package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AccessLog;

public interface AccessLogService {
	
	public AccessLog getAccessLogById(String logId);
	
	public Long getAccessLogQty();
	
	public Long getAccessLogQtyByOrg(String orgId);
	
	public List<AccessLog> getAccessLogs();
	
	public List<AccessLog> getAccessLogsByOrg(String orgId);
	
	public List<AccessLog> getAccessLogs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<AccessLog> getAccessLogsByOrg(String orgId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public boolean removeAccessLog(String logId);
	
	public boolean removeAccessLog(String[] logIds);
	
	public boolean removeAllAccessLog();
	
	public boolean removeAllAccessLogByOrg(String orgId);
	
	public boolean saveAccessLog(AccessLog accessLog);
	
}