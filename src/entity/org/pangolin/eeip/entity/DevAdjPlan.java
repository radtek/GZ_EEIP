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
 * 仪器设备核查/校准/维修申请表
 * @author JinRuiWang
 *
 */
@Entity
@Table(name = "t_dev_adj_plan")
public class DevAdjPlan extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8165711292645034879L;

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
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = DevAdjPlan.NORMAL;
	
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
	 * 计划标题（如：仪器设备的期间核查/校准2017年计划）	
	 * */
	@Column(name = "f_title", length = 200, nullable = false)
	private String title;
	
	/**
	 * 年度（如2017）
	 * */
	@Column(name = "t_year", length = 4, nullable = false)
	private String year;
	
	/**
	 * 审批人（技术负责人）ID
	 * */
	@Column(name = "f_approver_id", length = 40, nullable = true)
	private String approverId;
	
	/**
	 *	审批人（技术负责人）帐号		
	 * */
	@Column(name = "f_approver_name", length = 50, nullable = true)
	private String approverName;
	
	/**
	 *	审批人（技术负责人）姓名		
	 * */
	@Column(name = "f_approver_alias", length = 50, nullable = true)
	private String approverAlias;
	
	/**
	 *	审批意见
	 * */
	@Column(name = "f_opinion", nullable = true)
	@Type(type="text")
	private String opinion;

	/**
	 *	审批时间			
	 * */
	@Column(name = "f_approved_date", nullable = true)
	private Date approvedDate;
	
	/**
	 *	审批状态（0：草稿；1：待审批；2：通过；3：拒绝）				
	 * */
	@Column(name = "f_status",length = 1, nullable = false)
	private Integer status;

	/**
	 *	修改时间			
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	public DevAdjPlan() {};
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}