package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MessageDao;
import org.pangolin.eeip.entity.Message;
import org.pangolin.eeip.service.MessageService;
import org.pangolin.eeip.service.MessageTextService;
import org.springframework.stereotype.Service;

@Service("messageService")
@SuppressWarnings("all")
public class MessageServiceImpl implements MessageService {

	@Resource
	private  MessageDao messageDao;
	
	@Resource
	private MessageTextService messageTextService;
	
	public Message getMessageById(String messageId) {
		return messageDao.get(Message.class, messageId);
	}
	
	public Long getMessageQty() {
		return messageDao.count("select count(messageId) from Message");
	}
	
	public Long getMessageQtyByMessageText(String messageTextId) {
		return messageDao.count("select count(messageId) from Message where messageTextId = ?", new Object[] { messageTextId });
	}
	
	public Long getMessageQtyBySender(String senderId) {
		return messageDao.count("select count(messageId) from Message where senderId = ?", new Object[] { senderId });
	}
	
	public Long getMessageQtyByReceiver(String receiverId) {
		return messageDao.count("select count(messageId) from Message where receiverId = ?", new Object[] { receiverId });
	}
	
	public List<Message> getMessages() {
		return messageDao.find("from Message order by sendMessageDate desc");
	}
	
	public List<Message> getMessagesBySender(String senderId) {
		return messageDao.find("from Message where senderId = ? order by sendMessageDate desc", new Object[] { senderId });
	}
	
	public List<Message> getMessagesByReceiver(String receiverId) {
		return messageDao.find("from Message where receiverId = ? order by sendMessageDate desc", new Object[] { receiverId });
	}
	
	public List<Message> getMessages(int startIndex, int rows, String sorter, String sortingAttribute) {
		return messageDao.search("from Message order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<Message> getMessagesBySender(String senderId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return messageDao.search("from Message where senderId = ? order by " + sorter + " " + sortingAttribute, new Object[] { senderId }, startIndex, rows);
	}
	
	public List<Message> getMessagesByReceiver(String receiverId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return messageDao.search("from Message where receiverId = ? order by " + sorter + " " + sortingAttribute, new Object[] { receiverId }, startIndex, rows);
	}
	
	public boolean removeMessage(String messageId) {
		messageDao.executeHql("delete from Message where messageId = ?", new Object[] { messageId });
		Long qty = messageDao.count("select count(messageId) from Message where messageId = ?" , new Object[] { messageId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeMessage(String[] messageIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String messageId : messageIds) {
			messageDao.executeHql("delete from Message where messageId = ?", new Object[] { messageId });
			qty = messageDao.count("select count(messageId) from Message where messageId = ?" , new Object[] { messageId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == messageIds.length ) return true;
		return false;
	}
	
	public boolean removeAllMessage() {
		boolean status = false;
		messageDao.executeHql("delete from Message", new Object[] {  });
		Long qty = getMessageQty();
		if ( qty.intValue() == 0 ) status = true;
		if ( status ) {
			status = messageTextService.removeAllMessageText();
		}
		return status;
	}
	
	public boolean saveMessage(Message message) {
		String method = "";
		if ( message.getMessageId() == null ) { method = "add"; }
		else { method = "update"; }
		messageDao.saveOrUpdate(message);
		if ( method.equals("add") ) {
			if ( message.getMessageId() != null ) return true;
		} else { return true; }
		return false;
	}
}