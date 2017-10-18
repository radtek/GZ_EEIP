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
 * 设备使用情况表
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_dev_using_sitn")
public class DevUsingSitn extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6170969508211097892L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);

	/**
	 * 当前状态 - 正常   表设计的时候预留（0：闲置；1：使用中；）以后可能用现在用正常		
	 * */
	public static final Integer STATUS_NORMAL = new Integer(0);
	
	/**
	 * 当前状态 - 2：维修	
	 * */
	public static final Integer STATUS_MAINTAIN = new Integer(2);
	
	/**
	 * 当前状态 - 3：报废		
	 * */
	public static final Integer STATUS_SCRAP = new Integer(3);
	
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
	private Integer delFlag = DevUsingSitn.NORMAL;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate;
	
	/**
	 * 备注
	 * */
	@Column(name = "f_remarks" , length = 150, nullable = true)
	private String remarks;
	
	/**
	 * 使用开始时间			
	 * */
	@Column(name = "f_start_date" , nullable = true)
	private Date startDate;
	
	/**
	 * 使用结束时间		
	 * */
	@Column(name = "f_end_date" , nullable = true)
	private Date endDate;

	/**
	 *	检材编号或检测样品批号			
	 * */
	@Column(name = "f_evid_sn", length = 100, nullable = true)
	private String evidSn;
	
	/**
	 *	设备情况（与设备状态一致，记录鉴定过程使用仪器时的工作状态）		
	 * */
	@Column(name = "f_dev_status", length = 1, nullable = true)
	private Integer devStatus;
	
	/**
	 *	使用人ID		
	 * */
	@Column(name = "f_operator_id", length = 32, nullable = false)
	private String operatorId;
	
	/**
	 *	使用人帐号				
	 * */
	@Column(name = "f_operator_name", length = 50, nullable = false)
	private String operatorName;
	
	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;
	
	/**
	 * 检材ID（电子物证ID）	
	 * */
	@Column(name = "fk_evid_id", length = 32, nullable = true)
	private String evidId;
	
	/**
	 *	使用人姓名				
	 * */
	@Column(name = "f_operator_alias", length = 50, nullable = false)
	private String operatorAlias;

	public DevUsingSitn() {};

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getEvidSn() {
		return evidSn;
	}

	public void setEvidSn(String evidSn) {
		this.evidSn = evidSn;
	}

	public Integer getDevStatus() {
		return devStatus;
	}

	public void setDevStatus(Integer devStatus) {
		this.devStatus = devStatus;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorAlias() {
		return operatorAlias;
	}

	public void setOperatorAlias(String operatorAlias) {
		this.operatorAlias = operatorAlias;
	}

	public String getEvidId() {
		return evidId;
	}

	public void setEvidId(String evidId) {
		this.evidId = evidId;
	}
}
