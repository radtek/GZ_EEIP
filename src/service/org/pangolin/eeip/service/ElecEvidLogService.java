package org.pangolin.eeip.service;

import java.util.List;
import org.pangolin.eeip.entity.EvidOpLog;

public interface ElecEvidLogService {
	
	/**
	 * 根据ID获取电子物证日志信息
	 * @author zhanghong
	 * @param id 电子物证日志ID
	 * @return 电子物证日志信息
	 * */
	public EvidOpLog getElecEvidLogById(String id);
	
	
	/**
	 * 获取所有电子物证日志数量,附加限定条件params
	 * @author zhanghong
	 * @return 电子物证日志数量
	 * */
	public long count(String params) ;
	
	/**
	 * 获取所有电子物证日志数量,没有附加限定条件
	 * @author zhanghong
	 * @return 电子物证日志数量
	 * */
	public long count() ;
	
	/**
	 * 获取所有电子物证日志列表,附加限定条件params
	 * @author zhanghong
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 电子物证日志列表
	 * */
	public List<EvidOpLog> getElecEvidLogs(String params, int startIndex, int rows, String sorter, String sortingAttribute);

	/**
	 * 获取所有电子物证日志列表,没有附加限定条件
	 * @author zhanghong
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 电子物证日志列表
	 * */
	public List<EvidOpLog> getElecEvidLogs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除电子物证日志
	 * @author zhanghong
	 * @param id 电子物证日志ID
	 * @return 移除状态
	 * */
	public boolean remove(String id);
	
	/**
	 * 保存电子物证日志信息
	 * @author zhanghong
	 * @param gallery 电子物证日志对象
	 * @return 保存状态
	 * */
	public boolean add(EvidOpLog elecEvidLog);
	
}