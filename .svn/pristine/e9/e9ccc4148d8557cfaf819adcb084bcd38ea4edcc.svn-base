package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ExtractedDataItem;

public interface ExtractedDataItemService {
	/**
	 * 根据ID查询ExtractedDataItem
	 * ID
	 * @param id
	 * @return
	 */
	public ExtractedDataItem getExtractedDataItemById(String id);

	/**
	 * 获取ExtractedDataItem总数量
	 * @param devId 
	 * @return
	 */
	public Long getExtractedDataItemQty();
	
	/**
	 * 获取ExtractedDataItem总集合
	 * @return
	 */
	public List<ExtractedDataItem> getExtractedDataItems();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<ExtractedDataItem> getExtractedDataItems(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除ExtractedDataItem
	 * @param id ID
	 * @return
	 */
	public boolean removeExtractedDataItem(String id);
	
	/**
	 * 伪删除ExtractedDataItem
	 * @param id ID
	 * @return
	 */
	public boolean removeExtractedDataItemFalse(String id);
	
	/**
	 * 更新 ExtractedDataItem
	 * @param ExtractedDataItem 对象
	 * @return 更新状态
	 */
	public boolean saveExtractedDataItem(ExtractedDataItem extractedDataItem);

	/**
	 * 根据 提取电子数据清单   id删除全部清单项目
	 * @param extractedDataId
	 */
	public boolean removeExtractedDataItemByExtractedDataId(String extractedDataId);

	/**
	 * @param id
	 * @return
	 */
	public List<ExtractedDataItem> getExtractedDataItemByExtractedDataId(String id);


}
