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
 * 版本副本实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_version_cp")
public class VersionCopy extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 3184289734661709432L;

	/**
	 * 使用状态 - 过期
	 * */
	public static final Integer EXPIRED = new Integer(0);
	
	/**
	 * 使用状态 - 正常
	 * */
	public static final Integer NORMAL = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 版本模块标识
	 * 保存权限标识，各标识间用逗号分隔，如：LABEL01,LABEL02
	 * */
	@Type(type="text")
	@Column(name = "f_module_labels", nullable = true)
	private String moduleLabels;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 开始使用时间
	 * */
	@Column(name = "f_activated_date", nullable = true)
	private Date activatedDate;
	
	/**
	 * 使用结束时间
	 * */
	@Column(name = "f_expired_date", nullable = true)
	private Date expiredDate;
	
	/**
	 * 使用状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = VersionCopy.NORMAL;
	
	/**
	 * 对应版本ID（正本）
	 * */
	@Column(name = "fk_version_id", length = 40, nullable = true)
	private String versionId;
	
	/**
	 * 机构ID
	 * */
	@Column(name = "fk_org_id", length = 40, nullable = true)
	private String orgId;
	
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

	public String getModuleLabels() {
		return moduleLabels;
	}

	public void setModuleLabels(String moduleLabels) {
		this.moduleLabels = moduleLabels;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}