package org.pangolin.eeip.service;

import java.util.List;
import java.util.Map;

import org.pangolin.eeip.entity.MeetingApp;

public interface MeetingAppService {
	
	/***
	 * 保存会议信息
	 * @param meeting 会议对象
	 * @return 保存状态
	 */
	public boolean saveMeetingApp(MeetingApp meetingApp);
	
	/**
	 * 根据ID删除会议信息
	 * @param id 会议ID
	 * @return 删除状态
	 */
	public boolean removeMeetingApp(String id);
	
	/***
	 * 根据ID伪删除会议信息（修改会议删除状态）
	 * @param id 会议ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingAppFalse(String id);

	/***
	 * 根据ID获取会议信息
	 * @param id 会议ID
	 * @return 会议信息
	 */
	public MeetingApp getMeetingAppById(String id);
	
	/***
	 * 获取所有会议数量
	 * @return 会议数量
	 */
	public Long getMeetingAppQty(Map<String, Object> queryParams);
	
	/***
	 * 获取所有的会议列表信息
	 * @return 会议列表
	 */
	public List<MeetingApp> getMeetingApps();
	
	/***
	 * 获取会议列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param queryParams 查询条件
	 * @return 会议列表
	 */
	public List<MeetingApp> getMeetingApps(int startIndex, int rows, String sorter, String sortingAttribute,Map<String, Object> queryParams);
}
