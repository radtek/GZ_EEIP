package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.dto.UserDto;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;

public interface UserService {
	
	/**
	 * 根据用户ID获取用户信息
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 用户信息
	 * */
	public User getUserById(String userId);
	
	/**
	 * 根据用户账号获取用户信息
	 * @author Oscar Mok
	 * @param userName 用户账号
	 * @return 用户信息
	 * */
	public User getUserByName(String userName);
	
	/**
	 * 根据用户ID获取用户原密码
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 用户原密码
	 * */
	public String getUserOriginalPwdById(String userId);
	
	/**
	 * 获取所有用户数量
	 * @author Oscar Mok
	 * @return 用户数量
	 * */
	public Long getUserQty();
	
	/**
	 * 根据查询条件获取所有用户数量
	 * @author Oscar Mok
	 * @param condition 查询条件
	 * @return 用户数量
	 * */
	public Long getUserQty(String condition);
	
	/**
	 * 根据组织ID获取所属用户数量
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 用户数量
	 * */
	public Long getUserQtyByOrg(String orgId);
	
	/**
	 * 根据组织ID获取所属用户数量
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @param condition 查询条件
	 * @return 用户数量
	 * */
	public Long getUserQtyByOrg(String orgId, String condition);
	
	/**
	 * 获取所有用户信息列表
	 * @author Oscar Mok
	 * @return 用户信息列表
	 * */
	public List<User> getUsers();
	
	/**
	 * 根据组织ID获取所属用户信息列表
	 * @author Oscar Mok
	 * @param orgId
	 * @return 用户信息列表
	 * */
	public List<User> getUsersByOrg(String orgId);
	
	/**
	 * 根据角色ID获取所属用户信息列表
	 * @author Oscar Mok
	 * @param roleId
	 * @return 用户信息列表
	 * */
	public List<User> getUsersByRole(String roleId);
	
	/**
	 * 获取所有用户信息列表（包含已删除用户）
	 * @author Oscar Mok
	 * @return 用户信息列表
	 * */
	public List<User> getAllUsers();
	
	/**
	 * 根据组织ID获取所属用户信息列表（包含已删除用户）
	 * @author Oscar Mok
	 * @param orgId
	 * @return 用户信息列表
	 * */
	public List<User> getAllUsersByOrg(String orgId);
	
	/**
	 * 根据角色ID获取所属用户信息列表（包含已删除用户）
	 * @author Oscar Mok
	 * @param roleId
	 * @return 用户信息列表
	 * */
	public List<User> getAllUsersByRole(String roleId);
	
	/**
	 * 获取所有用户信息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 用户信息列表
	 * */
	public List<User> getUsers(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 获取所有用户信息列表
	 * @author Oscar Mok
	 * @param condition 查询条件
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 用户信息列表
	 * */
	public List<User> getUsers(String condition, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据组织ID获取所属用户信息列表
	 * @author Oscar Mok
	 * @param orgId 组织ID
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 用户信息列表
	 * */
	public List<User> getUsersByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据组织ID、查询条件获取所属用户信息列表
	 * @author Oscar Mok
	 * @param orgId 组织ID
	 * @param condition 查询条件
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 用户信息列表
	 * */
	public List<User> getUsersByOrg(String orgId, String condition, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除用户信息
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 移除状态
	 * */
	public boolean removeUser(String userId);
	
	/**
	 * 设置用户删除状态
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @param deleteFlag 删除标识
	 * @return 移除状态
	 * */
	public boolean setUserDelFlag(String userId, Integer deleteFlag);
	
	/**
	 * 设置用户注册状态
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @param userRegStatus 用户注册状态
	 * @return 移除状态
	 * */
	public boolean setUserRegStatus(String userId, Integer userRegStatus);
	
	/**
	 * 批量移除用户信息
	 * @author Oscar Mok
	 * @param userIds 用户ID集合
	 * @return 移除状态
	 * */
	public boolean removeUser(String[] userIds);
	
	/**
	 * 设置用户使用状态信息（支持批量）
	 * @author Oscar Mok
	 * @param userIds 用户ID集合
	 * @param userStatus 用户状态
	 * @return 保存状态
	 * */
	public boolean saveUserStatus(String[] userIds, Integer userStatus);
	
	/**
	 * 恢复用户默认密码（支持批量）
	 * @author Oscar Mok
	 * @param userIds 用户ID集合
	 * @param defaultPwd 默认密码
	 * @return 保存状态
	 * */
	public boolean saveUserDefaultPwd(String[] userIds, String defaultPwd);
	
	/**
	 * 保存用户信息
	 * @author Oscar Mok
	 * @param user 用户对象
	 * @return 保存状态
	 * */
	public boolean saveUser(User user);
	
	/**
	 * 保存用户信息
	 * @author Oscar Mok
	 * @param user 用户基本信息
	 * @param userDetail 用户详细信息
	 * @param orgId 组织ID
	 * @param roleId 角色ID
	 * @return 保存状态
	 * */
	public boolean saveUser(User user, UserDetail userDetail, String orgId, String roleId);
	
	/**
	 * 保存用户信息
	 * @author liaoqi
	 * @param user 用户基本信息
	 * @param userDetail 用户详细信息
	 * @param orgId 组织ID
	 * @param roleIds 角色ID集合
	 * @return 保存状态
	 * */
	public boolean saveUser(User user, UserDetail userDetail, String orgId, String[] roleIds);//TODO
	
	/**
	 * 是否存在指定用户
	 * @param userName 用户账号
	 * @return 用户存在状态
	 * */
	public boolean existUser(String userName);
	
	/**
	 * 保存用户密码
	 * @param user 用户对象
	 * @param newPwd 用户新密码
	 * @return 保存状态
	 * */
	public boolean saveUserPwd(User user, String newPwd);
	
	/**
	 * 保存用户资料
	 * @param user 用户对象
	 * @param userDetail 用户详细信息
	 * @return 保存状态
	 * */
	public boolean saveUserProfile(User user, UserDetail userDetail);
	
	/**
	 * 重载所有用户角色关系缓存
	 * @author Oscar Mok
	 * */
	public void reloadUserRoles();
	
	/**
	 * 重载指定用户的用户角色关系缓存
	 * @author Oscar Mok
	 * */
	public void reloadUserRole(User user);
	
	/**
	 * 验证注册用户数据
	 * @author Oscar Mok
	 * @param userDto 注册用户数据
	 * @return 验证状态
	 * */
	public boolean verifyRegUserData(UserDto userDto);
	
	/**
	 * 验证用户原密码
	 * @author Oscar Mok
	 * @param user 用户对象
	 * @param originalPassword 用户原密码
	 * @return 验证状态
	 * */
	public boolean verifyUserOriginalPassword(User user, String originalPassword);
	
	/**
	 * 根据用户对象获取当前登录用户对象
	 * @author Oscar Mok
	 * @param user 用户对象
	 * @return 当前登录用户对象
	 * */
	public CurrentUser getCurrentUser(User user);
	
	/**
	 * 验证用户基本信息合法性
	 * @author Oscar Mok
	 * @param user 用户对象
	 * @return 验证状态
	 * */
	public boolean validateUser(User user);
	
	/**
	 * 根据用户ID获取密码信息
	 * @author Oscar Mok
	 * @param userId 用户密码
	 * @return 用户密码
	 * */
	public String getUserPwd(String userId);
	
	/**
	 * 根据角色ID获取所属用户鉴定情况信息列表
	 * @author Xiaolin Yin
	 * @param roleLabel
	 * @return 用户信息列表
	 * */
	public List<User> getUsersByRoleId(String roleId);
}