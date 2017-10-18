package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.DevInspectionParam;

public interface DevInspectionParamService {
	/**
	 * 根据ID查询DevInspectionParam
	 * ID
	 * @param id
	 * @return
	 */
	public DevInspectionParam getDevInspectionParamById(String id);

	/**
	 * 获取DevInspectionParam总数量
	 * @param devId 
	 * @param devInspectionId 
	 * @return
	 */
	public Long getDevInspectionParamQty(String devId, String devInspectionId);
	
	/**
	 * 获取DevInspectionParam总集合
	 * @return
	 */
	public List<DevInspectionParam> getDevInspectionParams();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param devId 
	 * @param devInspectionId 
	 * @return
	 */
	public List<DevInspectionParam> getDevInspectionParams(int startIndex, int rows, String sorter, String sortingAttribute, String devId, String devInspectionId);
	
	/**
	 * 删除DevInspectionParam
	 * @param id ID
	 * @return
	 */
	public boolean removeDevInspectionParam(String id);
	
	/**
	 * 伪删除DevInspectionParam
	 * @param id ID
	 * @return
	 */
	public boolean removeDevInspectionParamFalse(String id);
	
	/**
	 * 更新 DevInspectionParam
	 * @param DevInspectionParam 对象
	 * @return 更新状态
	 */
	public boolean saveDevInspectionParam(DevInspectionParam devInspectionParam);


}
