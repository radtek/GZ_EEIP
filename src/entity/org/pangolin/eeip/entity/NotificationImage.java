package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 消息图片实体类
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_notification_img")
public class NotificationImage extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 4707327374656160764L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 图片名称
	 * */
	@Column(name = "f_name", length = 200, nullable = false)
	private String name;
	
	/**
	 * 后缀名
	 * */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String extensions;
	
	/**
	 * 磁盘位置
	 * */
	@Type(type="text")
	@Column(name = "f_path", nullable = true)
	private String path;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 修改时间
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	/**
	 * 消息ID
	 * */
	@Column(name = "fk_note_id", length = 40, nullable = false)
	private String notificationId;
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
}