package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserTraining;
import org.pangolin.eeip.entity.UserTrainingExp;
import org.pangolin.eeip.service.UserTrainingExpService;
import org.pangolin.eeip.service.UserTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings("all")
public class UserTrainingExpController extends BaseController{

	@Autowired
	private UserTrainingExpService userTrainingExpService;
	
	@Autowired
	private UserTrainingService userTrainingService;
	
	/**
	 * 培训经历列表数据源
	 * @author Xiaolin Yin
	 * @return 培训经历数据集JSON
	 * */
	//@RequestMapping(NavConst.UserTrainingExp_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingExpListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserTrainingExp> resultList = new ArrayList<UserTrainingExp>();
		 
		totalCount=userTrainingExpService.getUserTrainingExpQty();
		resultList=userTrainingExpService.getUserTrainingExps(params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载培训经历
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定培训经历数据JSON
	 * */
	@RequestMapping(NavConst.USERTRAININGEXP_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingExpDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserTrainingExp userTrainingExp = userTrainingExpService.getUserTrainingExpById(id);  
			resultMap.put("entity", ( userTrainingExp != null ) ? userTrainingExp : new UserTrainingExp());
		} else{ 
			resultMap.put("entity", new UserTrainingExp());
		}
		return resultMap;
	}
	
	/**
	 * 保存培训经历数据
	 * @author Xiaolin Yin
	 * @param UserTrainingExp 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERTRAININGEXP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserTrainingExpData(@RequestBody UserTrainingExp userTrainingExp) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if( userTrainingExp != null ){
			status = userTrainingExpService.saveUserTrainingExp(userTrainingExp);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除培训经历记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.USERTRAININGEXP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserTrainingExpById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) {
			status = userTrainingExpService.removeUserTrainingExpFalse(id);
			resultMap.put("status", status);
		} else{ 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 加载培训履历集合通过userBasicInfoId
	 * @author Xiaolin Yin
	 * @param userBasicInfoId
	 * @return 指定培训履历数据JSON
	 * */
	@RequestMapping(NavConst.USERTRAININGEXP_MGT_GET_BY_USER_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingExpListDataById(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<UserTrainingExp> resultList=new ArrayList<UserTrainingExp>();
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			resultList =userTrainingExpService.getUserTrainingExpsByUserId(userBasicInfoId);  
		}
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	
}
