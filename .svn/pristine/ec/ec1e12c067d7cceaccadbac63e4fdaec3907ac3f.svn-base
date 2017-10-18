package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingIiReport;

public interface MeetingIiReportService {

	/***
	 * 保存不符合项报告信息
	 * @param meeting 不符合项报告对象
	 * @return 保存状态
	 */
	public boolean saveMeetingIiReport(MeetingIiReport meetingIiReport);
	
	/**
	 * 根据ID删除不符合项报告信息
	 * @param id 不符合项报告ID
	 * @return 删除状态
	 */
	public boolean removeMeetingIiReport(String id);
	
	/***
	 * 根据ID伪删除不符合项报告信息（修改不符合项报告删除状态）
	 * @param id 不符合项报告ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingIiReportFalse(String id);
	
	/***
	 * 根据参与人员ID伪删除不符合项报告信息（修改不符合项报告删除状态）
	 * @param id 参与人员ID
	 */
	public void removeMeetingIiReportFalseByParticipantId(String participantId);

	/***
	 * 根据ID获取不符合项报告信息
	 * @param id 不符合项报告ID
	 * @return 不符合项报告信息
	 */
	public MeetingIiReport getMeetingIiReportById(String id);
	
	/***
	 * 获取所有不符合项报告数量
	 * @return 不符合项报告数量
	 */
	public Long getMeetingIiReportQty();
	
	/***
	 * 获取所有的不符合项报告列表信息
	 * @return 不符合项报告列表
	 */
	public List<MeetingIiReport> getMeetingIiReports();
	
	/***
	 * 获取不符合项报告列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 不符合项报告列表
	 */
	public List<MeetingIiReport> getMeetingIiReports(int startIndex, int rows, String sorter, String sortingAttribute);

	/***
	 * 根据会议申请ID获取所有的不符合项报告列表信息
	 * @param appId 会议申请ID
	 * @return 不符合项报告列表
	 */
	public List<MeetingIiReport> getMeetingIiReportsByAppId(String appId);
	
	/***
	 * 根据会议申请ID和参与人ID获取不符合项报告信息
	 * @param appId 会议申请ID
	 * @param participantId 参与人ID
	 * @return
	 */
	public List<MeetingIiReport> getMeetingIiReportByAppIdAndParticipantId(String appId,String participantId);
}
