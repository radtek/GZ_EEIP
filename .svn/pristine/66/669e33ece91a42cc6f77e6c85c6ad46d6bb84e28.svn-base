package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingParticipant;

public interface MeetingParticipantService {

	/***
	 * 保存参会人信息
	 * @param meeting 参会人对象
	 * @param type 会议类型
	 * @return 保存状态
	 */
	public boolean saveMeetingParticipant(MeetingParticipant meetingParticipant,Integer type);
	
	/**
	 * 根据ID删除参会人信息
	 * @param id 参会人ID
	 * @return 删除状态
	 */
	public boolean removeMeetingParticipant(String id);
	
	/***
	 * 根据会议ID删除参与会人信息
	 * @param appId
	 * @return
	 */
	public boolean removeMeetingParticipantsByAppId(String appId);
	

	/***
	 * 根据ID获取参会人信息
	 * @param id 参会人ID
	 * @return 参会人信息
	 */
	public MeetingParticipant getMeetingParticipantById(String id);
	
	/***
	 * 获取所有参会人数量
	 * @return 参会人数量
	 */
	public Long getMeetingParticipantQty();
	
	/***
	 * 获取所有的参会人列表信息
	 * @return 参会人列表
	 */
	public List<MeetingParticipant> getMeetingParticipants();
	
	/***
	 * 获取参会人列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 参会人列表
	 */
	public List<MeetingParticipant> getMeetingParticipants(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据会议申请ID获取参会人信息列表
	 * @param meetingAppId 会议申请ID
	 * @return 参会人列表
	 */
	public List<MeetingParticipant> getMeetingParticipantsByMeetingAppId(String meetingAppId);
}
