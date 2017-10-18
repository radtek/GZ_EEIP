package org.pangolin.eeip.service;

import org.pangolin.eeip.entity.MessageText;

public interface MessageTextService {
	
	public MessageText getMessageTextById(String messageTextId);
	
	public boolean removeMessageText(String messageTextId);
	
	public boolean removeAllMessageText();
	
	public boolean saveMessageText(MessageText messageText);
	
}