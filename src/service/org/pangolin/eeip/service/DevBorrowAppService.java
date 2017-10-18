package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevBorrowApp;

public interface DevBorrowAppService {
	/**
	 * 根据ID查询DevBorrowApp
	 * ID
	 * @param id
	 * @return
	 */
	public DevBorrowApp getDevBorrowAppById(String id);

	/**
	 * 获取DevBorrowApp总数量
	 * @return
	 */
	public Long getDevBorrowAppQty();
	
	/**
	 * 获取DevBorrowApp总集合
	 * @return
	 */
	public List<DevBorrowApp> getDevBorrowApps();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param extraParam 
	 * @return
	 */
	public List<DevBorrowApp> getDevBorrowApps(int startIndex, int rows, String sorter, String sortingAttribute, String extraParam);
	
	/**
	 * 删除DevBorrowApp
	 * @param id ID
	 * @return
	 */
	public boolean removeDevBorrowApp(String id);
	
	/**
	 * 伪删除DevBorrowApp
	 * @param id ID
	 * @return
	 */
	public boolean removeDevBorrowAppFalse(String id);
	
	/**
	 * 更新 DevBorrowApp
	 * @param DevBorrowApp 对象
	 * @return 更新状态
	 */
	public boolean saveDevBorrowApp(DevBorrowApp devBorrowApp);


}
