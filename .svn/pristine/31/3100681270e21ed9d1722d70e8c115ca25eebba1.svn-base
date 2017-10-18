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
 * 现场勘验审批表
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_inquest")
public class Inquest extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 4033146733352417561L;

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
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/***
	 * 现场勘验号
	 */
	@Column(name = "f_sn", length = 50, nullable = false)
	private String sn;
	
	/***
	 * 案件名称
	 */
	@Column(name = "f_case_name", length = 50, nullable = false)
	private String caseName;
	
	/***
	 * 案件所属区域 - 省行政区划代码（默认：广东省）
	 */
	@Column(name = "f_province", length = 20, nullable = false)
	private String province;
	
	/***
	 * 案件所属区域 - 市行政区划代码（默认：广州市）
	 */
	@Column(name = "f_city", length = 20, nullable = false)
	private String city;
	
	/***
	 * 案件所属区域 - 县区行政区划代码（默认：广州市内所有区）
	 */
	@Column(name = "f_county", length = 20, nullable =  true)
	private String county;
	
	/***
	 * 勘验时间
	 */
	@Column(name = "f_operated_date", nullable = false)
	private Date operatedDate;
	
	/***
	 * 勘验人ID
	 */
	@Column(name = "f_operator_id", length = 32, nullable = false)
	private String operatorId;
	
	/***
	 * 勘验人账号
	 */
	@Column(name = "f_operator_name", length = 50, nullable = false)
	private String operatorName;
	
	/***
	 * 勘验人姓名
	 */
	@Column(name = "f_operator_alias", length = 50, nullable = false)
	private String operatorAlias;

	/***
	 * 审批人ID
	 */
	@Column(name = "f_approver_id", length = 32, nullable = true)
	private String approverId;
	
	/***
	 * 审批人账号
	 */
	@Column(name = "f_approverName", length = 50, nullable = true)
	private String approverName;
	
	/***
	 * 审批人姓名
	 */
	@Column(name = "f_approverAlias", length = 50, nullable = true)
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
	@Column(name = "f_approver_date", nullable = true)
	private Date approverDate;
	
	/***
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/***
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
	
	/***
	 * 创建者ID
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
	 * 状态（0：草稿；1：待审批；2：通过；3：拒绝）
	 */
	@Column(name = "f_status", nullable = false)
	private Integer status;
	
	/***
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = Inquest.NORMAL;

	// getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public Date getApproverDate() {
		return approverDate;
	}

	public void setApproverDate(Date approverDate) {
		this.approverDate = approverDate;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Date getOperatedDate() {
		return operatedDate;
	}

	public void setOperatedDate(Date operatedDate) {
		this.operatedDate = operatedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
