package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DirectoryDao;
import org.pangolin.eeip.entity.Directory;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.service.DirectoryService;
import org.pangolin.eeip.service.DocumentService;
import org.springframework.stereotype.Service;

@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService {

	@Resource()
	private DirectoryDao directoryDao;
	
	@Resource
	private DocumentService documentService;
	
	@Override
	public boolean saveDirectory(Directory directory) {
		String method = "";
		if ( directory.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		directoryDao.saveOrUpdate(directory);
		if ( method.equals("add") ) {
			if ( directory.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeDirectory(String id) {
		directoryDao.executeHql("delete from Directory where id = ?", new Object[] { id });
		Long qty = directoryDao.count("select count(id) from Directory where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeDirectoryFalse(String id) {
		directoryDao.executeHql("update Directory set delFlag = ? where id = ?", new Object[] { Directory.REMOVED, id });
		Long qty = directoryDao.count("select count(id) from Directory where id = ? and delFlag = ? " , new Object[] { id, Directory.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public Directory getDirectoryById(String id) {
		return directoryDao.get(Directory.class, id);
	}

	@Override
	public Long getDirectoryQty() {
		return directoryDao.count("select count(id) from Directory where delFlag = ? ", new Object[]{Directory.NORMAL});
	}

	@Override
	public List<Directory> getDirectorys() {
		List<Directory> list = directoryDao.find("from Directory where delFlag = ? order by createdDate desc", new Object[]{Directory.NORMAL});
		for ( Directory directory : list ) {
			List<Document> documents = documentService.getDocumentsByDirectoryId(directory.getId());
			if ( documents != null && documents.size() > 0 ) {
				directory.setIsLeaf(true);
			}
		}
		return list;
	}

	@Override
	public List<Directory> getDirectorys(int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return directoryDao.search("from Directory where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Directory.NORMAL }, startIndex, rows);
	}
}
