package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingMaReport;

public interface MeetingMaReportService {

	/***
	 * 保存管理评审报告表信息
	 * @param meeting 管理评审报告表对象
	 * @return 保存状态
	 */
	public boolean saveMeetingMaReport(MeetingMaReport meetingMaReport);
	
	/**
	 * 根据ID删除管理评审报告表信息
	 * @param id 管理评审报告表ID
	 * @return 删除状态
	 */
	public boolean removeMeetingMaReport(String id);
	
	/***
	 * 根据ID伪删除管理评审报告表信息（修改管理评审报告表删除状态）
	 * @param id 管理评审报告表ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingMaReportFalse(String id);

	/***
	 * 根据ID获取管理评审报告表信息
	 * @param id 管理评审报告表ID
	 * @return 管理评审报告表信息
	 */
	public MeetingMaReport getMeetingMaReportById(String id);
	
	/***
	 * 获取所有管理评审报告表数量
	 * @return 管理评审报告表数量
	 */
	public Long getMeetingMaReportQty();
	
	/***
	 * 获取所有的管理评审报告表列表信息
	 * @return 管理评审报告表列表
	 */
	public List<MeetingMaReport> getMeetingMaReports();
	
	/***
	 * 获取管理评审报告表列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 管理评审报告表列表
	 */
	public List<MeetingMaReport> getMeetingMaReports(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据会议申请ID获取管理评审报告信息
	 * @param appId 会议申请ID
	 * @return
	 */
	public MeetingMaReport getMeetingMaReportByAppId(String appId);

}
