package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.NotificationType;

public interface NotificationTypeService {
	
	/**
	 * 根据消息类型ID获取消息类型信息
	 * @author Oscar Mok
	 * @param noteTypeId 消息类型ID
	 * @return 消息类型信息
	 * */
	public NotificationType getNotificationTypeById(String id);
	
	/**
	 * 根据消息类型标识获取消息类型信息
	 * @author Oscar Mok
	 * @param noteTypeLabel 消息类型标识
	 * @return 消息类型信息
	 * */
	public NotificationType getNotificationTypeByLabel(String label);
	
	/**
	 * 获取所有消息类型数量
	 * @author Oscar Mok
	 * @return 消息类型数量
	 * */
	public Long getNotificationTypeQty();
	
	/**
	 * 获取所有消息类型列表
	 * @author Oscar Mok
	 * @return 消息类型列表
	 * */
	public List<NotificationType> getNotificationTypies();
	
	/**
	 * 获取所有根消息类型列表
	 * @author Oscar Mok
	 * @return 消息类型列表
	 * */
	public List<NotificationType> getRootNotificationTypies();
	
	/**
	 * 根据类型获取消息类型列表
	 * @author Oscar Mok
	 * @param parentNoteTypeId 消息类型ID
	 * @return 消息类型列表
	 * */
	public List<NotificationType> getNotificationTypiesByParentType(String parentNoteTypeId);
	
	/**
	 * 获取所有消息类型列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 消息类型列表
	 * */
	public List<NotificationType> getNotificationTypies(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除消息类型
	 * @author Oscar Mok
	 * @param noteTypeId 消息类型ID
	 * @return 移除状态
	 * */
	public boolean removeNotificationType(String id);
	
	/**
	 * 保存消息类型
	 * @author Oscar Mok
	 * @param notificationType 消息类型对象
	 * @return 保存状态
	 * */
	public boolean saveNotificationType(NotificationType notificationType);
	
	/**
	 * 是否存在指定消息类型
	 * @param noteTypeLabel 消息类型标识
	 * @return 消息类型存在状态
	 * */
	public boolean existNotificationType(String label);
}