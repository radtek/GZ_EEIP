package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.dto.RoleUserDto;
import org.pangolin.eeip.entity.RoleUser;

public interface RoleUserService {
	
	/**
	 * 根据角色用户ID获取角色用户关系信息
	 * @author Oscar Mok
	 * @param roleUserId 角色用户ID
	 * @return 角色用户关系信息
	 * */
	public RoleUser getRoleUserById(String roleUserId);
	
	/**
	 * 获取所有角色用户关系信息
	 * @author Oscar Mok
	 * @return 角色用户关系信息列表
	 * */
	public List<RoleUser> getRoleUsers();
	
	/**
	 * 获取所有角色用户关系信息（用户传输对象）
	 * @author Oscar Mok
	 * @return 角色用户关系（用户传输对象）信息列表
	 * */
	public List<RoleUserDto> getRoleUserDtos();
	
	/**
	 * 根据指定角色获取角色用户关系信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 角色用户关系信息列表
	 * */
	public List<RoleUser> getRoleUsersByRole(String roleId);
	
	/**
	 * 根据指定用户获取角色用户关系信息（允许一个用户同时拥有多角色）
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 角色用户关系信息列表
	 * */
	public List<RoleUser> getRoleUsersByUser(String userId);
	
	/**
	 * 移除角色用户关系信息
	 * @author Oscar Mok
	 * @param roleUserId 角色用户关系ID
	 * */
	public void removeRoleUser(String roleUserId);
	
	/**
	 * 根据角色ID移除角色用户关系信息
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @param roleUserId 角色用户关系ID
	 * */
	public void removeRoleUserByRole(String roleId);
	
	/**
	 * 根据用户ID移除角色用户关系信息
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @param roleUserId 角色用户关系ID
	 * */
	public void removeRoleUserByUser(String userId);
	
	/**
	 * 保存角色用户关系信息
	 * @author Oscar Mok
	 * @param roleUser 角色用户关系对象
	 * */
	public void saveRoleUser(RoleUser roleUser);
	
	/**
	 * 用户是否属于指定角色
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @param userId 用户ID
	 * @return 角色用户关系存在情况
	 * */
	public boolean existRoleUser(String roleId, String userId);
	
}