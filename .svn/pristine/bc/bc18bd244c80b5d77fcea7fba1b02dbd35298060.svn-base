package org.pangolin.eeip.util;

import java.util.Date;

import org.pangolin.eeip.entity.DocHistory;
import org.pangolin.eeip.entity.DocOpLog;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.entity.TmpDocOpLog;

public class DocumentUtil {

	public static Document convertDocument(Document document, TmpDocOpLog tmpDocOpLog){
		document.setCreatedDate(tmpDocOpLog.getCreatedDate());
		document.setCreatorAlias(tmpDocOpLog.getCreatorAlias());
		document.setCreatorId(tmpDocOpLog.getCreatorId());
		document.setCreatorName(tmpDocOpLog.getCreatorName());
		document.setDeleteFlag(tmpDocOpLog.getDelFlag());
		document.setDirId(tmpDocOpLog.getDirId());
		document.setExtensions(tmpDocOpLog.getExtensions());
		document.setName(tmpDocOpLog.getName());
		document.setOriginalSn(tmpDocOpLog.getOriginalSn());
		document.setPath(tmpDocOpLog.getPath());
		document.setSn(tmpDocOpLog.getSn());
		document.setYear(tmpDocOpLog.getYear());
		return document;
	}
	
	public static DocHistory convertDocHistory(Document document){
		DocHistory docHistory = new DocHistory();
		docHistory.setCreatedDate(document.getCreatedDate());
		docHistory.setCreatorAlias(document.getCreatorAlias());
		docHistory.setCreatorId(document.getCreatorId());
		docHistory.setCreatorName(document.getCreatorName());
		docHistory.setDeleteFlag(document.getDeleteFlag());
		docHistory.setDirId(document.getDirId());
		docHistory.setExtensions(document.getExtensions());
		docHistory.setName(document.getName());
		docHistory.setOriginalSn(document.getOriginalSn());
		docHistory.setPath(document.getPath());
		docHistory.setSn(document.getSn());
		docHistory.setYear(document.getYear());
		docHistory.setDocId(document.getId());
		return docHistory;
	}
	
	public static DocOpLog convertDocOpLog(DocOpLog docOpLog,TmpDocOpLog tmpDocOpLog){
		docOpLog.setDocumentId(tmpDocOpLog.getDocId());
		docOpLog.setEventDate(new Date());
		docOpLog.setOperator(tmpDocOpLog.getCreatorName());
		docOpLog.setOperatorAlias(tmpDocOpLog.getCreatorAlias());
		docOpLog.setOperatorId(tmpDocOpLog.getCreatorId());
		return docOpLog;
	}
}
