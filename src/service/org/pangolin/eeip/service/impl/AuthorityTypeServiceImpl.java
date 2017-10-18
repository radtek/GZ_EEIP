package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AuthorityTypeDao;
import org.pangolin.eeip.entity.AuthorityType;
import org.pangolin.eeip.service.AuthorityTypeService;
import org.springframework.stereotype.Service;

@Service("authorityTypeService")
@SuppressWarnings("all")
public class AuthorityTypeServiceImpl implements AuthorityTypeService {

	@Resource
	private AuthorityTypeDao authorityTypeDao;
	
	public AuthorityType getAuthorityTypeById(String authorityTypeId) {
		return authorityTypeDao.get(AuthorityType.class, authorityTypeId);
	}
	
	public AuthorityType getAuthorityTypeByLabel(String authorityTypeLabel) {
		AuthorityType authorityType = null;
		List<AuthorityType> authTypeList = authorityTypeDao.find("from AuthorityType where authorityTypeLabel = ?", new Object[] { authorityTypeLabel });
		if ( authTypeList != null && authTypeList.size() > 0 ) authorityType = authTypeList.get(0);
		return authorityType;
	}
	
	public List<AuthorityType> getAuthorityTypies() {
		return authorityTypeDao.find("from AuthorityType order by createdDate desc");
	}
	
	public List<AuthorityType> getRootAuthorityTypies() {
		return authorityTypeDao.find("from AuthorityType where parentAuthorityTypeId is null order by createdDate desc");
	}
	
	public List<AuthorityType> getAuthorityTypiesByParentAuthorityType(String parentAuthorityTypeId) {
		return authorityTypeDao.find("from AuthorityType where parentAuthorityTypeId=? order by createdDate desc", new Object[] { parentAuthorityTypeId });
	}
	
	public boolean existAuthorityType(String authorityTypeLabel) {
		if ( getAuthorityTypeByLabel(authorityTypeLabel) != null ) return true;
		return false;
	}
	
	public void saveAuthorityType(AuthorityType authorityType) {
		if ( !existAuthorityType(authorityType.getAuthorityTypeLabel()) ) authorityTypeDao.saveOrUpdate(authorityType);
	}
	
}