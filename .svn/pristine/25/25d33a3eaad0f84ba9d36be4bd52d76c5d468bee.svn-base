package org.pangolin.eeip.service;

import java.util.List;
import java.util.Map;

import org.pangolin.eeip.entity.DevAttachment;

public interface DevAttachmentService {
	/**
	 * 根据ID查询DevAttachment
	 * ID
	 * @param id
	 * @return
	 */
	public DevAttachment getDevAttachmentById(String id);

	/**
	 * 获取DevAttachment总数量
	 * @param deviceId 
	 * @param type 
	 * @return
	 */
	public Long getDevAttachmentQty(String deviceId, Integer type);
	
	/**
	 * 获取DevAttachment总集合
	 * @return
	 */
	public List<DevAttachment> getDevAttachments();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param deviceId 
	 * @param integer 
	 * @return
	 */
	public List<DevAttachment> getDevAttachments(int startIndex, int rows, String sorter, String sortingAttribute, String deviceId, Integer integer);
	
	/**
	 * 删除DevAttachment
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAttachment(String id);
	
	/**
	 * 伪删除DevAttachment
	 * @param id ID
	 * @return
	 */
	public boolean removeDevAttachmentFalse(String id);
	
	/**
	 * 更新 DevAttachment
	 * @param DevAttachment 对象
	 * @return 更新状态
	 */
	public boolean saveDevAttachment(DevAttachment devAttachment);

	/**
	 * 根据设备Id获取全部附件列表
	 * @param deviceId
	 * @return
	 */
	public List<DevAttachment> getDevAttachmentListByDeviceId(String deviceId);

	/**
	 * 根据类型和deviceId获取附件对象
	 * @param type 文件类型
 	 * @param deviceId 设备deviceId
	 */
	public DevAttachment getDevAttachmentByTypeAndDeviceId(Integer type, String deviceId);


}
