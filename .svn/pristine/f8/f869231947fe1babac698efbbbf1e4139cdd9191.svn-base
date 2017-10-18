package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.dao.UserDao;
import org.pangolin.eeip.dto.RoleUserDto;
import org.pangolin.eeip.dto.UserDto;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.RoleUser;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;
import org.pangolin.eeip.entity.UserOrganization;
import org.pangolin.eeip.entity.VersionCopy;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.OrganizationService;
import org.pangolin.eeip.service.ResourceService;
import org.pangolin.eeip.service.RoleService;
import org.pangolin.eeip.service.RoleUserService;
import org.pangolin.eeip.service.UserDetailService;
import org.pangolin.eeip.service.UserOrganizationService;
import org.pangolin.eeip.service.UserService;
import org.pangolin.eeip.service.VersionCopyService;
import org.pangolin.security.encryption.MD5Encryption;
import org.pangolin.util.StringUtil;
import org.pangolin.validator.StringValidator;
import org.springframework.stereotype.Service;

@Service("userService")
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private OrganizationService organizationService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private AuthorityService authorityService;
	
	@Resource
	private ResourceService resourceService;
	
	@Resource
	private UserOrganizationService userOrgService;
  
	@Resource
	private UserDetailService userDetailService;
	
	@Resource
	private RoleUserService roleUserService;
	
	@Resource
	private VersionCopyService versionCopyService;
	
	/**
	 * 加载角色、权限、资源数据时是否使用缓存
	 * */
	private static final boolean USING_CACHE = true;
	
	public User getUserById(String userId) {
		return userDao.get(User.class, userId);
	}
	
	public User getUserByName(String userName) {
		User user = null;
		List<User> userList = userDao.find("from User where userName = ?", new Object[] { userName });
		if ( userList != null && userList.size() > 0 ) user = userList.get(0);
		return user;
	}
	
	public String getUserOriginalPwdById(String userId) {
		List<String> list = userDao.compSearch("select userPwd from User where userId = ?", new Object[] { userId });
		if ( list != null && list.size() > 0 ) return list.get(0);
		return null;
	}
	
	public Long getUserQty() {
		return userDao.count("select count(userId) from User where deleteFlag = ?", new Object[] { User.NORMAL });
	}
	
	public Long getUserQty(String condition) {
		return userDao.count("select count(a.userId) from User a, UserDetail b "
				+ "where a.deleteFlag = ? and a.userId = b.userId and "
				+ "(a.userName like '%" + condition + "%' or a.userAlias like '%" + condition + "%' or b.userCellphone like '%" + condition + "%')", new Object[] { User.NORMAL });
	}
	
	public Long getUserQtyByOrg(String orgId) {
		return userDao.count("select count(a.userId) from User a, UserOrganization b where a.userId=b.userId and b.orgId = ? and a.deleteFlag = ?", new Object[] { orgId, User.NORMAL });
	}
	
	public Long getUserQtyByOrg(String orgId, String condition) {
		return userDao.count("select count(a.userId) from User a, UserOrganization b, UserDetail c "
				+ "where a.userId = b.userId and a.userId = c.userId and b.userId = c.userId and b.orgId = ? and a.deleteFlag = ? and "
				+ "(a.userName like '%" + condition + "%' or a.userAlias like '%" + condition + "%' or c.userCellphone like '%" + condition + "%')", new Object[] { orgId, User.NORMAL });
	}
	
	public List<User> getUsers() {
		return userDao.find("from User where deleteFlag = ? order by createdDate desc", new Object[] { User.NORMAL });
	}
	
	public List<User> getUsersByOrg(String orgId) {
		User user = null;
		String userId = null, userName = null, userAlias =null;
		Date createdDate = null, modifiedDate = null;
		Integer userStatus = null, userRegStatus = null;
		List<User> userList = new ArrayList<User>();
		List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
				+ "from User a, UserOrganization b where a.userId = b.userId and b.orgId = ? and a.deleteFlag = ? order by a.userSort", new Object[] { orgId, User.NORMAL });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) userId = (String)objArray[0];
				if (objArray[1] != null) userName = (String)objArray[1];
				if (objArray[2] != null) userAlias = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				if (objArray[5] != null) userStatus = (Integer)objArray[5];
				if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setUserAlias(userAlias);
				user.setCreatedDate(createdDate);
				user.setModifiedDate(modifiedDate);
				user.setUserStatus(userStatus);
				user.setUserRegStatus(userRegStatus);
				userList.add(user);
			}
		}
		return userList;
	}
	
	public List<User> getUsersByRole(String roleId) {
		User user = null;
		String userId = null, userName = null, userAlias =null;
		Date createdDate = null, modifiedDate = null;
		Integer userStatus = null, userRegStatus = null;
		List<User> userList = new ArrayList<User>();
		List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
				+ "from User a, RoleUser b where a.userId = b.userId and b.roleId = ? and a.deleteFlag = ? order by a.userSort", new Object[] { roleId, User.NORMAL });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) userId = (String)objArray[0];
				if (objArray[1] != null) userName = (String)objArray[1];
				if (objArray[2] != null) userAlias = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				if (objArray[5] != null) userStatus = (Integer)objArray[5];
				if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setUserAlias(userAlias);
				user.setCreatedDate(createdDate);
				user.setModifiedDate(modifiedDate);
				user.setUserStatus(userStatus);
				user.setUserRegStatus(userRegStatus);
				userList.add(user);
			}
		}
		return userList;
	}
	
	public List<User> getAllUsers() {
		return userDao.find("from User where deleteFlag = ? order by createdDate desc", new Object[] { User.NORMAL });
	}
	
	public List<User> getAllUsersByOrg(String orgId) {
		User user = null;
		String userId = null, userName = null, userAlias =null;
		Date createdDate = null, modifiedDate = null;
		Integer userStatus = null, userRegStatus = null;
		List<User> userList = new ArrayList<User>();
		List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
				+ "from User a, UserOrganization b where a.userId = b.userId and b.orgId = ? order by a.userSort", new Object[] { orgId });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) userId = (String)objArray[0];
				if (objArray[1] != null) userName = (String)objArray[1];
				if (objArray[2] != null) userAlias = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				if (objArray[5] != null) userStatus = (Integer)objArray[5];
				if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setUserAlias(userAlias);
				user.setCreatedDate(createdDate);
				user.setModifiedDate(modifiedDate);
				user.setUserStatus(userStatus);
				user.setUserRegStatus(userRegStatus);
				userList.add(user);
			}
		}
		return userList;
	}
	
	public List<User> getAllUsersByRole(String roleId) {
		User user = null;
		String userId = null, userName = null, userAlias =null;
		Date createdDate = null, modifiedDate = null;
		Integer userStatus = null, userRegStatus = null;
		List<User> userList = new ArrayList<User>();
		List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
				+ "from User a, RoleUser b where a.userId = b.userId and b.roleId = ? order by a.userSort", new Object[] { roleId });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) userId = (String)objArray[0];
				if (objArray[1] != null) userName = (String)objArray[1];
				if (objArray[2] != null) userAlias = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				if (objArray[5] != null) userStatus = (Integer)objArray[5];
				if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setUserAlias(userAlias);
				user.setCreatedDate(createdDate);
				user.setModifiedDate(modifiedDate);
				user.setUserStatus(userStatus);
				user.setUserRegStatus(userRegStatus);
				userList.add(user);
			}
		}
		return userList;
	}
	
	public List<User> getUsers(int startIndex, int rows, String sorter, String sortingAttribute) {
		return userDao.search("from User where deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { User.NORMAL }, startIndex, rows);
	}
	
	public List<User> getUsers(String condition, int startIndex, int rows, String sorter, String sortingAttribute) {
		User user = null;
		String userId = null, userName = null, userAlias = null;
		Date createdDate = null, modifiedDate = null;
		Integer userStatus = null, userRegStatus = null;
		List<User> userList = new ArrayList<User>();
		List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
				+ "from User a, UserDetail b where a.userId = b.userId and a.deleteFlag = ? and "
				+ "(a.userName like '%" + condition + "%' or a.userAlias like '%" + condition + "%' or b.userCellphone like '%" + condition + "%') "
				+ "order by a." + sorter + " " + sortingAttribute, new Object[] { User.NORMAL }, startIndex, rows);
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) userId = (String)objArray[0];
				if (objArray[1] != null) userName = (String)objArray[1];
				if (objArray[2] != null) userAlias = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				if (objArray[5] != null) userStatus = (Integer)objArray[5];
				if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setUserAlias(userAlias);
				user.setCreatedDate(createdDate);
				user.setModifiedDate(modifiedDate);
				user.setUserStatus(userStatus);
				user.setUserRegStatus(userRegStatus);
				userList.add(user);
			}
		}
		return userList;
	}
	
	public List<User> getUsersByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute) {
		if ( orgId != null ) {
			if ( orgId.trim().equals("root") ) {
				User user = null;
				String userId = null, userName = null, userAlias = null;
				Date createdDate = null, modifiedDate = null;
				Integer userStatus = null, userRegStatus = null;
				List<User> userList = new ArrayList<User>();
				List resultList = userDao.searchBySQL("select a.pk_user_id, a.f_user_name, a.f_user_alias, a.f_created_date, a.f_modified_date, a.f_status, a.f_reg_status "
						+ "from t_user a left join t_user_org b on a.pk_user_id = b.fk_user_id where b.fk_org_id is null and a.f_del_flag = ? order by a.f_created_date desc", new Object[] { User.NORMAL }, startIndex, rows);
				if ( resultList != null && resultList.size() > 0 ) {
					for ( int i = 0; i < resultList.size(); i++ ) {
						Object[] objArray = (Object[])resultList.get(i);
						
						if (objArray[0] != null) userId = (String)objArray[0];
						if (objArray[1] != null) userName = (String)objArray[1];
						if (objArray[2] != null) userAlias = (String)objArray[2];
						if (objArray[3] != null) createdDate = (Date)objArray[3];
						if (objArray[4] != null) modifiedDate = (Date)objArray[4];
						if (objArray[5] != null) userStatus = (Integer)objArray[5];
						if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
						
						user = new User();
						user.setUserId(userId);
						user.setUserName(userName);
						user.setUserAlias(userAlias);
						user.setCreatedDate(createdDate);
						user.setModifiedDate(modifiedDate);
						user.setUserStatus(userStatus);
						user.setUserRegStatus(userRegStatus);
						userList.add(user);
					}
				}
				return userList;
			} else {
				User user = null;
				String userId = null, userName = null, userAlias = null;
				Date createdDate = null, modifiedDate = null;
				Integer userStatus = null, userRegStatus = null;
				List<User> userList = new ArrayList<User>();
				List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
						+ "from User a, UserOrganization b where a.userId=b.userId and b.orgId = ? and a.deleteFlag = ? order by a." + sorter + " " + sortingAttribute, new Object[] { orgId, User.NORMAL }, startIndex, rows);
				if ( resultList != null && resultList.size() > 0 ) {
					for ( int i = 0; i < resultList.size(); i++ ) {
						Object[] objArray = (Object[])resultList.get(i);
						
						if (objArray[0] != null) userId = (String)objArray[0];
						if (objArray[1] != null) userName = (String)objArray[1];
						if (objArray[2] != null) userAlias = (String)objArray[2];
						if (objArray[3] != null) createdDate = (Date)objArray[3];
						if (objArray[4] != null) modifiedDate = (Date)objArray[4];
						if (objArray[5] != null) userStatus = (Integer)objArray[5];
						if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
						
						user = new User();
						user.setUserId(userId);
						user.setUserName(userName);
						user.setUserAlias(userAlias);
						user.setCreatedDate(createdDate);
						user.setModifiedDate(modifiedDate);
						user.setUserStatus(userStatus);
						user.setUserRegStatus(userRegStatus);
						userList.add(user);
					}
				}
				return userList;
			}
		}
		return new ArrayList<User>();
	}
	
	public List<User> getUsersByOrg(String orgId, String condition, int startIndex, int rows, String sorter, String sortingAttribute) {
		if ( orgId != null ) {
			if ( orgId.trim().equals("root") ) {
				User user = null;
				String userId = null, userName = null, userAlias = null;
				Date createdDate = null, modifiedDate = null;
				Integer userStatus = null, userRegStatus = null;
				List<User> userList = new ArrayList<User>();
				
				String sql = "select a.pk_user_id, a.f_user_name, a.f_user_alias, a.f_created_date, a.f_modified_date, a.f_status, a.f_reg_status "
						+ "from t_user a left join t_user_org b on a.pk_user_id = b.fk_user_id "
						+ "left join t_user_detail c on a.pk_user_id = c.fk_user_id "
						+ "where b.fk_org_id is null and a.f_del_flag = ? and "
						+ "(a.f_user_name like '%" + condition + "%' or a.f_user_alias like '%" + condition + "%' or c.f_user_mp like '%" + condition + "%') "
						+ "order by a.f_created_date desc";
				
				List resultList = userDao.searchBySQL(sql, new Object[] { User.NORMAL }, startIndex, rows);
				if ( resultList != null && resultList.size() > 0 ) {
					for ( int i = 0; i < resultList.size(); i++ ) {
						Object[] objArray = (Object[])resultList.get(i);
						
						if (objArray[0] != null) userId = (String)objArray[0];
						if (objArray[1] != null) userName = (String)objArray[1];
						if (objArray[2] != null) userAlias = (String)objArray[2];
						if (objArray[3] != null) createdDate = (Date)objArray[3];
						if (objArray[4] != null) modifiedDate = (Date)objArray[4];
						if (objArray[5] != null) userStatus = (Integer)objArray[5];
						if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
						
						user = new User();
						user.setUserId(userId);
						user.setUserName(userName);
						user.setUserAlias(userAlias);
						user.setCreatedDate(createdDate);
						user.setModifiedDate(modifiedDate);
						user.setUserStatus(userStatus);
						user.setUserRegStatus(userRegStatus);
						userList.add(user);
					}
				}
				return userList;
			} else {
				User user = null;
				String userId = null, userName = null, userAlias = null;
				Date createdDate = null, modifiedDate = null;
				Integer userStatus = null, userRegStatus = null;
				List<User> userList = new ArrayList<User>();
				List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, a.userRegStatus "
						+ "from User a, UserOrganization b, UserDetail c "
						+ "where a.userId = b.userId and a.userId = c.userId and b.userId = c.userId and b.orgId = ? and a.deleteFlag = ? and "
						+ "(a.userName like '%" + condition + "%' or a.userAlias like '%" + condition + "%' or c.userCellphone like '%" + condition + "%')"
						+ "order by a." + sorter + " " + sortingAttribute, new Object[] { orgId, User.NORMAL }, startIndex, rows);
				if ( resultList != null && resultList.size() > 0 ) {
					for ( int i = 0; i < resultList.size(); i++ ) {
						Object[] objArray = (Object[])resultList.get(i);
						
						if (objArray[0] != null) userId = (String)objArray[0];
						if (objArray[1] != null) userName = (String)objArray[1];
						if (objArray[2] != null) userAlias = (String)objArray[2];
						if (objArray[3] != null) createdDate = (Date)objArray[3];
						if (objArray[4] != null) modifiedDate = (Date)objArray[4];
						if (objArray[5] != null) userStatus = (Integer)objArray[5];
						if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
						
						user = new User();
						user.setUserId(userId);
						user.setUserName(userName);
						user.setUserAlias(userAlias);
						user.setCreatedDate(createdDate);
						user.setModifiedDate(modifiedDate);
						user.setUserStatus(userStatus);
						user.setUserRegStatus(userRegStatus);
						userList.add(user);
					}
				}
				return userList;
			}
		}
		return new ArrayList<User>();
	}
	
	public boolean removeUser(String userId) {
		if ( isSystemAdministrator(userId) ) return false;
		userDao.executeHql("delete from User where userId = ?", new Object[] { userId });
		userDetailService.removeUserDetailByUser(userId); //remove relationship of users and details
		userOrgService.removeUserOrganizationByUser(userId); //remove relationship of users and orgs
		roleUserService.removeRoleUserByUser(userId); //remove relationship of users and roles
		Long qty = userDao.count("select count(userId) from User where userId = ?" , new Object[] { userId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean setUserDelFlag(String userId, Integer deleteFlag) {
		if ( isSystemAdministrator(userId) ) return false;
		Integer userStatus = null;
		if ( deleteFlag.intValue() == User.REMOVED ) userStatus = User.DISABLE;
		if ( deleteFlag.intValue() == User.NORMAL ) userStatus = User.ENABLE;
		
		Integer status = userDao.executeHql("update User set deleteFlag = ?, userStatus = ? where userId = ?", new Object[] { deleteFlag, userStatus, userId });
		if ( status.intValue() == 1 ) return true;
		return false;
	}
	
	public boolean setUserRegStatus(String userId, Integer userRegStatus) {
		Integer status = userDao.executeHql("update User set userRegStatus = ? where userId = ?", new Object[] { userRegStatus, userId });
		if ( status.intValue() == 1 ) return true;
		return false;
	}
	
	public boolean removeUser(String[] userIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		List<String> filteredUserIdList = new ArrayList<String>();
		for (String userId : userIds) {
			if ( !isSystemAdministrator(userId) ) {
				filteredUserIdList.add(userId);
			}
		}
		
		for (String userId : filteredUserIdList) {
			userDao.executeHql("delete from User where userId = ?", new Object[] { userId });
			userDetailService.removeUserDetailByUser(userId); //remove relationship of users and details
			userOrgService.removeUserOrganizationByUser(userId); //remove relationship of users and orgs
			roleUserService.removeRoleUserByUser(userId); //remove relationship of users and roles
			qty = userDao.count("select count(userId) from User where userId = ?" , new Object[] { userId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == filteredUserIdList.size() ) return true;
		return false;
	}
	
	public boolean saveUser(User user) {
		if ( !validateUser(user) ) return false;
		
		String method = "";
		if ( user.getUserId() == null ) { 
			method = "add";
			if ( existUser(user.getUserName()) ) return false;
		}
		else {
			method = "update";
			user.setUserRegStatus(User.EXISTING);
			user.setModifiedDate(new Date());
		}
		userDao.saveOrUpdate(user);
		if ( method.equals("add") ) {
			if ( user.getUserId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean saveUser(User user, UserDetail userDetail, String orgId, String roleId) {
		try {
			if ( !validateUser(user) ) return false;
			if ( !userDetailService.validateUserDetail(userDetail) ) return false;
			
			Organization org = null; Role role = null;
			if ( orgId != null && !orgId.trim().equals("") ) org = organizationService.getOrganizationById(orgId);
			if ( roleId != null && !roleId.trim().equals("") ) role = roleService.getRoleById(roleId);
			
			String method = "";
			if ( user.getUserId() == null ) { //Add new user
				method = "add";
				if ( existUser(user.getUserName()) ) return false;
				
				if ( user.getUserPwd() == null || ( user.getUserPwd() != null && user.getUserPwd().trim().equals("") ) ) { user.setUserPwd(MD5Encryption.encrypt(Const.USER_DEFAULT_PWD)); }
				else { user.setUserPwd(MD5Encryption.encrypt(user.getUserPwd())); }
				
				user.setUserSort( ( org != null ) ? getMaxUserSort(org.getOrgId()) : new Integer(0) );
				user.setCreatedDate(new Date());
				
				saveUser(user);
				
				if ( user.getUserId() != null ) {
					userDetail.setUserId(user.getUserId());
					userDetailService.saveUserDetail(userDetail);
				}
				
				if ( role != null ) {
					RoleUser roleUser = new RoleUser();
					roleUser.setRoleId(role.getRoleId());
					roleUser.setUserId(user.getUserId());
					roleUserService.saveRoleUser(roleUser);
				}
				
				if ( org != null ) {
					UserOrganization userOrg = new UserOrganization();
					userOrg.setUserId(user.getUserId());
					userOrg.setOrgId(org.getOrgId());
					userOrgService.saveUserOrganization(userOrg);
				}
			}
			else { //Update user
				method = "update";
				
				if ( user.getUserPwd() != null 
						&& !user.getUserPwd().trim().equals("") 
						&& !user.getUserPwd().trim().equals(getUserOriginalPwdById(user.getUserId()))) {
					user.setUserPwd(MD5Encryption.encrypt(user.getUserPwd()));
				} else {
					user.setUserPwd(getUserOriginalPwdById(user.getUserId()));
				}
				
				saveUser(user);
					
				if ( user.getUserId() != null ) {
					userDetail.setUserId(user.getUserId());
					userDetailService.saveUserDetail(userDetail);
				}
				
				if ( role != null ) {
					roleUserService.removeRoleUserByUser(user.getUserId());
					RoleUser roleUser = new RoleUser();
					roleUser.setRoleId(role.getRoleId());
					roleUser.setUserId(user.getUserId());
					roleUserService.saveRoleUser(roleUser);
				}
				
				if ( org != null ) {
					userOrgService.removeUserOrganizationByUser(user.getUserId());
					UserOrganization userOrg = new UserOrganization();
					userOrg.setUserId(user.getUserId());
					userOrg.setOrgId(org.getOrgId());
					userOrgService.saveUserOrganization(userOrg);
				}
			}
			
			if ( method.equals("add") ) {
				if ( user.getUserId() != null ) return true;
			} else { return true; }
		} catch(Exception ex) { ex.printStackTrace(); }
		return false;
	}
	
	public boolean saveUser(User user, UserDetail userDetail, String orgId, String[] roleIds) {//TODO
		try {
			if ( !validateUser(user) ) return false;
			if ( !userDetailService.validateUserDetail(userDetail) ) return false;
			
			Organization org = null; List<Role> roles = null;
			if ( orgId != null && !orgId.trim().equals("") ) org = organizationService.getOrganizationById(orgId);
			if ( roleIds != null ) roles = roleService.getRolesByIds(roleIds);
			
			String method = "";
			if ( user.getUserId() == null ) { //Add new user
				method = "add";
				if ( existUser(user.getUserName()) ) return false;
				
				if ( user.getUserPwd() == null || ( user.getUserPwd() != null && user.getUserPwd().trim().equals("") ) ) { user.setUserPwd(MD5Encryption.encrypt(Const.USER_DEFAULT_PWD)); }
				else { user.setUserPwd(MD5Encryption.encrypt(user.getUserPwd())); }
				
				user.setUserSort( ( org != null ) ? getMaxUserSort(org.getOrgId()) : new Integer(0) );
				user.setCreatedDate(new Date());
				
				saveUser(user);
				
				if ( user.getUserId() != null ) {
					userDetail.setUserId(user.getUserId());
					userDetailService.saveUserDetail(userDetail);
				}
				
				if ( roles != null ) {
					for (Role role : roles) {
						RoleUser roleUser = new RoleUser();
						roleUser.setRoleId(role.getRoleId());
						roleUser.setUserId(user.getUserId());
						roleUserService.saveRoleUser(roleUser);
					}
				}
				
				if ( org != null ) {
					UserOrganization userOrg = new UserOrganization();
					userOrg.setUserId(user.getUserId());
					userOrg.setOrgId(org.getOrgId());
					userOrgService.saveUserOrganization(userOrg);
				}
			}
			else { //Update user
				method = "update";
				
				if ( user.getUserPwd() != null 
						&& !user.getUserPwd().trim().equals("") 
						&& !user.getUserPwd().trim().equals(getUserOriginalPwdById(user.getUserId()))) {
					user.setUserPwd(MD5Encryption.encrypt(user.getUserPwd()));
				} else {
					user.setUserPwd(getUserOriginalPwdById(user.getUserId()));
				}
				
				saveUser(user);
					
				if ( user.getUserId() != null ) {
					userDetail.setUserId(user.getUserId());
					userDetailService.saveUserDetail(userDetail);
				}
				
				if ( roles != null ) {
					roleUserService.removeRoleUserByUser(user.getUserId());
					for (Role role : roles) {
						RoleUser roleUser = new RoleUser();
						roleUser.setRoleId(role.getRoleId());
						roleUser.setUserId(user.getUserId());
						roleUserService.saveRoleUser(roleUser);
					}
				}
				
				if ( org != null ) {
					userOrgService.removeUserOrganizationByUser(user.getUserId());
					UserOrganization userOrg = new UserOrganization();
					userOrg.setUserId(user.getUserId());
					userOrg.setOrgId(org.getOrgId());
					userOrgService.saveUserOrganization(userOrg);
				}
			}
			
			if ( method.equals("add") ) {
				if ( user.getUserId() != null ) return true;
			} else { return true; }
		} catch(Exception ex) { ex.printStackTrace(); }
		return false;
	}
	
	public boolean saveUserStatus(String[] userIds, Integer userStatus) {
		for (String userId : userIds) {
			userDao.executeHql("update User set userStatus = ? where userId = ?", new Object[] { userStatus, userId });
		}
		return true;
	}
	
	public boolean saveUserDefaultPwd(String[] userIds, String defaultPwd) {
		for (String userId : userIds) {
			userDao.executeHql("update User set userPwd = ? where userId = ?", new Object[] { defaultPwd, userId });
		}
		return true;
	}
	
	public boolean existUser(String userName) {
		Long qty = userDao.count("select count(userId) from User where userName = ?", new Object[] { userName });
		if ( qty > 0 ) return true;
		return false;
	}
	
	public boolean saveUserPwd(User user, String newPwd) {
		if ( user != null ) {
			user.setUserPwd(MD5Encryption.encrypt(newPwd));
			userDao.saveOrUpdate(user);
			return true;
		}
		return false;
	}
	
	public boolean saveUserProfile(User user, UserDetail userDetail) {
		if ( user != null && userDetail != null ) {
			if ( !validateUser(user) ) return false;
			if ( !userDetailService.validateUserDetail(userDetail) ) return false;
			
			user.setUserPwd(this.getUserPwd(user.getUserId()));
			
			saveUser(user);
			userDetailService.saveUserDetail(userDetail);
			return true;
		}
		return false;
	}
	
	public CurrentUser getCurrentUser(User user) {
		if ( user != null ) {
			Organization org = null;
			List<Organization> orgList = organizationService.getOrganizationsByUser(user.getUserId());
			if ( orgList != null && orgList.size() > 0 ) org = orgList.get(0);
			
			UserDetail userDetail = userDetailService.getUserDetailByUser(user.getUserId());
			
			CurrentUser currentUser = new CurrentUser();
			currentUser.setUserId(user.getUserId());
			currentUser.setUserName(user.getUserName());
			currentUser.setUserAlias(user.getUserAlias());
			currentUser.setUserType(user.getUserType());
			if ( org != null ) {
				currentUser.setOrgId(org.getOrgId());
				currentUser.setOrgName(org.getOrgName());
				currentUser.setOrgSN(org.getOrgSN());
				
				if ( org.getVersionId() != null 
						&& !org.getVersionId().trim().equals("") ) {
					VersionCopy verCp = versionCopyService.getVersionCopyByOrg(org.getOrgId());
					if ( verCp != null ) {
						List<String> modules = StringUtil.separate2List(verCp.getModuleLabels(), ",");
						for ( String module : modules ) {
							currentUser.getVerModules().put(module, module);
						}
						
						currentUser.setActivatedDate(verCp.getActivatedDate());
						currentUser.setExpiredDate(verCp.getExpiredDate());
					}
				}
			}
			if ( userDetail != null ) {
				currentUser.setUserSex(userDetail.getUserSex());
				currentUser.setUserIdCard(userDetail.getUserIdCard());
				currentUser.setUserEmail(userDetail.getUserEmail());
				currentUser.setUserTelephone(userDetail.getUserTelephone());
				currentUser.setUserCellphone(userDetail.getUserCellphone());
				currentUser.setCountry(userDetail.getCountry());
			}
			
			loadUserAuthInfo(currentUser); //加载当前登录用户的权限和资源
			
			return currentUser;
		}
		return null;
	}
	
	/**
	 * 加载当前登录用户的角色、权限、资源数据
	 * @param currentUser 当前登录用户
	 * */
	private void loadUserAuthInfo(CurrentUser currentUser) {
		try {
			if ( currentUser != null ) {
				List<Authority> authorityList = null;
				List<org.pangolin.eeip.entity.Resource> resourceList = null;
				List<Role> roleList = roleService.getRolesByUser(currentUser.getUserId());
				if ( roleList != null && roleList.size() > 0 ) {
					for ( Role role : roleList ) {
						currentUser.getRoles().put(role.getRoleLabel(), role.getRoleId());
						
						if ( USING_CACHE ) {
							authorityList = getAuthoritiesInCache(role.getRoleLabel());
							for ( Authority authority : authorityList ) {
								currentUser.getAuthorities().put(authority.getAuthorityLabel(), authority.getAuthorityId());
							}
							
							resourceList = getResourcesInCache(role.getRoleLabel());
							for ( org.pangolin.eeip.entity.Resource resource : resourceList ) {
								currentUser.getResources().put(resource.getResourceLabel(), resource.getResourceLocation());
							}
						} else {
							authorityList = authorityService.getAuthoritiesByRole(role.getRoleId());
							if ( authorityList != null && authorityList.size() > 0 ) {
								for ( Authority authority : authorityList ) { 
									currentUser.getAuthorities().put(authority.getAuthorityLabel(), authority.getAuthorityId());
								}
							}
							
							resourceList = resourceService.getResourcesByRole(role.getRoleId());
							if ( resourceList != null && resourceList.size() > 0 ) {
								for ( org.pangolin.eeip.entity.Resource resource : resourceList ) { 
									currentUser.getResources().put(resource.getResourceLabel(), resource.getResourceLocation());
								}
							}
						}
					}
				}
			}			
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	/**
	 * 从缓存获取角色权限
	 * @param roleLabel 角色标记
	 * @return 权限清单
	 * */
	private List<Authority> getAuthoritiesInCache(String roleLabel) {
		try {
			if ( roleLabel != null && !roleLabel.trim().equals("") ) {
				List<Authority> authorityList = null;
				if ( Const.ROLE_AUTH_MAP.containsKey(roleLabel) ) {
					authorityList = Const.ROLE_AUTH_MAP.get(roleLabel);
					if ( authorityList != null && authorityList.size() > 0 ) return authorityList;
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return new ArrayList<Authority>();
	}
	
	/**
	 * 从缓存获取角色资源
	 * @param roleLabel 角色标记
	 * @return 资源清单
	 * */
	private List<org.pangolin.eeip.entity.Resource> getResourcesInCache(String roleLabel) {
		try {
			if ( roleLabel != null && !roleLabel.trim().equals("") ) {
				List<org.pangolin.eeip.entity.Resource> resourceList = null;
				if ( Const.ROLE_RESOURCE_MAP.containsKey(roleLabel) ) {
					resourceList = Const.ROLE_RESOURCE_MAP.get(roleLabel);
					if ( resourceList != null && resourceList.size() > 0 ) return resourceList;
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return new ArrayList<org.pangolin.eeip.entity.Resource>();
	}
	
	/**
	 * 获取用户排序号
	 * @author Oscar Mok
	 * @return 用户排序号
	 * */
	private Integer getMaxUserSort(String orgId) {
		if ( orgId != null && !orgId.trim().equals("") ) {
			List list = userDao.compSearch("select a.userSort from User a, UserOrganization b where a.userId = b.userId and b.orgId = ? order by a.userSort desc", new Object[] { orgId });
			if ( list != null && list.size() > 0 ) {
				Integer userSort = (Integer)list.get(0);
				return userSort+1;
			} else {
				return 1;
			}
		}
		return 0;
	}
	
	public void reloadUserRoles() {
		List<RoleUserDto> roleUserDtoList = roleUserService.getRoleUserDtos();
		Role role = null; List<Role> roleList = null;
		List<User> userList = getUsers();
		for ( User user : userList ) {
			roleList = new ArrayList<Role>();
			for ( RoleUserDto roleUserDto : roleUserDtoList ) {
				if ( roleUserDto.getUserName().trim().equals(user.getUserName()) ) {
					role = new Role();
					role.setRoleId(roleUserDto.getRoleId());
					role.setRoleName(roleUserDto.getRoleName());
					role.setRoleLabel(roleUserDto.getRoleLabel());
					roleList.add(role);
				}
			}			
			Const.USER_ROLE_MAP.put(user.getUserName(), roleList);
		}
	}
	
	public void reloadUserRole(User user) {
		if ( user != null ) {
			List<Role> roleList = roleService.getRolesByUser(user.getUserId());
			if ( roleList != null && roleList.size() > 0 ) Const.USER_ROLE_MAP.put(user.getUserName(), roleList);
		}
	}
	
	public boolean verifyRegUserData(UserDto userDto) {
		if ( userDto != null ) {
			if ( userDto.getUserName() != null && !userDto.getUserName().trim().equals("") 
					&& userDto.getUserAlias() != null && !userDto.getUserAlias().trim().equals("")
					&& userDto.getUserPwd() != null && !userDto.getUserPwd().trim().equals("")
					&& userDto.getUserConfirmPwd() != null && !userDto.getUserConfirmPwd().trim().equals("")
					&& userDto.getUserPwd().trim().equals(userDto.getUserConfirmPwd().trim())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyUserOriginalPassword(User user, String originalPassword) {
		if ( user != null && user.getUserPwd().trim().equals(MD5Encryption.encrypt(originalPassword))) {
			return true;
		}
		return false;
	}
	
	public boolean validateUser(User user) {
		boolean status = true;
		if ( user != null ) {
			//验证用户帐号格式
			if ( user.getUserName() != null ) {
				if ( user.getUserName().trim().equals("") ) return false;
				status = StringValidator.isValidUserName(user.getUserName());
				if (!status) return status;
			}
			
			//验证用户姓名格式
			if ( user.getUserAlias() != null ) {
				if ( user.getUserAlias().trim().equals("") ) return false;
				status = StringValidator.isValidUserAlias(user.getUserAlias());
				if (!status) return status;
			}
		}
		return status;
	}
	
	public String getUserPwd(String userId) {
		List list = userDao.compSearch("select userPwd from User where userId = ?", new Object[] { userId });
		if ( list != null && list.size() > 0 ) {
			String userPwd = (String)list.get(0);
			return userPwd;
		}
		return null;
	}
	
	/**
	 * 验证是否为系统超级管理员或者系统管理员（二级）
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 系统管理员状态
	 * */
	private boolean isSystemAdministrator(String userId) {
		if ( userId != null && !userId.trim().equals("") ) {
			User user = getUserById(userId);
			if ( user != null ) {
				if ( user.getUserName().trim().equals(Const.ADMINISTRATOR_ACCOUNT) ) return true;
				else {
					List<Role> roleList = roleService.getRolesByUser(userId);
					if ( roleList != null && roleList.size() > 0 ) {
						for ( Role role : roleList ) {
							if ( role.getRoleLabel().trim().equals(Const.SECONDARY_ADMINISTRATOR_ROLE) ) return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public List<User> getUsersByRoleId(String roleId) {
		User user = null;
		String userId = null, userName = null, userAlias =null;
		Date createdDate = null, modifiedDate = null;
		Integer userStatus = null, userRegStatus = null;
		List<User> userList = new ArrayList<User>();
		List resultList = userDao.compSearch("select a.userId, a.userName, a.userAlias, a.createdDate, a.modifiedDate, a.userStatus, "
				+ "a.userRegStatus from User as a ,RoleUser as b   where a.userId = b.userId and b.roleId =? and a.deleteFlag = ? and  "
				+ "a.userId not in (select appraiserId from AppraisalSitn)", new Object[] { roleId, User.NORMAL });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) userId = (String)objArray[0];
				if (objArray[1] != null) userName = (String)objArray[1];
				if (objArray[2] != null) userAlias = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				if (objArray[5] != null) userStatus = (Integer)objArray[5];
				if (objArray[6] != null) userRegStatus = (Integer)objArray[6];
				
				user = new User();
				user.setUserId(userId);
				user.setUserName(userName);
				user.setUserAlias(userAlias);
				user.setCreatedDate(createdDate);
				user.setModifiedDate(modifiedDate);
				user.setUserStatus(userStatus);
				user.setUserRegStatus(userRegStatus);
				userList.add(user);
			}
		}
		return userList;
	}
}