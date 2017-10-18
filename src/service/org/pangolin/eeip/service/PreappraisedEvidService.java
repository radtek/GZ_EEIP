package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.PreappraisedEvid;

public interface PreappraisedEvidService {
	/**
	 * 根据ID查询PreappraisedEvid
	 * ID
	 * @param id
	 * @return
	 */
	public PreappraisedEvid getPreappraisedEvidById(String id);

	/**
	 * 获取PreappraisedEvid总数量
	 * @return
	 */
	public Long getPreappraisedEvidQty();
	
	/**
	 * 获取PreappraisedEvid总集合
	 * @param preappraisalId 
	 * @return
	 */
	public List<PreappraisedEvid> getPreappraisedEvids(String preappraisalId);
	
	/**
	 * 获取PreappraisedEvid总集合
	 * @param preappraisalId 
	 * @return
	 */
	public PreappraisedEvid getPreappraisedEvid(String preappraisalId,String sn);
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<PreappraisedEvid> getPreappraisedEvids(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除PreappraisedEvid
	 * @param preappraisalId preappraisalId
	 * @return
	 */
	public boolean removePreappraisedEvid(String preappraisalId);
	
	/**
	 * 更新 PreappraisedEvid
	 * @param PreappraisedEvid 对象
	 * @return 更新状态
	 */
	public boolean savePreappraisedEvid(PreappraisedEvid preappraisedEvid);


}
