package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.MeetingQsDocCmtDto;
import org.pangolin.eeip.entity.MeetingQsDocCmt;
import org.pangolin.eeip.entity.MeetingQsDocCmtItem;
import org.pangolin.eeip.service.MeetingQsDocCmtItemService;
import org.pangolin.eeip.service.MeetingQsDocCmtService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeetingQsDocCmtController extends BaseController {

	@Resource
	private MeetingQsDocCmtService meetingQsDocCmtService;
	
	@Resource
	private MeetingQsDocCmtItemService meetingQsDocCmtItemService;
	
	/***
	 * 保存质量体系文件修改意见申请信息
	 * @param meetingApp 质量体系文件修改意见申请对象
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMeetingQsDocCmt(@RequestBody MeetingQsDocCmtDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			MeetingQsDocCmt meetingQsDocCmt = MeetingQsDocCmtDto.convertToMeetingQsDocCmt(dto);
			status = meetingQsDocCmtService.saveMeetingQsDocCmt(meetingQsDocCmt);
			//质量手册
			List<MeetingQsDocCmtItem> itemsProgram = dto.getItemsProgram();
			if ( itemsProgram != null && itemsProgram.size() > 0 ) {
				for( MeetingQsDocCmtItem item : itemsProgram ) {
					if ( MeetingQsDocCmtDto.isSave(item) ) {
						item.setMeetingAppId(meetingQsDocCmt.getMeetingAppId());
						item.setMeetingQsDocCmtId(meetingQsDocCmt.getId());
						item.setDocType(MeetingQsDocCmtItem.TYPE_PROGRAM);
						status = meetingQsDocCmtItemService.saveMeetingQsDocCmtItem(item);
					}
					
				}
			}
			// 程序文件
			List<MeetingQsDocCmtItem> itemsQuailty = dto.getItemsQuality();
			if ( itemsQuailty != null && itemsQuailty.size() > 0 ) {
				for ( MeetingQsDocCmtItem item : itemsQuailty ) {
					if ( MeetingQsDocCmtDto.isSave(item) ) {
						item.setMeetingAppId(meetingQsDocCmt.getMeetingAppId());
						item.setMeetingQsDocCmtId(meetingQsDocCmt.getId());
						item.setDocType(MeetingQsDocCmtItem.TYPE_QUALITY);
						status = meetingQsDocCmtItemService.saveMeetingQsDocCmtItem(item);
					}
					
				}
			}
			
			//作业指导书，表格类
			List<MeetingQsDocCmtItem> itemsForm = dto.getItemsForm();
			if ( itemsForm != null && itemsForm.size() > 0 ) {
				for ( MeetingQsDocCmtItem item : itemsForm ) {
					if ( MeetingQsDocCmtDto.isSave(item) ) {
						item.setMeetingAppId(meetingQsDocCmt.getMeetingAppId());
						item.setMeetingQsDocCmtId(meetingQsDocCmt.getId());
						item.setDocType(MeetingQsDocCmtItem.TYPE_FORM);
						status = meetingQsDocCmtItemService.saveMeetingQsDocCmtItem(item);
					}
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
	 * 根据质量体系文件修改意见申请ID获取质量体系文件修改意见申请信息
	 * @param id 质量体系文件修改意见申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingQsDocCmtDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingQsDocCmt docCmt = meetingQsDocCmtService.getMeetingQsDocCmtById(id);
			MeetingQsDocCmtDto cmtDto = new MeetingQsDocCmtDto();
			List<MeetingQsDocCmtItem> itemsProgram = new ArrayList<MeetingQsDocCmtItem>();
			List<MeetingQsDocCmtItem> itemsForm = new ArrayList<MeetingQsDocCmtItem>();
			List<MeetingQsDocCmtItem> itemsQuality = new ArrayList<MeetingQsDocCmtItem>();
			if ( docCmt != null ) {
				itemsForm = meetingQsDocCmtItemService.getMeetingQsDocCmtItemsByCmtId(docCmt.getMeetingAppId(),MeetingQsDocCmtItem.TYPE_FORM);
				itemsProgram = meetingQsDocCmtItemService.getMeetingQsDocCmtItemsByCmtId(docCmt.getMeetingAppId(),MeetingQsDocCmtItem.TYPE_PROGRAM);
				itemsQuality = meetingQsDocCmtItemService.getMeetingQsDocCmtItemsByCmtId(docCmt.getMeetingAppId(),MeetingQsDocCmtItem.TYPE_QUALITY);
			}
			docCmt = docCmt == null ? new MeetingQsDocCmt() : docCmt;
			cmtDto = MeetingQsDocCmtDto.converToMeetingQsDocCmtDto(docCmt);
			if ( itemsForm.size() == 0 ) {
				itemsForm.add(new MeetingQsDocCmtItem(MeetingQsDocCmtItem.TYPE_FORM));
			}
			if ( itemsProgram.size() == 0 ) {
				itemsProgram.add(new MeetingQsDocCmtItem(MeetingQsDocCmtItem.TYPE_PROGRAM));
			}
			if ( itemsQuality.size() == 0 ) {
				itemsQuality.add(new MeetingQsDocCmtItem(MeetingQsDocCmtItem.TYPE_QUALITY));
			}
			cmtDto.setItemsForm(itemsForm);
			cmtDto.setItemsProgram(itemsProgram);
			cmtDto.setItemsQuality(itemsQuality);
			result.put("entity", cmtDto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingQsDocCmt());
		}
	
		return result;
	}
	
	/***
	 * 根据质量体系文件修改意见申请ID删除质量体系文件修改意见申请信息（伪删除）
	 * @param id 质量体系文件修改意见申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingQsDocCmt(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingQsDocCmtService.removeMeetingQsDocCmtFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 质量体系文件修改意见申请信息列表数据源
	 * @return 质量体系文件修改意见申请数据集JSON
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingQsDocCmtList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingQsDocCmt> list =  meetingQsDocCmtService.getMeetingQsDocCmts(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingQsDocCmtService.getMeetingQsDocCmtQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 会议申请ID获取质量体系文件修改意见申请信息
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETING_QS_DOC_CMT_MGT_LOAD_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingQsDocCmtDetailByAppId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingQsDocCmt docCmt = meetingQsDocCmtService.getMeetingQsDocCmtByAppId(id);
			MeetingQsDocCmtDto cmtDto = new MeetingQsDocCmtDto();
			List<MeetingQsDocCmtItem> itemsProgram = new ArrayList<MeetingQsDocCmtItem>();
			List<MeetingQsDocCmtItem> itemsForm = new ArrayList<MeetingQsDocCmtItem>();
			List<MeetingQsDocCmtItem> itemsQuality = new ArrayList<MeetingQsDocCmtItem>();
			if ( docCmt != null ) {
				itemsForm = meetingQsDocCmtItemService.getMeetingQsDocCmtItemsByCmtId(docCmt.getMeetingAppId(),MeetingQsDocCmtItem.TYPE_FORM);
				itemsProgram = meetingQsDocCmtItemService.getMeetingQsDocCmtItemsByCmtId(docCmt.getMeetingAppId(),MeetingQsDocCmtItem.TYPE_PROGRAM);
				itemsQuality = meetingQsDocCmtItemService.getMeetingQsDocCmtItemsByCmtId(docCmt.getMeetingAppId(),MeetingQsDocCmtItem.TYPE_QUALITY);
			}
			docCmt = docCmt == null ? new MeetingQsDocCmt() : docCmt;
			cmtDto = MeetingQsDocCmtDto.converToMeetingQsDocCmtDto(docCmt);
			if ( itemsForm.size() == 0 ) {
				itemsForm.add(new MeetingQsDocCmtItem(MeetingQsDocCmtItem.TYPE_FORM));
			}
			if ( itemsProgram.size() == 0 ) {
				itemsProgram.add(new MeetingQsDocCmtItem(MeetingQsDocCmtItem.TYPE_PROGRAM));
			}
			if( itemsQuality.size() == 0 ) {
				itemsQuality.add(new MeetingQsDocCmtItem(MeetingQsDocCmtItem.TYPE_QUALITY));
			}
			cmtDto.setItemsForm(itemsForm);
			cmtDto.setItemsProgram(itemsProgram);
			cmtDto.setItemsQuality(itemsQuality);
			result.put("entity", cmtDto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingQsDocCmtDto());
		}
	
		return result;
	}
}
