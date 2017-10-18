package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.MessageDao;
import org.pangolin.eeip.entity.Message;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
@SuppressWarnings("all")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {
	
}