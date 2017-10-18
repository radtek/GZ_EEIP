package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色权限实体类（中间表）
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_role_authority")
public class RoleAuthority extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2683156914888148434L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_ra_id", length = 40, nullable = false)
	private String roleAuthId;
	
	/**
	 * 角色ID
	 * */
	@Column(name = "fk_role_id", length = 40, nullable = false)
	private String roleId;
	
	/**
	 * 权限ID
	 * */
	@Column(name = "fk_auth_id", length = 40, nullable = false)
	private String authorityId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getRoleAuthId() {
		return roleAuthId;
	}

	public void setRoleAuthId(String roleAuthId) {
		this.roleAuthId = roleAuthId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
}