package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevInspectionParam;
import org.pangolin.eeip.service.DevInspectionParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevInspectionParamController extends BaseController{
	
	@Resource
	private DevInspectionParamService devInspectionParamService;
	
	/***
	 * 保存期间核查项目及参数 表
	 * @param devInspectionParam 期间核查项目及参数 对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVINSPECTIONPARAM_SAVEDEVINSPECTIONPARAMDATA)
	@ResponseBody
	public Map<String, Object> saveDevInspectionParam(@RequestBody DevInspectionParam devInspectionParam){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devInspectionParamService.saveDevInspectionParam(devInspectionParam);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据期间核查项目及参数 ID获取期间核查项目及参数 信息
	 * @param id 期间核查项目及参数 ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVINSPECTIONPARAM_LOADDEVINSPECTIONPARAMDATA)
	@ResponseBody
	public Map<String, Object> getDevInspectionParamDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevInspectionParam devInspectionParam = devInspectionParamService.getDevInspectionParamById(id);
			devInspectionParam = devInspectionParam == null ? new DevInspectionParam() : devInspectionParam;
			result.put("entity", devInspectionParam);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevInspectionParam());
		}
	
		return result;
	}
	
	/***
	 * 根据期间核查项目及参数 ID删除期间核查项目及参数 信息（伪删除）
	 * @param id 期间核查项目及参数 ID
	 * @return
	 */
	@ResponseBody
	public Map<String, Object> removeDevInspectionParam(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devInspectionParamService.removeDevInspectionParamFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 期间核查项目及参数 信息列表数据源
	 * @return 期间核查项目及参数 数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVINSPECTIONPARAM_DEVINSPECTIONPARAMGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevInspectionParamList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		String devInspectionId = params.getExtraParam("devInspectionId");
		List<DevInspectionParam> list = devInspectionParamService.getDevInspectionParams(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId,devInspectionId);
		long totalCount = devInspectionParamService.getDevInspectionParamQty(devId,devInspectionId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
