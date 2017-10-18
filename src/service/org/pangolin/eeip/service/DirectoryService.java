package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Directory;

public interface DirectoryService {

	/***
	 * 保存文件夹夹信息
	 * @param meeting 文件夹对象
	 * @return 保存状态
	 */
	public boolean saveDirectory(Directory directory);
	
	/**
	 * 根据ID删除文件夹信息
	 * @param id 文件夹ID
	 * @return 删除状态
	 */
	public boolean removeDirectory(String id);
	
	/***
	 * 根据ID伪删除文件夹信息（修改文件夹删除状态）
	 * @param id 文件夹ID
	 * @return 伪删除状态
	 */
	public boolean removeDirectoryFalse(String id);

	/***
	 * 根据ID获取文件夹信息
	 * @param id 文件夹ID
	 * @return 文件夹信息
	 */
	public Directory getDirectoryById(String id);
	
	/***
	 * 获取所有文件夹数量
	 * @return 文件夹数量
	 */
	public Long getDirectoryQty();
	
	/***
	 * 获取所有的文件夹列表信息
	 * @return 文件夹列表
	 */
	public List<Directory> getDirectorys();
	
	/***
	 * 获取文件夹列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 文件夹列表
	 */
	public List<Directory> getDirectorys(int startIndex, int rows, String sorter, String sortingAttribute);

}
