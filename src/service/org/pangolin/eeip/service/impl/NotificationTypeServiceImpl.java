package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.NotificationTypeDao;
import org.pangolin.eeip.entity.NotificationType;
import org.pangolin.eeip.service.NotificationTypeService;
import org.springframework.stereotype.Service;

@Service("notificationTypeService")
@SuppressWarnings("all")
public class NotificationTypeServiceImpl implements NotificationTypeService {

	@Resource
	private  NotificationTypeDao notificationTypeDao;
	
	public NotificationType getNotificationTypeById(String id) {
		return notificationTypeDao.get(NotificationType.class, id);
	}
	
	public NotificationType getNotificationTypeByLabel(String label) {
		NotificationType notificationType = null;
		List<NotificationType> notificationTypeList = 
				notificationTypeDao.find("from NotificationType where label = ?", new Object[] { label });
		if ( notificationTypeList != null && notificationTypeList.size() > 0 ) notificationType = notificationTypeList.get(0);
		return notificationType;
	}
	
	public Long getNotificationTypeQty() {
		return notificationTypeDao.count("select count(id) from NotificationType");
	}
	
	public List<NotificationType> getNotificationTypies() {
		return notificationTypeDao.find("from NotificationType order by createdDate desc");
	}
	
	public List<NotificationType> getRootNotificationTypies() {
		return notificationTypeDao.find("from NotificationType where parentNoteTypeId is null order by createdDate desc");
	}
	
	public List<NotificationType> getNotificationTypiesByParentType(String parentNoteTypeId) {
		return notificationTypeDao.find("from NotificationType where parentNoteTypeId = ? order by createdDate desc", new Object[] { parentNoteTypeId });
	}
	
	public List<NotificationType> getNotificationTypies(int startIndex, int rows, String sorter, String sortingAttribute) {
		return notificationTypeDao.search("from NotificationType order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public boolean removeNotificationType(String id) {
		notificationTypeDao.executeHql("delete from NotificationType where id = ?", new Object[] { id });
		Long qty = notificationTypeDao.count("select count(id) from NotificationType where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveNotificationType(NotificationType notificationType) {
		if ( notificationType != null ) {
			String method = "";
			if ( notificationType.getId() == null ) { method = "add"; }
			else { method = "update"; }
			notificationTypeDao.saveOrUpdate(notificationType);
			if ( method.equals("add") ) {
				if ( notificationType.getId() != null ) return true;
			} else { return true; }
		}
		return false;
	}
	
	public boolean existNotificationType(String label) {
		NotificationType notificationType = getNotificationTypeByLabel(label);
		if ( notificationType != null ) return true;
		return false;
	}
}