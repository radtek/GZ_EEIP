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
@Table(name = "t_resource")
public class Resource extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7393916708825740627L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_resource_id", length = 40, nullable = false)
	private String resourceId;
	
	@Column(name = "f_resource_name", length = 50, nullable = false)
	private String resourceName;
	
	@Column(name = "f_resource_label", length = 50, nullable = false)
	private String resourceLabel;
	
	@Column(name = "f_resource_location", length = 200, nullable = false)
	private String resourceLocation;
	
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
	
	@Column(name = "f_desc", length = 100, nullable = true)
	private String resourceDesc;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceLabel() {
		return resourceLabel;
	}

	public void setResourceLabel(String resourceLabel) {
		this.resourceLabel = resourceLabel;
	}

	public String getResourceLocation() {
		return resourceLocation;
	}

	public void setResourceLocation(String resourceLocation) {
		this.resourceLocation = resourceLocation;
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

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}
}