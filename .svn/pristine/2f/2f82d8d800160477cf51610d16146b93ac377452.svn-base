package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_role_resource")
public class RoleResource extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -436887588165037147L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_rr_id", length = 40, nullable = false)
	private String roleResourceId;
	
	@Column(name = "fk_role_id", length = 40, nullable = false)
	private String roleId;
	
	@Column(name = "fk_resource_id", length = 40, nullable = false)
	private String resourceId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getRoleResourceId() {
		return roleResourceId;
	}

	public void setRoleResourceId(String roleResourceId) {
		this.roleResourceId = roleResourceId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
}