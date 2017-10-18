package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AppraisedDev;

public interface AppraisedDevService {
	/**
	 * 根据ID查询AppraisedDev
	 * ID
	 * @param id
	 * @return
	 */
	public AppraisedDev getAppraisedDevById(String id);

	/**
	 * 获取AppraisedDev总数量
	 * @return
	 */
	public Long getAppraisedDevQty();
	
	/**
	 * 获取AppraisedDev总集合
	 * @return
	 */
	public List<AppraisedDev> getAppraisedDevs();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisedDev> getAppraisedDevs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除AppraisedDev
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisedDev(String id);
	
	/**
	 * 伪删除AppraisedDev
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisedDevFalse(String id);
	
	/**
	 * 更新 AppraisedDev
	 * @param AppraisedDev 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisedDev(AppraisedDev appraisedDev);

	/**
	 * 根据历史Id吧之前的文件伪删除
	 * @param Historyid
	 * @param appraisalId
	 */
	public void saveAppraisedDevByHistory(String historyid, String appraisalId);

	/**
	 * 根据appraisalId获取鉴定设备的集合
	 * @param id
	 * @return
	 */
	public List<AppraisedDev> getAppraisedByappraisalId(String id);

}
