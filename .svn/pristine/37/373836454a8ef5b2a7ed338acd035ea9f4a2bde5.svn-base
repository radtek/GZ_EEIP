package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 问卷调查题目选项
 * @author Oscar Mok
 * */
@Entity
@Table(name = "t_survey_item")
public class QuestionItem extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -8326722127468635398L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 题目选项名称
	 * */
	@Column(name = "f_name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 题目选项值
	 * */
	@Column(name = "f_val", length = 100, nullable = false)
	private String value;
	
	/**
	 * 题目选项序号
	 * */
	@Column(name = "f_seq_no", length = 2, nullable = false)
	private Integer sequenceNumber = new Integer(1);
	
	/**
	 * 所属问卷调查题目ID
	 * */
	@Column(name = "fk_ques_id", length = 40, nullable = true)
	private String surveyQuesId;
	
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSurveyQuesId() {
		return surveyQuesId;
	}

	public void setSurveyQuesId(String surveyQuesId) {
		this.surveyQuesId = surveyQuesId;
	}

	public String getSurveySubjectId() {
		return surveySubjectId;
	}

	public void setSurveySubjectId(String surveySubjectId) {
		this.surveySubjectId = surveySubjectId;
	}
}