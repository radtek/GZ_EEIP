package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 内审成员信息
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_meeting_ia_participant")
public class MeetingIaParticipant extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -8295966052665343073L;

	/**
	 * 内审成员类型 - 内审组长
	 * */
	public static final Integer LEARDER = new Integer(0);
	
	/**
	 * 内审成员类型 - 内审成员
	 * */
	public static final Integer MEMBER = new Integer(1);

	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 参会人ID
	 */
	@Column(name = "f_user_id", length = 32, nullable = false)
	private String userId;
	
	/***
	 * 内审成员账号
	 */
	@Column(name = "f_user_name", length = 50, nullable = false)
	private String userName;
	
	/***
	 * 内审成员姓名
	 */
	@Column(name = "f_user_alias", length = 50, nullable = false)
	private String userAlias;
	
	/***
	 * 内审成员类型
	 */
	@Column(name = "f_user_type", nullable = false)
	private Integer userType;
	
	/***
	 * 会议申请ID
	 */
	@Column(name = "fk_meeting_app_id", length = 32, nullable = false)
	private String meetingAppId;
	
	public MeetingIaParticipant(){};
	
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

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}
	
	
}
