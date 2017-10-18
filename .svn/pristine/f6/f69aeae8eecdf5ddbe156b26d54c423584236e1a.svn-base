package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 鉴定事项 （文书修改）
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_appraisal_item")
public class AppraisalItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3475438756354431218L;
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	public String id;
	
	/**
	 * 委托项目（0：提取固定电子数据；1：恢复电子数据；2：检验程序功能；3：破解电子数据密码；4：分析电子数据；5：销毁电子数据），实验室对电子物证鉴定的范围"
	 * */
	@Column(name = "f_scope",length = 20, nullable = true)
	private String scope;

	/**
	 * 鉴定方法-其他（手工输入）
	 * */
	@Column(name = "f_method_other",length = 200, nullable = true)
	private String methodOther;
	
	/**
	 * 鉴定方法，可填写《数字化设备证据数据发现提取固定方法》GA/T756-2008、《电子物证搜索检验技术规范》GB/T29362-2012、《电子物证恢复检验技术规范》GB/T29360-2012，超出范围可根据实际填写
	 * */
	@Column(name = "f_method",length = 200, nullable = true)
	private String method;
	
	/**
	 * 结果要求，可填写出具检验报告、出具鉴定意见书、只提取电子数据，超出范围可根据实际填写
	 * */
	@Column(name = "f_rqmt",length = 200, nullable = true)
	private String rqmt;
	
	/**
	 * 结果要求-其他（手工输入）
	 * */
	@Column(name = "f_rqmt_other",length = 200, nullable = true)
	private String rqmtOther;
	
	/**
	 * 电子物证文书修改申请ID
	 * */
	@Column(name = "fk_appraisal_revise_id",length = 32 ,nullable = true)
	private String appraisalReviseId;
	
	/**
	 * 电子物证（检材）鉴定ID
	 * */
	@Column(name = "fk_appraisal_id",length = 32 ,nullable = true)
	private String appraisalId;
	
	public AppraisalItem(){}
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getMethodOther() {
		return methodOther;
	}

	public void setMethodOther(String methodOther) {
		this.methodOther = methodOther;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRqmt() {
		return rqmt;
	}

	public void setRqmt(String rqmt) {
		this.rqmt = rqmt;
	}

	public String getRqmtOther() {
		return rqmtOther;
	}

	public void setRqmtOther(String rqmtOther) {
		this.rqmtOther = rqmtOther;
	}

	public String getAppraisalReviseId() {
		return appraisalReviseId;
	}

	public void setAppraisalReviseId(String appraisalReviseId) {
		this.appraisalReviseId = appraisalReviseId;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}  
}
