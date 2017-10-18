package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserOrganizationDao;
import org.pangolin.eeip.entity.UserOrganization;
import org.pangolin.eeip.service.UserOrganizationService;
import org.springframework.stereotype.Service;

@Service("userOrgService")
@SuppressWarnings("all")
public class UserOrganizationServiceImpl implements UserOrganizationService {

	@Resource
	private UserOrganizationDao userOrganizationDao;
	
	public UserOrganization getUserOrganizationById(String userOrgId) {
		return userOrganizationDao.get(UserOrganization.class, userOrgId);
	}
	
	public Long getUserOrganizationQtyByOrg(String orgId) {
		if ( orgId != null ) {
			if ( orgId.trim().equals("root") ) {
				return userOrganizationDao.countBySQL("select count(a.pk_user_id) from t_user a left join t_user_org b on a.pk_user_id = b.fk_user_id where fk_org_id is null");
			} else {
				return userOrganizationDao.count("select count(userOrgId) from UserOrganization where orgId = ?", new Object[] { orgId });
			}
		}
		return new Long(0);
	}
	
	public List<UserOrganization> getUserOrganizations() {
		return userOrganizationDao.find("from UserOrganization");
	}
	
	public List<UserOrganization> getUserOrganizationsByUser(String userId) {
		return userOrganizationDao.find("from UserOrganization where userId = ?", new Object[] { userId });
	}
	
	public List<UserOrganization> getUserOrganizationsByOrg(String orgId) {
		return userOrganizationDao.find("from UserOrganization where orgId = ?", new Object[] { orgId });
	}
	
	public List<UserOrganization> getUserOrganizationsByUser(String userId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return userOrganizationDao.search("from UserOrganization where userId = ? order by " + sorter + " " + sortingAttribute, new Object[] { userId }, startIndex, rows);
	}
	
	public List<UserOrganization> getUserOrganizationsByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return userOrganizationDao.search("from UserOrganization where orgId = ? order by " + sorter + " " + sortingAttribute, new Object[] { orgId }, startIndex, rows);
	}
	
	public void removeUserOrganizationByUser(String userId) {
		userOrganizationDao.executeHql("delete from UserOrganization where userId = ?", new Object[] { userId });
	}
	
	public void removeUserOrganizationByOrg(String orgId) {
		userOrganizationDao.executeHql("delete from UserOrganization where orgId = ?", new Object[] { orgId });
	}
	
	public void saveUserOrganization(UserOrganization userOrganization) {
		userOrganizationDao.saveOrUpdate(userOrganization);
	}
}