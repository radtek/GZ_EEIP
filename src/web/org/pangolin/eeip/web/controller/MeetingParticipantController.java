package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingParticipant;
import org.pangolin.eeip.service.MeetingParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingParticipantController extends BaseController {

	@Resource(name = "meetingParticipantService")
	private MeetingParticipantService meetingParticipantService;
	
	/***
	 * 保存参会人信息
	 * @param meetingParticipant 参会人对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_PARTICIPANT_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingParticipant(@RequestBody MeetingParticipant meetingParticipant) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			//status = meetingParticipantService.saveMeetingParticipant(meetingParticipant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据参会人ID获取参会人信息
	 * @param id 参会人ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_PARTICIPANT_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingParticipantDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingParticipant meetingParticipant = meetingParticipantService.getMeetingParticipantById(id);
			meetingParticipant = meetingParticipant == null ? new MeetingParticipant() : meetingParticipant;
			result.put("entity", meetingParticipant);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingParticipant());
		}
	
		return result;
	}
	
	/***
	 * 根据参会人ID删除参会人信息
	 * @param id 参会人ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_PARTICIPANT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingParticipant(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingParticipantService.removeMeetingParticipant(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 参会人信息列表数据源
	 * @return 参会人数据集JSON
	 */
	@RequestMapping(NavConst.MEETINGAPP_PARTICIPANT_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingParticipantList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingParticipant> list =  meetingParticipantService.getMeetingParticipants(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingParticipantService.getMeetingParticipantQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据会议申请ID获取参会人信息列表
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_PARTICIPANT_MGT_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingParticipantByAppId (String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<MeetingParticipant> list = null;
		try {
			list = meetingParticipantService.getMeetingParticipantsByMeetingAppId(id);
		} catch (Exception e) {
			e.printStackTrace();
			list = new ArrayList<MeetingParticipant>();
		}
	
		result.put("list", list);
		return result;
	}
}
