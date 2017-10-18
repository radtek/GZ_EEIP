package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/***
 * 文档操作日志
 * @author Tinggui Zhu
 *
 */
@Entity
@Table(name = "t_doc_op_log")
public class DocOpLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 2510524577494566898L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/***
	 * 日志类型- 新增
	 */
	public static final Integer ADD = new Integer(0);
	
	/***
	 * 日志类型- 修改
	 */
	public static final Integer MODIFY = new Integer(1);
	
	/***
	 * 日志类型- 删除
	 */
	public static final Integer REMOVE = new Integer(2);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 事件内容
	 * 新增事件格式：Add document XXX successfully
	 * 修改事件格式：Modify document XXX successfully
	 * 删除事件格式：Remove document XXX successfully
	 */
	@Column(name = "f_event", length = 200, nullable = false)
	private String event;
	
	/***
	 * 操作时间
	 */
	@Column(name = "f_event_date", nullable = false)
	private Date eventDate;
	
	/***
	 * 日志类型
	 */
	@Column(name = "f_type", nullable = false)
	private Integer type = DirOpLog.ADD;
	
	/***
	 * 操作者ID
	 */
	@Column(name = "f_operator_id", length = 32, nullable = false)
	private String operatorId;
	
	/***
	 * 操作者账号
	 */
	@Column(name = "f_operator_name", length = 50, nullable = false)
	private String operator;
	
	/***
	 * 操作者姓名
	 */
	@Column(name = "f_operator_alias", length = 50, nullable = false)
	private String operatorAlias;
	
	/***
	 * 操作者IP地址
	 */
	@Column(name = "f_operator_ip_addr", length = 50, nullable = false)
	private String operatorIpAddr;
	
	/***
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = DocOpLog.NORMAL;
	
	/***
	 * 文件ID
	 * 删除日志不需要关联对应的文件ID
	 */
	@Column(name = "fk_doc_id", length = 32, nullable = true)
	private String documentId;
	
	/***
	 * 文件历史记录ID
	 */
	@Column(name = "fk_doc_hist_id", length = 32, nullable = true)
	private String docHistId;
	
	public DocOpLog(){  }
	
	// getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatorAlias() {
		return operatorAlias;
	}

	public void setOperatorAlias(String operatorAlias) {
		this.operatorAlias = operatorAlias;
	}

	public String getOperatorIpAddr() {
		return operatorIpAddr;
	}

	public void setOperatorIpAddr(String operatorIpAddr) {
		this.operatorIpAddr = operatorIpAddr;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocHistId() {
		return docHistId;
	}

	public void setDocHistId(String docHistId) {
		this.docHistId = docHistId;
	}
	
	
}