package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.NotificationImageDao;
import org.pangolin.eeip.entity.NotificationImage;
import org.pangolin.eeip.service.NotificationImageService;
import org.springframework.stereotype.Service;

@Service("notificationImageService")
@SuppressWarnings("all")
public class NotificationImageServiceImpl implements NotificationImageService {

	@Resource
	private  NotificationImageDao notificationImageDao;
	
	public NotificationImage getNotificationImageById(String id) {
		return notificationImageDao.get(NotificationImage.class, id);
	}
	
	public List<NotificationImage> getImagesByNotification(String notificationId) {
		return notificationImageDao.find("from NotificationImage "
				+ "where notificationId = ? order by createdDate desc", new Object[] { notificationId });
	}
	
	public boolean saveNotificationImage(NotificationImage notificationImage) {
		String method = "";
		if ( notificationImage.getId() == null ) { method = "add"; }
		else { method = "update"; }
		notificationImageDao.saveOrUpdate(notificationImage);
		if ( method.equals("add") ) {
			if ( notificationImage.getId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean removeNotificationImage(String id) {
		notificationImageDao.executeHql("delete from NotificationImage where id = ?", new Object[] { id });
		Long qty = notificationImageDao.count("select count(id) from NotificationImage where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeImageByNotification(String notificationId) {
		notificationImageDao.executeHql("delete from NotificationImage where notificationId = ?", new Object[] { notificationId });
		Long qty = notificationImageDao.count("select count(id) from NotificationImage where notificationId = ?" , new Object[] { notificationId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
}