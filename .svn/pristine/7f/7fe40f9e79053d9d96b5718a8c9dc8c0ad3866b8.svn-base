package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MgtRvwPlanApp;

public interface MgtRvwPlanAppService {

	/***
	 * 保存管理评审计划申请信息
	 * @param meeting 管理评审计划申请对象
	 * @return 保存状态
	 */
	public boolean saveMgtRvwPlanApp(MgtRvwPlanApp mgtRvwPlanApp);
	
	/**
	 * 根据ID删除管理评审计划申请信息
	 * @param id 管理评审计划申请ID
	 * @return 删除状态
	 */
	public boolean removeMgtRvwPlanApp(String id);
	
	/***
	 * 根据ID伪删除管理评审计划申请信息（修改管理评审计划申请删除状态）
	 * @param id 管理评审计划申请ID
	 * @return 伪删除状态
	 */
	public boolean removeMgtRvwPlanAppFalse(String id);

	/***
	 * 根据ID获取管理评审计划申请信息
	 * @param id 管理评审计划申请ID
	 * @return 管理评审计划申请信息
	 */
	public MgtRvwPlanApp getMgtRvwPlanAppById(String id);
	
	/***
	 * 获取所有管理评审计划申请数量
	 * @return 管理评审计划申请数量
	 */
	public Long getMgtRvwPlanAppQty(String queryParams);
	
	/***
	 * 获取所有的管理评审计划申请列表信息
	 * @return 管理评审计划申请列表
	 */
	public List<MgtRvwPlanApp> getMgtRvwPlanApps();
	
	/***
	 * 获取管理评审计划申请列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParams 查询条件
	 * @return 管理评审计划申请列表
	 */
	public List<MgtRvwPlanApp> getMgtRvwPlanApps(int startIndex, int rows, String sorter, String sortingAttribute,String queryParams);
}
