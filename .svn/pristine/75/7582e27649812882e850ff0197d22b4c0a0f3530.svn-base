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
 * 会议室管理
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_meeting_room")
public class MeetingRoom extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 2457621383668229852L;

	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);

	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 名称
	 */
	@Column(name = "f_name", length = 50, nullable = false)
	private String name;
	
	/***
	 * 编号
	 */
	@Column(name = "f_sn", length = 50, nullable = true)
	private String sn;
	
	/***
	 * 地址
	 */
	@Column(name = "f_addr", length = 150, nullable = true)
	private String addr;
	
	/***
	 * 可容纳数
	 */
	@Column(name = "f_cap", nullable = true)
	private Integer cap;
	
	/***
	 * 最大容纳人数
	 */
	@Column(name = "f_max_cap", nullable = true)
	private Integer maxCap;
	
	/***
	 * 备注
	 */
	@Column(name = "f_remarks", length = 200, nullable = true)
	private String remarks;
	
	/***
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate;
	
	/***
	 * 修改时间
	 */
	@Column(name = "f_modified_date", nullable = true)
	private Date modifedDate;
	
	/***
	 * 创建者ID
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
	 * 删除状态（0：正常，1：删除）
	 */
	@Column(name = "f_del_flag", nullable = false)
	private Integer delFlag = MeetingRoom.NORMAL;

	public MeetingRoom() {
		// TODO Auto-generated constructor stub
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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Integer getMaxCap() {
		return maxCap;
	}

	public void setMaxCap(Integer maxCap) {
		this.maxCap = maxCap;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifedDate() {
		return modifedDate;
	}

	public void setModifedDate(Date modifedDate) {
		this.modifedDate = modifedDate;
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
	
	
	
}
