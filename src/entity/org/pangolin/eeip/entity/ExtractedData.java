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
 * 提取电子数据清单
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_extracted_data")
public class ExtractedData extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8946822332624113240L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();

	/**
	 * 案由（由委托单位与案件名称组合而成，如：XXX单位的XXXX案）
	 */
	@Column(name = "f_cause", length = 200	, nullable = false)
	private String cause;
	
	/**
	 * （数据）提取时间
	 */
	@Column(name = "f_extracted_date", nullable = false)
	private Date extractedDate;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = ExtractedData.NORMAL;
	
	/**
	 * 电子物证（检材）鉴定ID
	 */
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;
	
	/**
	 * 电子物证预检信息ID
	 */
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;
	
	/**
	 * 电子物证（检材）鉴定历史记录ID
	 */
	@Column(name = "fk_appraisal_hist_id", length = 32, nullable = true)
	private String appraisalHistId;

	public ExtractedData(){}
    
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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getExtractedDate() {
		return extractedDate;
	}

	public void setExtractedDate(Date extractedDate) {
		this.extractedDate = extractedDate;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

	public String getAppraisalHistId() {
		return appraisalHistId;
	}

	public void setAppraisalHistId(String appraisalHistId) {
		this.appraisalHistId = appraisalHistId;
	}
	
}
	
