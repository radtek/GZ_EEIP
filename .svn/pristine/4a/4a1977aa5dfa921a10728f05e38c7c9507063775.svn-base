package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Visitor;

public interface VisitorService {
	/**
	 * 根据ID查询Visitor
	 * ID
	 * @param id
	 * @return
	 */
	public Visitor getVisitorById(String id);

	/**
	 * 获取Visitor总数量
	 * @return
	 */
	public Long getVisitorQty();
	
	/**
	 * 获取列表Visitor总数量
	 * @param queryParam 查询条件（ 姓名,部门,来访事由）
	 * @return
	 */
	public Long getVisitorListQty(String queryParam );
	
	/**
	 * 获取Visitor总集合
	 * @return
	 */
	public List<Visitor> getVisitors();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<Visitor> getVisitors(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除Visitor
	 * @param id ID
	 * @return
	 */
	public boolean removeVisitor(String id);
	
	/**
	 * 伪删除Visitor
	 * @param id ID
	 * @return
	 */
	public boolean removeVisitorFalse(String id);
	
	/**
	 * 更新 Visitor
	 * @param Visitor 对象
	 * @return 更新状态
	 */
	public boolean saveVisitor(Visitor visitor);

	
	/**
	 * 列表的分页查询
	 * @param queryParam 查询条件（ 姓名,部门,来访事由）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<Visitor> getListVisitors(String queryParam ,int startIndex, int rows, String sorter, String sortingAttribute);
	
}
