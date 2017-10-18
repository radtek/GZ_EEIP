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
 * @author zhanghong
 */
@Entity
@Table(name = "t_evid_op_log")
public class EvidOpLog extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6486120999115541572L;

	/**
	 * 日志类型 - 入库
	 */
	public static final Integer INSIDE = new Integer(0);
	
	/**
	 * 日志类型 - 出库
	 */
	public static final Integer OUTSIDE = new Integer(1);
	
	/**
	 * 特殊标注 - 入库
	 */
	public static final Integer SP_IMPT = new Integer(0);
	
	/**
	 * 特殊标注 - 出库
	 */
	public static final Integer SP_EXPT = new Integer(1);
	
	
	
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
	 * */
	@Column(name = "f_evid_name", length = 100, nullable = false)
	private String evidName;
	
	/**
	 * 物证编号
	 * */
	@Column(name = "f_evid_sn", length = 100, nullable = false)
	private String evidSn;
	
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
	 * 日志类型
	 **/
	@Column(name = "f_type", length = 1, nullable = false)
	private  Integer type = EvidOpLog.INSIDE;
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
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
	 * 电子物证ID
	 **/
	@Column(name = "fk_evid_id", length = 32, nullable = false)
	private String evidId;
	
	/**
	 * 特殊标注（0：入库 [ SP_IMPT ]、1：出库 [ SP_EXPT ]），电子物证鉴定实验室以进入实验室及离开实验室作为入出库的标志，与系统物证库设计概念（设计以证物进入证物房或离开证物房作为入出库标志）有差异，故另加特殊标识
	 **/
	@Column(name = "f_sp_label", length = 1, nullable = true)
	private  Integer spLabel;
	
	/**
	 * 电子物证预检信息ID
	 **/
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;
	
	public EvidOpLog(){};

	public EvidOpLog(String id){
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

	public String getEvidName() {
		return evidName;
	}

	public void setEvidName(String evidName) {
		this.evidName = evidName;
	}

	public String getEvidSn() {
		return evidSn;
	}

	public void setEvidSn(String evidSn) {
		this.evidSn = evidSn;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseSn() {
		return caseSn;
	}

	public void setCaseSn(String caseSn) {
		this.caseSn = caseSn;
	}

	public int getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
	
	public String getEvidId() {
		return evidId;
	}

	public void setEvidId(String evidId) {
		this.evidId = evidId;
	}

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}

	public Integer getSpLabel() {
		return spLabel;
	}

	public void setSpLabel(Integer spLabel) {
		this.spLabel = spLabel;
	} 
}