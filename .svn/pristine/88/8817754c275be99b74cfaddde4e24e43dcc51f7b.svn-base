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
 * 系统权限实体类
 * */
@Entity
@Table(name = "t_authority")
public class Authority extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 6644898365891419551L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_auth_id", length = 40, nullable = false)
	private String authorityId;
	
	/**
	 * 权限名称
	 * */
	@Column(name = "f_auth_name", length = 50, nullable = false)
	private String authorityName;
	
	/**
	 * 权限标识
	 * */
	@Column(name = "f_auth_label", length = 50, nullable = false)
	private String authorityLabel;
	
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
	 * 权限描述
	 * */
	@Column(name = "f_desc", length = 100, nullable = true)
	private String authorityDesc;

	/**
	 * 父级权限标识
	 * */
	@Column(name = "f_parent_auth_label", length = 50, nullable = true)
	private String parentAuthorityLabel;
	
	/**
	 * 所属权限类型
	 * */
	@Column(name = "fk_auth_type_id", length = 40, nullable = false)
	private String authorityTypeId;
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityLabel() {
		return authorityLabel;
	}

	public void setAuthorityLabel(String authorityLabel) {
		this.authorityLabel = authorityLabel;
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

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	public String getParentAuthorityLabel() {
		return parentAuthorityLabel;
	}

	public void setParentAuthorityLabel(String parentAuthorityLabel) {
		this.parentAuthorityLabel = parentAuthorityLabel;
	}

	public String getAuthorityTypeId() {
		return authorityTypeId;
	}

	public void setAuthorityTypeId(String authorityTypeId) {
		this.authorityTypeId = authorityTypeId;
	}
}