package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingDoc;


public interface MeetingDocService {

	/***
	 * 保存会议资料信息
	 * @param meeting 会议资料对象
	 * @return 保存状态
	 */
	public boolean saveMeetingDoc(MeetingDoc meetingDoc);
	
	/**
	 * 根据ID删除会议资料信息
	 * @param id 会议资料ID
	 * @return 删除状态
	 */
	public boolean removeMeetingDoc(String id);
	
	/***
	 * 根据ID伪删除会议资料信息（修改资料删除状态）
	 * @param id 会议资料ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingDocFalse(String id);
	
	/***
	 * 根据ID恢复会议资料信息状态（修改资料删除状态）
	 * @param id 会议资料ID
	 * @return 正常状态
	 */
	public boolean updateMeetingDoc(String id);

	/***
	 * 根据ID获取会议资料信息
	 * @param id 会议资料ID
	 * @return 会议资料信息
	 */
	public MeetingDoc getMeetingDocById(String id);
	
	/***
	 * 获取所有会议资料数量
	 * @return 会议资料数量
	 */
	public Long getMeetingDocQty();
	
	/***
	 * 获取所有的会议资料列表信息
	 * @return 会议资料列表
	 */
	public List<MeetingDoc> getMeetingDocs();
	
	/***
	 * 获取会议资料列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 会议资料列表
	 */
	public List<MeetingDoc> getMeetingDocs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据会议申请ID获取会议资料信息列表
	 * @param meetingAppId 会议申请ID
	 * @return 会议资料列表
	 */
	public List<MeetingDoc> getMeetingDocsByMeetingAppId(String meetingAppId);
	
	/***
	 * 根据会议申请ID获取会议资料信息
	 * @param id 会议申请ID
	 * @param type 会议资料类型
	 * @return 会议资料信息
	 */
	public MeetingDoc getMeetingDocByAppIdAndType(String appId,int type);
}
