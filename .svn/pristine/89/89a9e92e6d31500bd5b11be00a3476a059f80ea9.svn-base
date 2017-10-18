package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevDiscardApp;
import org.pangolin.eeip.service.DevDiscardAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevDiscardAppController extends BaseController{
	
	@Resource
	private DevDiscardAppService devDiscardAppService;
	
	/***
	 * 保存固定资产（设备）报废申请表
	 * @param devDiscardApp 固定资产（设备）报废申请对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_SAVEDEVDISCARDAPPDATE)
	@ResponseBody
	public Map<String, Object> saveDevDiscardApp(@RequestBody DevDiscardApp devDiscardApp){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devDiscardAppService.saveDevDiscardApp(devDiscardApp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据固定资产（设备）报废申请ID获取固定资产（设备）报废申请信息
	 * @param id 固定资产（设备）报废申请ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_LOADDEVDISCARDAPPDATE)
	@ResponseBody
	public Map<String, Object> getDevDiscardAppDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevDiscardApp devDiscardApp = devDiscardAppService.getDevDiscardAppById(id);
			devDiscardApp = devDiscardApp == null ? new DevDiscardApp() : devDiscardApp;
			result.put("entity", devDiscardApp);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevDiscardApp());
		}
	
		return result;
	}
	
	/***
	 * 根据固定资产（设备）报废申请ID获取固定资产（设备）报废申请信息
	 * @param id 固定资产（设备）报废申请ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_LOADDEVDISCARDAPPBYDEVICEID)
	@ResponseBody
	public Map<String, Object> getDevDiscardAppByDeviceId(String deviceId){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevDiscardApp devDiscardApp = devDiscardAppService.getDevDiscardAppByDeviceId(deviceId);
			devDiscardApp = devDiscardApp == null ? new DevDiscardApp() : devDiscardApp;
			result.put("entity", devDiscardApp);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevDiscardApp());
		}
		
		return result;
	}
	
	/***
	 * 固定资产（设备）报废申请信息列表数据源
	 * @return 固定资产（设备）报废申请数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_DEVDISCARDAPPGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevDiscardAppList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<DevDiscardApp> list = devDiscardAppService.getDevDiscardApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = devDiscardAppService.getDevDiscardAppQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
