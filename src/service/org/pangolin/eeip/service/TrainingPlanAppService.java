package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.TrainingPlanApp;

public interface TrainingPlanAppService {


	/***
	 * 保存培训计划信息
	 * @param meeting 培训计划对象
	 * @return 保存状态
	 */
	public boolean saveTrainingPlanApp(TrainingPlanApp trainingPlanApp);
	
	/**
	 * 根据ID删除培训计划信息
	 * @param id 培训计划ID
	 * @return 删除状态
	 */
	public boolean removeTrainingPlanApp(String id);
	
	/***
	 * 根据ID伪删除培训计划信息（修改培训计划删除状态）
	 * @param id 培训计划ID
	 * @return 伪删除状态
	 */
	public boolean removeTrainingPlanAppFalse(String id);
	

	/***
	 * 根据ID获取培训计划信息
	 * @param id 培训计划ID
	 * @return 培训计划信息
	 */
	public TrainingPlanApp getTrainingPlanAppById(String id);
	
	/***
	 * 获取所有培训计划数量
	 * @param queryParam 查询条件
	 * @return 培训计划数量
	 */
	public Long getTrainingPlanAppQty(String queryParam);
	
	/***
	 * 获取所有的培训计划列表信息
	 * @return 培训计划列表
	 */
	public List<TrainingPlanApp> getTrainingPlanApps();
	
	/***
	 * 获取培训计划列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParam 查询条件
	 * @return 培训计划列表
	 */
	public List<TrainingPlanApp> getTrainingPlanApps(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam);
}
