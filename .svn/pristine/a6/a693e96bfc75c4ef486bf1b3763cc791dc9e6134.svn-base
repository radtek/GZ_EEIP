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
 * 电子物证（检材）鉴定记录  
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_appraisal_revise_entruster")
public class AppraisalReviseEntruster extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5206485986744154460L;

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 委托人ID
	 */
	@Column(name = "f_user_id", length = 32, nullable = true)
	private String userId;
	
	/**
	 * 委托人帐号
	 */
	@Column(name = "f_user_name", length = 50, nullable = true)
	private String userName;
	
	/**
	 * 委托人姓名
	 */
	@Column(name = "f_user_alias", length = 50, nullable = false)
	private String userAlias;
	
	/**
	 * 送检人职务
	 */
	@Column(name = "f_user_post", length = 50, nullable = true)
	private String userPost;
	
	/**
	 * 委托人移动电话
	 */
	@Column(name = "f_user_mp", length = 20, nullable = true)
	private String userMp;
	
	/**
	 * 警员编号
	 */
	@Column(name = "f_police_id", length = 20, nullable = false)
	private String policeId;
	
	/**
	 * 电子物证文书修改申请ID
	 */
	@Column(name = "fk_appraisal_revise_app_id", length = 32, nullable = true)
	private String appraisalReviseAppId;
	
	/**
	 * 电子物证（检材）鉴定ID
	 */
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;

	public AppraisalReviseEntruster() {}
	
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

	public String getUserMp() {
		return userMp;
	}

	public void setUserMp(String userMp) {
		this.userMp = userMp;
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getAppraisalReviseAppId() {
		return appraisalReviseAppId;
	}

	public void setAppraisalReviseAppId(String appraisalReviseAppId) {
		this.appraisalReviseAppId = appraisalReviseAppId;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	
}