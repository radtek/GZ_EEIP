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
import org.pangolin.util.UUIDHexGenerator;

/**
 * 中止鉴定告知书  
 * @author JinRui Wang
 */
@Entity
@Table(name = "t_termination_notice")
public class TerminationNotice extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7973013616747451067L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 40, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/**
	 * 机关代字		
	 **/
	@Column(name = "f_agency", length = 100, nullable = true)
	private String agency ;
	
	/**
	 * 文件年份		
	 **/
	@Column(name = "f_year", length = 4, nullable = true)
	private String year;
	
	/**
	 * 文件号			
	 **/
	@Column(name = "f_sn", length = 5, nullable = true)
	private String sn;
	
	/**
	 * 不予受理 - 条	
	 **/
	@Column(name = "f_article", length = 50, nullable = false)
	private String article;
	
	/**
	 * 不予受理 - 款	
	 **/
	@Column(name = "f_paragraph", length = 50, nullable = false)
	private String paragraph;
	
	/**
	 * 不予受理 - 理由	
	 **/
	@Column(name = "f_reason", length = 200, nullable = false)
	private String reason;
	
	/**
	 * 创建人（填表人，即受理人）ID	
	 **/
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 创建人（填表人，即受理人）帐号		
	 **/
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建人（填表人，即受理人）姓名	
	 **/
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 电子物证（检材）鉴定ID	
	 **/
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;
	
	/**
	 * 电子物证预检信息ID		
	 **/
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;
	
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

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorAlias() {
		return creatorAlias;
	}

	public void setCreatorAlias(String creatorAlias) {
		this.creatorAlias = creatorAlias;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}
}