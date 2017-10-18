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
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserCertificate;
import org.pangolin.eeip.entity.UserTrainingAtt;
import org.pangolin.eeip.service.UserCertificateService;
import org.pangolin.eeip.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserCertificateController extends BaseController{

	@Autowired
	private UserCertificateService userCertificateService;
	
	 
	/**
	 * 根据UserID加载资格证书
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定资格证书数据JSON
	 * */
	@RequestMapping(NavConst.USERCERTIFICATE_MGT_GET_BY_USER_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserCertificateDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<UserCertificate> resultList=new ArrayList<UserCertificate>();
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			resultList = userCertificateService.getUserCertificatesByUserId(userBasicInfoId);  
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	
	/**
	 * 保存资格证书数据
	 * @author Xiaolin Yin
	 * @param UserCertificate 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERCERTIFICATE_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserCertificateData(@RequestParam("file") MultipartFile file,String userBasicInfoId,Integer type) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		HttpServletRequest request=	getRequest();
		HttpSession session = request.getSession();
		CurrentUser currentUser =(CurrentUser)session.getAttribute("loginUser");
		boolean status=false;
		 if (!file.isEmpty()) {  
			    String path=FileUtil.uploadFile(Const.CERTIFICATE_IMG_PATH + File.separatorChar, file);
	            String fileName = file.getOriginalFilename();  
	            String fileExtension = FilenameUtils.getExtension(fileName);  
	            UserCertificate att=new UserCertificate();
	            att.setDelFlag(UserCertificate.NORMAL);
	            att.setCreatedDate(new Date());
		        att.setExt(fileExtension);
		        att.setName(fileName);
		        att.setPath(path);
		        att.setType(type);
		        att.setUserBasicInfoId(userBasicInfoId);
		        att.setCreatorAlias(currentUser.getUserAlias());
		        att.setCreatorId(currentUser.getUserId());
		        att.setCreatorName(currentUser.getUserName());
		        status=userCertificateService.saveUserCertificate(att);
		        resultMap.put("name", fileName); 
		        resultMap.put("id", att.getId()); 
		 }  
		resultMap.put("status", status); 
		
		return resultMap;
	}
	
	/**
	 * 删除资格证书记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.USERCERTIFICATE_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserCertificateById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if ( id != null && !id.trim().equals("") ) {
			status = userCertificateService.removeUserCertificateFalse(id);
			resultMap.put("status", status);
		} else { 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 将本地图片转换成文件流，然后存入OutputStream
	 * 即，页面显示图片
	 * @param userId
	 * @param request
	 * @param response
	 */
	@RequestMapping(NavConst.USER_CERTIFICATE_IMAGE_LOAD)
	@ResponseBody
	public void getImage(String id, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (id != null && (!id.trim().equals(""))) {
				UserCertificate certificate=userCertificateService.getUserCertificateById(id);
 					File file = new File(certificate.getPath());
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
	@RequestMapping(NavConst.USER_CERTIFICATE_MGT_DOWNLOAD_DATA)
	@ResponseBody
	public void download(HttpServletResponse response, String id){
		UserCertificate att = userCertificateService.getUserCertificateById(id);
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
	 * 资格证书表单页面导航
	 * */
	@RequestMapping(NavConst.QUALIFICATION_MGT_FORM)
	public ModelAndView getQualificationMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/qualification");
    }
	
	/**
	 * 资格证书表单详情页面导航
	 * */
	@RequestMapping(NavConst.QUALIFICATION_MGT_VIEW)
	public ModelAndView getQualificationView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/qualificationView");
    }
}
