package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingIaInspection;

public interface MeetingIaInspectionService {

	/***
	 * 保存内部审核检查表信息
	 * @param meeting 内部审核检查表对象
	 * @return 保存状态
	 */
	public boolean saveMeetingIaInspection(MeetingIaInspection meetingIaInspection);
	
	/**
	 * 根据ID删除内部审核检查表信息
	 * @param id 内部审核检查表ID
	 * @return 删除状态
	 */
	public boolean removeMeetingIaInspection(String id);
	
	/***
	 * 根据ID伪删除内部审核检查表信息（修改内部审核检查表删除状态）
	 * @param id 内部审核检查表ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingIaInspectionFalse(String id);
	
	/***
	 * 根据参与人员ID伪删除内部审核检查表信息（修改内部审核检查表删除状态）
	 * @param participantId 参与人员ID
	 */
	public void removeMeetingIaInspectionFalseByParticipantId(String participantId);

	/***
	 * 根据ID获取内部审核检查表信息
	 * @param id 内部审核检查表ID
	 * @return 内部审核检查表信息
	 */
	public MeetingIaInspection getMeetingIaInspectionById(String id);
	
	/***
	 * 获取所有内部审核检查表数量
	 * @return 内部审核检查表数量
	 */
	public Long getMeetingIaInspectionQty();
	
	/***
	 * 获取所有的内部审核检查表列表信息
	 * @return 内部审核检查表列表
	 */
	public List<MeetingIaInspection> getMeetingIaInspections();
	
	/***
	 * 获取内部审核检查表列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 内部审核检查表列表
	 */
	public List<MeetingIaInspection> getMeetingIaInspections(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据会议申请获取所有的内部审核检查表列表信息
	 * @param appId 会议申请ID
	 * @return 内部审核检查表列表
	 */
	public List<MeetingIaInspection> getMeetingIaInspectionsByAppId(String appId);
	
	/***
	 * 根据会议申请ID和参与人ID获取内部审核检查表列表信息
	 * @param appId 会议申请ID
	 * @param participantId 参与人ID
	 * @return
	 */
	public List<MeetingIaInspection> getMeetingIaInspectionByAppIdAndParticipantId(String appId,String participantId);

}
