package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AccessLogDao;
import org.pangolin.eeip.entity.AccessLog;
import org.pangolin.eeip.service.AccessLogService;
import org.springframework.stereotype.Service;

@Service("accessLogService")
@SuppressWarnings("all")
public class AccessLogServiceImpl implements AccessLogService {

	@Resource
	private  AccessLogDao accessLogDao;
	
	public AccessLog getAccessLogById(String logId) {
		return accessLogDao.get(AccessLog.class, logId);
	}
	
	public Long getAccessLogQty() {
		return accessLogDao.count("select count(logId) from AccessLog");
	}
	
	public Long getAccessLogQtyByOrg(String orgId) {
		return accessLogDao.count("select count(logId) from AccessLog where orgId = ?", new Object[] { orgId });
	}
	
	public List<AccessLog> getAccessLogs() {
		return accessLogDao.find("from AccessLog order by eventDate desc");
	}
	
	public List<AccessLog> getAccessLogsByOrg(String orgId) {
		return accessLogDao.find("from AccessLog where orgId = ? order by eventDate desc", new Object[] { orgId });
	}
	
	public List<AccessLog> getAccessLogs(int startIndex, int rows, String sorter, String sortingAttribute) {
		return accessLogDao.search("from AccessLog order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<AccessLog> getAccessLogsByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return accessLogDao.search("from AccessLog where orgId = ? order by " + sorter + " " + sortingAttribute, new Object[] { orgId }, startIndex, rows);
	}
	
	public boolean removeAccessLog(String logId) {
		accessLogDao.executeHql("delete from AccessLog where logId = ?", new Object[] { logId });
		Long qty = accessLogDao.count("select count(logId) from AccessLog where logId = ?" , new Object[] { logId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeAccessLog(String[] logIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String logId : logIds) {
			accessLogDao.executeHql("delete from AccessLog where logId = ?", new Object[] { logId });
			qty = accessLogDao.count("select count(logId) from AccessLog where logId = ?" , new Object[] { logId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == logIds.length ) return true;
		return false;
	}
	
	public boolean removeAllAccessLog() {
		accessLogDao.executeHql("delete from AccessLog", new Object[] {  });
		Long qty = getAccessLogQty();
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeAllAccessLogByOrg(String orgId) {
		accessLogDao.executeHql("delete from AccessLog where orgId = ?", new Object[] { orgId });
		Long qty = getAccessLogQtyByOrg(orgId);
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveAccessLog(AccessLog accessLog) {
		String method = "";
		if ( accessLog.getLogId() == null ) { method = "add"; }
		else { method = "update"; }
		accessLogDao.saveOrUpdate(accessLog);
		if ( method.equals("add") ) {
			if ( accessLog.getLogId() != null ) return true;
		} else { return true; }
		return false;
	}
}