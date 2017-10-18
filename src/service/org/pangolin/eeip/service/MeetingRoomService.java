package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingRoom;

public interface MeetingRoomService {

	/***
	 * 保存会议室信息
	 * @param meeting 会议室对象
	 * @return 保存状态
	 */
	public boolean saveMeetingRoom(MeetingRoom meetingRoom);
	
	/**
	 * 根据ID删除会议室信息
	 * @param id 会议室ID
	 * @return 删除状态
	 */
	public boolean removeMeetingRoom(String id);
	
	/***
	 * 根据ID伪删除会议室信息（修改文件室删除状态）
	 * @param id 会议室文件ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingRoomFalse(String id);

	/***
	 * 根据ID获取会议室信息
	 * @param id 会议室ID
	 * @return 会议室信息
	 */
	public MeetingRoom getMeetingRoomById(String id);
	
	/***
	 * 获取所有会议室数量
	 * @param params 查询条件
	 * @return 会议室数量
	 */
	public Long getMeetingRoomQty(String params);
	
	/***
	 * 获取所有的会议室列表信息
	 * @return 会议室列表
	 */
	public List<MeetingRoom> getMeetingRooms();
	
	/***
	 * 获取会议室列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param params 查询条件
	 * @return 会议室列表
	 */
	public List<MeetingRoom> getMeetingRooms(int startIndex, int rows, String sorter, String sortingAttribute,String params);
	
	/***
	 * 获取可用的会议室列表信息
	 * @return
	 */
	public List<MeetingRoom> getEmptyMeetingRooms();
	
}
