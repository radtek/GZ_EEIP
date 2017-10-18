package org.pangolin.eeip.dto;

/***
 * 质量体系文件修改意见
 * @author Tinggui Zhu
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.MeetingQsDocCmt;
import org.pangolin.eeip.entity.MeetingQsDocCmtItem;

public class MeetingQsDocCmtDto {

	private String id;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private String creatorId;
	
	private String creatorName;
	
	private String creatorAlias;
	
	private String meetingAppId;
	
	private Integer status;
	
	private List<MeetingQsDocCmtItem> itemsQuality = new ArrayList<MeetingQsDocCmtItem>(); //质量体系文件修改意见细项（质量手册）
	
	private List<MeetingQsDocCmtItem> itemsProgram = new ArrayList<MeetingQsDocCmtItem>(); //质量体系文件修改意见细项（程序文件）
	
	private List<MeetingQsDocCmtItem> itemsForm = new ArrayList<MeetingQsDocCmtItem>(); //质量体系文件修改意见细项（作业指导书，表格类）
	
	public static MeetingQsDocCmt convertToMeetingQsDocCmt(MeetingQsDocCmtDto dto) {
		MeetingQsDocCmt cmt = new MeetingQsDocCmt();
		cmt.setCreatedDate(dto.getCreatedDate());
		cmt.setCreatorAlias(dto.getCreatorAlias());
		cmt.setCreatorId(dto.getCreatorId());
		cmt.setCreatorName(dto.getCreatorName());
		cmt.setModifiedDate(dto.getModifiedDate());
		cmt.setMeetingAppId(dto.getMeetingAppId());
		cmt.setStatus(dto.getStatus());
		
		return cmt;
	}
	
	public static MeetingQsDocCmtDto converToMeetingQsDocCmtDto(MeetingQsDocCmt cmt) {
		MeetingQsDocCmtDto dto = new MeetingQsDocCmtDto();
		dto.setCreatedDate(cmt.getCreatedDate());
		dto.setCreatorAlias(cmt.getCreatorAlias());
		dto.setCreatorId(cmt.getCreatorId());
		dto.setCreatorName(cmt.getCreatorName());
		dto.setMeetingAppId(cmt.getMeetingAppId());
		dto.setModifiedDate(cmt.getModifiedDate());
		dto.setStatus(cmt.getStatus());
		
		return dto;
	}
	
	/***
	 * 是否保存质量体系细项
	 * @param item
	 * @return
	 */
	public static boolean isSave(MeetingQsDocCmtItem item) {
		if ( item.getModif() == null && item.getOpinion() == null && item.getOriginal() == null && item.getReason() == null ) return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorAlias() {
		return creatorAlias;
	}

	public void setCreatorAlias(String creatorAlias) {
		this.creatorAlias = creatorAlias;
	}

	public List<MeetingQsDocCmtItem> getItemsQuality() {
		return itemsQuality;
	}

	public void setItemsQuality(List<MeetingQsDocCmtItem> itemsQuality) {
		this.itemsQuality = itemsQuality;
	}

	public List<MeetingQsDocCmtItem> getItemsProgram() {
		return itemsProgram;
	}

	public void setItemsProgram(List<MeetingQsDocCmtItem> itemsProgram) {
		this.itemsProgram = itemsProgram;
	}

	public List<MeetingQsDocCmtItem> getItemsForm() {
		return itemsForm;
	}

	public void setItemsForm(List<MeetingQsDocCmtItem> itemsForm) {
		this.itemsForm = itemsForm;
	}

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
