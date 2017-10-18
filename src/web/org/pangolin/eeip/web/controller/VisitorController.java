package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 来访人员管理Controller
 * @author Xiaolin Yin
 *
 */
@Controller
@SuppressWarnings("all")
public class VisitorController extends BaseController {

	@Autowired
	private VisitorService visitorService;
	
	/**
	 * 来访人员列表数据源
	 * @author Xiaolin Yin
	 * @return 来访人员数据集JSON
	 * */
	@RequestMapping(NavConst.VISITOR_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getVisitorListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<Visitor> resultList = new ArrayList<Visitor>();
		String queryParam = params.getExtraParam("queryParam");
		totalCount=visitorService.getVisitorListQty(queryParam);
		resultList=visitorService.getListVisitors(queryParam,params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载来访人员
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定来访人员数据JSON
	 * */
	@RequestMapping(NavConst.VISITOR_MGT_GET_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getVisitorDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			Visitor visitor = visitorService.getVisitorById(id);  
			resultMap.put("entity", ( visitor != null ) ? visitor : new Visitor());
		} else{ 
			resultMap.put("entity", new Visitor());
		}
		return resultMap;
	}
	
	/**
	 * 保存来访人员数据
	 * @author Xiaolin Yin
	 * @param visitor 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.VISITOR_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveStoppageData(@RequestBody Visitor visitor) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(visitor!=null){
			status=visitorService.saveVisitor(visitor);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除来访人员记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	@RequestMapping(NavConst.VISITOR_MGT_REMOVE_VISITOR_DATA)
	@ResponseBody
	public Map<String, Object> removeVisitorById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if ( id != null && !id.trim().equals("") ) {
			status=visitorService.removeVisitorFalse(id);
			resultMap.put("status", status);
		} else{ 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 来访人员登记表单页面导航
	 * */
	@RequestMapping(NavConst.VISITOR_MGT_FORM)
	public ModelAndView getVisitorRegisterFormMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/visitor/visitorRegisterForm");
    }
	
	/**
	 * 来访人员登记列表页面导航
	 * */
	@RequestMapping(NavConst.VISITOR_INFO_MGT_LIST)
	public ModelAndView getVisitorInfoListMV() { 
        return new ModelAndView("/pangolin/psnlInfoMgt/visitor/visitorInfoList");
    }
	
	/**
	 * 来访人员登记查看页面导航
	 * */
	@RequestMapping(NavConst.VISITOR_INFO_MGT_VIEW)
	public ModelAndView getVisitorInfoViewMV() { 
        return new ModelAndView("/pangolin/psnlInfoMgt/visitor/visitorRegisterView");
    }
}
