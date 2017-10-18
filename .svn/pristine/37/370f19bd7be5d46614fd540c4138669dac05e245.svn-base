package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.TerminationNotice;

public interface TerminationNoticeService {
	/**
	 * 根据ID查询TerminationNotice
	 * ID
	 * @param id
	 * @return
	 */
	public TerminationNotice getTerminationNoticeById(String id);

	/**
	 * 获取TerminationNotice总数量
	 * @return
	 */
	public Long getTerminationNoticeQty();
	
	/**
	 * 获取TerminationNotice总集合
	 * @return
	 */
	public List<TerminationNotice> getTerminationNotices();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 设备Id
	 * @return
	 */
	public List<TerminationNotice> getTerminationNotices(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除TerminationNotice
	 * @param id ID
	 * @return
	 */
	public boolean removeTerminationNotice(String id);
	
	/**
	 * 更新 TerminationNotice
	 * @param TerminationNotice 对象
	 * @return 更新状态
	 */
	public boolean saveTerminationNotice(TerminationNotice terminationNotice);

	/**
	 * 根据鉴定Id获取终止报告
	 * @param id
	 * @return
	 */
	public TerminationNotice getTerminationNoticeByAppraisalId(String id);



}
