package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.pangolin.util.UUIDHexGenerator;

/***
 * 内部审核检查表细项
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_meeting_ia_inspection_item")
public class MeetingIaInspectionItem extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -7196681388048000959L;

	/**
	 * 审核结果- 符合
	 * */
	public static final Integer RESULT_CONFORM = new Integer(0);
	
	/**
	 * 审核结果 - 观察
	 * */
	public static final Integer RESULT_SURVEY = new Integer(1);
	
	/**
	 * 审核结果 - 不符合
	 * */
	public static final Integer RESULT_INCONFORMITY = new Integer(2);
	
	/**
	 * 审核结果 - 不适用
	 * */
	public static final Integer RESUTL_INAPPLICABILITY = new Integer(3);

	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/***
	 * 审核涉及要素
	 */
	@Column(name = "f_element", length = 200, nullable = false)
	private String element;
	
	/***
	 * 审核内容
	 */
	@Type(type = "text")
	@Column(name = "f_content", nullable = false)
	private String content;
	
	/***
	 * 审核方法
	 */
	@Column(name = "f_method", length = 200, nullable = false)
	private String method;
	
	/***
	 * 审核结果（0：符合，1：观察，2：不符合，3：不适用）
	 */
	@Column(name = "f_result", nullable = false)
	private Integer result;
	
	/***
	 * 结果说明
	 */
	@Column(name = "f_explanation", length = 200, nullable = false)
	private String explanation;
	
	/***
	 * 会议申请ID
	 */
	@Column(name = "fk_meeting_app_id", length = 32, nullable = false)
	private String meetingAppId;
	
	/***
	 * 内部审核检查表ID
	 */
	@Column(name = "fk_meeting_ia_inspection_id", length = 32, nullable = false)
	private String meetingIaInspectionId;
	
	public MeetingIaInspectionItem(){}
	
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

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}

	public String getMeetingIaInspectionId() {
		return meetingIaInspectionId;
	}

	public void setMeetingIaInspectionId(String meetingIaInspectionId) {
		this.meetingIaInspectionId = meetingIaInspectionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
