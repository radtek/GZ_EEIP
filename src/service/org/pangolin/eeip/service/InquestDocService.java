package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.InquestDoc;

public interface InquestDocService {

	/***
	 * 保存现场勘验文件信息
	 * @param meeting 现场勘验文件对象
	 * @return 保存状态
	 */
	public boolean saveInquestDoc(InquestDoc inquestDoc);
	
	/**
	 * 根据ID删除现场勘验文件信息
	 * @param id 现场勘验文件ID
	 * @return 删除状态
	 */
	public boolean removeInquestDoc(String id);
	
	/***
	 * 根据ID伪删除现场勘验文件信息（修改现场勘验文件删除状态）
	 * @param id 现场勘验文件ID
	 * @return 伪删除状态
	 */
	public boolean removeInquestDocFalse(String id);

	/***
	 * 根据ID获取现场勘验文件信息
	 * @param id 现场勘验文件ID
	 * @return 现场勘验文件信息
	 */
	public InquestDoc getInquestDocById(String id);
	
	/***
	 * 获取所有现场勘验文件数量
	 * @return 现场勘验文件数量
	 */
	public Long getInquestDocQty();
	
	/***
	 * 获取所有的现场勘验文件列表信息
	 * @return 现场勘验文件列表
	 */
	public List<InquestDoc> getInquestDocs();
	
	/***
	 * 获取现场勘验文件列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 现场勘验文件列表
	 */
	public List<InquestDoc> getInquestDocs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据现场勘验ID获取现场勘验文件列表信息
	 * @param inquestId 现场勘验ID
	 * @return
	 */
	public List<InquestDoc> getInquestDocsByInquestId(String inquestId);
}
