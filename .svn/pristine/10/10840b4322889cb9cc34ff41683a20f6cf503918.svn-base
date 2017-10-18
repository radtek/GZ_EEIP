package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevInspection;
import org.pangolin.eeip.service.DevInspectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevInspectionController extends BaseController{
	
	@Resource
	private DevInspectionService devInspectionService;
	
	/***
	 * 保存设备期间核查情况记录表 
	 * @param devInspection 设备期间核查情况记录对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEV_INSPECTION_SAVEDATE)
	@ResponseBody
	public Map<String, Object> saveDevInspection(@RequestBody DevInspection devInspection){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devInspectionService.saveDevInspection(devInspection);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据设备期间核查情况记录ID获取设备期间核查情况记录信息
	 * @param id 设备期间核查情况记录ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEV_INSPECTION_LOADBYID)
	@ResponseBody
	public Map<String, Object> getDevInspectionDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevInspection devInspection = devInspectionService.getDevInspectionById(id);
			devInspection = devInspection == null ? new DevInspection() : devInspection;
			result.put("entity", devInspection);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevInspection());
		}
	
		return result;
	}
	
	/***
	 * 根据设备期间核查情况记录ID删除设备期间核查情况记录信息（伪删除）
	 * @param id 设备期间核查情况记录ID
	 * @return
	 */
	
	@ResponseBody
	public Map<String, Object> removeDevInspection(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devInspectionService.removeDevInspectionFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 设备期间核查情况记录信息列表数据源
	 * @return 设备期间核查情况记录数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEV_INSPECTION_DEVINSPECTION)
	@ResponseBody
	public Map<String, Object> getDevInspectionList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevInspection> list = devInspectionService.getDevInspections(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId);
		long totalCount = devInspectionService.getDevInspectionQty(devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
