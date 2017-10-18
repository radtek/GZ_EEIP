package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.pangolin.util.UUIDHexGenerator;

/***
 * 普通会议申请 / 内审会议申请 / 管理评审会议申请 
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_meeting_app")
public class MeetingApp extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7234234926864802771L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 会议类型 - 普通会议
	 * */
	public static final Integer TYPE_NORMAL = new Integer(0);
	
	/**
	 * 会议类型 - 内部评审会议
	 * */
	public static final Integer TYPE_INNER = new Integer(1);
	
	/**
	 * 会议类型 - 管理评审会议
	 * */
	public static final Integer TYPE_MANAGE = new Integer(2);
	
	/**
	 * 会议申请状态 - 草稿
	 * */
	public static final Integer STATUS_DRAFT = new Integer(0);
	
	/**
	 * 会议申请状态 - 待审核
	 * */
	public static final Integer STATUS_TO_AUDIT = new Integer(1);
	
	/**
	 * 会议申请状态  - 通过
	 * */
	public static final Integer STATUS_AGREE = new Integer(2);
	
	/**
	 * 会议申请状态  - 拒绝
	 * */
	public static final Integer STATUS_REJECT = new Integer(3);
	
	/**
	 * 会议申请状态 - 文件上传
	 * */
	public static final Integer FIEL_UPLOAD  = new Integer(4);
	
	/**
	 * 会议申请状态  - 文件审核
	 * */
	public static final Integer FILE_APPROVE = new Integer(5);
	
	/**
	 * 会议申请状态  - 完成
	 * */
	public static final Integer FINISH = new Integer(6);
	
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/***
	 * 会议类型（0：普通会议，1：内部评审会议，2：管理评审会议）
	 */
	@Column(name = "f_type", nullable = false)
	private Integer type;
	
	/***
	 * 会议主题
	 */
	@Column(name = "f_subject", length = 50, nullable = false)
	private String subject;
	
	/***
	 * 评审目的
	 */
	@Column(name = "f_purpose", length = 255, nullable = true)
	private String purpose;
	
	/***
	 * 开始时间
	 */
	@Column(name = "f_start_date", nullable = false)
	private Date startDate;
	
	/***
	 * 结束时间
	 */
	@Column(name = "f_end_date", nullable = true)
	private Date endDate;
	
	/***
	 * 备注
	 */
	@Column(name = "f_remarks", length = 200, nullable = true)
	private String remarks;
	
	/***
	 * 会议审批人ID
	 */
	@Column(name = "f_approver_id", length = 32, nullable = true)
	private String approverId;
	
	/***
	 * 会议审批人账号
	 */
	@Column(name = "f_approver_name", length = 50, nullable = true)
	private String approverName;
	
	/***
	 * 会议审批人姓名
	 */
	@Column(name = "f_approver_alias", length = 50, nullable = true)
	private String approverAlias;
	
	/***
	 * 会议审批意见
	 */
	@Type(type = "text")
	@Column(name = "f_opinion", nullable = true)
	private String opinion;
	
	/***
	 * 会议审批时间
	 */
	@Column(name = "f_approved_date", nullable = true)
	private Date approvedDate;
	
	/***
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	/***
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/***
	 * 创建者ID
	 */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/***
	 * 创建者账号
	 */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/***
	 * 创建者姓名
	 */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/***
	 * 会议申请状态（0：草稿，1：待审，2：通过，3：拒绝）
	 */
	@Column(name = "f_status", nullable = false)
	private Integer status = MeetingApp.STATUS_DRAFT;
	
	/***
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = MeetingApp.NORMAL;
	
	/***
	 * 会议室ID
	 */
	@Column(name = "fk_meeting_room_id", length = 32, nullable = false)
	private String meetingRoomId;
	
	/***
	 * 会议室名称
	 */
	@Column(name = "f_meeting_room_name", length = 50, nullable = false)
	private String meetingRoomName;

	public MeetingApp() {
		// TODO Auto-generated constructor stub
	}

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
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

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}


}
