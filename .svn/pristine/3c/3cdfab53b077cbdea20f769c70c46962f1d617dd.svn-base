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
@Table(name = "t_notification_type")
public class NotificationType extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2280929158184759993L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 消息类型名称
	 * */
	@Column(name = "f_name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 消息类型标记
	 * */
	@Column(name = "f_label", length = 100, nullable = false)
	private String label;
	
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
	 * 备注
	 * */
	@Column(name = "f_desc", length = 100, nullable = true)
	private String description;
	
	/**
	 * 上级消息类型ID
	 * */
	@Column(name = "fk_parent_id", length = 40, nullable = true)
	private String parentNoteTypeId;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentNoteTypeId() {
		return parentNoteTypeId;
	}

	public void setParentNoteTypeId(String parentNoteTypeId) {
		this.parentNoteTypeId = parentNoteTypeId;
	}
}