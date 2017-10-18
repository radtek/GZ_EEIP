package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingMaParticipant;
import org.pangolin.eeip.service.MeetingMaParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingMaParticipantController extends BaseController {

	@Resource
	private MeetingMaParticipantService meetingMaParticipantService;
	
	/***
	 * 保存管理评审参与人清单申请信息
	 * @param meetingApp 管理评审参与人清单申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_PARTICIPANT_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingMaParticipant(@RequestBody MeetingMaParticipant meetingMaParticipant){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingMaParticipantService.saveMeetingMaParticipant(meetingMaParticipant);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据管理评审参与人清单申请ID获取管理评审参与人清单申请信息
	 * @param id 管理评审参与人清单申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_PARTICIPANT_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingMaParticipantDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingMaParticipant meetingApp = meetingMaParticipantService.getMeetingMaParticipantById(id);
			meetingApp = meetingApp == null ? new MeetingMaParticipant() : meetingApp;
			result.put("entity", meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingMaParticipant());
		}
	
		return result;
	}
	
	/***
	 * 根据管理评审参与人清单申请ID删除管理评审参与人清单申请信息
	 * @param id 管理评审参与人清单申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_MA_PARTICIPANT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingMaParticipant(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingMaParticipantService.removeMeetingMaParticipant(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 管理评审参与人清单申请信息列表数据源
	 * @return 管理评审参与人清单申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_MA_PARTICIPANT_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingMaParticipantList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingMaParticipant> list =  meetingMaParticipantService.getMeetingMaParticipants(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingMaParticipantService.getMeetingMaParticipantQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
