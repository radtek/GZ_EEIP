package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingQsDocCmtItem;
import org.pangolin.eeip.service.MeetingQsDocCmtItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingQsDocCmtItemController extends BaseController {

	@Resource
	private MeetingQsDocCmtItemService meetingQsDocCmtItemService;
	
	/***
	 * 保存质量体系文件修改意见细项申请信息
	 * @param meetingApp 质量体系文件修改意见细项申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_ITEM_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingQsDocCmtItem(@RequestBody MeetingQsDocCmtItem meetingQsDocCmtItem) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingQsDocCmtItemService.saveMeetingQsDocCmtItem(meetingQsDocCmtItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据质量体系文件修改意见细项申请ID获取质量体系文件修改意见细项申请信息
	 * @param id 质量体系文件修改意见细项申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_ITEM_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingQsDocCmtItemDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingQsDocCmtItem meetingApp = meetingQsDocCmtItemService.getMeetingQsDocCmtItemById(id);
			meetingApp = meetingApp == null ? new MeetingQsDocCmtItem() : meetingApp;
			result.put("entity", meetingApp);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingQsDocCmtItem());
		}
	
		return result;
	}
	
	/***
	 * 根据质量体系文件修改意见细项申请ID删除质量体系文件修改意见细项申请信息
	 * @param id 质量体系文件修改意见细项申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_ITEM_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingQsDocCmtItem(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingQsDocCmtItemService.removeMeetingQsDocCmtItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 质量体系文件修改意见细项申请信息列表数据源
	 * @return 质量体系文件修改意见细项申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_ITEM_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingQsDocCmtItemList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingQsDocCmtItem> list =  meetingQsDocCmtItemService.getMeetingQsDocCmtItems(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingQsDocCmtItemService.getMeetingQsDocCmtItemQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
