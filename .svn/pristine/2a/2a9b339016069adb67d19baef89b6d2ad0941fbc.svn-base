package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_message")
public class Message extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -7499340721363434022L;
	
	//Type of Message
	/** Explanation: 
	 * 1. Private Message: one to one
	 * 2. Public Message: one to group/role
	 * 3. System Message: one to all
	 * */
	public static final Integer PRIVATE_MSG = new Integer(0); //Private Message
	public static final Integer PUBLIC_MSG = new Integer(1); //Public Message
	public static final Integer GLOBAL_MSG = new Integer(2); //System Message
	
	//Delete Status
	public static final Integer NORMAL = new Integer(0);
	public static final Integer RECYCLED = new Integer(1);
	public static final Integer DELETED = new Integer(2);
	
	//Read Status
	public static final Integer UNREAD = new Integer(0);
	public static final Integer READ = new Integer(1);
	
	public static final String SYSTEM_SENDER_NAME = "System";
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_msg_id", length = 40, nullable = false)
	private String messageId;
	
	@Column(name = "f_sender_id", length = 40, nullable = true)
	private String senderId;
	
	@Column(name = "f_sender_name", length = 150, nullable = true)
	private String senderName;
	
	@Column(name = "f_receiver_id", length = 40, nullable = true)
	private String receiverId;
	
	@Column(name = "f_receiver_name", length = 150, nullable = true)
	private String receiverName;
	
	@Column(name = "f_read_msg_date", nullable = true)
	private Date readMessageDate;
	
	@Column(name = "f_send_msg_date", nullable = true)
	private Date sendMessageDate;
	
	@Column(name = "f_read_status", length = 1, nullable = false)
	private Integer readStatus = Message.UNREAD;
	
	@Column(name = "f_del_Status", length = 1, nullable = false)
	private Integer deleteStatus = Message.NORMAL;
	
	@Column(name = "f_msg_type", length = 1, nullable = false)
	private Integer messageType = Message.PRIVATE_MSG;
	
	@Column(name = "fk_msg_txt_id", length = 40, nullable = false)
	private String messageTextId;
	
	@Transient
	private String messageContent;
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Date getReadMessageDate() {
		return readMessageDate;
	}

	public void setReadMessageDate(Date readMessageDate) {
		this.readMessageDate = readMessageDate;
	}

	public Date getSendMessageDate() {
		return sendMessageDate;
	}

	public void setSendMessageDate(Date sendMessageDate) {
		this.sendMessageDate = sendMessageDate;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getMessageTextId() {
		return messageTextId;
	}

	public void setMessageTextId(String messageTextId) {
		this.messageTextId = messageTextId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}