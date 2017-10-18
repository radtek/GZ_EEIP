package org.pangolin.eeip.web.controller;

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
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserTrainingAtt;
import org.pangolin.eeip.service.UserTrainingAttService;
import org.pangolin.eeip.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
 
@Controller
@SuppressWarnings("all")
public class UserTrainingAttController extends BaseController {

	@Autowired
	private UserTrainingAttService userTrainingAttService;
	
	  
	
	/**
	 * 加载培训附件
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定培训附件数据JSON
	 * */
	@RequestMapping(NavConst.USERTRAININGATT_MGT_GET_BY_TRA_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingAttByTraIdListData(String userTrainingId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<UserTrainingAtt> resultList = new ArrayList<UserTrainingAtt>();
		if ( userTrainingId != null && !userTrainingId.trim().equals("") ) {
			resultList = userTrainingAttService.getUserTrainingAttsByTraId(userTrainingId); 
		}
		resultMap.put("entity",resultList);
		return resultMap;
	}
	
	/**
	 * 保存培训附件数据
	 * @author Xiaolin Yin
	 * @param UserTrainingAtt 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERTRAININGATT_MGT_UPLOAD_DATA)
	@ResponseBody
	public Map<String, Object> uploadUserTrainingAttData(@RequestParam("file") MultipartFile file,String userBasicInfoId,String userTrainingId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		HttpServletRequest request=	getRequest();
		HttpSession session = request.getSession();
		CurrentUser currentUser =(CurrentUser)session.getAttribute("loginUser");
		boolean status=false;
		 if (!file.isEmpty()) {  
			    String path=FileUtil.uploadFile(Const.EXPERT_DOC_PATH + "/", file);
	            String fileName = file.getOriginalFilename();  
	            String fileExtension = FilenameUtils.getExtension(fileName);  
	            UserTrainingAtt att=new UserTrainingAtt();
	            att.setDelFlag(UserTrainingAtt.NORMAL);
	            att.setCreatedDate(new Date());
		        att.setExt(fileExtension);
		        att.setName(fileName);
		        att.setPath(path);
		        att.setUserBasicInfoId(userBasicInfoId);
		        att.setUserTrainingId(userTrainingId);
		        att.setCreatorAlias(currentUser.getUserAlias());
		        att.setCreatorId(currentUser.getUserId());
		        att.setCreatorName(currentUser.getUserName());
		        status=userTrainingAttService.saveUserTrainingAtt(att);
		        resultMap.put("name", fileName); 
		        resultMap.put("id", att.getId()); 
		 }  
		resultMap.put("status", status); 
		
		return resultMap;
	}
 
	 
	
	/***
	 * 根据附件ID下载附件信息
	 * @param response
	 * @param attachmentId
	 */
	@RequestMapping(NavConst.USERTRAININGATT_MGT_DOWNLOAD_DATA)
	@ResponseBody
	public void download(HttpServletResponse response, String id){
		UserTrainingAtt att = userTrainingAttService.getUserTrainingAttById(id);
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
	
	/**
	 * 删除培训附件数据
	 * @author Xiaolin Yin
	 * @param id UserTrainingAtt 主键ID
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERTRAININGATT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserTrainingAtt(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		 if (null!=id&&!"".equals(id)){
			 status = userTrainingAttService.removeUserTrainingAttFalse(id);
		 }  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	
}
