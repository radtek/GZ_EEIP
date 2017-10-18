package org.pangolin.eeip.service.impl;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MessageTextDao;
import org.pangolin.eeip.entity.MessageText;
import org.pangolin.eeip.service.MessageService;
import org.pangolin.eeip.service.MessageTextService;
import org.springframework.stereotype.Service;

@Service("messageTextService")
@SuppressWarnings("all")
public class MessageTextServiceImpl implements MessageTextService {

	@Resource
	private  MessageTextDao messageTextDao;
	
	@Resource
	private MessageService messageService;
	
	public MessageText getMessageTextById(String messageTextId) {
		return messageTextDao.get(MessageText.class, messageTextId);
	}
	
	public boolean removeMessageText(String messageTextId) {
		Long msgQty = messageService.getMessageQtyByMessageText(messageTextId);
		if ( msgQty.intValue() == 0 ) {
			messageTextDao.executeHql("delete from MessageText where messageTextId = ?", new Object[] { messageTextId });
			Long qty = messageTextDao.count("select count(messageTextId) from MessageText where messageTextId = ?" , new Object[] { messageTextId });
			if ( qty.intValue() == 0 ) return true;
		}
		return false;
	}
	
	public boolean removeAllMessageText() {
		messageTextDao.executeHql("delete from MessageText", new Object[] {  });
		Long qty = messageTextDao.count("select count(messageTextId) from MessageText");
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveMessageText(MessageText messageText) {
		String method = "";
		if ( messageText.getMessageTextId() == null ) { method = "add"; }
		else { method = "update"; }
		messageTextDao.saveOrUpdate(messageText);
		if ( method.equals("add") ) {
			if ( messageText.getMessageTextId() != null ) return true;
		} else { return true; }
		return false;
	}
}