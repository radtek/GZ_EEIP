package org.pangolin.eeip.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;

public class UserDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 1179380680367566424L;
	
	/* 用户基本信息 */
	private String userId;
	private String userName;
	private String userAlias;
	private Integer userType = new Integer(0);
	private String userPwd;
	private String userConfirmPwd;
	private Integer userSort;
	private Date createdDate = new Date();
	private Date modifiedDate;
	private Integer userStatus = User.ENABLE;
	
	/* 用户详细信息 */
	private String userDetailId;
	private Integer userSex = UserDetail.MALE;
	private String userIdCard;
	private String policeId;
	private String userEmail;
	private String userTelephone;
	private String userFax;
	private String userCellphone;
	private String userAddress;
	private String country;
	
	/* 用户部门信息 */
	private String orgId;
	private String orgName;
	
	/* 用户角色信息 */
	private String roleId;
	private String roleName;
	private String roleLabel;
	
	private String roleIds;
	
	/**
	 * 用户传输对象转换至用户基本信息对象
	 * @author Oscar Mok
	 * @param userDto 用户传输对象
	 * @return 用户基本信息对象
	 * */
	public static User convertToUser(UserDto userDto) {		
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setUserAlias(userDto.getUserAlias());
		user.setUserType(userDto.getUserType());
		user.setUserPwd(userDto.getUserPwd());
		user.setUserSort(userDto.getUserSort());
		user.setCreatedDate(userDto.getCreatedDate());
		user.setModifiedDate(userDto.getModifiedDate());
		user.setUserStatus(userDto.getUserStatus());
		return user;
	}
	
	/**
	 * 用户传输对象转换至用户详细信息对象
	 * @author Oscar Mok
	 * @param userDto 用户传输对象
	 * @return 用户详细信息对象
	 * */
	public static UserDetail convertToUserDetail(UserDto userDto) {
		UserDetail userDetail = new UserDetail();
		userDetail.setUserDetailId(userDto.getUserDetailId());
		userDetail.setUserSex(userDto.getUserSex());
		userDetail.setUserIdCard(userDto.getUserIdCard());
		userDetail.setPoliceId(userDto.getPoliceId());
		userDetail.setUserEmail(userDto.getUserEmail());
		userDetail.setUserTelephone(userDto.getUserTelephone());
		userDetail.setUserFax(userDto.getUserFax());
		userDetail.setUserCellphone(userDto.getUserCellphone());
		userDetail.setUserAddress(userDto.getUserAddress());
		userDetail.setUserId(userDto.getUserId());
		userDetail.setCountry(userDto.getCountry());
		return userDetail;
	}
	
	/**
	 * 用户传输对象转换至用户详细信息对象
	 * @author Oscar Mok
	 * @param user 用户基础信息对象
	 * @param userDetail 用户详细信息对象
	 * @param org 所属部门
	 * @param role 所属角色
	 * @return 用户传输对象
	 * */
	public static UserDto convertToUserDto(User user, UserDetail userDetail, Organization org, List<Role> roles) {
		UserDto userDto = new UserDto();
		if ( user != null ) {
			userDto.setUserId(user.getUserId());
			userDto.setUserName(user.getUserName());
			userDto.setUserAlias(user.getUserAlias());
			userDto.setUserType(user.getUserType());
			userDto.setUserPwd(user.getUserPwd());
			userDto.setUserSort(user.getUserSort());
			userDto.setCreatedDate(user.getCreatedDate());
			userDto.setModifiedDate(user.getModifiedDate());
			userDto.setUserStatus(user.getUserStatus());
		}
		if ( userDetail != null ) {
			userDto.setUserDetailId(userDetail.getUserDetailId());
			userDto.setUserSex(userDetail.getUserSex());
			userDto.setUserIdCard(userDetail.getUserIdCard());
			userDto.setPoliceId(userDetail.getPoliceId());
			userDto.setUserEmail(userDetail.getUserEmail());
			userDto.setUserTelephone(userDetail.getUserTelephone());
			userDto.setUserFax(userDetail.getUserFax());
			userDto.setUserCellphone(userDetail.getUserCellphone());
			userDto.setUserAddress(userDetail.getUserAddress());
			userDto.setCountry(userDetail.getCountry());
		}
		if ( org != null ) {
			userDto.setOrgId(org.getOrgId());
			userDto.setOrgName(org.getOrgName());
		}
		if ( roles != null && roles.size() > 0 ) {
			userDto.setRoleId(roles.get(0).getRoleId());
			userDto.setRoleName(roles.get(0).getRoleName());
			userDto.setRoleLabel(roles.get(0).getRoleLabel());
			String roleIds = "";
			for ( int i = 0; i < roles.size(); i++ ) {
				Role role = roles.get(i);
				roleIds += role.getRoleId();
				if ( i < (roles.size() - 1) ) {
					roleIds += ",";
				}
			}
			if ( roleIds.trim().length() > 0 ) userDto.setRoleIds(roleIds);
		}
		return userDto;
	}
	
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

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserConfirmPwd() {
		return userConfirmPwd;
	}

	public void setUserConfirmPwd(String userConfirmPwd) {
		this.userConfirmPwd = userConfirmPwd;
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

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(String userDetailId) {
		this.userDetailId = userDetailId;
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleLabel() {
		return roleLabel;
	}

	public void setRoleLabel(String roleLabel) {
		this.roleLabel = roleLabel;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}