package org.pangolin.eeip.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.entity.TmpDocOpLog;

/***
 * 知识文件管理列表
 * @author Tinggui Zhu
 *
 */
public class DocOpLogDto {

	private String id;
	
	private String sn;
	
	private String name;
	
	private String creatorAlias;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private int status;
	
	private int type; // 0:临时文件,1:正式文件
	
	private String docId; 
	
	public static List<DocOpLogDto> converToDocOpLogDto(List<Document> documents,List<TmpDocOpLog> docOpLogs) {
		List<DocOpLogDto> dtos = new ArrayList<DocOpLogDto>();
		if ( documents != null && documents.size() > 0 ) {
			for ( Document document : documents) {
				DocOpLogDto dto = new DocOpLogDto();
				dto.setCreatedDate(document.getCreatedDate());
				dto.setCreatorAlias(document.getCreatorAlias());
				dto.setId(document.getId());
				dto.setSn(document.getSn());
				dto.setModifiedDate(document.getModifiedDate());
				dto.setName(document.getName());
				dto.setStatus(-1);
				dto.setType(1);
				dtos.add(dto);
			}
		}
		
		if ( docOpLogs != null && docOpLogs.size() > 0 ) {
			for ( TmpDocOpLog docOpLog : docOpLogs ) {
				DocOpLogDto dto = new DocOpLogDto();
				dto.setCreatedDate(docOpLog.getCreatedDate());
				dto.setCreatorAlias(docOpLog.getCreatorAlias());
				dto.setId(docOpLog.getId());
				dto.setSn(docOpLog.getSn());
				dto.setModifiedDate(docOpLog.getModifiedDate());
				dto.setName(docOpLog.getName());
				dto.setStatus(docOpLog.getStatus());
				dto.setType(0);
				dto.setDocId(docOpLog.getDocId());
				dtos.add(dto);
			}
		}
		
		return dtos;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
}
