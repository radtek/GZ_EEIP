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
 * 业务能力确认及授权
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_user_authorization")
public class UserAuthorization extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8427649009090467345L;

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
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id; 
	
	/**
	 * 部门
	 */
	@Column(name = "f_dept", length = 20, nullable = false)
	private String dept;
	
	/**
	 * 人员姓名
	 */
	@Column(name = "f_name", length = 20 ,nullable = true)
	private String name;
	
	/**
	 * 确认时间
	 */
	@Column(name = "f_confirmed_date", nullable = true)
	private Date confirmedDate;
	
	/**
	 * 确认内容（长字段）
	 */
	@Type(type="text")
	@Column(name = "f_content", length = 20, nullable = true)
	private String content;
	
	/**
	 * 授权意见（长字段）
	 */
	@Type(type="text")
	@Column(name = "f_opinion", length = 20, nullable = true)
	private String opinion;
	
	/**
	 * 确认人
	 */
	@Column(name = "f_confirm_person", length = 20, nullable = true)
	private String confirmPerson;
	
	/**
	 * 确认结果（长字段）
	 */
	@Type(type="text")
	@Column(name = "f_result", length = 20, nullable = true)
	private String result;
	
	/**
	 * 实验室主任
	 */
	@Column(name = "f_lab_director", length = 20,nullable = true)
	private String labDirector;
	
	/**
	 * 授权时间
	 */
	@Column(name = "f_authorization_date", nullable = true)
	private Date authorizationDate;
	
	/**
	 * 备注
	 */ 
	@Column(name = "f_remarks", length = 20, nullable = true)
	private String remarks; 
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserAuthorization.NORMAL;
	

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
	@Column(name = "f_creator_alias", length = 50,nullable = false)
	private String creatorAlias;
	
	/**
	 * 人员基本信息ID
	 */
	@Column(name = "fk_user_basic_info_id", length = 32, nullable = false)
	private String userBasicInfoId; 
	
	public UserAuthorization(){}

	public String toString() {
		return outputObjPropertyString(this);
	}
	
	//getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
 

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

 
	public String getConfirmPerson() {
		return confirmPerson;
	}

	public void setConfirmPerson(String confirmPerson) {
		this.confirmPerson = confirmPerson;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLabDirector() {
		return labDirector;
	}

	public void setLabDirector(String labDirector) {
		this.labDirector = labDirector;
	}

	public Date getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	
	public String getUserBasicInfoId() {
		return userBasicInfoId;
	}

	public void setUserBasicInfoId(String userBasicInfoId) {
		this.userBasicInfoId = userBasicInfoId;
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
}