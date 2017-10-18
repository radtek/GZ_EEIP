package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Advertisement;

public interface AdvertisementService {
	
	/**
	 * 根据ID获取广告信息
	 * @author Oscar Mok
	 * @param id 广告ID
	 * @return 广告信息
	 * */
	public Advertisement getAdvertisementById(String id);
	
	/**
	 * 获取所有广告数量
	 * @author Oscar Mok
	 * @return 广告数量
	 * */
	public Long getAdvertisementQty();
	
	/**
	 * 获取所有广告列表
	 * @author Oscar Mok
	 * @return 广告列表
	 * */
	public List<Advertisement> getAdvertisements();
	
	/**
	 * 获取所有广告列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 广告列表
	 * */
	public List<Advertisement> getAdvertisements(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除广告
	 * @author Oscar Mok
	 * @param id 广告ID
	 * @return 移除状态
	 * */
	public boolean removeAdvertisement(String id);
	
	/**
	 * 保存广告信息
	 * @author Oscar Mok
	 * @param advertisement 广告对象
	 * @return 保存状态
	 * */
	public boolean saveAdvertisement(Advertisement advertisement);
	
	/**
	 * 设置广告使用状态信息
	 * @author Oscar Mok
	 * @param id 广告ID
	 * @param status 广告状态
	 * @return 保存状态
	 * */
	public boolean saveAdvertisementStatus(String id, Integer status);
	
}