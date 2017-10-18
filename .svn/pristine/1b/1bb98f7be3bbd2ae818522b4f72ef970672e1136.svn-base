package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.pangolin.eeip.dao.ResourceDao;
import org.pangolin.eeip.entity.Resource;
import org.pangolin.eeip.entity.RoleResource;
import org.pangolin.eeip.service.ResourceService;
import org.pangolin.eeip.service.RoleResourceService;
import org.springframework.stereotype.Service;

@Service("resourceService")
@SuppressWarnings("all")
public class ResourceServiceImpl implements ResourceService {

	@javax.annotation.Resource
	private ResourceDao resourceDao;
	
	@javax.annotation.Resource
	private RoleResourceService roleResourceService;
	
	public Resource getResourceById(String resourceId) {
		return resourceDao.get(Resource.class, resourceId);
	}
	
	public Resource getResourceByLabel(String resourceLabel) {
		Resource resource = null;
		List<Resource> resourceList = resourceDao.find("from Resource where resourceLabel = ?", new Object[] { resourceLabel });
		if ( resourceList != null && resourceList.size() > 0 ) resource = resourceList.get(0);
		return resource;
	}
	
	public Long getResourceQty() {
		return resourceDao.count("select count(resourceId) from Resource");
	}
	
	public Long getSurplusResourceQty(String roleId) {
		Long sum = getResourceQty();
		Long distributedQty = getResourceQtyByRole(roleId);
		Long surplusQty = new Long( sum.intValue() - distributedQty.intValue() );
		return surplusQty;
	}
	
	public Long getResourceQtyByRole(String roleId) {
		return resourceDao.count("select count(roleResourceId) from RoleResource where roleId = ?", new Object[] { roleId });
	}
	
	public List<Resource> getResources() {
		return resourceDao.find("from Resource order by createdDate desc");
	}
	
	public List<Resource> getResourcesByRole(String roleId) {
		Resource resource = null;
		List<Resource> resourceList = new ArrayList<Resource>();
		List<RoleResource> roleResourceList = roleResourceService.getRoleResourcesByRole(roleId);
		if ( roleResourceList != null && roleResourceList.size() > 0 ) {
			for ( RoleResource roleResource : roleResourceList ) {
				resource = getResourceById(roleResource.getResourceId());
				resourceList.add(resource);
			}
		}
		return resourceList;
	}
	
	public List<Resource> getResources(int startIndex, int rows, String sorter, String sortingAttribute) {
		return resourceDao.search("from Resource order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<Resource> getSurplusResources(String roleId, int startIndex, int rows, String sorter, String sortingAttribute) {
		Long qty = getResourceQtyByRole(roleId);
		if ( qty.intValue() > 0 ) {
			String resourceId = null, resourceName = null, resourceLabel = null, resourceLocation = null;
			Resource resource = null;
			List<Resource> resourceList = new ArrayList<Resource>();
			String hql = "select a.resourceId, a.resourceName, a.resourceLabel, a.resourceLocation "
					+ "from Resource a where a.resourceId not in ( select b.resourceId from RoleResource b where b.roleId = ? ) order by a." + sorter + " " + sortingAttribute;
			List resultList = resourceDao.compSearch(hql, new Object[] { roleId }, startIndex, rows);
			if ( resultList != null && resultList.size() > 0 ) {
				for ( int i = 0; i < resultList.size(); i++ ) {
					Object[] objArray = (Object[])resultList.get(i);
					
					if (objArray[0] != null) resourceId = (String)objArray[0];
					if (objArray[1] != null) resourceName = (String)objArray[1];
					if (objArray[2] != null) resourceLabel = (String)objArray[2];
					if (objArray[3] != null) resourceLocation = (String)objArray[3];
					
					resource = new Resource();
					resource.setResourceId(resourceId);
					resource.setResourceName(resourceName);
					resource.setResourceLabel(resourceLabel);
					resource.setResourceLocation(resourceLocation);
					resourceList.add(resource);
				}
			}
			return resourceList;
		} else {
			return resourceDao.search("from Resource order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
		}
	}
	
	public boolean removeResource(String resourceId) {
		resourceDao.executeHql("delete from Resource where resourceId = ?", new Object[] { resourceId });
		Long qty = resourceDao.count("select count(resourceId) from Resource where resourceId = ?" , new Object[] { resourceId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeResource(String[] resourceIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String resourceId : resourceIds) {
			resourceDao.executeHql("delete from Resource where resourceId = ?", new Object[] { resourceId });
			qty = resourceDao.count("select count(resourceId) from Resource where resourceId = ?" , new Object[] { resourceId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == resourceIds.length ) return true;
		return false;
	}
	
	public boolean saveResource(Resource resource) {
		String method = "";
		if ( resource.getResourceId() == null ) { method = "add"; }
		else { method = "update"; }
		resourceDao.saveOrUpdate(resource);
		if ( method.equals("add") ) {
			if ( resource.getResourceId() != null ) return true;
		} else { return true; }
		return false;
	}
}