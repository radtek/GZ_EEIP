package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingIiReport;
import org.pangolin.eeip.service.MeetingIiReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingIiReportController extends BaseController {

	@Resource
	private MeetingIiReportService meetingIiReportService;
	
	/***
	 * 保存不符合项报告信息
	 * @param folder 不符合项报告对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_II_REPORT_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingIiReport(@RequestBody MeetingIiReport directory) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIiReportService.saveMeetingIiReport(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据不符合项报告ID获取不符合项报告信息
	 * @param id 不符合项报告ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_II_REPORT_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIiReportDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingIiReport folder = meetingIiReportService.getMeetingIiReportById(id);
			folder = folder == null ? new MeetingIiReport() : folder;
			result.put("entity", folder);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingIiReport());
		}
	
		return result;
	}
	
	/***
	 * 根据不符合项报告ID删除会议夹信息（伪删除）
	 * @param id 不符合项报告ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_II_REPORT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingIiReport(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIiReportService.removeMeetingIiReportFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 不符合项报告信息列表数据源
	 * @return 不符合项报告数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_II_REPORT_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIiReportList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingIiReport> list =  meetingIiReportService.getMeetingIiReports(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingIiReportService.getMeetingIiReportQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据会议申请ID获取不符合项报告信息列表
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_II_REPORT_MGT_LIST_BY_APPID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIiReportsByAppId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<MeetingIiReport> iiReports = meetingIiReportService.getMeetingIiReportsByAppId(id);
			result.put("entity", iiReports);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new ArrayList<MeetingIiReport>());
		}
	
		return result;
	}
	
	/***
	 * 根据会议申请ID和参与人ID获取不符合项报告信息列表
	 * @param id 会议申请ID
	 * @param participantId 参与人ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_II_REPORT_MGT_LIST_BY_APPID_AND_PARTICIPANT_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIiReportsByAppId(String id,String participantId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<MeetingIiReport> iiReports = meetingIiReportService.getMeetingIiReportByAppIdAndParticipantId(id, participantId);
			result.put("entity", iiReports);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new ArrayList<MeetingIiReport>());
		}
	
		return result;
	}
}
