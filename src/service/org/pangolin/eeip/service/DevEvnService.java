package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevEvn;

public interface DevEvnService {
	
	/**
	 * 根据ID查询DevEvn
	 * ID
	 * @param id
	 * @return
	 */
	public DevEvn getDevEvnById(String id);

	/**
	 * 获取DevEvn总数量
	 * @param endDate 
	 * @param startDate 
	 * @param queryParam 
	 * @return
	 */
	public Long getDevEvnQty(String queryParam, String startDate, String endDate);
	
	/**
	 * 获取DevEvn总集合
	 * @return
	 */
	public List<DevEvn> getDevEvns();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param endDate 
	 * @param startDate 
	 * @param queryParam 
	 * @return
	 */
	public List<DevEvn> getDevEvns(int startIndex, int rows, String sorter, String sortingAttribute, String queryParam, String startDate, String endDate);
	
	/**
	 * 更新 DevEvn
	 * @param DevEvn 对象
	 * @return 更新状态
	 */
	public boolean saveDevEvn(DevEvn devEvn);

	/**
	 * 根据位置获取最近一次获取的温湿度
	 * @param location OFFICE_ROOM/SERVER_ROOM
	 * @return
	 */
	public DevEvn getDevEvnByCreateDate(String location);

	/**
	 * 换取列表数据
	 * @param queryParam
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<DevEvn> getDevEvnList(String queryParam, String startDate, String endDate);

}