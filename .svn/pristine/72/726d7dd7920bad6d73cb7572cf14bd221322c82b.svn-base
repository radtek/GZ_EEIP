package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Authority;

public interface AuthorityService {

	/**
	 * 根据权限ID获取权限信息
	 * @author Oscar Mok
	 * @param authorityId 权限ID
	 * @return 权限信息
	 * */
	public Authority getAuthorityById(String authorityId);
	
	/**
	 * 根据权限标记获取权限信息
	 * @author Oscar Mok
	 * @param authorityLabel 权限标记
	 * @return 权限信息
	 * */
	public Authority getAuthorityByLabel(String authorityLabel);
	
	/**
	 * 获取所有权限信息列表
	 * @author Oscar Mok
	 * @return 权限信息列表
	 * */
	public List<Authority> getAuthorities();
	
	/**
	 * 获取顶层权限信息列表
	 * @author Oscar Mok
	 * @return 顶层权限信息列表
	 * */
	public List<Authority> getRootAuthorities();
	
	/**
	 * 根据指定角色获取权限信息列表
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 权限信息列表
	 * */
	public List<Authority> getAuthoritiesByRole(String roleId);
	
	/**
	 * 根据指定类型获取权限信息列表
	 * @author Oscar Mok
	 * @param authorityTypeId 权限类型ID
	 * @return 权限信息列表
	 * */
	public List<Authority> getAuthoritiesByType(String authorityTypeId);
	
	/**
	 * 移除权限信息
	 * @author Oscar Mok
	 * @param authorityId 权限ID
	 * @return 移除状态
	 * */
	public boolean removeAuthority(String authorityId);
	
	/**
	 * 批量移除权限信息
	 * @author Oscar Mok
	 * @param authorityIds 权限ID集合
	 * @return 移除状态
	 * */
	public boolean removeAuthority(String[] authorityIds);
	
	/**
	 * 保存权限信息
	 * @author Oscar Mok
	 * @param authority 权限对象
	 * @return 保存状态
	 * */
	public boolean saveAuthority(Authority authority);
	
	/**
	 * 是否存在指定权限
	 * @param authorityLabel 权限标识
	 * @return 权限存在状态
	 * */
	public boolean existAuthority(String authorityLabel);
	
	/**
	 * 当前登录用户的权限
	 * @XiaoLin Yin
	 * @return 权限信息列表
	 */
	public List<Authority> getCurrentAuthority(String userName);
}