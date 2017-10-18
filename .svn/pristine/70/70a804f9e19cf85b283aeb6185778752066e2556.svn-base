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
 * 文书资料（鉴定资料）
 * @author JinRuiWang
 */
@Entity
@Table(name = "t_appraisal_doc")
public class AppraisalDoc extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7185440498571832824L;

	public AppraisalDoc() {}
	
	/**
	 * 删除标记 - 正常
	 * */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除标记 - 删除
	 * */
	public static final Integer REMOVED = new Integer(1);
	
	/**
	 * 文书资料类型（0：鉴定委托书；
	 * */
	public static final Integer  POWER_OF_ATTORNEY  = new Integer(0);
	
	/**
	 * 文书资料类型 1：鉴定事项确认书；
	 * */
	public static final Integer  CONFIRMATION  = new Integer(1);
	
	/**
	 * 文书资料类型 2：物证鉴定档案封面；
	 * */
	public static final Integer  COVER  = new Integer(2);
	
	/**
	 * 文书资料类型  3：鉴定文书档案目录；
	 * */
	public static final Integer  CATALOGUE  = new Integer(3);
	
	/**
	 * 文书资料类型  4：电子物证检验原始记录；
	 * */
	public static final Integer  SOURCE_RECORD  = new Integer(4);
	
	/**
	 * 文书资料类型  5：鉴定文书；
	 * */
	public static final Integer  SETTLE_DOC  = new Integer(5);
	
	/**
	 * 文书资料类型  6：检验鉴定照片记录表；
	 * */
	public static final Integer  PICTURE_RECORD  = new Integer(6);
	
	/**
	 * 文书资料类型  7：提取电子证据清单；
	 * */
	public static final Integer  EVIDENCE_LIST  = new Integer(7);
	
	/**
	 * 文书资料类型  8：鉴定文书审批表
	 * */
	public static final Integer  AUTHENTICATE_DOC_APPROVE  = new Integer(8);
	
	/**
	 * 文书资料类型  9：不受理鉴定委托告知书
	 * */
	public static final Integer  NOT_ACCEPT_NOTIFICATION  = new Integer(9);
	
	/**
	 * 文书资料类型  10：中止鉴定告知书
	 * */
	public static final Integer  STOP_NOTIFICATION  = new Integer(10);
	
	/**
	 * 文书资料类型  11：鉴定文书修改审批表
	 * */
	public static final Integer  INSTRUMENT_MODIFY_APPROVAL  = new Integer(11);
	
	/**
	 * 文书资料类型  12：检材流转记录表
	 * */
	public static final Integer  EVID_CIRCULATION_RECORD  = new Integer(12);
	
	

	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 删除状态
	 * */
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private Integer delFlag = AppraisalDoc.NORMAL;
	
	/**
	 * 文书资料名称
	 * */
	@Column(name = "f_name", length = 200, nullable = false)
	private String name ;
	
	/**
	 * 文书资料物理路径，如： /opt/files/xxx.jpg
	 * */
	@Column(name = "f_path", nullable = false)
	@Type(type="text")
	private String path ;
	
	/**
	 * 文书资料扩展名，如：.jpg
	 * */
	@Column(name = "f_ext", length = 10, nullable = false)
	private String ext ;
	
	/**
	 *	文书资料类型（0：鉴定委托书；1：鉴定事项确认书；2：物证鉴定档案封面；
	 *	3：鉴定文书档案目录；4：电子物证检验原始记录；5：鉴定文书；
	 *	6：检验鉴定照片记录表；7：提取电子证据清单；8：鉴定文书审批表）
	 *	，加粗部分代表该类文档在鉴定过程中可能有变更情况"(3-8)
	 * */
	@Column(name = "f_type", length = 1, nullable = false)
	private Integer type ;

	/**
	 * 创建人（鉴定人）帐号
	 * */
	@Column(name = "f_creator_name", length = 50, nullable = false)
	private String creatorName;
	
	/**
	 * 创建人（鉴定人）姓名
	 * */
	@Column(name = "f_creator_alias", length = 50, nullable = false)
	private String creatorAlias;
	
	/**
	 * 创建时间
	 * */
	@Column(name = "f_created_date", nullable = false)
	private Date createdDate = new Date();
	
	/**
	 * 创建人（鉴定人）ID
	 * */
	@Column(name = "f_creator_id", length = 32, nullable = false)
	private String creatorId;
	
	/**
	 * 电子物证文书修改申请ID
	 * */
	@Column(name = "fk_appraisal_revise_id", length = 32, nullable = true)
	private String appraisalReviseId;
	
	/**
	 *	电子物证（检材）鉴定历史记录ID
	 * */
	@Column(name = "fk_appraisal_hist_id", length = 32, nullable = true)
	private String appraisalHistId;
	
	/**
	 *	电子物证（检材）鉴定ID
	 * */
	@Column(name = "fk_appraisal_id", length = 32, nullable = false)
	private String appraisalId;
	
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

	public String getAppraisalHistId() {
		return appraisalHistId;
	}

	public void setAppraisalHistId(String appraisalHistId) {
		this.appraisalHistId = appraisalHistId;
	}

	public String getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(String appraisalId) {
		this.appraisalId = appraisalId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAppraisalReviseId() {
		return appraisalReviseId;
	}

	public void setAppraisalReviseId(String appraisalReviseId) {
		this.appraisalReviseId = appraisalReviseId;
	}
	
}
