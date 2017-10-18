package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DocOpLog;

public interface DocOpLogService {

	/***
	 * 保存文档操作日志信息
	 * @param meeting 文档操作日志对象
	 * @return 保存状态
	 */
	public boolean saveDocOpLog(DocOpLog docOperationLog);
	
	/**
	 * 根据ID删除文档操作日志信息
	 * @param id 文档操作日志ID
	 * @return 删除状态
	 */
	public boolean removeDocOpLog(String id);
	
	/***
	 * 根据ID伪删除文档操作日志信息（修改文档操作日志删除状态）
	 * @param id 文档操作日志ID
	 * @return 伪删除状态
	 */
	public boolean removeDocOpLogFalse(String id);

	/***
	 * 根据ID获取文档操作日志信息
	 * @param id 文档操作日志ID
	 * @return 文档操作日志信息
	 */
	public DocOpLog getDocOpLogById(String id);
	
	/***
	 * 获取所有文档操作日志数量
	 * @return 文档操作日志数量
	 */
	public Long getDocOpLogQty();
	
	/***
	 * 获取所有的文档操作日志列表信息
	 * @return 文档操作日志列表
	 */
	public List<DocOpLog> getDocOpLogs();
	
	/***
	 * 获取文档操作日志列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 文档操作日志列表
	 */
	public List<DocOpLog> getDocOpLogs(int startIndex, int rows, String sorter, String sortingAttribute);
}
