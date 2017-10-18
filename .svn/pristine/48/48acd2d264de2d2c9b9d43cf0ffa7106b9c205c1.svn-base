package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.QuestionItem;

public interface QuestionItemService {
	
	/**
	 * 根据ID获取选项信息
	 * @author Oscar Mok
	 * @param id 选项ID
	 * @return 题目选项信息
	 * */
	public QuestionItem getQuestionItemById(String id);
	
	/**
	 * 根据题目获取选项数据
	 * @author Oscar Mok
	 * @param surveyQuestionId 题目ID
	 * @return 题目选项列表
	 * */
	public List<QuestionItem> getQuestionItems(String surveyQuestionId);
	
	/**
	 * 移除题目选项信息
	 * @author Oscar Mok
	 * @param id 选项ID
	 * @return 移除状态
	 * */
	public boolean removeQuestionItem(String id);
	
	/**
	 * 保存题目选项信息
	 * @author Oscar Mok
	 * @param questionItem 题目选项对象
	 * @return 保存状态
	 * */
	public boolean saveQuestionItem(QuestionItem questionItem);
	
	/**
	 * 根据条件查询题目选项信息
	 * @author Xiaolin Yin
	 * @param hql 条件
	 * @return
	 */
	public List<QuestionItem> getQuestionItemsByWhere(String hql);
	
	/**
	 * 根据问券主题ID获取问题选项
	 * @author Xiaolin Yin
	 * @param surveySubjectId 问券主题ID
	 * @return
	 */
	public List<QuestionItem> getQuestionItemsBysurveySubjectId(String surveySubjectId);
	
	
}