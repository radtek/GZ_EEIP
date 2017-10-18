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
 *访问日志实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_access_log")
public class AccessLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2191281568749097513L;
	
	public static final Integer SYSTEM_LOGIN = new Integer(0);
	public static final Integer SYSTEM_LOGOUT = new Integer(1);
	
	public static final Integer FAILURE = new Integer(0);
	public static final Integer SUCCESS = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_log_id", length = 40, nullable = false)
	private String logId;
	
	/**
	 * 日志事件
	 * */
	@Column(name = "f_event", length = 200, nullable = false)
	private String logEvent;
	
	/**
	 * 事件发生时间
	 * */
	@Column(name = "f_event_date", nullable = false)
	private Date eventDate = new Date();
	
	/**
	 * 操作用户帐号
	 * */
	@Column(name = "f_user_name", length = 100, nullable = false)
	private String userName;
	
	/**
	 * 操作用户姓名
	 * */
	@Column(name = "f_user_alias", length = 50, nullable = false)
	private String userAlias;
	
	/**
	 * 操作用户IP地址
	 * */
	@Column(name = "f_user_ip_addr", length = 50, nullable = false)
	private String userIPAddress;
	
	/**
	 * 操作用户使用的浏览器版本
	 * */
	@Column(name = "f_user_nav_app_ver", length = 300, nullable = false)
	private String userNavAppVersion;
	
	/**
	 * 日志类型（登入、登出）
	 * */
	@Column(name = "f_log_type", length = 1, nullable = false)
	private Integer logType;
	
	/**
	 * 日志状态（成功、失败）
	 * */
	@Column(name = "f_log_status", length = 1, nullable = false)
	private Integer logStatus;
	
	/**
	 * 所属机构ID（用于分级权限过滤）
	 * */
	@Column(name = "fk_org_id", length = 40, nullable = true)
	private String orgId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogEvent() {
		return logEvent;
	}

	public void setLogEvent(String logEvent) {
		this.logEvent = logEvent;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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

	public String getUserIPAddress() {
		return userIPAddress;
	}

	public void setUserIPAddress(String userIPAddress) {
		this.userIPAddress = userIPAddress;
	}

	public String getUserNavAppVersion() {
		return userNavAppVersion;
	}

	public void setUserNavAppVersion(String userNavAppVersion) {
		this.userNavAppVersion = userNavAppVersion;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public Integer getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}