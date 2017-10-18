package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingQsDocCmt;

public interface MeetingQsDocCmtService {

	/***
	 * 保存质量体系文件修改意见信息
	 * @param meeting 质量体系文件修改意见对象
	 * @return 保存状态
	 */
	public boolean saveMeetingQsDocCmt(MeetingQsDocCmt meetingQsDocCmt);
	
	/**
	 * 根据ID删除质量体系文件修改意见信息
	 * @param id 质量体系文件修改意见ID
	 * @return 删除状态
	 */
	public boolean removeMeetingQsDocCmt(String id);
	
	/***
	 * 根据ID伪删除质量体系文件修改意见信息（修改质量体系文件修改意见删除状态）
	 * @param id 质量体系文件修改意见ID
	 * @return 伪删除状态
	 */
	public boolean removeMeetingQsDocCmtFalse(String id);

	/***
	 * 根据ID获取质量体系文件修改意见信息
	 * @param id 质量体系文件修改意见ID
	 * @return 质量体系文件修改意见信息
	 */
	public MeetingQsDocCmt getMeetingQsDocCmtById(String id);
	
	/***
	 * 获取所有质量体系文件修改意见数量
	 * @return 质量体系文件修改意见数量
	 */
	public Long getMeetingQsDocCmtQty();
	
	/***
	 * 获取所有的质量体系文件修改意见列表信息
	 * @return 质量体系文件修改意见列表
	 */
	public List<MeetingQsDocCmt> getMeetingQsDocCmts();
	
	/***
	 * 获取质量体系文件修改意见列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 质量体系文件修改意见列表
	 */
	public List<MeetingQsDocCmt> getMeetingQsDocCmts(int startIndex, int rows, String sorter, String sortingAttribute);

	/***
	 * 根据会议申请ID获取质量体系文件修改意见信息
	 * @param appId 申请ID
	 * @return
	 */
	public MeetingQsDocCmt getMeetingQsDocCmtByAppId(String appId);
}
