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
import org.pangolin.util.UUIDHexGenerator;

/**
 * 临时文档操作日志
 * @author Tinggui Zhu
 */
@Entity
@Table(name = "t_tmp_doc_op_log")
public class TmpDocOpLog extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2361707822538274746L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 文件类型- 新增
	 * */
	public static final Integer TYPE_ADD = new Integer(0);
	
	/**
	 * 文件类型 - 修改
	 * */
	public static final Integer TYPE_MODIFY = new Integer(1);
	
	/**
	 * 文件类型 - 删除
	 * */
	public static final Integer TYPE_REMOVE = new Integer(2);
	
	/**
	 * 文件状态 - 草稿
	 * */
	public static final Integer STATUS_DRAFT = new Integer(0);
	
	/**
	 * 文件状态 - 待审核
	 * */
	public static final Integer STATUS_TO_AUDIT = new Integer(1);
	
	/**
	 * 文件状态  - 通过
	 * */
	public static final Integer STATUS_AGREE = new Integer(2);
	
	/**
	 * 文件状态  - 拒绝
	 * */
	public static final Integer STATUS_REJECT = new Integer(3);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
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
	 * 临时文件原文件编号
	 */
	@Column(name = "f_original_sn", length = 50, nullable = true)
	private String originalSn;
	
	/***
	 * 临时文件文件编号
	 */
	@Column(name = "f_sn", length = 50, nullable = false)
	private String sn;
	
	/**
	 * 临时文件后缀名
	 * */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String extensions;
	
	/**
	 * 临时文件物理路径
	 * */
	@Type(type="text")
	@Column(name = "f_path", nullable = false)
	private String path;
	
	/***
	 * 临时文件类型（0：新增；1：变更；2：删除）
	 */
	@Column(name = "f_type", nullable = true)
	private Integer type;
	
	/***
	 * 修改内容
	 */
	@Type(type = "text")
	@Column(name = "f_content", nullable = true)
	private String content;
	
	/***
	 * 修改原因
	 */
	@Type(type = "text")
	@Column(name = "f_reason", nullable = true)
	private String reason;
	
	/***
	 * 审批意见
	 */
	@Type(type = "text")
	@Column(name = "f_opinion", nullable = true)
	private String opinion;
	
	/***
	 * 审批时间
	 */
	@Column(name = "f_approved_date", nullable = true)
	private Date approvedDate;
	
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
	 * 审批状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = TmpDocOpLog.STATUS_DRAFT;
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = TmpDocOpLog.NORMAL;
	
	/***
	 * 文件夹ID
	 */
	@Column(name = "fk_dir_id", length = 32, nullable = false)
	private String dirId;
	
	/***
	 * 正式文件ID
	 */
	@Column(name = "fk_doc_id", length = 32, nullable = true)
	private String docId;
	
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}