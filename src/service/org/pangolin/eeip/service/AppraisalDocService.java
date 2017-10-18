package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AppraisalDoc;
import org.pangolin.eeip.entity.AppraisalRevise;

public interface AppraisalDocService {
	/**
	 * 根据ID查询AppraisalDoc
	 * ID
	 * @param id
	 * @return
	 */
	public AppraisalDoc getAppraisalDocById(String id);

	/**
	 * 获取AppraisalDoc总数量
	 * @return
	 */
	public Long getAppraisalDocQty();
	
	/**
	 * 获取AppraisalDoc总集合
	 * @return
	 */
	public List<AppraisalDoc> getAppraisalDocs();
	
	/**
	 * 获取AppraisalDoc总集合 通过 appraisalId
	 * @return
	 */
	public List<AppraisalDoc> getAppraisalDocs(String appraisalId);
	
	/**
	 * 获取AppraisalDoc总集合 通过 appraisalId
	 * @return
	 */
	public List<AppraisalDoc> getReviseAppraisalDocs(String appraisalReviseId );
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<AppraisalDoc> getAppraisalDocs(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除AppraisalDoc
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisalDoc(String id);
	
	/**
	 * 伪删除AppraisalDoc
	 * @param type 类型
	 * @param appraisalId 
	 * @return
	 */
	public boolean removeAppraisalDocFalse(Integer type, String appraisalId);
	
	/**
	 * 更新 AppraisalDoc
	 * @param AppraisalDoc 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisalDoc(AppraisalDoc appraisalDoc);

	/***
	 * 判断是否有原文件
	 * @param type 类型
	 * @param appraisalId 对应的电子物证（检材）鉴定Id
	 * @return
	 */
	public AppraisalDoc getAppraisalDocByTypeAndAppraisalId(Integer type, String appraisalId);

	/***
	 * 判断是否有原文件
	 * @param type 类型
	 * @param appraisalReviseId 文书修改申请Id
	 * @return
	 */
	public AppraisalDoc getAppraisalDocByReviseId(Integer type, String appraisalReviseId);

	/**
	 * 获取对象
	 * @param type 类型
	 * @param appraisalId 对应的电子物证（检材）鉴定Id
	 * @return
	 */
	public AppraisalDoc loadAppraisalDocByTypeAndAppraisalId(Integer valueOf, String appraisalId);

	/**
	 * 根据历史记录删除 4、5、6、7、8
	 * @param id
	 * @param appraisalId
	 */
	public void removeAppraisalDocByHistory(String id, String appraisalId);
	
	/**
	 * 更新 AppraisalDoc 版本
	 * @param AppraisalRevise 对象
	 * @return 更新状态
	 */
	public boolean updateVersion(String  appraisalId,String appraisalReviseId);
	
	/**
	 * 更新 AppraisalDoc 版本
	 * @param AppraisalRevise 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisalDoc(List<AppraisalDoc> docList);

	/**
	 * 根据类型  和 id 判断改附件是否存在 存在返回true 否则返回false
	 * @param type
	 * @param appraisalId
	 * @return
	 */
	public Boolean getAppDocByTypeAndAppraisalId(Integer type, String appraisalId);
	

}
