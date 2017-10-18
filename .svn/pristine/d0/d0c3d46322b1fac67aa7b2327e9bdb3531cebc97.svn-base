package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevAdjApp;

public interface DevAdjAppService {
	/**
	 * 根据ID查询DevAdjApp
	 * ID
	 * @param id
	 * @return
	 */
	public DevAdjApp getDevAdjAppById(String id);

	/**
	 * 获取DevAdjApp总数量
	 * @param devId 
	 * @return
	 */
	public Long getDevAdjAppQty(String devId);
	
	/**
	 * 获取DevAdjApp总集合
	 * @return
	 */
	public List<DevAdjApp> getDevAdjApps();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<DevAdjApp> getDevAdjApps(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevAdjApp
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjApp(String id);
	
	/**
	 * 伪删除DevAdjApp
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjAppFalse(String id);
	
	/**
	 * 更新 DevAdjApp
	 * @param DevAdjApp 对象
	 * @return 更新状态
	 */
	public boolean saveDevAdjApp(DevAdjApp devAdjApp);

	/**
	 * 获取待审批列表
	 * @return
	 */
	public List<DevAdjApp> getDevAdjAppByStatus();

	/**
	 * 根据条件查询列表
	 * @param extraParam
	 * @return
	 */
	public List<DevAdjApp> getDevAdjAppByQueryParam(String extraParam);


}
