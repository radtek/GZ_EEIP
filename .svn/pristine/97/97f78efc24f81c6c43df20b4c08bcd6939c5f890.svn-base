package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Device;

public interface DeviceService {
	/**
	 * 根据ID查询Device
	 * ID
	 * @param id
	 * @return
	 */
	public Device getDeviceById(String id);

	/**
	 * 获取Device总数量
	 * @param extraParam 
	 * @return
	 */
	public Long getDeviceQty(String extraParam);
	
	/**
	 * 获取Device总集合
	 * @return
	 */
	public List<Device> getDevices();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param extraParam 
	 * @return
	 */
	public List<Device> getDevices(int startIndex, int rows, String sorter, String sortingAttribute, String extraParam);
	
	/**
	 * 删除Device
	 * @param id ID
	 * @return
	 */
	public boolean removeDevice(String id);
	
	/**
	 * 伪删除Device
	 * @param id ID
	 * @return
	 */
	public boolean removeDeviceFalse(String id);
	
	/**
	 * 更新 Device
	 * @param Device 对象
	 * @return 更新状态
	 */
	public boolean saveDevice(Device device);

	/***
	 * 获取设备状态为正常的列表
	 * @return
	 */
	public List<Device> getNormalDevices();

	/***
	 * 获取设备状态为正常的列表
	 * @return
	 */
	public List<Device> getDeviceUseSituations();
	
	/***
	 * 获取设备状态为正常的列表
	 * @param name 设备名称
	 * @return
	 */
	public List<Device> getAppraisalDevices(String name);

}
