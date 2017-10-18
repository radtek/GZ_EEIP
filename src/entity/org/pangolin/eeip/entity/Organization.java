package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 机构实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_organization")
public class Organization extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7330450128670261486L;

	/**
	 * 机构状态 - 禁用
	 * */
	public static final Integer DISABLE = new Integer(0);
	
	/**
	 * 机构状态 - 启用
	 * */
	public static final Integer ENABLE = new Integer(1);
	
	//----------------------------------------------------
	
	/**
	 * 机构类型 - 机构
	 * */
	public static final Integer ORGANIZATION = new Integer(0);
	
	/**
	 * 机构类型 - 部门
	 * */
	public static final Integer DEPARTMENT = new Integer(1);
	
	//----------------------------------------------------
	
	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_org_id", length = 40, nullable = false)
	private String orgId;
	
	/**
	 * 机构名称
	 * */
	@Column(name = "f_org_name", length = 50, nullable = false)
	private String orgName;
	
	/**
	 * 机构简称
	 * */
	@Column(name = "f_org_short_name", length = 50, nullable = true)
	private String orgShortName;
	
	/**
	 * 机构编号
	 * */
	@Column(name = "f_org_sn", length = 30, nullable = false)
	private String orgSN = generateOrgSN();
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 修改时间
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
	
	/**
	 * 机构排序
	 * */
	@Column(name = "f_sort", length = 1, nullable = false)
	private Integer orgSort;
	
	/**
	 * 机构描述
	 * */
	@Column(name = "f_desc", length = 100, nullable = true)
	private String orgDesc;
	
	/**
	 * 机构状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer orgStatus = Organization.ENABLE;
	
	/**
	 * 机构类型
	 * */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer orgType = Organization.ORGANIZATION;
	
	/**
	 * 机构层级（层级从0开始累加）
	 * */
	@Column(name = "f_level", length = 1, nullable = false)
	private Integer orgLevel = new Integer(0);
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer deleteFlag = Organization.NORMAL;
	
	/**
	 * 父级机构ID
	 * */
	@Column(name = "fk_parent_id", length = 40, nullable = true)
	private String parentOrgId;
	
	/**
	 * 版本ID
	 * */
	@Column(name = "fk_version_id", length = 40, nullable = true)
	private String versionId;
	
	/**
	 * 父级机构名称
	 * */
	@Transient
	private String parentOrgName;
	
	/**
	 * 机构管理员状态
	 * */
	@Transient
	private Boolean orgAdminStatus = new Boolean(false);
	
	/**
	 * 版本使用开始时间
	 * */
	@Transient
	private Date activatedDate;
	
	/**
	 * 版本使用结束时间
	 * */
	@Transient
	private Date expiredDate;

	/**
	 * Generate serial number of organization
	 * @return Serial number of organization
	 * @author Oscar Mok
	 * */
	private String generateOrgSN() {
		String orgSN = "";
		Date currentDate = new Date();
		if ( currentDate != null ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			orgSN = "ORG_" + sdf.format(currentDate);
		}
		return orgSN;
	}
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
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

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public String getOrgSN() {
		return orgSN;
	}

	public void setOrgSN(String orgSN) {
		this.orgSN = orgSN;
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

	public Integer getOrgSort() {
		return orgSort;
	}

	public void setOrgSort(Integer orgSort) {
		this.orgSort = orgSort;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public Integer getOrgStatus() {
		return orgStatus;
	}

	public void setOrgStatus(Integer orgStatus) {
		this.orgStatus = orgStatus;
	}

	public Integer getOrgType() {
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}

	public Boolean getOrgAdminStatus() {
		return orgAdminStatus;
	}

	public void setOrgAdminStatus(Boolean orgAdminStatus) {
		this.orgAdminStatus = orgAdminStatus;
	}

	public Date getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
}