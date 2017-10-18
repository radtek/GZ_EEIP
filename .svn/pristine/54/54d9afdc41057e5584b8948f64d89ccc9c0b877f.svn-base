package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 年度内部审核计划
 * @author Tinggui Zhu
 */
@Entity
@Table(name = "t_annual_plan")
public class AnnualPlan extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4221154449530927652L;

	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 年度（年份）
	 */
	@Column(name = "f_year", length = 20, nullable = false)
	private String year;
	
	/***
	 * 部门
	 */
	@Column(name = "f_dept", length = 100, nullable = false)
	private String dept;
	
	/***
	 * 涉及要素
	 */
	@Column(name = "f_element", length = 250, nullable = false)
	private String element;
	
	/***
	 * 一月
	 */
	@Column(name = "f_jan", length = 250, nullable = true)
	private String jan;
	
	/***
	 * 二月
	 */
	@Column(name = "f_feb", length = 250, nullable = true)
	private String feb;
	
	/***
	 * 三月
	 */
	@Column(name = "f_mar", length = 250, nullable = true)
	private String mar;
	
	/***
	 * 四月
	 */
	@Column(name = "f_apr", length = 250, nullable = true)
	private String apr;
	
	/***
	 * 五月
	 */
	@Column(name = "f_may", length = 250, nullable = true)
	private String may;
	
	/***
	 * 六月
	 */
	@Column(name = "f_jun", length = 250, nullable = true)
	private String jun;
	
	/***
	 * 七月
	 */
	@Column(name = "f_jul", length = 250, nullable = true)
	private String jul;
	
	/***
	 * 八月
	 */
	@Column(name = "f_aug", length = 250, nullable = true)
	private String aug;
	
	/***
	 * 九月
	 */
	@Column(name = "f_sep", length = 250, nullable = true)
	private String sep;
	
	/***
	 * 十月
	 */
	@Column(name = "f_oct", length = 250, nullable = true)
	private String oct;
	
	/***
	 * 十一月
	 */
	@Column(name = "f_nov", length = 250, nullable = true)
	private String nov;
	
	/***
	 * 十二月
	 */
	@Column(name = "f_dec", length = 250, nullable = true)
	private String dec;
	
	/***
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifiedDate;

	/***
	 * 创建时间（编制时间）
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/***
	 * 创建者ID（编制人）
	 */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/***
	 * 创建者账号
	 */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/***
	 * 创建者姓名
	 */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/***
	 * 年度内部审核计划申请ID
	 */
	@Column(name = "fk_annual_plan_app_id", length = 32, nullable = false)
	private String annualPlanAppId;
	
	public AnnualPlan() {  }

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getJan() {
		return jan;
	}

	public void setJan(String jan) {
		this.jan = jan;
	}

	public String getFeb() {
		return feb;
	}

	public void setFeb(String feb) {
		this.feb = feb;
	}

	public String getMar() {
		return mar;
	}

	public void setMar(String mar) {
		this.mar = mar;
	}

	public String getApr() {
		return apr;
	}

	public void setApr(String apr) {
		this.apr = apr;
	}

	public String getMay() {
		return may;
	}

	public void setMay(String may) {
		this.may = may;
	}

	public String getJun() {
		return jun;
	}

	public void setJun(String jun) {
		this.jun = jun;
	}

	public String getJul() {
		return jul;
	}

	public void setJul(String jul) {
		this.jul = jul;
	}

	public String getAug() {
		return aug;
	}

	public void setAug(String aug) {
		this.aug = aug;
	}

	public String getSep() {
		return sep;
	}

	public void setSep(String sep) {
		this.sep = sep;
	}

	public String getOct() {
		return oct;
	}

	public void setOct(String oct) {
		this.oct = oct;
	}

	public String getNov() {
		return nov;
	}

	public void setNov(String nov) {
		this.nov = nov;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	public String getAnnualPlanAppId() {
		return annualPlanAppId;
	}

	public void setAnnualPlanAppId(String annualPlanAppId) {
		this.annualPlanAppId = annualPlanAppId;
	}
}