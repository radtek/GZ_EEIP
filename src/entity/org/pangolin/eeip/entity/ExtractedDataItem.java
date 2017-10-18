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
 * 提取电子数据清单
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_extracted_data_item")
public class ExtractedDataItem extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2939620089073166892L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 	数据
	 */
	@Column(name = "f_data", nullable = true)
	@Type(type="text")
	private String data;
	
	/**
	 * 	来源
	 */
	@Column(name = "f_src", nullable = true)
	@Type(type="text")
	private String src;
	
	/**
	 * 	说明
	 */
	@Column(name = "f_explanation", nullable = true)
	@Type(type="text")
	private String explanation;
	
	/**
	 * 	提取电子数据清单ID
	 */
	@Column(name = "fk_extracted_data_id", length = 32 , nullable = false)
	@Type(type="text")
	private String extractedDataId;

	public ExtractedDataItem(){}
    
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getExtractedDataId() {
		return extractedDataId;
	}

	public void setExtractedDataId(String extractedDataId) {
		this.extractedDataId = extractedDataId;
	}
	
}
	
