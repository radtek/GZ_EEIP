package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ImplPlanApp;

public interface ImplPlanAppService {

	/***
	 * 保存内部审核实施计划申请信息
	 * @param meeting 内部审核实施计划申请对象
	 * @return 保存状态
	 */
	public boolean saveImplPlanApp(ImplPlanApp implPlanApp);
	
	/**
	 * 根据ID删除内部审核实施计划申请信息
	 * @param id 内部审核实施计划申请ID
	 * @return 删除状态
	 */
	public boolean removeImplPlanApp(String id);
	
	/***
	 * 根据ID伪删除内部审核实施计划申请信息（修改内部审核实施计划申请删除状态）
	 * @param id 内部审核实施计划申请ID
	 * @return 伪删除状态
	 */
	public boolean removeImplPlanAppFalse(String id);

	/***
	 * 根据ID获取内部审核实施计划申请信息
	 * @param id 内部审核实施计划申请ID
	 * @return 内部审核实施计划申请信息
	 */
	public ImplPlanApp getImplPlanAppById(String id);
	
	/***
	 * 获取所有内部审核实施计划申请数量
	 * @return 内部审核实施计划申请数量
	 */
	public Long getImplPlanAppQty(String queryParams);
	
	/***
	 * 获取所有的内部审核实施计划申请列表信息
	 * @return 内部审核实施计划申请列表
	 */
	public List<ImplPlanApp> getImplPlanApps();
	
	/***
	 * 获取内部审核实施计划申请列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParams 查询条件
	 * @return 内部审核实施计划申请列表
	 */
	public List<ImplPlanApp> getImplPlanApps(int startIndex, int rows, String sorter, String sortingAttribute,String queryParams);
}
