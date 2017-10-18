package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.PreappraisalAtt;

public interface PreappraisalAttService {
	/**
	 * 根据ID查询PreappraisalAtt
	 * ID
	 * @param id
	 * @return
	 */
	public PreappraisalAtt getPreappraisalAttById(String id);

	/**
	 * 获取PreappraisalAtt总数量
	 * @return
	 */
	public Long getPreappraisalAttQty();
	
	/**
	 * 获取PreappraisalAtt总集合
	 * @param id 
	 * @return
	 */
	public List<PreappraisalAtt> getPreappraisalAtts(String id);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<PreappraisalAtt> getPreappraisalAtts(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除PreappraisalAtt
	 * @param id ID
	 * @return
	 */
	public boolean removePreappraisalAtt(String id);
	
	/**
	 * 更新 PreappraisalAtt
	 * @param PreappraisalAtt 对象
	 * @return 更新状态
	 */
	public boolean savePreappraisalAtt(PreappraisalAtt preappraisalAtt);

	/**
	 * 删除PreappraisalAtt
	 * @param id preappraisalId
	 * @return
	 */
	public boolean removePreappraisalAttByPreappraisalId(String preappraisalId);


}
