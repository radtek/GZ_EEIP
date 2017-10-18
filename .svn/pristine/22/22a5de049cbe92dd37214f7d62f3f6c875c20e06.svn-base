package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserOrganization;

public interface UserOrganizationService {
	
	public UserOrganization getUserOrganizationById(String userOrgId);
	
	public Long getUserOrganizationQtyByOrg(String orgId);
	
	public List<UserOrganization> getUserOrganizations();
	
	public List<UserOrganization> getUserOrganizationsByUser(String userId);
	
	public List<UserOrganization> getUserOrganizationsByOrg(String orgId);
	
	public List<UserOrganization> getUserOrganizationsByUser(String userId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<UserOrganization> getUserOrganizationsByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public void removeUserOrganizationByUser(String userId);
	
	public void removeUserOrganizationByOrg(String orgId);
	
	public void saveUserOrganization(UserOrganization userOrganization);
	
}