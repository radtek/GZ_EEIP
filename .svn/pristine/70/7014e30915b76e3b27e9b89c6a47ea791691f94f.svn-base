package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AppraisedDev;
import org.pangolin.eeip.service.AppraisedDevService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppraisedDevController extends BaseController{
	
	@Resource
	private AppraisedDevService appraisedDevService;
	
	/***
	 * 保存电子物证（检材）鉴定设备表
	 * @param appraisedDev 电子物证（检材）鉴定设备对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISEDDEV_SAVEAPPRAISEDDEVDATA)
	@ResponseBody
	public Map<String, Object> saveAppraisedDev(@RequestBody AppraisedDev appraisedDev){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = appraisedDevService.saveAppraisedDev(appraisedDev);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据电子物证（检材）鉴定设备ID获取电子物证（检材）鉴定设备信息
	 * @param id 电子物证（检材）鉴定设备ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISEDDEV_LOADAPPRAISEDDEVDATA)
	@ResponseBody
	public Map<String, Object> getAppraisedDevDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			AppraisedDev appraisedDev = appraisedDevService.getAppraisedDevById(id);
			appraisedDev = appraisedDev == null ? new AppraisedDev() : appraisedDev;
			result.put("entity", appraisedDev);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisedDev());
		}
	
		return result;
	}
	
	/***
	 * 根据电子物证（检材）鉴定设备ID设备的集合
	 * @param id 电子物证（检材）鉴定设备ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISEDDEV_LOADAPPRAISEDBYAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getAppraisedByappraisalId(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<AppraisedDev> list = appraisedDevService.getAppraisedByappraisalId(id);
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ArrayList<AppraisedDev>());
		}
		return result;
	}
	
	/***
	 * 电子物证（检材）鉴定设备信息列表数据源
	 * @return 电子物证（检材）鉴定设备数据集JSON
	 */
//	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_DEVDISCARDAPPGIRDDATA)
	@ResponseBody
	public Map<String, Object> getAppraisedDevList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<AppraisedDev> list = appraisedDevService.getAppraisedDevs(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = appraisedDevService.getAppraisedDevQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
