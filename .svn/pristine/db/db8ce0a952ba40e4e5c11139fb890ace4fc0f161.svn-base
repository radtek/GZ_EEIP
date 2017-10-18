package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.SurveyResult;


public interface SurveyResultService {
	
	/**
	 * 通过ID获取问券结果信息
	 * @author Xiaolin Yin
	 * @param ID
	 * @return 问卷调查结果
	 */
	public SurveyResult getSurveyResultById(String id);
	
	/**
	 * 通过问券主题获取问券结果信息集
	 * @author Xiaolin Yin
	 * @param surveySubjectId 问券主题ID
	 * @return 问卷调查结果列表
	 */
	public List<SurveyResult> getSurveyResultsBySubject(String surveySubjectId);
	
	/**
	 * 根据调查对象ID获取问券结果信息集
	 * @author Xiaolin Yin
	 * @param respondentId 调查对象ID
	 * @return 问卷调查结果列表
	 */
	public List<SurveyResult> getSurveyResultsByrespondentId(String respondentId);
	
	/**
	 * 获取所有问卷调查结果列表
	 * @author Xiaolin Yin
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 问卷调查结果列表
	 * */
	public List<SurveyResult> getSurveyResults(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 获取所有问卷调查结果列表数量
	 * @author Xiaolin Yin
	 * @return 问卷调查结果列表数量
	 */
	public Long getSurveyResultQty();
	
	/**
	 * 获取所有的问券调查结果列表
	 * @author Xiaolin Yin
	 * @return 所有的问券调查结果
	 */
	public List<SurveyResult> getSurveyResults();
	
	/**
	 * 根据条件获取问券调查结果列表
	 * @author Xiaolin Yin
	 * @param hql 条件
	 * @return 问券调查列表
	 */
	public List<SurveyResult> getSurveyResultsByWhere(String hql);
	
	/**
	 * 根据条件获取问券调查结果的数量
	 * @author Xiaolin Yin
	 * @param hql
	 * @return 条件下问券调查结果的数量
	 */
	public Long getSurveyResultsQtyByWhere(String hql);
	
	/**
	 * 保存问券调查结果信息
	 * @author Xiaolin Yin
	 * @param surveyResult  问券调查结果对象
	 * @return
	 */
	public boolean saveSurveyResult(SurveyResult surveyResult);
	
	/**
	 * 移除问卷调查结果信息
	 * @author Xiaolin Yin
	 * @param id 问卷调结果ID
	 * @return 移除状态
	 * */
	public boolean removeSurveyResult(String id);
}