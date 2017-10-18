package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 质量体系文件修改意见细项
 * @author zhutinggui
 *
 */
@Entity
@Table(name = "t_meeting_qs_doc_cmt_item")
public class MeetingQsDocCmtItem extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -5770296032448909555L;

	/***
	 * 文件类型 - 质量手册
	 */
	public static final Integer TYPE_QUALITY = 0;
	
	/***
	 * 文件类型 - 程序文件
	 */
	public static final Integer TYPE_PROGRAM = 1;
	
	/***
	 * 文件类型- 作业指导书，表格类
	 */
	public static final Integer TYPE_FORM = 2;
	
	/***
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 文件类型（0：质量手册，1：程序文件，2：作业指导书、表格类）
	 */
	@Column(name = "f_doc_type", nullable = true)
	private Integer docType;
	
	/***
	 * 修改处（章，节，条款）
	 */
	@Column(name = "f_modif", length = 200, nullable = true)
	private String modif;
	
	/***
	 * 原内容
	 */
	@Column(name = "f_original", length = 200, nullable = true)
	private String original;
	
	/***
	 * 修改意见
	 */
	@Column(name = "f_opinion", length = 200, nullable = true)
	private String opinion;
	
	/***
	 * 修改理由
	 */
	@Column(name = "f_reason", length = 200, nullable = true)
	private String reason;
	
	/***
	 * 会议申请ID
	 */
	@Column(name = "fk_meeting_app_id", length = 32, nullable = false)
	private String meetingAppId;
	
	/***
	 * 质量体系文件修改意见表ID
	 */
	@Column(name = "fk_meeting_qs_doc_cmt_id", length = 32, nullable = false)
	private String meetingQsDocCmtId;
	
	public  MeetingQsDocCmtItem() {
		// TODO Auto-generated constructor stub
	}
	
	public MeetingQsDocCmtItem(int docType){
          this.docType = docType;
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

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	public String getModif() {
		return modif;
	}

	public void setModif(String modif) {
		this.modif = modif;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMeetingAppId() {
		return meetingAppId;
	}

	public void setMeetingAppId(String meetingAppId) {
		this.meetingAppId = meetingAppId;
	}

	public String getMeetingQsDocCmtId() {
		return meetingQsDocCmtId;
	}

	public void setMeetingQsDocCmtId(String meetingQsDocCmtId) {
		this.meetingQsDocCmtId = meetingQsDocCmtId;
	}
	
	
}
