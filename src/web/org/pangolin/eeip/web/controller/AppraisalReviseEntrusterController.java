package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AppraisalReviseEntruster;
import org.pangolin.eeip.service.AppraisalReviseEntrusterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppraisalReviseEntrusterController extends BaseController{
	
	@Resource
	private AppraisalReviseEntrusterService appraisalReviseEntrusterService;
	
	/***
	 * 保存电子物证（检材）鉴定设备表
	 * @param appraisalReviseEntruster 电子物证（检材）鉴定设备对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISEENTRUSTER_SAVEAPPRAISALREVISEENTRUSTERDATA)
	@ResponseBody
	public Map<String, Object> saveAppraisalReviseEntruster(@RequestBody AppraisalReviseEntruster appraisalReviseEntruster){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = appraisalReviseEntrusterService.saveAppraisalReviseEntruster(appraisalReviseEntruster);
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
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISEENTRUSTER_LOADAPPRAISALREVISEENTRUSTERDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseEntrusterDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			AppraisalReviseEntruster appraisalReviseEntruster = appraisalReviseEntrusterService.getAppraisalReviseEntrusterById(id);
			appraisalReviseEntruster = appraisalReviseEntruster == null ? new AppraisalReviseEntruster() : appraisalReviseEntruster;
			result.put("entity", appraisalReviseEntruster);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisalReviseEntruster());
		}
	
		return result;
	}
	
	/***
	 * 文书修改申请ID查询委托人
	 * @param appraisalReviseAppId 文书修改申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_ENTRUSTER_LOAD_BY_APPRAISALREVISEAPPID)
	@ResponseBody
	public Map<String, Object> getEntrusterByAppraisalReviseAppId(String appraisalReviseAppId){
		Map<String, Object> result = new HashMap<String, Object>();
		List<AppraisalReviseEntruster> resultList = new ArrayList<AppraisalReviseEntruster>();
		try{
			resultList = appraisalReviseEntrusterService.getAppraisalReviseEntrusters(appraisalReviseAppId);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("entity", resultList);
		return result;
	}
 
	/***
	 * 电子物证（检材）鉴定设备信息列表数据源
	 * @return 电子物证（检材）鉴定设备数据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALREVISEENTRUSTER_APPRAISALREVISEENTRUSTERGIRDDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalReviseEntrusterList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<AppraisalReviseEntruster> list = appraisalReviseEntrusterService.getAppraisalReviseEntrusters(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = appraisalReviseEntrusterService.getAppraisalReviseEntrusterQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
