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
 * 专家培训经历
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_user_training_exp")	
public class UserTrainingExp extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -4015467572079655331L;

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
	 * 培训开始日期
	 */
	@Column(name = "f_start_date", nullable = true)
	private Date startDate;
	
	/**
	 * 培训结束日期
	 */
	@Column(name = "f_end_date", nullable = true)
	private Date endDate;
	
	
	/**
	 * 培训内容
	 */
	@Type(type="text")
	@Column(name = "f_content", nullable = true)
	private String content;
	
	/**
	 * 培训单位
	 */
	@Column(name = "f_training_agency", length = 40, nullable = true)
	private String trainingAgency;
	
	/**
	 * 考核情况
	 */
	@Column(name = "f_result", length = 255, nullable = true)
	private String result; 
	
	/**
	 * 登记人
	 */
	@Column(name = "f_registrant", length = 40, nullable = true)
	private String registrant;
	
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
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserTrainingExp.NORMAL;
	
	/**
     * 人员基本信息ID
     */
	@Column(name = "fk_user_basic_info_id", length = 32, nullable = false)
	private String userBasicInfoId;
	
	/**
     * 培训履历ID
     */
	@Column(name = "fk_user_training_id", length = 32, nullable = false)
	private String userTrainingId; 
	
	public UserTrainingExp() {}
	
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
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTrainingAgency() {
		return trainingAgency;
	}

	public void setTrainingAgency(String trainingAgency) {
		this.trainingAgency = trainingAgency;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public String getUserBasicInfoId() {
		return userBasicInfoId;
	}

	public void setUserBasicInfoId(String userBasicInfoId) {
		this.userBasicInfoId = userBasicInfoId;
	}

	public String getUserTrainingId() {
		return userTrainingId;
	}

	public void setUserTrainingId(String userTrainingId) {
		this.userTrainingId = userTrainingId;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getRegistrant() {
		return registrant;
	}

	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}
}