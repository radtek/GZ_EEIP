package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevSwUpgrade;

public interface DevSwUpgradeService {
	/**
	 * 根据ID查询DevSwUpgrade
	 * ID
	 * @param id
	 * @return
	 */
	public DevSwUpgrade getDevSwUpgradeById(String id);

	/**
	 * 获取DevSwUpgrade总数量
	 * @param devId 
	 * @return
	 */
	public Long getDevSwUpgradeQty(String devId);
	
	/**
	 * 获取DevSwUpgrade总集合
	 * @return
	 */
	public List<DevSwUpgrade> getDevSwUpgrades(String id);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<DevSwUpgrade> getDevSwUpgrades(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevSwUpgrade
	 * @param id ID
	 * @return
	 */
	public boolean removeDevSwUpgrade(String id);
	
	/**
	 * 伪删除DevSwUpgrade
	 * @param id ID
	 * @return
	 */
	public boolean removeDevSwUpgradeFalse(String id);
	
	/**
	 * 更新 DevSwUpgrade
	 * @param DevSwUpgrade 对象
	 * @return 更新状态
	 */
	public boolean saveDevSwUpgrade(DevSwUpgrade devSwUpgrade);


}
