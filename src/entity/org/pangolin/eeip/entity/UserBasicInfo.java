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
 * 专家人员基本情况
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_user_basic_info")
public class UserBasicInfo extends BaseEntity implements Serializable {
 
	private static final long serialVersionUID = 8685972091616955520L;

	/**
	 * 用户性别 - 男
	 * */
	public static final Integer MALE = new Integer(0);
	
	/**
	 * 用户性别 - 女
	 * */
	public static final Integer FEMALE = new Integer(1);
	
	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 政治面貌- 中共党员
	 * */
	public static final Integer MEMBER_OF_COMMUNIST_PARTY_OF_CHINA = new Integer(0);
	
	/**
	 * 政治面貌- 中共预备党员
	 * */
	public static final Integer PROBATIONARY_PARTY_MEMBER = new Integer(1);
	
	/**
	 * 政治面貌- 共青团员
	 * */
	public static final Integer LEAGUE_MEMBER  = new Integer(2);
	
	/**
	 * 政治面貌- 民革党员
	 * */
	public static final Integer MDC_PARTY = new Integer(3);
	
	/**
	 * 政治面貌- 民盟盟员
	 * */
	public static final Integer PAD_LEAGUER = new Integer(4);
	
	/**
	 * 政治面貌- 民建会员
	 * */
	public static final Integer COMMITTEE_MEMBER = new Integer(5);
	
	/**
	 * 政治面貌- 农工党党员
	 * */
	public static final Integer FARMER_LABOR_PARTY_MEMBER = new Integer(6);
	
	/**
	 * 政治面貌- 致公党党员
	 * */
	public static final Integer ZHIGONG_PARTY_MEMBER = new Integer(7);
	
	/**
	 * 政治面貌- 九三学社社员
	 * */
	public static final Integer JIUSAN_SOCIETY_MEMBER = new Integer(8);
	
	/**
	 * 政治面貌- 台盟盟员
	 * */
	public static final Integer TAI_LEAGUE_MEMBER = new Integer(9);
	
	/**
	 * 政治面貌- 无党派人士
	 * */
	public static final Integer NON_PARTY_PERSONAGE = new Integer(10);
	
	/**
	 * 政治面貌- 群众
	 * */
	public static final Integer MASSES  = new Integer(11);
	
	/**
	 * 鉴定分配状态 - 未分配
	 */
	public static final Integer NOT_ASSIGNED  = new Integer(0);
	
	/**
	 * 鉴定分配状态 - 已分配
	 */
	public static final Integer ASSIGNED  = new Integer(1);
	
	
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 姓名
	 */
	@Column(name = "f_name", length = 50, nullable = false)
	private String name;

	/**
	 * 性别
	 */
	@Column(name = "f_sex", length = 1, nullable = false)
	private Integer sex = UserBasicInfo.MALE;
	
	/**
	 * 出生日期
	 */
	@Column(name = "f_birthday",  nullable = false)
	private Date birthday;
	
	/**
	 * 身份证号
	 */
	@Column(name = "f_id_card", length = 20, nullable = false)
	private String idCard;

	/**
	 * 家庭住址
	 */
	@Column(name = "f_addr", length = 150, nullable = true)
	private String addr;
	
	/**
	 * 邮编
	 */
	@Column(name = "f_zip_code", length = 10, nullable = true) 
	private String zipCode;
	
	/**
	 * 籍贯
	 */
	@Column(name = "f_native_place", length = 10, nullable = true)
	private String nativePlace;
	
	/**
	 * 民族
	 */
	@Column(name = "f_nation", length = 10, nullable = true)
	private String nation;

	/**
	 * 部门
	 */
	@Column(name = "f_dept", length = 20, nullable = true)
	private String dept;
	
	/**
	 * 参加工作日期
	 */
	@Column(name = "f_working_date", nullable = true)
    private Date workingDate;
	
	/**
	 * 参加公安工作日期
	 */
	@Column(name = "f_police_date", nullable = true)
	private Date policeDate;

	/**
	 * 现从事职业
	 */
	@Column(name = "f_major", length = 20, nullable = true)
	private String major;

	/**
	 * 政治面貌
	 */
	@Column(name = "f_political_status", length = 1, nullable = true)
	private Integer politicalStatus;
	
	/**
	 * 入党团时间
	 */
	@Column(name = "f_join_date", nullable = true)
	private Date joinDate;

	/**
	 * 行政职务
	 */
	@Column(name = "f_position", length = 20, nullable = true)
	private String position;
	
	/**
	 * 任职时间
	 */
	@Column(name = "f_office_date", nullable = true)
	private Date officeDate; 
	
	/**
	 * 本专业工作年限
	 */
	@Column(name = "f_working_seniority", length = 20, nullable = true)
    private String workingSeniority;

	/**
	 * 现任专业技术职务
	 */
	@Column(name = "f_tech_post", length = 40, nullable = true)
	private String techPost;

	/**
	 * 取得资格时间
	 */
	@Column(name = "f_qualifying_date", nullable = true)
	private Date qualifyingDate;
	 
	/**
	 * 警衔
	 */
	@Column(name = "f_police_rank", length = 40, nullable = false)
	private String policeRank;
	
	/**
	 * 警号
	 */
	@Column(name = "f_police_id", length = 40, nullable = false)
	private String policeId;
	
	/**
	 * 掌握何种外语，程度如何
	 */
	@Column(name = "f_foreign_lang_lvl", length = 10, nullable = true)
	private String foreignLangLvl;

	/**
	 * 参加何种学术团体、任何职、有无社会其他兼职
	 */
	@Column(name = "f_social_post", length = 50, nullable = true)
	private String socialPost;
	
	/**
	 * 头像路径
	 */
	@Column(name = "f_avatar_path", length = 200, nullable = true)
	private String avatarPath;

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
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	
	/**
	 * 用户ID
	 */
	@Column(name = "f_user_id", length = 32, nullable = true)
	private String userId;
	
	/**
	 * 用户账号
	 */
	@Column(name = "f_user_name", length = 50, nullable = true)
	private String userName;
	
	/**
	 * 用户姓名
	 */
	@Column(name = "f_user_alias", length = 50, nullable = true)
	private String userAlias;
	
	/**
	 * 鉴定分配状态
	 */
	@Column(name = "f_appraisal_flag", nullable = false)
	private Integer appraisalFlag = UserBasicInfo.NOT_ASSIGNED;
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserBasicInfo.NORMAL;

	public UserBasicInfo(){}
	
	public UserBasicInfo(String id){
		this.id = id;
	}
	
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
  
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}

	public Date getPoliceDate() {
		return policeDate;
	}

	public void setPoliceDate(Date policeDate) {
		this.policeDate = policeDate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	} 

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getOfficeDate() {
		return officeDate;
	}

	public void setOfficeDate(Date officeDate) {
		this.officeDate = officeDate;
	}

	public String getWorkingSeniority() {
		return workingSeniority;
	}

	public void setWorkingSeniority(String workingSeniority) {
		this.workingSeniority = workingSeniority;
	}

	public String getTechPost() {
		return techPost;
	}

	public void setTechPost(String techPost) {
		this.techPost = techPost;
	} 

	public String getPoliceRank() {
		return policeRank;
	}

	public void setPoliceRank(String policeRank) {
		this.policeRank = policeRank;
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getForeignLangLvl() {
		return foreignLangLvl;
	}

	public void setForeignLangLvl(String foreignLangLvl) {
		this.foreignLangLvl = foreignLangLvl;
	}

	public String getSocialPost() {
		return socialPost;
	}

	public void setSocialPost(String socialPost) {
		this.socialPost = socialPost;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
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

	public Date getQualifyingDate() {
		return qualifyingDate;
	}

	public void setQualifyingDate(Date qualifyingDate) {
		this.qualifyingDate = qualifyingDate;
	}

	public Integer getAppraisalFlag() {
		return appraisalFlag;
	}

	public void setAppraisalFlag(Integer appraisalFlag) {
		this.appraisalFlag = appraisalFlag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
}