package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 待鉴定电子物证（检材）信息  
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_preappraised_evid")
public class PreappraisedEvid extends BaseEntity implements Serializable {
 
	private static final long serialVersionUID = -1734075866515335873L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 物证名称
	 */
	@Column(name = "f_name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 状态  （0：物证袋封装,1:封条,2:未封存）
	 */
	@Column(name = "f_status", length = 1, nullable = false)
	private Integer status = new Integer(0);
	
	/**
	 * 数量 （默认：1），暂不开放修改
	 */
	@Column(name = "f_qty", length = 1, nullable = false)
	private Integer qty = new Integer(1);
	
	/**
	 * 特征描述
	 */
	@Column(name = "f_desc", nullable = true)
	@Type(type="text")
	private String desc;

	/**
	 * 物证编号
	 */
	@Column(name = "f_sn", length = 100, nullable = false)
	private String sn;
	
	/**
	 * 备注
	 */
	@Column(name = "f_remarks", nullable = true)
	@Type(type="text")
	private String remarks;
	
	/**
	 * 物证类型（有别于电子物证库的物证类型）
	 */
	@Column(name = "f_type", length = 100, nullable = true)
	private String type;
	
	/**
	 * 物证类型（有别于电子物证库的物证类型） 其他具体
	 */
	@Column(name = "f_type_other", length = 100, nullable = true)
	private String typeOther;
	
	/**
	 * 电子物证预检信息ID
	 */
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;
	
 

	public PreappraisedEvid(){}
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}

	public String getTypeOther() {
		return typeOther;
	}

	public void setTypeOther(String typeOther) {
		this.typeOther = typeOther;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
	
}
