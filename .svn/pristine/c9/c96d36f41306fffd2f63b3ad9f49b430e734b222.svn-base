package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DocRelationshipDao;
import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.service.DocRelationshipService;
import org.springframework.stereotype.Service;

@Service("docRelationshipService")
public class DocRelationshipServiceImpl implements DocRelationshipService {

	@Resource
	private DocRelationshipDao docRelationshipDao;
	
	@Override
	public boolean saveDocRelationship(DocRelationship docRelationship) {
		String method = "";
		if ( docRelationship.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		docRelationshipDao.saveOrUpdate(docRelationship);
		if ( method.equals("add") ) {
			if ( docRelationship.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeDocRelationship(String id) {
		docRelationshipDao.executeHql("delete from DocRelationship where id = ?", new Object[] { id });
		Long qty = docRelationshipDao.count("select count(id) from DocRelationship where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeDocRelationshipBySrcId(String srcId) {
		docRelationshipDao.executeHql("delete from DocRelationship where srcDocId = ?", new Object[] { srcId });
		Long qty = docRelationshipDao.count("select count(id) from DocRelationship where srcDocId = ?" , new Object[] { srcId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public DocRelationship getDocRelationshipById(String id) {
		return docRelationshipDao.get(DocRelationship.class, id);
	}

	@Override
	public Long getDocRelationshipQty() {
		return docRelationshipDao.count("select count(id) from DocRelationship ", new Object[]{});
	}

	@Override
	public List<DocRelationship> getDocRelationships() {
		return docRelationshipDao.find("from DocRelationship", new Object[]{});
	}

	@Override
	public List<DocRelationship> getDocRelationships(int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return docRelationshipDao.search("from DocRelationship order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	@Override
	public List<DocRelationship> getDocRelationshipsBySrcDocId(String srcDocId) {
		return docRelationshipDao.find("from DocRelationship where srcDocId = ?", new Object[]{ srcDocId});
	}
}
