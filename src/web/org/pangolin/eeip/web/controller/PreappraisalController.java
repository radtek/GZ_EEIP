package org.pangolin.eeip.web.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalDoc;
import org.pangolin.eeip.entity.Preappraisal;
import org.pangolin.eeip.entity.PreappraisalEntruster;
import org.pangolin.eeip.entity.PreappraisedEvid;
import org.pangolin.eeip.service.AppraisalDocService;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.CountyService;
import org.pangolin.eeip.service.PreappraisalAttService;
import org.pangolin.eeip.service.PreappraisalEntrusterService;
import org.pangolin.eeip.service.PreappraisalService;
import org.pangolin.eeip.service.PreappraisedEvidService;
import org.pangolin.eeip.util.GenerateWordUtil;
import org.pangolin.util.DateUtil;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PreappraisalController extends BaseController{
	
	@Resource
	private PreappraisalService preappraisalService;
	@Resource
	private PreappraisalAttService preappraisalAttService;
	@Resource
	private PreappraisalEntrusterService preappraisalEntrusterService;
	@Resource
	private PreappraisedEvidService preappraisedEvidService;
	@Resource
	private AppraisalDocService appraisalDocService;
	@Resource
	private AppraisalService appraisalService;
	@Resource
	private CountyService countyService;
	
	
	/***
	 * 保存电子物证（检材）预检信息表
	 * @param preappraisal 电子物证（检材）预检信息对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVID_MGT_PREAPPRAISAL_SAVEPREAPPRAISALDATA)
	@ResponseBody
	public Map<String, Object> savePreappraisal(@RequestBody Preappraisal preappraisal){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = preappraisalService.savePreappraisal(preappraisal);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID获取电子物证（检材）预检信息信息
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVID_MGT_PREAPPRAISAL_LOADPREAPPRAISALDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisalDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Preappraisal preappraisal = preappraisalService.getPreappraisalById(id);
			preappraisal = preappraisal == null ? new Preappraisal() : preappraisal;
			result.put("entity", preappraisal);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new Preappraisal());
		}
	
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID删除电子物证（检材）预检信息信息（伪删除）
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVID_MGT_PREAPPRAISAL_DELEPREAPPRAISALDATA)
	@ResponseBody
	public Map<String, Object> removePreappraisal(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = preappraisalService.removePreappraisal(id);
			status = preappraisalAttService.removePreappraisalAttByPreappraisalId(id);
			status = preappraisalEntrusterService.removePreappraisalEntruster(id);
			status = preappraisedEvidService.removePreappraisedEvid(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 电子物证（检材）预检信息信息列表数据源
	 * @return 电子物证（检材）预检信息数据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVID_MGT_PREAPPRAISAL_PREAPPRAISALGIRDDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisalList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String extraParam = params.getExtraParam("queryParam");
		String creatorId = params.getExtraParam("creatorId");
		List<Preappraisal> list = preappraisalService.getPreappraisals(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),extraParam,creatorId);
		long totalCount = preappraisalService.getPreappraisalQty(extraParam,creatorId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	
	/***
	 * 保存提取电子清单列表
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISAL_SAVEPREAPPRAISALWORD)
	@ResponseBody
	public Map<String,Object> saveExtractListWord(String preappraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Preappraisal preappraisal = preappraisalService.getPreappraisalById(preappraisalId);
			String templatePath = "";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Map<String,String> param = new HashMap<String, String>();
			List<PreappraisalEntruster> list = preappraisalEntrusterService.getPreappraisalEntrusterListByPreappraisalId(preappraisalId);
			if(list.size() <= 1){
				templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/preappraisal_v1.docx").toString();
				Integer Num = 1;
				for (PreappraisalEntruster preappraisalEntruster : list) {
					param.put("$ENTRUSTER_NAME"+Num+"$", checkNull(preappraisalEntruster.getUserAlias()));
					param.put("$ENTRUSTER_POST"+Num+"$", checkNull(preappraisalEntruster.getUserPost()));
					param.put("$POLICE_ID"+Num+"$", checkNull(preappraisalEntruster.getPoliceId()));
					Num++;
				}
			}else if(list.size() == 2){
				templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/preappraisal_v2.docx").toString();
				Integer Num = 1;
				for (PreappraisalEntruster preappraisalEntruster : list) {
					param.put("$ENTRUSTER_NAME"+Num+"$", checkNull(preappraisalEntruster.getUserAlias()));
					param.put("$ENTRUSTER_POST"+Num+"$", checkNull(preappraisalEntruster.getUserPost()));
					param.put("$POLICE_ID"+Num+"$", checkNull(preappraisalEntruster.getPoliceId()));
					Num++;
				}
			}else if(list.size() == 3){
				templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/preappraisal_v3.docx").toString();
				Integer Num = 1;
				for (PreappraisalEntruster preappraisalEntruster : list) {
					param.put("$ENTRUSTER_NAME"+Num+"$", checkNull(preappraisalEntruster.getUserAlias()));
					param.put("$ENTRUSTER_POST"+Num+"$", checkNull(preappraisalEntruster.getUserPost()));
					param.put("$POLICE_ID"+Num+"$", checkNull(preappraisalEntruster.getPoliceId()));
					Num++;
				}
			}else if(list.size() == 4){
				templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/preappraisal_v4.docx").toString();
				Integer Num = 1;
				for (PreappraisalEntruster preappraisalEntruster : list) {
					param.put("$ENTRUSTER_NAME"+Num+"$", checkNull(preappraisalEntruster.getUserAlias()));
					param.put("$ENTRUSTER_POST"+Num+"$", checkNull(preappraisalEntruster.getUserPost()));
					param.put("$POLICE_ID"+Num+"$", checkNull(preappraisalEntruster.getPoliceId()));
					Num++;
				}
			}else if(list.size() >= 5){
				templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/preappraisal_v5.docx").toString();
				Integer Num = 1;
				for (PreappraisalEntruster preappraisalEntruster : list) {
					param.put("$ENTRUSTER_NAME"+Num+"$", checkNull(preappraisalEntruster.getUserAlias()));
					param.put("$ENTRUSTER_POST"+Num+"$", checkNull(preappraisalEntruster.getUserPost()));
					param.put("$POLICE_ID"+Num+"$", checkNull(preappraisalEntruster.getPoliceId()));
					Num++;
				}
			}
			templatePath = templatePath.replace("file:/", "");
			File file = new File(templatePath);
			if (file.exists() && file.canRead()) {
				String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date()) + DateUtil.getMonth(new Date()) + DateUtil.getDay(new Date());
				saveDirectoryPath = saveDirectoryPath.replaceAll("//", "/");
		        File saveDirectory = new File(saveDirectoryPath); 
				if (!saveDirectory.exists()) {
					saveDirectory.mkdirs();
				}
				String outPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
				param.put("$ORG_NAME$",checkNull(preappraisal.getOrgName()));
				param.put("$ENTRUSTED_DATE$",checkNull(sdf.format(preappraisal.getEntrustedDate())));
				param.put("$ADDR$",checkNull(preappraisal.getAddr()));
				param.put("$ZIP_CODE$",checkNull(preappraisal.getZipCode()));
				param.put("$TEL$", checkNull(preappraisal.getTel()));
				param.put("$FAX$", checkNull(preappraisal.getFax()));
				param.put("$CASE_NAME$", checkNull(preappraisal.getCaseName()));
				param.put("$CASE_SN$", checkNull(preappraisal.getCaseSn()));
				param.put("$EXPLANATION$", checkNull(preappraisal.getExplanation()));
				String rqmt = "鉴定要求："+checkNull(preappraisal.getRqmt()) +" "+"@<br>@诚信声明：我单位向你实验室介绍的情况客观真实，提交的检材等来源清楚可靠。如有虚假，愿意承担全部法律责任。@<br>@负责人签字：                     （单位印章） ";
				
				param.put("$RQMT$",rqmt );
				param.put("$REMARKS$", checkNull(preappraisal.getRemarks()));
				
				List<Map<Integer, Object>> paramList = new ArrayList<Map<Integer,Object>>();
				List<PreappraisedEvid> preappraisedEvids = preappraisedEvidService.getPreappraisedEvids(preappraisalId);
				int Num = 1;
				for (PreappraisedEvid preappraisedEvid : preappraisedEvids) {
					Map<Integer,Object> map = new HashMap<Integer, Object>();
					map.put(0, Num);
					map.put(1, checkNull(preappraisedEvid.getName()));
					map.put(2, checkNull(String.valueOf(preappraisedEvid.getQty())));
					Integer status = preappraisedEvid.getStatus();
					if(status.intValue() == 0){
						map.put(3, "物证袋封装");
					}else if(status.intValue() == 1){
						map.put(3, "封条");
					}else if(status.intValue() == 2){
						map.put(3, "未封存");
					} 
					map.put(4, checkNull(preappraisedEvid.getDesc()));
					map.put(5, checkNull(preappraisedEvid.getRemarks()));
					Num++;
					paramList.add(map);
				}
				
				GenerateWordUtil.replaceAllWordAndWriteExcelInWord(templatePath, outPath, 1 , 1, paramList,param);  //替换列表
				
				
				
				List<Appraisal> appraisals = appraisalService.getAppraisalsByPreappraisedId(preappraisalId);
				if( appraisals.size() > 0){
					for (Appraisal app : appraisals) {
						saveAppraisalDoc(app.getId(),outPath,0,"鉴定委托书.doc");
					}
				}
			}
			result.put("entity", true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", false);
			return result;
		}
	}
	
	public Boolean saveAppraisalDoc(String appraisalId,String path,Integer type,String name){
		try {
	        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_NAME);
			AppraisalDoc appraisalDoc = new AppraisalDoc();
	    	appraisalDoc.setAppraisalId(appraisalId);
	    	appraisalDoc.setPath(path);
	    	appraisalDoc.setName(name);
	    	appraisalDoc.setExt(path.substring(path.lastIndexOf(".")+1));
	    	appraisalDoc.setType(type);
	    	appraisalDoc.setCreatedDate(new Date());
	    	appraisalDoc.setCreatorAlias(currentUser.getUserAlias());
	    	appraisalDoc.setCreatorName(currentUser.getUserName());
	    	appraisalDoc.setCreatorId(currentUser.getUserId());
	    	if(appraisalDocService.getAppraisalDocByTypeAndAppraisalId(Integer.valueOf(type),appraisalId) != null){
	    		appraisalDocService.removeAppraisalDocFalse(Integer.valueOf(type),appraisalId);
	    	}
	    	appraisalDocService.saveAppraisalDoc(appraisalDoc);
	    	return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String checkNull(String object){
		return object == null ? "" : object;
	}
	
	/***
	 *  获取分析图预检历史数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_HISTORY_PREAPPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getHistoryAnalysis(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> dateList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = preappraisalService.getHistoryYearAnalysis(null);
				 if(null != data.get("date") && data.get("date").size()>0){
					 List<String> date = data.get("date");
					 for (int i =0 ; i< date.size(); i++ ) {
						 dateList.add(date.get(i).toString().substring(0, 4)+"年");
					} 
				 } 
			result.put("number", data.get("number"));
			result.put("date", dateList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", null);
		}
		return result;
	} 
	
	/***
	 *  获取分析图预检历史年数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_YEAR_PREAPPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getYearAnalysis(String year){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> dateList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = preappraisalService.getHistoryYearAnalysis(year);
			 if(null != year && !"".equals(year)){
				 if(null != data.get("date") && data.get("date").size()>0){
					List<String> date = data.get("date");
					  for (int i =0 ; i< date.size(); i++ ) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							dateList.add(sdf.parse(date.get(i)).getMonth()+1+"月");
					   } 
				 }
			 }
			result.put("number", data.get("number"));
			result.put("date", dateList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", null);
		}
		return result;
	} 
	
	/***
	 *  获取分析图预检区域数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_COUNTRY_PREAPPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getYearAnalysis(String year,String month){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> nameList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = preappraisalService.getCountryAnalysis(year,month);
			 if(null != data.get("number") && data.get("number").size()>0){
					List<String> country = data.get("date");
					  for (int i =0 ; i< country.size(); i++ ) {
						  nameList.add(countyService.getCountyByCountyId(country.get(i)).getName());
					   } 
				 }
			result.put("number", data.get("number"));
			result.put("country", nameList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", null);
		}
		return result;
	} 
	
	/***
	 *  获取分析图预检区域数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_ACCEPTED_PREAPPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getAcceptedAnalysis(String year,String month){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String ,Object>> list =new ArrayList<Map<String,Object>>();
		try{
			 
			Map<String, Object> data =  appraisalService.getAcceptedAnalysis(year,month);
			Map<String, Object> ok = new HashMap<String, Object>();
			Map<String, Object> no = new HashMap<String, Object>();
			ok.put("name", "通过受理");
			ok.put("value", data.get("ok"));
			
			no.put("name", "未受理或受理失败");
			no.put("value", data.get("no"));
			
			list.add(ok);
			list.add(no);
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", null);
 		}
		return result;
	} 
	
	
	
}
