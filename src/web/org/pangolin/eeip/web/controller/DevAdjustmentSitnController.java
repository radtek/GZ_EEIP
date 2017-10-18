package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevAdjustmentSitn;
import org.pangolin.eeip.service.DevAdjustmentSitnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevAdjustmentSitnController extends BaseController{
	
	@Resource
	private DevAdjustmentSitnService devAdjustmentSitnService;
	
	/***
	 * 保存仪器设备校准/核查/维修情况登记表
	 * @param devAdjustmentSitn 仪器设备校准/核查/维修情况登记对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJUSTMENTSITN_SAVEDEVICEDATA)
	@ResponseBody
	public Map<String, Object> saveDevAdjustmentSitn(@RequestBody DevAdjustmentSitn devAdjustmentSitn){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjustmentSitnService.saveDevAdjustmentSitn(devAdjustmentSitn);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据仪器设备校准/核查/维修情况登记ID获取仪器设备校准/核查/维修情况登记信息
	 * @param id 仪器设备校准/核查/维修情况登记ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJUSTMENTSITN_LOADDEVICEDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjustmentSitnDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevAdjustmentSitn devAdjustmentSitn = devAdjustmentSitnService.getDevAdjustmentSitnById(id);
			devAdjustmentSitn = devAdjustmentSitn == null ? new DevAdjustmentSitn() : devAdjustmentSitn;
			result.put("entity", devAdjustmentSitn);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevAdjustmentSitn());
		}
	
		return result;
	}
	
	/***
	 * 根据仪器设备校准/核查/维修情况登记ID删除仪器设备校准/核查/维修情况登记信息（伪删除）
	 * @param id 仪器设备校准/核查/维修情况登记ID
	 * @return
	 */
//	@RequestMapping()
	@ResponseBody
	public Map<String, Object> removeDevAdjustmentSitn(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAdjustmentSitnService.removeDevAdjustmentSitnFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 仪器设备校准/核查/维修情况登记信息列表数据源
	 * @return 仪器设备校准/核查/维修情况登记数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVADJUSTMENTSITN_DEVADJUSTMENTSITNGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevAdjustmentSitnList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevAdjustmentSitn> list = devAdjustmentSitnService.getDevAdjustmentSitns(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(), devId);
		long totalCount = devAdjustmentSitnService.getDevAdjustmentSitnQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
