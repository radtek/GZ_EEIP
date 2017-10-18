package org.pangolin.eeip.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevUsingSitn;
import org.pangolin.eeip.service.DevUsingSitnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevUsingSitnController extends BaseController{
	
	@Resource
	private DevUsingSitnService devUsingSitnService;
	
	/***
	 * 保存设备使用情况表
	 * @param devUsingSitn 设备使用情况对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVUSINGSITN_SAVEDEVUSINGSITNDATA)
	@ResponseBody
	public Map<String, Object> saveDevUsingSitn(@RequestBody DevUsingSitn devUsingSitn){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			devUsingSitn.setCreatedDate(new Date());
			status = devUsingSitnService.saveDevUsingSitn(devUsingSitn);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据设备使用情况ID获取设备使用情况信息
	 * @param id 设备使用情况ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVUSINGSITN_LOADDEVUSINGSITNDATA)
	@ResponseBody
	public Map<String, Object> getDevUsingSitnDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevUsingSitn devUsingSitn = devUsingSitnService.getDevUsingSitnById(id);
			devUsingSitn = devUsingSitn == null ? new DevUsingSitn() : devUsingSitn;
			result.put("entity", devUsingSitn);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevUsingSitn());
		}
	
		return result;
	}
	
	/***
	 * 根据设备使用情况ID删除设备使用情况信息（伪删除）
	 * @param id 设备使用情况ID
	 * @return
	 */
	
	@ResponseBody
	public Map<String, Object> removeDevUsingSitn(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devUsingSitnService.removeDevUsingSitnFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 设备使用情况信息列表数据源
	 * @return 设备使用情况数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVUSINGSITN_DEVUSINGSITNGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevUsingSitnList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevUsingSitn> list = devUsingSitnService.getDevUsingSitns(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId);
		long totalCount = devUsingSitnService.getDevUsingSitnQty(devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
