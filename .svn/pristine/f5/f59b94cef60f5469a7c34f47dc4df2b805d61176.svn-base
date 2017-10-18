package org.pangolin.eeip.service;

import java.util.List;
import org.pangolin.eeip.entity.EvidType;

public interface ElecEvidTypeService {
	
	/**
	 * 根据ID获取电子物证类型信息
	 * @author zhanghong
	 * @param id 电子物证类型ID
	 * @return 电子物证类型信息
	 * */
	public EvidType getElecEvidTypeById(String id);
	
	/**
	 * 获取所有电子物证类型数量,附加限定条件params
	 * @author zhanghong
	 * @return 电子物证类型数量
	 * */
	public long count(String params) ;
	
	/**
	 * 获取所有电子物证类型数量,没有附加限定条件
	 * @author zhanghong
	 * @return 电子物证类型数量
	 * */
	public long count() ;
	
	/**
	 * 获取所有电子物证类型列表,附加限定条件params
	 * @author zhanghong
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 电子物证类型列表
	 * */
	public List<EvidType> getElecEvidTypes(String params, int startIndex, int rows, String sorter, String sortingAttribute);

	/**
	 * 获取所有电子物证类型列表,没有附加限定条件
	 * @author zhanghong
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 电子物证类型列表
	 * */
	public List<EvidType> getElecEvidTypes(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除电子物证类型
	 * @author zhanghong
	 * @param id 电子物证类型ID
	 * @return 移除状态
	 * */
	public boolean remove(String id);
	
	/**
	 * 保存电子物证类型信息
	 * @author zhanghong
	 * @param gallery 电子物证类型对象
	 * @return 保存状态
	 * */
	public boolean add(EvidType elecEvidType);
	
}