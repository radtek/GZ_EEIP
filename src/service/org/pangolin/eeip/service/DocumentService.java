package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Document;

public interface DocumentService {
	
	/**
	 * 根据ID获取文档信息
	 * @author Oscar Mok
	 * @param id 文档ID
	 * @return 文档信息
	 * */
	public Document getDocumentById(String id);
	
	/**
	 * 获取所有文档数量
	 * @author Oscar Mok
	 * @param queryParam 查询条件
	 * @return 文档数量
	 * */
	public Long getDocumentQty(String queryParam);
	
	/**
	 * 获取所有文档列表
	 * @author Oscar Mok
	 * @return 文档列表
	 * */
	public List<Document> getDocuments();
	
	/**
	 * 获取所有文档列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParam 查询条件
	 * @return 文档列表
	 * */
	public List<Document> getDocuments(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam);
	
	/**
	 * 根据文件夹ID获取所有文档列表
	 * @author Tinggui Zhu
	 * @return 文档列表
	 * */
	public List<Document> getDocumentsByDirectoryId(String directoryId);
	
	/**
	 * 移除文档
	 * @author Oscar Mok
	 * @param id 文档ID
	 * @return 移除状态
	 * */
	public boolean removeDocument(String id);
	
	/**
	 * 保存文档信息
	 * @author Oscar Mok
	 * @param document 文档对象
	 * @return 保存状态
	 * */
	public boolean saveDocument(Document document);
	
	/***
	 * 根据文件夹ID获取文件列表信息
	 * @param dirId 文件夹ID
	 * @return 文件列表信息
	 */
	public List<Document> getDocumentsByDirId(String dirId);
	
	/***
	 * 根据关键字获取文件信息
	 * @param dirId 文件夹ID
	 * @param key 文件名称
	 * @return
	 */
	public List<Document> getDocumentByKey(String dirId,String key);
	
}