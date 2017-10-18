package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 电子物证（检材）预检委托人（送检人）
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_preappraisal_entruster")
public class PreappraisalEntruster  extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6896370717680143555L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 送检人ID
	 */
	@Column(name = "f_user_id", length = 32, nullable = true)
	private String userId;

	/**
	 * 送检人账号
	 */
	@Column(name = "f_user_name", length = 50, nullable = true)
	private String userName;


	/**
	 * 送检人职务
	 */
	@Column(name = "f_user_post", length = 50, nullable = true)
	private String userPost;
	
	/**
	 * 送检人姓名
	 */
	@Column(name = "f_user_alias", length = 50, nullable = false)
	private String userAlias;
	
	/**
	 * 送检人移动电话（预留）
	 */
	@Column(name = "f_user_mp", length = 20, nullable = true)
	private String userMp;
	
	/**
	 * 警员编号
	 */
	@Column(name = "f_police_id", length = 40, nullable = false)
	private String policeId;

	/**
	 * 电子物证预检信息ID
	 */
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;

	public PreappraisalEntruster(){}
	
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

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	} 
	
}
