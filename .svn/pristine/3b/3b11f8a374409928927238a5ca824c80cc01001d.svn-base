package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AppraisalReviseEntruster;

public interface AppraisalReviseEntrusterService {
	/**
	 * 根据ID查询AppraisalReviseEntruster
	 * ID
	 * @param id
	 * @return
	 */
	public AppraisalReviseEntruster getAppraisalReviseEntrusterById(String id);

	/**
	 * 获取AppraisalReviseEntruster总数量
	 * @return
	 */
	public Long getAppraisalReviseEntrusterQty();
	
	/**
	 * 获取AppraisalReviseEntruster总集合
	 * @return
	 */
	public List<AppraisalReviseEntruster> getAppraisalReviseEntrusters();
	
	/**
	 * 获取AppraisalReviseEntruster总集合
	 * appraisalReviseAppId 电子物证文书修改申请ID
	 * @return
	 */
	public List<AppraisalReviseEntruster> getAppraisalReviseEntrusters(String appraisalReviseAppId);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisalReviseEntruster> getAppraisalReviseEntrusters(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除AppraisalReviseEntruster
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisalReviseEntruster(String id);
	
	/**
	 * 更新 AppraisalReviseEntruster
	 * @param AppraisalReviseEntruster 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisalReviseEntruster(AppraisalReviseEntruster appraisalReviseEntruster);

}
