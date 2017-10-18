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
 * 设备管理表
 * @author JinRuiWang
 *
 */
@Entity
@Table(name = "t_device")
public class Device extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 8833067079741842756L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 维护方式 - 合同维护保养；
	 * */
	public static final Integer MAINTMETHOD_CONTRACT = new Integer(0);
	
	/**
	 * 维护方式 - 自行维护保养；
	 * */
	public static final Integer MAINTMETHOD_ONESELF = new Integer(1);
	
	/**
	 * 接收时状态 - 全新	
	 * */
	public static final Integer RECEIVINGSTATUS_NEW = new Integer(0);
	
	/**
	 * 接收时状态 - 成旧
	 * */
	public static final Integer RECEIVINGSTATUS_OLD = new Integer(1);
	
	/**
	 * 接收时状态 - 经过改装	
	 * */
	public static final Integer RECEIVINGSTATUS_REFIT = new Integer(2);
	
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
	 * 校准/检定/验证方式 - 合同校准/检定；
	 * */
	public static final Integer VERIFICATIONMETHOD_CONTRACT = new Integer(0);
	
	/**
	 * 校准/检定/验证方式 - 自行校准/验证
	 * */
	public static final Integer VERIFICATIONMETHOD_ONSELF = new Integer(1);
	
	/**
	 * 设备来源（0：内部；1：外借）
	 * */
	public static final Integer SOURCE_INTERIOR = new Integer(0);
	
	/**
	 * 设备来源（0：内部；1：外借）
	 * */
	public static final Integer SOURCE_LEND_OUT = new Integer(1);
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = Device.NORMAL;

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
	 * 设备识别号（实验室仪器编号）
	 * */
	@Column(name = "f_identifier", length = 100, nullable = false)
	private String identifier;
	
	/**
	 * 仪器设备名称
	 * */
	@Column(name = "f_name", length = 200, nullable = false)
	private String name;
	
	/**
	 * 制造商名称 （MFR = Manufacturer）	
	 * */
	@Column(name = "f_mfr_name", length = 100, nullable = true)
	private String mfrName;
	
	/**
	 * 型号/规格	
	 * */
	@Column(name = "f_model", length = 100, nullable = true)
	private String model;
	
	/**
	 * 出厂编号
	 * */
	@Column(name = "f_sn", length = 100, nullable = true)
	private String sn;
	
	/**
	 * 接收时状态（0：全新；1：成旧；2：经过改装）		
	 * */
	@Column(name = "f_receiving_status", length = 1, nullable = true)
	private Integer receivingStatus;
	
	/**
	 * 接收日期		
	 * */
	@Column(name = "f_receiving_date", nullable = true)
	private Date receivingDate;
	
	/**
	 * 启用日期			
	 * */
	@Column(name = "f_using_date", nullable = true)
	private Date usingDate;

	/**
	 * 目前存放地点		
	 * */
	@Column(name = "f_location", length = 150, nullable = true)
	private String location;

	/**
	 * 初次检定时间		
	 * */
	@Column(name = "f_checking_date", nullable = true)
	private Date checkingDate;

	/**
	 * 检定周期	
	 * */
	@Column(name = "f_checking_cycle", length = 150, nullable = true)
	private String checkingCycle;
	
	/**
	 * 使用技术组	
	 * */
	@Column(name = "f_tech_group", length = 150, nullable = true)
	private String techGroup;
	
	/**
	 * 管理人ID
	 * */
	@Column(name = "f_manager_id", length = 32, nullable = true)
	private String managerId;
	
	/**
	 * 管理人帐号
	 * */
	@Column(name = "f_manager_name", length = 50, nullable = true)
	private String managerName;
	
	/**
	 * 管理人姓名
	 * */
	@Column(name = "f_manager_alias", length = 50, nullable = true)
	private String managerAlias;
	
	/**
	 * 维护方式（0：合同维护保养；1：自行维护保养）
	 * */
	@Column(name = "f_maint_method", length = 1, nullable = true)
	private Integer maintMethod;

	/**
	 * 校准/检定/验证方式（0：合同校准/检定；1：自行校准/验证）
	 * */
	@Column(name = "f_verification_method", length = 1, nullable = true)
	private Integer verificationMethod;
	
	/**
	 * 当前状态（0：闲置；1：使用中；2：维修；3：报废）	
	 * */
	@Column(name = "f_status", length = 1, nullable = true)
	private Integer status;
	
	/**
	 * 设备来源（0：内部；1：外借）
	 * */
	@Column(name = "f_source", length = 1, nullable = false)
	private Integer source;
	
	/**
	 * 修改时间	
	 * */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	public Device() {};

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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMfrName() {
		return mfrName;
	}

	public void setMfrName(String mfrName) {
		this.mfrName = mfrName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getReceivingStatus() {
		return receivingStatus;
	}

	public void setReceivingStatus(Integer receivingStatus) {
		this.receivingStatus = receivingStatus;
	}

	public Date getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
	}

	public Date getUsingDate() {
		return usingDate;
	}

	public void setUsingDate(Date usingDate) {
		this.usingDate = usingDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCheckingDate() {
		return checkingDate;
	}

	public void setCheckingDate(Date checkingDate) {
		this.checkingDate = checkingDate;
	}

	public String getCheckingCycle() {
		return checkingCycle;
	}

	public void setCheckingCycle(String checkingCycle) {
		this.checkingCycle = checkingCycle;
	}

	public String getTechGroup() {
		return techGroup;
	}

	public void setTechGroup(String techGroup) {
		this.techGroup = techGroup;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerAlias() {
		return managerAlias;
	}

	public void setManagerAlias(String managerAlias) {
		this.managerAlias = managerAlias;
	}

	public Integer getMaintMethod() {
		return maintMethod;
	}

	public void setMaintMethod(Integer maintMethod) {
		this.maintMethod = maintMethod;
	}

	public Integer getVerificationMethod() {
		return verificationMethod;
	}

	public void setVerificationMethod(Integer verificationMethod) {
		this.verificationMethod = verificationMethod;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	

}
