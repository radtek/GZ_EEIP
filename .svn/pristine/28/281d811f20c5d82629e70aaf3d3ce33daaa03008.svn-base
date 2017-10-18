package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.SystemLog;

public interface SystemLogService {
	
	public SystemLog getSystemLogById(String logId);
	
	public Long getSystemLogQty();
	
	public Long getSystemLogQtyByLogType(Integer logType);

	public List<SystemLog> getSystemLogs();
	
	public List<SystemLog> getSystemLogsByLogType(Integer logType);
	
	public List<SystemLog> getSystemLogs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	public List<SystemLog> getSystemLogsByLogType(Integer logType, int startIndex, int rows, String sorter, String sortingAttribute);
	
	public boolean removeSystemLog(String logId);
	
	public boolean removeSystemLog(String[] logIds);
	
	public boolean removeAllSystemLog();
	
	public boolean saveSystemLog(SystemLog systemLog);
	
}
