package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.dao.OrganizationDao;
import org.pangolin.eeip.dto.OrgDto;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.service.OrganizationService;
import org.pangolin.eeip.service.UserOrganizationService;
import org.pangolin.eeip.service.UserService;
import org.springframework.stereotype.Service;

@Service("organizationService")
@SuppressWarnings("all")
public class OrganizationServiceImpl implements OrganizationService {

	@Resource
	private OrganizationDao organizationDao;
	
	@Resource
	private UserService userService;
	
	@Resource
	private UserOrganizationService userOrgService;
	
	public Organization getOrganizationById(String orgId) {
		return organizationDao.get(Organization.class, orgId);
	}
	
	public Organization getRootOrganization(String orgId) {
		Organization org = null;
		if ( orgId != null && !orgId.trim().equals("") ) {
			while(true) {
				org = getOrganizationById(orgId);
				if ( org != null ) {
					if ( org.getParentOrgId() != null 
							&& !org.getParentOrgId().trim().equals("") ) {
						orgId = org.getParentOrgId();
					} else break;
				} else break;
			}
		}
		return org;
	}
	
	public Long getOrganizationQty() {
		return organizationDao.count("select count(orgId) from Organization where deleteFlag = ?", new Object[] { Organization.NORMAL });
	}
	
	public Long getOrganizationQtyByParentOrg(String parentOrgId) {
		return organizationDao.count("select count(orgId) from Organization where parentOrgId = ? and deleteFlag = ?", new Object[] { parentOrgId, Organization.NORMAL });
	}
	
	public List<Organization> getOrganizations() {
		List<Organization> generalOrgList = new ArrayList<Organization>();
		List<Organization> rootOrgList = getRootOrganizations();
		List<Organization> childOrgList = null;
		for ( Organization rootOrg : rootOrgList ) {
			generalOrgList.add(rootOrg);
			childOrgList = getChildOrganizationsByCurrentOrg(rootOrg.getOrgId());
			for ( Organization childOrg : childOrgList ) generalOrgList.add(childOrg);
		}
		return generalOrgList;
		//return organizationDao.find("from Organization where deleteFlag = ? order by createdDate desc", new Object[] { Organization.NORMAL });
	}
	
	public List<Organization> getRootOrganizations() {
		return organizationDao.find("from Organization where parentOrgId is null and deleteFlag = ? order by createdDate desc", new Object[] { Organization.NORMAL });
	}
	
	public List<Organization> getOrganizationsByUser(String userId) {
		Organization org = null;
		String orgId = null, orgName = null, orgShortName = null, orgSN =null, versionId = null, parentOrgId = null;
		Date createdDate = null, modifiedDate = null;
		Integer orgType = null, orgLevel = null, orgSort = null, orgStatus = null, deleteFlag = null;
		List<Organization> orgList = new ArrayList<Organization>();
		List resultList = organizationDao.compSearch("select a.orgId, a.orgName, a.orgShortName, a.orgSN, a.createdDate, a.modifiedDate, "
				+ "a.orgSort, a.orgStatus, a.versionId, a.orgType, a.orgLevel, a.parentOrgId, a.deleteFlag "
				+ "from Organization a, UserOrganization b where a.orgId = b.orgId and b.userId = ?", new Object[] { userId });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) orgId = (String)objArray[0];
				if (objArray[1] != null) orgName = (String)objArray[1];
				if (objArray[2] != null) orgShortName = (String)objArray[2];
				if (objArray[3] != null) orgSN = (String)objArray[3];
				if (objArray[4] != null) createdDate = (Date)objArray[4];
				if (objArray[5] != null) modifiedDate = (Date)objArray[5];
				if (objArray[6] != null) orgSort = (Integer)objArray[6];
				if (objArray[7] != null) orgStatus = (Integer)objArray[7];
				if (objArray[8] != null) versionId = (String)objArray[8];
				if (objArray[9] != null) orgType = (Integer)objArray[9];
				if (objArray[10] != null) orgLevel = (Integer)objArray[10];
				if (objArray[11] != null) parentOrgId = (String)objArray[11];
				if (objArray[12] != null) deleteFlag = (Integer)objArray[12];
				
				org = new Organization();
				org.setOrgId(orgId);
				org.setOrgName(orgName);
				org.setOrgShortName(orgShortName);
				org.setOrgSN(orgSN);
				org.setCreatedDate(createdDate);
				org.setModifiedDate(modifiedDate);
				org.setOrgSort(orgSort);
				org.setOrgStatus(orgStatus);
				org.setOrgType(orgType);
				org.setOrgLevel(orgLevel);
				org.setDeleteFlag(deleteFlag);
				org.setParentOrgId(parentOrgId);
				org.setVersionId(versionId);
				orgList.add(org);
			}
		}
		return orgList;
	}
	
	public List<Organization> getOrganizationsByParentOrg(String parentOrgId) {
		return organizationDao.find("from Organization where parentOrgId = ? and deleteFlag = ? order by createdDate desc", new Object[] { parentOrgId, Organization.NORMAL });
	}
	
	public List<Organization> getAllOrganizationsByParentOrg(String parentOrgId) {
		List<Organization> orgList = new ArrayList<Organization>();
		List<Organization> childOrgList = getOrganizationsByParentOrg(parentOrgId);
		if ( childOrgList != null && childOrgList.size() > 0 ) {
			for ( Organization childOrg : childOrgList ) {
				orgList.add(childOrg);
				getOrganizationsByParentOrg4Recursion(orgList, childOrg.getOrgId());
			}
		}
		return orgList;
	}
	
	public List<Organization> getParentOrganizationsByCurrentOrg(String orgId) {
		List<Organization> orgList = new ArrayList<Organization>();
		Organization currentOrg = getOrganizationById(orgId);
		if ( currentOrg != null ) {
			String parentOrgId = currentOrg.getParentOrgId();
			while(true) {
				if ( parentOrgId != null && !parentOrgId.trim().equals("") ) {
					Organization parentOrg = getOrganizationById(parentOrgId);
					if ( parentOrg != null ) {
						parentOrgId = parentOrg.getParentOrgId();
						orgList.add(parentOrg);
					} else break;
				} else  break;
			}
		}
		return orgList;
	}
	
	public List<Organization> getChildOrganizationsByCurrentOrg(String orgId) {
		List<Organization> orgList = new ArrayList<Organization>();
		List<Organization> childOrgList = getOrganizationsByParentOrg(orgId);
		for ( Organization childOrg : childOrgList ) {
			orgList.add(childOrg);
			addChildOrg4BG(childOrg, orgList);
		}
		return orgList;
	}
	
	public List<Organization> getOrganizations(int startIndex, int rows, String sorter, String sortingAttribute) {
		return organizationDao.search("from Organization where deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Organization.NORMAL }, startIndex, rows);
	}
	
	public List<Organization> getRootOrganizations(int startIndex, int rows, String sorter, String sortingAttribute) {
		return organizationDao.search("from Organization where parentOrgId is null and deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Organization.NORMAL }, startIndex, rows);
	}
	
	public List<Organization> getOrganizationsByParentOrg(String parentOrgId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return organizationDao.search("from Organization where parentOrgId = ? and deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { parentOrgId, Organization.NORMAL }, startIndex, rows);
	}
	
	public boolean removeOrganization(String orgId) {
		if ( !existUserInOrg(orgId) ) {
			//删除所有子组织
			List<Organization> childOrgList = new ArrayList<Organization>();
			getChildOrgs(orgId, childOrgList);
			for ( Organization childOrg : childOrgList ) {
				organizationDao.executeHql("delete from Organization where orgId = ?", new Object[] { childOrg.getOrgId() });
				userOrgService.removeUserOrganizationByOrg(childOrg.getOrgId());
			}
			
			organizationDao.executeHql("delete from Organization where orgId = ?", new Object[] { orgId });
			userOrgService.removeUserOrganizationByOrg(orgId);
			Long qty = organizationDao.count("select count(orgId) from Organization where orgId = ?" , new Object[] { orgId });
			if ( qty.intValue() == 0 ) return true;
		}
		return false;
	}
	
	public boolean setOrganizationDelFlag(String orgId, Integer deleteFlag) {
		if ( !existUserInOrg(orgId) ) {
			Integer status = organizationDao.executeHql("update Organization set deleteFlag = ? where orgId = ?", new Object[] { deleteFlag, orgId });
			if ( status.intValue() == 1 ) return true;
		}
		return false;
	}
	
	public boolean removeOrganization(String[] orgIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		List<String> filteredOrgIdList = new ArrayList<String>();
		
		for (String orgId : orgIds) {
			if ( !existUserInOrg(orgId) ) filteredOrgIdList.add(orgId);
		}
		
		for (String orgId : filteredOrgIdList) {
			organizationDao.executeHql("delete from Organization where orgId = ?", new Object[] { orgId });
			userOrgService.removeUserOrganizationByOrg(orgId); //移除用户与组织关系
			qty = organizationDao.count("select count(orgId) from Organization where orgId = ?" , new Object[] { orgId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == filteredOrgIdList.size() ) return true;
		return false;
	}
	
	public boolean saveOrganization(Organization organization) {
		String method = "";
		if ( organization.getOrgId() == null ) { 
			method = "add";
			organization.setOrgSort(getMaxOrgSort(organization.getParentOrgId())); //组织排序号
		}
		else { 
			method = "update";
			organization.setModifiedDate(new Date());
			
			//机构的父级机构不允许为自身
			if ( organization.getParentOrgId() != null 
					&& organization.getParentOrgId().trim().equals(organization.getOrgId().trim()) ) {
				return false;
			}
		}
		
		if ( organization.getParentOrgId() == null 
				|| organization.getParentOrgId().trim().equals("") ) 
			organization.setParentOrgId(null);
		
		organization.setOrgLevel(getCurrentOrgLevel(organization)); //设置机构层级
		
		organizationDao.saveOrUpdate(organization);
		if ( method.equals("add") ) {
			if ( organization.getOrgId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public List<OrgDto> getAllOrganizationTreeGridData() {
		List<OrgDto> orgList = new ArrayList<OrgDto>();
		try {
			List<Organization> rootOrgList = getRootOrganizations();
			if ( rootOrgList != null && rootOrgList.size() > 0 ) {
				for ( Organization org : rootOrgList ) {
					orgList.add(new OrgDto(org.getOrgId(), org.getOrgName(), org.getOrgShortName(), org.getOrgSN(), org.getOrgStatus(), org.getOrgType(),org.getCreatedDate(), org.getModifiedDate(), org.getOrgDesc(), "treegrid-" + org.getOrgId()));
					addChildOrg(org, orgList);
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return orgList;
	}
	
	public List<OrgDto> getChildOrganizationTreeGridData(String parentOrgId) {
		List<OrgDto> orgList = new ArrayList<OrgDto>();
		try {
			Organization parentOrg = getOrganizationById(parentOrgId);
			if ( parentOrg != null ) {
				orgList.add(new OrgDto(parentOrg.getOrgId(), parentOrg.getOrgName(), parentOrg.getOrgShortName(), parentOrg.getOrgSN(), parentOrg.getOrgStatus(), parentOrg.getOrgType(), parentOrg.getCreatedDate(), parentOrg.getModifiedDate(), "", "treegrid-" + parentOrg.getOrgId()));
			}
			List<Organization> rootOrgList = getOrganizationsByParentOrg(parentOrgId);
			if ( rootOrgList != null && rootOrgList.size() > 0 ) {
				for ( Organization org : rootOrgList ) {
					orgList.add(new OrgDto(org.getOrgId(), org.getOrgName(), org.getOrgShortName(), org.getOrgSN(), org.getOrgStatus(), org.getOrgType(), org.getCreatedDate(), org.getModifiedDate(), org.getOrgDesc(), "treegrid-" + org.getOrgId() + " treegrid-parent-" + parentOrg.getOrgId()));
					addChildOrg(org, orgList);
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return orgList;
	}
	
	public void clearAllOrganizationCache() {  }
	
	public List<OrgDto> getAllUserOrganizationTreeGridData() {
		List<OrgDto> orgList = new ArrayList<OrgDto>();
		try {
			//orgList.add(new OrgDto("root", Const.SERVICE_PROVIDER_NAME, Const.SERVICE_PROVIDER_NAME, "ROOT", Organization.ENABLE, Organization.ORGANIZATION, new Date(), new Date(), "", "treegrid-root"));
			List<Organization> rootOrgList = getRootOrganizations();
			if ( rootOrgList != null && rootOrgList.size() > 0 ) {
				for ( Organization org : rootOrgList ) {
					orgList.add(new OrgDto(org.getOrgId(), org.getOrgName(), org.getOrgShortName(), org.getOrgSN(), org.getOrgStatus(), org.getOrgType(), org.getCreatedDate(), org.getModifiedDate(), org.getOrgDesc(), "treegrid-" + org.getOrgId() + " treegrid-parent-root"));
					addChildOrg(org, orgList);
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return orgList;
	}
	
	public void clearAllUserOrganizationCache() {  }
	
	/**
	 * 获取组织排序号
	 * @author Oscar Mok
	 * @return 组织排序号
	 * */
	private Integer getMaxOrgSort(String parentOrgId) {
		if ( parentOrgId != null && !parentOrgId.trim().equals("") ) {
			List<Organization> orgList = organizationDao.find("from Organization where parentOrgId = ? order by orgSort desc", new Object[] { parentOrgId });
			if ( orgList != null && orgList.size() > 0 ) {
				if ( orgList.get(0).getOrgSort() != null ) {
					return orgList.get(0).getOrgSort() + 1;
				}
			} else {
				return 1;
			}
		} else {
			List<Organization> orgList = organizationDao.find("from Organization where parentOrgId is null order by orgSort desc");
			if ( orgList != null && orgList.size() > 0 ) {
				if ( orgList.get(0).getOrgSort() != null ) {
					return orgList.get(0).getOrgSort() + 1;
				}
			} else {
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * 根据上级组织递归获取所有子组织
	 * @author Oscar Mok
	 * @param orgId
	 * @param childOrgList
	 * @return 子组织列表
	 * */
	private void getChildOrgs(String orgId, List<Organization> childOrgList) {
		if ( orgId != null && !orgId.trim().equals("") ) {
			List<Organization> orgList = getOrganizationsByParentOrg(orgId);
			for ( Organization org : orgList ) {
				childOrgList.add(org);
				getChildOrgs(org.getOrgId(), childOrgList);
			}
		}
	}
	
	/**
	 * 递归加入子部门（TreeGrid专用 ）
	 * @author Oscar Mok
	 * @param org 上级部门对象
	 * @param orgList 部门列表
	 * */
	private void addChildOrg(Organization org, List<OrgDto> orgList) {
		List<Organization> childOrgList = getOrganizationsByParentOrg(org.getOrgId());
		for ( Organization childOrg : childOrgList ) {
			orgList.add(new OrgDto(childOrg.getOrgId(), 
					childOrg.getOrgName(), 
					childOrg.getOrgShortName(), 
					childOrg.getOrgSN(), 
					childOrg.getOrgStatus(),
					childOrg.getOrgType(),
					childOrg.getCreatedDate(), 
					childOrg.getModifiedDate(), 
					childOrg.getOrgDesc(), "treegrid-"+childOrg.getOrgId()+" treegrid-parent-"+org.getOrgId()));
			addChildOrg(childOrg, orgList);
		}
	}
	
	/**
	 * 递归加入子部门（后台数据方法专用 ）
	 * @author Oscar Mok
	 * @param org 上级部门对象
	 * @param orgList 部门列表
	 * */
	private void addChildOrg4BG(Organization org, List<Organization> orgList) {
		List<Organization> childOrgList = getOrganizationsByParentOrg(org.getOrgId());
		for ( Organization childOrg : childOrgList ) {
			orgList.add(childOrg);
			addChildOrg4BG(childOrg, orgList);
		}
	}
	
	/**
	 * 递归加入子机构
	 * @author Oscar Mok
	 * @param orgList 机构列表
	 * @param parentOrgId 父级机构ID
	 * */
	private void getOrganizationsByParentOrg4Recursion(List<Organization> orgList, String parentOrgId) {
		if ( orgList != null 
				&& parentOrgId != null && !parentOrgId.trim().equals("") ) {
			List<Organization> childOrgList = getOrganizationsByParentOrg(parentOrgId);
			if ( childOrgList != null && childOrgList.size() > 0 ) {
				for ( Organization childOrg : childOrgList ) {
					orgList.add(childOrg);
					getOrganizationsByParentOrg4Recursion(orgList, childOrg.getOrgId());
				}
			}
		}
	}
	
	/**
	 * 指定机构下是否存在用户
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 存在情况
	 * */
	private boolean existUserInOrg(String orgId) {
		Long qty = userService.getUserQtyByOrg(orgId);
		if ( qty > 0 ) return true;
		return false;
	}
	
	/**
	 * 获取当前机构级别（新增或更新时使用）
	 * @author Oscar Mok
	 * @param org 部门对象
	 * */
	private Integer getCurrentOrgLevel(Organization org) {
		if ( org != null ) {
			if ( org.getParentOrgId() != null 
					&& !org.getParentOrgId().trim().equals("") ) {
				Organization parentOrg = getOrganizationById(org.getParentOrgId());
				if ( parentOrg != null ) {
					return (parentOrg.getOrgLevel() + 1);
				}
			}
		}
		return new Integer(0);
	}
}