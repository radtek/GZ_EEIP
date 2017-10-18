package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *广告信息实体类
 *可用于广告轮播
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_advertisement")
public class Advertisement extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -3278888912179009071L;

	/**
	 * 广告状态 - 禁用
	 * */
	public static final Integer DISABLE = new Integer(0);
	
	/**
	 * 广告状态 - 启用
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
	 * 广告标题
	 * */
	@Column(name = "f_title", length = 100, nullable = false)
	private String title;
	
	/**
	 * 广告URL
	 * */
	@Type(type="text")
	@Column(name = "f_url", nullable = true)
	private String url;
	
	/**
	 * 广告图片磁盘位置
	 * */
	@Type(type="text")
	@Column(name = "f_path", nullable = true)
	private String path;
	
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
	 * 广告描述
	 * */
	@Column(name = "f_desc", length = 200, nullable = true)
	private String description;
	
	/**
	 * 广告状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = Advertisement.ENABLE;
	
	/**
	 * 正式上载文件
	 * */
	@Transient
	private String uploadFileName;
	
	/**
	 * 临时上载文件
	 * */
	@Transient
	private String tempUploadFileName;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getTempUploadFileName() {
		return tempUploadFileName;
	}

	public void setTempUploadFileName(String tempUploadFileName) {
		this.tempUploadFileName = tempUploadFileName;
	}
}