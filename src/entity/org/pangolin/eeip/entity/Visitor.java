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
 * 来访人员信息
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_visitor")
public class Visitor extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -4729201530083861490L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 用户性别 - 男
	 * */
	public static final Integer MALE = new Integer(0);
	
	/**
	 * 用户性别 - 女
	 * */
	public static final Integer FEMALE = new Integer(1);
	
	/**
	 * 证件类别 - 警官证
	 * */
	public static final Integer POLICE_CARD = new Integer(0);
	
	/**
	 * 证件类别 - 身份证
	 * */
	public static final Integer ID_CARD = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id; 
	
	/**
	 * 姓名
	 */
	@Column(name = "f_name", length = 50, nullable = false)
	private String name; 

	/**
	 * 性别
	 */
	@Column(name = "f_sex", length = 1, nullable = false)
	private Integer sex;
	
	/**
	 * 单位
	 */
	@Column(name = "f_org", length = 50, nullable = false)
	private String org;
	
	/**
	 * 证件类型
	 */
	@Column(name = "f_cert_type", length = 1, nullable = false)
	private Integer certType; 
	
	/**
	 * 证号码
	 */
	@Column(name = "f_cert_no", length = 40, nullable = false)
	private String certNo;
	
	/**
	 * 来访时间
	 */
	@Column(name = "f_visit_date", nullable = true)
	private Date visitDate;

	/**
	 * 离开时间
	 */
	@Column(name = "f_leaving_date", nullable = true)
	private Date leavingDate;

	/**
	 * 来访事由
	 */
	@Column(name = "f_reason", length = 255, nullable = false)
	private String reason;
	
	/**
	 * 备注
	 */
	@Column(name = "f_remarks", length = 150, nullable = true)
	private String remarks; 
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();

	/**
	 * 创建者ID
	 */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 创建者账号
	 */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者姓名
	 */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserTraining.NORMAL;
	
	public Visitor(){};
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}