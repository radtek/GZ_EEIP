package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevEvn;
import org.pangolin.eeip.service.DevEvnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevEvnController extends BaseController{
	
	@Resource
	private DevEvnService devEvnService;
	
	/***
	 * 保存固定资产（设备）报废申请表
	 * @param devEvn 固定资产（设备）报废申请对象
	 * @return
	 */
//	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_SAVEDEVDISCARDAPPDATE)
	@ResponseBody
	public Map<String, Object> saveDevEvn(@RequestBody DevEvn devEvn){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devEvnService.saveDevEvn(devEvn);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据location获取最近一次的温湿度
	 * @return
	 */
	@RequestMapping(NavConst.ENV_MGT_DEVEVN_LOADDEVEVNDATE)
	@ResponseBody
	public Map<String, Object> getDevEvnDetail(String location){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevEvn devEvn = new DevEvn();
			devEvn = devEvnService.getDevEvnByCreateDate(location);
			devEvn = devEvn == null ? new DevEvn() : devEvn;
			result.put("entity", devEvn);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevEvn());
		}
	
		return result;
	}
	
	/***
	 * 固定资产（设备）报废申请信息列表数据源
	 * @return 固定资产（设备）报废申请数据集JSON
	 */
	@RequestMapping(NavConst.ENV_MGT_DEVEVN_DEVEVNGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevEvnList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("queryParam");
		String startDate = params.getExtraParam("startDate");
		String endDate = params.getExtraParam("endDate");
		List<DevEvn> list = devEvnService.getDevEvns(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam,startDate,endDate);
		long totalCount = devEvnService.getDevEvnQty(queryParam,startDate,endDate);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 固定资产（设备）报废申请信息列表数据源
	 * @return 固定资产（设备）报废申请数据集JSON
	 */
	@RequestMapping(NavConst.ENV_MGT_DEVEVN_LOADDEVEVNLIST)
	@ResponseBody
	public Map<String, Object> getDevEvnList(String queryParam,String endDate,String startDate){
		Map<String,Object> map = new HashMap<String, Object>();
		List<DevEvn> list = devEvnService.getDevEvnList(queryParam,startDate,endDate);
		if(list.size() > 10){
			list = list.subList(0, 10);
		}
		map.put("entity", list);
		return map;
	}

}
