package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Role;

public interface RoleService {
	
	/**
	 * 根据角色ID获取角色信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 角色信息
	 * */
	public Role getRoleById(String roleId);
	
	/**
	 * 根据角色标记获取角色信息
	 * @author Oscar Mok
	 * @param roleLabel 角色标记
	 * @return 角色信息
	 * */
	public Role getRoleByLabel(String roleLabel);
	
	/**
	 * 获取所有角色数量
	 * @author Oscar Mok
	 * @return 角色数量
	 * */
	public Long getRoleQty();
	
	/**
	 * 获取顶层角色数量
	 * @author Oscar Mok
	 * @return 角色数量
	 * */
	public Long getRootRoleQty();
	
	/**
	 * 根据组织获取角色数量
	 * @author Oscar Mok
	 * @return 角色数量
	 * */
	public Long getRoleQtyByOrg(String orgId);
	
	/**
	 * 获取所有角色信息列表
	 * @author Oscar Mok
	 * @return 角色信息列表
	 * */
	public List<Role> getRoles();
	
	/**
	 * 根据角色ID集合，查询对应的角色信息集合
	 * @param roleIds 角色ID集合
	 * @return 角色信息集合
	 * @author liaoqi
	 */
	public List<Role> getRolesByIds(String[] roleIds);//TODO
	
	/**
	 * 获取顶层角色信息列表
	 * @author Oscar Mok
	 * @return 角色信息列表
	 * */
	public List<Role> getRootRoles();
	
	/**
	 * 获取顶层角色信息列表
	 * @author Oscar Mok
	 * @param roleStatus 角色状态
	 * @return 角色信息列表
	 * */
	public List<Role> getRootRoles(Integer roleStatus);
	
	/**
	 * 根据指定用户获取所属角色列表（允许一个用户拥有多重角色）
	 * @author Oscar Mok
	 * @return 角色信息列表
	 * */
	public List<Role> getRolesByUser(String userId);
	
	/**
	 * 根据指定组织获取所属角色列表
	 * @author Oscar Mok
	 * @return 角色信息列表
	 * */
	public List<Role> getRolesByOrg(String orgId);
	
	/**
	 * 根据指定组织获取所属角色列表
	 * @author Oscar Mok
	 * @param roleStatus 角色状态
	 * @return 角色信息列表
	 * */
	public List<Role> getRolesByOrg(String orgId, Integer roleStatus);
	
	/**
	 * 获取所有角色信息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 角色信息列表
	 * */
	public List<Role> getRoles(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 获取顶层角色信息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 角色信息列表
	 * */
	public List<Role> getRootRoles(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据组织获取所有角色信息列表
	 * @author Oscar Mok
	 * @param orgId 组织ID
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 角色信息列表
	 * */
	public List<Role> getRolesByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除角色信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 移除状态
	 * */
	public boolean removeRole(String roleId);
	
	/**
	 * 设置角色删除状态
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @param deleteFlag 删除标识
	 * @return 移除状态
	 * */
	public boolean setRoleDelFlag(String roleId, Integer deleteFlag);
	
	/**
	 * 批量移除角色信息
	 * @author Oscar Mok
	 * @param roleIds 角色ID集合
	 * @return 移除状态
	 * */
	public boolean removeRole(String[] roleIds);
	
	/**
	 * 保存角色信息
	 * @author Oscar Mok
	 * @param role 角色对象
	 * @return 保存状态
	 * */
	public boolean saveRole(Role role);
	
	/**
	 * 是否存在指定角色（同层级内不允许存在重复标识）
	 * @param roleLabel 角色标识
	 * @param org 所属机构（可选）
	 * @return 角色存在状态
	 * */
	public boolean existRole(String roleLabel, Organization org);
	
	/**
	 * 复制角色信息
	 * @param copiedRole 被复制角色
	 * @param org 用户所属机构（可选）
	 * @return 新角色
	 * */
	public Role copyRole(Role copiedRole, Organization org);
	
	/**
	 * 获取机构管理员角色标识
	 * @param org 机构对象
	 * @return 机构管理员角色标识
	 * */
	public String getOrgAdminRoleLabel(Organization org);
	
	/**
	 * 重载所有角色权限关系缓存
	 * @author Oscar Mok
	 * */
	public void reloadRoleAuthorities();
	
	/**
	 * 重载指定角色的角色权限关系缓存
	 * @author Oscar Mok
	 * */
	public void reloadRoleAuthorities(Role role);
	
	/**
	 * 重载所有角色标识与名称配对缓存
	 * @author Oscar Mok
	 * */
	public void reloadRoleNames();
	
	/**
	 * 重载指定角色标识与名称配对缓存
	 * @author Oscar Mok
	 * */
	public void reloadRoleName(Role role);
	
}