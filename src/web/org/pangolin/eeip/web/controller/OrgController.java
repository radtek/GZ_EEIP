package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.OrgDto;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;
import org.pangolin.eeip.entity.Version;
import org.pangolin.eeip.entity.VersionCopy;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.service.OrganizationService;
import org.pangolin.eeip.service.RoleService;
import org.pangolin.eeip.service.UserDetailService;
import org.pangolin.eeip.service.UserService;
import org.pangolin.eeip.service.VersionCopyService;
import org.pangolin.eeip.service.VersionService;
import org.pangolin.eeip.util.SerialNumberGenerator;
import org.pangolin.security.encryption.MD5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 机构管理 Controller
 * @author Oscar Mok
 */
@Controller
@SuppressWarnings("all")
public class OrgController extends BaseController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private VersionService versionService;
	
	@Autowired
	private VersionCopyService versionCopyService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 机构架构列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ORG_MGT_LIST)
	public ModelAndView getOrgListMV() {
        return new ModelAndView("/pangolin/systemMgt/orgMgt/orgList");
    }
	
	/**
	 * 机构架构表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ORG_MGT_FORM)
	public ModelAndView getOrgFormMV() {
        return new ModelAndView("/pangolin/systemMgt/orgMgt/orgForm");
	}
	
	/**
	 * 机构列表数据源
	 * @author Oscar Mok
	 * @return 机构数据集JSON
	 * */
	@RequestMapping(NavConst.ORG_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getOrgListData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<OrgDto> orgList = new ArrayList<OrgDto>();
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			orgList = organizationService.getAllOrganizationTreeGridData();
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
	@RequestMapping(NavConst.ORG_MGT_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getOrgOptionsData(String orgId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Organization> orgList = null;
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			orgList = organizationService.getOrganizations();
		}
		else {
			if ( orgId != null && !orgId.trim().equals("") ) {
				orgList = organizationService.getParentOrganizationsByCurrentOrg(orgId);
			} else {
				orgList = new ArrayList<Organization>();
				Organization currentOrg = organizationService.getOrganizationById(getOrgIdByCurrentUser());
				orgList.add(currentOrg);
				
				List<Organization> childOrgList = organizationService.getChildOrganizationsByCurrentOrg(currentOrg.getOrgId());
				for ( Organization childOrg : childOrgList ) orgList.add(childOrg);
			}
		}
		orgList = getHierarchicalOrgList(orgList);
		resultMap.put("entity", orgList);
		return resultMap;
	}
	
	/**
	 * 移除机构数据
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.ORG_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeOrgData(String orgId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( orgId != null && !orgId.trim().equals("") ) {
			Organization org = organizationService.getOrganizationById(orgId);
			if ( org != null ) {
				status = organizationService.setOrganizationDelFlag(org.getOrgId(), Organization.REMOVED);
				if ( status ) {
					this.clearAllCache();
					saveOperationLog(org, OperationLog.REMOVE);
				}
			}
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 加载机构数据（用于更新）
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 指定机构数据JSON
	 * */
	@RequestMapping(NavConst.ORG_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getOrgData(String orgId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( orgId != null && !orgId.trim().equals("") ) {
			Organization org = organizationService.getOrganizationById(orgId);
			if ( org != null ) {
				//Load parent organization
				if ( org.getParentOrgId() != null 
						&& !org.getParentOrgId().trim().equals("") ) {
					Organization parentOrg = organizationService.getOrganizationById(org.getParentOrgId());
					if ( parentOrg != null ) org.setParentOrgName(parentOrg.getOrgName());
				}
				
				//Load version copy information
				VersionCopy verCp = versionCopyService.getVersionCopyByOrg(org.getOrgId());
				if ( verCp != null ) {
					org.setActivatedDate(verCp.getActivatedDate());
					org.setExpiredDate(verCp.getExpiredDate());
				}
				
				//Load status of org admin
				boolean orgAdminStatus =  getOrgAdminStatus(org);
				org.setOrgAdminStatus(orgAdminStatus);
			}
			resultMap.put("entity", ( org != null ) ? org : new Organization());
		} else resultMap.put("entity", new Organization());
		return resultMap;
	}
	
	/**
	 * 保存机构数据
	 * @author Oscar Mok
	 * @param org 机构对象
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.ORG_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveOrg(@RequestBody Organization org) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( org != null ) {
			Integer logType = getLogType(org);
			boolean status = organizationService.saveOrganization(org);
			if ( status ) {
				
				//保存版本副本
				buildVersionCopy(org);
				
				//设置机构管理员
				if ( org.getOrgAdminStatus() != null ) {
					if ( org.getOrgAdminStatus() ) {
						buildSecondaryAdministrator(org);
						buildOtherRoles(org);
					} else {
						removeOrRestoreSecondaryAdministrator(org, User.REMOVED);
					}
				}
				
				this.clearAllCache();
				
				saveOperationLog(org, logType);
			}
			resultMap.put("status", status);
		}
		return resultMap;
	}
	
	/**
	 * 构建机构系统管理员
	 * @param org 机构对象
	 * */
	private void buildSecondaryAdministrator(Organization org) {
		try {
			String orgAdminRoleLabel = roleService.getOrgAdminRoleLabel(org);
			
			if ( !roleService.existRole(orgAdminRoleLabel, org) ) { //构建机构管理员
				Role copiedRole = 
						roleService.getRoleByLabel(Const.SECONDARY_ADMINISTRATOR_ROLE);
				if ( copiedRole != null ) {
					Role newRole = roleService.copyRole(copiedRole, org);
					
					User admin = new User();
					admin.setUserName(SerialNumberGenerator.getSecondaryAdminAccount());
					admin.setUserAlias(org.getOrgName() + Const.SECONDARY_ADMINISTRATOR_ALIAS);
					admin.setUserPwd(MD5Encryption.encrypt(Const.USER_DEFAULT_PWD));
					
					UserDetail adminDetail = new UserDetail();
					adminDetail.setUserId(admin.getUserId());
					
					/**
					 * 防止构建随机管理员账号时出现重复记录
					 * */
					while(true) {
						if ( userService.existUser(SerialNumberGenerator.getSecondaryAdminAccount()) ) {
							admin.setUserName(SerialNumberGenerator.getSecondaryAdminAccount());
						} else break;
					}
					
					userService.saveUser(admin, adminDetail, org.getOrgId(), newRole.getRoleId());
					
					userService.reloadUserRole(admin);
					roleService.reloadRoleAuthorities(newRole);
					roleService.reloadRoleName(newRole);
				}
			} else { //还原机构管理员数据
				removeOrRestoreSecondaryAdministrator(org, User.NORMAL);
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		
		this.clearAllCache();
	}
	
	/**
	 * 构建除一级、二级管理员外的其他角色
	 * @author Oscar Mok
	 * @param org 机构对象
	 * */
	private void buildOtherRoles(Organization org) {
		try {
			Role newRole = null;
			List<Role> newRoleList = new ArrayList<Role>();
			
			List<Role> roleList = roleService.getRootRoles();
			for ( Role role : roleList ) {
				if ( !role.getRoleLabel().trim().equals(Const.ADMINISTRATOR_ROLE) 
						&& !role.getRoleLabel().trim().equals(Const.SECONDARY_ADMINISTRATOR_ROLE) ) {
					newRole = roleService.copyRole(role, org);
					newRoleList.add(newRole);
				}
			}
			
			for ( Role role : newRoleList ) {
				roleService.reloadRoleAuthorities(role);
				roleService.reloadRoleName(role);
			}
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	/**
	 * 删除或还原机构系统管理员
	 * @param org 机构对象
	 * */
	private void removeOrRestoreSecondaryAdministrator(Organization org, Integer deleteFlag) {
		try {
			if ( org != null && deleteFlag != null ) {
				String orgAdminRoleLabel = roleService.getOrgAdminRoleLabel(org);
				if ( roleService.existRole(orgAdminRoleLabel, org) ) {
					Role role = roleService.getRoleByLabel(orgAdminRoleLabel);
					if ( role != null ) {
						List<User> userList = userService.getAllUsersByRole(role.getRoleId());
						for ( User user : userList ) {
							userService.setUserDelFlag(user.getUserId(), deleteFlag);
						}
					}
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	/**
	 * 根据机构获取机构管理员开关状态
	 * @author Oscar Mok
	 * @param org 机构对象
	 * @return 机构管理员存在情况
	 * */
	private boolean getOrgAdminStatus(Organization org) {
		try {
			if ( org != null ) {
				String orgAdminRoleLabel = roleService.getOrgAdminRoleLabel(org);
				Role role = roleService.getRoleByLabel(orgAdminRoleLabel);
				if ( role != null ) {
					List<User> userList = userService.getUsersByRole(role.getRoleId());
					if ( userList != null && userList.size() > 0 ) return true;
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return false;
	}
	
	/**
	 * 构建机构的版本副本
	 * @author Oscar Mok
	 * @param org 机构对象
	 * @return 
	 * */
	private void buildVersionCopy(Organization org) {
		if ( org.getParentOrgId() != null 
				&& !org.getParentOrgId().trim().equals("") ) { //构建下层机构时建立机构版本副本（下层机构继承上层机构的版本副本）
			Organization parentOrg = organizationService.getOrganizationById(org.getParentOrgId());
			if ( parentOrg != null ) {
				versionCopyService.copyVersionCopy(org, parentOrg);
			}
		} else { //构建顶层机构时建立机构版本副本
			if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
				if ( org.getVersionId() != null 
						&& !org.getVersionId().trim().equals("") ) {
					Version version = versionService.getVersionById(org.getVersionId());
					if ( version != null ) {
						VersionCopy verCp = versionCopyService.getVersionCopyByOrg(org.getOrgId());
						if ( verCp == null 
								|| ( verCp != null && !verCp.getVersionId().trim().equals(version.getId()) ) 
								|| ( verCp != null && verCp.getVersionId().trim().equals(version.getId()) 
								       && ( verCp.getActivatedDate().getTime() != org.getActivatedDate().getTime() 
								             || verCp.getExpiredDate().getTime() != org.getExpiredDate().getTime() ) ) ) {
							versionCopyService.saveVersionCopy(org, version); //新增或更新当前部门版本副本
							
							//批量设置子机构的版本副本
							List<Organization> childOrgList = organizationService.getAllOrganizationsByParentOrg(org.getOrgId());
							if ( childOrgList != null && childOrgList.size() > 0 ) {
								for ( Organization childOrg : childOrgList ) {
									versionCopyService.copyVersionCopy(childOrg, org);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 清理所有机构缓存
	 * */
	public void clearAllCache() {
		try {
			organizationService.clearAllOrganizationCache();
			organizationService.clearAllUserOrganizationCache();
		} catch(Exception ex) { ex.printStackTrace(); }
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
	 * @param org 机构对象
	 * @return 日志类型
	 * */
	private Integer getLogType(Organization org) {
		if ( org != null && org.getOrgId() == null ) return OperationLog.ADD;
		else return OperationLog.MODIFY;
	}
	
	/**
	 * 保存操作日志
	 * @author Oscar Mok
	 * @param org 机构对象
	 * @param logType 日志类型
	 * */
	private void saveOperationLog(Organization org, Integer logType) {
		if ( logType.intValue() == OperationLog.ADD.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_ORG_MGT, 
					                             OperationLog.ADD, "Add organization " + org.getOrgName() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.MODIFY.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_ORG_MGT, 
					                             OperationLog.MODIFY, "Modify organization " + org.getOrgName() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.REMOVE.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_ORG_MGT, 
					                             OperationLog.REMOVE, "Remove organization " + org.getOrgName() + " successfully", 
					                             getCurrentUser());
		}
	}
}