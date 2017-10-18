package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserBasicInfo;
import org.pangolin.eeip.entity.UserCertificate;
import org.pangolin.eeip.entity.UserDetail;
import org.pangolin.eeip.entity.UserTrainingAtt;
import org.pangolin.eeip.service.UserBasicInfoService;
import org.pangolin.eeip.service.UserDetailService;
import org.pangolin.eeip.service.UserService;
import org.pangolin.eeip.util.FileUtil;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserBasicInfoController extends BaseController {
	
	@Autowired
	private UserBasicInfoService userBasicInfoService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 人员基本情况数据源
	 * @author Xiaolin Yin
	 * @return 人员基本数据集JSON
	 * */
	@RequestMapping(NavConst.USERBASICINFO_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserBasicInfoListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserBasicInfo> resultList = new ArrayList<UserBasicInfo>();
		String queryParam = params.getExtraParam("queryParam");
		totalCount=userBasicInfoService.getUserBasicInfoQty(queryParam);
		resultList=userBasicInfoService.getUserBasicInfos(queryParam,params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载人员基本信息
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定人员基本数据JSON
	 * */
	@RequestMapping(NavConst.USERBASICINFO_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserBasicInfoDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserBasicInfo userBasicInfo = userBasicInfoService.getUserBasicInfoById(id);  
			resultMap.put("entity", ( userBasicInfo != null ) ? userBasicInfo : new UserBasicInfo(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new UserBasicInfo(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 加载人员基本信息
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定人员基本数据JSON
	 * */
	@RequestMapping(NavConst.USERBASICINFO_MGT_GET_BY_USER_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserBasicInfoDataByUserId(String userId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userId != null && !userId.trim().equals("") ) {
			UserBasicInfo userBasicInfo = userBasicInfoService.getUserBasicInfoByUserId(userId);  
			resultMap.put("entity", ( userBasicInfo != null ) ? userBasicInfo : new UserBasicInfo(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new UserBasicInfo(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 加载人员基本
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定人员基本数据JSON
	 * */
	@RequestMapping(NavConst.USERBASICINFO_MGT_GET_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserBasicInfoGetListData() {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		 List<UserBasicInfo> resultList=new ArrayList<UserBasicInfo>();
		 resultList = userBasicInfoService.getUserBasicInfos();
			resultMap.put("entity", resultList);
		 
		return resultMap;
	}
	
	/**
	 * 保存人员基本数据
	 * @author Xiaolin Yin
	 * @param UserBasicInfo 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERAUTHORIZATION_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserBasicInfoData(@RequestBody UserBasicInfo userBasicInfo) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		status=userBasicInfoService.saveUserBasicInfo(userBasicInfo);
		/*if(userBasicInfo!=null){
				UserDetail userDetail = userDetailService.getUserDetailByPoliceId(userBasicInfo.getPoliceId());
				User user = userService.getUserById(userDetail.getUserId());
				if(userDetail!=null){
					userBasicInfo.setUserId(userDetail.getUserId());
					userBasicInfo.setUserName(user.getUserName());
					userBasicInfo.setUserAlias(user.getUserAlias());
					
				}   
		}  */
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 查询人员信息
	 * @author Xiaolin Yin
	 * @param UserBasicInfo 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.PSNLINFO_USERBASICINFO_GETUSERBASICINFOBYPOLICEID)
	@ResponseBody
	public Map<String, Object> getUserBasicInfoDataByPoliceId(String policeId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(policeId != null && policeId != ""){
			UserDetail userDetail = userDetailService.getUserDetailByPoliceId(policeId);
			resultMap.put("entity", userDetail); 
		}
		return resultMap;
	}
	
	/**
	 * 保存培训附件数据
	 * @author Xiaolin Yin
	 * @param UserTrainingAtt 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERBASICINFO_MGT_UPLOAD_AVATAR_DATA)
	@ResponseBody
	public Map<String, Object> uploadUserTrainingAttData(@RequestParam("file") MultipartFile file, String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		HttpServletRequest request=	getRequest();
		HttpSession session = request.getSession();
		CurrentUser currentUser =(CurrentUser)session.getAttribute("loginUser");
		boolean status=false;
		 if (!file.isEmpty()) {  
			    String path=FileUtil.uploadFile(Const.USERBASICINFO_AVATAR_PATH + "/", file); 
		        resultMap.put("path", path);  
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
	@RequestMapping(NavConst.USERBASICINFO_MGT_LOAD_AVATAR_DATA)
	@ResponseBody
	public void getImage(String path, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (path != null && (!path.trim().equals(""))) {
				 
 					File file = new File(path);
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
	
	 
	
	/**
	 * 人员基本情况登记表单页面导航
	 * */
	@RequestMapping(NavConst.PERSONNEL_REGISTER_MGT_FORM)
	public ModelAndView getPersonnelRegisterFormMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/personnelRegisterForm");
    }
	
	/**
	 * 人员基本情况登记列表页面导航
	 * */
	@RequestMapping(NavConst.PERSONNEL_INFO_MGT_LIST)
	public ModelAndView getPersonnelInfoListMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/personnelInfoList");
    }
	
	/**
	 * 人员基本情况查看页面导航
	 * */
	@RequestMapping(NavConst.PERSONNEL_INFO_MGT_VIEW)
	public ModelAndView getPersonnelInfoViewMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/personnelRegisterView");
    }
}
