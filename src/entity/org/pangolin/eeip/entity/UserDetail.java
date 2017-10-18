package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "t_user_detail")
public class UserDetail extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 6742778606718130677L;

	/**
	 * 用户性别 - 男
	 * */
	public static final Integer MALE = new Integer(0);
	
	/**
	 * 用户性别 - 女
	 * */
	public static final Integer FEMALE = new Integer(1);
	
	/**
	 * 用户性别 - 保密
	 * */
	public static final Integer SECRET = new Integer(2);
	
	/**
	 * 用户详细信息ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_ud_id", length = 40, nullable = false)
	private String userDetailId;
	
	/**
	 * 用户头像（物理路径）
	 * */	
	@Type(type="text")
	@Column(name = "f_avatar_path", nullable = true)
	private String avatarPath;
	
	/**
	 * 用户性别
	 * */
	@Column(name = "f_sex", length = 1, nullable = false)
	private Integer userSex = UserDetail.MALE;
	
	/**
	 * 用户身份证号
	 * */
	@Column(name = "f_user_id_card", length = 100, nullable = true)
	private String userIdCard;
	
	/**
	 * 警员编号
	 * */
	@Column(name = "f_police_id", length = 50, nullable = true)
	private String policeId;
	
	/**
	 * 用户电子邮箱
	 * */
	@Column(name = "f_user_email", length = 100, nullable = true)
	private String userEmail;
	
	/**
	 * 用户办公电话
	 * */
	@Column(name = "f_user_tel", length = 100, nullable = true)
	private String userTelephone;
	
	/**
	 * 用户传真电话
	 * */
	@Column(name = "f_user_fax", length = 100, nullable = true)
	private String userFax;
	
	/**
	 * 用户移动电话
	 * */
	@Column(name = "f_user_mp", length = 100, nullable = true)
	private String userCellphone;
	
	/**
	 * 所属区域
	 * */
	@Column(name = "f_country", length = 100, nullable = true)
	private String country;
	
	/**
	 * 用户联系地址
	 * */
	@Column(name = "f_user_addr", length = 100, nullable = true)
	private String userAddress;
	
	/**
	 * 所属用户基本信息ID
	 * */
	@Column(name = "fk_user_id", length = 40, nullable = false)
	private String userId;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(String userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserFax() {
		return userFax;
	}

	public void setUserFax(String userFax) {
		this.userFax = userFax;
	}

	public String getUserCellphone() {
		return userCellphone;
	}

	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 
}