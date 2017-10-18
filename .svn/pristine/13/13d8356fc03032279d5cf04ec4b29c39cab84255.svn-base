package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevAdjPlanItem;
import org.pangolin.eeip.service.DevAdjPlanItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevAdjPlanItemController extends BaseController{
	
	@Resource
	private DevAdjPlanItemService devAdjPlanItemService;
	
	/***
	 * 保存仪器设备核查/校准/维修申请表表
	 * @param devAdjPlanItem 仪器设备核查/校准/维修申请表对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_SAVEDEVADJPLANITEMDATA)
	@ResponseBody
	public Map<String, Object> saveDevAdjPlanItem(@RequestBody DevAdjPlanItem devAdjPlanItem){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjPlanItemService.saveDevAdjPlanItem(devAdjPlanItem);
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
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_LOADDEVADJPLANITEMDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjPlanItemDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevAdjPlanItem devAdjPlanItem = devAdjPlanItemService.getDevAdjPlanItemById(id);
			devAdjPlanItem = devAdjPlanItem == null ? new DevAdjPlanItem() : devAdjPlanItem;
			result.put("entity", devAdjPlanItem);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevAdjPlanItem());
		}
	
		return result;
	}
	
	/***
	 * 根据仪器设备核查/校准/维修申请表ID获取仪器设备核查/校准/维修申请表信息
	 * @param id 仪器设备核查/校准/维修申请表ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_LOADDEVADJPLANBYDEVPLANID)
	@ResponseBody
	public Map<String, Object> getDevAdjPlanByDevPlanId(String devicePlanId){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevAdjPlanItem devAdjPlanItem = devAdjPlanItemService.getDevAdjPlanByDevPlanId(devicePlanId);
			devAdjPlanItem = devAdjPlanItem == null ? new DevAdjPlanItem() : devAdjPlanItem;
			result.put("entity", devAdjPlanItem);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevAdjPlanItem());
		}
	
		return result;
	}
	
	/***
	 * 仪器设备核查/校准/维修申请表信息列表数据源
	 * @return 仪器设备核查/校准/维修申请表数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJPLAN_DEVADJPLANITEMGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjPlanItemList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String AdjId = params.getExtraParam("devAdjPlanId");
		String devId = params.getExtraParam("devId");
		List<DevAdjPlanItem> list = devAdjPlanItemService.getDevAdjPlanItems(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),AdjId,devId);
		long totalCount = devAdjPlanItemService.getDevAdjPlanItemQty(AdjId,devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
