package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.TmpDocOpLogDao;
import org.pangolin.eeip.entity.TmpDocOpLog;
import org.pangolin.eeip.service.TmpDocOpLogService;
import org.pangolin.util.FileUtil;
import org.springframework.stereotype.Service;

@Service("tmpDocOpLogService")
@SuppressWarnings("all")
public class TmpDocOpLogServiceImpl implements TmpDocOpLogService {

	@Resource
	private TmpDocOpLogDao tmpDocOpLogDao;

	@Override
	public boolean saveTmpDocOpLog(TmpDocOpLog docOperationLog) {
		Long qty = tmpDocOpLogDao.count("select count(id) from TmpDocOpLog where id = ?",new Object[]{ docOperationLog.getId() });
		if ( qty > 0 ) {
			tmpDocOpLogDao.update(docOperationLog);
		} else {
			tmpDocOpLogDao.save(docOperationLog);
		}
		
		return true;
	}

	@Override
	public boolean removeTmpDocOpLogFalse(String id) {
		tmpDocOpLogDao.executeHql("update TmpDocOpLog set delFlag = ? where id = ?", new Object[]{ TmpDocOpLog.REMOVED, id});
		Long qty = tmpDocOpLogDao.count("select count(id) from TmpDocOpLog where id = ? and delFlag = ?", new Object[]{ id, TmpDocOpLog.NORMAL});
		if ( qty > 0 ) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeTmpDocOpLog(String id) {
		String filePath = "" ;
		TmpDocOpLog docOpLog = getTmpDocOpLogById(id);
		if ( docOpLog != null ) {
			filePath = docOpLog.getPath();
		}
		
		tmpDocOpLogDao.executeHql("delete from TmpDocOpLog where id = ? and delFlag = ?", new Object[]{ id, TmpDocOpLog.NORMAL});
		Long qty = tmpDocOpLogDao.count("select count(id) from TmpDocOpLog where id = ? and delFlag = ?", new Object[]{ id, TmpDocOpLog.NORMAL});
		if ( qty.intValue() == 0 ) {
			FileUtil.removeFile(filePath);
			return true;
		}
		return false;
	}

	@Override
	public List<TmpDocOpLog> getTmpDocOpLogsByStatus(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			String hql = "from TmpDocOpLog where delFlag = ? and status = ? and (name like ? or sn like ? ) order by " + sorter + " " + sortingAttribute;
			return tmpDocOpLogDao.search(hql, new Object[]{ TmpDocOpLog.NORMAL, TmpDocOpLog.STATUS_TO_AUDIT, queryParam, queryParam }, startIndex, rows);
		}
		return tmpDocOpLogDao.search("from TmpDocOpLog where delFlag = ? and status = ? order by " + sorter + " " + sortingAttribute, new Object[]{TmpDocOpLog.NORMAL, TmpDocOpLog.STATUS_TO_AUDIT},startIndex,rows);
	}
	
	@Override
	public List<TmpDocOpLog> getTmpDocOpLogs(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			String hql = "from TmpDocOpLog where delFlag = ?  and (name like ? or sn like ? ) order by " + sorter + " " + sortingAttribute;
			return tmpDocOpLogDao.search(hql, new Object[]{ TmpDocOpLog.NORMAL, queryParam, queryParam }, startIndex, rows);
		}
		return tmpDocOpLogDao.search("from TmpDocOpLog where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[]{TmpDocOpLog.NORMAL}, startIndex, rows);
	}

	@Override
	public TmpDocOpLog getTmpDocOpLogById(String id) {
		return tmpDocOpLogDao.get(TmpDocOpLog.class, id);
	}

	@Override
	public TmpDocOpLog getTmpDocOpLogByDocId(String docId) {
		return tmpDocOpLogDao.get("from TmpDocOpLog where delFlag = ? and docId = ?", new Object[]{TmpDocOpLog.NORMAL, docId});
	}

	@Override
	public Long getTmpDocOpLogQtyByStatus(String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			String hql = "select count(id) from TmpDocOpLog where delFlag = ? and status = ? and (name like ? or sn like ? )";
			return tmpDocOpLogDao.count(hql, new Object[]{ TmpDocOpLog.NORMAL, TmpDocOpLog.STATUS_TO_AUDIT, queryParam, queryParam });
		}
		return tmpDocOpLogDao.count("select count(id) from TmpDocOpLog where delFlag = ? and status = ?", new Object[]{TmpDocOpLog.NORMAL, TmpDocOpLog.STATUS_TO_AUDIT});
	}
	
	@Override
	public Long getTmpDocOpLogQty(String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			String hql = "select count(id) from TmpDocOpLog where delFlag = ? and (name like ? or sn like ? ) ";
			return tmpDocOpLogDao.count(hql, new Object[]{ TmpDocOpLog.NORMAL, queryParam, queryParam });
		}
		return tmpDocOpLogDao.count("select count(id) from TmpDocOpLog where delFlag = ? ", new Object[]{TmpDocOpLog.NORMAL});
	}
	
	
}
