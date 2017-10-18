package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevAdjustmentSitn;

public interface DevAdjustmentSitnService {
	/**
	 * 根据ID查询DevAdjustmentSitn
	 * ID
	 * @param id
	 * @return
	 */
	public DevAdjustmentSitn getDevAdjustmentSitnById(String id);

	/**
	 * 获取DevAdjustmentSitn总数量
	 * @return
	 */
	public Long getDevAdjustmentSitnQty();
	
	/**
	 * 获取DevAdjustmentSitn总集合
	 * @return
	 */
	public List<DevAdjustmentSitn> getDevAdjustmentSitns();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId devId
	 * @return
	 */
	public List<DevAdjustmentSitn> getDevAdjustmentSitns(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevAdjustmentSitn
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjustmentSitn(String id);
	
	/**
	 * 伪删除DevAdjustmentSitn
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAdjustmentSitnFalse(String id);
	
	/**
	 * 更新 DevAdjustmentSitn
	 * @param DevAdjustmentSitn 对象
	 * @return 更新状态
	 */
	public boolean saveDevAdjustmentSitn(DevAdjustmentSitn devAdjustmentSitn);

	/**
	 * 获取全部待审批的列表
	 * @return
	 */
	List<DevAdjustmentSitn> getDevAdjustmentSitnsByStatus();

	/**
	 * 根据关键字（识别号和名称）返回登记表列表
	 * @param extraParam
	 * @return
	 */
	public List<DevAdjustmentSitn> getDevAdjustmentSitnByQueryParam(String extraParam);


}
