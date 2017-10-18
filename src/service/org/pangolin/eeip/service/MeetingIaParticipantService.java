package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingIaParticipant;

public interface MeetingIaParticipantService {

	/***
	 * 保存内审成员信息
	 * @param meeting 内审成员对象
	 * @param type 会议类型
	 * @return 保存状态
	 */
	public boolean saveMeetingIaParticipant(MeetingIaParticipant meetingIaParticipant,Integer type);
	
	/**
	 * 根据ID删除内审成员信息
	 * @param id 内审成员ID
	 * @return 删除状态
	 */
	public boolean removeMeetingIaParticipant(String id);
	
	/**
	 * 根据appId删除内审成员信息
	 * @param id 内审成员ID
	 * @return 删除状态
	 */
	public boolean removeMeetingIaParticipantByAppId(String appId);
	

	/***
	 * 根据ID获取内审成员信息
	 * @param id 内审成员ID
	 * @return 内审成员信息
	 */
	public MeetingIaParticipant getMeetingIaParticipantById(String id);
	
	/***
	 * 获取所有内审成员数量
	 * @return 内审成员数量
	 */
	public Long getMeetingIaParticipantQty();
	
	/***
	 * 获取所有的内审成员列表信息
	 * @return 内审成员列表
	 */
	public List<MeetingIaParticipant> getMeetingIaParticipants();
	
	/***
	 * 获取内审成员列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 内审成员列表
	 */
	public List<MeetingIaParticipant> getMeetingIaParticipants(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据会议申请ID获取内审成员列表信息
	 * @param appId 会议申请ID
	 * @return
	 */
	public List<MeetingIaParticipant> getMeetingIaParticipantsByAppId(String appId);
}
