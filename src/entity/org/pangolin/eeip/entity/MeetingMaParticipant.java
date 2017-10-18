package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 管理评审参与人清单
 * @author Tinggui Zhu
 *
 */
@Entity
@Table(name = "t_meeting_ma_participant")
public class MeetingMaParticipant extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -8332873370559831166L;

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
	 * 参会人账号
	 */
	@Column(name = "f_user_name", length = 50, nullable = false)
	private String userName;
	
	/***
	 * 参会人姓名
	 */
	@Column(name = "f_user_alias", length = 50, nullable = false)
	private String userAlias;
	
	/***
	 * 参会人移动电话
	 */
	@Column(name = "f_user_mp", length = 20, nullable = true)
	private String userMp;
	
	/***
	 * 会议申请ID
	 */
	@Column(name = "fk_meeting_app_id", length = 32, nullable = false)
	private String meetingAppId;
	
	/***
	 * 管理评审报告ID
	 */
	@Column(name = "fk_meeting_ma_report_id", length = 32, nullable = false)
	private String meetingMaReportId;
	
	public MeetingMaParticipant() {
		// TODO Auto-generated constructor stub
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

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}

	public String getMeetingMaReportId() {
		return meetingMaReportId;
	}

	public void setMeetingMaReportId(String meetingMaReportId) {
		this.meetingMaReportId = meetingMaReportId;
	}
	
	
}
