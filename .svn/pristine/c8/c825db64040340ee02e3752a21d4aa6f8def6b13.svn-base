package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 业务考核
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_user_evaluation")
public class UserEvaluation extends BaseEntity implements Serializable { 
	 
	private static final long serialVersionUID = -7417841194700806347L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1); 
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 *  部门
	 */
	@Column(name = "f_dept", length = 20, nullable = false)
	private String dept;
	
	/**
	 *  人员名称
	 */
	@Column(name = "f_name", length = 20, nullable = false)
	private String name;
	
	/**
	 *  技术职称
	 */
	@Column(name = "f_title", length =40, nullable = false)
	private String title;
	
	/**
	 *  考试类别
	 */
	@Column(name = "f_type", length =40, nullable = false)
	private String type;
	
	/**
	 *  考核形式
	 */
	@Column(name = "f_form", length =20, nullable = false)
	private String form;
	
	/**
	 *  考核形式
	 */
	@Column(name = "f_exam_date", nullable = false)
	private String examDate;
	
	/**
	 *  考试内容
	 */
	@Type(type="text")
	@Column(name = "f_content", nullable = false)
	private String content;
	
	/**
	 *  考试结果
	 */
	@Type(type="text")
	@Column(name = "f_result", nullable = false)
	private String result;
	
	/**
	 *  考试意见
	 */
	@Type(type="text")
	@Column(name = "f_opinion", nullable = true)
	private String opinion;
	
	/**
	 *  备注
	 */ 
	@Column(name = "f_remarks", length = 150, nullable = true)
	private String remarks;
	
	/**
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserEvaluation.NORMAL;
	
	/**
	 *  技术负责人
	 */ 
	@Column(name = "f_tech_principal", length = 100, nullable = false)
	private String techPrincipal;
	
	/**
	 * 技术负责人签署时间
	 */ 
	@Column(name = "f_signature_date", nullable = false)
	private Date signatureDate; 
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate=new Date();

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
     * 人员基本信息ID
     */
	@Column(name = "fk_user_basic_info_id", length = 32, nullable = false)
	private String userBasicInfoId;
	
	public UserEvaluation(){}

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTechPrincipal() {
		return techPrincipal;
	}

	public void setTechPrincipal(String techPrincipal) {
		this.techPrincipal = techPrincipal;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
 
	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	 
	public String getUserBasicInfoId() {
		return userBasicInfoId;
	}

	public void setUserBasicInfoId(String userBasicInfoId) {
		this.userBasicInfoId = userBasicInfoId;
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
}