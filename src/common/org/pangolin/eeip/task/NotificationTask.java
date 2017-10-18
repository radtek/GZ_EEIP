package org.pangolin.eeip.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.pangolin.eeip.entity.Notification;
import org.pangolin.eeip.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationTask {
	
	/**
	 * 待自动发布消息
	 * */
	public static Map<String, Object> PRE_PUBLISH_NOTES = new HashMap<String, Object>();
	
	/**
	 * 待自动撤回消息
	 * */
	public static Map<String, Object> PRE_WITHDRAW_NOTES = new HashMap<String, Object>();
	
	@Autowired
	private NotificationService notificationService;
	
	/**
	 * 自动发布消息任务（延时性）
	 * @author Oscar Mok
	 * */
	public void publish() {
		if ( !PRE_PUBLISH_NOTES.isEmpty() ) {
			System.out.println("Publish notifications automatically at " + formatDate(new Date()));
			Set<String> noteIds = PRE_PUBLISH_NOTES.keySet();
			long currentDateTime = getCurrentTime();
			for ( String noteId : noteIds ) {
				long publishedDateTime = (Long)PRE_PUBLISH_NOTES.get(noteId);
				if ( publishedDateTime <= currentDateTime ) {
					notificationService.saveNotificationStatus(noteId, Notification.PUBLISHED);
					PRE_PUBLISH_NOTES.remove(noteId);
				}
			}
		}
	}
	
	/**
	 * 自动撤回消息任务（延时性）
	 * @author Oscar Mok
	 * */
	public void withdraw() {
		if ( !PRE_WITHDRAW_NOTES.isEmpty() ) {
			System.out.println("Withdraw notifications automatically at " + formatDate(new Date()));
			Set<String> noteIds = PRE_WITHDRAW_NOTES.keySet();
			long currentDateTime = getCurrentTime();
			for ( String noteId : noteIds ) {
				long expiredDateTime = (Long)PRE_WITHDRAW_NOTES.get(noteId);
				if ( expiredDateTime <= currentDateTime ) {
					notificationService.saveNotificationStatus(noteId, Notification.UNPUBLISHED);
					PRE_WITHDRAW_NOTES.remove(noteId);
				}
			}
		}
	}
	
	/**
	 * 获取当前时间
	 * @author Oscar Mok
	 * @return 当前时间的毫秒数
	 * */
	private long getCurrentTime() {
		long currentTime = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date currentDate = new Date();
			currentTime = sdf.parse(sdf.format(currentDate)).getTime();
		} catch(Exception ex) { ex.printStackTrace(); }
		return currentTime;
	}
	
	/**
	 * 日期格式化
	 * @author Oscar Mok
	 * @param date 日期对象
	 * @return 指定格式日期字符
	 * */
	private String formatDate(Date date) {
		try {
			if ( date != null ) {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return "";
	}
}