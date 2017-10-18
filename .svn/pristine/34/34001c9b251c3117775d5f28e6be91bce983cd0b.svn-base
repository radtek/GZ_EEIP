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
 * 用户实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_user")
public class User extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -3898674421781329409L;

	/**
	 * 用户状态 - 禁用
	 * */
	public static final Integer DISABLE = new Integer(0);
	
	/**
	 * 用户状态 - 启用
	 * */
	public static final Integer ENABLE = new Integer(1);
	
	//----------------------------------------------------
	
	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	//----------------------------------------------------
	
	/**
	 * 注册状态 - 新注册用户
	 * */
	public static final Integer NEW = new Integer(0);
	
	/**
	 * 注册状态 - 已存在用户
	 * */
	public static final Integer EXISTING = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_user_id", length = 40, nullable = false)
	private String userId;
	
	/**
	 * 用户帐号
	 * */
	@Column(name = "f_user_name", length = 50, nullable = false)
	private String userName;
	
	/**
	 * 用户别名（姓名）
	 * */
	@Column(name = "f_user_alias", length = 50, nullable = false)
	private String userAlias;
	
	/**
	 * 用户密码（以加密方式存储）
	 * */
	@Column(name = "f_user_pwd", length = 100, nullable = false)
	private String userPwd;
	
	/**
	 * 用户排序号
	 * */
	@Column(name = "f_sort", length = 1, nullable = false)
	private Integer userSort = new Integer(0);
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 修改时间
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
	
	/**
	 * 用户类型（预留字段）
	 * */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer userType = new Integer(0);
	
	/**
	 * 用户状态
	 * */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer userStatus = User.ENABLE;
	
	/**
	 * 注册状态
	 * */
	@Column(name = "f_reg_status", length = 1, nullable = false)
	private Integer userRegStatus = User.NEW;
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer deleteFlag = User.NORMAL;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserSort() {
		return userSort;
	}

	public void setUserSort(Integer userSort) {
		this.userSort = userSort;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	public Integer getUserRegStatus() {
		return userRegStatus;
	}

	public void setUserRegStatus(Integer userRegStatus) {
		this.userRegStatus = userRegStatus;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}