package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevAdjApp;
import org.pangolin.eeip.service.DevAdjAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevAdjAppController extends BaseController{
	
	@Resource
	private DevAdjAppService devAdjAppService;
	
	/***
	 * 保存仪器设备核查/校准/维修申请表
	 * @param devAdjApp 仪器设备核查/校准/维修申请对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJAPP_SAVEDEVADJAPPDATA)
	@ResponseBody
	public Map<String, Object> saveDevAdjApp(@RequestBody DevAdjApp devAdjApp){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjAppService.saveDevAdjApp(devAdjApp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据仪器设备核查/校准/维修申请ID获取仪器设备核查/校准/维修申请信息
	 * @param id 仪器设备核查/校准/维修申请ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJAPP_LOADDEVADJAPPDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjAppDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevAdjApp devAdjApp = devAdjAppService.getDevAdjAppById(id);
			devAdjApp = devAdjApp == null ? new DevAdjApp() : devAdjApp;
			result.put("entity", devAdjApp);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevAdjApp());
		}
	
		return result;
	}
	
	/***
	 * 根据仪器设备核查/校准/维修申请ID删除仪器设备核查/校准/维修申请信息（伪删除）
	 * @param id 仪器设备核查/校准/维修申请ID
	 * @return
	 */
//	@RequestMapping()
	@ResponseBody
	public Map<String, Object> removeDevAdjApp(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjAppService.removeDevAdjAppFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 仪器设备核查/校准/维修申请信息列表数据源
	 * @return 仪器设备核查/校准/维修申请数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJAPP_DEVADJAPPGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjAppList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevAdjApp> list = devAdjAppService.getDevAdjApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId);
		long totalCount = devAdjAppService.getDevAdjAppQty(devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
