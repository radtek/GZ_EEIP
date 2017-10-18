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
 * 仪器设备核查/校准/维修申请表
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_dev_adj_plan_item")
public class DevAdjPlanItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6820277209592346490L;

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
	public String id;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = DevAdjPlanItem.NORMAL;

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
	 * 检查/校准方式	
	 * */
	@Column(name = "f_method", length = 150, nullable = true)
	private String method;
	
	/**
	 * 检查时间		
	 * */
	@Column(name = "f_inspected_date", nullable = true)
	private Date inspectedDate;

	/**
	 * 负责人（设备对应的管理人）ID	
	 * */
	@Column(name = "f_principal_id", length = 32, nullable = true)
	private String principalId;
	
	/**
	 * 负责人（设备对应的管理人）帐号		
	 * */
	@Column(name = "f_principal_name", length = 50, nullable = true)
	private String principalName;
	
	/**
	 * 负责人（设备对应的管理人）姓名	
	 * */
	@Column(name = "f_principal_alias", length = 50, nullable = true)
	private String principalAlias;
	
	/**
	 * 仪器设备期间核查/校准计划ID			
	 * */
	@Column(name = "fk_dev_adj_plan_id", length = 32, nullable = false)
	private String devAdjPlanId;
	
	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;

	public DevAdjPlanItem() {};
	
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getInspectedDate() {
		return inspectedDate;
	}

	public void setInspectedDate(Date inspectedDate) {
		this.inspectedDate = inspectedDate;
	}

	public String getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(String principalId) {
		this.principalId = principalId;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getPrincipalAlias() {
		return principalAlias;
	}

	public void setPrincipalAlias(String principalAlias) {
		this.principalAlias = principalAlias;
	}

	public String getDevAdjPlanId() {
		return devAdjPlanId;
	}

	public void setDevAdjPlanId(String devAdjPlanId) {
		this.devAdjPlanId = devAdjPlanId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
