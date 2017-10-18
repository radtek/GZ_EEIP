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
 * 设备附件表
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_dev_attachment")
public class DevAttachment extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 7725094937865261563L;

	public DevAttachment() {};

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 0：普通附件
	 */
	public static final Integer TYPR_COMMON = new Integer(0);
	
	/**
	 * 1：外观图片
	 */
	public static final Integer TYPR_PICTURE = new Integer(1);
	
	/**
	 * 2：仪器设备档案封面及目录
	 */
	public static final Integer TYPR_COVER = new Integer(2);
	
	/**
	 * 3：仪器设备使用说明书
	 */
	public static final Integer TYPR_INSTRUCTIONS = new Integer(3);
	
	/**
	 * 4：仪器设备检定校准证书复印件
	 */
	public static final Integer TYPR_COPY_CERTIFICATE = new Integer(4);
	
	/**
	 * 5：仪器设备验收单
	 */
	public static final Integer TYPR_RECEIPT = new Integer(5);
	
	/**
	 * 6：仪器设备购置合同
	 */
	public static final Integer TYPR_CONTRACT = new Integer(6);
	
	/**
	 * 7：仪器设备技术服务协议
	 */
	public static final Integer TYPR_TECHNICAL_SERVICES = new Integer(7);
	
	/**
	 * 8：随机技术文件
	 */
	public static final Integer TYPR_TECHNICAL_DOCUMENTS = new Integer(8);
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	public String id;

	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = DevAttachment.NORMAL;

	/**
	 * 创建者帐号
	 * */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建者别名（姓名）
	 * */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate;
	
	/**
	 * 创建者ID
	 * */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 附件资料名称
	 * */
	@Column(name = "f_name", length = 150, nullable = false)
	private String name;
	
	/**
	 * 附件资料物理路径		
	 * */
	@Column(name = "f_path",  nullable = false)
	@Type(type="text")
	private String path;

	/**
	 * 附件资料扩展名		
	 * */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String ext;
	
	/**
	 *	附件资料存放地点			
	 * */
	@Column(name = "f_location", length = 150, nullable = false)
	private String location;
	
	/**
	 *	附件类型（0：普通附件；1：外观图片；2：仪器设备档案封面及目录；
	 *  3：仪器设备使用说明书；4：仪器设备检定校准证书复印件；
	 *  5：仪器设备验收单；6：仪器设备购置合同；7：仪器设备技术服务协议
	 *  8：随机技术文件）		
	 * */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer type;
	
	/**
	 * 设备ID
	 * */
	@Column(name = "fk_device_id", length = 32, nullable = false)
	private String deviceId;
	
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
	
}
