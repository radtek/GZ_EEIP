package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserAuthorization;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.UserAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserAuthorizationController extends BaseController {
	
	@Autowired
	private UserAuthorizationService userAuthorizationService;
	
	
	/**
	 * 业务能力确认及授权列表数据源
	 * @author Xiaolin Yin
	 * @return 业务能力确认及授权数据集JSON
	 * */
	@RequestMapping(NavConst.USERAUTHORIZATION_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserAuthorizationListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserAuthorization> resultList = new ArrayList<UserAuthorization>();
		 
		totalCount=userAuthorizationService.getUserAuthorizationQty();
		resultList=userAuthorizationService.getUserAuthorizations(params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载业务能力确认及授权
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定业务能力确认及授权数据JSON
	 * */
	@RequestMapping(NavConst.USERAUTHORIZATION_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserAuthorizationDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserAuthorization userAuthorization = userAuthorizationService.getUserAuthorizationById(id);  
			resultMap.put("entity", ( userAuthorization != null ) ? userAuthorization : new UserAuthorization());
		} else{ 
			resultMap.put("entity", new UserAuthorization());
		}
		return resultMap;
	}
	
	/**
	 * 加载业务能力确认及授权
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定业务能力确认及授权数据JSON
	 * */
	@RequestMapping(NavConst.USERAUTHORIZATION_MGT_GET_BY_USER_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserAuthorizationDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			UserAuthorization userAuthorization = userAuthorizationService.getUserAuthorizationByUserId(userBasicInfoId);  
			resultMap.put("entity", ( userAuthorization != null ) ? userAuthorization : new UserAuthorization());
		} else{ 
			resultMap.put("entity", new UserAuthorization());
		}
		return resultMap;
	}
	
	
	/**
	 * 保存业务能力确认及授权
	 * @author Xiaolin Yin
	 * @param UserAuthorization 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERAUTHORIZATION_MGT_SAVE_VISITOR_DATA)
	@ResponseBody
	public Map<String, Object> saveUserAuthorizationData(@RequestBody UserAuthorization userAuthorization) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(userAuthorization!=null){
			status=userAuthorizationService.saveUserAuthorization(userAuthorization);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除业务能力确认及授权
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.USERAUTHORIZATION_MGT_REMOVE_VISITOR_DATA)
	@ResponseBody
	public Map<String, Object> removeVisitorById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if ( id != null && !id.trim().equals("") ) {
			status=userAuthorizationService.removeUserAuthorizationFalse(id);
			resultMap.put("status", status);
		} else{ 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 

	/**
	 * 业务能力确认及授权表单页面导航
	 * */
	@RequestMapping(NavConst.AUTHORIZE_MGT_FORM)
	public ModelAndView getAuthorizeMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/authorize");
    }
	
	/**
	 * 业务能力确认及授权表单详情页面导航
	 * */
	@RequestMapping(NavConst.AUTHORIZE_MGT_VIEW)
	public ModelAndView getAuthorizeView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/authorizeView");
    }
}
