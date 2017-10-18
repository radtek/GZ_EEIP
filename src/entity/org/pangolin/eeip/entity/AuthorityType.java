package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_authority_type")
public class AuthorityType extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -4179991517242862661L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_auth_type_id", length = 40, nullable = false)
	private String authorityTypeId;
	
	/**
	 * 权限类型名称
	 * */
	@Column(name = "f_auth_type_name", length = 50, nullable = false)
	private String authorityTypeName;
	
	/**
	 * 权限类型标识
	 * */
	@Column(name = "f_auth_type_label", length = 50, nullable = false)
	private String authorityTypeLabel;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 上级权限类型ID
	 * */
	@Column(name = "fk_parent_auth_type_id", length = 40, nullable = true)
	private String parentAuthorityTypeId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getAuthorityTypeId() {
		return authorityTypeId;
	}

	public void setAuthorityTypeId(String authorityTypeId) {
		this.authorityTypeId = authorityTypeId;
	}

	public String getAuthorityTypeName() {
		return authorityTypeName;
	}

	public void setAuthorityTypeName(String authorityTypeName) {
		this.authorityTypeName = authorityTypeName;
	}

	public String getAuthorityTypeLabel() {
		return authorityTypeLabel;
	}

	public void setAuthorityTypeLabel(String authorityTypeLabel) {
		this.authorityTypeLabel = authorityTypeLabel;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getParentAuthorityTypeId() {
		return parentAuthorityTypeId;
	}

	public void setParentAuthorityTypeId(String parentAuthorityTypeId) {
		this.parentAuthorityTypeId = parentAuthorityTypeId;
	}
}