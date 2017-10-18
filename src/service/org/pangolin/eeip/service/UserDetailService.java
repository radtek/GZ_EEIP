package org.pangolin.eeip.service;

import org.pangolin.eeip.entity.UserDetail;

public interface UserDetailService {
	
	/**
	 * 根据用户详细信息ID获取用户详细信息
	 * @author Oscar Mok
	 * @param userDetailId 用户详细信息ID
	 * @return 用户详细信息
	 * */
	public UserDetail getUserDetailById(String userDetailId);
	
	/**
	 * 根据用户ID获取用户详细信息
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 用户详细信息
	 * */
	public UserDetail getUserDetailByUser(String userId);
	
	/**
	 * 根据用户ID获取用户详细信息
	 * @author Xiaolin Yin
	 * @param policeId 用户ID
	 * @return 用户详细信息
	 * */
	public UserDetail getUserDetailByPoliceId(String policeId);
	
	/**
	 * 移除用户详细信息
	 * @author Oscar Mok
	 * @param userDetailId 用户详细信息ID
	 * @return 移除状态
	 * */
	public void removeUserDetail(String userDetailId);
	
	/**
	 * 根据用户ID移除用户详细信息
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 移除状态
	 * */
	public void removeUserDetailByUser(String userId);
	
	/**
	 * 保存用户详细信息
	 * @author Oscar Mok
	 * @param userDetail 用户详细信息对象
	 * @return 保存状态
	 * */
	public boolean saveUserDetail(UserDetail userDetail);
	
	/**
	 * 验证用户详细信息合法性
	 * @author Oscar Mok
	 * @param userDetail 用户详细信息对象
	 * @return 验证状态
	 * */
	public boolean validateUserDetail(UserDetail userDetail);
}