package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_user_org")
public class UserOrganization extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7736941351309064592L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_uo_id", length = 40, nullable = false)
	private String userOrgId;
	
	@Column(name = "fk_user_id", length = 40, nullable = false)
	private String userId;
	
	@Column(name = "fk_org_id", length = 40, nullable = false)
	private String orgId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getUserOrgId() {
		return userOrgId;
	}

	public void setUserOrgId(String userOrgId) {
		this.userOrgId = userOrgId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}