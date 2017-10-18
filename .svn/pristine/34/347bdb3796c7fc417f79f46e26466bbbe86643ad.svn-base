package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingIaReport;

public interface MeetingIaReportService {

	/***
	 * 保存内部审核报告信息
	 * @param meeting 内部审核报告对象
	 * @return 保存状态
	 */
	public boolean saveMeetingIaReport(MeetingIaReport meetingIaReport);
	
	/**
	 * 根据ID删除内部审核报告信息
	 * @param id 内部审核报告ID
	 * @return 删除状态
	 */
	public boolean removeMeetingIaReport(String id);
	
	/***
	 * 根据ID伪删除内部审核报告信息（修改内部审核报告删除状态）
	 * @param id 内部审核报告ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingIaReportFalse(String id);

	/***
	 * 根据ID获取内部审核报告信息
	 * @param id 内部审核报告ID
	 * @return 内部审核报告信息
	 */
	public MeetingIaReport getMeetingIaReportById(String id);
	
	/***
	 * 获取所有内部审核报告数量
	 * @return 内部审核报告数量
	 */
	public Long getMeetingIaReportQty();
	
	/***
	 * 获取所有的内部审核报告列表信息
	 * @return 内部审核报告列表
	 */
	public List<MeetingIaReport> getMeetingIaReports();
	
	/***
	 * 获取内部审核报告列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 内部审核报告列表
	 */
	public List<MeetingIaReport> getMeetingIaReports(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据会议申请ID获取内部审核报告信息
	 * @param appId 会议申请ID
	 * @return 内部审核报告信息
	 */
	public MeetingIaReport getMeetingIaReportByAppId(String appId);

}
