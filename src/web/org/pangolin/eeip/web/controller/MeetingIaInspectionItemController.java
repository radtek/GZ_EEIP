package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingIaInspectionItem;
import org.pangolin.eeip.service.MeetingIaInspectionItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingIaInspectionItemController extends BaseController {

	@Resource
	private MeetingIaInspectionItemService meetingIaInspectionItemService;
	
	/***
	 * 保存内部审核检查细项申请信息
	 * @param meetingApp 内部审核检查细项申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_ITEM_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingIaInspectionItem(@RequestBody MeetingIaInspectionItem meetingIaInspectionItem) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaInspectionItemService.saveMeetingIaInspectionItem(meetingIaInspectionItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内部审核检查细项申请ID获取内部审核检查细项申请信息
	 * @param id 内部审核检查细项申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_ITEM_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionItemDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingIaInspectionItem inspectionItem = meetingIaInspectionItemService.getMeetingIaInspectionItemById(id);
			inspectionItem = inspectionItem == null ? new MeetingIaInspectionItem() : inspectionItem;
			result.put("entity", inspectionItem);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingIaInspectionItem());
		}
	
		return result;
	}
	
	/***
	 * 根据内部审核检查细项申请ID删除内部审核检查细项申请信息
	 * @param id 内部审核检查细项申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_ITEM_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingIaInspectionItem(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingIaInspectionItemService.removeMeetingIaInspectionItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 内部审核检查细项申请信息列表数据源
	 * @return 内部审核检查细项申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_ITEM_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionItemList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingIaInspectionItem> list =  meetingIaInspectionItemService.getMeetingIaInspectionItems(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingIaInspectionItemService.getMeetingIaInspectionItemQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据内部审核检查申请ID获取内部审核检查细项申请信息
	 * @param id 内部审核检查申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_IA_INSPECTION_ITEM_MGT_LOAD_BY_INSPECTION_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingIaInspectionItemsByInspectionId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<MeetingIaInspectionItem> inspectionItems = meetingIaInspectionItemService.getMeetingIaInspectionItemsByInspectionId(id);
			result.put("entity", inspectionItems);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new ArrayList<MeetingIaInspectionItem>());
		}
	
		return result;
	}
}
