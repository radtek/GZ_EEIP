package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ExtractedData;

public interface ExtractedDataService {
	/**
	 * 根据ID查询ExtractedData
	 * ID
	 * @param id
	 * @return
	 */
	public ExtractedData getExtractedDataById(String id);

	/**
	 * 获取ExtractedData总数量
	 * @param devId 
	 * @return
	 */
	public Long getExtractedDataQty();
	
	/**
	 * 获取ExtractedData总集合
	 * @return
	 */
	public List<ExtractedData> getExtractedDatas();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<ExtractedData> getExtractedDatas(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除ExtractedData
	 * @param id ID
	 * @return
	 */
	public boolean removeExtractedData(String id);
	
	/**
	 * 伪删除ExtractedData
	 * @param id ID
	 * @return
	 */
	public boolean removeExtractedDataFalse(String id);
	
	/**
	 * 更新 ExtractedData
	 * @param ExtractedData 对象
	 * @return 更新状态
	 */
	public boolean saveExtractedData(ExtractedData extractedData);
	
	/**
	 * 返回ExtractedData
	 * @param 根据 appraisalId
	 * @return 
	 */
	public ExtractedData getExtractedDataByAppraisalId(String appraisalId);

}
