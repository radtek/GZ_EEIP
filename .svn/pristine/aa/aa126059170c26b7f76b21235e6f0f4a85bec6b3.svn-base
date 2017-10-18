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
 * 电子物证（检材）预检信息附件
 * @author Xiaolin Yin
 *
 */
@Entity
@Table(name = "t_preappraisal_att")
public class PreappraisalAtt extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1843584476265414789L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-assigned")
	@GenericGenerator(name = "system-assigned", strategy = "assigned")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 名称
	 */
	@Column(name = "f_name", length = 32, nullable = false)
	private String name; 
	
	/**
	 * 资料物理路径
	 */
	@Type(type="text")
	@Column(name = "f_path", nullable = false)
	private String path; 
	
	/**
	 * 资料后缀名
	 */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String ext;
	
	/**
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();

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
	 * 电子物证预检信息ID
	 */
	@Column(name = "fk_preappraisal_id", length = 32, nullable = false)
	private String preappraisalId;

	public PreappraisalAtt() {
		super();
	}

	public PreappraisalAtt(String id) {
		super();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
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

	public String getPreappraisalId() {
		return preappraisalId;
	}

	public void setPreappraisalId(String preappraisalId) {
		this.preappraisalId = preappraisalId;
	}
	
}
