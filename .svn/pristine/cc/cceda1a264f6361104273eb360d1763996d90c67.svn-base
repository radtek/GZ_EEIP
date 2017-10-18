package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.dao.AuthorityDao;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.RoleAuthority;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.RoleAuthorityService;
import org.springframework.stereotype.Service;

@Service("authorityService")
@SuppressWarnings("all")
public class AuthorityServiceImpl implements AuthorityService {

	@Resource
	private AuthorityDao authorityDao;
	
	@Resource
	private RoleAuthorityService roleAuthorityService;
	
	public Authority getAuthorityById(String authorityId) {
		return authorityDao.get(Authority.class, authorityId);
	}
	
	public Authority getAuthorityByLabel(String authorityLabel) {
		Authority authority = null;
		List<Authority> authorityList = authorityDao.find("from Authority where authorityLabel = ?", new Object[] { authorityLabel });
		if ( authorityList != null && authorityList.size() > 0 ) authority = authorityList.get(0);
		return authority;
	}
	
	public List<Authority> getAuthorities() {
		return authorityDao.find("from Authority order by authorityLabel");
	}
	
	public List<Authority> getRootAuthorities() {
		return authorityDao.find("from Authority where parentAuthorityLabel is null order by authorityLabel");
	}
	
	public List<Authority> getAuthoritiesByRole(String roleId) {
		Authority authority = null;
		List<Authority> authorityList  = new ArrayList<Authority>();
		List<RoleAuthority> roleAuthorityList = roleAuthorityService.getRoleAuthoritiesByRole(roleId);
		if ( roleAuthorityList != null && roleAuthorityList.size() > 0 ) {
			for ( RoleAuthority roleAuthority : roleAuthorityList ) {
				authority = getAuthorityById(roleAuthority.getAuthorityId());
				authorityList.add(authority);
			}
		}
		return authorityList;
	}
	
	public List<Authority> getAuthoritiesByType(String authorityTypeId) {
		return authorityDao.find("from Authority where authorityTypeId=? order by createdDate desc", new Object[] { authorityTypeId });
	}
	
	public boolean removeAuthority(String authorityId) {
		authorityDao.executeHql("delete from Authority where authorityId = ?", new Object[] { authorityId });
		Long qty = authorityDao.count("select count(authorityId) from Authority where authorityId = ?" , new Object[] { authorityId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeAuthority(String[] authorityIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String authorityId : authorityIds) {
			authorityDao.executeHql("delete from Authority where authorityId = ?", new Object[] { authorityId });
			qty = authorityDao.count("select count(authorityId) from Authority where authorityId=?" , new Object[] { authorityId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == authorityIds.length ) return true;
		return false;
	}
	
	public boolean saveAuthority(Authority authority) {
		String method = "";
		Date originalModifiedDate = authority.getModifiedDate();
		if ( authority.getAuthorityId() == null ) { method = "add"; }
		else { method = "update"; }
		authorityDao.saveOrUpdate(authority);
		if ( method.equals("add") ) {
			if ( authority.getAuthorityId() != null ) return true;
		} else { 
			if ( originalModifiedDate == null ) {
				if ( authority.getModifiedDate() != null ) return true;
			} else {
				if ( authority.getModifiedDate() != null 
						&& authority.getModifiedDate().getTime() > originalModifiedDate.getTime() ) return true;
			}
		}
		return false;
	}
	
	public boolean existAuthority(String authorityLabel) {
		Long qty = authorityDao.count("select count(authorityId) from Authority where authorityLabel = ?", new Object[] { authorityLabel });
		if ( qty > 0 ) return true;
		return false;
	}

	@Override
	public List<Authority> getCurrentAuthority(String username) {  
		List<Authority> userAuthorities = new ArrayList<Authority>(); //用户所有权限 
		List<Role> roleList = Const.USER_ROLE_MAP.get(username); //根据当前帐户获取角色列表
		if ( roleList != null ) {
			for ( Role role : roleList ) {
				List<Authority> authList = Const.ROLE_AUTH_MAP.get(role.getRoleLabel());
				if ( authList != null ) {
					for ( Authority authority : authList ) userAuthorities.add(authority); //加入用户所在角色的权限
				}
			}
		}
 		return userAuthorities;
	}
}