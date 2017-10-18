package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.OrgDto;
import org.pangolin.eeip.dto.UserDto;
import org.pangolin.eeip.dto.UserPasswordDto;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.service.OrganizationService;
import org.pangolin.eeip.service.RoleService;
import org.pangolin.eeip.service.RoleUserService;
import org.pangolin.eeip.service.UserDetailService;
import org.pangolin.eeip.service.UserOrganizationService;
import org.pangolin.eeip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户管理 Controller
 * @author Oscar Mok
 */
@Controller
@SuppressWarnings("all")
public class UserController extends BaseController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserOrganizationService userOrganizationService;
	
	@Autowired
	private RoleUserService roleUserService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 用户数据列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.USER_MGT_LIST)
	public ModelAndView getUserListMV() {
        return new ModelAndView("/pangolin/systemMgt/userMgt/userList");
    }
	
	/**
	 * 用户表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.USER_MGT_FORM)
	public ModelAndView getUserFormMV() {
        return new ModelAndView("/pangolin/systemMgt/userMgt/userForm");
	}
	
	/**
	 * 用户资料表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.USER_MGT_PROFILE_FORM)
	public ModelAndView getUserProfileFormMV() {
        return new ModelAndView("/pangolin/systemMgt/userMgt/userProfileForm");
	}
	
	/**
	 * 用户密码修改表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.USER_MGT_PWD_FORM)
	public ModelAndView getUserPwdFormMV() {
        return new ModelAndView("/pangolin/systemMgt/userMgt/userPwdForm");
	}
	
	/**
	 * 用户列表数据源
	 * @author Oscar Mok
	 * @return 用户数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String orgId = params.getExtraParam("orgId");
		String condition = params.getExtraParam("condition");
		
		if ( orgId != null && !orgId.trim().equals("") ) {
			long totalCount = 0;
			List<User> userList = new ArrayList<User>();
			
			if ( condition != null && !condition.trim().equals("") ) {
				totalCount = userService.getUserQtyByOrg(orgId, condition);
				userList = userService.getUsersByOrg(orgId, condition, 
						                             params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
			} else {
				totalCount = userService.getUserQtyByOrg(orgId);
				userList = userService.getUsersByOrg(orgId, params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
			}
			return BootstrapDataGridUtil.getResultMap(params, totalCount, userList);
		} else {
			if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
				long totalCount = 0;
				List<User> userList = new ArrayList<User>();
				
				if ( condition != null && !condition.trim().equals("") ) {
					totalCount = userService.getUserQty(condition);
					userList = userService.getUsers(condition, params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				} else {
					totalCount = userService.getUserQty();
					userList = userService.getUsers(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				}
				return BootstrapDataGridUtil.getResultMap(params, totalCount, userList);
			} else {
				long totalCount = 0;
				List<User> userList = new ArrayList<User>();
				
				if ( condition != null && !condition.trim().equals("") ) {
					totalCount = userService.getUserQtyByOrg(getOrgIdByCurrentUser(), condition);
					userList = userService.getUsersByOrg(getOrgIdByCurrentUser(), condition, 
									                     params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				} else {
					totalCount = userService.getUserQtyByOrg(getOrgIdByCurrentUser());
					userList = userService.getUsersByOrg(getOrgIdByCurrentUser(), 
									                     params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				}
				return BootstrapDataGridUtil.getResultMap(params, totalCount, userList);
			}
		}
	}
	
	/**
	 * 机构树数据源
	 * @author Oscar Mok
	 * @return 机构数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_ORG_TREE_GRID_DATA)
	@ResponseBody
	public Map<String, Object> getOrgTreeGridData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<OrgDto> orgList = new ArrayList<OrgDto>();
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			orgList =  organizationService.getAllUserOrganizationTreeGridData();
		} else {
			orgList = organizationService.getChildOrganizationTreeGridData(getOrgIdByCurrentUser());
		}
		resultMap.put("data", orgList);
		return resultMap;
	}
	
	/**
	 * 机构下拉选项数据源
	 * @author Oscar Mok
	 * @return 机构数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_ORG_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getOrgOptionsData(String userId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Organization> orgList = new ArrayList<Organization>();
		
		if ( userId != null && !userId.trim().equals("") ) { //Updating user data
			if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
				orgList = organizationService.getOrganizations();
			} else {
				Organization currentUserOrg = getOrgByUser(userId);
				if ( currentUserOrg != null ) {
					orgList.add(currentUserOrg);
					List<Organization> childOrgList = organizationService.getChildOrganizationsByCurrentOrg(currentUserOrg.getOrgId());
					for ( Organization childOrg : childOrgList ) orgList.add(childOrg);
				}
			}
		} else { //Adding user data
			if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
				orgList = organizationService.getOrganizations();
			}
			else {
				orgList = new ArrayList<Organization>();
				Organization currentUserOrg = organizationService.getOrganizationById(getOrgIdByCurrentUser());
				orgList.add(currentUserOrg);
				
				List<Organization> childOrgList = organizationService.getChildOrganizationsByCurrentOrg(currentUserOrg.getOrgId());
				for ( Organization childOrg : childOrgList ) orgList.add(childOrg);
			}
		}
		orgList = getHierarchicalOrgList(orgList);
		resultMap.put("entity", orgList);
		return resultMap;
	}
	
	/**
	 * 角色下拉选项数据源
	 * @author Oscar Mok
	 * @return 角色数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_ROLE_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getRoleOptionsData(String orgId, String userId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Role> roleList = new ArrayList<Role>();
		
		if ( userId != null && !userId.trim().equals("") ) { //Updating user data
			if ( orgId != null && !orgId.trim().equals("") ) {
				roleList = roleService.getRolesByOrg(orgId, Role.ENABLE);
				roleList = inheritParentOrgRoles(roleList, orgId);
				if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) roleList = loadRootRoles(roleList);
			} else {
				String roleLabel = getRoleLabelByCurrentUser();
				if ( roleLabel != null && !roleLabel.trim().equals("") ) {
					Role currentUserRole = roleService.getRoleByLabel(roleLabel);
					if ( currentUserRole != null ) {
						String roleOrgId = currentUserRole.getOrgId();
						if ( roleOrgId != null && !roleOrgId.trim().equals("") ) {
							roleList = roleService.getRolesByOrg(roleOrgId, Role.ENABLE);
						} else {
							if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) roleList = loadRootRoles(roleList);
						}
					}
				}
			}
		} else { //Adding user data
			if ( orgId != null && !orgId.trim().equals("") ) {
				roleList = roleService.getRolesByOrg(orgId, Role.ENABLE);
				roleList = inheritParentOrgRoles(roleList, orgId);
				if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) roleList = loadRootRoles(roleList);
			} else {
				if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
					roleList = roleService.getRootRoles(Role.ENABLE);
				} else {
					roleList = roleService.getRolesByOrg(getOrgIdByCurrentUser(), Role.ENABLE);
					roleList = inheritParentOrgRoles(roleList, getOrgIdByCurrentUser());
				}
			}
		}
		resultMap.put("entity", roleList);
		return resultMap;
	}
	
	/**
	 * 继承上级机构角色
	 * @author Oscar Mok
	 * @param roleList 角色列表
	 * @param orgId 当前选中的机构ID
	 * */
	private List<Role> inheritParentOrgRoles(List<Role> roleList, String orgId) {
		if ( roleList == null || ( roleList != null && roleList.size() == 0 ) ) {
			Organization currentUserOrg = organizationService.getOrganizationById(orgId);
			if ( currentUserOrg != null ) {
				Organization parentOrg = null;
				while (true) {
					if ( currentUserOrg.getParentOrgId() != null 
							&& !currentUserOrg.getParentOrgId().trim().equals("") ) {
						parentOrg = organizationService.getOrganizationById(currentUserOrg.getParentOrgId());
						if ( parentOrg != null ) {
							currentUserOrg = parentOrg;
							roleList = roleService.getRolesByOrg(parentOrg.getOrgId());
							if ( roleList != null && roleList.size() > 0 ) break;
						}
					} else {
						roleList = new ArrayList<Role>();
						break;
					}
				}
			}
		}
		return roleList;
	}
	
	/**
	 * 加载顶层角色列表
	 * @author Oscar Mok
	 * @param roleList 角色列表
	 * */
	private List<Role> loadRootRoles(List<Role> roleList) {
		if ( roleList == null || ( roleList != null && roleList.size() == 0 ) ) roleList = roleService.getRootRoles();
		return roleList;
	}
	
	/**
	 * 所属指定部门获取用户数据源
	 * @author Oscar Mok
	 * @param orgId 部门ID
	 * @return 用户数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_OU_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getOrgUserData(String orgId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( orgId != null && !orgId.trim().equals("") ) {
			List<User> userList = userService.getUsersByOrg(orgId);
			resultMap.put("entity", userList);
		} else {
			resultMap.put("entity", new ArrayList<User>());
		}
		return resultMap;
	}
	
	/**
	 * 所属指定角色获取用户数据源
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 用户数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_RU_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getRoleUserData(String roleId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( roleId != null && !roleId.trim().equals("") ) {
			List<User> userList = userService.getUsersByRole(roleId);
			if ( userList != null && userList.size() > 0 ) {
				resultMap.put("entity", userList);
			}
		}
		return resultMap;
	}
	
	/**
	 * 根据角色标识获取用户列表
	 * @author Oscar Mok
	 * @param roleLabel 角色标识
	 * @return 角色数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_RU_DATA)
	@ResponseBody
	public Map<String, Object> getRoleUserDataByRoleLabel(String roleLabel) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( roleLabel != null && !roleLabel.trim().equals("") ) {
			Role role = roleService.getRoleByLabel(roleLabel);
			if ( role != null ) {
				List<User> userList = userService.getUsersByRole(role.getRoleId());
				if ( userList != null && userList.size() > 0 ) {
					resultMap.put("userList", userList);
				} else {
					resultMap.put("userList", new ArrayList<User>());
				}
			}
		}
		return resultMap;
	}
	
	/**
	 * 移除用户数据
	 * @author Oscar Mok
	 * @param orgId 组织ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeUserData(String userId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( userId != null && !userId.trim().equals("") ) {
			User user = userService.getUserById(userId);
			if ( user != null ) {
				status = userService.setUserDelFlag(userId, User.REMOVED);
				if ( status ) {
					saveOperationLog(user, OperationLog.REMOVE);
				}
			}
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 加载用户数据（用于更新）
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 指定用户数据JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getUserData(String userId) {//TODO
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( userId != null && !userId.trim().equals("") ) {
			userService.setUserRegStatus(userId, User.EXISTING);
			
			User user = userService.getUserById(userId);
			if ( user != null ) {
				/**
				 * 加载用户信息时不加载用户密码
				 * */
				user.setUserPwd(null);
				
				UserDetail userDetail = userDetailService.getUserDetailByUser(user.getUserId());
				
				Organization org = null;
				List<Organization> orgList = organizationService.getOrganizationsByUser(user.getUserId());
				if ( orgList != null && orgList.size() > 0 ) org = orgList.get(0);
				
//				Role role = null;
				List<Role> roleList = roleService.getRolesByUser(user.getUserId());
//				if ( roleList != null && roleList.size() > 0 ) role = roleList.get(0);
				
				UserDto userDto = UserDto.convertToUserDto(user, userDetail, org, roleList);
				
				resultMap.put("entity", ( userDto != null ) ? userDto : new UserDto());
			}
		} else resultMap.put("entity", new UserDto());
		return resultMap;
	}
	
	/**
	 * 保存用户数据
	 * @author Oscar Mok
	 * @param userDto 用户传输对象
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUser(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( userDto != null ) {
			User user = UserDto.convertToUser(userDto);
			UserDetail userDetail = UserDto.convertToUserDetail(userDto);
			Integer logType = getLogType(user);
			
			String[] roleIds = userDto.getRoleIds().split(",");
			boolean status = userService.saveUser(user, userDetail, userDto.getOrgId(), roleIds);
			if ( status ) {
				userService.reloadUserRoles();
				saveOperationLog(user, logType);
			}
			resultMap.put("status", status);
		}
		return resultMap;
	}
	
	/**
	 * 保存用户资料
	 * @author Oscar Mok
	 * @param userDto 用户传输对象
	 * @return 保存用户资料状态JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_SAVE_PROFILE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserProfile(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		User user = UserDto.convertToUser(userDto);
		UserDetail userDetail = UserDto.convertToUserDetail(userDto);
		boolean status = userService.saveUserProfile(user, userDetail);
		if ( status ) {
			saveOperationLog(user, OperationLog.MODIFY);
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 设置用户密码
	 * @param userPasswordDto 用户密码传输对象
	 * @return 设置密码情况JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_RESET_PWD_DATA)
	@ResponseBody
	public Map<String, Object> saveUserPassword(@RequestBody UserPasswordDto userPasswordDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( userPasswordDto != null ) {
			if ( userPasswordDto.getUserId() != null 
					&& userPasswordDto.getOriginalPassword() != null 
					&& userPasswordDto.getNewPassword() != null
				    && userPasswordDto.getConfirmPassword() != null
				    && userPasswordDto.getNewPassword().trim().equals(userPasswordDto.getConfirmPassword().trim()) ) {
				User user = userService.getUserById(userPasswordDto.getUserId());
				if ( user != null ) {
					if ( userService.verifyUserOriginalPassword(user, userPasswordDto.getOriginalPassword()) ) {
						status = userService.saveUserPwd(user, userPasswordDto.getNewPassword());
					}
				}
			}
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 注册用户资料（用户注册时使用）
	 * @return 注册用户JSON
	 * */
	@RequestMapping(NavConst.REGISTER_USER_DATA)
	@ResponseBody
	public Map<String, Object> registerUser(@RequestBody UserDto userDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		
		if ( userService.verifyRegUserData(userDto) ) {
			User regUser = UserDto.convertToUser(userDto);
			UserDetail regUserDetail = UserDto.convertToUserDetail(userDto);
			Role guest = roleService.getRoleByLabel(Const.GUEST_ROLE);
			
			status = userService.saveUser(regUser, regUserDetail, userDto.getOrgId(), guest.getRoleId());
			if ( status ) userService.reloadUserRoles();
		}
		
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 机构下拉选项数据源（用户注册时使用）
	 * @author Oscar Mok
	 * @return 机构数据集JSON
	 * */
	@RequestMapping(NavConst.REGISTER_USER_ORG_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getRegUserOrgOptionsData(String orgId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Organization> orgList = null;
		if ( orgId != null && !orgId.trim().equals("") ) {
			orgList = organizationService.getOrganizationsByParentOrg(orgId);
		} else {
			orgList = organizationService.getOrganizations();
		}
		resultMap.put("entity", orgList);
		return resultMap;
	}
	
	/**
	 * 根据用户ID获取机构ID
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 机构ID
	 * */
	private Organization getOrgByUser(String userId) {
		try {
			List<Organization> orgList = organizationService.getOrganizationsByUser(userId);
			if ( orgList != null && orgList.size() > 0 ) return orgList.get(0);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据用户ID获取角色ID
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 角色ID
	 * */
	private String getRoleLabelByUser(String userId) {
		try {
			List<Role> roleList = roleService.getRolesByUser(userId);
			if ( roleList != null && roleList.size() > 0 ) {
				String roleId = roleList.get(0).getRoleId();
				Role role = roleService.getRoleById(roleId);
				if ( role != null ) return role.getRoleLabel();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据机构层级获取空格
	 * @author Oscar Mok
	 * @param level 机构层级
	 * @return 空格
	 * */
	private String getBlank(int level) {
		String str = "";
		if ( level >= 0 ) {
			str += "ㅏ";
			for ( int i = 0; i < level; i ++ ) {
				str = "　" + str;
			}
		}
		return str;
	}
	
	/**
	 * 获取层级机构列表
	 * @author Oscar Mok
	 * @param 机构列表
	 * @return 已进行层级加工的机构列表
	 * */
	private List<Organization> getHierarchicalOrgList(List<Organization> orgList) {
		if ( orgList != null && orgList.size() > 0 ) {
			int firstOrgLevel = orgList.get(0).getOrgLevel().intValue();
			
			List<Organization> hierarchicalOrgList = new ArrayList<Organization>();
			for ( Organization org : orgList ) {
				org.setOrgName(getBlank(org.getOrgLevel().intValue() - firstOrgLevel) + org.getOrgName());
				hierarchicalOrgList.add(org);
			}
			if ( hierarchicalOrgList != null && hierarchicalOrgList.size() > 0 ) return hierarchicalOrgList;
		}
		return orgList;
	}
	
	/**
	 * 判断新增或编辑类型
	 * @author Oscar Mok
	 * @param user 用户对象
	 * @return 日志类型
	 * */
	private Integer getLogType(User user) {
		if ( user != null && user.getUserId() == null ) return OperationLog.ADD;
		else return OperationLog.MODIFY;
	}
	
	/**
	 * 保存操作日志
	 * @author Oscar Mok
	 * @param user 用户对象
	 * @param logType 日志类型
	 * */
	private void saveOperationLog(User user, Integer logType) {
		if ( logType.intValue() == OperationLog.ADD.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_USER_MGT, 
					                             OperationLog.ADD, "Add user " + user.getUserAlias() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.MODIFY.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_USER_MGT, 
					                             OperationLog.MODIFY, "Modify user " + user.getUserAlias() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.REMOVE.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_USER_MGT, 
					                             OperationLog.REMOVE, "Remove user " + user.getUserAlias() + " successfully", 
					                             getCurrentUser());
		}
	}
	
	/***
	 * 获取所有的用户
	 * @return
	 */
	@RequestMapping(NavConst.USER_MGT_ALL_USER_DATA)
	@ResponseBody
	public Map<String, Object> getAllUsers(){
		Map<String,Object> result = new HashMap<String, Object>();
		List<User> users = userService.getAllUsers();
		result.put("entity", users);
		return result;
	}
	
	/**
	 * 根据角色标识获取用户列表
	 * @author Oscar Mok
	 * @param roleLabel 角色标识
	 * @return 角色数据集JSON
	 * */
	@RequestMapping(NavConst.USER_MGT_RU_SITN_DATA)
	@ResponseBody
	public Map<String, Object> getUserDataByRoleLabel(String roleLabel) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( roleLabel != null && !roleLabel.trim().equals("") ) {
			Role role = roleService.getRoleByLabel(roleLabel);
			if ( role != null ) {
				List<User> userList = userService.getUsersByRoleId(role.getRoleId());
				if ( userList != null && userList.size() > 0 ) {
					resultMap.put("entity", userList);
				} else {
					resultMap.put("entity", new ArrayList<User>());
				}
			}
		}
		return resultMap;
	}
	
}