package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 问卷调查题目
 * @author Oscar Mok
 * */
@Entity
@Table(name = "t_survey_ques")
public class SurveyQuestion extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -1743814464219754932L;

	/**
	 * 单选题
	 * */
	public static final Integer SINGLE_CHOICE = new Integer(0);
	
	/**
	 * 多选题
	 * */
	public static final Integer MULTIPLE_CHOICE = new Integer(1);
	
	/**
	 * 文本项
	 * */
	public static final Integer TEXT_ITEM = new Integer(2);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 题目名称
	 * */
	@Column(name = "f_name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 题目序号
	 * */
	@Column(name = "f_seq_no", length = 2, nullable = false)
	private Integer sequenceNumber = new Integer(1);
	
	/**
	 * 题目类型
	 * */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer type = SurveyQuestion.SINGLE_CHOICE;
	
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
	 * 所属问卷调查主题ID
	 * */
	@Column(name = "fk_subject_id", length = 40, nullable = true)
	private String surveySubjectId;
	
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

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSurveySubjectId() {
		return surveySubjectId;
	}

	public void setSurveySubjectId(String surveySubjectId) {
		this.surveySubjectId = surveySubjectId;
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
}