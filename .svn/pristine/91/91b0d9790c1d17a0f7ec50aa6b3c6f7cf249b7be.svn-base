package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AnnualPlanApp;

public interface AnnualPlanAppService {

	/***
	 * 保存年度内部审核申请信息
	 * @param meeting 年度内部审核申请对象
	 * @return 保存状态
	 */
	public boolean saveAnnualPlanApp(AnnualPlanApp annualPlanApp);
	
	/**
	 * 根据ID删除年度内部审核申请信息
	 * @param id 年度内部审核申请ID
	 * @return 删除状态
	 */
	public boolean removeAnnualPlanApp(String id);
	
	/***
	 * 根据ID伪删除年度内部审核申请信息（修改年度内部审核申请删除状态）
	 * @param id 年度内部审核申请ID
	 * @return 伪删除状态
	 */
	public boolean removeAnnualPlanAppFalse(String id);
	

	/***
	 * 根据ID获取年度内部审核申请信息
	 * @param id 年度内部审核申请ID
	 * @return 年度内部审核申请信息
	 */
	public AnnualPlanApp getAnnualPlanAppById(String id);
	
	/***
	 * 获取所有年度内部审核申请数量
	 * @param queryParam 查询条件
	 * @return 年度内部审核申请数量
	 */
	public Long getAnnualPlanAppQty(String queryParam);
	
	/***
	 * 获取所有的年度内部审核申请列表信息
	 * @return 年度内部审核申请列表
	 */
	public List<AnnualPlanApp> getAnnualPlanApps();
	
	/***
	 * 获取年度内部审核申请列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParam 查询条件
	 * @return 年度内部审核申请列表
	 */
	public List<AnnualPlanApp> getAnnualPlanApps(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam);
}
