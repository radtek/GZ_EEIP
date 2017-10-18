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
 * 内部评审会议需审核文件
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_meeting_ia_report")
public class MeetingIaReport extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 5084763679108885256L;

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
	
	/**
	 * 审核目的 - 例行审核
	 * */
	public static final Integer PURPOSE_ROUTINE = new Integer(0);
	
	/**
	 * 审核目的 - 特殊审核
	 * */
	public static final Integer PURPOSE_SPECIAL = new Integer(1);
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 编号-年份
	 */
	@Column(name = "f_year", length = 4, nullable = false)
	private String year;
	
	/***
	 * 编号-次数
	 */
	@Column(name = "f_time", length = 4, nullable = false)
	private String time;
	
	/***
	 * 审核范围
	 */
	@Column(name = "f_scope", length = 200, nullable = true)
	private String scope;
	
	/***
	 * 审核目的(0：例行审核，1：特殊审核)
	 */
	@Column(name = "f_purpose", length = 1, nullable = true)
	private Integer purpose;
	
	/***
	 * 审核开始时间
	 */
	@Column(name = "f_start_date", nullable = true)
	private Date startDate;

	/***
	 * 审核结束时间
	 */
	@Column(name = "f_end_date", nullable = true)
	private Date endDate;

	/***
	 * 审核依据
	 */
	@Column(name = "f_gist", length = 200, nullable = true)
	private String gist;
	
	/***
	 * 上次审核完成日期
	 */
	@Column(name = "f_last_finished_date", nullable = true)
	private Date lastFinishedDate;
	
	/***
	 * 审核概述
	 */
	@Type(type = "text")
	@Column(name = "f_overview", nullable = true)
	private String overview;
	
	/***
	 * 审核中的不符合项描述
	 */
	@Type(type = "text")
	@Column(name = "f_incongruent_item", nullable = true)
	private String incongruentItem;
	
	/***
	 * 审核问题分析
	 */
	@Type(type = "text")
	@Column(name = "f_problem_analysis", nullable = true)
	private String problemAnalysis;
	
	/***
	 * 总体评价
	 */
	@Type(type = "text")
	@Column(name = "f_overall_eval", nullable = true)
	private String overallEval;
	
	/***
	 * 不符合项的整改
	 */
	@Type(type = "text")
	@Column(name = "f_amendment", nullable = true)
	private String amendment;
	
	/***
	 * 质量负责人签署对内审结果的批准意见
	 */
	@Type(type = "text")
	@Column(name = "f_opinion", nullable = true)
	private String opinion;
	
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
	private Integer status = MeetingIaReport.STATUS_DRAFT;
	
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

	
	public MeetingIaReport(){}
	
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getPurpose() {
		return purpose;
	}

	public void setPurpose(Integer purpose) {
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

	public String getGist() {
		return gist;
	}

	public void setGist(String gist) {
		this.gist = gist;
	}

	public Date getLastFinishedDate() {
		return lastFinishedDate;
	}

	public void setLastFinishedDate(Date lastFinishedDate) {
		this.lastFinishedDate = lastFinishedDate;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getIncongruentItem() {
		return incongruentItem;
	}

	public void setIncongruentItem(String incongruentItem) {
		this.incongruentItem = incongruentItem;
	}

	public String getProblemAnalysis() {
		return problemAnalysis;
	}

	public void setProblemAnalysis(String problemAnalysis) {
		this.problemAnalysis = problemAnalysis;
	}

	public String getOverallEval() {
		return overallEval;
	}

	public void setOverallEval(String overallEval) {
		this.overallEval = overallEval;
	}

	public String getAmendment() {
		return amendment;
	}

	public void setAmendment(String amendment) {
		this.amendment = amendment;
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

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
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
	
	
}
