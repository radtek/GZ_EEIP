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
 * 文号使用情况  
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_archive_code")
public class ArchiveCode extends BaseEntity implements Serializable {
 
	private static final long serialVersionUID = 3311745205396456150L;

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	public String id;
	
	/**
	 * 机关代字
	 */
	@Column(name = "f_agency", length = 100, nullable = false)
	private String agency;
	
	/**
	 * 文件年份（格式：四位数字，如 2017）
	 */
	@Column(name = "f_year", length = 4, nullable = false)
	private String year;
	
	/**
	 * 文件号（最大四位数字，根据机关代字和年份自动累加）
	 */
	@Column(name = "f_sn", length = 4, nullable = false)
	private String sn;
	
	/**
	 * 电子物证（检材）鉴定ID
	 * */
	@Column(name = "fk_appraisal_id", length = 32 ,nullable = true)
	private String appraisalId;
	
	/**
	 * 文号类型ID
	 * */
	@Column(name = "fk_archive_type_id", length = 32 ,nullable = true)
	private String archiveTypeId;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	public ArchiveCode(){}
	
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

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public String getArchiveTypeId() {
		return archiveTypeId;
	}

	public void setArchiveTypeId(String archiveTypeId) {
		this.archiveTypeId = archiveTypeId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}  
	
}
