package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.dao.RoleDao;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.RoleAuthority;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.RoleAuthorityService;
import org.pangolin.eeip.service.RoleResourceService;
import org.pangolin.eeip.service.RoleService;
import org.pangolin.eeip.service.RoleUserService;
import org.pangolin.servlet.InitServletContext;
import org.springframework.stereotype.Service;

@Service("roleService")
@SuppressWarnings("all")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Resource
	private AuthorityService authorityService;
	
	@Resource
	private RoleAuthorityService roleAuthorityService;
	
	@Resource
	private RoleResourceService roleResourceService;
	
	@Resource
	private RoleUserService roleUserService;
	
	public Role getRoleById(String roleId) {
		return roleDao.get(Role.class, roleId);
	}
	
	public Role getRoleByLabel(String roleLabel) {
		Role role = null;
		List<Role> roleList = roleDao.find("from Role where roleLabel = ?", new Object[] { roleLabel });
		if ( roleList != null && roleList.size() > 0 ) role = roleList.get(0);
		return role;
	}
	
	public Long getRoleQty() {
		return roleDao.count("select count(roleId) from Role where deleteFlag = ?", new Object[] { Role.NORMAL });
	}
	
	public Long getRootRoleQty() {
		return roleDao.count("select count(roleId) from Role where orgId is null and deleteFlag = ?", new Object[] { Role.NORMAL });
	}
	
	public Long getRoleQtyByOrg(String orgId) {
		if ( orgId.trim().equals("root") ) {
			return getRootRoleQty();
		} else {
			return roleDao.count("select count(roleId) from Role where orgId=? and deleteFlag = ?", new Object[] { orgId, Role.NORMAL });
		}
	}
	
	public List<Role> getRoles() {
		return roleDao.find("from Role where deleteFlag = ? order by createdDate", new Object[] { Role.NORMAL });
	}
	
	public List<Role> getRolesByIds(String[] roleIds) {//TODO
		String param = "";
		for (int i = 0; i < roleIds.length; i++) {
			param += "'" + roleIds[i] + "'";
			if (i < (roleIds.length - 1)) {
				param += ",";
			}
		}
		if (param != null && param.trim().length() > 0) {
			return roleDao.find("from Role where deleteFlag = 0 and roleId in (" + param + ")");
		} else {
			return new ArrayList<Role>();
		}
	}
	
	public List<Role> getRootRoles() {
		return roleDao.find("from Role where orgId is null and deleteFlag = ? order by createdDate", new Object[] { Role.NORMAL });
	}
	
	public List<Role> getRootRoles(Integer roleStatus) {
		return roleDao.find("from Role where orgId is null and deleteFlag = ? and roleStatus = ? order by createdDate", new Object[] { Role.NORMAL, roleStatus });
	}
	
	public List<Role> getRolesByUser(String userId) {
		Role role = null;
		String roleId = null, roleName = null, roleLabel =null;
		Date createdDate = null, modifiedDate = null;
		List<Role> roleList = new ArrayList<Role>();
		List resultList = roleDao.compSearch("select a.roleId, a.roleName, a.roleLabel, a.createdDate, a.modifiedDate "
				+ "from Role a, RoleUser b where a.roleId = b.roleId and b.userId = ? and a.deleteFlag = ?", new Object[] { userId, Role.NORMAL });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) roleId = (String)objArray[0];
				if (objArray[1] != null) roleName = (String)objArray[1];
				if (objArray[2] != null) roleLabel = (String)objArray[2];
				if (objArray[3] != null) createdDate = (Date)objArray[3];
				if (objArray[4] != null) modifiedDate = (Date)objArray[4];
				
				role = new Role();
				role.setRoleId(roleId);
				role.setRoleName(roleName);
				role.setRoleLabel(roleLabel);
				role.setCreatedDate(createdDate);
				role.setModifiedDate(modifiedDate);
				roleList.add(role);
			}
		}
		return roleList;
	}
	
	public List<Role> getRolesByOrg(String orgId) {
		return roleDao.find("from Role where orgId = ? and deleteFlag = ? order by createdDate", new Object[] { orgId, Role.NORMAL });
	}
	
	public List<Role> getRolesByOrg(String orgId, Integer roleStatus) {
		return roleDao.find("from Role where orgId = ? and deleteFlag = ? and roleStatus = ? order by createdDate", new Object[] { orgId, Role.NORMAL, roleStatus });
	}
	
	public List<Role> getRoles(int startIndex, int rows, String sorter, String sortingAttribute) {
		return roleDao.search("from Role where deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Role.NORMAL }, startIndex, rows);
	}
	
	public List<Role> getRootRoles(int startIndex, int rows, String sorter, String sortingAttribute) {
		return roleDao.search("from Role where orgId is null and deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Role.NORMAL }, startIndex, rows);
	}
	
	public List<Role> getRolesByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute) {
		if ( orgId.trim().equals("root") ) {
			return getRootRoles(startIndex, rows, sorter, sortingAttribute);
		} else {
			return roleDao.search("from Role where orgId = ? and deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { orgId, Role.NORMAL }, startIndex, rows);
		}
	}
	
	public boolean removeRole(String roleId) {
		roleDao.executeHql("delete from Role where roleId = ?", new Object[] { roleId });
		roleAuthorityService.removeRoleAuthorityByRole(roleId); //remove relationship of roles and authorities
		roleResourceService.removeRoleResourceByRole(roleId); //remove relationship of roles and resources
		roleUserService.removeRoleUserByRole(roleId); //remove relationship of roles and users
		Long qty = roleDao.count("select count(roleId) from Role where roleId = ?" , new Object[] { roleId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean setRoleDelFlag(String roleId, Integer deleteFlag) {
		Integer status = roleDao.executeHql("update Role set deleteFlag = ? where roleId = ?", new Object[] { deleteFlag, roleId });
		if ( status.intValue() == 1 ) return true;
		return false;
	}
	
	public boolean removeRole(String[] roleIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String roleId : roleIds) {
			roleDao.executeHql("delete from Role where roleId = ?", new Object[] { roleId });
			roleAuthorityService.removeRoleAuthorityByRole(roleId); //remove relationship of roles and authorities
			roleResourceService.removeRoleResourceByRole(roleId); //remove relationship of roles and resources
			roleUserService.removeRoleUserByRole(roleId); //remove relationship of roles and users
			qty = roleDao.count("select count(roleId) from Role where roleId = ?" , new Object[] { roleId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == roleIds.length ) return true;
		return false;
	}
	
	public boolean saveRole(Role role) {
		String method = "";
		if ( role.getRoleId() == null ) { method = "add"; }
		else { method = "update"; role.setModifiedDate(new Date()); }
		roleDao.saveOrUpdate(role);
		if ( method.equals("add") ) {
			if ( role.getRoleId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean existRole(String roleLabel, Organization org) {
		if ( org != null ) {
			Long qty = roleDao.count("select count(roleId) from Role where roleLabel = ? and orgId = ?", new Object[] { roleLabel, org.getOrgId() });
			if ( qty.intValue() > 0 ) return true;
		} else {
			Long qty = roleDao.count("select count(roleId) from Role where roleLabel = ?", new Object[] { roleLabel });
			if ( qty.intValue() > 0 ) return true;
		}
		return false;
	}
	
	public Role copyRole(Role copiedRole, Organization org) {
		if ( copiedRole != null && org != null ) {
			Role newRole = new Role();
			newRole.setRoleName(copiedRole.getRoleName());
			newRole.setRoleLabel( ( ( org.getOrgSN() != null && !org.getOrgSN().trim().equals("") ) ? org.getOrgSN() + "_" : "" ) + copiedRole.getRoleLabel());
			newRole.setRoleDesc(copiedRole.getRoleDesc());
			newRole.setOrgId(org.getOrgId());
			newRole.setOrgName(org.getOrgName());
			if ( !existRole(newRole.getRoleLabel(), org) ) saveRole(newRole); //save new role
			if ( newRole.getRoleId() != null ) {
				copyAuthorities(copiedRole, newRole);
				return newRole;
			}
		}
		return null;
	}
	
	public String getOrgAdminRoleLabel(Organization org) {
		if ( org != null ) {
			String orgAdminRoleLabel = ( ( org.getOrgSN() != null && !org.getOrgSN().trim().equals("") ) ? org.getOrgSN() + "_" : "" )  +Const.SECONDARY_ADMINISTRATOR_ROLE;
			return orgAdminRoleLabel;
		}
		return "";
	}
	
	//TODO
	public void reloadRoleAuthorities() {
		List<Authority> authorityList = null;
		List<Role> roleList = getRoles();
		if ( roleList != null && roleList.size() > 0 ) {
			for ( Role role : roleList ) {
				authorityList = authorityService.getAuthoritiesByRole(role.getRoleId());
				if ( authorityList != null && authorityList.size() > 0 ) {
					Const.ROLE_AUTH_MAP.put(role.getRoleLabel(), authorityList);
				}
			}
		}
	}

	//TODO
	public void reloadRoleAuthorities(Role role) {
		List<Authority> authorityList = authorityService.getAuthoritiesByRole(role.getRoleId());
		if ( authorityList != null && authorityList.size() > 0 ) {
			Const.ROLE_AUTH_MAP.put(role.getRoleLabel(), authorityList);
		}
	}
	
	//TODO
	public void reloadRoleNames() {
		List<Role> roleList = getRoles();
		if ( roleList != null && roleList.size() > 0 ) {
			for ( Role role : roleList ) {
				Const.ROLE_NAME_MAP.put(role.getRoleLabel(), role.getRoleName());
			}
			InitServletContext.SERVLET_CONTEXT.setAttribute("ROLE_NAME", Const.ROLE_NAME_MAP);
		}
	}
	
	//TODO
	public void reloadRoleName(Role role) {
		Const.ROLE_NAME_MAP.put(role.getRoleLabel(), role.getRoleName());
		InitServletContext.SERVLET_CONTEXT.setAttribute("ROLE_NAME", Const.ROLE_NAME_MAP);
	}
	
	/**
	 * 复制角色权限
	 * @param copiedRole 被复制角色
	 * @param newRole 新角色
	 * */
	private void copyAuthorities(Role copiedRole, Role newRole) {
		RoleAuthority roleAuthority = null;
		List<RoleAuthority> roleAuthList = 
				roleAuthorityService.getRoleAuthoritiesByRole(copiedRole.getRoleId());
		if ( roleAuthList != null && roleAuthList.size() > 0 ) {
			for ( RoleAuthority roleAuth : roleAuthList ) {
				roleAuthority = new RoleAuthority();
				roleAuthority.setRoleId(newRole.getRoleId());
				roleAuthority.setAuthorityId(roleAuth.getAuthorityId());
				roleAuthorityService.saveRoleAuthority(roleAuthority);
			}
		}
	}
}