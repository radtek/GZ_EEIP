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
 * 软件升级表
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_dev_sw_upgrade")
public class DevSwUpgrade extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6293698156592182549L;

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
	private Integer delFlag = DevSwUpgrade.NORMAL;

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
	 * 软件名称	
	 * */
	@Column(name = "f_software_name", length = 150, nullable = true)
	private String softwareName;
	
	/**
	 * 原版本号	
	 * */
	@Column(name = "f_original_ver", length = 150, nullable = true)
	private String originalVer;
	
	/**
	 * 升级版本号	
	 * */
	@Column(name = "f_new_ver", length = 150, nullable = true)
	private String newVer;
	
	/**
	 * 升级完成时间
	 * */
	@Column(name = "f_finished_date", nullable = true)
	private Date finishedDate;

	/**
	 * 操作人ID		
	 * */
	@Column(name = "f_operator_id", length = 32, nullable = true)
	private String operatorId;
	
	/**
	 * 操作人账号		
	 * */
	@Column(name = "f_operator_name", length = 50, nullable = true)
	private String operatorName;
	
	/**
	 * 操作人姓名	
	 * */
	@Column(name = "f_operator_alias", length = 50, nullable = true)
	private String operatorAlias;
	
	/**
	 * 备注
	 * */
	@Column(name = "f_remarks" ,length = 150, nullable = true)
	private String remarks;

	public DevSwUpgrade() {};

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

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getOriginalVer() {
		return originalVer;
	}

	public void setOriginalVer(String originalVer) {
		this.originalVer = originalVer;
	}

	public String getNewVer() {
		return newVer;
	}

	public void setNewVer(String newVer) {
		this.newVer = newVer;
	}

	public Date getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
