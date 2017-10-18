package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 县/区
 * @author Oscar Mok
 */
@Entity
@Table(name = "t_county")
public class County implements Serializable {
	
	private static final long serialVersionUID = 7858041392313566621L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 县/区ID
	 */
	@Column(name="f_county_id", length = 50, nullable = false)
	private String countyId;
	
	/**
	 * 县/区名称
	 */
	@Column(name="f_name", length = 50, nullable = false)
	private String name;
	
	/**
	 * 市ID
	 */
	@Column(name="fk_city_id", length = 50, nullable = false)
	private String cityId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}