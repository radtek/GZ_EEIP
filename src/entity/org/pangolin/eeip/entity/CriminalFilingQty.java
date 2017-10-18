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
 * 刑事立案数
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_criminal_filing_qty")
public class CriminalFilingQty extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4929402017890210231L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 *  年份
	 */
	@Column(name="f_year", length = 10, nullable = false)
	private String year;
	
	/**
	 *  月份
	 */
	@Column(name="f_month", length = 10, nullable = false)
	private String month;
	
	/**
	 *  区名称
	 */
	@Column(name="f_country", length = 10, nullable = false)
	private String country;
	
	/**
	 *  区立案数
	 */
	@Column(name="f_filing_qty", length = 10, nullable = false)
	private Integer filingQty;
	
	/**
	 * 创建人姓名
	 * */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 创建人ID
	 * */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId; 
	
	public CriminalFilingQty(){}
	
	public CriminalFilingQty(String id){
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Integer getFilingQty() {
		return filingQty;
	}

	public void setFilingQty(Integer filingQty) {
		this.filingQty = filingQty;
	}
	
}
