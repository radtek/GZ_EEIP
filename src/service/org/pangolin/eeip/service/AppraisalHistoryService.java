package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AppraisalHistory;

public interface AppraisalHistoryService {
	/**
	 * 根据ID查询AppraisalHistory
	 * ID
	 * @param id
	 * @return
	 */
	public AppraisalHistory getAppraisalHistoryById(String id);

	/**
	 * 获取AppraisalHistory总数量
	 * @return
	 */
	public Long getAppraisalHistoryQty();
	
	/**
	 * 获取AppraisalHistory总集合
	 * @return
	 */
	public List<AppraisalHistory> getAppraisalHistorys();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisalHistory> getAppraisalHistorys(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除AppraisalHistory
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisalHistory(String id);
	
	/**
	 * 更新 AppraisalHistory
	 * @param AppraisalHistory 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisalHistory(AppraisalHistory appraisalHistory);

	/**
	 * 电子物证（检材）鉴定 移动到历史表单
	 * @param appraisalHistory
	 * @param appraisalId
	 * @return
	 */
	public AppraisalHistory saveAppraisalToHistory(AppraisalHistory appraisalHistory, String appraisalId);

}
