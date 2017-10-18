package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserEvaluation;
import org.pangolin.eeip.service.UserEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserEvaluationController extends BaseController {

	@Autowired
	private UserEvaluationService userEvaluationService;
	
	/**
	 * 业务考核列表数据源
	 * @author Xiaolin Yin
	 * @return 业务考核数据集JSON
	 * */
	@RequestMapping(NavConst.USEREVALUATION_MGT_LIST_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserEvaluationListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserEvaluation> resultList = new ArrayList<UserEvaluation>();
		String userBasicInfoId = params.getExtraParam("userBasicInfoId");
		totalCount=userEvaluationService.getUserEvaluationQty(userBasicInfoId);
		resultList=userEvaluationService.getUserEvaluations(userBasicInfoId, params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载业务考核
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定业务考核数据JSON
	 * */
	@RequestMapping(NavConst.USEREVALUATION_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserEvaluationDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserEvaluation userEvaluation = userEvaluationService.getUserEvaluationById(id);  
			resultMap.put("entity", ( userEvaluation != null ) ? userEvaluation : new UserEvaluation());
		} else{ 
			resultMap.put("entity", new UserEvaluation());
		}
		return resultMap;
	}
	
	/**
	 * 加载业务考核
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定业务考核数据JSON
	 * */
	@RequestMapping(NavConst.USEREVALUATION_MGT_GET_BY_USER_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserEvaluationDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			UserEvaluation userEvaluation = userEvaluationService.getUserEvaluationByUserId(userBasicInfoId);  
			resultMap.put("entity", ( userEvaluation != null ) ? userEvaluation : new UserEvaluation());
		} else{ 
			resultMap.put("entity", new UserEvaluation());
		}
		return resultMap;
	}
	
	
	/**
	 * 保存业务考核数据
	 * @author Xiaolin Yin
	 * @param UserEvaluation 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USEREVALUATION_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveStoppageData(@RequestBody UserEvaluation userEvaluation) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(userEvaluation!=null){
			status=userEvaluationService.saveUserEvaluation(userEvaluation);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	 
	
	/**
	 * 业务考核表单页面导航
	 * */
	@RequestMapping(NavConst.BUSINESS_ASSESSMENT_MGT_FORM)
	public ModelAndView getBusinessAssessmentMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/businessAssessment");
    }
	
	/**
	 * 业务考核表单查看导航
	 * */
	@RequestMapping(NavConst.BUSINESS_ASSESSMENT_MGT_VIEW)
	public ModelAndView getBusinessAssessmentView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/businessAssessmentView");
    }
	
	/**
	 * 业务考核表单列表导航
	 * */
	@RequestMapping(NavConst.BUSINESS_ASSESSMENT_MGT_LIST)
	public ModelAndView getBusinessAssessmentList() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/businessAssessmentList");
    }
}
