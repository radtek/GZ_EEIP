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
 * 电子物证（检材）预检信息  
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_preappraisal")
public class Preappraisal extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 2823357417823165509L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 预检信息状态 - 草稿
	 * */
	public static final Integer DRAFTS = new Integer(0);
	
	/**
	 * 预检信息状态 - 已提交
	 * */
	public static final Integer OFFICIAL = new Integer(1);
	
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
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
	 * 委托时间
	 */
	@Column(name = "f_entrusted_date", nullable = false )
	private Date entrustedDate;

	/**
	 * 省份（默认：广东省），行政区划代码
	 */
	@Column(name = "f_province", length = 20, nullable = false)
	private String province;

	/**
	 * 地市（默认：广州市），行政区划代码
	 */
	@Column(name = "f_city", length = 20, nullable = false)
	private String city;

	/**
	 * 县区（默认：广州市各区），行政区划代码
	 */
	@Column(name = "f_country", length = 20, nullable = false)
	private String country;

	/**
	 * 详细地址
	 */
	@Column(name = "f_addr", length = 200, nullable = false)
	private String addr;

	/**
	 * 邮政编码
	 */
	@Column(name = "f_zip_code", length = 200, nullable = true)
	private String zipCode;
	
	/**
	 *  联系电话
	 */
	@Column(name = "f_tel", length = 20, nullable = false)
	private String tel;
	
	/**
	 * 传真
	 */
	@Column(name = "f_fax", length = 20, nullable = true)
	private String fax;
	
	/**
	 * 电子邮件
	 */
	@Column(name = "f_email", length = 100, nullable = true)
	private String email;
	
	/**
	 * 案件名称
	 */
	@Column(name = "f_case_name", length = 100, nullable = false)
	private String caseName;
	
	/**
	 * 案件编号
	 */
	@Column(name = "f_case_sn", length = 100, nullable = false)
	private String caseSn;

	/**
	 * 简要说明
	 */ 
	@Column(name = "f_explanation", nullable = false)
	@Type(type="text")
	private String explanation;

	/**
	 * 鉴定要求
	 */ 
	@Column(name = "f_rqmt", nullable = false)
	@Type(type="text")
	private String rqmt;
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();

	/**
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
 
	
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
	 * 状态
	 */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status;
	
	/**
	 * 备   注
	 */
	@Column(name = "f_remarks",  nullable = true)
	@Type(type = "text")
	private String remarks;
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = Preappraisal.NORMAL;

	public Preappraisal(){}
	
	public Preappraisal(String id){
		this.id=id;
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

	public Date getEntrustedDate() {
		return entrustedDate;
	}

	public void setEntrustedDate(Date entrustedDate) {
		this.entrustedDate = entrustedDate;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getRqmt() {
		return rqmt;
	}

	public void setRqmt(String rqmt) {
		this.rqmt = rqmt;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	
}
