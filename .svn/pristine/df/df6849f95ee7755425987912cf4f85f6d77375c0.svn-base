package org.pangolin.eeip.service;

import java.util.List;

/**
 * Basic Service Operator
 * @author Oscar Mok
 * @version 1.0
 */
@SuppressWarnings("all")
public interface BaseService<T> {
	
	/**
	 * 根据ID获取指定数据
	 * @author Oscar Mok
	 * @param id 数据ID
	 * @return 数据对象
	 * */
	public T findDataById(String id);
	
	/**
	 * 获取数据列表
	 * @author Oscar Mok
	 * @return 数据列表
	 * */
	public List<T> getDataList();
	
	/**
	 * 根据指定条件获取数据列表
	 * @author Oscar Mok
	 * @param clause0 WHERE条件
	 * @param clause1 ORDER BY条件
	 * @return 数据列表
	 * */
	public List<T> getDataList(String clause0, String clause1);
	
	/**
	 * 保存数据
	 * @author Oscar Mok
	 * @param o 数据对象
	 * @return 保存状态
	 * */
	public boolean saveData(T o);
	
	/**
	 * 移除数据
	 * @author Oscar Mok
	 * @param o 数据对象
	 * @return 移除状态
	 * */
	public boolean removeData(T o);
	
	/**
	 * 移除数据
	 * @author Oscar Mok
	 * @param id 数据ID
	 * @return 移除状态
	 * */
	public boolean removeData(String id);
	
}