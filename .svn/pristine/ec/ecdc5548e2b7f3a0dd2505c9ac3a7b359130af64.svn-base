package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingIaInspection;
import org.pangolin.eeip.service.MeetingIaInspectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingIaInspectionController extends BaseController {

	@Resource
	private MeetingIaInspectionService meetingIaInspectionService;
	
	/***
	 * 保存内部审核检查申请信息
	 * @param meetingApp 内部审核检查申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingIaInspection(@RequestBody MeetingIaInspection meetingIaInspection) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaInspectionService.saveMeetingIaInspection(meetingIaInspection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内部审核检查申请ID获取内部审核检查申请信息
	 * @param id 内部审核检查申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingIaInspection meetingApp = meetingIaInspectionService.getMeetingIaInspectionById(id);
			meetingApp = meetingApp == null ? new MeetingIaInspection() : meetingApp;
			result.put("entity", meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingIaInspection());
		}
	
		return result;
	}
	
	/***
	 * 根据内部审核检查申请ID删除内部审核检查申请信息（伪删除）
	 * @param id 内部审核检查申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingIaInspection(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaInspectionService.removeMeetingIaInspectionFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 内部审核检查申请信息列表数据源
	 * @return 内部审核检查申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingIaInspection> list =  meetingIaInspectionService.getMeetingIaInspections(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingIaInspectionService.getMeetingIaInspectionQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据会议申请ID获取内部审核检查申请列表信息
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_MGT_LIST_BY_APPID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionsByAppId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<MeetingIaInspection> iaInspections = meetingIaInspectionService.getMeetingIaInspectionsByAppId(id);
			result.put("entity", iaInspections);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new ArrayList<MeetingIaInspection>());
		}
	
		return result;
	}
	
	/***
	 * 根据会议申请ID和参与人ID获取内部审核检查申请列表信息
	 * @param id 会议申请ID
	 * @param participantId 参与人ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_MGT_LIST_BY_APPID_AND_PARTICIPANT_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionsByAppIdAndParticipantId(String id,String participantId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<MeetingIaInspection> iaInspections = meetingIaInspectionService.getMeetingIaInspectionByAppIdAndParticipantId(id, participantId);
			result.put("entity", iaInspections);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new ArrayList<MeetingIaInspection>());
		}
	
		return result;
	}
}
