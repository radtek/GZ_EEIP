package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Advertisement;
import org.pangolin.eeip.entity.NotificationImage;

public interface NotificationImageService {
	
	/**
	 * 根据ID获取图片信息
	 * @author Oscar Mok
	 * @param id 图片ID
	 * @return 图片信息
	 * */
	public NotificationImage getNotificationImageById(String id);
	
	/**
	 * 根据指定消息获取图片信息列表
	 * @author Oscar Mok
	 * @param notificationId 消息ID
	 * @return 图片信息列表
	 * */
	public List<NotificationImage> getImagesByNotification(String notificationId);
	
	/**
	 * 保存图片信息
	 * @author Oscar Mok
	 * @param notificationImage 图片信息
	 * @return 保存状态
	 * */
	public boolean saveNotificationImage(NotificationImage notificationImage);
	
	/**
	 * 移除图片信息
	 * @author Oscar Mok
	 * @param id 图片ID
	 * @return 移除状态
	 * */
	public boolean removeNotificationImage(String id);
	
	/**
	 * 根据指定消息移除图片信息
	 * @author Oscar Mok
	 * @param notificationId 消息ID
	 * @return 移除状态
	 * */
	public boolean removeImageByNotification(String notificationId);
	
}