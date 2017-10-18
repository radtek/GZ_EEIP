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

/***
 * 管理评审报告表
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_meeting_ma_report")
public class MeetingMaReport extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7500551419071774137L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 审核状态 - 草稿
	 * */
	public static final Integer STATUS_DRAFT = new Integer(0);
	
	/**
	 * 审核状态 - 待审核
	 * */
	public static final Integer STATUS_TO_AUDIT = new Integer(1);
	
	/**
	 * 审核状态  - 通过
	 * */
	public static final Integer STATUS_AGREE = new Integer(2);
	
	/**
	 * 审核状态  - 拒绝
	 * */
	public static final Integer STATUS_REJECT = new Integer(3);
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 报告编号
	 */
	@Column(name = "f_sn", length = 50, nullable = false)
	private String sn;
	
	/***
	 * 计划表编号
	 */
	@Column(name = "f_plan_sn", length = 50, nullable = false)
	private String planSn;
	
	/***
	 * 主持人ID
	 */
	@Column(name = "f_emcee_id", length = 32, nullable = true)
	private String emceeId;
	
	/***
	 * 主持人账号
	 */
	@Column(name = "f_emcee_name", length = 50, nullable = true)
	private String emceeName;
	
	/***
	 * 主持人姓名
	 */
	@Column(name = "f_emcee_alias", length = 50, nullable = true)
	private String emceeAlias;
	
	/***
	 * 审批时间
	 */
	@Column(name = "f_audited_date", nullable = true)
	private Date auditedDate;
	
	/***
	 * 审批地点
	 */
	@Column(name = "f_location", length = 200, nullable = true)
	private String location;
	
	/***
	 * 审批目的
	 */
	@Column(name = "f_purpose", length = 200, nullable = true)
	private String purpose;
	
	/***
	 * 审批依据
	 */
	@Column(name = "f_gist", length = 200, nullable = true)
	private String gist;
	
	/***
	 * 备注
	 */
	@Column(name = "f_remarks", length = 200, nullable = true)
	private String remarks;
	
	/***
	 * 评审结论及相关建议
	 */
	@Type(type = "text")
	@Column(name = "f_conclusion", nullable = true)
	private String conclusion;
	
	/***
	 * 审批人ID
	 */
	@Column(name = "f_approver_id", length = 32, nullable = true)
	private String approverId;
	
	/***
	 * 审批人账号
	 */
	@Column(name = "f_approver_name", length = 50, nullable = true)
	private String approverName;
	
	/***
	 * 审批人姓名
	 */
	@Column(name = "f_approver_alias", length = 50, nullable = true)
	private String approverAlias;
	
	/***
	 * 审批意见
	 */
	@Type(type = "text")
	@Column(name = "f_opinion", nullable = true)
	private String opinion;
	
	/***
	 * 审批时间
	 */
	@Column(name = "f_approved_date", nullable = true)
	private Date approvedDate;
	
	/***
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	/***
	 * 创建时间（编制时间）
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/***
	 * 创建者ID（编制人）
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
	 * 审核状态（0：草稿，1：待审，2：通过，3：拒绝）
	 */
	@Column(name = "f_status", nullable = false)
	private Integer status;
	
	/***
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = MeetingIaReport.NORMAL;
	
	/***
	 * 会议申请ID
	 */
	@Column(name = "fk_meeting_app_id", length = 32, nullable = false)
	private String meetingAppId;
	
	public MeetingMaReport(){}
	
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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPlanSn() {
		return planSn;
	}

	public void setPlanSn(String planSn) {
		this.planSn = planSn;
	}

	public String getEmceeId() {
		return emceeId;
	}

	public void setEmceeId(String emceeId) {
		this.emceeId = emceeId;
	}

	public String getEmceeName() {
		return emceeName;
	}

	public void setEmceeName(String emceeName) {
		this.emceeName = emceeName;
	}

	public String getEmceeAlias() {
		return emceeAlias;
	}

	public void setEmceeAlias(String emceeAlias) {
		this.emceeAlias = emceeAlias;
	}

	public Date getAuditedDate() {
		return auditedDate;
	}

	public void setAuditedDate(Date auditedDate) {
		this.auditedDate = auditedDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getGist() {
		return gist;
	}

	public void setGist(String gist) {
		this.gist = gist;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
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

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	
}
