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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AppraisalAcptAtt;
import org.pangolin.eeip.entity.UserCertificate;
import org.pangolin.eeip.entity.UserTrainingAtt;
import org.pangolin.eeip.service.AppraisalAcptAttService;
import org.pangolin.eeip.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AppraisalAcptAttController extends BaseController {

	@Resource  
	private AppraisalAcptAttService appraisalAcptAttService;
	 
	
	/***
	 * 受理附件保存
	 * @param 
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_APPRAISALACPTATT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAppraisalAcptAtt(@RequestParam("file") MultipartFile file,String appraisalId){
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		HttpServletRequest request=	getRequest();
		HttpSession session = request.getSession();
		CurrentUser currentUser =(CurrentUser)session.getAttribute("loginUser");
		boolean status=false;
		 if (!file.isEmpty()) {  
			    String path=FileUtil.uploadFile(Const.EXPERT_DOC_PATH + "/", file);
	            String fileName = file.getOriginalFilename();  
	            String fileExtension = FilenameUtils.getExtension(fileName);  
	            AppraisalAcptAtt att=new AppraisalAcptAtt();
	            att.setCreatedDate(new Date());
		        att.setExt(fileExtension);
		        att.setName(fileName);
		        att.setPath(path);
		        att.setAppraisalId(appraisalId);
		        att.setCreatorAlias(currentUser.getUserAlias());
		        att.setCreatorId(currentUser.getUserId());
		        att.setCreatorName(currentUser.getUserName());
		        status=appraisalAcptAttService.saveAppraisalAcptAtt(att);
		        resultMap.put("name", fileName); 
		        resultMap.put("id", att.getId()); 
		 }  
		resultMap.put("status", status); 
		return resultMap; 
	}
	
	/***
	 * 根据ID查询  电子物证（检材）鉴定 
	 * @param id 电子物证（检材）鉴定 ID
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_LOAD_APPRAISALACPTATT_DATA_BY_APPRAISALID)
	@ResponseBody
	public Map<String, Object> getAppraisalAcptAttDataByappraisalId(String appraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		List<AppraisalAcptAtt> resultList=new ArrayList<AppraisalAcptAtt>();
		if(null!=appraisalId&&!"".equals(appraisalId)){
			resultList = appraisalAcptAttService.getAppraisalAcptAttsByAppraisalId(appraisalId);
		} 
		result.put("entity", resultList);
		return result;
	}
	
	/***
	 * 根据ID 查询  电子物证（检材）鉴定 
	 * @param id 电子物证（检材）鉴定 ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALACPTATT_LOADAPPRAISALACPTATTDATABYAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getAppraisalAcptAttData(String appraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		AppraisalAcptAtt appraisalAcptAtt = new AppraisalAcptAtt();
		if(appraisalId != null && !"".equals(appraisalId)){
			appraisalAcptAtt = appraisalAcptAttService.getAppraisalAcptAttData(appraisalId);
		}
		appraisalAcptAtt = appraisalAcptAtt == null ? new AppraisalAcptAtt() : appraisalAcptAtt;
		result.put("entity", appraisalAcptAtt);
		return result;
	}
	
	/**
	 * 将本地图片转换成文件流，然后存入OutputStream
	 * 即，页面显示图片
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(NavConst.ELEC_MGT_APPRAISAL_ACPT_ATT_IMAGE_GET_BY_ID)
	@ResponseBody
	public void getImage(String id, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (id != null && (!id.trim().equals(""))) {
				AppraisalAcptAtt att = appraisalAcptAttService.getAppraisalAcptAttById(id);
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
	 * 受理附件刪除 
	 * @param attId 
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_REMOVE_APPRAISALACPTATT_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> removeAppraisalAcptAttDataById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status=false;
		if(null!=id&&!"".equals(id)){
			status = appraisalAcptAttService.removeAppraisalAcptAttData(id);
		} 
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据附件ID下载附件信息
	 * @param response
	 * @param attachmentId
	 */
	@RequestMapping(NavConst.APPRAISAL_MGT_DOWNLOAD_APPRAISALACPTATT_DATA_BY_ID)
	@ResponseBody
	public void download(HttpServletResponse response, String id){
		AppraisalAcptAtt att = appraisalAcptAttService.getAppraisalAcptAttById(id);
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
	
}
