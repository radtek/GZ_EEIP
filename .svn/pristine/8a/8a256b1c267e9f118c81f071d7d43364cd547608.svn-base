package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.RoleResourceDao;
import org.pangolin.eeip.entity.RoleAuthority;
import org.pangolin.eeip.entity.RoleResource;
import org.pangolin.eeip.service.RoleResourceService;
import org.springframework.stereotype.Service;

@Service("roleResourceService")
@SuppressWarnings("all")
public class RoleResourceServiceImpl implements RoleResourceService {

	@Resource
	private RoleResourceDao roleResourceDao;
	
	public RoleResource getRoleResourceById(String roleResourceId) {
		return roleResourceDao.get(RoleResource.class, roleResourceId);
	}
	
	public List<RoleResource> getRoleResources() {
		return roleResourceDao.find("from RoleResource");
	}
	
	public List<RoleResource> getRoleResourcesByRole(String roleId) {
		return roleResourceDao.find("from RoleResource where roleId = ?", new Object[] { roleId });
	}
	
	public void removeRoleResource(String roleResourceId) {
		roleResourceDao.executeHql("delete from RoleResource where roleResourceId = ?", new Object[] { roleResourceId });
	}
	
	public void removeRoleResourceByRole(String roleId) {
		roleResourceDao.executeHql("delete from RoleResource where roleId = ?", new Object[] { roleId });
	}
	
	public void saveRoleResource(RoleResource roleResource) {
		roleResourceDao.saveOrUpdate(roleResource);
	}
	
	public void saveRoleResource(String roleId, String[] resourceIds) {
		removeRoleResourceByRole(roleId);
		RoleResource roleResource = null;
		for ( String resourceId : resourceIds ) {
			roleResource = new RoleResource();
			roleResource.setRoleId(roleId);
			roleResource.setResourceId(resourceId);
			saveRoleResource(roleResource);
		}
	}
	
	public boolean existRoleResource(String roleId, String resourceId) {
		List<RoleResource> roleResourceList = roleResourceDao.find("from RoleResource where roleId = ? and resourceId = ?", new Object[] { roleId, resourceId });
		if ( roleResourceList != null && roleResourceList.size() > 0 ) return true;
		return false;
	}
	
}