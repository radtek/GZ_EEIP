package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.SystemLogDao;
import org.pangolin.eeip.entity.SystemLog;
import org.pangolin.eeip.service.SystemLogService;
import org.springframework.stereotype.Service;

@Service("systemLogService")
@SuppressWarnings("all")
public class SystemLogServiceImpl implements SystemLogService {

	@Resource
	private SystemLogDao systemLogDao;
	
	public SystemLog getSystemLogById(String logId) {
		return systemLogDao.get(SystemLog.class, logId);
	}
	
	public Long getSystemLogQty() {
		return systemLogDao.count("select count(logId) from SystemLog");
	}
	
	public Long getSystemLogQtyByLogType(Integer logType) {
		return systemLogDao.count("select count(logId) from SystemLog where logType = ?", new Object[] { logType });
	}
	
	public List<SystemLog> getSystemLogs() {
		return systemLogDao.find("from SystemLog order by eventDate desc");
	}
	
	public List<SystemLog> getSystemLogsByLogType(Integer logType) {
		return systemLogDao.find("from SystemLog where logType = ? order by eventDate desc", new Object[] { logType });
	}
	
	public List<SystemLog> getSystemLogs(int startIndex, int rows, String sorter, String sortingAttribute) {
		return systemLogDao.search("from SystemLog order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<SystemLog> getSystemLogsByLogType(Integer logType, int startIndex, int rows, String sorter, String sortingAttribute) {
		return systemLogDao.search("from SystemLog where logType = ? order by " + sorter + " " + sortingAttribute, new Object[] { logType }, startIndex, rows);
	}
	
	public boolean removeSystemLog(String logId) {
		systemLogDao.executeHql("delete from SystemLog where logId = ?", new Object[] { logId });
		Long qty = systemLogDao.count("select count(logId) from SystemLog where logId = ?" , new Object[] { logId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeSystemLog(String[] logIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String logId : logIds) {
			systemLogDao.executeHql("delete from SystemLog where logId = ?", new Object[] { logId });
			qty = systemLogDao.count("select count(logId) from SystemLog where logId = ?" , new Object[] { logId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == logIds.length ) return true;
		return false;
	}
	
	public boolean removeAllSystemLog() {
		systemLogDao.executeHql("delete from SystemLog", new Object[] {  });
		Long qty = getSystemLogQty();
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveSystemLog(SystemLog systemLog) {
		String method = "";
		if ( systemLog.getLogId() == null ) { method = "add"; }
		else { method = "update"; }
		systemLogDao.saveOrUpdate(systemLog);
		if ( method.equals("add") ) {
			if ( systemLog.getLogId() != null ) return true;
		} else { return true; }
		return false;
	}
}