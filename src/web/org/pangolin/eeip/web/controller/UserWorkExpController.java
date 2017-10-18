package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserWorkExp;
import org.pangolin.eeip.service.UserWorkExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserWorkExpController extends BaseController {

	@Autowired
	private UserWorkExpService userWorkExpService;
	
	/**
	 * 工作经历列表数据源
	 * @author Xiaolin Yin
	 * @return 工作经历数据集JSON
	 * */
	//@RequestMapping(NavConst.UserWorkExp_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorkExpListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserWorkExp> resultList = new ArrayList<UserWorkExp>();
		 
		totalCount=userWorkExpService.getUserWorkExpQty();
		resultList=userWorkExpService.getUserWorkExps(params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载工作经历
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定工作经历数据JSON
	 * */
	@RequestMapping(NavConst.USERWORKEXP_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorkExpDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserWorkExp userWorkExp = userWorkExpService.getUserWorkExpById(id);  
			resultMap.put("entity", ( userWorkExp != null ) ? userWorkExp : new UserWorkExp());
		} else{ 
			resultMap.put("entity", new UserWorkExp());
		}
		return resultMap;
	}
	
	/**
	 * 通过UserID加载工作经历
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定工作经历数据JSON
	 * */
	@RequestMapping(NavConst.USERWORKEXP_MGT_GET_BY_USER_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorkExpDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			UserWorkExp userWorkExp = userWorkExpService.getUserWorkExpByUserId(userBasicInfoId);  
			resultMap.put("entity", ( userWorkExp != null ) ? userWorkExp : new UserWorkExp());
		} else{ 
			resultMap.put("entity", new UserWorkExp());
		}
		return resultMap;
	}
	
	/**
	 * 保存工作经历数据
	 * @author Xiaolin Yin
	 * @param UserWorkExp 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERWORKEXP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserWorkExpData(@RequestBody UserWorkExp userWorkExp) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if( userWorkExp != null ){
			status = userWorkExpService.saveUserWorkExp(userWorkExp);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除工作经历记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.USERWORKEXP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserWorkExpById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) {
			status = userWorkExpService.removeUserWorkExpFalse(id);
			resultMap.put("status", status);
		} else{ 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 加载工作经历
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定工作经历数据JSON
	 * */
	@RequestMapping(NavConst.USERWORKEXP_MGT_GET_BY_USER_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorkExpListDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<UserWorkExp> resultList=new ArrayList<UserWorkExp>();
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			resultList= userWorkExpService.getUserWorkExps(userBasicInfoId);  
		}  
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	
	
	
	/**
	 * 工作经历表单页面导航
	 * */
	@RequestMapping(NavConst.WORK_EXPERIENCE_MGT_FORM)
	public ModelAndView getWorkExperienceMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/workExperience");
    }
	
	/**
	 * 工作经历表单详情页面导航
	 * */
	@RequestMapping(NavConst.WORK_EXPERIENCE_MGT_VIEW)
	public ModelAndView getWorkExperienceView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/workExperienceView");
    }
}
