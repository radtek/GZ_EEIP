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
 * 设备期间核查情况记录表
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_dev_inspection")
public class DevInspection extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 7271662430305307133L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 工作状态 - 正常；
	 * */
	public static final Integer WORK_STATUS_NORMAL = new Integer(0);
	
	/**
	 * 工作状态 - 异常；
	 * */
	public static final Integer WORK_STATUS_ABNORMAL = new Integer(1);
	
	/**
	 * 核查结果 - 正常；
	 * */
	public static final Integer RESULT_NORMAL = new Integer(0);
	
	/**
	 * 核查结果 - 异常；
	 * */
	public static final Integer RESULT_ABNORMAL = new Integer(1);
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	public String id;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = DevInspection.NORMAL;

	/**
	 * 创建者帐号
	 * */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者别名（姓名）
	 * */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate;
	
	/**
	 * 创建者ID
	 * */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;
	
	/**
	 * 工作状态（0：正常；1：异常）	
	 * */
	@Column(name = "f_status", length = 1, nullable = true)
	private Integer status;
	
	/**
	 * 核查日期
	 * */
	@Column(name = "f_inspected_date", nullable = true)
	private Date inspectedDate;
	
	/**
	 * 下次核查时间			
	 * */
	@Column(name = "f_next_inspected_date", nullable = true)
	private Date nextInspectedDate;

	/**
	 * 核查周期	
	 * */
	@Column(name = "f_cycle", length = 150, nullable = true)
	private String cycle;
	
	/**
	 * 本次核查结果		
	 * */
	@Column(name = "f_result", length = 1, nullable = true)
	private Integer result;
	
	/**
	 * 备注	
	 * */
	@Column(name = "f_remarks", length = 150, nullable = true)
	private String remarks;
	
	/**
	 * 核查人ID
	 * */
	@Column(name = "f_inspector_id", length = 32, nullable = true)
	private String inspectorId;
	
	/**
	 * 核查人帐号		
	 * */
	@Column(name = "f_inspector_name", length = 50, nullable = true)
	private String inspectorName;
	
	/**
	 * 核查人姓名		
	 * */
	@Column(name = "f_inspector_alias", length = 50, nullable = true)
	private String inspectorAlias;

	public DevInspection() {};

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getInspectedDate() {
		return inspectedDate;
	}

	public void setInspectedDate(Date inspectedDate) {
		this.inspectedDate = inspectedDate;
	}

	public Date getNextInspectedDate() {
		return nextInspectedDate;
	}

	public void setNextInspectedDate(Date nextInspectedDate) {
		this.nextInspectedDate = nextInspectedDate;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getInspectorId() {
		return inspectorId;
	}

	public void setInspectorId(String inspectorId) {
		this.inspectorId = inspectorId;
	}

	public String getInspectorName() {
		return inspectorName;
	}

	public void setInspectorName(String inspectorName) {
		this.inspectorName = inspectorName;
	}

	public String getInspectorAlias() {
		return inspectorAlias;
	}

	public void setInspectorAlias(String inspectorAlias) {
		this.inspectorAlias = inspectorAlias;
	}
	
	

}
