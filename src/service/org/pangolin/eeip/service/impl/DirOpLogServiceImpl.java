package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DirOpLogDao;
import org.pangolin.eeip.entity.DirOpLog;
import org.pangolin.eeip.service.DirOpLogService;
import org.springframework.stereotype.Service;

@Service("dirOpLogService")
@SuppressWarnings("all")
public class DirOpLogServiceImpl implements DirOpLogService {

	@Resource
	private DirOpLogDao dirOpLogDao;
	
	@Override
	public boolean saveDirOpLog(DirOpLog dirOpLog) {
		String method = "";
		if ( dirOpLog.getId() == null ) { 
			method = "add"; 
			dirOpLog.setEventDate(new Date());
		}
		else { 
			method = "update";
		}
		dirOpLogDao.saveOrUpdate(dirOpLog);
		if ( method.equals("add") ) {
			if ( dirOpLog.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeDirOpLog(String id) {
		dirOpLogDao.executeHql("delete from DirOpLog where id = ?", new Object[] { id });
		Long qty = dirOpLogDao.count("select count(id) from DirOpLog where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeDirOpLogFalse(String id) {
		dirOpLogDao.executeHql("update DirOpLog set delFlag = ? where id = ?", new Object[] { DirOpLog.REMOVED, id });
		Long qty = dirOpLogDao.count("select count(id) from DirOpLog where id = ? and delFlag = ? " , new Object[] { id, DirOpLog.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public DirOpLog getDirOpLogById(String id) {
		return dirOpLogDao.get(DirOpLog.class, id);
	}

	@Override
	public Long getDirOpLogQty() {
		return dirOpLogDao.count("select count(id) from DirOpLog where delFlag = ? ", new Object[]{DirOpLog.NORMAL});
	}

	@Override
	public List<DirOpLog> getDirOpLogs() {
		return dirOpLogDao.find("from DirOpLog where delFlag = ? order by createdDate desc", new Object[]{DirOpLog.NORMAL});
	}

	@Override
	public List<DirOpLog> getDirOpLogs(int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return dirOpLogDao.search("from DirOpLog where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { DirOpLog.NORMAL }, startIndex, rows);
	}
}
