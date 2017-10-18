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
 * 温湿度传感器数据采集日志
 * @author Oscar Mok
 *
 */
@Entity
@Table(name = "t_sensor_data_log")
public class DevEvn extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 6030999466468160608L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 数据采集时间
	 * */
	@Column(name = "f_collected_date", nullable = false)
	private Date collectedDate = new Date();
	
	/**
	 * 温度
	 * */
	@Column(name = "f_temp", nullable = false)
	private Double temperature = new Double(0);
	
	/**
	 * 湿度
	 * */
	@Column(name = "f_hum", nullable = false)
	private Double humidity = new Double(0);
	
	/**
	 * 传感器位置
	 * */
	@Column(name = "f_location", length = 100, nullable = false)
	private String location;
	
	/**
	 * 传感器IP地址
	 * */
	@Column(name = "f_ip_addr", length = 100, nullable = false)
	private String ipAddr;
	
	/**
	 * 传感器访问端口
	 * */
	@Column(name = "f_port", length = 10, nullable = false)
	private String port;
	
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

	public Date getCollectedDate() {
		return collectedDate;
	}

	public void setCollectedDate(Date collectedDate) {
		this.collectedDate = collectedDate;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}