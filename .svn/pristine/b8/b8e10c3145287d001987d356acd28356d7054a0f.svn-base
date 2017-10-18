package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DocOpLogDao;
import org.pangolin.eeip.entity.DocOpLog;
import org.pangolin.eeip.service.DocOpLogService;
import org.springframework.stereotype.Service;

@Service("docOpLogService")
public class DocOpLogServiceImpl implements DocOpLogService {

	@Resource
	private DocOpLogDao docOpLogDao;
	
	@Override
	public boolean saveDocOpLog(DocOpLog docOpLog) {
		String method = "";
		if ( docOpLog.getId() == null ) { 
			method = "add"; 
			docOpLog.setEventDate(new Date());
		}
		else { 
			method = "update";
		}
		docOpLogDao.saveOrUpdate(docOpLog);
		if ( method.equals("add") ) {
			if ( docOpLog.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeDocOpLog(String id) {
		docOpLogDao.executeHql("delete from DocOpLog where id = ?", new Object[] { id });
		Long qty = docOpLogDao.count("select count(id) from DocOpLog where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeDocOpLogFalse(String id) {
		docOpLogDao.executeHql("update DocOpLog set delFlag = ? where id = ?", new Object[] { DocOpLog.REMOVED, id });
		Long qty = docOpLogDao.count("select count(id) from DocOpLog where id = ? and delFlag = ? " , new Object[] { id, DocOpLog.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public DocOpLog getDocOpLogById(String id) {
		return docOpLogDao.get(DocOpLog.class, id);
	}

	@Override
	public Long getDocOpLogQty() {
		return docOpLogDao.count("select count(id) from DocOpLog where delFlag = ? ", new Object[]{DocOpLog.NORMAL});
	}

	@Override
	public List<DocOpLog> getDocOpLogs() {
		return docOpLogDao.find("from DocOpLog where delFlag = ? order by createdDate desc", new Object[]{DocOpLog.NORMAL});
	}

	@Override
	public List<DocOpLog> getDocOpLogs(int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return docOpLogDao.search("from DocOpLog where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { DocOpLog.NORMAL }, startIndex, rows);
	}
}
