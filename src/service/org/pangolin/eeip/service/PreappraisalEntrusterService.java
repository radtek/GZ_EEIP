package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.PreappraisalEntruster;

public interface PreappraisalEntrusterService {
	/**
	 * 根据ID查询PreappraisalEntruster
	 * ID
	 * @param id
	 * @return
	 */
	public PreappraisalEntruster getPreappraisalEntrusterById(String id);

	/**
	 * 获取PreappraisalEntruster总数量
	 * @return
	 */
	public Long getPreappraisalEntrusterQty();
	
	/**
	 * 获取PreappraisalEntruster总集合
	 * @param preappraisalId 
	 * @return
	 */
	public List<PreappraisalEntruster> getPreappraisalEntrusters(String preappraisalId);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<PreappraisalEntruster> getPreappraisalEntrusters(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除PreappraisalEntruster
	 * @param id ID
	 * @return
	 */
	public boolean removePreappraisalEntruster(String id);
	
	/**
	 * 更新 PreappraisalEntruster
	 * @param PreappraisalEntruster 对象
	 * @return 更新状态
	 */
	public boolean savePreappraisalEntruster(PreappraisalEntruster preappraisalEntruster);

	/**
	 * 根据preappraisalDataId获取第一个送件人信息
	 * @param preappraisalDataId
	 * @return
	 */
	public PreappraisalEntruster getPreappraisalEntrusterBypreappraisalId(String preappraisalDataId);

	/**
	 * 根据预检Id获取送件人列表
	 * @param preappraisalId
	 * @return
	 */
	public List<PreappraisalEntruster> getPreappraisalEntrusterListByPreappraisalId(String preappraisalId);


}
