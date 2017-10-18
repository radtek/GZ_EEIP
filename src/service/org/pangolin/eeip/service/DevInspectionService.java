package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevInspection;

public interface DevInspectionService {
	/**
	 * 根据ID查询DevInspection
	 * ID
	 * @param id
	 * @return
	 */
	public DevInspection getDevInspectionById(String id);

	/**
	 * 获取DevInspection总数量
	 * @return
	 */
	public Long getDevInspectionQty(String devId);
	
	/**
	 * 获取DevInspection总集合
	 * @return
	 */
	public List<DevInspection> getDevInspections(String id);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 设备Id
	 * @return
	 */
	public List<DevInspection> getDevInspections(int startIndex, int rows, String sorter, String sortingAttribute, String devId);
	
	/**
	 * 删除DevInspection
	 * @param id ID
	 * @return
	 */
	public boolean removeDevInspection(String id);
	
	/**
	 * 伪删除DevInspection
	 * @param id ID
	 * @return
	 */
	public boolean removeDevInspectionFalse(String id);
	
	/**
	 * 更新 DevInspection
	 * @param DevInspection 对象
	 * @return 更新状态
	 */
	public boolean saveDevInspection(DevInspection devInspection);


}
