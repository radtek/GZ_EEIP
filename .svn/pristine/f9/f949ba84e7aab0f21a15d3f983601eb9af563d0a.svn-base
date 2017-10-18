package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevAdjPlan;
import org.pangolin.eeip.service.DevAdjPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevAdjPlanController extends BaseController{
	
	@Resource
	private DevAdjPlanService devAdjPlanService;
	
	/***
	 * 保存仪器设备核查/校准/维修申请表表
	 * @param devAdjPlan 仪器设备核查/校准/维修申请表对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_SAVEDEVADJPLANDATA)
	@ResponseBody
	public Map<String, Object> saveDevAdjPlan(@RequestBody DevAdjPlan devAdjPlan){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjPlanService.saveDevAdjPlan(devAdjPlan);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据仪器设备核查/校准/维修申请表ID获取仪器设备核查/校准/维修申请表信息
	 * @param id 仪器设备核查/校准/维修申请表ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_LOADDEVADJPLANDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjPlanDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevAdjPlan devAdjPlan = devAdjPlanService.getDevAdjPlanById(id);
			devAdjPlan = devAdjPlan == null ? new DevAdjPlan() : devAdjPlan;
			result.put("entity", devAdjPlan);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevAdjPlan());
		}
	
		return result;
	}
	
	/***
	 * 根据仪器设备核查/校准/维修申请表ID删除仪器设备核查/校准/维修申请表信息（伪删除）
	 * @param id 仪器设备核查/校准/维修申请表ID
	 * @return
	 */
//	@RequestMapping()
	@ResponseBody
	public Map<String, Object> removeDevAdjPlan(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjPlanService.removeDevAdjPlanFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 仪器设备核查/校准/维修申请表信息列表数据源
	 * @return 仪器设备核查/校准/维修申请表数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_DEVADJPLANGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjPlanList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevAdjPlan> list = devAdjPlanService.getDevAdjPlans(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId);
		long totalCount = devAdjPlanService.getDevAdjPlanQty(devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
