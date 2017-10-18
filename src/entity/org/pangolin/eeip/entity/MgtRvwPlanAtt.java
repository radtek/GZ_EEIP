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

/***
 * 管理评审计划附件
 * @author Tinggui Zhu
 *
 */
@Entity
@Table(name = "t_mgt_rvw_plan_att")
public class MgtRvwPlanAtt extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5203028410111103178L;

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
	 * 附件资料名称
	 */
	@Column(name = "f_name", length = 200, nullable = false)
	private String name;
	
	/***
	 * 附件资料物理路径
	 */
	@Type(type="text")
	@Column(name = "f_path", nullable = false)
	private String path;
	
	/***
	 * 附件资料扩展名
	 */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String ext;
	
	/***
	 * 创建时间
	 */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
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
	private Integer delFlag = MgtRvwPlanAtt.NORMAL;
	
	/***
	 * 内部审核实施计划申请ID
	 */
	@Column(name = "fk__mgt_rvw_plan_app_id", length = 32, nullable = false)
	private String mgtRvwPlanAppId;
	
	public MgtRvwPlanAtt(){
		
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getMgtRvwPlanAppId() {
		return mgtRvwPlanAppId;
	}

	public void setMgtRvwPlanAppId(String mgtRvwPlanAppId) {
		this.mgtRvwPlanAppId = mgtRvwPlanAppId;
	}

	
}
