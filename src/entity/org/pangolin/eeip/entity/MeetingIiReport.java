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
 * 不符合项报告
 * @author zhutinggui
 *
 */
@Entity
@Table(name ="t_meeting_ii_report")
public class MeetingIiReport extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 8045067232175954569L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	
	/**
	 * 严重性评价- 严重不符合
	 * */
	public static final Integer SERIOUS = new Integer(0);
	
	/**
	 * 严重性评价 - 一般不符合
	 * */
	public static final Integer GENERAL = new Integer(1);
	
	/**
	 * 严重性评价 - 轻微不符合
	 * */
	public static final Integer SLIGHT = new Integer(2);
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 被申岗位
	 */
	@Column(name = "f_audited_post", length = 50, nullable = true)
	private String auditedPost;
	
	/***
	 * 审核依据文件
	 */
	@Column(name = "f_gist", length = 200, nullable = true)
	private String gist;
	
	/***
	 * 不符合事实陈述
	 */
	@Column(name = "f_statement", length = 200, nullable = true)
	private String statement;
	
	/***
	 * 严重性评价（0：严重不符合，1：一般不符合，2：轻微不符合）
	 */
	@Column(name = "f_evaluation", nullable = true)
	private Integer evaluation;
	
	/***
	 * 拟采取纠正措施及完成
	 */
	@Type(type = "text")
	@Column(name = "f_adj_opinion", nullable = true)
	private String adjOpinion;
	
	/***
	 * 纠正措施验证情况
	 */
	@Type(type = "text")
	@Column(name = "f_ver_opinion", nullable = true)
	private String verOpinion;
	
	/***
	 * 被审核方确认意见
	 */
	@Type(type = "text")
	@Column(name = "f_conf_opinion", nullable = true)
	private String confOpinion;
	
	/***
	 * 纠正措施完成情况
	 */
	@Type(type = "text")
	@Column(name = "f_sitn_opinion", nullable = true)
	private String sitnOpinion;
	
	/***
	 * 规定
	 */
	@Column(name = "f_provisions", length = 200, nullable = true)
	private String provisions;
	
	/***
	 * 责任人ID
	 */
	@Column(name = "f_principal_id", length = 32, nullable = false)
	private String principalId;
	
	/***
	 * 责任人账号
	 */
	@Column(name = "f_principal_name", length = 50, nullable = false)
	private String principalName;
	
	/***
	 * 责任人姓名
	 */
	@Column(name = "f_principal_alias", length = 50, nullable = false)
	private String principalAlias;
	
	/***
	 * 内审员ID
	 */
	@Column(name = "f_auditor_id", length = 32, nullable = true)
	private String auditorId;
	
	/***
	 * 内审员账号
	 */
	@Column(name = "f_auditor_name", length = 50, nullable = true)
	private String auditorName;
	
	/***
	 * 内审员姓名
	 */
	@Column(name = "f_auditor_alias", length = 50, nullable = true)
	private String auditorAlias;
	
	/***
	 * 质量或技术负责人ID
	 */
	@Column(name = "f_approver_id", length = 32, nullable = true)
	private String approverId;
	
	/***
	 * 质量或技术负责人账号
	 */
	@Column(name = "f_approver_name", length = 50, nullable = true)
	private String approverName;
	
	/***
	 * 质量或技术负责人姓名
	 */
	@Column(name = "f_approver_alias", length = 50, nullable = true)
	private String approverAlias;
	
	/***
	 * 内审时间（不符合事实陈述内审时使用）
	 */
	@Column(name = "f_stmt_audited_date", nullable = true)
	private Date stmtAuditedDate;
	
	/***
	 * 内审时间（拟采取纠正措施及完成时间内审时使用）
	 */
	@Column(name = "f_adj_audited_date", nullable = true)
	private Date adjAuditedDate;
	
	/***
	 * 内审时间（纠正措施验证情况内审时使用）
	 */
	@Column(name = "f_ver_audited_date", nullable = true)
	private Date  verAuditedDate;
	
	/***
	 * 质量或技术负责人 - 严重性评价时间
	 */
	@Column(name = "f_approved_date", nullable = true)
	private Date approvedDate;
	
	/***
	 * 责任人填报时间（被审核方确认意见填报时使用）
	 */
	@Column(name = "f_conf_reported_date", nullable = true)
	private Date confReportedDate;
	
	/***
	 * 责任人填报时间（拟采取纠正措施及完成时间填报时使用）
	 */
	@Column(name = "f_adj_reported_date", nullable = true)
	private Date adjReportedDate;
	
	/***
	 * 责任人填报时间（纠正措施完成情况填报时使用）
	 */
	@Column(name = "f_sitn_reported_date", nullable = true)
	private Date sitnReportedDate;
	
	/***
	 * 会议申请ID
	 */
	@Column(name = "fk_meeting_app_id", length = 32, nullable = false)
	private String meetingAppId;

	/***
	 * 参会人ID
	 */
	@Column(name = "fk_meeting_participant_id", length = 32, nullable = false)
	private String meetingParticipantId;
	
	/***
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = MeetingDoc.NORMAL;

	public MeetingIiReport() {
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

	public String getAuditedPost() {
		return auditedPost;
	}

	public void setAuditedPost(String auditedPost) {
		this.auditedPost = auditedPost;
	}

	public String getGist() {
		return gist;
	}

	public void setGist(String gist) {
		this.gist = gist;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

	public String getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(String principalId) {
		this.principalId = principalId;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getPrincipalAlias() {
		return principalAlias;
	}

	public void setPrincipalAlias(String principalAlias) {
		this.principalAlias = principalAlias;
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

	public Date getStmtAuditedDate() {
		return stmtAuditedDate;
	}

	public void setStmtAuditedDate(Date stmtAuditedDate) {
		this.stmtAuditedDate = stmtAuditedDate;
	}

	public Date getAdjAuditedDate() {
		return adjAuditedDate;
	}

	public void setAdjAuditedDate(Date adjAuditedDate) {
		this.adjAuditedDate = adjAuditedDate;
	}

	public Date getVerAuditedDate() {
		return verAuditedDate;
	}

	public void setVerAuditedDate(Date verAuditedDate) {
		this.verAuditedDate = verAuditedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getConfReportedDate() {
		return confReportedDate;
	}

	public void setConfReportedDate(Date confReportedDate) {
		this.confReportedDate = confReportedDate;
	}

	public Date getAdjReportedDate() {
		return adjReportedDate;
	}

	public void setAdjReportedDate(Date adjReportedDate) {
		this.adjReportedDate = adjReportedDate;
	}

	public Date getSitnReportedDate() {
		return sitnReportedDate;
	}

	public void setSitnReportedDate(Date sitnReportedDate) {
		this.sitnReportedDate = sitnReportedDate;
	}

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}

	public String getMeetingParticipantId() {
		return meetingParticipantId;
	}

	public void setMeetingParticipantId(String meetingParticipantId) {
		this.meetingParticipantId = meetingParticipantId;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getAdjOpinion() {
		return adjOpinion;
	}

	public void setAdjOpinion(String adjOpinion) {
		this.adjOpinion = adjOpinion;
	}

	public String getVerOpinion() {
		return verOpinion;
	}

	public void setVerOpinion(String verOpinion) {
		this.verOpinion = verOpinion;
	}

	public String getConfOpinion() {
		return confOpinion;
	}

	public void setConfOpinion(String confOpinion) {
		this.confOpinion = confOpinion;
	}

	public String getSitnOpinion() {
		return sitnOpinion;
	}

	public void setSitnOpinion(String sitnOpinion) {
		this.sitnOpinion = sitnOpinion;
	}

	public String getProvisions() {
		return provisions;
	}

	public void setProvisions(String provisions) {
		this.provisions = provisions;
	}
	
	
}
