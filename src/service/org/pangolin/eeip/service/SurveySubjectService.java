package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.SurveySubject;

public interface SurveySubjectService {
	
	/**
	 * 根据ID获取问卷调查主题信息
	 * @author Oscar Mok
	 * @param id 问卷调查主题ID
	 * @return 问卷调查主题信息
	 * */
	public SurveySubject getSurveySubjectById(String id);
	
	/**
	 * 获取所有问卷调查主题数量
	 * @author Oscar Mok
	 * @return 问卷调查主题数量
	 * */
	public Long getSurveySubjectQty();
	
	/**
	 * 根据指定条件获取问卷调查主题数量
	 * @author Oscar Mok
	 * @param orgSN 部门编号
	 * @param roleLabel 角色标识
	 * @param status 发布状态（可为空，空值代表所有状态）
	 * @return 问卷调查主题数量
	 * */
	public Long getSurveySubjectQty(String orgSN, String roleLabel, Integer status);
	
	/**
	 * 获取所有问卷调查主题列表
	 * @author Oscar Mok
	 * @return 问卷调查主题列表
	 * */
	public List<SurveySubject> getSurveySubjects();
	
	/**
	 * 获取所有问卷调查主题列表
	 * @author Oscar Mok
	 * @param orgSN 部门编号
	 * @param roleLabel 角色标识
	 * @param  status 发布状态（可为空，空值代表所有状态）
	 * @return 问卷调查主题列表
	 * */
	public List<SurveySubject> getSurveySubjects(String orgSN, String roleLabel, Integer status);
	
	/**
	 * 获取所有问卷调查主题列表
	 * @author Oscar Mok
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 问卷调查主题列表
	 * */
	public List<SurveySubject> getSurveySubjects(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 获取所有问卷调查主题列表
	 * @author Oscar Mok
	 * @param orgSN 部门编号
	 * @param roleLabel 角色标识
	 * @param  status 发布状态（可为空，空值代表所有状态）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 问卷调查主题列表
	 * */
	public List<SurveySubject> getSurveySubjects(String orgSN, String roleLabel, Integer status, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除问卷调查主题信息
	 * @author Oscar Mok
	 * @param id 问卷调查主题ID
	 * @return 移除状态
	 * */
	public boolean removeSurveySubject(String id);
	
	/**
	 * 保存问卷调查主题信息
	 * @author Oscar Mok
	 * @param surveySubject 问卷调查主题对象
	 * @return 保存状态
	 * */
	public boolean saveSurveySubject(SurveySubject surveySubject);
	
	
	/**
	 * 根据条件查询问券调查主题
	 * @author Xiaolin Yin
	 * @param sql 
	 * @param startIndex
	 * @param rows
	 * @param sorter
	 * @param sortingAttribute
	 * @return
	 */
	public List<SurveySubject> getSurveySubjectsByWhere(String hql,int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 根据条件查询问券调查主题数量
	 * @author Xiaolin Yin
	 * @param hql
	 * @return
	 */
	public Long getSurveySubjectQtyByWhere(String hql);
	
}