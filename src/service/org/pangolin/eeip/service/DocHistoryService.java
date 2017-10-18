package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DocHistory;

public interface DocHistoryService {

	/***
	 * 保存文件历史记录信息
	 * @param docHistory 文件历史记录对象
	 * @return 保存状态
	 */
	public boolean saveDocHistory(DocHistory docHistory);
	
	/***
	 * 根据正式文件ID获取文件历史记录信息列表
	 * @param docId 正式文件ID
	 * @return 文件历史记录列表
	 */
	public List<DocHistory> getDocHistorysByDocId(String docId);
	
	/***
	 * 根据正式文件ID获取文件历史记录信息列表
	 * @param docId 正式文件ID
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 文件历史记录列表
	 */
	public List<DocHistory> getDocHistorysByDocId(String docId,int startIndex, int rows,String sorter, String sortingAttribute );
	
	/***
	 * 根据ID获取文件历史记录信息
	 * @param id ID
	 * @return 文件历史记录对象
	 */
	public DocHistory getDocHistory(String id);
}
