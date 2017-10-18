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

/**
 * 电子物证（检材）鉴定文书修订
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_appraisal_revise")
public class AppraisalRevise extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 9126356141960575026L;
	
	/**
	 * 审批状态（0：草稿；)	
	 * */
	public static final Integer DRAFT = new Integer(0);
	
	/**
	 * 审批状态（1：初审；)	
	 * */
	public static final Integer FIRST_TRIAL = new Integer(1);
	
	/**
	 * 审批状态（2：二审；)	
	 * */
	public static final Integer SECOND_TRIAL = new Integer(2);
	
	/**
	 * 审批状态（3：审批；)	
	 * */
	public static final Integer EXAMINE_AND_APPROVE = new Integer(3);
	
	/**
	 * 审批状态（4：申请通过；)	
	 * */
	public static final Integer APPLICATION_PASS = new Integer(4);
	
	/**
	 * 审批状态（5：申请拒绝；)	
	 * */
	public static final Integer APPLICATION_REFUSE = new Integer(5);
	
	/**
	 * 审批状态（6：修改完成；)	
	 * */
	public static final Integer UPDATE_END = new Integer(6);
	
	/**
	 * 审批状态（7：修改通过；)	
	 * */
	public static final Integer UPDATE_PASS = new Integer(7);
	
	
	/**
	 * 审批状态（7：修改拒绝；)	
	 * */
	public static final Integer UPDATE_REFUSE = new Integer(8);
	
	
	/**
	 * 修改方式（0：原件杠改盖章；）	
	 * */
	public static final Integer NEW_AFFIX = new Integer(0);
	
	
	/**
	 * 修改方式（1：收回原件，重新出具鉴定文书；）	
	 * */
	public static final Integer WITHDRAW = new Integer(1);
	
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/**
	 * 委托单位ID（数据源自系统管理的组织架构）
	 */
	@Column(name = "f_org_id", length = 32, nullable = false)
	private String orgId;
	
	/**
	 * 委托单位名称（数据源自系统管理的组织架构）
	 */
	@Column(name = "f_org_name", length = 100, nullable = false)
	private String orgName;
	
	/**
	 * 鉴定文书编号
	 */
	@Column(name = "f_report_sn", length = 50, nullable = false)
	private String reportSn;
	
	/**
	 * 鉴定文书名称
	 */
	@Column(name = "f_report_name", length = 100, nullable = false)
	private String reportName;
	
	/**
	 * 修改人ID
	 */
	@Column(name = "f_modifier_id", length = 32, nullable = true)
	private String modifierId;
	
	/**
	 * 修改人账号
	 */
	@Column(name = "f_modifier_name", length = 50, nullable = true)
	private String modifierName;
	
	/**
	 * 修改人姓名
	 */
	@Column(name = "f_modifier_alias", length = 50, nullable = true)
	private String modifierAlias;
	
	/**
	 * （文书）修改时间
	 */
	@Column(name = "f_revised_date", nullable = true)
	private Date revisedDate;
	
	/**
	 * 修改内容
	 */
	@Column(name = "f_revised_content", nullable = true)
	@Type(type="text")
	private String revisedContent;
	
	/**
	 * 修改方式（0：原件杠改盖章；1：收回原件，重新出具鉴定文书）
	 */
	@Column(name = "f_method" , length = 1, nullable = true)
	private Integer method;
	
	/**
	 * 审核员（授权签字人）ID
	 */
	@Column(name = "f_auth_auditor_id" , length = 32, nullable = true)
	private String authAuditorId;
	
	/**
	 * 审核员（授权签字人）帐号
	 */
	@Column(name = "f_auth_auditor_name" , length = 50, nullable = true)
	private String authAuditorName;
	
	/**
	 * 审核员（授权签字人）姓名
	 */
	@Column(name = "f_auth_auditor_alias" , length = 50, nullable = true)
	private String authAuditorAlias;
	
	/**
	 * （授权签字人）审核意见
	 */
	@Column(name = "f_auth_auditor_opinion" , nullable = true)
	@Type(type="text")
	private String authAuditorOpinion;
	
	/**
	 * （授权签字人）审核时间
	 */
	@Column(name = "f_auth_audited_date", nullable = true)
	private Date authAuditedDate;
	
	/**
	 * 审核员（技术负责人）ID
	 */
	@Column(name = "f_tech_auditor_id" , length = 32, nullable = true)
	private String techAuditorId;
	
	/**
	 * 审核员（技术负责人）帐号
	 */
	@Column(name = "f_tech_auditor_name" , length = 50, nullable = true)
	private String techAuditorName;
	
	/**
	 * 审核员（技术负责人）姓名
	 */
	@Column(name = "f_tech_auditor_alias" , length = 50, nullable = true)
	private String techAuditorAlias;
	
	/**
	 * （技术负责人）审核意见
	 */
	@Column(name = "f_tech_auditor_opinion" , nullable = true)
	@Type(type="text")
	private String techAuditorOpinion;
	
	/**
	 * （技术负责人）审核时间
	 */
	@Column(name = "f_tech_audited_date", nullable = true)
	private Date techAuditedDate;
	
	/**
	 *	审批者（鉴定机构负责人）ID
	 * */
	@Column(name = "f_approver_id", length = 32 , nullable = true)
	private String approverId;
	
	/**
	 * 审批者（鉴定机构负责人）帐号	
	 * */
	@Column(name = "f_approver_name",length = 50,nullable = true)
	private String approverName;
	
	/**
	 * 审批者（鉴定机构负责人）姓名
	 * */
	@Column(name = "f_approver_alias",length = 50,nullable = true)
	private String approverAlias;
	
	/**
	 * （鉴定机构负责人）审批意见
	 * */
	@Column(name = "f_approver_opinion",nullable = true)
	@Type(type="text")
	private String approverOpinion;

	/**
	 * （鉴定机构负责人）审批时间
	 * */
	@Column(name = "f_approved_date",nullable = true)
	private Date approvedDate;
	
	/**
	 * 创建时间（申请时间）
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * （申请内容）修改时间
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
	
	/**
	 * 创建人（申请人）ID
	 * */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 创建人（申请人）帐号
	 * */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建人（申请人）姓名
	 * */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 修改申请状态（0：草稿；1：初审；2：二审；3：审批；4：申请通过；5：申请拒绝；6：修改完成；7：修改通过；8：修改拒绝）
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status;
	
	/**
	 * （鉴定机构负责人）结果审批意见
	 * */
	@Column(name = "f_result_opinion", nullable = true)
	@Type(type="text")
	private String resultOpinion;
	
	 
	/**
	 * 电子物证（检材）鉴定ID
	 * */
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;
	
	/**
	 * 电子物证预检信息ID
	 * */
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;

	public AppraisalRevise() {}
	
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getReportSn() {
		return reportSn;
	}

	public void setReportSn(String reportSn) {
		this.reportSn = reportSn;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public String getModifierAlias() {
		return modifierAlias;
	}

	public void setModifierAlias(String modifierAlias) {
		this.modifierAlias = modifierAlias;
	}

	public Date getRevisedDate() {
		return revisedDate;
	}

	public void setRevisedDate(Date revisedDate) {
		this.revisedDate = revisedDate;
	}

	public String getRevisedContent() {
		return revisedContent;
	}

	public void setRevisedContent(String revisedContent) {
		this.revisedContent = revisedContent;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public String getAuthAuditorId() {
		return authAuditorId;
	}

	public void setAuthAuditorId(String authAuditorId) {
		this.authAuditorId = authAuditorId;
	}

	public String getAuthAuditorName() {
		return authAuditorName;
	}

	public void setAuthAuditorName(String authAuditorName) {
		this.authAuditorName = authAuditorName;
	}

	public String getAuthAuditorAlias() {
		return authAuditorAlias;
	}

	public void setAuthAuditorAlias(String authAuditorAlias) {
		this.authAuditorAlias = authAuditorAlias;
	}

	public String getAuthAuditorOpinion() {
		return authAuditorOpinion;
	}

	public void setAuthAuditorOpinion(String authAuditorOpinion) {
		this.authAuditorOpinion = authAuditorOpinion;
	}

	public Date getAuthAuditedDate() {
		return authAuditedDate;
	}

	public void setAuthAuditedDate(Date authAuditedDate) {
		this.authAuditedDate = authAuditedDate;
	}

	public String getTechAuditorId() {
		return techAuditorId;
	}

	public void setTechAuditorId(String techAuditorId) {
		this.techAuditorId = techAuditorId;
	}

	public String getTechAuditorName() {
		return techAuditorName;
	}

	public void setTechAuditorName(String techAuditorName) {
		this.techAuditorName = techAuditorName;
	}

	public String getTechAuditorAlias() {
		return techAuditorAlias;
	}

	public void setTechAuditorAlias(String techAuditorAlias) {
		this.techAuditorAlias = techAuditorAlias;
	}

	public String getTechAuditorOpinion() {
		return techAuditorOpinion;
	}

	public void setTechAuditorOpinion(String techAuditorOpinion) {
		this.techAuditorOpinion = techAuditorOpinion;
	}

	public Date getTechAuditedDate() {
		return techAuditedDate;
	}

	public void setTechAuditedDate(Date techAuditedDate) {
		this.techAuditedDate = techAuditedDate;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}

	public String getResultOpinion() {
		return resultOpinion;
	}

	public void setResultOpinion(String resultOpinion) {
		this.resultOpinion = resultOpinion;
	}
}