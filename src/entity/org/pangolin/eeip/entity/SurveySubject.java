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
 * 问卷调查主题
 * @author Oscar Mok
 * */
@Entity
@Table(name = "t_survey_subject")
public class SurveySubject extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2243695432288721109L;

	/**
	 * 未发布
	 * */
	public static final Integer UNPUBLISHED = new Integer(0);
	
	/**
	 * 已发布
	 * */
	public static final Integer PUBLISHED = new Integer(1);
	
	/**
	 * 已过期
	 * */
	public static final Integer EXPIRED = new Integer(2);
	
	/**
	 * 已撤回
	 * */
	public static final Integer REVOKED = new Integer(3);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 调查问卷主题名称
	 * */
	@Column(name = "f_name", length = 200, nullable = false)
	private String name;
	
	/**
	 * 问卷调查开始时间
	 * */
	@Column(name = "f_avl_start_date", nullable = false)
	private String avlStartDate;
	
	/**
	 * 问卷调查结束时间
	 * */
	@Column(name = "f_avl_end_date", nullable = false)
	private String avlEndDate;
	
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
	 * 发布者ID
	 * */
	@Column(name = "f_publisher_id", length = 40, nullable = false)
	private String publisherId;
	
	/**
	 * 发布者帐户
	 * */
	@Column(name = "f_publisher_name", length = 100, nullable = false)
	private String publisherName;
	
	/**
	 * 发布者姓名
	 * */
	@Column(name = "f_publisher_alias", length = 100, nullable = false)
	private String publisherAlias;
	
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
	 * 发布时间
	 * */
	@Column(name = "f_published_date", nullable = true)
	private Date publishedDate;
	
	/**
	 * 备注
	 * */
	@Column(name = "f_desc", length = 200, nullable = true)
	private String description;
	
	/**
	 * 发布范围（组织范围、角色范围）
	 * 利用组织标记、角色标记进行存储，如：{ "orgRange" : "orgLabel1,orgLabel2,orgLabel3", "roleRange" : "roleLabel1,roleLabel2,roleLabel3" }
	 * */
	@Type(type="text")
	@Column(name = "f_issue_range", nullable = true)
	private String  issueRange;
	
	/**
	 * 调查问卷状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = SurveySubject.UNPUBLISHED;
	
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

	public String getAvlStartDate() {
		return avlStartDate;
	}

	public void setAvlStartDate(String avlStartDate) {
		this.avlStartDate = avlStartDate;
	}

	public String getAvlEndDate() {
		return avlEndDate;
	}

	public void setAvlEndDate(String avlEndDate) {
		this.avlEndDate = avlEndDate;
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

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAlias() {
		return publisherAlias;
	}

	public void setPublisherAlias(String publisherAlias) {
		this.publisherAlias = publisherAlias;
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

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssueRange() {
		return issueRange;
	}

	public void setIssueRange(String issueRange) {
		this.issueRange = issueRange;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}