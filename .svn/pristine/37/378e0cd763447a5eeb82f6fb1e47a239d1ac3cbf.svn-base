package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DocRelationship;

public interface DocRelationshipService {

	/***
	 * 保存相关文件信息
	 * @param meeting 相关文件对象
	 * @return 保存状态
	 */
	public boolean saveDocRelationship(DocRelationship docRelationship);
	
	/**
	 * 根据ID删除相关文件信息
	 * @param id 相关文件ID
	 * @return 删除状态
	 */
	public boolean removeDocRelationship(String id);
	
	/**
	 * 根据源文件ID删除相关文件信息
	 * @param srcId 源文件ID
	 * @return 删除状态
	 */
	public boolean removeDocRelationshipBySrcId(String srcId);

	/***
	 * 根据ID获取相关文件信息
	 * @param id 相关文件ID
	 * @return 相关文件信息
	 */
	public DocRelationship getDocRelationshipById(String id);
	
	/***
	 * 获取所有相关文件数量
	 * @return 相关文件数量
	 */
	public Long getDocRelationshipQty();
	
	/***
	 * 获取所有的相关文件列表信息
	 * @return 相关文件列表
	 */
	public List<DocRelationship> getDocRelationships();
	
	/***
	 * 根据源文件ID获取相关文件列表信息
	 * @return 相关文件列表
	 */
	public List<DocRelationship> getDocRelationshipsBySrcDocId(String srcDocId);
	
	/***
	 * 获取相关文件列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 相关文件列表
	 */
	public List<DocRelationship> getDocRelationships(int startIndex, int rows, String sorter, String sortingAttribute);
}
