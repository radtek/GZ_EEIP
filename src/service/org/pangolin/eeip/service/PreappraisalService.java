package org.pangolin.eeip.service;

import java.util.List;
import java.util.Map;

import org.pangolin.eeip.entity.Preappraisal;

public interface PreappraisalService {
	/**
	 * 根据ID查询Preappraisal
	 * ID
	 * @param id
	 * @return
	 */
	public Preappraisal getPreappraisalById(String id);

	/**
	 * 获取Preappraisal总数量
	 * @param extraParam 
	 * @return
	 */
	public Long getPreappraisalQty(String extraParam);
	
	/**
	 * 获取Preappraisal总集合
	 * @return
	 */
	public List<Preappraisal> getPreappraisals();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param extraParam 
	 * @return
	 */
	public List<Preappraisal> getPreappraisals(int startIndex, int rows, String sorter, String sortingAttribute, String extraParam);
	
	/**
	 * 删除Preappraisal
	 * @param id ID
	 * @return
	 */
	public boolean removePreappraisal(String id);
	
	/**
	 * 伪删除Preappraisal
	 * @param id ID
	 * @return
	 */
	public boolean removePreappraisalFalse(String id);
	
	/**
	 * 更新 Preappraisal
	 * @param Preappraisal 对象
	 * @return 更新状态
	 */
	public boolean savePreappraisal(Preappraisal preappraisal);
	
	/**
	 * 分页查询 通过登录人信息
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @param extraParam  搜索参数
	 * @param creatorId 登录用户ID
	 * @return
	 */
	public List<Preappraisal> getPreappraisals(int startIndex, int rows, String sorter, String sortingAttribute, String extraParam,String creatorId);


	/**
	 * 获取Preappraisal总数量
	 * @param extraParam  搜索参数
	 * @param creatorId 登录用户ID
	 * @return
	 */
	public Long getPreappraisalQty(String extraParam,String creatorId);
	
	
	/**
	 * 查询历年广州市检材鉴定委托的趋势分析数据源
	 * @param year 年份
	 * @return
	 */
	public Map<String, List<String>> getHistoryYearAnalysis(String year);
	
	/**
	 * 查询广州市检材鉴定委托的趋势分析数据源
	 * @param year 年份
	 * @param mouth 月份
	 * @return
	 */
	public Map<String, List<String>> getCountryAnalysis(String year,String month);
	
	
	 
}
