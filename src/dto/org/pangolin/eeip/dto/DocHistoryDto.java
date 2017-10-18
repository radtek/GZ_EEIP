package org.pangolin.eeip.dto;

/***
 * 历史知识文件
 * @author Tinggui Zhu
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.DocHistory;
import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.entity.Document;

public class DocHistoryDto {

	private String id;
	
	private String name;
	
	private String year;
	
	private Integer type;
	
	private String originalSn;
	
	private String sn;
	
	private String extensions;
	
	private String path;
	
	private Date approvedDate;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private Integer deleteFlag;
	
	private String dirId;
	
	private List<DocRelationship> docRelationships = new ArrayList<DocRelationship>();  // 相关文件
	
	private List<Document> documents = new ArrayList<Document>(); // 相关文件-详细信息
	
	public static DocHistoryDto convertToDocHistoryDto(DocHistory docHistory) {
		DocHistoryDto dto = new DocHistoryDto();
		dto.setCreatedDate(docHistory.getCreatedDate());
		dto.setDeleteFlag(docHistory.getDeleteFlag());
		dto.setDirId(docHistory.getDirId());
		dto.setExtensions(docHistory.getExtensions());
		dto.setId(docHistory.getId());
		dto.setModifiedDate(docHistory.getModifiedDate());
		dto.setName(docHistory.getName());
		dto.setOriginalSn(docHistory.getOriginalSn());
		dto.setPath(docHistory.getPath());
		dto.setSn(docHistory.getSn());
		dto.setYear(docHistory.getYear());
		return dto;
	}
	 
	public static DocHistory convertToDocHistory(DocHistoryDto dto) {
		DocHistory docHistory = new DocHistory();
		docHistory.setCreatedDate(dto.getCreatedDate());
		docHistory.setDeleteFlag(dto.getDeleteFlag());
		docHistory.setDirId(dto.getDirId());
		docHistory.setExtensions(dto.getExtensions());
		docHistory.setId(dto.getId());
		docHistory.setModifiedDate(dto.getModifiedDate());
		docHistory.setName(dto.getName());
		docHistory.setOriginalSn(dto.getOriginalSn());
		docHistory.setPath(dto.getPath());
		docHistory.setSn(dto.getSn());
		docHistory.setYear(dto.getYear());
		return docHistory;
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

	public List<DocRelationship> getDocRelationships() {
		return docRelationships;
	}

	public void setDocRelationships(List<DocRelationship> docRelationships) {
		this.docRelationships = docRelationships;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
}
