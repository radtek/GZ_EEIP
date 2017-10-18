package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Resource;

public interface ResourceService {
	
	public Resource getResourceById(String resourceId);
	
	public Resource getResourceByLabel(String resourceLabel);
	
	public Long getResourceQty();
	
	public Long getSurplusResourceQty(String roleId);
	
	public Long getResourceQtyByRole(String roleId);
	
	public List<Resource> getResources();
	
	public List<Resource> getResourcesByRole(String roleId);
	
	public List<Resource> getResources(int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<Resource> getSurplusResources(String roleId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public boolean removeResource(String resourceId);
	
	public boolean removeResource(String[] resourceIds);
	
	public boolean saveResource(Resource resource);
	
}