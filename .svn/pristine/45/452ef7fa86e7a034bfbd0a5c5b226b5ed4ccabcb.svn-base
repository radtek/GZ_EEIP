package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.MeetingMaReportDto;
import org.pangolin.eeip.entity.MeetingMaParticipant;
import org.pangolin.eeip.entity.MeetingMaReport;
import org.pangolin.eeip.service.MeetingMaParticipantService;
import org.pangolin.eeip.service.MeetingMaReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingMaReportController extends BaseController {

	@Resource
	private MeetingMaReportService meetingMaReportService;
	
	@Resource
	private MeetingMaParticipantService meetingMaParticipantService;
	
	/***
	 * 保存管理评审报告申请信息
	 * @param meetingApp 管理评审报告申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_REPORT_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingMaReport(@RequestBody MeetingMaReportDto dto ){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingMaReportService.saveMeetingMaReport(dto.getMeetingMaReport());
			List<MeetingMaParticipant> participants = dto.getParticipants();
			if ( participants != null && participants.size() > 0 ) {
				for ( MeetingMaParticipant participant : participants ) {
					participant.setMeetingAppId(dto.getMeetingMaReport().getMeetingAppId());
					participant.setMeetingMaReportId(dto.getMeetingMaReport().getId());
					status = meetingMaParticipantService.saveMeetingMaParticipant(participant);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据管理评审报告申请ID获取管理评审报告申请信息
	 * @param id 管理评审报告申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_REPORT_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingMaReportDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingMaReport maReport = meetingMaReportService.getMeetingMaReportById(id);
			List<MeetingMaParticipant> participants = new ArrayList<MeetingMaParticipant>();
			if ( maReport != null ) {
				participants = meetingMaParticipantService.getMeetingMaParticipantsByReportId(maReport.getId());
			}
			maReport = maReport == null ? new MeetingMaReport() : maReport;
			MeetingMaReportDto dto = new MeetingMaReportDto();
			dto.setMeetingMaReport(maReport);
			dto.setParticipants(participants);
			
			result.put("entity", dto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingMaReport());
		}
	
		return result;
	}
	
	/***
	 * 根据管理评审报告申请ID删除管理评审报告申请信息（伪删除）
	 * @param id 管理评审报告申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_REPORT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingMaReport(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingMaReportService.removeMeetingMaReportFalse(id);
		} catch ( Exception e ) { 
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 管理评审报告申请信息列表数据源
	 * @return 管理评审报告申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_MA_REPORT_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingMaReportList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingMaReport> list =  meetingMaReportService.getMeetingMaReports(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingMaReportService.getMeetingMaReportQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	

	/***
	 * 根据会议申请ID获取管理评审报告申请信息
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_REPORT_MGT_LOAD_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingMaReportDetailByAppId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingMaReport maReport = meetingMaReportService.getMeetingMaReportByAppId(id);
			List<MeetingMaParticipant> participants = new ArrayList<MeetingMaParticipant>();
			if ( maReport != null ) {
				participants = meetingMaParticipantService.getMeetingMaParticipantsByReportId(maReport.getId());
			}
			maReport = maReport == null ? new MeetingMaReport() : maReport;
			MeetingMaReportDto dto = new MeetingMaReportDto();
			dto.setMeetingMaReport(maReport);
			dto.setParticipants(participants);
			
			result.put("entity", dto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingMaReportDto());
		}
	
		return result;
	}
}
