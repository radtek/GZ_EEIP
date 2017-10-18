package org.pangolin.eeip.dto;

/***
 * 临时知识文件
 * @author Tinggui Zhu
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.entity.TmpDocOpLog;

public class TmpDocOpLogDto {

	private String id;
	
	private String name;
	
	private String year;
	
	private Integer type;
	
	private String originalSn;
	
	private String sn;

	private String extensions;
	
	private String path;
	
	private String content;
	
	private String reason;
	
	private String opinion;
	
	private Date approvedDate;
	
	private Date createdDate;
	
	private String creatorId;
	
	private String creatorAlias;
	
	private String creatorName;
	
	private Date modifiedDate;
	
	private Integer deleteFlag;
	
	private String dirId;
	
	private Integer status;
	
	private String docId;
	
	private List<Document> documents = new ArrayList<Document>(); // 相关文件-详细信息（正式知识文件）
	
	private List<DocRelationship> docRelationships = new ArrayList<DocRelationship>(); // 相关文件
	
	public static TmpDocOpLogDto convertToTmpDocOpLogDto(TmpDocOpLog tmpDocOpLog) {
		TmpDocOpLogDto dto = new TmpDocOpLogDto();
		dto.setCreatorAlias(tmpDocOpLog.getCreatorAlias());
		dto.setCreatorId(tmpDocOpLog.getCreatorId());
		dto.setCreatorName(tmpDocOpLog.getCreatorName());
		dto.setContent(tmpDocOpLog.getContent());
		dto.setCreatedDate(tmpDocOpLog.getCreatedDate());
		dto.setDeleteFlag(tmpDocOpLog.getDelFlag());
		dto.setDirId(tmpDocOpLog.getDirId());
		dto.setExtensions(tmpDocOpLog.getExtensions());
		dto.setId(tmpDocOpLog.getId());
		dto.setModifiedDate(tmpDocOpLog.getModifiedDate());
		dto.setName(tmpDocOpLog.getName());
		dto.setOpinion(tmpDocOpLog.getOpinion());
		dto.setOriginalSn(tmpDocOpLog.getOriginalSn());
		dto.setPath(tmpDocOpLog.getPath());
		dto.setReason(tmpDocOpLog.getReason());
		dto.setSn(tmpDocOpLog.getSn());
		dto.setType(tmpDocOpLog.getType());
		dto.setYear(tmpDocOpLog.getYear());
		dto.setStatus(tmpDocOpLog.getStatus());
		dto.setDocId(tmpDocOpLog.getDocId());
		
		return dto;
	}
	
	public static TmpDocOpLog convertToTmpDocOpLog(TmpDocOpLogDto dto) {
		TmpDocOpLog tmpDocOpLog = new TmpDocOpLog();
		tmpDocOpLog.setCreatorAlias(dto.getCreatorAlias());
		tmpDocOpLog.setCreatorId(dto.getCreatorId());
		tmpDocOpLog.setCreatorName(dto.getCreatorName());
		tmpDocOpLog.setContent(dto.getContent());
		tmpDocOpLog.setCreatedDate(dto.getCreatedDate());
		tmpDocOpLog.setDelFlag(dto.getDeleteFlag());
		tmpDocOpLog.setDirId(dto.getDirId());
		tmpDocOpLog.setExtensions(dto.getExtensions());
		tmpDocOpLog.setId(dto.getId());
		tmpDocOpLog.setModifiedDate(dto.getModifiedDate());
		tmpDocOpLog.setName(dto.getName());
		tmpDocOpLog.setOpinion(dto.getOpinion());
		tmpDocOpLog.setOriginalSn(dto.getOriginalSn());
		tmpDocOpLog.setPath(dto.getPath());
		tmpDocOpLog.setReason(dto.getReason());
		tmpDocOpLog.setSn(dto.getSn());
		tmpDocOpLog.setType(dto.getType());
		tmpDocOpLog.setYear(dto.getYear());
		tmpDocOpLog.setStatus(dto.getStatus());
		tmpDocOpLog.setDocId(dto.getDocId());
		return tmpDocOpLog;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOriginalSn() {
		return originalSn;
	}

	public void setOriginalSn(String originalSn) {
		this.originalSn = originalSn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDirId() {
		return dirId;
	}

	public void setDirId(String dirId) {
		this.dirId = dirId;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<DocRelationship> getDocRelationships() {
		return docRelationships;
	}

	public void setDocRelationships(List<DocRelationship> docRelationships) {
		this.docRelationships = docRelationships;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorAlias() {
		return creatorAlias;
	}

	public void setCreatorAlias(String creatorAlias) {
		this.creatorAlias = creatorAlias;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}
	
}
