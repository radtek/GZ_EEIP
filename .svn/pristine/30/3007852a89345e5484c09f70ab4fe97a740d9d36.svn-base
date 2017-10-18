package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.pangolin.util.UUIDHexGenerator;

/***
 * 内部审核实施计划 
 * @author Tinggui Zhu
 *
 */
@Entity
@Table(name = "t_impl_plan")
public class ImplPlan extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -6415013501292092717L;

	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id = UUIDHexGenerator.getInstance().generate();
	
	/***
	 * 被申岗位
	 */
	@Column(name = "f_audited_post", length = 50, nullable = false)
	private String auditedPost;
	
	/***
	 * 审核时间
	 */
	@Column(name = "f_audited_date", nullable = false)
	private Date auditedDate;
	
	/***
	 * 责任人ID
	 */
	@Column(name = "f_principal_id", length = 32, nullable = true)
	private String principalId;
	
	/***
	 * 责任人账号
	 */
	@Column(name = "f_principal_name", length = 50, nullable = true)
	private String principalName;
	
	/***
	 * 责任人姓名
	 */
	@Column(name = "f_principal_alias", length = 50, nullable = false)
	private String principalAlias;
	
	/***
	 * 审核员ID
	 */
	@Column(name = "f_auditor_id", length = 32, nullable = true)
	private String auditorId;
	
	/***
	 * 审核员账号
	 */
	@Column(name = "f_auditor_name", length = 50, nullable = true)
	private String auditorName;
	
	/***
	 * 审核员姓名
	 */
	@Column(name = "f_auditor_alias", length = 50, nullable = false)
	private String auditorAlias;
	
	/***
	 * 审核内容（要素）
	 */
	@Column(name = "f_content", length = 50, nullable = false)
	private String content;
	
	/***
	 * 内部审核实施计划申请ID
	 */
	@Column(name = "fk_impl_plan_app_id", length = 32, nullable = false)
	private String implPlanAppId;
	
	public ImplPlan() {
		// TODO Auto-generated constructor stub
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

	public String getAuditedPost() {
		return auditedPost;
	}

	public void setAuditedPost(String auditedPost) {
		this.auditedPost = auditedPost;
	}

	public Date getAuditedDate() {
		return auditedDate;
	}

	public void setAuditedDate(Date auditedDate) {
		this.auditedDate = auditedDate;
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

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getAuditorAlias() {
		return auditorAlias;
	}

	public void setAuditorAlias(String auditorAlias) {
		this.auditorAlias = auditorAlias;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImplPlanAppId() {
		return implPlanAppId;
	}

	public void setImplPlanAppId(String implPlanAppId) {
		this.implPlanAppId = implPlanAppId;
	}
	
	
	
	
}
