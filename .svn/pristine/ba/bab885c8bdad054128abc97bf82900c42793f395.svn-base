package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DirOpLog;

public interface DirOpLogService {

	/***
	 * 保存目录操作日志信息
	 * @param meeting 目录操作日志对象
	 * @return 保存状态
	 */
	public boolean saveDirOpLog(DirOpLog operationLog);
	
	/**
	 * 根据ID删除目录操作日志信息
	 * @param id 目录操作日志ID
	 * @return 删除状态
	 */
	public boolean removeDirOpLog(String id);
	
	/***
	 * 根据ID伪删除目录操作日志信息（修改目录操作日志删除状态）
	 * @param id 目录操作日志ID
	 * @return 伪删除状态
	 */
	public boolean removeDirOpLogFalse(String id);

	/***
	 * 根据ID获取目录操作日志信息
	 * @param id 目录操作日志ID
	 * @return 目录操作日志信息
	 */
	public DirOpLog getDirOpLogById(String id);
	
	/***
	 * 获取所有目录操作日志数量
	 * @return 目录操作日志数量
	 */
	public Long getDirOpLogQty();
	
	/***
	 * 获取所有的目录操作日志列表信息
	 * @return 目录操作日志列表
	 */
	public List<DirOpLog> getDirOpLogs();
	
	/***
	 * 获取目录操作日志列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 目录操作日志列表
	 */
	public List<DirOpLog> getDirOpLogs(int startIndex, int rows, String sorter, String sortingAttribute);
}
