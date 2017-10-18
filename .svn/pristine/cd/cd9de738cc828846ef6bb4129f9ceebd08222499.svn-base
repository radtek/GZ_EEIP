package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "t_notification")
public class Notification extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7571176408607874902L;

	/**
	 * 消息状态 - 未发布
	 * */
	public static final Integer UNPUBLISHED = new Integer(0);
	
	/**
	 * 消息状态 - 已发布
	 * */
	public static final Integer PUBLISHED = new Integer(1);
	
	//------------------------------------------------------------------------------
	
	/**
	 * 发布方式 - 指定时间自动发布
	 * */
	public static final Integer AUTO = new Integer(0);
	
	/**
	 * 发布方式 - 手动发布
	 * */
	public static final Integer MANUAL = new Integer(1);
	
	//------------------------------------------------------------------------------
	
	/**
	 * 消息时效性 - 时间限制
	 * */
	public static final Boolean TIME_LIMIT = new Boolean(true);
	
	/**
	 * 消息时效性 - 永不过期
	 * */
	public static final Boolean NEVER_EXPIRES = new Boolean(false);
	
	//------------------------------------------------------------------------------
	
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
	 * 消息标题
	 * */
	@Column(name = "f_title", length = 200, nullable = false)
	private String title;
	
	/**
	 * 消息内容
	 * */
	//@Lob //Java data type 'String' map to oracle data type 'CLOB'
	@Type(type="text")
	@Column(name = "f_content" , nullable = true)
	private String content;
	
	/**
	 * 创建者ID
	 * */
	@Column(name = "f_creator_id", length = 40, nullable = false)
	private String creatorId;
	
	/**
	 * 创建者帐户
	 * */
	@Column(name = "f_creator_name", length = 100, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者姓名
	 * */
	@Column(name = "f_creator_alias", length = 100, nullable = false)
	private String creatorAlias;
	
	/**
	 * 发布时间
	 * */
	@Column(name = "f_published_date", nullable = true)
	private Date publishedDate;
	
	/**
	 * 过期时间
	 * */
	@Column(name = "f_expired_date", nullable = true)
	private Date expiredDate;
	
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
	 * 发布方式
	 * */
	@Column(name = "f_p_method", length = 1, nullable = false)
	private Integer method = Notification.MANUAL;
	
	/**
	 * 时效性
	 * */
	@Column(name = "f_timeliness", nullable = false)
	//@Type(type="yes_no") //Oracle is unable to identify data type 'boolean'
	private Boolean timeliness = Notification.NEVER_EXPIRES;
	
	/**
	 * 消息状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = Notification.UNPUBLISHED;
	
	/**
	 * 发布范围（组织范围、角色范围）
	 * 利用组织标记、角色标记进行存储，如：[{"orgRange":"orgSN1,orgSN2,orgSN3","roleRange":"roleLabel1,roleLabel2,roleLabel3"}]
	 * */
	//@Lob //Java data type 'String' map to oracle data type 'CLOB'
	@Type(type="text")
	@Column(name = "f_issue_range", nullable = true)
	private String issueRange;
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer deleteFlag = Notification.NORMAL;
	
	/**
	 * 消息类型ID
	 * */
	@Column(name = "fk_note_type_id", length = 40, nullable = true)
	private String notificationTypeId;
	
	/**
	 * 消息图片ID集合
	 * */
	@Transient
	private String notificationImages;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public Boolean getTimeliness() {
		return timeliness;
	}

	public void setTimeliness(Boolean timeliness) {
		this.timeliness = timeliness;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIssueRange() {
		return issueRange;
	}

	public void setIssueRange(String issueRange) {
		this.issueRange = issueRange;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getNotificationTypeId() {
		return notificationTypeId;
	}

	public void setNotificationTypeId(String notificationTypeId) {
		this.notificationTypeId = notificationTypeId;
	}

	public String getNotificationImages() {
		return notificationImages;
	}

	public void setNotificationImages(String notificationImages) {
		this.notificationImages = notificationImages;
	}
}