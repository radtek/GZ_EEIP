package org.pangolin.eeip.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 电子物证交接
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_evid_transition")
public class EvidTransition extends BaseEntity implements Serializable{
 
	private static final long serialVersionUID = 6582273807074268157L;
 
	/**
	 * 交接状态- 领取
	 * */
	public static final Integer RECEIVE = new Integer(0);
	
	/**
	 * 交接状态- 归还
	 * */
	public static final Integer GIVE_BACK = new Integer(1);
	
	/**
	 * 交接情况- 未确认
	 * */
	public static final Integer UNCONFIRMED = new Integer(0);
	
	/**
	 * 交接情况- 已确认
	 * */
	public static final Integer CONFIRMED = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 物证名称
	 */
	@Column(name = "f_evid_name", length = 100, nullable = false)
	private String evidName;
	
	/**
	 * 物证编号
	 */
	@Column(name = "f_evid_sn", length = 100, nullable = false)
	private String evidSn;
	
	/**
	 * 案件名称
	 */
	@Column(name = "f_cese_name", length = 100, nullable = false)
	private String caseName;
	
	/**
	 * 案件编号
	 */
	@Column(name = "f_case_sn", length = 100, nullable = false)
	private String caseSn;
	
	/**
	 * 交接类型
	 */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer type;
	
	/**
	 * 交接状态
	 */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status;
	
	/**
	 * 申请者ID
	 */
	@Column(name = "f_applicant_id", length = 32, nullable = false)
	private String applicantId;
	 
	/**
	 * 申请者账号
	 */
	@Column(name = "f_applicant_name", length = 50, nullable = false)
	private String applicantName;
	
	/**
	 * 申请者姓名
	 */
	@Column(name = "f_applicant_alias", length = 50, nullable = false)
	private String applicantAlias;
	
	/**
	 * 申请时间
	 */
	@Column(name = "f_applicant_date", nullable = false)
	private Date applicantDate = new Date();

	/**
	 * 确认人ID
	 */
	@Column(name = "f_operator_id", length = 32, nullable = true)
	private String operatorId;
	
	/**
	 * 确认人账号
	 */
	@Column(name = "f_operator_name", length = 50, nullable = true)
	private String operatorName;
	
	/**
	 * 确认人姓名
	 */
	@Column(name = "f_operator_alias",length = 50, nullable = true)
	private String operatorAlias;
	
	/**
	 * 创建时间（申请时间）
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 确认时间（形成闭环的时间）
	 */
	@Column(name = "f_confirmed_date", nullable = true)
	private Date confirmedDate;

	/**
	 * 电子物证ID
	 */
	@Column(name = "fk_evid_id", length = 32,  nullable = false)
	private String evidId;
	
	/**
	 * 电子物证预检信息ID
	 */
	@Column(name = "fk_preappraisal_id", length = 32,  nullable = false)
	private String preappraisalId;
	
	/**
	 * 电子物证（检材）鉴定ID
	 */
	@Column(name = "fk_appraisal_id", length = 32,  nullable = false)
	private String appraisalId;
	
	
	
	public EvidTransition(){}
	
	//getters and setters
	public String toString(){
		return outputObjPropertyString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvidName() {
		return evidName;
	}

	public void setEvidName(String evidName) {
		this.evidName = evidName;
	}

	public String getEvidSn() {
		return evidSn;
	}

	public void setEvidSn(String evidSn) {
		this.evidSn = evidSn;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseSn() {
		return caseSn;
	}

	public void setCaseSn(String caseSn) {
		this.caseSn = caseSn;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantAlias() {
		return applicantAlias;
	}

	public void setApplicantAlias(String applicantAlias) {
		this.applicantAlias = applicantAlias;
	} 
	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorAlias() {
		return operatorAlias;
	}

	public void setOperatorAlias(String operatorAlias) {
		this.operatorAlias = operatorAlias;
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

	public Date getApplicantDate() {
		return applicantDate;
	}

	public void setApplicantDate(Date applicantDate) {
		this.applicantDate = applicantDate;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}  
}
