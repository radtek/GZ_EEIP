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
 * 电子物证（检材）鉴定
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_appraisal")
public class Appraisal extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2139630114525166456L;

	public Appraisal() {}; 

	/**
	 * 鉴定状态（待受理）
	 * */
	public static final Integer WILL_ACCEPT = new Integer(0);
	
	/**
	 * 鉴定状态（不受理[可选]）
	 * */
	public static final Integer NO_ACCEPT = new Integer(1);
	
	/**
	 * 鉴定状态（待审核）
	 * */
	public static final Integer WILL_AUDIT = new Integer(2);
	
	/**
	 * 鉴定状态（审核失败[可选]）
	 * */
	public static final Integer AUDIT_FAILE = new Integer(3);
	
	/**
	 * 鉴定状态（待入库）
	 * */
	public static final Integer WILL_STORAGE = new Integer(4);
	
	/**
	 * 鉴定状态（待分配）
	 * */
	public static final Integer WAIT_FOR_DISTRIBUTION = new Integer(5);
	
	/**
	 * 鉴定状态（待领用）
	 * */
	public static final Integer LED_BY = new Integer(6);
	
	/**
	 * 鉴定状态（设备申领）
	 * */
	public static final Integer DEV_APPLY = new Integer(7);
	
	/**
	 * 鉴定状态（鉴定中）
	 * */
	public static final Integer AUTHENTICATE = new Integer(8);
	
	/**
	 * 鉴定状态（检材归还）
	 * */
	public static final Integer CHECK_MATERIAL_RETURNED = new Integer(9);
	
	/**
	 * 鉴定状态（文书整理、）
	 * */
	public static final Integer ARRANGEMENT_DOCUMENTS = new Integer(10);
	
	/**
	 * 鉴定状态（文书审核、）
	 * */
	public static final Integer ARRANGEMENT_REVIEW = new Integer(11);
	
	/**
	 * 鉴定状态（文书审批、）
	 * */
	public static final Integer ARRANGEMENT_AUDIT = new Integer(12);
	
	/**
	 * 鉴定状态（文书打印）
	 * */
	public static final Integer DOWN_DOC = new Integer(13);
	
	/**
	 * 鉴定状态（结果反馈、）
	 * */
	public static final Integer RESULT_FEEDBACK = new Integer(14);
	
	/**
	 * 鉴定状态（中止）
	 * */
	public static final Integer TERMINATION = new Integer(15);
	
	/**
	 * 鉴定状态（暂停）
	 * */
	public static final Integer PAUSE = new Integer(16);
	
	/**
	 * 鉴定状态（已完成）
	 * */
	public static final Integer FINISH = new Integer(17);
	
	/**
	 * （0：否；1：是）
	 * */
	public static final Integer NO = new Integer(0);
	
	/**
	 * （0：否；1：是）
	 * */
	public static final Integer YES = new Integer(1);
	
	/**
	 * 委托项目（0：提取固定电子数据；
	 * */
	public static final Integer EXTRACT_EVIDENCE = new Integer(0);
	
	/**
	 * 委托项目（1：恢复电子数据；
	 * */
	public static final Integer RECOVER_EVIDENCE = new Integer(1);
	
	/**
	 * 委托项目（2：检验程序功能；
	 * */
	public static final Integer AUTHENTICATE_FUNCTION = new Integer(2);
	
	/**
	 * 委托项目（3：破解电子数据密码；
	 * */
	public static final Integer CRACKING_PASSWORD = new Integer(3);
	
	/**
	 * 委托项目（4：分析电子数据；
	 * */
	public static final Integer ANALYZE_DATA = new Integer(4);
	
	/**
	 * 委托项目（5：销毁电子数据），实验室对电子物证鉴定的范围
	 * */
	public static final Integer DESTROY_EVIDENCE = new Integer(5);
	
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
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	public String id;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 伪删除状态 废弃时设置为伪删除
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = Appraisal.NORMAL;
	
	/**
	 * 鉴定状态（待受理、不受理[可选]、待审核、审核失败[可选]、待入库、待分配、待领用、设备申领、鉴定中、检材归还、文书整理、文书审批、已完成、中止、暂停、废弃）
	 * */
	@Column(name = "f_status", length = 2, nullable = false)
	private Integer status = 0;
	
	
	/**
	 * 机关代字
	 */
	@Column(name = "f_agency", length = 100, nullable = true)
	private String agency;
	
	/**
	 * 文件年份（格式：四位数字，如 2017）
	 */
	@Column(name = "f_year", length = 4, nullable = true)
	private String year;
	
	/**
	 * 文件号（最大四位数字，根据机关代字和年份自动累加）
	 */
	@Column(name = "f_sn", length = 4, nullable = true)
	private String sn;
	
	
	/**
	 * 案件名称
	 */
	@Column(name = "f_case_name", length = 100, nullable = false)
	private String caseName;
	
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
	 * 案件编号
	 */
	@Column(name = "f_case_sn", length = 100, nullable = false)
	private String caseSn;
	
	/**
	 *  联系电话
	 */
	@Column(name = "f_tel", length = 20, nullable = false)
	private String tel;
	
	/**
	 * 委托时间
	 */
	@Column(name = "f_entrusted_date", nullable = false )
	private Date entrustedDate;
	
	/**
	 * 委托鉴定单位ID（数据源自系统管理的组织架构）
	 */
	@Column(name = "f_org_id", length = 32, nullable = false)
	private String orgId;
	
	/**
	 * 委托鉴定单位名称（数据源自系统管理的组织架构）
	 */
	@Column(name = "f_org_name", length = 100, nullable = false)
	private String orgName;
	
	/**
	 * 受理人ID
	 * */
	@Column(name = "f_acceptor_id", length = 32, nullable = true)
	private String acceptorId;
	
	/**
	 * 受理人帐号
	 * */
	@Column(name = "f_acceptor_name", length = 50, nullable = true)
	private String acceptorName;
	
	/**
	 * 受理人姓名
	 * */
	@Column(name = "f_acceptor_alias", length = 50, nullable = true)
	private String acceptorAlias;
	
	/**
	 * 受理时间
	 * */
	@Column(name = "f_accepted_date", nullable = true)
	private Date acceptedDate;
	
	/**
	 * 受理意见 - 外观完整性（0：否；1：是）
	 * */
	@Column(name = "f_appearance_sitn",length = 1, nullable = true)
	private Integer appearanceSitn;
	
	/**
	 * 受理意见 - 拟同意接收（0：否；1：是）
	 * */
	@Column(name = "f_reception_sitn",length = 1, nullable = true)
	private Integer receptionSitn;
	
	/**
	 * 受理意见 - 其他
	 * */
	@Column(name = "f_other",length = 200, nullable = true)
	private String other;
	
	/**
	 * 委托项目（0：提取固定电子数据；1：恢复电子数据；2：检验程序功能；3：破解电子数据密码；4：分析电子数据；5：销毁电子数据），实验室对电子物证鉴定的范围"
	 * */
	@Column(name = "f_scope",length = 20, nullable = true)
	private String scope;

	/**
	 * 鉴定方法-其他（手工输入）
	 * */
	@Column(name = "f_method_other",length = 200, nullable = true)
	private String methodOther;
	
	/**
	 * 鉴定方法，可填写《数字化设备证据数据发现提取固定方法》GA/T756-2008、《电子物证搜索检验技术规范》GB/T29362-2012、《电子物证恢复检验技术规范》GB/T29360-2012，超出范围可根据实际填写
	 * */
	@Column(name = "f_method",length = 200, nullable = true)
	private String method;
	
	/**
	 * 结果要求，可填写出具检验报告、出具鉴定意见书、只提取电子数据，超出范围可根据实际填写
	 * */
	@Column(name = "f_rqmt",length = 200, nullable = true)
	private String rqmt;
	
	/**
	 * 结果要求-其他（手工输入）
	 * */
	@Column(name = "f_rqmt_other",length = 200, nullable = true)
	private String rqmtOther;
	
	/**
	 * 审核人ID
	 * */
	@Column(name = "f_auditor_id",length = 32, nullable = true)
	private String auditorId;
	
	/**
	 * 审核人帐号
	 * */
	@Column(name = "f_auditor_name",length = 50, nullable = true)
	private String auditorName;
	
	/**
	 * 审核人姓名
	 * */
	@Column(name = "f_auditor_alias",length = 50, nullable = true)
	private String auditorAlias;
	
	/**
	 * 审核意见
	 * */
	@Column(name = "f_audited_opinion", nullable = true)
	@Type(type="text")
	private String auditedOpinion;
	
	/**
	 * 审核时间
	 * */
	@Column(name = "f_audited_date", nullable = true)
	private Date auditedDate;
	
	/**
	 * 分配人ID
	 * */
	@Column(name = "f_assigner_id",length = 32, nullable = true)
	private String assignerId;
	
	/**
	 * 分配人帐号
	 **/
	@Column(name = "f_assigner_name",length = 50, nullable = true)
	private String assignerName;
	
	/**
	 * 分配人姓名
	 **/
	@Column(name = "f_assigner_alias",length = 50, nullable = true)
	private String assignerAlias;
	
	/**
	 *	分配时间
	 **/
	@Column(name = "f_allocation_date", nullable = true)
	private Date allocationDate;
	
	/**	
	 *	预计开始时间
	 **/
	@Column(name = "f_planed_start_date", nullable = true)
	private Date planedStartDate;
	
	/**
	 *	预计结束时间
	 * */
	@Column(name = "f_planed_end_date", nullable = true)
	private Date planedEndDate;
	
	/**
	 *	鉴定专业（0：数据恢复、1：数据分析；2：系统分析；3：数据提取固定）
	 **/
	@Column(name = "f_major", length = 10, nullable = true)
	private String major;
	
	/**
	 *	鉴定人Id
	 **/
	@Column(name = "f_appraiser_id", length = 32, nullable = true)
	private String appraiserId;
	
	/**
	 *	鉴定人帐号
	 * */
	@Column(name = "f_appraiser_name", length = 50, nullable = true)
	private String appraiserName;
	
	/**
	 *	鉴定人姓名
	 **/
	@Column(name = "f_appraiser_alias", length = 50, nullable = true)
	private String appraiserAlias;
	
	/**
	 *	鉴定人移动电话（设计预留）
	 **/
	@Column(name = "f_appraiser_mp", length = 20, nullable = true)
	private String appraiserMp;

	/**
	 *	检材领用人（鉴定人）ID
	 **/
	@Column(name = "f_collector_id", length = 40, nullable = true)
	private String collectorId;
	
	/**
	 *	检材领用人（鉴定人）帐号
	 **/
	@Column(name = "f_collector_name", length = 50, nullable = true)
	private String collectorName;
	
	/**
	 *	检材领用人（鉴定人）姓名
	 **/
	@Column(name = "f_collector_alias", length = 50, nullable = true)
	private String collectorAlias;
	
	/**
	 *	检材领用时间
	 **/
	@Column(name = "f_collected_date", nullable = true)
	private Date collectedDate;
	
	/**
	 *	监控视频物理路径
	 **/
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
	 * "发文形式及数量，JSON格式：[{ ""name"" : ""鉴定书"", ""qty"" : 0 },{ ""name"" : ""检验报告"", ""qty"" : 1 },{ ""name"" : ""检验意见书"", ""qty"" : 2 }]"
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
	 * 流程实例ID
	 * */
	@Column(name = "f_proc_inst_id",length = 32 ,nullable = true)
	private String procInstId;
	
	/**
	 * 当前流程步骤实例ID（流程运作的当前步骤），步骤发生变化须更新
	 * */
	@Column(name = "f_proc_act_inst_id",length = 32 ,nullable = true)
	private String procActInstId;
	
	/**
	 * 当前工作项ID（步骤发生变化须更新）
	 * */
	@Column(name = "f_workitem_id",length = 32 ,nullable = true)
	private String workItemId;
	
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
	 * 电子物证预检信息ID
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
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

	public String getCaseSn() {
		return caseSn;
	}

	public void setCaseSn(String caseSn) {
		this.caseSn = caseSn;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getEntrustedDate() {
		return entrustedDate;
	}

	public void setEntrustedDate(Date entrustedDate) {
		this.entrustedDate = entrustedDate;
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

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Integer getAppearanceSitn() {
		return appearanceSitn;
	}

	public void setAppearanceSitn(Integer appearanceSitn) {
		this.appearanceSitn = appearanceSitn;
	}

	public Integer getReceptionSitn() {
		return receptionSitn;
	}

	public void setReceptionSitn(Integer receptionSitn) {
		this.receptionSitn = receptionSitn;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getMethodOther() {
		return methodOther;
	}

	public void setMethodOther(String methodOther) {
		this.methodOther = methodOther;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRqmt() {
		return rqmt;
	}

	public void setRqmt(String rqmt) {
		this.rqmt = rqmt;
	}

	public String getRqmtOther() {
		return rqmtOther;
	}

	public void setRqmtOther(String rqmtOther) {
		this.rqmtOther = rqmtOther;
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

	public String getAuditedOpinion() {
		return auditedOpinion;
	}

	public void setAuditedOpinion(String auditedOpinion) {
		this.auditedOpinion = auditedOpinion;
	}

	public Date getAuditedDate() {
		return auditedDate;
	}

	public void setAuditedDate(Date auditedDate) {
		this.auditedDate = auditedDate;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProcInstId() {
		return procInstId;
	}

	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}

	public String getProcActInstId() {
		return procActInstId;
	}

	public void setProcActInstId(String procActInstId) {
		this.procActInstId = procActInstId;
	}

	public String getWorkItemId() {
		return workItemId;
	}

	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public static Appraisal cleanAppraisalParam(Appraisal appraisal){
		appraisal.setStatus(5);
		appraisal.setAssignerAlias(null);
		appraisal.setAssignerId(null);
		appraisal.setAssignerName(null);
		appraisal.setAllocationDate(null);
		appraisal.setPlanedStartDate(null);
		appraisal.setPlanedEndDate(null);
		appraisal.setMajor(null);
		appraisal.setAppraiserId(null);
		appraisal.setAppraiserAlias(null);
		appraisal.setAppraiserMp(null);
		appraisal.setAppraiserName(null);
		
		appraisal.setCollectorAlias(null);
		appraisal.setCollectorId(null);
		appraisal.setCollectorName(null);
		appraisal.setCollectedDate(null);
		
		appraisal.setVideoPath(null);
		appraisal.setLocation(null);
		appraisal.setProcess(null);
		appraisal.setAntivirusResult(null);
		appraisal.setAppraisalResult(null);
		appraisal.setRemarks(null);
		appraisal.setAppraisedStartDate(null);
		appraisal.setAppraisedEndDate(null);
		
		appraisal.setReturnerId(null);
		appraisal.setReturnerAlias(null);
		appraisal.setReturnerName(null);
		appraisal.setReturnedDate(null);
		
		appraisal.setReviewer(null);
		appraisal.setReviewerdDate(null);
		appraisal.setIssuedForm(null);
		appraisal.setAtt(null);
		appraisal.setAttOther(null);
		appraisal.setVerifierAlias(null);
		appraisal.setVerifierId(null);
		appraisal.setVerifierName(null);
		appraisal.setSitnJudgement(null);
		appraisal.setVerifierOpinion(null);
		appraisal.setVerifiedDate(null);
		appraisal.setApprovedDate(null);
		appraisal.setApproverAlias(null);
		appraisal.setApproverId(null);
		appraisal.setApproverName(null);
		appraisal.setApproverOpinion(null);
		appraisal.setComments(null);
		appraisal.setDelFlag(Appraisal.NORMAL);
		return appraisal;
	}	
}