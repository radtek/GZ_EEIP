package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.NotificationDao;
import org.pangolin.eeip.entity.Notification;
import org.pangolin.eeip.service.NotificationImageService;
import org.pangolin.eeip.service.NotificationService;
import org.springframework.stereotype.Service;

@Service("notificationService")
@SuppressWarnings("all")
public class NotificationServiceImpl implements NotificationService {

	@Resource
	private  NotificationDao notificationDao;
	
	@Resource
	private NotificationImageService notificationImageService;
	
	public Notification getNotificationById(String id) {
		return notificationDao.get(Notification.class, id);
	}
	
	public Long getNotificationQty() {
		return notificationDao.count("select count(id) from Notification");
	}
	
	public Long getNotificationQty(Integer status) {
		return notificationDao.count("select count(id) from Notification where status = ?", new Object[] { status });
	}
	
	public Long getNotificationQtyByType(String notificationTypeId) {
		return notificationDao.count("select count(id) from Notification where notificationTypeId = ?", new Object[] { notificationTypeId });
	}
	
	public Long getNotificationQtyByTypeAndStatus(String notificationTypeId, Integer status) {
		return notificationDao.count("select count(id) from Notification where notificationTypeId = ? and status = ?", new Object[] { notificationTypeId, status });
	}
	
	public List<Notification> getNotifications() {
		return notificationDao.find("from Notification order by createdDate desc");
	}
	
	public List<Notification> getNotificationsByType(String notificationTypeId) {
		return notificationDao.find("from Notification where notificationTypeId = ? order by createdDate desc", new Object[] { notificationTypeId });
	}
	
	public List<Notification> getNotificationsByTypeAndIssueRange(String notificationTypeId, String orgSN, String roleLabel) {
		return notificationDao.find("from Notification where notificationTypeId = ? and issueRange like ? and issueRange like ? and status = ? order by createdDate desc", new Object[] { notificationTypeId, "%" + orgSN + "%", "%" + roleLabel + "%", Notification.PUBLISHED });
	}
	
	public List<Notification> getNotifications(int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationDao.search("from Notification order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<Notification> getNotificationsByType(String notificationTypeId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationDao.search("from Notification where notificationTypeId = ? order by " + sorter + " " + sortingAttribute, new Object[] { notificationTypeId }, startIndex, rows);
	}
	
	public List<Notification> getNotificationsByTypeAndIssueRange(String notificationTypeId, String orgSN, String roleLabel, int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationDao.search("from Notification where notificationTypeId = ? and issueRange like ? and issueRange like ? and status = ? order by " + sorter + " " + sortingAttribute, new Object[] { notificationTypeId, orgSN, roleLabel, Notification.PUBLISHED }, startIndex, rows);
	}
	
	public List<Notification> getNotificationsByStatus(Integer status, int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationDao.search("from Notification where status = ? order by " + sorter + " " + sortingAttribute, new Object[] { status }, startIndex, rows);
	}
	
	public List<Notification> getNotificationsByTypeAndStatus(String notificationTypeId, Integer status, int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationDao.search("from Notification where notificationTypeId = ? and notificationStatus = ? order by " + sorter + " " + sortingAttribute, new Object[] { notificationTypeId, status }, startIndex, rows);
	}
	
	public List<Notification> getNotificationCachesByTypeAndStatus(String notificationTypeId, Integer status, int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationDao.search("from Notification where notificationTypeId = ? and notificationStatus = ? order by " + sorter + " " + sortingAttribute, new Object[] { notificationTypeId, status }, startIndex, rows);
	}
	
	public boolean removeNotification(String id) {
		notificationDao.executeHql("delete from Notification where id = ?", new Object[] { id });
		Long qty = notificationDao.count("select count(id) from Notification where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) {
			notificationImageService.removeImageByNotification(id);
			return true;
		}
		return false;
	}
	
	public boolean saveNotification(Notification notification) {
		String method = "";
		if ( notification.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			notification.setModifiedDate(new Date());
		}
		notificationDao.saveOrUpdate(notification);
		if ( method.equals("add") ) {
			if ( notification.getId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean saveNotificationStatus(String notificationId, Integer status) {
		Integer executedStatus = new Integer(0);
		if ( status.intValue() == Notification.PUBLISHED.intValue() ) {
			executedStatus = notificationDao.executeHql("update Notification set status = ?, publishedDate = ? where id = ?", new Object[] { status, new Date(), notificationId });
			if ( executedStatus.intValue() == 1 ) return true;
		}
		if ( status.intValue() == Notification.UNPUBLISHED.intValue() ) {
			executedStatus = notificationDao.executeHql("update Notification set status = ?, publishedDate = ? where id = ?", new Object[] { status, null, notificationId });
			if ( executedStatus.intValue() == 1 ) return true;
		}
		return false;
	}
	
	public boolean saveNotificationStatus(String[] notificationIds, Integer status) {
		for (String notificationId : notificationIds) {
			notificationDao.executeHql("update Notification set status = ? where id = ?", new Object[] { status, notificationId });
		}
		return true;
	}
	
	public void clearAllNotificationCache() {  }
	
}