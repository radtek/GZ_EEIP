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
 *电子物证日志表（物证出入库记录）
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_evidence")
public class Evidence extends BaseEntity implements Serializable {

 
	private static final long serialVersionUID = -6282692095155935220L;
	
	
	/**
	 * 检材状态 - 在库
	 * */
	public static final Integer INSIDE = new Integer(0);
	
	/**
	 * 检材状态 - 出库
	 * */
	public static final Integer OUTSIDE  = new Integer(1);
	 
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 物证名称
	 */
	@Column(name = "f_name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 物证编号
	 */
	@Column(name = "f_sn", length = 100, nullable = false)
	private String sn;
	
	/**
	 * 案件名称
	 */
	@Column(name = "f_case_name", length = 100, nullable = false)
	private String caseName;
	
	/**
	 * 案件编号
	 */
	@Column(name = "f_case_sn", length = 100, nullable = false)
	private String caseSn;
	
	/**
	 * 物证状态（在库，出库）
	 */
	@Column(name = "f_status", nullable = false)
	private Integer status = Evidence.INSIDE;;
	
	/**
	 * 物证存放位置
	 */
	@Column(name = "f_location", length = 100, nullable = false)
	private String location;
	
	/**
	 * 文书存放位置
	 */
	@Column(name = "f_doc_location", length = 100, nullable = true)
	private String docLocation;

	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate=new Date();
	
	/**
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;
	
	/**
	 * 创建者ID
	 */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 创建者账号
	 */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者姓名
	 */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 电子物证类型ID
	 **/
	@Column(name = "fk_evid_type_id", length = 32, nullable = true)
	private String evidTypeId;
	
	/**
	 * 电子物证（检材）鉴定ID
	 **/
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;
	 
	/**
	 * 电子物证（检材）鉴定ID
	 **/
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;
	 
	 
	public Evidence(){};
	
	public Evidence(String id){
		this.id = id;
	}
	
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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCaseName() {
		return caseName;
	}
  
	public String getCaseSn() {
		return caseSn;
	}

	public void setCaseSn(String caseSn) {
		this.caseSn = caseSn;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	} 
	 
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getEvidTypeId() {
		return evidTypeId;
	}

	public void setEvidTypeId(String evidTypeId) {
		this.evidTypeId = evidTypeId;
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

	public String getDocLocation() {
		return docLocation;
	}

	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	} 
	
}