package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevUsingSitn;

public interface DevUsingSitnService {
	/**
	 * 根据ID查询DevUsingSitn
	 * ID
	 * @param id
	 * @return
	 */
	public DevUsingSitn getDevUsingSitnById(String id);

	/**
	 * 获取DevUsingSitn总数量
	 * @param devId 
	 * @return
	 */
	public Long getDevUsingSitnQty(String devId);
	
	/**
	 * 获取DevUsingSitn总集合
	 * @return
	 */
	public List<DevUsingSitn> getDevUsingSitns(String di);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @return
	 */
	public List<DevUsingSitn> getDevUsingSitns(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevUsingSitn
	 * @param id ID
	 * @return
	 */
	public boolean removeDevUsingSitn(String id);
	
	/**
	 * 伪删除DevUsingSitn
	 * @param id ID
	 * @return
	 */
	public boolean removeDevUsingSitnFalse(String id);
	
	/**
	 * 更新 DevUsingSitn
	 * @param DevUsingSitn 对象
	 * @return 更新状态
	 */
	public boolean saveDevUsingSitn(DevUsingSitn devUsingSitn);


}
