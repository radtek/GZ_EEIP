package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AppraisalAcptAtt;
import org.pangolin.eeip.entity.EvidOpLogAtt;
import org.pangolin.eeip.entity.UserAuthorization;
import org.pangolin.eeip.entity.UserCertificate;
import org.pangolin.eeip.service.EvidOpLogAttService;
import org.pangolin.eeip.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SuppressWarnings("all")
public class EvidOpLogAttController  extends BaseController{

	@Autowired 
	private EvidOpLogAttService evidOpLogAttService;
	
	/**
	 * 加载电子物证操作日志表附件
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定业务能力确认及授权数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDOPLOGATT_DATA_BY_APPRAISALID)
	@ResponseBody
	public Map<String, Object> getEvidOpLogAttDataByAppraisalId(String appraisalId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<EvidOpLogAtt> resultList = new ArrayList<EvidOpLogAtt>();
		if ( appraisalId != null && !appraisalId.trim().equals("") ) {
			resultList = evidOpLogAttService.getEvidOpLogAttByPreappraisalId(appraisalId);
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	/**
	 * 加载电子物证操作日志表附件
	 * @author Xiaolin Yin
	 * @param evidOpLogId 物证进出库日志附件
	 * @return 指定业务能力确认及授权数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDOPLOGATT_DATA_BY_EVIDOPLOGID)
	@ResponseBody
	public Map<String, Object> getEvidOpLogAttDataByevidOpLogId(String evidOpLogId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<EvidOpLogAtt> resultList = new ArrayList<EvidOpLogAtt>();
		if ( evidOpLogId != null && !evidOpLogId.trim().equals("") ) {
			resultList = evidOpLogAttService.getEvidOpLogAttByEvidOpLogId(evidOpLogId);
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	/**
	 * 加载电子物证操作日志表附件
	 * @author Xiaolin Yin
	 * @param evidOpLogId 物证进出库日志附件
	 * @return 指定业务能力确认及授权数据JSON
	 * */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EVIDOPLOGATT_GETEVIDOPLOGATTBYEVIDENCEID)
	@ResponseBody
	public Map<String, Object> getEvidOpLogAttByEvidenceId(String evidenceId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<EvidOpLogAtt> resultList = new ArrayList<EvidOpLogAtt>();
		if ( evidenceId != null && !evidenceId.trim().equals("") ) {
			resultList = evidOpLogAttService.getEvidOpLogAttByEvidenceId(evidenceId);
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	
	/**
	 * 进出库日志附件
	 * @author Xiaolin Yin
	 * @param UserAuthorization 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDOPLOGATT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveEvidOpLogAttData(@RequestParam("file") MultipartFile file,String evidOpLogId ,String evidId,String appraisalId,String preappraisalId,String evidTransitionId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		HttpServletRequest request=	getRequest();
		HttpSession session = request.getSession();
		CurrentUser currentUser =(CurrentUser)session.getAttribute("loginUser");
		boolean status=false;
		 if (!file.isEmpty()) {  
			    String path=FileUtil.uploadFile(Const.EXPERT_DOC_PATH + "/", file);
	            String fileName = file.getOriginalFilename();  
	            String fileExtension = FilenameUtils.getExtension(fileName);  
	            EvidOpLogAtt att=new EvidOpLogAtt();
	            att.setCreatedDate(new Date());
		        att.setExt(fileExtension);
		        att.setName(fileName);
		        att.setPath(path);
		        att.setAppraisalId(appraisalId);
		        att.setEvidId(evidId);
		        att.setCreatorAlias(currentUser.getUserAlias());
		        att.setCreatorId(currentUser.getUserId());
		        att.setCreatorName(currentUser.getUserName());
		        att.setEvidOpLogId(evidOpLogId);
		        att.setPreappraisalId(preappraisalId);
		        att.setEvidTransitionId(evidTransitionId);
		        status=evidOpLogAttService.saveEvidOpLogAtt(att); 
		        resultMap.put("name", fileName); 
		        resultMap.put("id", att.getId()); 
		 }  
		resultMap.put("status", status); 
		return resultMap; 
	}
	
	/**
	 * 将本地图片转换成文件流，然后存入OutputStream
	 * 即，页面显示图片
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(NavConst.EVIDOPLOGATT_IMAGE_LOAD)
	@ResponseBody
	public void getImage(String id, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (id != null && (!id.trim().equals(""))) {
				EvidOpLogAtt att=evidOpLogAttService.getEvidOpLogAttById(id);
 					File file = new File(att.getPath());
					if (file.exists() && file.canRead()) {
						FileInputStream inputStream = new FileInputStream(file);
						byte[] data = new byte[(int)file.length()];
				        inputStream.read(data);
				        inputStream.close();
				        response.setContentType("image/jpeg");
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
	 * 根据附件ID下载附件信息
	 * @param response
	 * @param attachmentId
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_DOWNLOAD_EVIDOPLOGATT_DATA_BY_ID)
	@ResponseBody
	public void download(HttpServletResponse response, String id){
		EvidOpLogAtt att = evidOpLogAttService.getEvidOpLogAttById(id);
		if(att != null){
			String name = att.getName();
			String ext = att.getExt();
			response.setContentType("application/octet-stream");
			try { 
				name = URLEncoder.encode(name,"UTF-8");
				String path = att.getPath(); 
				response.reset(); 
				response.setHeader("Content-Disposition", "attachment;fileName="+name);
	            OutputStream os=response.getOutputStream();  
	            byte[] bytes= org.pangolin.util.FileUtil.readFile(path);
	            os.write(bytes);
	            os.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		}
	}
	
	/***
	 * 进出库附件刪除 
	 * @param attId 
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_REMOVE_EVIDOPLOGATT_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> removeEvidOpLogAttDataById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status=false;
		if(null!=id&&!"".equals(id)){
			status = evidOpLogAttService.removeEvidOpLogAttById(id);
		} 
		result.put("status", status);
		return result;
	}
	
	
	
}
