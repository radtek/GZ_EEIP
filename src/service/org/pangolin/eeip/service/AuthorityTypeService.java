package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AuthorityType;

public interface AuthorityTypeService {
	
	/**
	 * 根据权限类型ID获取权限类型信息
	 * @author Oscar Mok
	 * @param authorityTypeId 权限类型ID
	 * @return 权限类型信息
	 * */
	public AuthorityType getAuthorityTypeById(String authorityTypeId);
	
	/**
	 * 根据权限类型标记获取权限类型信息
	 * @author Oscar Mok
	 * @param authorityTypeLabel 权限类型标记
	 * @return 权限类型信息
	 * */
	public AuthorityType getAuthorityTypeByLabel(String authorityTypeLabel);
	
	/**
	 * 获取所有权限类型信息列表
	 * @author Oscar Mok
	 * @return 权限类型信息列表
	 * */
	public List<AuthorityType> getAuthorityTypies();
	
	/**
	 * 获取所有（顶层）权限类型信息列表
	 * @author Oscar Mok
	 * @return 权限类型信息列表
	 * */
	public List<AuthorityType> getRootAuthorityTypies();
	
	/**
	 * 根据上级权限类型获取所有权限类型信息列表
	 * @author Oscar Mok
	 * @return 权限类型信息列表
	 * */
	public List<AuthorityType> getAuthorityTypiesByParentAuthorityType(String parentAuthorityTypeId);
	
	/**
	 * 是否存在指定权限类型
	 * @author Oscar Mok
	 * @param authorityTypeLabel 权限类型标记
	 * @return 权限类型存在情况
	 * */
	public boolean existAuthorityType(String authorityTypeLabel);
	
	/**
	 * 保存权限类型信息
	 * @author Oscar Mok
	 * @param authorityType 权限类型
	 * @return 保存状态
	 * */
	public void saveAuthorityType(AuthorityType authorityType);
	
}