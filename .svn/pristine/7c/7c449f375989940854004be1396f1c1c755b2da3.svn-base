package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.dao.OperationLogDao;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.service.OperationLogService;
import org.springframework.stereotype.Service;

@Service("operationLogService")
@SuppressWarnings("all")
public class OperationLogServiceImpl implements OperationLogService {

	@Resource
	private OperationLogDao operationLogDao;
	
	public OperationLog getOperationLogById(String logId) {
		return operationLogDao.get(OperationLog.class, logId);
	}
	
	public Long getOperationLogQty() {
		return operationLogDao.count("select count(logId) from OperationLog");
	}
	
	public Long getOperationLogQtyByOrg(String orgId) {
		return operationLogDao.count("select count(logId) from OperationLog where orgId = ?", new Object[] { orgId });
	}
	
	public List<OperationLog> getOperationLogs() {
		return operationLogDao.find("from OperationLog order by eventDate desc");
	}
	
	public List<OperationLog> getOperationLogsByOrg(String orgId) {
		return operationLogDao.find("from OperationLog where orgId = ? order by eventDate desc", new Object[] { orgId });
	}
	
	public List<OperationLog> getOperationLogs(int startIndex, int rows, String sorter, String sortingAttribute) {
		return operationLogDao.search("from OperationLog order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<OperationLog> getOperationLogsByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute) {
		return operationLogDao.search("from OperationLog where orgId = ? order by " + sorter + " " + sortingAttribute, new Object[] { orgId }, startIndex, rows);
	}
	
	public boolean removeOperationLog(String logId) {
		operationLogDao.executeHql("delete from OperationLog where logId = ?", new Object[] { logId });
		Long qty = operationLogDao.count("select count(logId) from OperationLog where logId = ?" , new Object[] { logId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeOperationLog(String[] logIds) {
		Long qty = new Long(0);
		Long deletedQty = new Long(0);
		for (String logId : logIds) {
			operationLogDao.executeHql("delete from OperationLog where logId = ?", new Object[] { logId });
			qty = operationLogDao.count("select count(logId) from OperationLog where logId = ?" , new Object[] { logId });
			if ( qty.intValue() == 0 ) deletedQty ++;
		}
		if ( deletedQty.intValue() == logIds.length ) return true;
		return false;
	}
	
	public boolean removeAllOperationLog() {
		operationLogDao.executeHql("delete from OperationLog", new Object[] {  });
		Long qty = getOperationLogQty();
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean removeAllOperationLogByOrg(String orgId) {
		operationLogDao.executeHql("delete from OperationLog where orgId = ?", new Object[] { orgId });
		Long qty = getOperationLogQtyByOrg(orgId);
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveOperationLog(OperationLog operationLog) {
		String method = "";
		if ( operationLog.getLogId() == null ) { method = "add"; }
		else { method = "update"; }
		operationLogDao.saveOrUpdate(operationLog);
		if ( method.equals("add") ) {
			if ( operationLog.getLogId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean saveOperationLog(String moduleName, Integer logType, String logEvent, CurrentUser currentUser) {
		boolean status = false;
		try {
			OperationLog operationLog = new OperationLog();
			operationLog.setModuleName(moduleName);
			operationLog.setLogEvent(logEvent);
			operationLog.setUserName(currentUser.getUserName());
			operationLog.setUserAlias(currentUser.getUserAlias());
			operationLog.setUserIPAddress(currentUser.getIpAddr());
			operationLog.setLogType(logType);
			operationLog.setOrgId(currentUser.getOrgId());
			status = saveOperationLog(operationLog);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
}