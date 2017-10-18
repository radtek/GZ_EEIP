package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "t_message_text")
public class MessageText extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2102781000926390631L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_msg_txt_id", length = 40, nullable = false)
	private String messageTextId;
	
	@Column(name = "f_msg_content" , nullable = true)
	@Type(type="text")
	private String messageContent;

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
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