package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.pangolin.util.UUIDHexGenerator;

/**
 * 专家著作信息
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_user_works")
public class UserWorks extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6781129405918653339L;

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
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/**
	 * 发表或出版时间
	 */
	@Column(name = "f_published_date", nullable = false)
	private Date publishedDate;
	
	/**
	 * 论文著作或专题技术分析报告标题
	 */
	@Column(name = "f_title", length = 100, nullable = false)
	private String title;

	/**
	 * 作者及名次
	 */
	@Column(name = "f_author_rank", length = 50, nullable = false)
	private String authorRank;
	
	/**
	 * 刊物名称及刊号
	 */
	@Column(name = "f_sn", length = 100, nullable = false)
	private String sn;
	
	/**
	 * 刊物（论文交流）主办单位
	 */
	@Column(name = "f_sponsor", length = 50, nullable = false)
	private String sponsor;
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 创建者ID
	 */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId; 
	

	/**
	 * 创建者账号
	 */ 
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者姓名
	 */ 
	@Column(name = "f_creator_alias",length = 50, nullable = false)
	private String creatorAlias; 
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserWorks.NORMAL;
	
	/**
	 * 人员基本信息ID
	 */
	@Column(name = "fk_user_basic_info_id", length = 32 ,nullable = false)
	private String userBasicInfoId;

	public UserWorks(){}

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

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorRank() {
		return authorRank;
	}

	public void setAuthorRank(String authorRank) {
		this.authorRank = authorRank;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getUserBasicInfoId() {
		return userBasicInfoId;
	}

	public void setUserBasicInfoId(String userBasicInfoId) {
		this.userBasicInfoId = userBasicInfoId;
	} 
}
