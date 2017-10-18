package org.pangolin.eeip.dto;

/***
 * 会议申请
 * @author Tinggui Zhu
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.MeetingApp;
import org.pangolin.eeip.entity.MeetingIaParticipant;
import org.pangolin.eeip.entity.MeetingParticipant;

public class MeetingAppDto {

	private String id;
	
	private Integer type;
	
	private String subject;
	
	private String purpose;
	
	private Date startDate;
	
	private Date endDate;
	
	private String remarks;
	
	private String approverId;
	
	private String approverName;
	
	private String approverAlias;
	
	private String opinion;
	
	private Date approvedDate;
	
	private Date modifiedDate;
	
	private Date createdDate;
	
	private String creatorId;
	
	private String creatorName;
	
	private String creatorAlias;
	
	private Integer status;
	
	private Integer delFlag;
	
	private String meetingRoomId;
	
	private String meetingRoomName;
	
	private List<MeetingParticipant> participants = new ArrayList<MeetingParticipant>(); //参与人员
	
	private List<MeetingIaParticipant> iaParticipants = new ArrayList<MeetingIaParticipant>(); //审核人员
	
	private List<String> add = new ArrayList<String>(); // 新增的会议文件
	
	public static MeetingAppDto converToMeetingAppDto(MeetingApp meetingApp) {
		MeetingAppDto dto = new MeetingAppDto();
		dto.setApprovedDate(meetingApp.getApprovedDate());
		dto.setApproverAlias(meetingApp.getApproverAlias());
		dto.setApproverId(meetingApp.getApproverId());
		dto.setApproverName(meetingApp.getApproverName());
		dto.setCreatedDate(meetingApp.getCreatedDate());
		dto.setCreatorAlias(meetingApp.getCreatorAlias());
		dto.setCreatorId(meetingApp.getCreatorId());
		dto.setCreatorName(meetingApp.getCreatorName());
		dto.setDelFlag(meetingApp.getDelFlag());
		dto.setEndDate(meetingApp.getEndDate());
		dto.setId(meetingApp.getId());
		dto.setMeetingRoomId(meetingApp.getMeetingRoomId());
		dto.setMeetingRoomName(meetingApp.getMeetingRoomName());
		dto.setModifiedDate(meetingApp.getModifiedDate());
		dto.setOpinion(meetingApp.getOpinion());
		dto.setPurpose(meetingApp.getPurpose());
		dto.setRemarks(meetingApp.getRemarks());
		dto.setStartDate(meetingApp.getStartDate());
		dto.setStatus(meetingApp.getStatus());
		dto.setSubject(meetingApp.getSubject());
		dto.setType(meetingApp.getType());
		return dto;
	}
	
	public static MeetingApp converToMeetingApp(MeetingAppDto dto) {
		MeetingApp meetingApp = new MeetingApp();
		meetingApp.setApprovedDate(dto.getApprovedDate());
		meetingApp.setApproverAlias(dto.getApproverAlias());
		meetingApp.setApproverId(dto.getApproverId());
		meetingApp.setApproverName(dto.getApproverName());
		meetingApp.setCreatedDate(dto.getCreatedDate());
		meetingApp.setCreatorAlias(dto.getCreatorAlias());
		meetingApp.setCreatorId(dto.getCreatorId());
		meetingApp.setCreatorName(dto.getCreatorName());
		meetingApp.setDelFlag(dto.getDelFlag());
		meetingApp.setEndDate(dto.getEndDate());
		meetingApp.setId(dto.getId());
		meetingApp.setMeetingRoomId(dto.getMeetingRoomId());
		meetingApp.setMeetingRoomName(dto.getMeetingRoomName());
		meetingApp.setModifiedDate(dto.getModifiedDate());
		meetingApp.setOpinion(dto.getOpinion());
		meetingApp.setPurpose(dto.getPurpose());
		meetingApp.setRemarks(dto.getRemarks());
		meetingApp.setStartDate(dto.getStartDate());
		meetingApp.setStatus(dto.getStatus());
		meetingApp.setSubject(dto.getSubject());
		meetingApp.setType(dto.getType());
		return meetingApp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public String getApproverAlias() {
		return approverAlias;
	}

	public void setApproverAlias(String approverAlias) {
		this.approverAlias = approverAlias;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getMeetingRoomId() {
		return meetingRoomId;
	}

	public void setMeetingRoomId(String meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public List<MeetingParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<MeetingParticipant> participants) {
		this.participants = participants;
	}

	public List<MeetingIaParticipant> getIaParticipants() {
		return iaParticipants;
	}

	public void setIaParticipants(List<MeetingIaParticipant> iaParticipants) {
		this.iaParticipants = iaParticipants;
	}

	public List<String> getAdd() {
		return add;
	}

	public void setAdd(List<String> add) {
		this.add = add;
	}
	
	
}
