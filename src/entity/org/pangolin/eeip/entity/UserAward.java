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
 * 获奖信息
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_user_award")
public class UserAward extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -5936608359591421063L;

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
     * 获奖时间（格式：yyyy-MM）
     */
	@Column(name = "f_awarding_date", nullable = false)
	private Date awardingDate;
	
    /**
     * 奖励名称及等级
     */
	@Column(name = "f_awarding_detail", length = 150, nullable = false)
	private String awardingDetail;

    /**
     * 颁奖单位
     */
	@Column(name = "f_awarder", length = 100, nullable = false)
	private String awarder;

    /**
     * 个人奖或集体获奖本人排名.所起作用
     */
	@Column(name = "f_effect", length = 100, nullable = false)
	private String effect; 
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate=new Date();

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
	@Column(name = "f_del_flag" , nullable = false)
	private Integer delFlag = UserAward.NORMAL;
	
    /**
     * 人员基本信息ID
     */
	@Column(name = "fk_user_basic_info_id", length = 32, nullable = false)
	private String userBasicInfoId;

	public UserAward(){}
	
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

	public Date getAwardingDate() {
		return awardingDate;
	}

	public void setAwardingDate(Date awardingDate) {
		this.awardingDate = awardingDate;
	}

	public String getAwardingDetail() {
		return awardingDetail;
	}

	public void setAwardingDetail(String awardingDetail) {
		this.awardingDetail = awardingDetail;
	}

	public String getAwarder() {
		return awarder;
	}

	public void setAwarder(String awarder) {
		this.awarder = awarder;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

	public String getUserBasicInfoId() {
		return userBasicInfoId;
	}

	public void setUserBasicInfoId(String userBasicInfoId) {
		this.userBasicInfoId = userBasicInfoId;
	}
}