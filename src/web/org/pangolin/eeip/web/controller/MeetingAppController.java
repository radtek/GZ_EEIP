package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.MeetingAppDto;
import org.pangolin.eeip.entity.MeetingApp;
import org.pangolin.eeip.entity.MeetingIaParticipant;
import org.pangolin.eeip.entity.MeetingParticipant;
import org.pangolin.eeip.service.MeetingAppService;
import org.pangolin.eeip.service.MeetingDocService;
import org.pangolin.eeip.service.MeetingIaParticipantService;
import org.pangolin.eeip.service.MeetingParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingAppController extends BaseController {

	@Resource(name = "meetingAppService")
	private MeetingAppService meetingAppService;
	
	@Resource
	private MeetingParticipantService meetingParticipantService; // 参与人员
	
	@Resource
	private MeetingIaParticipantService meetingIaParticipantService; // 内审成员
	
	@Resource(name = "meetingDocService")
	private MeetingDocService meetingDocService;
	
	
	/***
	 * 保存会议申请信息
	 * @param meetingApp 会议申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingApp(@RequestBody MeetingAppDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			MeetingApp meetingApp = MeetingAppDto.converToMeetingApp(dto);
			status = meetingAppService.saveMeetingApp(meetingApp);
			List<MeetingParticipant> participants = dto.getParticipants();
			List<MeetingIaParticipant> iaParticipants = dto.getIaParticipants();
			List<String> docIds = dto.getAdd();
			
			status = meetingParticipantService.removeMeetingParticipantsByAppId(meetingApp.getId());
			//参加人员
			if ( participants != null && participants.size() > 0 ) {
				for ( MeetingParticipant participant : participants ) {
					participant.setMeetingAppId(meetingApp.getId());
					status = meetingParticipantService.saveMeetingParticipant(participant,dto.getType());
				}
			}
			
			status = meetingIaParticipantService.removeMeetingIaParticipantByAppId(meetingApp.getId());
			//审核员
			if( iaParticipants != null && iaParticipants.size() > 0 ){
				for ( MeetingIaParticipant iaParticipant : iaParticipants ) {
					iaParticipant.setMeetingAppId(meetingApp.getId());
					status = meetingIaParticipantService.saveMeetingIaParticipant(iaParticipant, dto.getType());
				}
			}
			
			//会议资料
			if ( docIds != null && docIds.size() > 0 ) {
	   			for ( String id : docIds ) {
	   				status = meetingDocService.updateMeetingDoc(id);
	   			}
	   		}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据会议申请ID获取会议申请信息
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingAppDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			
			MeetingApp meetingApp = meetingAppService.getMeetingAppById(id);
			List<MeetingParticipant> participants = new ArrayList<MeetingParticipant>();
			List<MeetingIaParticipant> iaParticipants = new ArrayList<MeetingIaParticipant>();
			if ( meetingApp != null ) {
				participants = meetingParticipantService.getMeetingParticipantsByMeetingAppId(id);
				iaParticipants = meetingIaParticipantService.getMeetingIaParticipantsByAppId(id);
			}
			meetingApp = meetingApp == null ? new MeetingApp() : meetingApp;
			MeetingAppDto dto = MeetingAppDto.converToMeetingAppDto(meetingApp);
			dto.setParticipants(participants);
			dto.setIaParticipants(iaParticipants);
			result.put("entity", dto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingApp());
		}
	
		return result;
	}
	
	/***
	 * 根据会议申请ID删除会议申请信息（伪删除）
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingApp(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingAppService.removeMeetingAppFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 会议申请信息列表数据源
	 * @return 会议申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETINGAPP_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingAppList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		Map<String, Object> queryParams = new HashMap<String, Object>();
		if ( params != null ) {
			buildExtraParams(params, queryParams);
		}
		List<MeetingApp> list =  meetingAppService.getMeetingApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParams);
		long totalCount = meetingAppService.getMeetingAppQty(queryParams);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 构建查询参数 Bootstrap 请求
	 * @param params
	 * @param queryParams
	 */
	private void buildExtraParams(BootstrapDataGridParam params, Map<String, Object> queryParams) {
		String subject = params.getExtraParam("key");
		String type = params.getExtraParam("type");
		if ( subject != null && !"".equals(subject.trim()) ) {
			queryParams.put("key", subject.trim());
		} if ( type != null && !"".equals(type.trim()) ) {
			queryParams.put("type", type);
		}
	}
}
