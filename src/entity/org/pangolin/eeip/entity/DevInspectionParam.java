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
 * 期间核查项目及参数 
 * @author JinRuiWang
 *
 */
@Entity
@Table(name = "t_dev_inspection_param")
public class DevInspectionParam extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 6436108471195093037L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 单项核查结果 - 正常
	 * */
	public static final Integer RESULT_NORMAL = new Integer(0);
	
	/**
	 * 单项核查结果 - 异常
	 * */
	public static final Integer RESULT_ABNORMAL = new Integer(1);
	
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
	private Integer delFlag = DevInspectionParam.NORMAL;

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
	 * 设备期间核查情况记录ID	
	 * */
	@Column(name = "fk_dev_inspection_id", length = 32, nullable = false)
	private String devInspectionId;
	
	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;
	
	/**
	 * 核查项目	
	 * */
	@Column(name = "f_item", length = 150, nullable = false)
	private String item;
	
	/**
	 * 标准参数	
	 * */
	@Column(name = "f_standard_param", length = 150, nullable = false)
	private String standardParam;
	
	/**
	 * 核查参数	
	 * */
	@Column(name = "f_inspecting_param", length = 150, nullable = true)
	private String inspectingParam;
	
	/**
	 * 单项核查结果（0：正常；1：异常）	
	 * */
	@Column(name = "f_result", length = 1, nullable = true)
	private Integer result;
	
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	public String getDevInspectionId() {
		return devInspectionId;
	}

	public void setDevInspectionId(String devInspectionId) {
		this.devInspectionId = devInspectionId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getStandardParam() {
		return standardParam;
	}

	public void setStandardParam(String standardParam) {
		this.standardParam = standardParam;
	}

	public String getInspectingParam() {
		return inspectingParam;
	}

	public void setInspectingParam(String inspectingParam) {
		this.inspectingParam = inspectingParam;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
	
	
	

}
