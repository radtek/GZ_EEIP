package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 会议室管理
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_appraisal_sitn")
public class AppraisalSitn extends BaseEntity implements Serializable{
 
	private static final long serialVersionUID = -1301976607313422876L;

	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 鉴定人ID
	 */
	@Column(name = "f_appraiser_id", length = 32, nullable = false)
	private String appraiserId;
	
	/***
	 * 电子物证（检材）鉴定ID
	 */
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;

	public AppraisalSitn(){}
	
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

	public String getAppraiserId() {
		return appraiserId;
	}

	public void setAppraiserId(String appraiserId) {
		this.appraiserId = appraiserId;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}
	
}
