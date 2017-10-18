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
 * 问卷调查结果
 * @author Oscar Mok
 * */
@Entity
@Table(name = "t_survey_result")
public class SurveyResult extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -8807632680452630803L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id;
	
	/**
	 * 调查对象ID
	 * */
	@Column(name = "f_respondent_id", length = 40, nullable = false)
	private String respondentId;
	
	/**
	 * 调查对象帐户
	 * */
	@Column(name = "f_respondent_name", length = 100, nullable = false)
	private String respondentName;
	
	/**
	 * 调查对象姓名
	 * */
	@Column(name = "f_respondent_alias", length = 100, nullable = false)
	private String respondentAlias;
	
	/**
	 * 调查作答结果
	 * 存储格式为：[{ "id" : "id01", "question" : "question_title_01", "type" : "1", "answer" : "100" },{ "id" : "id02", "question" : "question_title_02", "type" : "0", "answer" : "200,300" }]
	 * */
	@Type(type="text")
	@Column(name = "f_result", nullable = true)
	private String result;
	
	/**
	 * 问卷调查提交时间
	 * */
	@Column(name = "f_submitted_date", nullable = false)
	private Date submittedDate = new Date();
	
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

	public String getRespondentId() {
		return respondentId;
	}

	public void setRespondentId(String respondentId) {
		this.respondentId = respondentId;
	}

	public String getRespondentName() {
		return respondentName;
	}

	public void setRespondentName(String respondentName) {
		this.respondentName = respondentName;
	}

	public String getRespondentAlias() {
		return respondentAlias;
	}

	public void setRespondentAlias(String respondentAlias) {
		this.respondentAlias = respondentAlias;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSurveySubjectId() {
		return surveySubjectId;
	}

	public void setSurveySubjectId(String surveySubjectId) {
		this.surveySubjectId = surveySubjectId;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}
}