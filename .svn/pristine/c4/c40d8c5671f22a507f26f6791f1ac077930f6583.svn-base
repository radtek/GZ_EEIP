package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Message;

public interface MessageService {
	
	public Message getMessageById(String messageId);
	
	public Long getMessageQty();
	
	public Long getMessageQtyByMessageText(String messageTextId);
	
	public Long getMessageQtyBySender(String senderId);
	
	public Long getMessageQtyByReceiver(String receiverId);
	
	public List<Message> getMessages();
	
	public List<Message> getMessagesBySender(String senderId);
	
	public List<Message> getMessagesByReceiver(String receiverId);
	
	public List<Message> getMessages(int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<Message> getMessagesBySender(String senderId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<Message> getMessagesByReceiver(String receiverId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public boolean removeMessage(String messageId);
	
	public boolean removeMessage(String[] messageIds);
	
	public boolean removeAllMessage();
	
	public boolean saveMessage(Message message);
	
}