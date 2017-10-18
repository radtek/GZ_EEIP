package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AppraisalRevise;

public interface AppraisalReviseService {
	/**
	 * 根据ID查询AppraisalRevise
	 * ID
	 * @param id
	 * @return
	 */
	public AppraisalRevise getAppraisalReviseById(String id);

	/**
	 * 获取AppraisalRevise总数量 (条件下)
	 * @param query 检索关键字
	 * @param status 状态
	 * @return
	 */
	public Long getAppraisalReviseQty(String query,Integer status);
	
	/**
	 * 获取AppraisalRevise总数量 (条件下) 
	 * @param status 状态
	 * @return
	 */
	public Long getAppraisalReviseQty(Integer status);
	
	
	/**
	 * 获取AppraisalRevise总数量  
	 * @return
	 */
	public Long getAppraisalReviseQty(String userId);
	
	
	/**
	 * 获取AppraisalRevise总集合
	 * @return
	 */
	public List<AppraisalRevise> getAppraisalRevises();
	
	/**
	 * 获取AppraisalRevise总集合 通过UserID
	 * @param userId  用户ID
	 * @return
	 */
	public List<AppraisalRevise> getAppraisalRevises(String userId);
	
	/**
	 * 分页查询 (条件下)
	 * @param query 检索关键字
	 * @param status 状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisalRevise> getAppraisalRevises(String query,Integer status,int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 分页查询 (条件下) 
	 * @param status 状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisalRevise> getAppraisalRevises(Integer status,int startIndex, int rows, String sorter, String sortingAttribute);
		
	
	/**
	 * 分页查询   
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisalRevise> getAppraisalRevises(int startIndex, int rows, String sorter, String sortingAttribute,String userId);
	
	
	/**
	 * 删除AppraisalRevise
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisalRevise(String id);
	
	/**
	 * 更新 AppraisalRevise
	 * @param AppraisalRevise 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisalRevise(AppraisalRevise appraisalRevise);

	/**
	 * 看看是否能再次申请文书修改审批
	 * @param appraisalId
	 * @return
	 */
	public AppraisalRevise getAppraisalReviseByAppraisalId(String appraisalId);

	 
}
