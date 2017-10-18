package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Version;

public interface VersionService {
	
	/**
	 * 根据ID获取版本信息
	 * @author Oscar Mok
	 * @param id 版本ID
	 * @return 版本信息
	 * */
	public Version getVersionById(String id);
	
	/**
	 * 获取所有版本数量
	 * @author Oscar Mok
	 * @return 版本数量
	 * */
	public Long getVersionQty();
	
	/**
	 * 根据版本状态获取所有版本数量
	 * @author Oscar Mok
	 * @param status 版本状态
	 * @return 版本数量
	 * */
	public Long getVersionQtyByStatus(Integer status);
	
	/**
	 * 获取所有版本信息列表
	 * @author Oscar Mok
	 * @return 版本信息列表
	 * */
	public List<Version> getVersions();
	
	/**
	 * 根据版本状态获取所有版本信息列表
	 * @author Oscar Mok
	 * @param status 版本状态
	 * @return 版本信息列表
	 * */
	public List<Version> getVersionsByStatus(Integer status);
	
	/**
	 * 获取所有版本信息列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 版本信息列表
	 * */
	public List<Version> getVersions(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据版本状态获取所有版本信息列表
	 * @author Oscar Mok
	 * @param status 版本状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 版本信息列表
	 * */
	public List<Version> getVersionsByStatus(Integer status, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除版本信息
	 * @author Oscar Mok
	 * @param id 版本ID
	 * @return 移除状态
	 * */
	public boolean removeVersion(String id);
	
	/**
	 * 保存版本信息
	 * @author Oscar Mok
	 * @param version 版本对象
	 * @return 保存状态
	 * */
	public boolean saveVersion(Version version);
	
	/**
	 * 设置版本状态
	 * @author Oscar Mok
	 * @param id 版本ID
	 * @param status 版本状态
	 * @return 保存状态
	 * */
	public boolean saveVersionStatus(String id, Integer status);
}