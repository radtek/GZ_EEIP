package org.pangolin.eeip.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 组织TreeGrid数据传输对象
 * @author Oscar Mok
 * */
public class OrgDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 3786480143542902434L;
	
	private String id;
	private String name;
	private String shortName;
	private String sn;
	private Integer status;
	private Integer type;
	private String createdDateStr;
	private String modifiedDateStr;
	private String desc;
	private String style;
	
	public OrgDto(String id, String name, String shortName, String sn, Integer status, Integer type, Date createdDate, Date modifiedDate, String desc, String style) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.sn = sn;
		this.status = status;
		this.type = type;
		this.createdDateStr = ( createdDate != null ) ? sdf.format(createdDate) : "";
		this.modifiedDateStr = ( modifiedDate != null ) ? sdf.format(modifiedDate) : "";
		this.desc = desc;
		this.style = style;
	}
	
	//getters and setters
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCreatedDateStr() {
		return createdDateStr;
	}

	public void setCreatedDateStr(String createdDateStr) {
		this.createdDateStr = createdDateStr;
	}

	public String getModifiedDateStr() {
		return modifiedDateStr;
	}

	public void setModifiedDateStr(String modifiedDateStr) {
		this.modifiedDateStr = modifiedDateStr;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}