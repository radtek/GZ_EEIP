package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 专家学历信息
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_user_education")
public class UserEducation extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 9174615831573538288L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 *  是
	 * */
	public static final Integer YES = new Integer(0);
	
	/**
	 * 否
	 * */
	public static final Integer NO = new Integer(1);
	
	
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 学历
	 */
	@Column(name = "f_eduction", length = 40, nullable = true)
	private String eduction;
	
	/**
	 * 学位
	 */
	@Column(name = "f_degree", length = 40, nullable = true)
	private String degree;

	/**
	 * 毕业院校
	 */
	@Column(name = "f_school", length = 50, nullable = true)
	private String school;
	
	/**
	 * 毕业时间
	 */
	@Column(name = "f_date", nullable = true)
	private Date date;
	
	/**
	 * 专业
	 */
	@Column(name = "f_major", length = 20, nullable = true)
	private String major;

	/**
	 * 毕业证书
	 */
	@Column(name = "f_education_cert", length = 1, nullable = true)
	private Integer educationCert;

	/**
	 * 学位证书
	 */
	@Column(name = "f_degree_cert", length = 1, nullable = true)
	private Integer degreeCert;
	
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
	private Integer delFlag = UserEducation.NORMAL;
	
	/**
     * 人员基本信息ID
     */
	@Column(name = "fk_user_basic_info_id", length = 32, nullable = false)
	private String userBasicInfoId;

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

	public String getEduction() {
		return eduction;
	}

	public void setEduction(String eduction) {
		this.eduction = eduction;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getEducationCert() {
		return educationCert;
	}

	public void setEducationCert(Integer educationCert) {
		this.educationCert = educationCert;
	}

	public Integer getDegreeCert() {
		return degreeCert;
	}

	public void setDegreeCert(Integer degreeCert) {
		this.degreeCert = degreeCert;
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