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
 * 角色实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_role")
public class Role extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7205512196198334196L;

	/**
	 * 角色状态 - 禁用
	 * */
	public static final Integer DISABLE = new Integer(0);
	
	/**
	 * 角色状态 - 启用
	 * */
	public static final Integer ENABLE = new Integer(1);
	
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
	@Column(name = "pk_role_id", length = 40, nullable = false)
	private String roleId;
	
	/**
	 * 角色名称
	 * */
	@Column(name = "f_role_name", length = 50, nullable = false)
	private String roleName;
	
	/**
	 * 角色标识
	 * */
	@Column(name = "f_role_label", length = 50, nullable = false)
	private String roleLabel;
	
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
	 * 角色描述
	 * */
	@Column(name = "f_desc", length = 100, nullable = true)
	private String roleDesc;
	
	/**
	 * 角色所属组织名称（用于冗余）
	 * */
	@Column(name = "f_org_name", length = 50, nullable = true)
	private String orgName;
	
	/**
	 * 角色状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer roleStatus = Role.ENABLE;
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer deleteFlag = Role.NORMAL;
	
	/**
	 * 角色所属组织ID（用户分类）
	 * */
	@Column(name = "fk_org_id", length = 40, nullable = true)
	private String orgId;
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleLabel() {
		return roleLabel;
	}

	public void setRoleLabel(String roleLabel) {
		this.roleLabel = roleLabel;
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

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}
}