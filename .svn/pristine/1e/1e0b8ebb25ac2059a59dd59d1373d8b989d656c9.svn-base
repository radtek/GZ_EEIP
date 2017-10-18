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
 * 电子物证（检材）鉴定历史记录
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_appraisal_history")
public class AppraisalHistory extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6593933202564090650L;

	public AppraisalHistory() {}
	
	
	/**
	 * 鉴定专业（0：数据恢复）
	 * */
	public static final Integer RECOVERY_DATA = new Integer(0);
	
	/**
	 * 鉴定专业（1：数据分析；）
	 * */
	public static final Integer DATA_ANALYSIS = new Integer(1);
	
	/**
	 * 鉴定专业（2：系统分析）
	 * */
	public static final Integer SYSTEM_ANALYSIS = new Integer(2);
	
	/**
	 * 鉴定专业（3：数据提取固定）
	 * */
	public static final Integer DATA_EXTRACTION_ANALYSIS = new Integer(3);

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate;
	
	/**
	 * 分配人ID
	 * */
	@Column(name = "f_assigner_id",length = 32, nullable = true)
	private String assignerId;
	
	/**
	 * 分配人帐号
	 * */
	@Column(name = "f_assigner_name",length = 50, nullable = true)
	private String assignerName;
	
	/**
	 * 分配人姓名
	 * */
	@Column(name = "f_assigner_alias",length = 50, nullable = true)
	private String assignerAlias;
	
	/**
	 *	分配时间
	 * */
	@Column(name = "f_allocation_date", nullable = true)
	private Date allocationDate;
	
	/**
	 *	预计开始时间
	 * */
	@Column(name = "f_planed_start_date", nullable = true)
	private Date planedStartDate;
	
	/**
	 *	预计结束时间
	 * */
	@Column(name = "f_planed_end_date", nullable = true)
	private Date planedEndDate;
	
	/**
	 *	鉴定专业（0：数据恢复、1：数据分析；2：系统分析；3：数据提取固定）
	 * */
	@Column(name = "f_major", length = 10, nullable = true)
	private String major;
	
	/**
	 *	鉴定人Id
	 * */
	@Column(name = "f_appraiser_id", length = 32, nullable = true)
	private String appraiserId;
	
	/**
	 *	鉴定人帐号
	 * */
	@Column(name = "f_appraiser_name", length = 50, nullable = true)
	private String appraiserName;
	
	/**
	 *	鉴定人姓名
	 * */
	@Column(name = "f_appraiser_alias", length = 50, nullable = true)
	private String appraiserAlias;
	
	/**
	 *	鉴定人移动电话（设计预留）
	 * */
	@Column(name = "f_appraiser_mp", length = 20, nullable = true)
	private String appraiserMp;
	
	/**
	 *	检材领用人（鉴定人）ID
	 * */
	@Column(name = "f_collector_id", length = 40, nullable = true)
	private String collectorId;
	
	/**
	 *	检材领用人（鉴定人）帐号
	 * */
	@Column(name = "f_collector_name", length = 50, nullable = true)
	private String collectorName;
	
	/**
	 *	检材领用人（鉴定人）姓名
	 * */
	@Column(name = "f_collector_alias", length = 50, nullable = true)
	private String collectorAlias;
	
	/**
	 *	检材领用时间
	 * */
	@Column(name = "f_collected_date", nullable = true)
	private Date collectedDate;
	
	/**
	 *	监控视频物理路径
	 * */
	@Column(name = "f_video_path", nullable = true)
	@Type(type="text")
	private String videoPath;
	
	/**
	 *	检验地点
	 * */
	@Column(name = "f_location", length = 200, nullable = true)
	private String location;
	
	/**
	 *	检验过程
	 * */
	@Column(name = "f_process", nullable = true)
	@Type(type="text")
	private String process;
	
	/**
	 *	杀毒结果
	 * */
	@Column(name = "f_antivirus_result", nullable = true)
	@Type(type="text")
	private String antivirusResult;
	
	/**
	 *	检验结果
	 * */
	@Column(name = "f_appraisal_result", nullable = true)
	@Type(type="text")
	private String appraisalResult;
	
	/**
	 *	备注
	 * */
	@Column(name = "f_remarks", nullable = true)
	@Type(type="text")
	private String remarks;
	
	/**
	 *	鉴定开始时间
	 * */
	@Column(name = "f_appraised_start_date", nullable = true)
	private Date appraisedStartDate;
	
	/**
	 *	鉴定结束时间
	 * */
	@Column(name = "f_appraised_end_date", nullable = true)
	private Date appraisedEndDate;
	
	/**
	 *	检材归还人（鉴定人）ID
	 * */
	@Column(name = "f_returner_id", length = 32 , nullable = true)
	private String returnerId;
	
	/**
	 *	检材归还人（鉴定人）帐号
	 * */
	@Column(name = "f_returner_name", length = 50 , nullable = true)
	private String returnerName;
	
	/**
	 *	检材归还人（鉴定人）姓名
	 * */
	@Column(name = "f_returner_alias", length = 50 , nullable = true)
	private String returnerAlias;
	
	/**
	 *	检材归还时间
	 * */
	@Column(name = "f_returned_date", nullable = true)
	private Date returnedDate;

	/**
	 * 复核人		
	 * */
	@Column(name = "f_reviewer",length = 50, nullable = true)
	private String reviewer;
	
	/**
	 * 复核时间
	 * */
	@Column(name = "f_reviewed_date", nullable = true)
	private Date reviewerdDate;
	
	/**
	 * "发文形式及数量，JSON格式：[{ ""name"" : ""鉴定书"", ""qty"" : 1 },{ ""name"" : ""检验报告"", ""qty"" : 1 }]"
	 * */
	@Column(name = "f_issued_form",length = 50, nullable = true)	
	private String issuedForm;

	/**
	 * 附件（0：鉴定委托书；1：鉴定事项确认书；2：检验记录；3：检验照片；4：提取数据），附件可多个，多个选择的情况以逗号分隔，如：0,1,2
	 * */
	@Column(name = "f_att",length = 100, nullable = true)
	private String att;

	/**
	 * 附件 - 其他
	 * */
	@Column(name = "f_att_other",length = 100, nullable = true)
	private String attOther;
	
	/**
	 *	文书审核者（文书审核人 - 授权签字人）ID
	 * */
	@Column(name = "f_verifier_id", length = 32 , nullable = true)
	private String verifierId;
	
	/**
	 * 文书审核者（文书审核人 - 授权签字人）账号		
	 * */
	@Column(name = "f_verifier_name", length = 50, nullable = true)
	private String verifierName;
	
	/**
	 * 文书审核者（文书审核人 - 授权签字人） 名称	
	 * */
	@Column(name = "f_verifier_alias", length = 50, nullable = true)
	private String verifierAlias;
	
	/**
	 * （文书审核人 - 授权签字人）鉴定情况判定（0：认可项目；1：非认可项目；2：符合委托方要求），选项可多个，如：0,1,2	
	 * */
	@Column(name = "f_sitn_judgement", length = 50, nullable = true)
	private String sitnJudgement;
	
	/**
	 * （文书审核人 - 授权签字人）文书审核意见
	 * */
	@Column(name = "f_verifier_opinion", nullable = true)
	@Type(type="text")
	private String verifierOpinion;
	
	/**
	 * （文书审核人 - 授权签字人）文书审核时间
	 * */
	@Column(name = "f_verified_date", nullable = true)
	private Date verifiedDate;
	 
	
	/**
	 *	文书审批者（文书审批人 - 实验室负责人）ID
	 * */
	@Column(name = "f_approver_id", length = 32 , nullable = true)
	private String approverId;
	
	/**
	 * 文书审批者（文书审批人 - 实验室负责人）帐号		
	 * */
	@Column(name = "f_approver_name",length = 50,nullable = true)
	private String approverName;
	
	/**
	 * 文书审批者（文书审批人 - 实验室负责人）姓名	
	 * */
	@Column(name = "f_approver_alias",length = 50,nullable = true)
	private String approverAlias;
	
	/**
	 * （文书审批人）审批意见	
	 * */
	@Column(name = "f_approver_opinion",nullable = true)
	@Type(type="text")
	private String approverOpinion;

	/**
	 * （文书审批人）审批时间
	 * */
	@Column(name = "f_approved_date",nullable = true)
	private Date approvedDate;
	
	/**
	 * 文书审批 - 备注
	 * */
	@Column(name = "f_comments",nullable = true)
	@Type(type="text")
	private String comments;

	/**
	 * 电子物证交接ID（检材领用时自动关联）
	 * */
	@Column(name = "fk_coll_transition_id",length = 32 ,nullable = true)
	private String collTransitionId;
	
	/**
	 * 电子物证交接ID（检材归还时自动关联）
	 * */
	@Column(name = "fk_return_transition_id",length = 32 ,nullable = true)
	private String returnTransitionId;
	
	/**
	 * 电子物证ID（入库后自动关联）
	 * */
	@Column(name = "fk_evid_id",length = 32 ,nullable = true)
	private String evidId;
	
	/**
	 * 电子物证预检信息ID）
	 * */
	@Column(name = "fk_preappraisal_id",length = 32 ,nullable = true)
	private String preappraisalId;
	
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAssignerId() {
		return assignerId;
	}

	public void setAssignerId(String assignerId) {
		this.assignerId = assignerId;
	}

	public String getAssignerName() {
		return assignerName;
	}

	public void setAssignerName(String assignerName) {
		this.assignerName = assignerName;
	}

	public String getAssignerAlias() {
		return assignerAlias;
	}

	public void setAssignerAlias(String assignerAlias) {
		this.assignerAlias = assignerAlias;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

	public Date getPlanedStartDate() {
		return planedStartDate;
	}

	public void setPlanedStartDate(Date planedStartDate) {
		this.planedStartDate = planedStartDate;
	}

	public Date getPlanedEndDate() {
		return planedEndDate;
	}

	public void setPlanedEndDate(Date planedEndDate) {
		this.planedEndDate = planedEndDate;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAppraiserId() {
		return appraiserId;
	}

	public void setAppraiserId(String appraiserId) {
		this.appraiserId = appraiserId;
	}

	public String getAppraiserName() {
		return appraiserName;
	}

	public void setAppraiserName(String appraiserName) {
		this.appraiserName = appraiserName;
	}

	public String getAppraiserAlias() {
		return appraiserAlias;
	}

	public void setAppraiserAlias(String appraiserAlias) {
		this.appraiserAlias = appraiserAlias;
	}

	public String getAppraiserMp() {
		return appraiserMp;
	}

	public void setAppraiserMp(String appraiserMp) {
		this.appraiserMp = appraiserMp;
	}

	public String getCollectorId() {
		return collectorId;
	}

	public void setCollectorId(String collectorId) {
		this.collectorId = collectorId;
	}

	public String getCollectorName() {
		return collectorName;
	}

	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}

	public String getCollectorAlias() {
		return collectorAlias;
	}

	public void setCollectorAlias(String collectorAlias) {
		this.collectorAlias = collectorAlias;
	}

	public Date getCollectedDate() {
		return collectedDate;
	}

	public void setCollectedDate(Date collectedDate) {
		this.collectedDate = collectedDate;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getAntivirusResult() {
		return antivirusResult;
	}

	public void setAntivirusResult(String antivirusResult) {
		this.antivirusResult = antivirusResult;
	}

	public String getAppraisalResult() {
		return appraisalResult;
	}

	public void setAppraisalResult(String appraisalResult) {
		this.appraisalResult = appraisalResult;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getAppraisedStartDate() {
		return appraisedStartDate;
	}

	public void setAppraisedStartDate(Date appraisedStartDate) {
		this.appraisedStartDate = appraisedStartDate;
	}

	public Date getAppraisedEndDate() {
		return appraisedEndDate;
	}

	public void setAppraisedEndDate(Date appraisedEndDate) {
		this.appraisedEndDate = appraisedEndDate;
	}

	public String getReturnerId() {
		return returnerId;
	}

	public void setReturnerId(String returnerId) {
		this.returnerId = returnerId;
	}

	public String getReturnerName() {
		return returnerName;
	}

	public void setReturnerName(String returnerName) {
		this.returnerName = returnerName;
	}

	public String getReturnerAlias() {
		return returnerAlias;
	}

	public void setReturnerAlias(String returnerAlias) {
		this.returnerAlias = returnerAlias;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
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

	public String getCollTransitionId() {
		return collTransitionId;
	}

	public void setCollTransitionId(String collTransitionId) {
		this.collTransitionId = collTransitionId;
	}

	public String getReturnTransitionId() {
		return returnTransitionId;
	}

	public void setReturnTransitionId(String returnTransitionId) {
		this.returnTransitionId = returnTransitionId;
	}

	public String getEvidId() {
		return evidId;
	}

	public void setEvidId(String evidId) {
		this.evidId = evidId;
	}

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public Date getReviewerdDate() {
		return reviewerdDate;
	}

	public void setReviewerdDate(Date reviewerdDate) {
		this.reviewerdDate = reviewerdDate;
	}

	public String getIssuedForm() {
		return issuedForm;
	}

	public void setIssuedForm(String issuedForm) {
		this.issuedForm = issuedForm;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getAttOther() {
		return attOther;
	}

	public void setAttOther(String attOther) {
		this.attOther = attOther;
	}

	public String getVerifierId() {
		return verifierId;
	}

	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}

	public String getVerifierName() {
		return verifierName;
	}

	public void setVerifierName(String verifierName) {
		this.verifierName = verifierName;
	}

	public String getVerifierAlias() {
		return verifierAlias;
	}

	public void setVerifierAlias(String verifierAlias) {
		this.verifierAlias = verifierAlias;
	}

	public String getSitnJudgement() {
		return sitnJudgement;
	}

	public void setSitnJudgement(String sitnJudgement) {
		this.sitnJudgement = sitnJudgement;
	}

	public String getVerifierOpinion() {
		return verifierOpinion;
	}

	public void setVerifierOpinion(String verifierOpinion) {
		this.verifierOpinion = verifierOpinion;
	}

	public Date getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
