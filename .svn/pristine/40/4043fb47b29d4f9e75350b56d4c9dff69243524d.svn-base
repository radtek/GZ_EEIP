package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevAdjPlanItem;

public interface DevAdjPlanItemService {
	/**
	 * 根据ID查询DevAdjPlanItem
	 * ID
	 * @param id
	 * @return
	 */
	public DevAdjPlanItem getDevAdjPlanItemById(String id);

	/**
	 * 获取DevAdjPlanItem总数量
	 * @param devId 
	 * @param adjId 
	 * @return
	 */
	public Long getDevAdjPlanItemQty(String adjId, String devId);
	
	/**
	 * 获取DevAdjPlanItem总集合
	 * @return
	 */
	public List<DevAdjPlanItem> getDevAdjPlanItems();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @param adjId 
	 * @return
	 */
	public List<DevAdjPlanItem> getDevAdjPlanItems(int startIndex, int rows, String sorter, String sortingAttribute, String adjId, String devId);
	
	/**
	 * 删除DevAdjPlanItem
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjPlanItem(String id);
	
	/**
	 * 伪删除DevAdjPlanItem
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjPlanItemFalse(String id);
	
	/**
	 * 更新 DevAdjPlanItem
	 * @param DevAdjPlanItem 对象
	 * @return 更新状态
	 */
	public boolean saveDevAdjPlanItem(DevAdjPlanItem devAdjPlanItem);

	/**
	 * 根据计划的Id获取计划项目的实体
	 * @param devicePlanId
	 * @return
	 */
	public DevAdjPlanItem getDevAdjPlanByDevPlanId(String devicePlanId);


}
