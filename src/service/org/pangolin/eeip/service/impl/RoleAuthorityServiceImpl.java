package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.RoleAuthorityDao;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.RoleAuthority;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.RoleAuthorityService;
import org.springframework.stereotype.Service;

@Service("roleAuthorityService")
@SuppressWarnings("all")
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

	@Resource
	private AuthorityService authorityService;
	
	@Resource
	private RoleAuthorityDao roleAuthorityDao;
	
	public RoleAuthority getRoleAuthorityById(String roleAuthId) {
		return roleAuthorityDao.get(RoleAuthority.class, roleAuthId);
	}
	
	public List<RoleAuthority> getRoleAuthorities() {
		return roleAuthorityDao.find("from RoleAuthority");
	}
	
	public List<RoleAuthority> getRoleAuthoritiesByRole(String roleId) {
		return roleAuthorityDao.find("from RoleAuthority where roleId = ?", new Object[] { roleId });
	}
	
	public void removeRoleAuthority(String roleAuthId) {
		roleAuthorityDao.executeHql("delete from RoleAuthority where roleAuthId = ?", new Object[] { roleAuthId });
	}
	
	public void removeRoleAuthorityByRole(String roleId) {
		roleAuthorityDao.executeHql("delete from RoleAuthority where roleId = ?", new Object[] { roleId });
	}
	
	public void saveRoleAuthority(RoleAuthority roleAuthority) {
		if ( !existRoleAuthority(roleAuthority.getRoleId(), roleAuthority.getAuthorityId()) ) roleAuthorityDao.saveOrUpdate(roleAuthority);
	}
	
	public void saveRoleAuthority(String roleId, String[] authorityIds, String[] parentAuthLabels) {
		removeRoleAuthorityByRole(roleId);
		RoleAuthority roleAuthority = null;
		for ( String authorityId : authorityIds ) {
			roleAuthority = new RoleAuthority();
			roleAuthority.setRoleId(roleId);
			roleAuthority.setAuthorityId(authorityId);
			saveRoleAuthority(roleAuthority);
		}
		
		List<Authority> parentAuthorityList = getParentAuthorities(parentAuthLabels);
		for ( Authority authority : parentAuthorityList ) {
			roleAuthority = new RoleAuthority();
			roleAuthority.setRoleId(roleId);
			roleAuthority.setAuthorityId(authority.getAuthorityId());
			saveRoleAuthority(roleAuthority);
		}
	}
	
	public boolean existRoleAuthority(String roleId, String authorityId) {
		Long qty = roleAuthorityDao.count("select count(roleAuthId) from RoleAuthority where roleId = ? and authorityId = ?", new Object[] { roleId, authorityId });
		if ( qty > 0 ) return true;
		return false;
	}
	
	private List<Authority> getParentAuthorities(String[] parentAuthLabels) {
		List<Authority> authorityList = new ArrayList<Authority>();
		if ( parentAuthLabels != null && parentAuthLabels.length > 0 ) {
			for ( String authorityLabel : parentAuthLabels ) {
				Authority authority = authorityService.getAuthorityByLabel(authorityLabel);
				if ( authority != null ) authorityList.add(authority);
			}
		}
		return authorityList;
	}
}