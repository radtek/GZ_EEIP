package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingMaParticipant;

public interface MeetingMaParticipantService {

	/***
	 * 保存管理评审参与人清单信息
	 * @param meeting 管理评审参与人清单对象
	 * @return 保存状态
	 */
	public boolean saveMeetingMaParticipant(MeetingMaParticipant meetingMaParticipant);
	
	/**
	 * 根据ID删除管理评审参与人清单信息
	 * @param id 管理评审参与人清单ID
	 * @return 删除状态
	 */
	public boolean removeMeetingMaParticipant(String id);


	/***
	 * 根据ID获取管理评审参与人清单信息
	 * @param id 管理评审参与人清单ID
	 * @return 管理评审参与人清单信息
	 */
	public MeetingMaParticipant getMeetingMaParticipantById(String id);
	
	/***
	 * 获取所有管理评审参与人清单数量
	 * @return 管理评审参与人清单数量
	 */
	public Long getMeetingMaParticipantQty();
	
	/***
	 * 获取所有的管理评审参与人清单列表信息
	 * @return 管理评审参与人清单列表
	 */
	public List<MeetingMaParticipant> getMeetingMaParticipants();
	
	/***
	 * 获取管理评审参与人清单列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 管理评审参与人清单列表
	 */
	public List<MeetingMaParticipant> getMeetingMaParticipants(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据管理评审报告ID获取管理评审参与人清单列表信息
	 * @param reportId 管理评审报告ID
	 * @return 管理评审参与人清单列表
	 */
	public List<MeetingMaParticipant> getMeetingMaParticipantsByReportId(String reportId);

}
