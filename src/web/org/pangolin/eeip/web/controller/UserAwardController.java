package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserAward;
import org.pangolin.eeip.entity.UserWorkExp;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.UserAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserAwardController extends BaseController{

	@Autowired
	private UserAwardService userAwardService;
	
	
 
	/**
	 * 加载主要获奖
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定主要获奖数据JSON
	 * */
	@RequestMapping(NavConst.USERAWARD_MGT_GET_USERAWARD_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserAwardDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserAward userAward = userAwardService.getUserAwardById(id);  
			resultMap.put("entity", ( userAward != null ) ? userAward : new UserAward());
		} else{ 
			resultMap.put("entity", new UserAward());
		}
		return resultMap;
	}
	
	/**
	 * 加载主要获奖列表
	 * @author Xiaolin Yin
	 * @param userBasicInfoId userID
	 * @return 指定主要获奖数据JSON
	 * */
	@RequestMapping(NavConst.USERAWARD_MGT_GET_BY_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserAwardListDataById(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<UserAward> resultList = new ArrayList<UserAward>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			 resultList = userAwardService.getUserAwardsByUserId(userBasicInfoId); 
		}
		resultMap.put("entity",resultList);
		return resultMap;
	}
	
	
	/**
	 * 保存主要获奖数据
	 * @author Xiaolin Yin
	 * @param UserAward 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERAWARD_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserawardData(@RequestBody UserAward userAward) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if( userAward != null ){
			status=userAwardService.saveUserAward(userAward);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除主要获奖记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.USERAWARD_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserAwardById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) {
			status = userAwardService.removeUserAwardFalse(id);
			resultMap.put("status", status);
		} else { 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 获奖情况表单页面导航
	 * */
	@RequestMapping(NavConst.WINNING_SITUATION_MGT_FORM)
	public ModelAndView getWinningSituationMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/winningSituation");
    }
	
	/**
	 * 获奖情况表单详情页面导航
	 * */
	@RequestMapping(NavConst.WINNING_SITUATION_MGT_VIEW)
	public ModelAndView getWinningSituationView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/winningSituationView");
    }
}
