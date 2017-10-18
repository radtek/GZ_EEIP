package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevMaintanence;
import org.pangolin.eeip.service.DevMaintanenceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevMaintanenceController extends BaseController{
	
	@Resource
	private DevMaintanenceService devMaintanenceService;
	
	/***
	 * 保存设备维护保养记录表
	 * @param devMaintanence 设备维护保养记录对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVMAINTANENCE_SAVEDEVMAINTANENCEDATA)
	@ResponseBody
	public Map<String, Object> saveDevMaintanence(@RequestBody DevMaintanence devMaintanence){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devMaintanenceService.saveDevMaintanence(devMaintanence);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据设备维护保养记录ID获取设备维护保养记录信息
	 * @param id 设备维护保养记录ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVMAINTANENCE_LOADDEVMAINTANENCEDATA)
	@ResponseBody
	public Map<String, Object> getDevMaintanenceDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevMaintanence devMaintanence = devMaintanenceService.getDevMaintanenceById(id);
			devMaintanence = devMaintanence == null ? new DevMaintanence() : devMaintanence;
			result.put("entity", devMaintanence);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevMaintanence());
		}
	
		return result;
	}
	
	/***
	 * 根据设备维护保养记录ID删除设备维护保养记录信息（伪删除）
	 * @param id 设备维护保养记录ID
	 * @return
	 */
	
	@ResponseBody
	public Map<String, Object> removeDevMaintanence(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devMaintanenceService.removeDevMaintanenceFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 设备维护保养记录信息列表数据源
	 * @return 设备维护保养记录数据集JSON
	 */
	
	@RequestMapping(NavConst.DEVICE_MGT_DEVMAINTANENCE_DEVMAINTANENCEGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevMaintanenceList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevMaintanence> list = devMaintanenceService.getDevMaintanences(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId);
		long totalCount = devMaintanenceService.getDevMaintanenceQty(devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
