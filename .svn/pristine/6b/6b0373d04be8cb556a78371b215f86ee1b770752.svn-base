package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevAdjPlan;

public interface DevAdjPlanService {
	/**
	 * 根据ID查询DevAdjPlan
	 * ID
	 * @param id
	 * @return
	 */
	public DevAdjPlan getDevAdjPlanById(String id);

	/**
	 * 获取DevAdjPlan总数量
	 * @param devId 
	 * @return
	 */
	public Long getDevAdjPlanQty(String devId);
	
	/**
	 * 获取DevAdjPlan总集合
	 * @return
	 */
	public List<DevAdjPlan> getDevAdjPlans();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<DevAdjPlan> getDevAdjPlans(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevAdjPlan
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjPlan(String id);
	
	/**
	 * 伪删除DevAdjPlan
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjPlanFalse(String id);
	
	/**
	 * 更新 DevAdjPlan
	 * @param DevAdjPlan 对象
	 * @return 更新状态
	 */
	public boolean saveDevAdjPlan(DevAdjPlan devAdjPlan);

	/**
	 * 根据状态搜索
	 * @return
	 */
	public List<DevAdjPlan> getDevAdjPlansByStatus();

	/**
	 * 根据关键字搜索
	 * @param extraParam
	 * @return
	 */
	public List<DevAdjPlan> getDevAdjPlanByQueryParam(String extraParam);


}
