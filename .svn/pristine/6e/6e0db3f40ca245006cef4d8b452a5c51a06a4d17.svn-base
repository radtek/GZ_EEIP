package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingQsDocCmtItem;

public interface MeetingQsDocCmtItemService {

	/***
	 * 保存质量体系文件修改意见细项信息
	 * @param meeting 质量体系文件修改意见细项对象
	 * @return 保存状态
	 */
	public boolean saveMeetingQsDocCmtItem(MeetingQsDocCmtItem meetingQsDocCmtItem);
	
	/**
	 * 根据ID删除质量体系文件修改意见细项信息
	 * @param id 质量体系文件修改意见细项ID
	 * @return 删除状态
	 */
	public boolean removeMeetingQsDocCmtItem(String id);

	/***
	 * 根据ID获取质量体系文件修改意见细项信息
	 * @param id 质量体系文件修改意见细项ID
	 * @return 质量体系文件修改意见细项信息
	 */
	public MeetingQsDocCmtItem getMeetingQsDocCmtItemById(String id);
	
	/***
	 * 获取所有质量体系文件修改意见细项数量
	 * @return 质量体系文件修改意见细项数量
	 */
	public Long getMeetingQsDocCmtItemQty();
	
	/***
	 * 获取所有的质量体系文件修改意见细项列表信息
	 * @return 质量体系文件修改意见细项列表
	 */
	public List<MeetingQsDocCmtItem> getMeetingQsDocCmtItems();
	
	/***
	 * 获取质量体系文件修改意见细项列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 质量体系文件修改意见细项列表
	 */
	public List<MeetingQsDocCmtItem> getMeetingQsDocCmtItems(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/***
	 * 根据质量体系文件修改意见ID获取质量体系文件修改意见细项列表信息
	 * @param cmtId 质量体系文件修改意见
	 * @param type 文件类型
	 * @return
	 */
	public List<MeetingQsDocCmtItem> getMeetingQsDocCmtItemsByCmtId(String cmtId,int type);

}
