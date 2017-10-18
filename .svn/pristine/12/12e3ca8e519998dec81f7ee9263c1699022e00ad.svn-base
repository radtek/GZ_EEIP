package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserWorks;
import org.pangolin.eeip.service.UserWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserWorksController extends BaseController {

	@Autowired
	private UserWorksService userWorksService;
	
	/**
	 * 著作报告列表数据源
	 * @author Xiaolin Yin
	 * @return 著作报告数据集JSON
	 * */
	//@RequestMapping(NavConst.UserWorks_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorksListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserWorks> resultList = new ArrayList<UserWorks>();
		 
		totalCount = userWorksService.getUserWorksQty();
		resultList = userWorksService.getUserWorkss( params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection() );
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载著作报告
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定著作报告数据JSON
	 * */
	@RequestMapping(NavConst.USERWORKS_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorksDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserWorks userWorks = userWorksService.getUserWorksById(id);  
			resultMap.put("entity", ( userWorks != null ) ? userWorks : new UserWorks());
		} else{ 
			resultMap.put("entity", new UserWorks());
		}
		return resultMap;
	}
	
	/**
	 * 保存著作报告数据
	 * @author Xiaolin Yin
	 * @param UserWorks 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERWORKS_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveStoppageData(@RequestBody UserWorks userWorks) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if (userWorks != null ) {
			status = userWorksService.saveUserWorks(userWorks);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除著作报告记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.USERWORKS_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserWorksById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) {
			status = userWorksService.removeUserWorksFalse(id);
			resultMap.put("status", status);
		} else { 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 加载著作报告集合通过userBasicInfoId
	 * @author Xiaolin Yin
	 * @param userBasicInfoId
	 * @return 指定著作报告数据JSON
	 * */
	@RequestMapping(NavConst.USERWORKS_MGT_GET_BY_USER_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserWorksListDataById(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		List<UserWorks> resultList = new ArrayList<UserWorks>();
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			  resultList = userWorksService.getUserWorksByUserId(userBasicInfoId);
		}
		resultMap.put("entity", resultList); 
		return resultMap;
	}
	
	/**
	 * 著作报告表单页面导航
	 * */
	@RequestMapping(NavConst.WRITINGS_REPORT_MGT_FORM)
	public ModelAndView getWritingsReportMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/writingsReport");
    }
	
	/**
	 * 著作报告表单详情页面导航
	 * */
	@RequestMapping(NavConst.WRITINGS_REPORT_MGT_VIEW)
	public ModelAndView getWritingsReportView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/writingsReportView");
    }
}
