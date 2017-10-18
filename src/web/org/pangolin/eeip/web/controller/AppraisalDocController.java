package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AppraisalDoc;
import org.pangolin.eeip.service.AppraisalDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SuppressWarnings("all")
public class AppraisalDocController extends BaseController{
	
	@Autowired
	private AppraisalDocService appraisalDocService;
	
	public static Map<String,String> appraisalDocMap = new HashMap<String, String>();
	
	/***
	 * 保存设备附件表 234567
	 * @param devAttachment 设备附件对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALDOC_SAVEAPPRAISALDOCDATA)
	@ResponseBody	 
	public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String type,String appraisalReviseId,String appraisalId,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
        String saveDirectoryPath = Const.DOC_LIB_PATH;
        File saveDirectory = new File(saveDirectoryPath);
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_NAME);
        if (!file.isEmpty()) {  
            String fileName = file.getOriginalFilename();  
            String fileExt = FilenameUtils.getExtension(fileName);  
            File rootFile = new File(saveDirectory, fileName);
            String path = rootFile.getPath();
            try {
            	FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
            	AppraisalDoc appraisalDoc = new AppraisalDoc();
            	appraisalDoc.setAppraisalId(appraisalId);
            	appraisalDoc.setPath(path);
            	appraisalDoc.setName(fileName);
            	appraisalDoc.setExt(fileExt);
            	appraisalDoc.setType(Integer.valueOf(type));
            	appraisalDoc.setCreatedDate(new Date());
            	appraisalDoc.setCreatorAlias(currentUser.getUserAlias());
            	appraisalDoc.setCreatorName(currentUser.getUserName());
            	appraisalDoc.setCreatorId(currentUser.getUserId());
            	if(appraisalReviseId!= null && !"".equals(appraisalReviseId)){
            		appraisalDoc.setAppraisalReviseId(appraisalReviseId);
            	}
            	if(appraisalDocService.getAppraisalDocByTypeAndAppraisalId(Integer.valueOf(type),appraisalId) != null){
            		appraisalDocService.removeAppraisalDocFalse(Integer.valueOf(type),appraisalId);
            	}
            	appraisalDocService.saveAppraisalDoc(appraisalDoc);
            	map.put("name", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			} 
        }  
		return map;
	}
	
	/***
	 * 修改文书的文件上传  保存staticMap
	 * @param devAttachment 设备附件对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALDOC_SAVECHANGEAPPRAISALDOCDATA)
	@ResponseBody	 
	public Map<String,Object> uploadChangeFile(@RequestParam("file") MultipartFile file,String type,String appraisalId,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String saveDirectoryPath = Const.DOC_LIB_PATH;
		File saveDirectory = new File(saveDirectoryPath);
		CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_NAME);
		if (!file.isEmpty()) {  
			String fileName = file.getOriginalFilename();  
			String fileExt = FilenameUtils.getExtension(fileName);  
			File rootFile = new File(saveDirectory, fileName);
			String path = rootFile.getPath();
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
				AppraisalDoc appraisalDoc = new AppraisalDoc();
				appraisalDoc.setAppraisalId(appraisalId);
				appraisalDoc.setPath(path);
            	appraisalDoc.setName(fileName);
				appraisalDoc.setExt(fileExt);
				appraisalDoc.setType(Integer.valueOf(type));
				appraisalDoc.setCreatedDate(new Date());
				appraisalDoc.setCreatorAlias(currentUser.getUserAlias());
				appraisalDoc.setCreatorName(currentUser.getUserName());
				appraisalDoc.setCreatorId(currentUser.getUserId());
				if(appraisalDocService.getAppraisalDocByTypeAndAppraisalId(Integer.valueOf(type),appraisalId) != null){
					String appraisaDocId = appraisalDocService.getAppraisalDocByTypeAndAppraisalId(Integer.valueOf(type),appraisalId).getId();
					appraisalDocMap.put(appraisalId,appraisaDocId);
					appraisalDocService.removeAppraisalDocFalse(Integer.valueOf(type),appraisalId);
				}
				appraisalDocService.saveAppraisalDoc(appraisalDoc);
				map.put("name", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}  
		return map;
	}
	
	/***
	 * 下载附件的时候输出
	 * @param id attrId
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALDOC_DOWNAPPRAISALDOCDATA)
	@ResponseBody
	public void download(HttpServletResponse response, String type,String appraisalId){
		AppraisalDoc appraisalDoc = appraisalDocService.loadAppraisalDocByTypeAndAppraisalId(Integer.valueOf(type),appraisalId);
		if(appraisalDoc != null){
			String name = appraisalDoc.getName();
			response.setContentType("application/octet-stream");
			try { 
				name = URLEncoder.encode(name,"UTF-8");
				String path = appraisalDoc.getPath(); 
				response.reset(); 
				response.setHeader("Content-Disposition", "attachment;fileName="+name);
	            OutputStream os = response.getOutputStream();  
	            byte[] bytes = org.pangolin.util.FileUtil.readFile(path);
	            os.write(bytes);
	            os.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		}
	}

	/***
	 * 根据电子物证（检材）鉴定检材ID 查询文书列表
	 * @param appraisalId 鉴定检材ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_APPRAISALDOC_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalDocList(String appraisalId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AppraisalDoc> resultList = new ArrayList<AppraisalDoc>();
		try {
			resultList = appraisalDocService.getAppraisalDocs(appraisalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	/***
	 * 电子物证文书修改申请ID 查询文书列表
	 * @param appraisalReviseId 电子物证文书修改申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_APPRAISALDOC_REVISE_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAppraisalDocReviseList(String appraisalReviseId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AppraisalDoc> resultList = new ArrayList<AppraisalDoc>();
		try {
			resultList = appraisalDocService.getReviseAppraisalDocs(appraisalReviseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	/***
	 * 电子物证文书修改申请ID 查询文书列表
	 * @param appraisalReviseId 电子物证文书修改申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISAL_CHECKAPPDOCBYTYPEANDAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getAppDocByTypeAndAppraisalId(Integer type,String appraisalId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Boolean status = false;
		try {
			status = appraisalDocService.getAppDocByTypeAndAppraisalId(type,appraisalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("entity", status);
		return resultMap;
	}
	
	/***
	 * 下载附件的时候输出 通过appraisalReviseId
	 * @param appraisalReviseId  修改文书申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_MGT_APPRAISALDOC_DOWN_BY_REVISE_ID)
	@ResponseBody
	public void downloadRevise(HttpServletResponse response, String type,String appraisalReviseId){
		AppraisalDoc appraisalDoc = appraisalDocService.getAppraisalDocByReviseId(Integer.valueOf(type), appraisalReviseId);
		if(appraisalDoc != null){
			String name = appraisalDoc.getName();
			response.setContentType("application/octet-stream");
			try { 
				name = URLEncoder.encode(name,"UTF-8");
				String path = appraisalDoc.getPath(); 
				response.reset(); 
				response.setHeader("Content-Disposition", "attachment;fileName="+name);
	            OutputStream os = response.getOutputStream();  
	            byte[] bytes = org.pangolin.util.FileUtil.readFile(path);
	            os.write(bytes);
	            os.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		}
	}
	
	
}
