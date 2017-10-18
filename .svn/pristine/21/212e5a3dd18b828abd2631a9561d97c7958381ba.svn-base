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
 * 电子物证（检材）鉴定设备
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_appraised_dev")
public class AppraisedDev extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3743007143736801046L;
	
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
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = AppraisedDev.NORMAL;
	
	/**
	 * 设备使用开始时间
	 */
	@Column(name = "f_start_date", nullable = true)
	private Date startDate;
	
	/**
	 * 设备使用结束时间
	 */
	@Column(name = "f_end_date", nullable = true)
	private Date endDate;
	
	/**
	 * 备注
	 */
	@Column(name = "f_remarks", length = 200, nullable = true)
	private String remarks;
	
	/**
	 * 鉴定人ID
	 */
	@Column(name = "f_appraiser_id", length = 32, nullable = true)
	private String appraiserId;
	
	/**
	 * 电子物证（检材）鉴定历史记录ID
	 */
	@Column(name = "fk_appraisal_hist_id", length = 32, nullable = true)
	private String appraisalHistId;
	
	/**
	 * 设备ID（对应设备管理的设备信息ID）
	 */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;
	
	/**
	 * 电子物证（检材）鉴定ID
	 */
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;

	public AppraisedDev() {}
	
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAppraiserId() {
		return appraiserId;
	}

	public void setAppraiserId(String appraiserId) {
		this.appraiserId = appraiserId;
	}

	public String getAppraisalHistId() {
		return appraisalHistId;
	}

	public void setAppraisalHistId(String appraisalHistId) {
		this.appraisalHistId = appraisalHistId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}
}