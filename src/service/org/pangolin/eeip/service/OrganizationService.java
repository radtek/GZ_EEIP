package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.dto.OrgDto;
import org.pangolin.eeip.entity.Organization;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface OrganizationService {
	
	/**
	 * 根据机构ID获取机构信息
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 机构信息
	 * */
	public Organization getOrganizationById(String orgId);
	
	/**
	 * 根据获取顶层机构信息
	 * @author Oscar Mok
	 * @return 机构信息
	 * */
	public Organization getRootOrganization(String orgId);
	
	/**
	 * 获取所有机构数量
	 * @author Oscar Mok
	 * @return 机构数量
	 * */
	public Long getOrganizationQty();
	
	/**
	 * 根据父机构获取子机构数量
	 * @author Oscar Mok
	 * @return 机构数量
	 * */
	public Long getOrganizationQtyByParentOrg(String parentOrgId);
	
	/**
	 * 获取所有机构信息列表
	 * @author Oscar Mok
	 * @return 机构信息列表
	 * */
	public List<Organization> getOrganizations();
	
	/**
	 * 获取根机构信息列表
	 * @author Oscar Mok
	 * @return 机构信息列表
	 * */
	public List<Organization> getRootOrganizations();
	
	/**
	 * 根据指定用户获取所属部门列表（允许一个用户从属多个部门）
	 * @author Oscar Mok
	 * @return 机构信息列表
	 * */
	public List<Organization> getOrganizationsByUser(String userId);
	
	/**
	 * 根据父机构获取子机构信息列表（非递归获取所有层级机构）
	 * @author Oscar Mok
	 * @param parentOrgId 父机构ID
	 * @return 机构信息列表
	 * */
	public List<Organization> getOrganizationsByParentOrg(String parentOrgId);
	
	/**
	 * 根据父机构获取子机构信息列表（递归获取所有层级机构）
	 * @author Oscar Mok
	 * @param parentOrgId 父机构ID
	 * @return 机构信息列表
	 * */
	public List<Organization> getAllOrganizationsByParentOrg(String parentOrgId);
	
	/**
	 * 根据当前机构获取所有父级机构
	 * @param orgId
	 * @return 机构信息列表
	 * */
	public List<Organization> getParentOrganizationsByCurrentOrg(String orgId);
	
	/**
	 * 根据当前机构获取所有下级机构
	 * @param orgId
	 * @return 机构信息列表
	 * */
	public List<Organization> getChildOrganizationsByCurrentOrg(String orgId);
	
	/**
	 * 获取所有机构信息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 机构信息列表
	 * */
	public List<Organization> getOrganizations(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 获取根机构信息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 机构信息列表
	 * */
	public List<Organization> getRootOrganizations(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据父机构获取子机构信息列表
	 * @author Oscar Mok
	 * @param parentOrgId 父机构ID
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 机构信息列表
	 * */
	public List<Organization> getOrganizationsByParentOrg(String parentOrgId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除机构信息
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 移除状态
	 * */
	public boolean removeOrganization(String orgId);
	
	/**
	 * 设置机构删除状态
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @param deleteFlag 删除标识
	 * @return 移除状态
	 * */
	public boolean setOrganizationDelFlag(String orgId, Integer deleteFlag);
	
	/**
	 * 批量移除机构信息
	 * @author Oscar Mok
	 * @param orgIds 机构ID集合
	 * @return 移除状态
	 * */
	public boolean removeOrganization(String[] orgIds);
	
	/**
	 * 保存机构信息
	 * @author Oscar Mok
	 * @param organization 机构对象
	 * @return 保存状态
	 * */
	public boolean saveOrganization(Organization organization);
	
	/**
	 * 获取所有机构TreeGrid对象列表（机构管理时使用）
	 * @author Oscar Mok
	 * @return 机构TreeGrid对象列表
	 * */
	@Cacheable(value = "orgCache")
	public List<OrgDto> getAllOrganizationTreeGridData();
	
	/**
	 * 根据父级机构ID获取机构TreeGrid对象列表（机构管理时使用）
	 * @author Oscar Mok
	 * @param parentOrgId 机构ID
	 * @return 机构TreeGrid对象列表
	 * */
	@Cacheable(value = "orgCache", key = "#parentOrgId")
	public List<OrgDto> getChildOrganizationTreeGridData(String parentOrgId);
	
	/**
	 * 清理所有机构缓存（机构管理时使用）
	 * */
	@CacheEvict(value = "orgCache", allEntries = true)
	public void clearAllOrganizationCache();
	
	/**
	 * 获取所有机构TreeGrid对象列表（用户管理时使用）
	 * @author Oscar Mok
	 * @return 机构TreeGrid对象列表
	 * */
	@Cacheable(value = "userOrgCache")
	public List<OrgDto> getAllUserOrganizationTreeGridData();
	
	/**
	 * 清理所有机构缓存（用户管理时使用）
	 * */
	@CacheEvict(value = "userOrgCache", allEntries = true)
	public void clearAllUserOrganizationCache();
	
}