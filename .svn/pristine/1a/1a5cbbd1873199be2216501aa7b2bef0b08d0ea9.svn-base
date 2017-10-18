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
 * 文档实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_document")
public class Document extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3391810223035898034L;

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
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 文件名称
	 * */
	@Column(name = "f_name", length = 200, nullable = false)
	private String name;
	
	/***
	 * 年份
	 */
	@Column(name = "f_year", length = 10, nullable = false)
	private String year;
	
	/***
	 * 原文件编号
	 */
	@Column(name = "f_original_sn", length = 50, nullable = true)
	private String originalSn;
	
	/***
	 * 文件编号
	 */
	@Column(name = "f_sn", length = 50, nullable = true)
	private String sn;
	
	/**
	 * 文档后缀名
	 * */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String extensions;
	
	/**
	 * 文档物理路径
	 * */
	@Type(type="text")
	@Column(name = "f_path", nullable = false)
	private String path;
	
	/***
	 * 是否含有历史版本
	 */
	@Column(name = "f_hist_doc", length = 1, nullable = false)
	private Boolean histDoc = new Boolean(false);
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/***
	 * 创建者ID
	 */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/***
	 * 创建者账号
	 */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/***
	 * 创建者姓名
	 */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 修改时间
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer deleteFlag = Document.NORMAL;
	
	/***
	 * 文件夹ID
	 */
	@Column(name = "fk_dir_id", length = 32, nullable = true)
	private String dirId;
	
	
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

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
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

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public String getDirId() {
		return dirId;
	}

	public void setDirId(String dirId) {
		this.dirId = dirId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOriginalSn() {
		return originalSn;
	}

	public void setOriginalSn(String originalSn) {
		this.originalSn = originalSn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorAlias() {
		return creatorAlias;
	}

	public void setCreatorAlias(String creatorAlias) {
		this.creatorAlias = creatorAlias;
	}

	public Boolean getHistDoc() {
		return histDoc;
	}

	public void setHistDoc(Boolean histDoc) {
		this.histDoc = histDoc;
	}
	
	
}