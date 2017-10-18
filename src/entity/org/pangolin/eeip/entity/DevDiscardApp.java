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

/**
 * 固定资产（设备）报废申请表
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_dev_discard_app")
public class DevDiscardApp extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3801768616108764037L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);

	/**
	 * 审批状态（0：草稿；)	
	 * */
	public static final Integer DRAFT = new Integer(0);
	
	/**
	 * 审批状态（1：待审批；）			
	 * */
	public static final Integer PENDING = new Integer(1);
	
	/**
	 * 审批状态（2：通过；）			
	 * */
	public static final Integer PASS = new Integer(2);
	
	/**
	 * 审批状态（3：拒绝；）			
	 * */
	public static final Integer REJECT = new Integer(3);

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = DevDiscardApp.NORMAL;

	/**
	 * 创建者帐号
	 * */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者别名（姓名）
	 * */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate;
	
	/**
	 * 创建者ID
	 * */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;

	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;
	
	/**
	 * 拟报废原因		
	 * */
	@Column(name = "f_reason", nullable = false)
	@Type(type="text")
	private String reason;

	/**
	 * 备注
	 * */
	@Column(name = "f_remarks", length = 150, nullable = true)
	private String remarks;

	/**
	 * 审核者（技术负责人）ID
	 * */
	@Column(name = "f_auditor_id", length = 32, nullable = true)
	private String auditorId;
	
	/**
	 * 审核者（技术负责人）帐号		
	 * */
	@Column(name = "f_auditor_name", length = 50, nullable = true)
	private String auditorName;
	
	/**
	 * 审核者（技术负责人）姓名	
	 * */
	@Column(name = "f_auditor_alias", length = 50, nullable = true)
	private String auditorAlias;
	
	/**
	 * 审核意见
	 * */
	@Column(name = "f_auditor_opinion", nullable = true)
	@Type(type="text")
	private String auditorOpinion;

	/**
	 * 审核时间		
	 * */
	@Column(name = "f_audited_date",nullable = true)
	private Date auditedDate;

	/**
	 * 审批人（实验室负责人）ID		
	 * */
	@Column(name = "f_approver_id",length = 32,nullable = true)
	private String ApproverId;
	
	/**
	 * 审批人（实验室负责人）帐号		
	 * */
	@Column(name = "f_approver_name",length = 50,nullable = true)
	private String approverName;
	
	/**
	 * 审批人（实验室负责人）姓名	
	 * */
	@Column(name = "f_approver_alias",length = 50,nullable = true)
	private String approverAlias;
	
	/**
	 * 审批意见	
	 * */
	@Column(name = "f_approver_opinion",nullable = true)
	@Type(type="text")
	private String approverOpinion;

	/**
	 * 审批时间	
	 * */
	@Column(name = "f_approved_date",nullable = true)
	private Date approvedDate;
	
	
	/**
	 * 审批状态（0：草稿；1：待审批；2：通过；3：拒绝）		
	 * */
	@Column(name = "f_status",length = 1,nullable = false)
	private Integer status;

	public DevDiscardApp() {};

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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getAuditorAlias() {
		return auditorAlias;
	}

	public void setAuditorAlias(String auditorAlias) {
		this.auditorAlias = auditorAlias;
	}

	public String getAuditorOpinion() {
		return auditorOpinion;
	}

	public void setAuditorOpinion(String auditorOpinion) {
		this.auditorOpinion = auditorOpinion;
	}

	public Date getAuditedDate() {
		return auditedDate;
	}

	public void setAuditedDate(Date auditedDate) {
		this.auditedDate = auditedDate;
	}
	
	public String getApproverId() {
		return ApproverId;
	}

	public void setApproverId(String approverId) {
		ApproverId = approverId;
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

	public String getApproverOpinion() {
		return approverOpinion;
	}

	public void setApproverOpinion(String approverOpinion) {
		this.approverOpinion = approverOpinion;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
