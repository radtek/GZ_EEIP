package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.entity.OperationLog;

public interface OperationLogService {
	
	public OperationLog getOperationLogById(String logId);
	
	public Long getOperationLogQty();
	
	public Long getOperationLogQtyByOrg(String orgId);
	
	public List<OperationLog> getOperationLogs();
	
	public List<OperationLog> getOperationLogsByOrg(String orgId);
	
	public List<OperationLog> getOperationLogs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<OperationLog> getOperationLogsByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public boolean removeOperationLog(String logId);
	
	public boolean removeOperationLog(String[] logIds);
	
	public boolean removeAllOperationLog();
	
	public boolean removeAllOperationLogByOrg(String orgId);
	
	public boolean saveOperationLog(OperationLog operationLog);
	
	public boolean saveOperationLog(String moduleName, Integer logType, String logEvent, CurrentUser currentUser);
	
}