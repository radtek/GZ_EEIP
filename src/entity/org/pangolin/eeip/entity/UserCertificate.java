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
import org.pangolin.util.UUIDHexGenerator;

/**
 * 专家资格证书信息
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_user_certificate")
public class UserCertificate extends BaseEntity implements Serializable {
 
	private static final long serialVersionUID = 3871627074699767036L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 证书类型 - 任职资格证书
	 * */
	public static final Integer QUALIFICATION_CERTIFICATE = new Integer(0);
	
	/**
	 * 证书类型 - 鉴定人资格证书
	 * */
	public static final Integer APPRAISER_CERTIFICATE = new Integer(1);
	
	/**
	 * 证书类型 - 毕业证书
	 * */
	public static final Integer GRADUATION_CERTIFICATE = new Integer(2);
	
	/**
	 * 证书类型 - 学位证书
	 * */
	public static final Integer DIPLOMA = new Integer(3);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 资格证书类型
	 */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer type;
	
	/**
	 * 名称
	 */
	@Column(name = "f_name", length = 32, nullable = false)
	private String name; 
	
	/**
	 * 文件物理路径
	 */
	@Type(type="text")
	@Column(name = "f_path", nullable = false)
	private String path; 
	
	/**
	 * 文件后缀名
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
	@Column(name = "f_creator_id", nullable = false)
	private String  creatorId; 
	
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
	 * 伪删除状态
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = UserCertificate.NORMAL;
	
	/**
     * 人员基本信息ID
     */
	@Column(name = "fk_user_basic_info_id", length = 32, nullable = false)
	private String userBasicInfoId;
	
	public UserCertificate(){}

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
 

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
	
}