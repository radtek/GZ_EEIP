package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.ImplPlan;
import org.pangolin.eeip.service.ImplPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImplPlanController extends BaseController {

	@Resource
	private ImplPlanService implPlanService;
	
	/***
	 * 保存内部审核实施计划信息
	 * @param meetingApp 内部审核实施计划对象
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLAN_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveImplPlan(@RequestBody ImplPlan implPlan) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = implPlanService.saveImplPlan(implPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内部审核实施计划ID获取内部审核实施计划信息
	 * @param id 内部审核实施计划ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLAN_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getImplPlan(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			ImplPlan implPlan = implPlanService.getImplPlan(id);
			implPlan = implPlan == null ? new ImplPlan() : implPlan;
			result.put("entity", implPlan);
		} catch(Exception e) {
			e.printStackTrace();
			result.put("entity", new ImplPlan());
		}
	
		return result;
	}
	
	/***
	 * 根据内部审核实施计划申请 ID获取内部审核实施计划
	 * @param id 内部审核实施计划申请 ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLAN_MGT_LIST_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getImplPlanList(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<ImplPlan> list = implPlanService.getImplPlansByAppId(id);
			result.put("entity", list);
		} catch(Exception e) {
			e.printStackTrace();
			result.put("entity", new ArrayList<ImplPlan>());
		}
	
		return result;
	}
	
	/***
	 * 根据内审实施计划ID删除内审实施计划信息
	 * @param id ID
	 */
	@RequestMapping(NavConst.IMPLPLAN_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String,Object> removeImplPlanById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = implPlanService.removeImplPlan(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
}
