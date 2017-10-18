package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MeetingIaInspectionItem;

public interface MeetingIaInspectionItemService {

	/***
	 * 保存内部审核检查表细项信息
	 * @param meeting 内部审核检查表细项对象
	 * @return 保存状态
	 */
	public boolean saveMeetingIaInspectionItem(MeetingIaInspectionItem meetingIaInspectionItem);
	
	/**
	 * 根据ID删除内部审核检查表细项信息
	 * @param id 内部审核检查表细项ID
	 * @return 删除状态
	 */
	public boolean removeMeetingIaInspectionItem(String id);

	/***
	 * 根据ID获取内部审核检查表细项信息
	 * @param id 内部审核检查表细项ID
	 * @return 内部审核检查表细项信息
	 */
	public MeetingIaInspectionItem getMeetingIaInspectionItemById(String id);
	
	/***
	 * 获取所有内部审核检查表细项数量
	 * @return 内部审核检查表细项数量
	 */
	public Long getMeetingIaInspectionItemQty();
	
	/***
	 * 获取所有的内部审核检查表细项列表信息
	 * @return 内部审核检查表细项列表
	 */
	public List<MeetingIaInspectionItem> getMeetingIaInspectionItems();
	
	/***
	 * 获取内部审核检查表细项列表信息（分页）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 内部审核检查表细项列表
	 */
	public List<MeetingIaInspectionItem> getMeetingIaInspectionItems(int startIndex, int rows, String sorter, String sortingAttribute);

	/***
	 * 根据内部审核检查ID获取所有的内部审核检查表细项列表信息
	 * @param inspectionId 内部审核检查ID
	 * @return 内部审核检查表细项列表
	 */
	public List<MeetingIaInspectionItem> getMeetingIaInspectionItemsByInspectionId(String inspectionId);
}
