package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingIaReport;
import org.pangolin.eeip.service.MeetingIaReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingIaReportController extends BaseController {

	@Resource
	private MeetingIaReportService meetingIaReportService;
	
	/***
	 * 保存内部审核报告申请信息
	 * @param meetingApp 内部审核报告申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_REPORT_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingIaReport(@RequestBody MeetingIaReport meetingIaReport) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaReportService.saveMeetingIaReport(meetingIaReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内部审核报告申请ID获取内部审核报告申请信息
	 * @param id 内部审核报告申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_REPORT_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaReportDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingIaReport meetingApp = meetingIaReportService.getMeetingIaReportById(id);
			meetingApp = meetingApp == null ? new MeetingIaReport() : meetingApp;
			result.put("entity", meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingIaReport());
		}
	
		return result;
	}
	
	/***
	 * 根据内部审核报告申请ID删除内部审核报告申请信息（伪删除）
	 * @param id 内部审核报告申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_REPORT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingIaReport(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaReportService.removeMeetingIaReportFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 内部审核报告申请信息列表数据源
	 * @return 内部审核报告申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_IA_REPORT_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaReportList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingIaReport> list =  meetingIaReportService.getMeetingIaReports(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingIaReportService.getMeetingIaReportQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据会议申请ID获取内部审核报告申请信息
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_REPORT_MGT_LOAD_BY_APPID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaReportDetailByAppId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingIaReport meetingApp = meetingIaReportService.getMeetingIaReportByAppId(id);
			result.put("entity", meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingIaReport());
		}
	
		return result;
	}
	
}
