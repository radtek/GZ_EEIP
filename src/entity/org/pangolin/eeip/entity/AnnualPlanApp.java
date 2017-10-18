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
 * 年度内部审核计划申请
 * @author Tinggui Zhu
 */
@Entity
@Table(name = "t_annual_plan_app")
public class AnnualPlanApp extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 236294336673131441L;

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
	public static final Integer DRAFT = new Integer(0);
	
	/**
	 * 审核状态 - 待审核
	 * */
	public static final Integer APPROVAL = new Integer(1);
	
	/**
	 * 审核状态  - 通过
	 * */
	public static final Integer PASSED = new Integer(2);
	
	/**
	 * 审核状态  - 拒绝
	 * */
	public static final Integer REJECTED = new Integer(3);
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/***
	 * 年度内部审核计划（与年度字段拼接，如2017年度内部审核计划）
	 */
	@Column(name = "f_title", length = 100, nullable = false)
	private String title;

	/***
	 * 年度（年份）
	 */
	@Column(name = "f_year", length = 20, nullable = false)
	private String year;
	
	/***
	 * 备注
	 */
	@Column(name = "f_remarks", length = 100, nullable = true)
	private String remarks;
	
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
	 * 审核状态（0：草稿，1：待审，2：通过，3：拒绝）
	 */
	@Column(name = "f_status", nullable = false)
	private Integer status = AnnualPlanApp.DRAFT;
	
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
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = AnnualPlanApp.NORMAL;
	
	public AnnualPlanApp() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
}