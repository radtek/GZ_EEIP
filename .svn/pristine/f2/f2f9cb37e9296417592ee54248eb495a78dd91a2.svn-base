package org.pangolin.eeip.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DocumentDao;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.service.DocumentService;
import org.pangolin.util.FileUtil;
import org.springframework.stereotype.Service;

@Service("documentService")
@SuppressWarnings("all")
public class DocumentServiceImpl implements DocumentService {

	@Resource
	private  DocumentDao documentDao;
	
	public Document getDocumentById(String id) {
		return documentDao.get(Document.class, id);
	}
	
	public Long getDocumentQty(String queryParam) {
		if( queryParam != null && !"".equals(queryParam) ){
			queryParam = "%" + queryParam + "%";
			return documentDao.count("select count(id) from Document where deleteFlag = ? and (name like ? or sn like ? )", new Object[]{ Document.NORMAL, queryParam, queryParam});
		}
		return documentDao.count("select count(id) from Document");
	}
	
	public List<Document> getDocuments() {
		return documentDao.find("from Document where deleteFlag = ?",new Object[]{ Document.NORMAL});
	}
	
	public List<Document> getDocumentsByDirectoryId(String directoryId) {
		return documentDao.find("from Document where deleteFlag = ? and dirId = ? order by createdDate desc",new Object[]{ Document.NORMAL, directoryId});
	}
	
	public List<Document> getDocuments(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam) {
		if( queryParam != null && !"".equals(queryParam) ){
			queryParam = "%" + queryParam + "%";
			String hql = "from Document where deleteFlag = ? and (name like ? or sn like ?) order by " + sorter + " " + sortingAttribute;
			return documentDao.search(hql, new Object[]{ Document.NORMAL, queryParam, queryParam}, startIndex, rows);
		}
		return documentDao.search("from Document where deleteFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Document.NORMAL  }, startIndex, rows);
	}
	
	public boolean removeDocument(String id) {
		String filePath = "";
		Document doc = getDocumentById(id);
		if ( doc != null 
				&& doc.getPath() != null 
				&& !doc.getPath().trim().equals("") ) {
			filePath = doc.getPath();
		}
		
		//documentDao.executeHql("delete from Document where id = ?", new Object[] { id });
		documentDao.executeHql("update Document set deleteFlag = ? where id = ?", new Object[] { Document.REMOVED,id });
		Long qty = documentDao.count("select count(id) from Document where id = ? and deleteFlag = ?" , new Object[] { id,Document.NORMAL });
		if ( qty.intValue() == 0 ) {
			//FileUtil.removeFile(filePath);
			return true;
		}
		return false;
	}
	
	public boolean saveDocument(Document document) {
		/*Long qty = documentDao.count("select count(id) from Document where id = ? and deleteFlag = ?", new Object[]{document.getId(), Document.NORMAL});
		if( qty > 0 ){
			documentDao.update(document);
		}else{
			documentDao.save(document);
		}
		return true;*/
		String method = "";
		if ( document.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			document.setModifiedDate(new Date());
		}
		document.setExtensions(FileUtil.getExtensionFileType(new File(document.getPath())));
		documentDao.saveOrUpdate(document);
		if ( method.equals("add") ) {
			if ( document.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public List<Document> getDocumentsByDirId(String dirId) {
		return documentDao.find("from Document where deleteFlag = ? and dirId = ?", new Object[]{ Document.NORMAL, dirId});
	}

	@Override
	public List<Document> getDocumentByKey(String dirId, String key) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Document where deleteFlag = "+Document.NORMAL);
		if ( dirId != null && !dirId.equals("") ) {
			hql.append(" and dirId = '"+dirId+"'");
		}
		if ( key != null && !key.equals("") ) {
			key = "%" + key + "%";
			hql.append(" and name like '"+key+"'");
		}
		
		return documentDao.find(hql.toString());
	}
}