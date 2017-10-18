package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingRoom;
import org.pangolin.eeip.service.MeetingRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingRoomController extends BaseController {

	@Resource(name = "meetingRoomService")
	private MeetingRoomService meetingRoomService;
	
	/***
	 * 保存会议室信息
	 * @param meetingRoom 会议室对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGROOM_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingRoom(@RequestBody MeetingRoom meetingRoom) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingRoomService.saveMeetingRoom(meetingRoom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据会议室ID获取会议室信息
	 * @param id 会议室ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGROOM_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingRoomDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingRoom meetingRoom = meetingRoomService.getMeetingRoomById(id);
			meetingRoom = meetingRoom == null ? new MeetingRoom() : meetingRoom;
			result.put("entity", meetingRoom);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingRoom());
		}
	
		return result;
	}
	
	/***
	 * 根据会议室ID删除会议信息（伪删除）
	 * @param id 会议室ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGROOM_MGT_REMOVE_FALSE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingRoomFalse(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingRoomService.removeMeetingRoomFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据会议室ID删除会议信息
	 * @param id 会议室ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGROOM_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingRoom(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingRoomService.removeMeetingRoom(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 会议室信息列表数据源
	 * @return 会议室数据集JSON
	 */
	@RequestMapping(NavConst.MEETINGROOM_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingRoomList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		List<MeetingRoom> list =  meetingRoomService.getMeetingRooms(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		long totalCount = meetingRoomService.getMeetingRoomQty(queryParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

	/***
	 * 获取可用的会议室信息列表
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGROOM_MGT_EMPTY_DATA)
	@ResponseBody
	public Map<String, Object> getEmptyMeetingRoomList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<MeetingRoom> list = null;
		try {
			list = meetingRoomService.getEmptyMeetingRooms();
		} catch (Exception e) {
			e.printStackTrace();
			list = new ArrayList<MeetingRoom>();
		}
		
		result.put("entity", list);
		return result;
	}
}
