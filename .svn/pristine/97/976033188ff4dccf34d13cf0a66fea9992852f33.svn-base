package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AnnualPlan;

public interface AnnualPlanService {

	/***
	 * 保存年度内部审核计划信息
	 * @param meeting 年度内部审核计划对象
	 * @return 保存状态
	 */
	public boolean saveAnnualPlan(AnnualPlan annualPlan);
	
	/**
	 * 根据ID删除年度内部审核计划信息
	 * @param id 年度内部审核计划ID
	 * @return 删除状态
	 */
	public boolean removeAnnualPlan(String id);
	

	/***
	 * 根据ID获取年度内部审核计划信息
	 * @param id 年度内部审核计划ID
	 * @return 年度内部审核计划信息
	 */
	public AnnualPlan getAnnualPlanById(String id);
	
	/***
	 * 获取所有年度内部审核计划数量
	 * @return 年度内部审核计划数量
	 */
	public Long getAnnualPlanQty();
	
	/***
	 * 获取所有的年度内部审核计划列表信息
	 * @return 年度内部审核计划列表
	 */
	public List<AnnualPlan> getAnnualPlans();
	
	/***
	 * 获取年度内部审核计划列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 年度内部审核计划列表
	 */
	public List<AnnualPlan> getAnnualPlans(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据年度内部审核申请ID获取年度内部审核计划信息列表
	 * @param annualPlanAppId 年度内部审核申请ID
	 * @return 年度内部审核计划列表
	 */
	public List<AnnualPlan> getAnnualPlansByAppId(String annualPlanAppId);
}
