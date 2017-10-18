package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalHistory;
import org.pangolin.eeip.entity.AppraisalRevise;
import org.pangolin.eeip.entity.AppraisalSitn;
import org.pangolin.eeip.entity.EvidTransition;
import org.pangolin.eeip.entity.UserBasicInfo;
import org.pangolin.eeip.service.AppraisalDocService;
import org.pangolin.eeip.service.AppraisalHistoryService;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.AppraisalSitnService;
import org.pangolin.eeip.service.AppraisedDevService;
import org.pangolin.eeip.service.EvidTransitionService;
import org.pangolin.eeip.service.UserBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 电子物证交接Controller
 * @author 
 *
 */
@Controller
@SuppressWarnings("all")
public class EvidTransitionController extends BaseController{
	 
	
	@Autowired
	private EvidTransitionService evidTransitionService;
		
	@Autowired
	private AppraisalService appraisalService;
	
	@Autowired
	private  AppraisalHistoryService appraisalHistory;
	
	@Autowired
	private AppraisalHistoryService appraisalHistoryService;
	
	@Autowired
	private AppraisedDevService appraisedDevService;
	
	@Autowired
	private AppraisalDocService appraisalDocService;
	
	@Autowired
	private UserBasicInfoService userBasicInfoService;
	
	@Autowired
	private AppraisalSitnService appraisalSitnService;
	
	/***
	 * 电子物证交接列表
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDTRANSITION_LOAD_LIST_DATA)
	@ResponseBody
	public Map<String,Object> getEvidTransitionLists(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest()); 
        Long total =  0L;
        List<EvidTransition> list = new ArrayList<EvidTransition>();
		try{
			if(params != null){
				String query = params.getExtraParam("query").trim();
				if(query != null && !"".equals(query)){
					list = evidTransitionService.getEvidTransitions(0,query, params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
					total = evidTransitionService.count(query);
				}else{
					list = evidTransitionService.getEvidTransitions(0,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
					total = evidTransitionService.getEvidTransitionQty(0);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return BootstrapDataGridUtil.getResultMap(params, total, list);
	}
	
	/***
	 * 电子物证交接列表(首页)
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDTRANSITION_INDEX_LIST_DATA)
	@ResponseBody
	public Map<String,Object> getEvidTransitionIndexLists(){
		Map<String, Object> result = new HashMap<String, Object>();
        List<EvidTransition> list = new ArrayList<EvidTransition>();
		try{
		 list = evidTransitionService.getEvidTransitions(0,0,Integer.MAX_VALUE, "applicantDate", "desc");
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("entity", list);
		return result;
	}
	
	/***
	 * 电子物证交接检材流转记录列表
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EVIDTRANSITION_EVIDTRANSITIONGIRDDATA)
	@ResponseBody
	public Map<String,Object> getEvidTransitionGirdData(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest()); 
		List<EvidTransition> list = null;
		long total = 0L;
		try{
			String appraisalId = params.getExtraParam("appraisalId");
			list = evidTransitionService.getEvidTransitionGirdData(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),appraisalId);
			total = evidTransitionService.getEvidTransitionQty(appraisalId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return BootstrapDataGridUtil.getResultMap(params, total, list);
	}
	
	
	/***
	 * 根据电子物证（检材）鉴定文书修订ID删
	 * @param id 电子物证（检材）鉴定文书修订ID
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDTRANSITION_LOAD_DATA_BY_APPRAISALID)
	@ResponseBody
	public Map<String, Object> getEvidTransitionByAppraisalId(String appraisalId,Integer status){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			EvidTransition evidTransition = evidTransitionService.getEvidTransitionByAppraisalId(appraisalId,status);
			if(evidTransition != null ){
				result.put("entity", true);
			}else{
				result.put("entity", false);
			}
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisalRevise());
		}
		return result;
	}
	
	/***
	 *  更新电子物证交接表
	 * @param produceStock
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDTRANSITION_SAVE_DATA)
	@ResponseBody
	public Map<String,Object> saveEvidTransition(@RequestBody EvidTransition evidTransition){
		Map<String,Object> map = new HashMap<String,Object>();
		CurrentUser curr = getCurrentUser();
		boolean status = false;
		try{ 
			status = evidTransitionService.saveOrUpdate(evidTransition);
			if(status){
				Appraisal appraisal = appraisalService.getAppraisalById(evidTransition.getAppraisalId());
				if(appraisal.getStatus().intValue() == Appraisal.PAUSE.intValue()){
				 	
					AppraisalHistory appraisalHistory =new AppraisalHistory();
					appraisalHistory.setReturnTransitionId(evidTransition.getId());
					appraisalHistory.setCollTransitionId(appraisal.getCollTransitionId());
					appraisalHistory.setEvidId(appraisal.getEvidId());
					appraisalHistory.setPreappraisalId(appraisal.getPreappraisalId());
					
					//组装原始记录对象
					 appraisalHistory = appraisalHistoryService.saveAppraisalToHistory(appraisalHistory,appraisal.getId());
					
					//把电子物证（检材）鉴定设备 全部根据appraisalId未删除然后添加appraisalHistory的id
					appraisedDevService.saveAppraisedDevByHistory(appraisalHistory.getId(),appraisal.getId());
					
					//鉴定文书资料 暂停过程中需要进行伪删除的文档编号有 4、5、6、7、8
					appraisalDocService.removeAppraisalDocByHistory(appraisalHistory.getId(),appraisal.getId());
					
					//复制原始记录
					status = appraisalHistoryService.saveAppraisalHistory(appraisalHistory);
					
					//TODO
					//空出鉴定专家
					AppraisalSitn sitn =appraisalSitnService.getAppraisalSitnByAppraisalId(appraisal.getId());
					if(sitn != null){
						status = appraisalSitnService.removeAppraisalSitn(sitn.getId());
					}
					/*UserBasicInfo basicInfo = userBasicInfoService.getUserBasicInfoByUserId(appraisal.getAppraiserId());
					basicInfo.setAppraisalFlag(UserBasicInfo.NOT_ASSIGNED);
					status = userBasicInfoService.saveUserBasicInfo(basicInfo);*/
					
					if(status){
						if(appraisal != null){
							//暂停重新回到分配阶段 清空数据
							appraisal = appraisal.cleanAppraisalParam(appraisal);
							appraisalService.saveAppraisal(appraisal);
						}else{
							status = false;
						}
					}
				}else if(appraisal.getStatus().intValue() == Appraisal.FINISH.intValue()){
					//中止
					//TODO
					//空出鉴定专家
					
					AppraisalSitn sitn =appraisalSitnService.getAppraisalSitnByAppraisalId(appraisal.getId());
					if(sitn != null){
						status = appraisalSitnService.removeAppraisalSitn(sitn.getId());
					}
 					/*UserBasicInfo basicInfo = userBasicInfoService.getUserBasicInfoByUserId(appraisal.getAppraiserId());
					basicInfo.setAppraisalFlag(UserBasicInfo.NOT_ASSIGNED);
					status = userBasicInfoService.saveUserBasicInfo(basicInfo);*/
					/*//回归结果管理m
					appraisal.setStatus(Appraisal.RESULT_FEEDBACK);
					appraisalService.saveAppraisal(appraisal);*/
					
				}else{
					if(appraisal.getStatus().intValue() == Appraisal.LED_BY.intValue()){
						appraisal.setCollTransitionId(evidTransition.getId());
						appraisal.setStatus(Appraisal.DEV_APPLY);
					}else if(appraisal.getStatus().intValue() == Appraisal.CHECK_MATERIAL_RETURNED.intValue()){
						appraisal.setReturnTransitionId(evidTransition.getId());
						appraisal.setStatus(Appraisal.ARRANGEMENT_DOCUMENTS);
					}
					status = appraisalService.saveAppraisal(appraisal);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("status", status);
		return map;
	}
	
	/***
	 * 加载 物证交接记录
	 * @param id ID
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDTRANSITION_LOAD_DATA_BY_ID)
	@ResponseBody
	public Map<String,Object> getEvidTransitionById(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			EvidTransition evidTransition = null;
			if(id != null && !"".equals(id.trim())){
				evidTransition = evidTransitionService.getEvidTransitionById(id);
			}
			evidTransition = evidTransition == null ? new EvidTransition() : evidTransition;
			map.put("entity", evidTransition);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return map;
	}
	
	/***
	 * 加载 物证交接记录
	 * @param preappraisalId 电子物证预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDTRANSITION_LOAD_DATA_BY_PREAPPRAISALID)
	@ResponseBody
	public Map<String,Object> getEvidTransitionByPerId(String preappraisalId){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			EvidTransition evidTransition = evidTransitionService.getEvidTransitionByPreappraisalId(preappraisalId);
			evidTransition = evidTransition == null ? new EvidTransition() : evidTransition;
			map.put("entity", evidTransition);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	/***
	 * 取消所有未完成交接申请
	 * @param appraisalId 电子物证预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EVIDTRANSITION_CANCELDATABYAPPRAISALID)
	@ResponseBody
	public Map<String,Object> changeCancelDataByAppraisalId(String appraisalId){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			boolean status = evidTransitionService.changeCancelDataByAppraisalId(appraisalId);
			map.put("status", status);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
}
