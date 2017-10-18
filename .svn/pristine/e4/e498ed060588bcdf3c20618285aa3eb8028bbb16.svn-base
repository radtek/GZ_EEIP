package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevDiscardApp;

public interface DevDiscardAppService {
	/**
	 * 根据ID查询DevDiscardApp
	 * ID
	 * @param id
	 * @return
	 */
	public DevDiscardApp getDevDiscardAppById(String id);

	/**
	 * 获取DevDiscardApp总数量
	 * @return
	 */
	public Long getDevDiscardAppQty();
	
	/**
	 * 获取DevDiscardApp总集合
	 * @return
	 */
	public List<DevDiscardApp> getDevDiscardApps();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<DevDiscardApp> getDevDiscardApps(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除DevDiscardApp
	 * @param id ID
	 * @return
	 */
	public boolean removeDevDiscardApp(String id);
	
	/**
	 * 伪删除DevDiscardApp
	 * @param id ID
	 * @return
	 */
	public boolean removeDevDiscardAppFalse(String id);
	
	/**
	 * 更新 DevDiscardApp
	 * @param DevDiscardApp 对象
	 * @return 更新状态
	 */
	public boolean saveDevDiscardApp(DevDiscardApp devDiscardApp);

	/**
	 * 根据状态获取list
	 * @param status
	 * @return 更新状态
	 */
	public List<DevDiscardApp> getDevDiscardAppByStatus();

	/**
	 * 根据deviceId返回对象
	 * @param deviceId
	 * @return 更新状态
	 */
	public DevDiscardApp getDevDiscardAppByDeviceId(String deviceId);

	/**
	 * 根据搜索条件查询
	 * @param extraParam
	 * @return
	 */
	public List<DevDiscardApp> getDevDiscardAppByQueryParam(String extraParam);


}
