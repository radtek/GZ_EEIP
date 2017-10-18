package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.SurveyQuestion;

public interface SurveyQuestionService {
	
	/**
	 * 根据ID获取问卷调查题目信息
	 * @author Oscar Mok
	 * @param id 问卷调查题目ID
	 * @return 问卷调查题目信息
	 * */
	public SurveyQuestion getSurveyQuestionById(String id);
	
	/**
	 * 根据主题获取所有问卷调查题目数量
	 * @author Oscar Mok
	 * @param surveySubjectId 问卷调查主题ID
	 * @return 问卷调查题目数量
	 * */
	public Long getSurveySubjectQty(String surveySubjectId);
	
	/**
	 * 根据主题获取所有问卷调查题目列表
	 * @author Oscar Mok
	 * @param surveySubjectId 问卷调查主题ID
	 * @return 问卷调查题目列表
	 * */
	public List<SurveyQuestion> getSurveyQuestions(String surveySubjectId);
	
	/**
	 * 移除问卷调查题目信息
	 * @author Oscar Mok
	 * @param id 问卷调查题目ID
	 * @return 移除状态
	 * */
	public boolean removeSurveyQuestion(String id);
	
	/**
	 * 保存问卷调查题目信息
	 * @author Oscar Mok
	 * @param surveyQuestion 问卷调查题目对象
	 * @return 保存状态
	 * */
	public boolean saveSurveyQuestion(SurveyQuestion surveyQuestion);
	
	/**
	 * 根据条件查询问卷调查题目信息
	 * @author Xiaolin Yin
	 * @param hql 条件
	 * @return
	 */
	public List<SurveyQuestion> getSurveyQuestionsByWhere(String hql);
	
	
	
}