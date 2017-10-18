package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 市
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_city")
public class City implements Serializable {

	private static final long serialVersionUID = 8511774315808778090L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 市ID
	 */
	@Column(name="f_city_id", length = 50, nullable = false)
	private String cityId;
	
	/**
	 * 市名称
	 */
	@Column(name="f_name", length = 50, nullable = false)
	private String name;
	
	/**
	 * 省ID
	 */
	@Column(name="fk_province_id", length = 50, nullable = false)
	private String provinceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
}