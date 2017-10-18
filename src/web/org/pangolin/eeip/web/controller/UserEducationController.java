package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserEducation;
import org.pangolin.eeip.service.UserEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings("all")
public class UserEducationController extends BaseController{

	@Autowired
	private UserEducationService userEducationService;
	
	 
	
	/**
	 * 加载学历
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定学历数据JSON
	 * */
	@RequestMapping(NavConst.USEREDUCATION_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserEducationDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserEducation userEducation = userEducationService.getUserEducationById(id);  
			resultMap.put("entity", ( userEducation != null ) ? userEducation : new UserEducation());
		} else{ 
			resultMap.put("entity", new UserEducation());
		}
		return resultMap;
	}
	
	/**
	 * 加载学历通过人员信息
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定学历数据JSON
	 * */
	@RequestMapping(NavConst.USEREDUCATION_MGT_GET_BY_USERID_DATA)
	@ResponseBody
	public Map<String, Object> getUserEducationDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			UserEducation userEducation = userEducationService.getUserEducationByUserId(userBasicInfoId);
			resultMap.put("entity", ( userEducation != null ) ? userEducation : new UserEducation());
		} else{ 
			resultMap.put("entity", new UserEducation());
		}
		return resultMap;
	}
	
	
	/**
	 * 保存学历数据
	 * @author Xiaolin Yin
	 * @param UserEducation 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USEREDUCATION_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveStoppageData(@RequestBody UserEducation userEducation) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(userEducation!=null){
			status=userEducationService.saveUserEducation(userEducation);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
}
