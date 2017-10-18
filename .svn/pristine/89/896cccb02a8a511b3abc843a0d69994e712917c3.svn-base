package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.TmpDocOpLog;

public interface TmpDocOpLogService {

	/***
	 * 保存临时文件信息
	 * @param docOperationLog 临时文件
	 * @return 保存状态
	 */
	public boolean saveTmpDocOpLog(TmpDocOpLog docOperationLog);
	
	/***
	 * 根据ID删除临时文件信息（伪删除，更改文件状态）
	 * @param id ID
	 * @return 删除状态
	 */
	public boolean removeTmpDocOpLogFalse(String id);
	
	/***
	 * 根据ID删除临时文件信息
	 * @param id ID
	 * @return 删除状态
	 */
	public boolean removeTmpDocOpLog(String id);
	
	/***
	 * 获取待审核临时文件列表信息
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<TmpDocOpLog> getTmpDocOpLogsByStatus(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam);
	
	/***
	 * 获取临时文件列表信息
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParam 查询条件
	 * @return
	 */
	public List<TmpDocOpLog> getTmpDocOpLogs(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam);
	
	/***
	 * 获取待审核临时文件数量
	 * @return
	 */
	public Long getTmpDocOpLogQtyByStatus(String queryParam);
	
	/***
	 * 获取临时文件数量
	 * @return
	 */
	public Long getTmpDocOpLogQty(String queryParam);
	
	/***
	 * 根据ID获取临时文件信息
	 * @param id ID
	 * @return
	 */
	public TmpDocOpLog getTmpDocOpLogById(String id);
	
	/***
	 * 根据正式文件ID获取临时文件信息
	 * @param docId 正式文件ID
	 * @return
	 */
	public TmpDocOpLog getTmpDocOpLogByDocId(String docId);
}
