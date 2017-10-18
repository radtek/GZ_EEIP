package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.InquestDocDao;
import org.pangolin.eeip.entity.InquestDoc;
import org.pangolin.eeip.service.InquestDocService;
import org.springframework.stereotype.Service;

@Service("inquestDocService")
public class InquestDocServiceImpl implements InquestDocService {

	@Resource
	private InquestDocDao inquestDocDao;
	
	@Override
	public boolean saveInquestDoc(InquestDoc inquestDoc) {
		String method = "";
		if ( inquestDoc.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		inquestDocDao.saveOrUpdate(inquestDoc);
		if ( method.equals("add") ) {
			if ( inquestDoc.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeInquestDoc(String id) {
		inquestDocDao.executeHql("delete from InquestDoc where id = ?", new Object[] { id });
		Long qty = inquestDocDao.count("select count(id) from InquestDoc where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeInquestDocFalse(String id) {
		inquestDocDao.executeHql("update InquestDoc set delFlag = ? where id = ?", new Object[] { InquestDoc.REMOVED, id });
		Long qty = inquestDocDao.count("select count(id) from InquestDoc where id = ? and delFlag = ? " , new Object[] { id, InquestDoc.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public InquestDoc getInquestDocById(String id) {
		return inquestDocDao.get(InquestDoc.class, id);
	}

	@Override
	public Long getInquestDocQty() {
		return inquestDocDao.count("select count(id) from InquestDoc where delFlag = ? ", new Object[]{ InquestDoc.NORMAL });
	}

	@Override
	public List<InquestDoc> getInquestDocs() {
		return inquestDocDao.find("from InquestDoc where delFlag = ? order by createdDate desc", new Object[]{ InquestDoc.NORMAL });
	}

	@Override
	public List<InquestDoc> getInquestDocs(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return inquestDocDao.search("from InquestDoc where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { InquestDoc.NORMAL }, startIndex, rows);
	}

	@Override
	public List<InquestDoc> getInquestDocsByInquestId(String inquestId) {
		return inquestDocDao.find("from InquestDoc where delFlag = ? and inquestId = ?", new Object[]{ InquestDoc.NORMAL, inquestId });
	}
}
