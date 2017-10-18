package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.CameraDto;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalDoc;
import org.pangolin.eeip.entity.AppraisedDev;
import org.pangolin.eeip.entity.ArchiveCode;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.entity.DismissalNotice;
import org.pangolin.eeip.entity.EvidOpLog;
import org.pangolin.eeip.entity.EvidOpLogAtt;
import org.pangolin.eeip.entity.EvidTransition;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.entity.ExtractedData;
import org.pangolin.eeip.entity.ExtractedDataItem;
import org.pangolin.eeip.entity.Preappraisal;
import org.pangolin.eeip.entity.PreappraisalAtt;
import org.pangolin.eeip.entity.PreappraisalEntruster;
import org.pangolin.eeip.entity.PreappraisedEvid;
import org.pangolin.eeip.entity.TerminationNotice;
import org.pangolin.eeip.poi.CustomXWPFDocument;
import org.pangolin.eeip.service.AppraisalDocService;
import org.pangolin.eeip.service.AppraisalReviseService;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.AppraisedDevService;
import org.pangolin.eeip.service.ArchiveCodeService;
import org.pangolin.eeip.service.CityService;
import org.pangolin.eeip.service.CountyService;
import org.pangolin.eeip.service.DeviceService;
import org.pangolin.eeip.service.DismissalNoticeService;
import org.pangolin.eeip.service.EvidOpLogAttService;
import org.pangolin.eeip.service.EvidOpLogService;
import org.pangolin.eeip.service.EvidTransitionService;
import org.pangolin.eeip.service.EvidenceService;
import org.pangolin.eeip.service.ExtractedDataItemService;
import org.pangolin.eeip.service.PreappraisalAttService;
import org.pangolin.eeip.service.PreappraisalEntrusterService;
import org.pangolin.eeip.service.PreappraisalService;
import org.pangolin.eeip.service.PreappraisedEvidService;
import org.pangolin.eeip.service.ProvinceService;
import org.pangolin.eeip.service.TerminationNoticeService;
import org.pangolin.eeip.sms.MessageSender;
import org.pangolin.eeip.util.CameraDataLoader;
import org.pangolin.eeip.util.GenerateWordUtil;
import org.pangolin.util.DateUtil;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 

@Controller
public class AppraisalController extends BaseController{

	private static Map<String,String> videoMap = new HashMap<String, String>();
	
	@Resource
	private AppraisalService appraisalService;
	
	@Resource
	private AppraisalReviseService appraisalReviseService;
	
	@Resource
	private DismissalNoticeService dismissalNoticeService;
	
	@Resource
	private AppraisalDocService appraisalDocService;
	
	@Resource
	private PreappraisalEntrusterService preappraisalEntrusterService;
	
	@Resource
	private PreappraisalService preappraisalService;
	
	@Resource
	private AppraisedDevService appraisedDevService;
	
	@Resource
	private DeviceService deviceService;
	
	@Resource
	private TerminationNoticeService terminationNoticeService;
	
	@Resource
	private ExtractedDataItemService extractedDataItemService;
	
	@Autowired
	private EvidTransitionService evidTransitionService;
	
	@Resource
	private PreappraisalAttService preappraisalAttService; 
	
	@Resource
	private PreappraisedEvidService preappraisedEvidService;
	
	@Resource
	private EvidOpLogService evidOpLogService;
	  
	@Resource
	private EvidOpLogAttService evidOpLogAttService;
	
	@Resource
	private EvidenceService evidenceService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private CountyService countyService;

	@Resource
	private ArchiveCodeService archiveCodeService;
	
	
	/***
	 * 保存电子物证（检材）鉴定申请表
	 * @param appraisal 电子物证（检材）鉴定申请对象
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_APPRAISAL_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAppraisal(@RequestBody Appraisal appraisal){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{  
			status = appraisalService.saveAppraisal(appraisal);
			String videoPath = appraisal.getVideoPath();
			if(videoPath != null && !"".equals(videoPath)){
				videoMap.put(appraisal.getId(), videoPath);
			}
			
			 if(status&&appraisal.getStatus().intValue() == Appraisal.WILL_STORAGE.intValue()){
				//生成文书
				status = generateInstruments(appraisal); 
			}else if(status&&appraisal.getStatus().intValue() == Appraisal.AUDIT_FAILE.intValue()){
				//不受理鉴定委托告知书 Do not accept the commission
				status = notAcceptInstruments(appraisal); 
			}else if(status&&appraisal.getStatus().intValue() == Appraisal.AUTHENTICATE.intValue()){
			//生成勘验检查照片记录表	
				status = generateImageForm(appraisal);
			}else if(status&&appraisal.getStatus().intValue() == Appraisal.RESULT_FEEDBACK.intValue()){
				//生成审批表	
				status = generateApprovalForm(appraisal);
			}else if(status&&appraisal.getStatus().intValue() == Appraisal.FINISH.intValue()){
				//生成检材流转记录
				status = generateCirculationRecord(appraisal);
			}
			
			//实例化检材鉴定流程
			initProcessInstance(appraisal);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	private boolean generateCirculationRecord(Appraisal appraisal) {
		boolean status = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		CurrentUser curr =getCurrentUser();
		if(appraisal != null && curr != null){
		try {
			Evidence evidence = evidenceService.getEvidenceByAppraisalId(appraisal.getId());
			List<EvidTransition> paramList =  evidTransitionService.getEvidTransitionsAll(appraisal.getId());
			String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
			File saveDirectory = new File(saveDirectoryPath); 
			if (!saveDirectory.exists()) {
				saveDirectory.mkdirs();
			} 
			//生成勘验检查照片记录表
			String circulationPath = request.getSession().getServletContext().getRealPath("/");
			circulationPath +="/WEB-INF/classes/templates/evid_circulation_record.docx";
			FileInputStream fileInputStream = new FileInputStream(circulationPath);
	 		CustomXWPFDocument document; 
			document = new CustomXWPFDocument(fileInputStream);
			List<XWPFTable> tables = document.getTables();
	 		XWPFTable table = tables.get(0);
	 		table.getRow(0).getCell(1).setText(checkNull(evidence.getName()).toString()); 
	 		table.getRow(0).getCell(3).setText(checkNull(evidence.getSn()).toString()); 
	 		table.getRow(1).getCell(1).setText(checkNull(evidence.getCreatorAlias()).toString() ); 
	 		table.getRow(2).getCell(1).setText(checkNull(sdf.format(evidence.getCreatedDate())).toString()); 
	 		table.getRow(3).getCell(1).setText(checkNull(evidence.getLocation()).toString()); 
	 		
	 		//表格
	 		if (paramList.size() > 0) {
				for (int i = 0; i < paramList.size(); i++) {
					table.createRow(0);
					XWPFTableRow row = table.getRow(5 + i + 1);
					row.getCell(0).setText( checkNull(sdf.format(paramList.get(i).getCreatedDate())).toString());
					row.getCell(1).setText(checkNull(paramList.get(i).getApplicantAlias()).toString());
					row.getCell(2).setText(checkNull(paramList.get(i).getOperatorAlias()).toString());
					if(paramList.get(i).getType() == 0){
						row.getCell(3).setText("检验");
					}else if(paramList.get(i).getType() == 1){
						row.getCell(3).setText("归还");
					}
					
				}
			}
	 		
	 		fileInputStream.close();
	 		String circulationOutPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
			// 写到目标文件
			OutputStream output = new FileOutputStream(circulationOutPath);
			document.write(output);
			output.close();
			
			AppraisalDoc circulationDoc = new AppraisalDoc(); 
			circulationDoc.setName("检材流转记录表.doc");
			circulationDoc.setAppraisalId(appraisal.getId());
			circulationDoc.setCreatorAlias(curr.getUserAlias());
			circulationDoc.setCreatorId(curr.getUserId());
			circulationDoc.setCreatorName(curr.getUserName());
			circulationDoc.setExt("docx");
			circulationDoc.setPath(circulationOutPath);
			circulationDoc.setType(AppraisalDoc.EVID_CIRCULATION_RECORD);
			status = appraisalDocService.saveAppraisalDoc(circulationDoc); 
			
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} 
 		return status;
	}



	/***
	 * 根据鉴定人员信息返回 appraisal
	 * @param userAlias 鉴定人员姓名
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_LOADDATABYUSERALIAS)
	@ResponseBody
	public Map<String, Object> getAppraisalByUserAlias(String userId) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Appraisal appraisal = null;
			if(userId != null && !"".equals(userId)){
				appraisal = appraisalService.getAppraisalByUserId(userId);
			}
			appraisal = appraisal == null ? new Appraisal() : appraisal;
			result.put("entity", appraisal);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new Appraisal());
		}
		return result;
	}
	
	/***
	 * 根据ID查询  电子物证（检材）鉴定 
	 * @param id 电子物证（检材）鉴定 ID
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_LOAD_APPRAISAL_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> getAppraisalDataById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Appraisal appraisal = appraisalService.getAppraisalById(id);
			appraisal = appraisal == null ? new Appraisal() : appraisal;
			result.put("entity", appraisal);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new Appraisal());
		}
		return result;
	}
 
	
	/***
	 * 检材鉴定列表数据源
	 * @return 检材鉴定数据据集JSON
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_APPRAISAL_LOAD_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalListData(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<Appraisal> list = new ArrayList<Appraisal>();
		long totalCount = 0L;
		String status = params.getExtraParam("status");
		String query = params.getExtraParam("query");
		if(null!=status&&!"".equals(status)){
			if(null!=query&&!"".equals(query)){
				list = appraisalService.getAppraisals(query,query,Integer.parseInt(status),params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQty(query,query,Integer.parseInt(status));
			}else{
				list = appraisalService.getAppraisals(Integer.parseInt(status),params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQty(Integer.parseInt(status));
			}
		}else{
			list = appraisalService.getAppraisals(null,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
			totalCount = appraisalService.getAppraisalQty(null);
		}
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 获取结果状态下的全部检材
	 * @return 检材鉴定数据据集JSON
	 */						 
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISED_GETAPPRAISEDDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String userId = params.getExtraParam("userId");
		List<Appraisal> list = appraisalService.getFinishAppraisals(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),userId);
		long totalCount = appraisalService.getFinishAppraisalQty(userId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 在库检材数据源
	 * @return 检材鉴定数据据集JSON
	 */						 
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_APPRAISALGIRDDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalDataList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String extraParam = params.getExtraParam("queryParam");
		List<Appraisal> list = appraisalService.getAppraisalInStockList(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),extraParam);
		long totalCount = appraisalService.getAppraisalInStock(extraParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 检材交接数据源
	 * @return 检材鉴定数据据集JSON
	 */						 
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_APPRAISALCONNECTLIST)
	@ResponseBody
	public Map<String, Object> getAppraisalConnectList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String extraParam = params.getExtraParam("queryParam");
		List<Appraisal> list = appraisalService.getAppraisalConnectLists(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),extraParam);
		long totalCount = appraisalService.getAppraisalConnectQtys(extraParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	
	}
	
	/***
	 * 检材出库数据源
	 * @return 检材鉴定数据据集JSON
	 */						 
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_APPRAISALOUTPUTLIST)
	@ResponseBody
	public Map<String, Object> getAppraisalOutputList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String extraParam = params.getExtraParam("queryParam");
		List<Appraisal> list = appraisalService.getAppraisalOutputList(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),extraParam);
		long totalCount = appraisalService.getAppraisalOutputQty(extraParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 检材鉴定列表数据源（文书审批）根据当前用户角色划分 （授权签字人，实验室负责人）
	 * @return 检材鉴定数据据集JSON
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_APPRAISAL_LOAD_LIST_BY_ROLE_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalListByRoleData(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		CurrentUser curr = getCurrentUser();
		Map<String,String> roles = curr.getRoles();
		List<Appraisal> list = new ArrayList<Appraisal>();
		long totalCount = 0L;
		String status = "-1";
		String query = params.getExtraParam("query");
		if(roles.containsKey("ROLE_AUTH_OFFICER")){
			if(null!=query&&!"".equals(query)){
				list.addAll( appraisalService.getAppraisals(query,query,Appraisal.ARRANGEMENT_REVIEW,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalService.getAppraisalQty(query,query,Integer.parseInt(status));
			}else{
				list = appraisalService.getAppraisals(Appraisal.ARRANGEMENT_REVIEW,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQty(Integer.parseInt(status));
			} 
		}else if(roles.containsKey("ROLE_LAB_DIRECTOR")){
			if(null!=query&&!"".equals(query)){
				list.addAll( appraisalService.getAppraisals(query,query,Appraisal.ARRANGEMENT_AUDIT,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection()));
				totalCount += appraisalService.getAppraisalQty(query,query,Integer.parseInt(status));
			}else{
				list = appraisalService.getAppraisals(Appraisal.ARRANGEMENT_AUDIT,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQty(Integer.parseInt(status));
			} 
		}   
		/*
		
		if(null!=status&&!"".equals(status)){
			if(null!=query&&!"".equals(query)){
				list = appraisalService.getAppraisals(query,query,Integer.parseInt(status),params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQty(query,query,Integer.parseInt(status));
			}else{
				list = appraisalService.getAppraisals(Integer.parseInt(status),params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQty(Integer.parseInt(status));
			}
		}else{
			list = appraisalService.getAppraisals(null,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
			totalCount = appraisalService.getAppraisalQty(null);
		}*/
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	
	/***
	 * 检材鉴定列表数据源（文书审批）根据当前用户角色划分 （首页）
	 * @return 检材鉴定数据据集JSON
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_APPRAISAL_AUDIT_INDEX_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalAuditIndexData(String status){
		 Map<String, Object> result = new HashMap<String, Object>();  
		List<Appraisal> list = new ArrayList<Appraisal>();
		if(null!=status&&!"".equals(status)){
			list = appraisalService.getAppraisals(Integer.parseInt(status) ,0,Integer.MAX_VALUE, "createdDate", "desc");
		}
		result.put("entity",list);
		return result;
	}
	
	
	
	/***
	 * 检材鉴定列表数据源
	 * @return 检材鉴定数据据集JSON
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_APPRAISAL_LOAD_ALL_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalAllListData(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		CurrentUser curr = getCurrentUser();
		Map<String,String> roles = curr.getRoles();
		List<Appraisal> list = new ArrayList<Appraisal>();
		long totalCount = 0L;
		String query = params.getExtraParam("query");
		//条件判断  管理人员加载所有
		if(roles.containsKey("ROLE_LAB_DIRECTOR")||roles.containsKey("ROLE_QLTY_DIRECTOR")||
				roles.containsKey("ROLE_TECH_DIRECTOR")||roles.containsKey("ROLE_AUTH_OFFICER")){
			if(null!=query&&!"".equals(query)){
				list = appraisalService.getAllAppraisalsSearch(query,query,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAllAppraisalsSearchQty(query,query);
			}else{
				list = appraisalService.getAppraisalConnectList(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalConnectQty();
			} 
		}else{
			//其他人员只加载自己的
			if(null!=query&&!"".equals(query)){
				list = appraisalService.getFinishAppraisalsByUserId(curr.getUserId(),query,query,params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQtyByUserIdQty(curr.getUserId(),query,query);
			}else{
				list = appraisalService.getFinishAppraisalsByUserId(curr.getUserId(),params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				totalCount = appraisalService.getAppraisalQtyByUserIdQty(curr.getUserId());
			}
		}
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	} 
	
	
	
	/***
	 * 下载视屏
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_SHOWVEDIO)
	@ResponseBody
	public void showVedio(String id, HttpServletRequest request, HttpServletResponse response){
		try {
			if (id != null && (!id.trim().equals(""))) {
				String videoPath = videoMap.get(id);
				File file = null;
				if(videoPath != null && !videoPath.equals("")){
					file = new File(videoPath);
				}else{
					Appraisal appraisal = appraisalService.getAppraisalById(id);
					videoMap.put(id, appraisal.getVideoPath());
					file = new File(appraisal.getVideoPath());
				}
				if (file.exists() && file.canRead()) {
					FileInputStream inputStream = new FileInputStream(file);
					byte[] data = new byte[(int)file.length()];
			        inputStream.read(data);
			        inputStream.close();
			        response.setContentType("application/octet-stream");
//			        response.setContentType("video/mpeg4");
			        OutputStream stream = response.getOutputStream();
			        stream.write(data);
			        stream.flush();
			        stream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	/***
	 * 获取摄像头参数List
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_LOADVIDEOLIST)
	@ResponseBody
	public Map<String,List<CameraDto>> loadVideoList(){
		Map<String,List<CameraDto>> map = new HashMap<String, List<CameraDto>>();
		try {
			List<CameraDto> camersList = CameraDataLoader.getCameras();
			map.put("entity", camersList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	} 
	
	/***
	 * 保存原始记录word文档
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_SAVERECORDWORD)
	@ResponseBody
	public void saveRecordWord(@RequestBody Appraisal appraisal){
		String templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/appraisal_record.doc").toString();
		templatePath = templatePath.replace("file:/", "");
		File file = new File(templatePath);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (file.exists() && file.canRead()) {
				String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
				saveDirectoryPath = saveDirectoryPath.replaceAll("//", "/");
		        File saveDirectory = new File(saveDirectoryPath); 
				if (!saveDirectory.exists()) {
					saveDirectory.mkdirs();
				}
				String outPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
				Map<String,Object> param = new HashMap<String, Object>();
				param.put("$CASE_NAME$", checkNull(appraisal.getCaseSn()));
				param.put("$EVID_SN$", checkNull(appraisal.getEvidSn()));
				//（0：《数字化设备证据数据发现提取固定方法》GA/T756-2008；1：《电子物证搜索检验技术规范》GB/T29362-2012；2：《电子物证恢复检验技术规范》GB/T29360-2012），鉴定方法可多个，多个选择的情况以逗号分隔，如：0,1,2
				String method = appraisal.getMethod();
				String appMethod = "";
				String[] split = method.split(",");
				for(int i = 0 ; i < split.length ; i++){
					if("0".equals(split[i])){
						appMethod += "《数字化设备证据数据发现提取固定方法》GA/T756-2008;";
					}else if("1".equals(split[i])){
						appMethod += "《电子物证搜索检验技术规范》GB/T29362-2012;";
					}else{
						appMethod += "《电子物证恢复检验技术规范》GB/T29360-2012）;";
					}
				}
				param.put("$METHODS$", checkNull(appMethod));
				param.put("$START_DATE$", checkNull(sdf.format(appraisal.getAppraisedStartDate())));
				param.put("$END_DATE$", checkNull(sdf.format(appraisal.getAppraisedEndDate())));
				param.put("$PROCESS$", checkNull(appraisal.getProcess()));
				param.put("$ANTIVIRUS_RESULT$", checkNull(appraisal.getAntivirusResult()));
				param.put("$APPRAISAL_RESULT$", checkNull(appraisal.getAppraisalResult()));
				param.put("$REMARKS$", checkNull(appraisal.getRemarks()));
				GenerateWordUtil.replaceWord(templatePath, outPath, param); //原来的路径   写出路径  替换map
				//需要保存appraisalDoc 
				saveAppraisalDoc(appraisal.getId(),outPath,4,"电子物证检验原始记录.doc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 保存鉴定文书副本
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_SAVEREPORTWORD)
	@ResponseBody
	public void saveReportWord(@RequestBody Appraisal appraisal){
		String templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/appraisal_report.doc").toString();
		templatePath = templatePath.replace("file:/", "");
		File file = new File(templatePath);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (file.exists() && file.canRead()) {
				String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
				saveDirectoryPath = saveDirectoryPath.replaceAll("//", "/");
		        File saveDirectory = new File(saveDirectoryPath); 
				if (!saveDirectory.exists()) {
					saveDirectory.mkdirs();
				}
				String outPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
				
				Map<String,Object> param = new HashMap<String, Object>();
				Map<String,Object> headerParam = new HashMap<String, Object>();
				
				param.put("$ORG_NAME$", checkNull(appraisal.getOrgName()));
				
				List<PreappraisalEntruster> list = preappraisalEntrusterService.getPreappraisalEntrusterListByPreappraisalId(appraisal.getPreappraisalId());
				Preappraisal preappraisal = preappraisalService.getPreappraisalById(appraisal.getPreappraisalId());
				String sendPerson = "";
				for (PreappraisalEntruster preappraisalEntruster : list) {
					sendPerson += preappraisalEntruster.getUserAlias()+"、";
				}
				param.put("$ENTRUSTER_NAMES$", checkNull(sendPerson.substring(0, sendPerson.length()-1)));
				
				param.put("$PREAPPRAISAL_DATE$", checkNull(sdf.format(appraisal.getEntrustedDate())));
				param.put("$EXPLANATION$", checkNull(preappraisalService.getPreappraisalById(appraisal.getPreappraisalId()).getExplanation()));
				param.put("$EVID_NAME$ ", checkNull(appraisal.getEvidName()));
				param.put("$EVID_SN$", checkNull(appraisal.getEvidSn()));
				param.put("$APPRAISAL_DATE$", checkNull(sdf.format(appraisal.getAppraisedStartDate())));
				param.put("$APPRAISAL_LOCATION$", checkNull(appraisal.getLocation()));
				if(preappraisal != null){
				    param.put("$RQMT$", checkNull(preappraisal.getRqmt()  ));
				}else{
					param.put("$RQMT$", "");
				}
				String method = appraisal.getMethod();
				String appMethod = "";
				String[] split = method.split(",");
				for(int i = 0 ; i < split.length ; i++){
					if("0".equals(split[i])){
						appMethod += "《数字化设备证据数据发现提取固定方法》GA/T756-2008;";
					}else if("1".equals(split[i])){
						appMethod += "《电子物证搜索检验技术规范》GB/T29362-2012;";
					}else{
						appMethod += "《电子物证恢复检验技术规范》GB/T29360-2012）;";
					}
				}
				String appMethod2 = "";
				String[] split2 = appraisal.getRqmt().split(",");
				for(int i = 0 ; i < split2.length ; i++){
					if("0".equals(split2[i])){
						appMethod2 += "出具检验报告;";
					}else if("1".equals(split2[i])){
						appMethod2 += "出具鉴定意见书;";
					}else{
						appMethod2 += "只提取电子数据;";
					}
				}
				param.put("$JDYQ$", checkNull(appMethod2));
				
				param.put("$APPRAISAL_METHODS$", checkNull(appMethod));
				String devName = "";
				List<AppraisedDev> devList = appraisedDevService.getAppraisedByappraisalId(appraisal.getId());
				for (AppraisedDev appraisedDev : devList) {
					Device device = deviceService.getDeviceById(appraisedDev.getDeviceId());
					if(device != null){
						devName += device.getName();
					}
				}
				param.put("$APPRAISAL_DEVICES$", checkNull(devName));
				param.put("$APPRAISAL_PROCESS$", checkNull(appraisal.getProcess()));
				param.put("$APPRAISAL_RESULT$",checkNull(appraisal.getAppraisalResult()));
				
				param.put("$AGENCY$", checkNull(appraisal.getAgency()));
				param.put("$YEAR$", checkNull(appraisal.getYear()));
				param.put("$SN$", checkNull(appraisal.getSn()));
				GenerateWordUtil.replaceWord(templatePath, outPath, param); //原来的路径   写出路径  替换map
				saveAppraisalDoc(appraisal.getId(),outPath,5,"鉴定文书.doc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/***
	 * 保存终止文件
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_SAVETERMINATIONWORD)
	@ResponseBody
	public void saveTerminationWord(@RequestBody Appraisal appraisal){
		String templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/appraisal_termination.doc").toString();
		templatePath = templatePath.replace("file:/", "");
		File file = new File(templatePath);
		try {
			if (file.exists() && file.canRead()) {
				String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH+DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
				saveDirectoryPath = saveDirectoryPath.replaceAll("/", "/");
		        File saveDirectory = new File(saveDirectoryPath); 
				if (!saveDirectory.exists()) {
					saveDirectory.mkdirs();
				}
				String outPath = saveDirectoryPath+"//"+UUIDHexGenerator.getInstance().generate()+".doc";
				Map<String,Object> param = new HashMap<String, Object>();
				param.put("$ORG_NAME$", checkNull(appraisal.getOrgName()));
				List<PreappraisalEntruster> list = preappraisalEntrusterService.getPreappraisalEntrusterListByPreappraisalId(appraisal.getPreappraisalId());
				String sendPerson = "";
				String sendPoliecId = "";
				if(list.size() > 0){
					sendPerson = list.get(0).getUserAlias();
					sendPoliecId = list.get(0).getPoliceId();
				} 
				param.put("$ENTRUSTER_NAME$", checkNull(sendPerson));
				
				param.put("$POLICE_ID$", checkNull(sendPoliecId));
				param.put("$CASE_NAME$", checkNull(appraisal.getCaseName()));
				param.put("$CASE_SN$", checkNull(appraisal.getCaseSn()));
				
				TerminationNotice terminationNotice = terminationNoticeService.getTerminationNoticeByAppraisalId(appraisal.getId());
				if(terminationNotice != null){
					param.put("$ARTICLE$", checkNull(terminationNotice.getArticle()));
					param.put("$PARAGRAPH$", checkNull(terminationNotice.getParagraph()));
					param.put("$REASON$", checkNull(terminationNotice.getReason()));
				}
				param.put("$EVID_NAME$", checkNull(appraisal.getEvidName()));
				ArchiveCode archiveCode = getArchiveCodeById(appraisal.getId(),"2",String.valueOf(DateUtil.getYear(new Date())));
				if(archiveCode != null){
					param.put("$AGENCY$", checkNull(archiveCode.getAgency()));
					param.put("$YEAR$", checkNull(archiveCode.getYear()));
					param.put("$SN$", checkNull(archiveCode.getSn()));
				}else{
					param.put("$AGENCY$", checkNull(appraisal.getAgency()));
					param.put("$YEAR$", checkNull(appraisal.getYear()));
					param.put("$SN$", checkNull(appraisal.getSn()));
				}
				GenerateWordUtil.replaceWord(templatePath, outPath, param); //原来的路径   写出路径  替换map
				
				saveAppraisalDoc(appraisal.getId(),outPath,10,"中止鉴定告知书.doc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * 根据 预检Id 查询  电子物证（检材）鉴定 
	 * @param id 预检Id 
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALDATA_LOADAPPRAISALDATABYPREAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getAppraisalDataByPreappraisalId(String preappraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Appraisal appraisal = appraisalService.getAppraisalByPreappraisedId(preappraisalId);
			appraisal = appraisal == null ? new Appraisal() : appraisal;
			result.put("entity", appraisal);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new Appraisal());
		}
		return result;
	}
	
	
	/***
	 * 根据 首页信息 数据源
	 * @return
	 */
	@RequestMapping(NavConst.ARCHIVECODE_MGT_GET_INDEX_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalIndexListData(Integer status){
		Map<String, Object> result = new HashMap<String, Object>();
		CurrentUser curr = getCurrentUser();
		List<Appraisal> resultList = new ArrayList<Appraisal>();
		Appraisal appraisal = null;
		try{
			if(status.intValue() == Appraisal.AUTHENTICATE ){
				appraisal = appraisalService.getAppraisalByUserId(curr.getUserId());
				resultList.add(appraisal);
			}else{
				resultList = appraisalService.getAppraisalsIndex(status);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("entity", resultList);
		return result;
	}
	
	
	
	
	
	/***
	 * 保存提取电子清单列表
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_SAVEEXTRACTLISTWORD)
	@ResponseBody
	public void saveExtractListWord(@RequestBody ExtractedData extractedData){
		String templatePath = Thread.currentThread().getContextClassLoader().getResource("/templates/appraisal_extract_list.docx").toString();
		templatePath = templatePath.replace("file:/", "");
		File file = new File(templatePath);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (file.exists() && file.canRead()) {
				Appraisal appraisal =appraisalService.getAppraisalById(extractedData.getAppraisalId());
				String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
				saveDirectoryPath = saveDirectoryPath.replaceAll("//", "/");
		        File saveDirectory = new File(saveDirectoryPath); 
				if (!saveDirectory.exists()) {
					saveDirectory.mkdirs();
				}
				String outPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
				List<Map<Integer, Object>> paramList = new ArrayList<Map<Integer,Object>>();
				List<ExtractedDataItem> itemList = extractedDataItemService.getExtractedDataItemByExtractedDataId(extractedData.getId());
				int Num = 1;
				for (ExtractedDataItem extractedDataItem : itemList) {
					Map<Integer,Object> map = new HashMap<Integer, Object>();
					map.put(0, Num);
					map.put(1, extractedDataItem.getData());
					map.put(2, extractedDataItem.getSrc());
					map.put(3, extractedDataItem.getExplanation());
					Num++;
					paramList.add(map);
				}
				
				List<String> list = new ArrayList<String>();
				list.add(extractedData.getCause());
				list.add(sdf.format(extractedData.getExtractedDate()));
				
				GenerateWordUtil.replaceWordAndWriteExcelInWord(templatePath, outPath, 0 , 2, paramList,list);  //替换列表
				
				saveAppraisalDoc(appraisal.getId(),outPath,7,"提取电子证据清单.doc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean generateImageForm(Appraisal appraisal) {
		boolean status = false;
		CurrentUser curr = getCurrentUser(); 
		AppraisalDoc picDoc = appraisalDocService.getAppraisalDocByTypeAndAppraisalId(6, appraisal.getId()); 
		if(picDoc != null){
			status = true;
		}
		if(appraisal!=null && picDoc==null){
			try {
				EvidOpLog evidoplog =  evidOpLogService.getEvidOpLogByEvidIdAndSpLabel(appraisal.getEvidId(), EvidOpLog.SP_IMPT);
				List<EvidOpLogAtt> attList = evidOpLogAttService.getEvidOpLogAttByEvidOpLogId(evidoplog.getId());
				
				String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
				File saveDirectory = new File(saveDirectoryPath); 
				if (!saveDirectory.exists()) {
					saveDirectory.mkdirs();
				} 
				//生成勘验检查照片记录表
				String imagePath = request.getSession().getServletContext().getRealPath("/");
				imagePath +="/WEB-INF/classes/templates/appraisal_pic_record.docx";
				
				// 读取word源文件
				FileInputStream fileInputStream = new FileInputStream(imagePath);
 				CustomXWPFDocument document = new CustomXWPFDocument(fileInputStream);
				// 获取所有表格
				List<XWPFTable> tables = document.getTables();
				// 这里简单取第一个表格
				XWPFTable table = tables.get(0);
				// 获取表头，这里没什么用，只是打印验证下
				XWPFTableRow header = table.getRow(0);
				// 表格的插入行有两种方式，这里使用addNewRowBetween，因为这样会保留表格的样式，就像我们在word文档的表格中插入行一样。注意这里不要使用insertNewTableRow方法插入新行，这样插入的新行没有样式，很难看
				XWPFTableRow row0 = table.getRow(0);
				int size = attList.size();
				String number = "";
				DecimalFormat df = new DecimalFormat("000");
				if(size>0){
					for (int i = 1; i < size+1; i++) {
						number += df.format(i)+",";
					}
				}
				row0.getCell(1).setText(checkNull(number.substring(0,number.length()-1)).toString());
				XWPFTableRow row1 = table.getRow(1);
				row1.getCell(1).setText(checkNull(appraisal.getEvidName()).toString()+"（标识号为"+checkNull(appraisal.getEvidSn()).toString()+"）");
				XWPFTableRow row2 = table.getRow(2);
				
				XWPFTableCell cell = row2.getCell(0);
				XWPFParagraph paragraph = cell.addParagraph();
				XWPFRun run = paragraph.createRun();
			    if(attList.size() > 0){
			    	 for (EvidOpLogAtt att : attList) {
			    		 int imageType = GenerateWordUtil.getPictureType(att.getExt());
			    		 if(att.getPath()!=null ||!att.getPath().equals("")){
				    		 String id = document.addPictureData(new FileInputStream(new File(att.getPath())),imageType);
							 document.createPicture(run, id, document.getNextPicNameNumber(imageType), 300, 300);
			    		 }
						 run.addBreak();
						 run.addBreak(); 
					}
			    }
				String imageOutPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".docx";
				OutputStream output = new FileOutputStream(imageOutPath);
				document.write(output);
				output.close();
				AppraisalDoc imageDoc = new AppraisalDoc(); 
				imageDoc.setName("检验鉴定照片记录表.docx");
				imageDoc.setAppraisalId(appraisal.getId());
				imageDoc.setCreatorAlias(curr.getUserAlias());
				imageDoc.setCreatorId(curr.getUserId());
				imageDoc.setCreatorName(curr.getUserName());
				imageDoc.setExt("docx");
				imageDoc.setPath(imageOutPath);
				imageDoc.setType(AppraisalDoc.PICTURE_RECORD);
				status = appraisalDocService.saveAppraisalDoc(imageDoc); 

			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return status;
			} catch (IOException e) {
				e.printStackTrace();
				return status;
			} catch (InvalidFormatException e) {
				e.printStackTrace();
				return status;
			}
			
		} 
 		return status;
	}

	private boolean generateApprovalForm(Appraisal appraisal) {
		boolean status = false;
		boolean haveApproveDoc = appraisalDocService.getAppDocByTypeAndAppraisalId(8, appraisal.getId());
		status = haveApproveDoc;
		if(appraisal!=null&& !haveApproveDoc&& appraisal.getApproverId() != null){
			CurrentUser curr = getCurrentUser();
			try {
			String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();
			File saveDirectory = new File(saveDirectoryPath); 
			if (!saveDirectory.exists()) {
				saveDirectory.mkdirs();
			} 
			int[] code = { 0x2610, 0x2611, 0x2612 };
			//生成审批表	
			String approvalPath = request.getSession().getServletContext().getRealPath("/");
			approvalPath +="/WEB-INF/classes/templates/appraisal_approval.doc";
			
			Map<String, Object> approvalParam = new HashMap<String, Object>();
			approvalParam.put("$YEAR$", checkNull(appraisal.getYear()).toString());
			approvalParam.put("$SN$", checkNull(appraisal.getSn()).toString());
			approvalParam.put("$ORG_NAME$", checkNull(appraisal.getOrgName()).toString());
			approvalParam.put("$AGENCY$", checkNull(appraisal.getAgency()).toString());
			approvalParam.put("$APPRAISER$",checkNull(appraisal.getAppraiserAlias()).toString());
			approvalParam.put("$REVIEWER$",  checkNull(appraisal.getReviewer()).toString());
			if(appraisal.getReviewerdDate() != null){
				Date reviewedDate = appraisal.getReviewerdDate(); 
				approvalParam.put("$REVIEW_YEAR$", checkNull(DateUtil.getYear(reviewedDate)).toString());
				approvalParam.put("$REVIEW_MONTH$", checkNull(DateUtil.getMonth(reviewedDate)).toString());
				approvalParam.put("$REVIEW_DAY$", checkNull(DateUtil.getDay(reviewedDate)).toString());
			}else{
				approvalParam.put("$REVIEW_YEAR$", checkNull(null).toString());
				approvalParam.put("$REVIEW_MONTH$", checkNull(null).toString());
				approvalParam.put("$REVIEW_DAY$", checkNull(null).toString());
			}
			
			String issuedForm = appraisal.getIssuedForm();
			
			 if(  null != issuedForm && !"".equals(issuedForm)){
				JSONArray jsonArray = new JSONArray(issuedForm);
				if(jsonArray.length() > 0){
					JSONObject jsonObj = jsonArray.getJSONObject(0);
					if(jsonObj.get("name").equals("0")){
						approvalParam.put("$FORM_0$", new String(code, 1, 1));//鉴定书
						approvalParam.put("$FORM_0_QTY$", jsonObj.get("qty"));//鉴定书 份数
						approvalParam.put("$FORM_1$", new String(code, 0, 1));//检验报告
						approvalParam.put("$FORM_1_QTY$", "");//检验报告 份数
						approvalParam.put("$FORM_2$", new String(code, 0, 1));//检验报告
						approvalParam.put("$FORM_2_QTY$", "");//检验报告 份数
					}else if(jsonObj.get("name").equals("1")){
						approvalParam.put("$FORM_0$", new String(code, 0, 1));//鉴定书
						approvalParam.put("$FORM_0_QTY$", "");//鉴定书 份数
						approvalParam.put("$FORM_1$", new String(code, 1, 1));//检验报告
						approvalParam.put("$FORM_1_QTY$", jsonObj.get("qty"));//检验报告 份数
						approvalParam.put("$FORM_2$", new String(code, 0, 1));//检验报告
						approvalParam.put("$FORM_2_QTY$", "");//检验报告 份数
					}else if(jsonObj.get("name").equals("2")){
						approvalParam.put("$FORM_0$", new String(code, 0, 1));//鉴定书
						approvalParam.put("$FORM_0_QTY$", "");//鉴定书 份数
						approvalParam.put("$FORM_1$", new String(code, 0, 1));//检验报告
						approvalParam.put("$FORM_1_QTY$", "");//检验报告 份数
						approvalParam.put("$FORM_2$", new String(code, 1, 1));//检验报告
						approvalParam.put("$FORM_2_QTY$", jsonObj.get("qty"));//检验报告 份数
					} 
				}
			 }	else{
				   approvalParam.put("$FORM_0$", new String(code, 0, 1));//鉴定书
					approvalParam.put("$FORM_0_QTY$", "");//鉴定书 份数
					approvalParam.put("$FORM_1$", new String(code, 0, 1));//检验报告
					approvalParam.put("$FORM_1_QTY$", "");//检验报告 份数
					approvalParam.put("$FORM_2$", new String(code, 0, 1));//检验报告
					approvalParam.put("$FORM_2_QTY$", "");//检验报告 份数
			 }
			 
			String att = appraisal.getAtt();
			Set<String> attSet = new HashSet<String>();
			if(null !=att && !"".equals(att)){
				String[] attArrty  = att.split(",");
				for (String string : attArrty) {
					attSet.add(string);
				} 
			} 
			
			for (int i = 0; i < 5; i++) {
				if(attSet.contains((i+"").trim())){
					approvalParam.put("$ATT_"+i+"$", new String(code, 1, 1));  
				}else{
					approvalParam.put("$ATT_"+i+"$", new String(code, 0, 1)); 
				} 
			}
			if( null!= appraisal.getAttOther() && !"".equals(appraisal.getAttOther())){
				approvalParam.put("$ATT_5$", new String(code, 1, 1));//其他
				approvalParam.put("$ATT_OTHER$", checkNull(appraisal.getAttOther()).toString());//其他
			}else{
				approvalParam.put("$ATT_5$", new String(code, 0, 1));//其他
				approvalParam.put("$ATT_OTHER$", "");//其他
			}
			
			String sitnJudgement = appraisal.getSitnJudgement();
			Set<String> sitnSet = new HashSet<String>();
			if( sitnJudgement !=null && !"".equals(sitnJudgement)){
				String[] signArray = sitnJudgement.split(",");
				for (String string : signArray) {
					sitnSet.add(string);
				} 
			}
			
			for (int i = 0; i < 3; i++) {
				if(sitnSet.contains((i+"").trim())){
					approvalParam.put("$JUDGEMENT_"+i+"$", new String(code, 1, 1));  
				}else{
					approvalParam.put("$JUDGEMENT_"+i+"$", new String(code, 0, 1)); 
				} 
			} 
			approvalParam.put("$AUDIT_OPINION$", checkNull(appraisal.getVerifierOpinion()).toString());//授权签字人意 见.
			System.out.println();
			approvalParam.put("$AUDIT_YEAR$" ,appraisal.getVerifiedDate() == null? "": DateUtil.getYear(appraisal.getVerifiedDate()) );//授权签字人意 见 年
			approvalParam.put("$AUDIT_MONTH$",appraisal.getVerifiedDate() == null? "": DateUtil.getMonth(appraisal.getVerifiedDate())) ;//授权签字人意 见 月
			approvalParam.put("$AUDIT_DAY$",appraisal.getVerifiedDate() == null? "": DateUtil.getDay(appraisal.getVerifiedDate()));//授权签字人意 见 日
			
			approvalParam.put("$APPROVAL_OPINION$", checkNull(appraisal.getApproverOpinion()).toString());//实 验 室 	负 责 人 审批意见
			 
			approvalParam.put("$APPROVAL_YEAR$", appraisal.getApprovedDate() == null ? "": DateUtil.getYear(appraisal.getApprovedDate()) );//实 验 室 	负 责 人 审批意见 年	
			approvalParam.put("$APPROVAL_MONTH$", appraisal.getApprovedDate() == null ? "": DateUtil.getMonth(appraisal.getApprovedDate()) );//实 验 室 	负 责 人 审批意见 年	
			approvalParam.put("$APPROVAL_DAY$", appraisal.getApprovedDate() == null ? "": DateUtil.getDay(appraisal.getApprovedDate()) );//实 验 室 	负 责 人 审批意见 年	
			approvalParam.put("$REMARKS$", checkNull(appraisal.getComments()).toString());//备注
			
			String approvalOutPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
			status = GenerateWordUtil.replaceWord(approvalPath, approvalOutPath, approvalParam);
			AppraisalDoc approvalDoc = new AppraisalDoc(); 
			approvalDoc.setName("鉴定文书审批表.doc");
			approvalDoc.setAppraisalId(appraisal.getId());
			approvalDoc.setCreatorAlias(curr.getUserAlias());
			approvalDoc.setCreatorId(curr.getUserId());
			approvalDoc.setCreatorName(curr.getUserName());
			approvalDoc.setExt("doc");
			approvalDoc.setPath(approvalOutPath);
			approvalDoc.setType(AppraisalDoc.AUTHENTICATE_DOC_APPROVE);
			status = appraisalDocService.saveAppraisalDoc(approvalDoc);
			} catch (Exception e) {
	 			e.printStackTrace();
	 			return status;
			}
 		}else{
			status = true;
		}
		return status;
	}

	private boolean notAcceptInstruments(Appraisal appraisal) {
		boolean status = false;
		CurrentUser curr = getCurrentUser();
 	    /* 不受理鉴定委托告知书 */ 
		String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn(); 
        File saveDirectory = new File(saveDirectoryPath); 
		if (!saveDirectory.exists()) {
			saveDirectory.mkdirs();
		}   
		DismissalNotice dismissalNotice = dismissalNoticeService.getDismissalNoticeByAppraisalId(appraisal.getId());
		List<PreappraisalEntruster> entrList =   preappraisalEntrusterService.getPreappraisalEntrusters(appraisal.getPreappraisalId());
		
		try {
		String coverPath = request.getSession().getServletContext().getRealPath("/");
		coverPath +="/WEB-INF/classes/templates/appraisal_veto.doc";
		 
		Map<String, Object> vetoParam = new HashMap<String, Object>();
		vetoParam.put("$ORG_NAME$", checkNull(appraisal.getOrgName()).toString());
		vetoParam.put("$CASE_NAME$", checkNull(appraisal.getCaseName()).toString());
		vetoParam.put("$CASE_SN$", checkNull(appraisal.getCaseSn()).toString());
		vetoParam.put("$PARAGRAPH$", checkNull(dismissalNotice.getParagraph()).toString());
		vetoParam.put("$REASON$", checkNull(dismissalNotice.getReason()).toString());
		vetoParam.put("$ARTICLE$", checkNull(dismissalNotice.getArticle()).toString()); 
		vetoParam.put("$EVIDNAME$", checkNull(appraisal.getEvidName()).toString()); 
		if(entrList.size() > 0){
			vetoParam.put("$ENTRUSTER_NAME$", checkNull(entrList.get(0).getUserAlias()).toString()); 
			vetoParam.put("$POLICE_ID$", checkNull(entrList.get(0).getPoliceId()).toString()); 
		} 
		String coverOutPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
		status = GenerateWordUtil.replaceWord(coverPath, coverOutPath, vetoParam);
		AppraisalDoc vetoDoc = new AppraisalDoc(); 
		vetoDoc.setName("不受理鉴定委托告知书.doc");
		vetoDoc.setAppraisalId(appraisal.getId());
		vetoDoc.setCreatorAlias(curr.getUserAlias());
		vetoDoc.setCreatorId(curr.getUserId());
		vetoDoc.setCreatorName(curr.getUserName());
		vetoDoc.setExt("doc");
		vetoDoc.setPath(coverOutPath);
		vetoDoc.setType(AppraisalDoc.NOT_ACCEPT_NOTIFICATION);
		appraisalDocService.saveAppraisalDoc(vetoDoc);
		} catch (Exception e) {
 			e.printStackTrace();
 			return status;
		}
		return status;
	}

	private boolean generateInstruments(Appraisal appraisal) {
		boolean status = false;
		if(appraisal!=null){
			CurrentUser curr = getCurrentUser();
			List<AppraisalDoc> docList = new ArrayList<AppraisalDoc>(); 
			
			
			String saveDirectoryPath = Const.DOC_LIB_INSTRUMENT_PATH +DateUtil.getYear(new Date())+"/"+DateUtil.getMonth(new Date())+ "/"+appraisal.getCaseSn()+"/"+appraisal.getEvidSn();  
	        File saveDirectory = new File(saveDirectoryPath); 
			if (!saveDirectory.exists()) {
				saveDirectory.mkdirs();
			}  
			try {
				String coverPath = request.getSession().getServletContext().getRealPath("/");
				coverPath +="/WEB-INF/classes/templates/appraisal_cover.doc";
				//生成封面
				String agency = appraisal.getAgency();
				String year = appraisal.getYear();
				String sn = appraisal.getSn();
				Map<String, Object> coverParam = new HashMap<String, Object>();
				coverParam.put("$AGENCY$", checkNull(agency));
				coverParam.put("$YEAR$", checkNull(year));
				coverParam.put("$SN$", checkNull(sn));
				String coverOutPath = saveDirectoryPath+"/"+UUIDHexGenerator.getInstance().generate()+".doc";
				status = GenerateWordUtil.replaceWord(coverPath, coverOutPath, coverParam);
				AppraisalDoc coverDoc = new AppraisalDoc(); 
				coverDoc.setName("物证鉴定档案封面.doc");
				coverDoc.setAppraisalId(appraisal.getId());
	 			coverDoc.setCreatorAlias(curr.getUserAlias());
				coverDoc.setCreatorId(curr.getUserId());
				coverDoc.setCreatorName(curr.getUserName());
				coverDoc.setExt("doc");
				coverDoc.setPath(coverOutPath);
				coverDoc.setType(AppraisalDoc.COVER);
				docList.add(coverDoc);
				
				//鉴定文书档案目录（复制一份）
				String catalogPath = request.getSession().getServletContext().getRealPath("/");
				catalogPath +="/WEB-INF/classes/templates/appraisal_catalog.doc";
				String catalogName = UUIDHexGenerator.getInstance().generate()+".doc";
				String outCatalogPath =  saveDirectoryPath+"/"+catalogName;
				InputStream template = new FileInputStream(catalogPath);
				File rootFile = new File(saveDirectory , catalogName);
				FileUtils.copyInputStreamToFile(template,rootFile);
				template.close(); 
				
				AppraisalDoc catalogDoc = new AppraisalDoc(); 
				catalogDoc.setName("鉴定文书档案目录.doc");
				catalogDoc.setAppraisalId(appraisal.getId());
	 			catalogDoc.setCreatorAlias(curr.getUserAlias());
				catalogDoc.setCreatorId(curr.getUserId());
				catalogDoc.setCreatorName(curr.getUserName());
				catalogDoc.setExt("doc");
				catalogDoc.setPath(outCatalogPath);
				catalogDoc.setType(AppraisalDoc.CATALOGUE);
				docList.add(catalogDoc);
				
				//鉴定事项确认书
				String confirmationPath = request.getSession().getServletContext().getRealPath("/");
				confirmationPath +="/WEB-INF/classes/templates/appraisal_confirmation.docx";
				
				Preappraisal preappraisal =	preappraisalService.getPreappraisalById(appraisal.getPreappraisalId());
				//替换 
				String confirmationName = UUIDHexGenerator.getInstance().generate()+".docx";
				String outConfirmationPath =  saveDirectoryPath+"/"+confirmationName;
				FileInputStream fileInputStream = new FileInputStream(confirmationPath);
				CustomXWPFDocument document = new CustomXWPFDocument(fileInputStream);
				List<XWPFTable> tables = document.getTables();
				
				
				/**  第一个表格--Strat**/
				XWPFTable table = tables.get(0);
				table.getRow(0).getCell(0).setText("编号：["+appraisal.getYear()+"]"+appraisal.getSn());//委托机构
				
				//定位直接替换
				XWPFTable table0 = tables.get(1);
				 
				table0.getRow(1).getCell(1).setText(checkNull(appraisal.getOrgName()).toString());//委托机构
				
				String provinceId = preappraisal.getProvince();
				String cityId = preappraisal.getCity();
				String countyId = preappraisal.getCountry();
				
				String province = "";
				String city = "";
				String county = "";
				
				if( null != provinceId || !"".equals(provinceId)){
					 province = provinceService.getProvinceByProvinceId(provinceId).getName();
				}
				
				if( null != cityId || !"".equals(cityId)){
					city = cityService.getCityByCityId(cityId).getName();
				}
				
				if( null != countyId || !"".equals(countyId)){
					county = countyService.getCountyByCountyId(countyId).getName();
				}
				
				table0.getRow(2).getCell(1).setText(checkNull(province).toString()+checkNull(city).toString()+checkNull(county).toString()+checkNull(preappraisal.getAddr()).toString());//地址
				table0.getRow(3).getCell(1).setText( "电话："+checkNull(preappraisal.getTel())+"  传真：" +checkNull(preappraisal.getFax()));//电话传真
				table0.getRow(3).getCell(3).setText(checkNull(preappraisal.getEmail()).toString());//电子邮箱
				table0.getRow(6).getCell(1).setText(checkNull(preappraisal.getCaseName()).toString() );//案件名称
				table0.getRow(6).getCell(3).setText(checkNull(preappraisal.getCaseSn()).toString() );//案件编号
				table0.getRow(7).getCell(1).setText(checkNull(preappraisal.getExplanation()).toString() );//简要说明
				XWPFTableCell cell091  = table0.getRow(9).getCell(1);//简要说明
				
				//检验鉴定事项--start
				int[] code = { 0x2610, 0x2611, 0x2612 };
				XWPFParagraph paragraph = cell091.addParagraph();
				XWPFRun run = paragraph.createRun();
				StringBuffer sb = new StringBuffer();
				String[] scope = appraisal.getScope().split(",");
				sb.append("1、委托项目选择：");
				Set<String> scopeSet = new HashSet<String>(Arrays.asList(scope));
				if(scopeSet.contains("0")){
					sb.append("  " + new String(code, 1, 1) + "  提取固定电子数据");
				}else{
					sb.append("  " + new String(code, 0, 1) + "  提取固定电子数据");
				}
				
				if(scopeSet.contains("1")){
					sb.append("  " + new String(code, 1, 1) + "  恢复电子数据");
				}else{
					sb.append("  " + new String(code, 0, 1) + "  恢复电子数据");
				}
				
				if(scopeSet.contains("2")){
					sb.append("  " + new String(code, 1, 1) + "  检验程序功能");
				}else{
					sb.append("  " + new String(code, 0, 1) + "  检验程序功能");
				}
		 
				if(scopeSet.contains("3")){
					sb.append("  " + new String(code, 1, 1) + "  破解电子数据密码");
				}else{
					sb.append("  " + new String(code, 0, 1) + "  破解电子数据密码");
				}
				
				if(scopeSet.contains("4")){
					sb.append("  " + new String(code, 1, 1) + "  分析电子数据");
				}else{
					sb.append("  " + new String(code, 0, 1) + "  分析电子数据");
				}
				
				if(scopeSet.contains("5")){
					sb.append("  " + new String(code, 1, 1) + "  销毁电子数据");
				}else{
					sb.append("  " + new String(code, 0, 1) + "  销毁电子数据");
				}
				run.setText(sb.toString());
				run.addBreak();
		  
				XWPFParagraph paragraph2 = cell091.addParagraph();
				XWPFRun run2 = paragraph2.createRun();
				StringBuffer sb2 = new StringBuffer();
				sb2.append("2、方法选择	："); 
	 			String[] method = appraisal.getMethod().split(",");
				Set<String> methodSet = new HashSet<String>(Arrays.asList(method));
				if(methodSet.contains("0")){
					sb2.append("  " + new String(code, 1, 1) + "  《数字化设备证据数据发现提取固定方法》GA/T756-2008");
				}else{
					sb2.append("  " + new String(code, 0, 1) + "  《数字化设备证据数据发现提取固定方法》GA/T756-2008");
				}
				
				if(methodSet.contains("1")){
					sb2.append("  " + new String(code, 1, 1) + "  《电子物证搜索检验技术规范》GB/T29362-2012");
				}else{
					sb2.append("  " + new String(code, 0, 1) + "  《电子物证搜索检验技术规范》GB/T29362-2012");
				}
				
				if(methodSet.contains("2")){
					sb2.append("  " + new String(code, 1, 1) + "  《电子物证恢复检验技术规范》GB/T29360-2012");
				}else{
					sb2.append("  " + new String(code, 0, 1) + "  《电子物证恢复检验技术规范》GB/T29360-2012");
				}
		  
	
				if(null != appraisal.getMethodOther()  && !"".equals(appraisal.getMethodOther())){
					sb2.append("  " + new String(code, 1, 1) + "  其他要求说明："+checkNull(appraisal.getMethodOther()).toString() +"");
				}else{
					sb2.append("  " + new String(code, 0, 1) + "  其他要求说明："+checkNull(appraisal.getMethodOther()).toString() +"");
				}
				 
				run2.setText(checkNull(sb2.toString()).toString());
				run2.addBreak();
				
				XWPFParagraph paragraph3 = cell091.addParagraph();
				XWPFRun run3 = paragraph3.createRun();
				StringBuffer sb3 = new StringBuffer();
				sb3.append("3、结果要求	："); 
				String[] rqmt = appraisal.getRqmt().split(",");
				Set<String> rqmtSet = new HashSet<String>(Arrays.asList(rqmt));
				if(rqmtSet.contains("0")){
					sb3.append("  " + new String(code, 1, 1) + "  出具检验报告");
				}else{
					sb3.append("  " + new String(code, 0, 1) + "  出具检验报告");
				}
				
				if(rqmtSet.contains("1")){
					sb3.append("  " + new String(code, 1, 1) + "  出具鉴定意见书");
				}else{
					sb3.append("  " + new String(code, 0, 1) + "  出具鉴定意见书");
				}
				
				if(rqmtSet.contains("2")){
					sb3.append("  " + new String(code, 1, 1) + "  只提取电子数据");
				}else{
					sb3.append("  " + new String(code, 0, 1) + "  只提取电子数据");
				}
		  
	
				if(null != appraisal.getRqmtOther()  && !"".equals(appraisal.getRqmtOther())){
					sb3.append("  " + new String(code, 1, 1) + "  其他要求说明："+checkNull(appraisal.getRqmtOther()).toString() +"");
				}else{
					sb3.append("  " + new String(code, 0, 1) + "  其他要求说明："+checkNull(appraisal.getRqmtOther()).toString() +"");
				}
				run3.setText(checkNull(sb3.toString()).toString());
				run3.addBreak();
				//检验鉴定事项--end
				
				table0.getRow(10).getCell(1).setText(checkNull(preappraisal.getRqmt()).toString());//简要说明//检验鉴定要求
				table0.getRow(11).getCell(1).setText(checkNull(preappraisal.getRemarks()).toString());//简要说明//检验鉴定要求
				
				/**  第一个表格--end**/
				
				/**  第二个表格--start**/
				//提交的文件资料
				List<PreappraisalAtt> attList = preappraisalAttService.getPreappraisalAtts(appraisal.getPreappraisalId());
				
				XWPFTable table1 = tables.get(2);
				if(attList.size() > 0){
				   for (int i = 0; i < attList.size(); i++) {
					   XWPFTableRow row = table1.createRow(1);
						// 获取到刚刚插入的行
						row.getCell(0).setText(i+1+"");
						row.getCell(1).setText("受理/立案/法律措施材料");
						row.getCell(2).setText(checkNull(attList.get(i).getName()).toString());
						row.getCell(3).setText("壹份");
						row.getCell(4).setText("");
				    }
				} 
				/**  第二个表格--end**/
				
				/**  第三个表格--end**/
				//检材明细
				List<PreappraisedEvid> evidList= preappraisedEvidService.getPreappraisedEvids(appraisal.getPreappraisalId());
				
				// 这里简单取第一个表格
				XWPFTable table2 = tables.get(3);
				
				PreappraisedEvid evid = preappraisedEvidService.getPreappraisedEvid(appraisal.getPreappraisalId(),appraisal.getEvidSn());
				
				if(evid != null){
					   XWPFTableRow row = table2.createRow(1);
						// 获取到刚刚插入的行
						row.getCell(0).setText("1"); 
 						XWPFTableCell cell221  = row.getCell(1);//简要说明
						XWPFParagraph paragraphType = cell221.addParagraph();
						XWPFRun runType = paragraphType.createRun();
						StringBuffer sb4 = new StringBuffer();
						String type = evid.getType();
						Set<String> typeSet = new HashSet<String>();
						typeSet.add("电脑主机");
						typeSet.add("笔记本电脑");
						typeSet.add("移动硬盘");
						typeSet.add("硬盘");
						typeSet.add("U盘");
						typeSet.add("SD存储卡（闪存）");
						typeSet.add("手机");
						typeSet.add("平板电脑");
						typeSet.add("SIM卡");
						typeSet.add("数码设备(录音笔、相机、摄像机等)");
						typeSet.add("伪基站设备");
 						for (String str : typeSet) {
							if(str.equals(type)){
								sb4.append("  " + new String(code, 1, 1) + "  "+type+"");
							}else{
								sb4.append("  " + new String(code, 0, 1) + "  "+str+"");
							}
						}
						if(evid.getTypeOther() != null && !"".equals(evid.getTypeOther())){
							sb4.append("  " + new String(code, 1, 1) + "  其他："+evid.getTypeOther()+"");
						}else{
							sb4.append("  " + new String(code, 0, 1) + "  其他");
						}
						runType.setText(sb4.toString());
						runType.addBreak();  
						row.getCell(2).setText("壹份");
						row.getCell(3).setText("");
				    
				} 
				 
			fileInputStream.close();
			//写到目标文件
			OutputStream output = new FileOutputStream(outConfirmationPath);
			document.write(output);
			output.close();
			
			AppraisalDoc confirmationDoc = new AppraisalDoc(); 
			confirmationDoc.setName("鉴定事项确认书.docx");
			confirmationDoc.setAppraisalId(appraisal.getId());
			confirmationDoc.setCreatorAlias(curr.getUserAlias());
			confirmationDoc.setCreatorId(curr.getUserId());
			confirmationDoc.setCreatorName(curr.getUserName());
			confirmationDoc.setExt("docx");
			confirmationDoc.setPath(outConfirmationPath);
			confirmationDoc.setType(AppraisalDoc.CONFIRMATION);
			docList.add(confirmationDoc);
			 
			status = appraisalDocService.saveAppraisalDoc(docList);
			
			} catch (Exception e) {
	 			e.printStackTrace();
	 			return status;
			}
		} 
		return status;
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
	
	
	public Object checkNull(Object object){
		return object == null ? "" : object;
	}
	
	public ArchiveCode getArchiveCodeById(String appraisalId, String agency, String year){
		List<ArchiveCode> reusltList = new ArrayList<ArchiveCode>();
		DecimalFormat df = new DecimalFormat("0000");
		ArchiveCode archiveCode = null ;
		agency = "中止";
		try{
			reusltList = archiveCodeService.getArchiveCodesByAgencyAndYear(agency, year); 
			if( reusltList.size() > 0 ){
			    archiveCode = reusltList.get(0); 
				archiveCode.setCreatedDate(new Date());
				Integer sn = Integer.valueOf(archiveCode.getSn())+1;
				archiveCode.setSn(df.format(sn));
				archiveCode.setAppraisalId(appraisalId);
				archiveCode.setId(null);
				archiveCodeService.saveArchiveCode(archiveCode);
 			}else{
 				archiveCode =new ArchiveCode();
 				archiveCode.setSn(df.format(1));
				archiveCode.setAppraisalId(appraisalId);
 				archiveCode.setAgency(agency);
				archiveCode.setYear(year);
				archiveCodeService.saveArchiveCode(archiveCode);
 			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return archiveCode == null ? new ArchiveCode() : archiveCode;
	}
	
	/**
	 * 是否为已提交预检信息
	 * @author Oscar Mok
	 * @param preappraisalId 预检信息ID
	 * @return 已提交预检信息的判断状态
	 * */
	private boolean isSubmittedPreappraisal(String preappraisalId) {
		try {
			if ( preappraisalId != null 
					&& !preappraisalId.trim().equals("") ) {
				Preappraisal preappraisal = preappraisalService.getPreappraisalById(preappraisalId);
				if ( preappraisal != null ) {
					if ( preappraisal.getStatus().intValue() == Preappraisal.OFFICIAL ) return true;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据鉴定信息初始化流程实例
	 * @author Oscar Mok
	 * @param appraisal 鉴定信息对象
	 * */
	private void initProcessInstance(Appraisal appraisal) {
		try {
			if ( isSubmittedPreappraisal(appraisal.getPreappraisalId()) ) {
				if ( !(appraisal.getProcInstId() != null 
						&& !appraisal.getProcInstId().trim().equals("")) ) {
					String procInstId = workflow.initProcessInstanceByKey(Const.PROC_DEFN);
					if ( procInstId != null && !procInstId.trim().equals("") ) {
						appraisal.setProcInstId(procInstId);
						appraisalService.saveAppraisal(appraisal); //Update appraisal data
					}
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/***
	 *  获取分析图预检历史数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_HISTORY_APPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getHistoryAnalysis(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> dateList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = appraisalService.getHistoryYearAnalysis(null);
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
	@RequestMapping(NavConst.ELEC_MGT_GET_YEAR_APPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getYearAnalysis(String year){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> dateList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = appraisalService.getHistoryYearAnalysis(year);
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
	@RequestMapping(NavConst.ELEC_MGT_GET_COUNTRY_APPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getYearAnalysis(String year,String month){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> nameList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = appraisalService.getCountryAnalysis(year,month);
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
	 *  获取分析图检材类别的数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_ACCEPTED_APPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getAcceptedAnalysis(String year,String month){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> typeList =new ArrayList<String>();
		List<String> numberList =new ArrayList<String>();
		List<Map<String ,Object>> list =new ArrayList<Map<String,Object>>();
		Map<String ,List<String>> data =new HashMap<String,List<String>>();
		
		try{
		    data =  appraisalService.getAppraisalsTypeAnalysis(year,month);
		    typeList = data.get("type");
		    numberList = data.get("number");
		    Map<String, Object> value = null;
		    for (int i = 0 ; i < typeList.size() ; i++) {
		    	value = new HashMap<String, Object>();
		    	value.put("name", typeList.get(i));
		    	value.put("value", numberList.get(i));
		    	list.add(value);
			}
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", null);
 		}
		return result;
	}  
	
	/***
	 *  获取分析图预检历史数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_ACCEPTED_OK_APPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getHistoryAcceptOKAnalysis(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> dateList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = appraisalService.getAcceptedOKYearAnalysis(null);
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
	@RequestMapping(NavConst.ELEC_MGT_GET_YEAR_ACCRPTED_OK_APPRAISAL_DATA)
	@ResponseBody
	public Map<String, Object> getYearAcceptOKAnalysis(String year){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> dateList = new ArrayList<String>();
		try{
			 Map<String,List<String>>  data = appraisalService.getAcceptedOKYearAnalysis(year);
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
	 *  获取分析图预检历史年数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_IDENTIFY_RESULTS_DATA)
	@ResponseBody
	public Map<String, Object> getIdentifyResultsAnalysis(String year,String month,String country){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> typeList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();
		try{
			 Map<String,Object>  data = appraisalService.getIdentifyResultsAnalysis(year,month,country);
			 typeList.add("不受理鉴定");
			 typeList.add("中止鉴定");
			 typeList.add("完成鉴定");
			 numberList.add(data.get("no").toString());
			 numberList.add(data.get("stop").toString());
			 numberList.add(data.get("ok").toString());
			result.put("type", typeList);
			result.put("number", numberList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("type", null);
			result.put("number", null);
		}
		return result;
	}  
	
	/***
	 *  获取分析图  年 各区受理成功建材数 数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_COUNTRY_ACCEPTED_OK_DATA)
	@ResponseBody
	public Map<String, Object> getAcceptedOKCountryAnalysis(String year,String month){
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> typeList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();
		List<Map<String ,Object>> list =new ArrayList<Map<String,Object>>();
		Map<String ,List<String>> data =new HashMap<String,List<String>>();
		
		try{
		    data = appraisalService.getAcceptedOKONCountryAnalysis(year,month);
		    typeList = data.get("name");
		    numberList = data.get("number");
		    Map<String, Object> value = null;
		    for (int i = 0 ; i < typeList.size() ; i++) {
		    	value = new HashMap<String, Object>();
		    	value.put("name",countyService.getCountyByCountyId(typeList.get(i)).getName());
		    	value.put("value", numberList.get(i));
		    	list.add(value);
			} 
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
		 
		}
		return result;
	}  
	
	/***
	 *  获取分析图  年 各区受理成功建材数 数据源
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_APPRAISALS_BY_PREAPPRAISALID_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalsByPreappraisalId(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Appraisal> list = new ArrayList<Appraisal>();
		 if(null != id && !"".equals(id)){
			 list = appraisalService.getAppraisalsByPreappraisedId(id);
		 }
        result.put("entity", list);		 
		return result;
	} 
	
	/***
	 * 发送短信
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_GET_APPRAISALS_SEND_MESSAGE)
	@ResponseBody
	public Map<String, Object> sendMessage(String id){
 		Map<String, Object> result = new HashMap<String, Object>();
 		boolean status = false;
 		String message = "";
 		 List<String> cellPhones = new ArrayList<String>();
 		if(null  != id && !"".equals(id)){
 			Appraisal appraisal =  appraisalService.getAppraisalById(id);
 			if(appraisal != null){
 			 Preappraisal preappraisal = preappraisalService.getPreappraisalById(appraisal.getPreappraisalId());	
 			 boolean stop = appraisalDocService.getAppDocByTypeAndAppraisalId(AppraisalDoc.STOP_NOTIFICATION , id);
 			 if(stop){
 				message = "您的检材已中止鉴定，请尽快到场领取您的检材!";
 			 }else{
 				message = "您的检材已完成鉴定，请尽快到场领取您的检材。";
 			 }
 			 if(preappraisal != null){
 				cellPhones.add(preappraisal.getTel());
 			 }
 			 
 			}
 			if(!message.equals("")&&cellPhones.size()>0&&appraisal.getStatus().intValue() == Appraisal.RESULT_FEEDBACK){
 				MessageSender.send(message,cellPhones );
 				status = true;
 			}
 		}  
        result.put("status", status);		 
		return result;
	}
	
}