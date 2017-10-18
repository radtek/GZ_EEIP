package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevBorrowApp;
import org.pangolin.eeip.service.DevBorrowAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevBorrowAppController extends BaseController{
	
	@Resource
	private DevBorrowAppService devBorrowAppService;
	
	/***
	 * 保存借用外部设备审批表
	 * @param devBorrowApp 借用外部设备审批对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVBORROWAPP_SAVEDEVBORROWAPPDATA)
	@ResponseBody
	public Map<String, Object> saveDevBorrowApp(@RequestBody DevBorrowApp devBorrowApp){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devBorrowAppService.saveDevBorrowApp(devBorrowApp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据借用外部设备审批ID获取借用外部设备审批信息
	 * @param id 借用外部设备审批ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVBORROWAPP_LOADDEVBORROWAPPDATA)
	@ResponseBody
	public Map<String, Object> getDevBorrowAppDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevBorrowApp devBorrowApp = devBorrowAppService.getDevBorrowAppById(id);
			devBorrowApp = devBorrowApp == null ? new DevBorrowApp() : devBorrowApp;
			result.put("entity", devBorrowApp);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevBorrowApp());
		}
	
		return result;
	}
	
	/***
	 * 根据借用外部设备审批ID删除借用外部设备审批信息（伪删除）
	 * @param id 借用外部设备审批ID
	 * @return
	 */
//	@RequestMapping()
	@ResponseBody
	public Map<String, Object> removeDevBorrowApp(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devBorrowAppService.removeDevBorrowAppFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 借用外部设备审批信息列表数据源
	 * @return 借用外部设备审批数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVBORROWAPP_DEVBORROWAPPGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevBorrowAppList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String extraParam = params.getExtraParam("queryParam");
		List<DevBorrowApp> list = devBorrowAppService.getDevBorrowApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),extraParam);
		long totalCount = list.size();
		int startIndex = params.getStart();
		if(( startIndex + 10 ) > totalCount){
			list = list.subList(startIndex, (int)totalCount);
		}else{
			list = list.subList(startIndex, startIndex+10);
		}
		return BootstrapDataGridUtil.getResultMap(params, list.size(), list);
	}

}
