package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Inquest;

public interface InquestService {

	/***
	 * 保存现场勘验信息
	 * @param meeting 现场勘验对象
	 * @return 保存状态
	 */
	public boolean saveInquest(Inquest inquest);
	
	/**
	 * 根据ID删除现场勘验信息
	 * @param id 现场勘验ID
	 * @return 删除状态
	 */
	public boolean removeInquest(String id);
	
	/***
	 * 根据ID伪删除现场勘验信息（修改现场勘验删除状态）
	 * @param id 现场勘验ID
	 * @return 伪删除状态
	 */
	public boolean removeInquestFalse(String id);

	/***
	 * 根据ID获取现场勘验信息
	 * @param id 现场勘验ID
	 * @return 现场勘验信息
	 */
	public Inquest getInquestById(String id);
	
	/***
	 * 获取所有现场勘验数量
	 * @param queryParam 查询条件
	 * @return 现场勘验数量
	 */
	public Long getInquestQty(String queryParam);
	
	/***
	 * 获取所有的现场勘验列表信息
	 * @return 现场勘验列表
	 */
	public List<Inquest> getInquests();
	
	/***
	 * 获取现场勘验列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParam 查询条件
	 * @return 现场勘验列表
	 */
	public List<Inquest> getInquests(int startIndex, int rows, String sorter, String sortingAttribute,String queryParam);
}
