package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Notification;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface NotificationService {
	
	/**
	 * 根据消息ID获取消息信息
	 * @author Oscar Mok
	 * @param id 消息ID
	 * @return 消息信息
	 * */
	public Notification getNotificationById(String id);
	
	/**
	 * 获取所有消息数量
	 * @author Oscar Mok
	 * @return 消息数量
	 * */
	public Long getNotificationQty();
	
	/**
	 * 根据消息状态获取消息数量
	 * @author Oscar Mok
	 * @param status 消息状态
	 * @return 消息数量
	 * */
	public Long getNotificationQty(Integer status);
	
	/**
	 * 根据类型获取消息数量
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @return 消息数量
	 * */
	public Long getNotificationQtyByType(String notificationTypeId);
	
	/**
	 * 根据类型和状态获取消息数量
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @param status 消息状态
	 * @return 消息数量
	 * */
	public Long getNotificationQtyByTypeAndStatus(String notificationTypeId, Integer status);
	
	/**
	 * 获取所有消息列表
	 * @author Oscar Mok
	 * @return 消息列表
	 * */
	public List<Notification> getNotifications();
	
	/**
	 * 根据类型获取消息列表
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @return 消息列表
	 * */
	public List<Notification> getNotificationsByType(String notificationTypeId);
	
	/**
	 * 根据类型、机构、角色获取消息列表（用于消息展示）
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @param orgSN 机构标识
	 * @param roleLabel 角色标识
	 * @return 消息列表
	 * */
	public List<Notification> getNotificationsByTypeAndIssueRange(String notificationTypeId, String orgSN, String roleLabel);
	
	/**
	 * 获取所有消息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息列表
	 * */
	public List<Notification> getNotifications(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据类型获取消息列表
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息列表
	 * */
	public List<Notification> getNotificationsByType(String notificationTypeId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * TODO
	 * 根据类型、机构标识、角色标识获取消息列表（用于消息展示）
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @param orgSN 机构标识
	 * @param roleLabel 角色标识
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息列表
	 * */
	public List<Notification> getNotificationsByTypeAndIssueRange(String notificationTypeId, String orgSN, String roleLabel, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据状态获取消息列表
	 * @author Oscar Mok
	 * @param status 消息状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息列表
	 * */
	public List<Notification> getNotificationsByStatus(Integer status, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据类型和状态获取消息列表
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @param notificationStatus 消息状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息列表
	 * */
	public List<Notification> getNotificationsByTypeAndStatus(String notificationTypeId, Integer status, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据类型和状态获取消息列表
	 * @author Oscar Mok
	 * @param notificationTypeId 消息类型ID
	 * @param notificationStatus 消息状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息列表
	 * */
	@Cacheable(value = "noteCache", key = "#notificationTypeId")
	public List<Notification> getNotificationCachesByTypeAndStatus(String notificationTypeId, Integer status, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除消息
	 * @author Oscar Mok
	 * @param id 消息ID
	 * @return 移除状态
	 * */
	public boolean removeNotification(String id);
	
	/**
	 * 保存消息
	 * @author Oscar Mok
	 * @param notification 消息对象
	 * @return 保存状态
	 * */
	public boolean saveNotification(Notification notification);
	
	/**
	 * 根据消息ID设置状态
	 * @author Oscar Mok
	 * @param notificationId 消息ID
	 * @param status 消息状态
	 * @return 保存状态
	 * */
	public boolean saveNotificationStatus(String notificationId, Integer status);
	
	/**
	 * 批量设置消息状态
	 * @author Oscar Mok
	 * @param notificationIds 消息ID集合
	 * @param status 消息状态
	 * @return 保存状态
	 * */
	public boolean saveNotificationStatus(String[] notificationIds, Integer status);
	
	/**
	 * 清理所有消息缓存
	 * */
	@CacheEvict(value = "noteCache", allEntries = true)
	public void clearAllNotificationCache();
}