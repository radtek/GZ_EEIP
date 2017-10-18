package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.service.AnnualPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnualPlanController extends BaseController {

	@Resource(name = "annualPlanService")
	private AnnualPlanService annualPlanService;
	
	/***
	 * 保存年度内部审核计划信息
	 * @param annualPlan 年度内部审核计划对象
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLAN_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAnnualPlan(@RequestBody AnnualPlan annualPlan) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = annualPlanService.saveAnnualPlan(annualPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据年度内部审核计划ID获取年度内部审核计划信息
	 * @param id 年度内部审核计划ID
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLAN_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getAnnualPlanDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			AnnualPlan annualPlan = annualPlanService.getAnnualPlanById(id);
			annualPlan = annualPlan == null ? new AnnualPlan() : annualPlan;
			result.put("entity", annualPlan);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new AnnualPlan());
		}
	
		return result;
	}
	
	/***
	 * 根据年度内部审核计划ID删除年度内部审核计划信息
	 * @param id 年度内部审核计划ID
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLAN_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeAnnualPlan(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = annualPlanService.removeAnnualPlan(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 年度内部审核计划信息列表数据源
	 * @return 年度内部审核计划数据集JSON
	 */
	@RequestMapping(NavConst.ANNUALPLAN_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAnnualPlanList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<AnnualPlan> list =  annualPlanService.getAnnualPlans(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = annualPlanService.getAnnualPlanQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据年度内部审核计划申请ID获取年度内部审核计划列表信息
	 * @param id 年度内部审核计划申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLAN_MGT_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getAnnualPlanByAppId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<AnnualPlan> list = null;
		try {
			list = annualPlanService.getAnnualPlansByAppId(id);
		} catch (Exception e) {
			e.printStackTrace();
			list = new ArrayList<AnnualPlan>();
		}
	
		result.put("list", list);
		return result;
	}
}
