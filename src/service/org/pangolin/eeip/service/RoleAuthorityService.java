package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.RoleAuthority;

public interface RoleAuthorityService {
	
	/**
	 * 根据角色权限ID获取角色权限关系信息
	 * @author Oscar Mok
	 * @param roleAuthId 角色权限ID
	 * @return 角色权限关系信息
	 * */
	public RoleAuthority getRoleAuthorityById(String roleAuthId);
	
	/**
	 * 获取所有角色权限关系信息
	 * @author Oscar Mok
	 * @return 角色权限关系信息列表
	 * */
	public List<RoleAuthority> getRoleAuthorities();
	
	/**
	 * 根据指定角色获取角色权限关系信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 角色权限关系信息列表
	 * */
	public List<RoleAuthority> getRoleAuthoritiesByRole(String roleId);
	
	/**
	 * 移除角色权限关系信息
	 * @author Oscar Mok
	 * @param roleAuthId 角色权限关系ID
	 * */
	public void removeRoleAuthority(String roleAuthId);
	
	/**
	 * 根据指定角色移除角色权限关系信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * */
	public void removeRoleAuthorityByRole(String roleId);
	
	/**
	 * 保存角色权限关系信息
	 * @author Oscar Mok
	 * @param roleAuthority 角色权限关系对象
	 * */
	public void saveRoleAuthority(RoleAuthority roleAuthority);
	
	/**
	 * 批量保存角色权限关系信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @param authorityIds 权限ID集合
	 * @param parentAuthLabels 父级权限标识集合
	 * */
	public void saveRoleAuthority(String roleId, String[] authorityIds, String[] parentAuthLabels);
	
	/**
	 * 角色是否存在指定权限
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @param authorityId 权限ID
	 * @return 角色权限关系存在情况
	 * */
	public boolean existRoleAuthority(String roleId, String authorityId);
	
}