package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevMaintanence;

public interface DevMaintanenceService {
	/**
	 * 根据ID查询DevMaintanence
	 * ID
	 * @param id
	 * @return
	 */
	public DevMaintanence getDevMaintanenceById(String id);

	/**
	 * 获取DevMaintanence总数量
	 * @param devId 
	 * @return
	 */
	public Long getDevMaintanenceQty(String devId);
	
	/**
	 * 获取DevMaintanence总集合
	 * @return
	 */
	public List<DevMaintanence> getDevMaintanences(String id);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<DevMaintanence> getDevMaintanences(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevMaintanence
	 * @param id ID
	 * @return
	 */
	public boolean removeDevMaintanence(String id);
	
	/**
	 * 伪删除DevMaintanence
	 * @param id ID
	 * @return
	 */
	public boolean removeDevMaintanenceFalse(String id);
	
	/**
	 * 更新 DevMaintanence
	 * @param DevMaintanence 对象
	 * @return 更新状态
	 */
	public boolean saveDevMaintanence(DevMaintanence devMaintanence);


}
