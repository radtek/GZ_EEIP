package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色用户实体类（中间表）
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_role_user")
public class RoleUser extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1614975361098761352L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_ru_id", length = 40, nullable = false)
	private String roleUserId;
	
	/**
	 * 角色ID
	 * */
	@Column(name = "fk_role_id", length = 40, nullable = false)
	private String roleId;
	
	/**
	 * 用户ID
	 * */
	@Column(name = "fk_user_id", length = 40, nullable = false)
	private String userId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getRoleUserId() {
		return roleUserId;
	}

	public void setRoleUserId(String roleUserId) {
		this.roleUserId = roleUserId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}