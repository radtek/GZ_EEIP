package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Inquest;
import org.pangolin.eeip.service.InquestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InquestController extends BaseController {

	@Resource
	private InquestService inquestService;
	
	/***
	 * 保存现场勘验审批申请信息
	 * @param meetingApp 现场勘验审批申请对象
	 * @return
	 */
	@RequestMapping(NavConst.INQUEST_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveInquest(@RequestBody Inquest meetingApp) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = inquestService.saveInquest(meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据现场勘验审批申请ID获取现场勘验审批申请信息
	 * @param id 现场勘验审批申请ID
	 * @return
	 */
	@RequestMapping(NavConst.INQUEST_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getInquestDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Inquest meetingApp = inquestService.getInquestById(id);
			meetingApp = meetingApp == null ? new Inquest() : meetingApp;
			result.put("entity", meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new Inquest());
		}
	
		return result;
	}
	
	/***
	 * 根据现场勘验审批申请ID删除现场勘验审批申请信息（伪删除）
	 * @param id 现场勘验审批申请ID
	 * @return
	 */
	@RequestMapping(NavConst.INQUEST_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeInquest(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = inquestService.removeInquestFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 现场勘验审批申请信息列表数据源
	 * @return 现场勘验审批申请数据集JSON
	 */
	@RequestMapping(NavConst.INQUEST_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getInquestList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		List<Inquest> list =  inquestService.getInquests(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		long totalCount = inquestService.getInquestQty(queryParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
