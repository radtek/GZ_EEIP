package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.entity.MeetingIaParticipant;
import org.pangolin.eeip.service.MeetingIaInspectionService;
import org.pangolin.eeip.service.MeetingIaParticipantService;
import org.pangolin.eeip.service.MeetingIiReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.pangolin.eeip.common.NavConst;

@Controller
public class MeetingIaParticipantController extends BaseController {

	@Resource
	private MeetingIaParticipantService meetingIaParticipantService;
	
	@Resource
	private MeetingIiReportService meetingIiReportService;
	
	@Resource
	private MeetingIaInspectionService meetingIaInspectionService;
	
	/***
	 * 保存内审成员信息
	 * @param folder 内审成员对象
	 * @return
	 */
	//@RequestMapping()
	@ResponseBody
	public Map<String, Object> saveMeetingIaParticipant(@RequestBody MeetingIaParticipant iaParticipant) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			//status = meetingIaParticipantService.saveMeetingIaParticipant(directory);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内审成员ID获取内审成员信息
	 * @param id 内审成员ID
	 * @return
	 */
	//@RequestMapping()
	@ResponseBody
	public Map<String, Object> getMeetingIaParticipantDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingIaParticipant folder = meetingIaParticipantService.getMeetingIaParticipantById(id);
			folder = folder == null ? new MeetingIaParticipant() : folder;
			result.put("entity", folder);
		} catch(Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingIaParticipant());
		}
	
		return result;
	}
	
	/***
	 * 根据内审成员ID删除内审成员信息
	 * @param id 内审成员ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_PARTICIPANT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingIaParticipant(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaParticipantService.removeMeetingIaParticipant(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 内审成员信息列表数据源
	 * @return 内审成员数据集JSON
	 */
	//@RequestMapping()
	@ResponseBody
	public Map<String, Object> getMeetingIaParticipantList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingIaParticipant> list =  meetingIaParticipantService.getMeetingIaParticipants(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingIaParticipantService.getMeetingIaParticipantQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
