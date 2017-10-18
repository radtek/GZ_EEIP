package org.pangolin.eeip.web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dao.AppraisalSitnDao;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalAcptAtt;
import org.pangolin.eeip.entity.AppraisalDoc;
import org.pangolin.eeip.entity.AppraisalItem;
import org.pangolin.eeip.entity.AppraisalRevise;
import org.pangolin.eeip.entity.AppraisalReviseEntruster;
import org.pangolin.eeip.entity.AppraisalSitn;
import org.pangolin.eeip.entity.EvidOpLog;
import org.pangolin.eeip.entity.EvidOpLogAtt;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.entity.UserBasicInfo;
import org.pangolin.eeip.service.AppraisalAcptAttService;
import org.pangolin.eeip.service.AppraisalDocService;
import org.pangolin.eeip.service.AppraisalItemService;
import org.pangolin.eeip.service.AppraisalReviseEntrusterService;
import org.pangolin.eeip.service.AppraisalReviseService;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.AppraisalSitnService;
import org.pangolin.eeip.service.EvidOpLogAttService;
import org.pangolin.eeip.service.EvidOpLogService;
import org.pangolin.eeip.service.EvidenceService;
import org.pangolin.eeip.service.UserBasicInfoService;
import org.pangolin.eeip.util.GenerateWordUtil;
import org.pangolin.util.DateUtil;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppraisalReviseController extends BaseController{
	
	@Resource
	private AppraisalReviseService appraisalReviseService;
	
	@Resource
	private AppraisalDocService appraisalDocService;
	
	@Resource
    private AppraisalService appraisalService;
	
	@Resource
	private EvidenceService evidenceService;
	
	@Resource
	private EvidOpLogService evidOpLogService;
	
	@Resource
	private EvidOpLogAttService evidOpLogAttService;
	
	@Resource
	private AppraisalAcptAttService appraisalAcptAttService;
	
	@Resource
	private AppraisalItemService appraisalItemService;
	
	@Resource
	private UserBasicInfoService userBasicInfoService;
	
	@Resource
	private AppraisalReviseEntrusterService appraisalReviseEntrusterService;
	
	@Resource
	private AppraisalSitnService appraisalSitnService;
	
	/***
	 * 保存电子物证（检材）鉴定文书修订表
	 * @param appraisalRevise 电子物证（检材）鉴定文书修订对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISE_SAVEAPPRAISALREVISEDATA)
	@ResponseBody
	public Map<String, Object> saveAppraisalRevise(@RequestBody AppraisalRevise appraisalRevise){
		Map<String, Object> result = new HashMap<String, Object>();
		AppraisalItem item =  appraisalItemService.getAppraisalItemByReviseId(appraisalRevise.getId());
		boolean status = false;
		try{
			if(appraisalRevise.getStatus().intValue() == 1){
				appraisalRevise.setCreatedDate(new Date());
			}else if(appraisalRevise.getStatus().intValue() == 2){
				appraisalRevise.setAuthAuditedDate(new Date());
			}else if(appraisalRevise.getStatus().intValue() == 3){
				appraisalRevise.setTechAuditedDate(new Date());
			}else if(appraisalRevise.getStatus().intValue() == 4){
				appraisalRevise.setApprovedDate(new Date());
			} 
			if(appraisalRevise.getStatus().intValue() == 7&&appraisalRevise.getMethod() == 1){
				appraisalRevise.setApprovedDate(new Date());
			}
			
			status = appraisalReviseService.saveAppraisalRevise(appraisalRevise);
			if(status){
				if(appraisalRevise.getMethod().intValue() == AppraisalRevise.WITHDRAW.intValue() &&appraisalRevise.getStatus().intValue()  == 7){
					//重新走流程
					status = generateUpdateApprovalForm(appraisalRevise);
					status = saveNewAppraisal(appraisalRevise,item);
				}else if(appraisalRevise.getStatus().intValue() == 4){
					//生成修改文书审批
					status = generateUpdateApprovalForm(appraisalRevise);
				}
				 
				
				//删除修改文书审批表
				if(appraisalRevise.getStatus().intValue() == 8){
					status = appraisalDocService.removeAppraisalDocFalse(11, appraisalRevise.getAppraisalId());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	private boolean generateUpdateApprovalForm(AppraisalRevise appraisalRevise) {
		boolean status = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(appraisalRevise != null){
			try {
			Appraisal appraisal = appraisalService.getAppraisalById(appraisalRevise.getAppraisalId());
			List<AppraisalReviseEntruster> reviseEntrusterList = appraisalReviseEntrusterService.getAppraisalReviseEntrusters(appraisalRevise.getId());
			String entrusterName = "";
			if(reviseEntrusterList.size() > 0){
				entrusterName = reviseEntrusterList.get(0).getUserAlias();
			}
			CurrentUser curr = getCurrentUser();
			String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+""+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
			File saveDirectory = new File(saveDirectoryPath); 
			if (!saveDirectory.exists()) {
				saveDirectory.mkdirs();
			} 
			
			int[] code = { 0x2610, 0x2611, 0x2612 };
			//生成审批表	
			String revisePath = request.getSession().getServletContext().getRealPath("/");
			revisePath +="/WEB-INF/classes/templates/appraisal_revise_approval.doc";
			Map<String, Object> reviseParam = new HashMap<String, Object>();
			reviseParam.put("$ORG_NAME$",checkNull(appraisalRevise.getOrgName()).toString());
			reviseParam.put("$AGENCY$", checkNull(appraisal.getAgency()).toString());
			reviseParam.put("$YEAR$", checkNull(appraisal.getYear()).toString());
			reviseParam.put("$SN$", checkNull(appraisal.getSn()).toString());
			reviseParam.put("$ENTRUSTER_NAMES$", checkNull(entrusterName).toString());
			reviseParam.put("$APP_DATE$", checkNull(sdf.format( appraisalRevise.getCreatedDate())).toString());
			reviseParam.put("$MODIFIER$", checkNull(appraisalRevise.getModifierAlias()).toString());
			reviseParam.put("$MODIFIED_DATE$", checkNull(sdf.format( appraisalRevise.getRevisedDate())).toString());
			reviseParam.put("$REVISED_CONTENT$", checkNull(appraisalRevise.getRevisedContent()).toString());
			
			Integer method = appraisalRevise.getMethod();
			if(method.intValue() == 0){
				reviseParam.put("$METHOD_0$", new String(code, 1, 1));//修改方式
				reviseParam.put("$METHOD_1$", new String(code, 0, 1));//修改方式
			}else if(method.intValue() == 1){
				reviseParam.put("$METHOD_0$", new String(code, 0, 1));//修改方式
				reviseParam.put("$METHOD_1$", new String(code, 1, 1));//修改方式
			}
			
			reviseParam.put("$AUTH_AUDITOR_OPINION$", checkNull(appraisalRevise.getAuthAuditorOpinion()).toString());
			reviseParam.put("$AUTH_AUDITOR_NAME$", checkNull(appraisalRevise.getAuthAuditorAlias()).toString());
			reviseParam.put("$AUTH_AUDITED_DATE$", checkNull(sdf.format( appraisalRevise.getAuthAuditedDate())).toString());
			reviseParam.put("$TECH_AUDITOR_OPINION$",  checkNull(appraisalRevise.getTechAuditorOpinion()).toString());
			reviseParam.put("$TECH_AUDITOR_NAME$",  checkNull(appraisalRevise.getTechAuditorAlias()).toString());
			reviseParam.put("$TECH_AUDITED_DATE$", checkNull(sdf.format(appraisalRevise.getTechAuditedDate())).toString());
			reviseParam.put("$APPROVER_OPINION$",  checkNull(appraisalRevise.getApproverOpinion()).toString());
			reviseParam.put("$APPROVER_NAME$",  checkNull(appraisalRevise.getApproverAlias()).toString());
			reviseParam.put("$APPROVED_DATE$", checkNull(sdf.format( appraisalRevise.getApprovedDate())).toString());
			
			String reviseOutPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
			status = GenerateWordUtil.replaceWord(revisePath, reviseOutPath, reviseParam);
			
			AppraisalDoc reviselDoc = new AppraisalDoc(); 
			reviselDoc.setName("鉴定文书修改审批表.doc");
			reviselDoc.setAppraisalId(appraisal.getId());
			reviselDoc.setCreatorAlias(curr.getUserAlias());
			reviselDoc.setCreatorId(curr.getUserId());
			reviselDoc.setCreatorName(curr.getUserName());
			reviselDoc.setExt("doc");
			reviselDoc.setPath(reviseOutPath);
			reviselDoc.setType(AppraisalDoc.INSTRUMENT_MODIFY_APPROVAL);
			status = appraisalDocService.saveAppraisalDoc(reviselDoc);
			} catch (Exception e) {
 				e.printStackTrace();
 				return status;
			}
		
		}
		return status;
	}
	/***
	 * 根据电子物证（检材）鉴定文书修订ID
	 * @param id 电子物证（检材）鉴定文书修订ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISE_LOADAPPRAISALREVISEDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			AppraisalRevise appraisalRevise = appraisalReviseService.getAppraisalReviseById(id);
			appraisalRevise = appraisalRevise == null ? new AppraisalRevise() : appraisalRevise;
			result.put("entity", appraisalRevise);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisalRevise());
		}
		return result;
	}
	
	/***
	 * 根据电子物证（检材）鉴定文书修订ID
	 * @param id 电子物证（检材）鉴定文书修订ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISE_LOADAPPRAISALREVISEBYAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseByAppraisalId(String appraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			AppraisalRevise appraisalRevise = appraisalReviseService.getAppraisalReviseByAppraisalId(appraisalId);
			appraisalRevise = appraisalRevise == null ? new AppraisalRevise() : appraisalRevise;
			result.put("entity", appraisalRevise);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisalRevise());
		}
		return result;
	}

	
	/***
	 * 电子物证（检材）鉴定文书修订信息列表数据源
	 * @return 电子物证（检材）鉴定文书修订数据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISE_APPRAISALREVISEGIRDDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String userId = params.getExtraParam("userId");
		List<AppraisalRevise> list = appraisalReviseService.getAppraisalRevises(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),userId);
		long totalCount = appraisalReviseService.getAppraisalReviseQty(userId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 电子物证（检材）鉴定文书修订信息列表数据源(首页)
	 * @return 电子物证（检材）鉴定文书修订数据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISE_INDEX_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseIndex(String userId){
		Map<String, Object> result = new HashMap<String, Object>();
		List<AppraisalRevise> list = appraisalReviseService.getAppraisalRevises(userId);
		result.put("entity", list);
		return result; 
	}
	
	/***
	 * 文书修改列表数据源（首页）
	 * @return 检材鉴定数据据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISE_AUDIT_INDEX_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseAuditIndex(String status){
		Map<String, Object> result = new HashMap<String, Object>();
		List<AppraisalRevise> list = new ArrayList<AppraisalRevise>();
		list = appraisalReviseService.getAppraisalRevises(Integer.parseInt(status) ,0,Integer.MAX_VALUE, "createdDate", "desc");
		result.put("entity", list);
		return result; 
	}

	/***
	 * 文书修改列表数据源
	 * @return 检材鉴定数据据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVID_MGT_APPRAISAL_REVISE_LOAD_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseListData(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		CurrentUser curr = getCurrentUser();
		List<AppraisalRevise> list = new ArrayList<AppraisalRevise>();
		long totalCount = 0L;
 		String query = params.getExtraParam("query");
 		Integer status = -1;
 		Map<String, String> roles = curr.getRoles();
 		boolean auth = containsKeyRoles(roles,"ROLE_AUTH_OFFICER");// 一审
 		boolean tech = containsKeyRoles(roles,"ROLE_TECH_DIRECTOR");// 二审
 		boolean approver = containsKeyRoles(roles,"ROLE_LAB_DIRECTOR");// 二审
 		if(auth){
 			//初审
 			status = 1;
 			if(null!=query&&!"".equals(query)){
				list.addAll( appraisalReviseService.getAppraisalRevises(query,status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(query,status).intValue();
			}else{
				list.addAll( appraisalReviseService.getAppraisalRevises(status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(status).intValue();
			} 
 		}
 		
 		if(tech){
 			//二审
 			status = 2;
 			if(null!=query&&!"".equals(query)){
 				list.addAll( appraisalReviseService.getAppraisalRevises(query,status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(query,status).intValue();;
			}else{
				list.addAll(  appraisalReviseService.getAppraisalRevises(status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(status).intValue();;
			} 
 		}
 		
 		if(approver){
 			//审批
 			status = 3;
 			if(null!=query&&!"".equals(query)){
 				list.addAll( appraisalReviseService.getAppraisalRevises(query,status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(query,status).intValue();;
			}else{
				list.addAll( appraisalReviseService.getAppraisalRevises(status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(status).intValue();;
			} 
 			
 			status = 6;
 			
 			if(null!=query&&!"".equals(query)){
 				list.addAll( appraisalReviseService.getAppraisalRevises(query,status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(query,status).intValue();;
			}else{
				list.addAll( appraisalReviseService.getAppraisalRevises(status,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalReviseService.getAppraisalReviseQty(status).intValue();;
			} 
 			
 		} 
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 更正文书版本
	 * @param appraisalRevise 电子物证（检材）鉴定文书修订对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_APPRAISALREVISE_UPDATE_VERSION)
	@ResponseBody
	public Map<String, Object> updateDoc(@RequestBody AppraisalRevise appraisalRevise){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			if(appraisalRevise!=null){
			   status=	appraisalDocService.updateVersion(appraisalRevise.getAppraisalId(),appraisalRevise.getId());
			}  
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	//判断权限
	public boolean containsKeyRoles(Map<String,String> roles,String role){
		boolean result=false;
	   if(roles.containsKey(role)){
		   result = true;
	   } 
		return result;
	}; 
	
	public boolean saveNewAppraisal(AppraisalRevise appraisalRevise,AppraisalItem item ){
		boolean status = false;
        String appraisalId = appraisalRevise.getAppraisalId();
       
        //新增流程信息
		Appraisal appraisal = appraisalService.getAppraisalById(appraisalId);
		appraisal.setDelFlag(Appraisal.REMOVED);
		status = appraisalService.saveAppraisal(appraisal);
		// 鉴定人ID
		String userId = appraisal.getAppraiserId();
		Appraisal.cleanAppraisalParam(appraisal);
		appraisal.setId(null);
		appraisal.setScope(item.getScope());
		appraisal.setMethod(item.getMethod());
		appraisal.setMethodOther(item.getMethodOther());
		appraisal.setRqmt(item.getRqmt());
		appraisal.setRqmtOther(item.getRqmtOther());
		status = appraisalService.saveAppraisal(appraisal);
		
		/*appraisalRevise.setAppraisalId(appraisal.getId());
		status = generateUpdateApprovalForm(appraisalRevise);
		appraisalRevise.setAppraisalId(appraisalId);*/
		//在库信息新增
		Evidence evidence = evidenceService.getEvidenceByAppraisalId(appraisalId);
		String evidenceId = evidence.getId();
		evidence.setId(UUIDHexGenerator.getInstance().generate());
		evidence.setStatus(Evidence.INSIDE);
		evidence.setAppraisalId(appraisal.getId());
		status = evidenceService.saveEvidence(evidence);
 		//入库日志
		
		EvidOpLog evidOpLog = evidOpLogService.getEvidOpLogByEvidIdAndSpLabel(evidenceId, EvidOpLog.SP_IMPT);
		String logId = evidOpLog.getId();
		evidOpLog.setId(UUIDHexGenerator.getInstance().generate());
		evidOpLog.setEvidId(evidence.getId());
		evidOpLog.setSpLabel(EvidOpLog.SP_IMPT);
		status = evidOpLogService.saveEvidOpLog(evidOpLog); 
		 
		//在库附件
        List<EvidOpLogAtt> evidAttList = evidOpLogAttService.getEvidOpLogAttByEvidOpLogId(logId);
        if(evidAttList.size() > 0){
        	for (EvidOpLogAtt att : evidAttList) {
        		att.setEvidId(evidence.getId());
        		att.setEvidOpLogId(evidOpLog.getId());
        		att.setEvidOpLogId(evidOpLog.getId());
        		att.setAppraisalId(appraisal.getId());
        		status = evidOpLogAttService.saveEvidOpLogAtt(att);
			}
        }
        
		//鉴定文书 复制
        List<AppraisalDoc> docList = appraisalDocService.getAppraisalDocs(appraisalId);
        if(docList.size() > 0){
        	for (AppraisalDoc doc : docList) {
        		if(doc.getType().intValue() == 0 || doc.getType().intValue() == 1 || doc.getType().intValue() == 2 || doc.getType().intValue() == 3 ||doc.getType().intValue() == 6||doc.getType().intValue() == 11 ){
	        		doc.setAppraisalId(appraisal.getId());
	        		doc.setAppraisalReviseId(appraisalRevise.getId());
	        		status = appraisalDocService.saveAppraisalDoc(doc); 
        		}
			}
        }
        
		//受理附件
		List<AppraisalAcptAtt> appAttList = appraisalAcptAttService.getAppraisalAcptAttsByAppraisalId(appraisalId);
		if(appAttList.size() > 0){
        	for (AppraisalAcptAtt att : appAttList) {
        		att.setAppraisalId(appraisal.getId()); 
        		status = appraisalAcptAttService.saveAppraisalAcptAtt(att); 
			}
        } 
		//TODO
		//清空鉴定人员
		AppraisalSitn sitn =appraisalSitnService.getAppraisalSitnByAppraisalId(appraisalId);
		if(sitn != null){
			status = appraisalSitnService.removeAppraisalSitn(sitn.getId());
		}
		/*
		UserBasicInfo user = userBasicInfoService.getUserBasicInfoByUserId(userId);
		if(user != null){
			user.setAppraisalFlag(UserBasicInfo.NOT_ASSIGNED);
			userBasicInfoService.saveUserBasicInfo(user);
		}*/
		return status;
	}
	
	public String checkNull(String object){
		return object == null ? "" : object;
	}
	
}
