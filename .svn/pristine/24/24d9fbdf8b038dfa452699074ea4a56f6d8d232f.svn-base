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
 * 仪器设备校准/核查/维修情况登记表（事后登记）
 * @author JinRuiWang
 *
 */
@Entity
@Table(name = "t_dev_adjustment_sitn")
public class DevAdjustmentSitn extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 43645945754513069L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 项目（0：校准；），即登记类型	
	 * */
	public static final Integer TYPE_CALIBRATION = new Integer(0);
	
	/**
	 * 项目（1：检查;），即登记类型	
	 * */
	public static final Integer TYPE_EXAMINE = new Integer(1);
	
	/**
	 * 项目（2：维修），即登记类型	
	 * */
	public static final Integer TYPE_MAINTAIN = new Integer(2);
	
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
	private Integer delFlag = DevAdjustmentSitn.NORMAL;

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
	 * 项目（0：校准；1：检查；2：维修），即登记类型	
	 * */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer type;
	
	/**
	 * 使用经费（单位：元）	
	 * */
	@Column(name = "f_cost", length = 10, nullable = false)
	private Integer cost;
	
	/**
	 * 情况说明	
	 * */
	@Column(name = "f_situation", nullable = true)
	@Type(type="text")
	private String situation;

	/**
	 * 报送人ID	
	 * */
	@Column(name = "f_reporter_id", length = 32, nullable = true)
	private String reporterId;
	
	/**
	 * 报送人帐号
	 * */
	@Column(name = "f_reporter_name", length = 50, nullable = true)
	private String reporterName;
	
	/**
	 * 报送人姓名		
	 * */
	@Column(name = "f_reporter_alias", length = 50, nullable = true)
	private String reporterAlias;
	
	/**
	 * 验收记录	
	 * */
	@Column(name = "f_acceptance", nullable = true)
	@Type(type="text")
	private String acceptance;

	/**
	 * 验收人ID			
	 * */
	@Column(name = "f_acceptor_id", length = 32, nullable = true)
	private String acceptorId;
	
	/**
	 * 验收人帐号			
	 * */
	@Column(name = "f_acceptor_name", length = 50, nullable = true)
	private String acceptorName;
	
	/**
	 * 验收人姓名			
	 * */
	@Column(name = "f_acceptor_alias", length = 50, nullable = true)
	private String acceptorAlias;
	
	/**
	 * 	验收时间	
	 * */
	@Column(name = "f_accepted_date", nullable = true)
	private Date acceptedDate;
	
	/**
	 * 审批人（技术负责人）ID		
	 * */
	@Column(name = "f_approver_id", length = 32, nullable = true)
	private String approverId;
	
	/**
	 * 审批人（技术负责人）帐号
	 * */
	@Column(name = "f_approver_name", length = 50, nullable = true)
	private String approverName;
	
	/**
	 * 审批人（技术负责人）姓名	
	 * */
	@Column(name = "f_approver_alias", length = 50, nullable = true)
	private String approverAlias;

	/**
	 * 审批意见	
	 * */
	@Column(name = "f_opinion", nullable = true)
	@Type(type="text")
	private String opinion;
	
	/**
	 * 审批时间	
	 * */
	@Column(name = "f_approved_date", nullable = true)
	private Date approvedDate;

	/**
	 * 修改时间	
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	/**
	 * 审批状态（0：草稿；1：待阅；2：已阅）			
	 * */
	@Column(name = "f_status", length = 1, nullable = true)
	private Integer status;

	public DevAdjustmentSitn() {};

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getReporterId() {
		return reporterId;
	}

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getReporterAlias() {
		return reporterAlias;
	}

	public void setReporterAlias(String reporterAlias) {
		this.reporterAlias = reporterAlias;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public String getAcceptorId() {
		return acceptorId;
	}

	public void setAcceptorId(String acceptorId) {
		this.acceptorId = acceptorId;
	}

	public String getAcceptorName() {
		return acceptorName;
	}

	public void setAcceptorName(String acceptorName) {
		this.acceptorName = acceptorName;
	}

	public String getAcceptorAlias() {
		return acceptorAlias;
	}

	public void setAcceptorAlias(String acceptorAlias) {
		this.acceptorAlias = acceptorAlias;
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
	
	
}
