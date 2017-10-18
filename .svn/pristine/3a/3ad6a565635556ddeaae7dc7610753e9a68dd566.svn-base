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
 * 版本实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_version")
public class Version extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -825594707931233854L;

	/**
	 * 版本状态 - 禁用
	 * */
	public static final Integer DISABLE = new Integer(0);
	
	/**
	 * 版本状态 - 启用
	 * */
	public static final Integer ENABLE = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 版本名称
	 * */
	@Column(name = "f_name", length = 50, nullable = false)
	private String name;
	
	/**
	 * 版本模块标识
	 * 保存权限标识，各标识间用逗号分隔，如：LABEL01,LABEL02
	 * */
	@Type(type="text")
	@Column(name = "f_module_labels", nullable = true)
	private String moduleLabels;
	
	/**
	 * 版本模块名称（用于冗余）
	 * 保存权限名称，各标识间用逗号分隔，如：NAME01,NAME02
	 * */
	@Type(type="text")
	@Column(name = "f_module_names", nullable = true)
	private String moduleNames;
	
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
	 * 版本状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = Version.ENABLE;
	
	/**
	 * 版本描述
	 * */
	@Column(name = "f_desc", length = 100, nullable = true)
	private String description;
	
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

	public String getModuleLabels() {
		return moduleLabels;
	}

	public void setModuleLabels(String moduleLabels) {
		this.moduleLabels = moduleLabels;
	}

	public String getModuleNames() {
		return moduleNames;
	}

	public void setModuleNames(String moduleNames) {
		this.moduleNames = moduleNames;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}