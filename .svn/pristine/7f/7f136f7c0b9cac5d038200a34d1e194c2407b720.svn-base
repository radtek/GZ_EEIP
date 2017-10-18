package org.pangolin.eeip.service;

import java.util.List;
import java.util.Map;

import org.pangolin.eeip.entity.Appraisal;

public interface AppraisalService {
	/**
	 * 根据ID查询Appraisal
	 * ID
	 * @param id
	 * @return
	 */
	public Appraisal getAppraisalById(String id);

	/**
	 * 获取Appraisal总数量
	 * @return
	 */
	public Long getAppraisalQty(Integer status);
	
	/**
	 * 获取所有Appraisal总数量
	 * @param caseName 案件名称
	 * @param caseSn 案件编号
	 * @return
	 */
	public Long getAllAppraisalsSearchQty(String caseName,String caseSn);
	
	/**
	 * 分页查询
	 * @param caseName 案件名称
	 * @param caseSn 案件编号
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<Appraisal> getAllAppraisalsSearch(String caseName,String caseSn,int startIndex, int rows, String sorter, String sortingAttribute);
	
	
	
	/**
	 * 获取Appraisal总数量  条件下
	 * @param caseName 案件名称
	 * @param caseSn 案件编号
	 * @param status 检材状态
	 * @return
	 */
	public Long getAppraisalQty(String caseName,String caseSn,Integer status);
	
	/**
	 * 获取Appraisal总数量  条件下 
	 * @param userId 鉴定人ID
	 * @return
	 */
	public Long getAppraisalQtyByUserIdQty(String userId);
	

	/**
	 * 获取Appraisal总数量  条件下
	 * @param caseName 案件名称
	 * @param caseSn 案件编号
	 * @param userId 鉴定人ID
	 * @return
	 */
	public Long getAppraisalQtyByUserIdQty(String userId,String caseName,String caseSn );
	
	/**
	 * 获取Appraisal总集合
	 * @return
	 */
	public List<Appraisal> getAppraisals();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<Appraisal> getAppraisals(Integer status,int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 分页查询含条件
	 * @param caseName 案件名称
	 * @param caseSn 案件编号
	 * @param status 检材状态
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<Appraisal> getAppraisals(String caseName,String caseSn,Integer status, int startIndex, int rows, String sorter, String sortingAttribute);
	
	
	/**
	 * 删除Appraisal
	 * @param id ID
	 * @return
	 */
	public boolean removeAppraisal(String id);
	
	/**
	 * 更新 Appraisal
	 * @param Appraisal 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisal(Appraisal appraisal);

	/**
	 * 根据userId查询带鉴定检材
	 * @param userId
	 * @return
	 */
	public Appraisal getAppraisalByUserId(String userId);

	/**
	 * 已办结 电子物证（检材）鉴定文书列表
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @return
	 */
	public List<Appraisal> getFinishAppraisals(int start, int limit, String sorter, String sorterDirection,String userId);
	
	/**
	 * 已办结 电子物证（检材）鉴定文书列表
	 * @param userId 用户ID
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @return
	 */
	public List<Appraisal> getFinishAppraisalsByUserId(String userId,int start, int limit, String sorter, String sorterDirection);
	
	/**
	 * 已办结 电子物证（检材）鉴定文书列表
	 * @param userId 用户ID
	 * @param caseName 案件名称
	 * @param caseSn 案件编号
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @return
	 */
	public List<Appraisal> getFinishAppraisalsByUserId(String userId,String caseName,String caseSn,int start, int limit, String sorter, String sorterDirection);
	
	
	/**
	 * 已办结 电子物证（检材）鉴定文书修订 总数 
	 * @return 
	 */
	public long getFinishAppraisalQty(String userId);

	/**
	 * 获取在库检材列表除了为完成
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @param extraParam 
	 * @return
	 */
	public List<Appraisal> getAppraisalList(int start, int limit, String sorter, String sorterDirection);
	
	/**
	 * 获取在库检材列表
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @param extraParam 
	 * @param extraParam 
	 * @return
	 */
	public List<Appraisal> getAppraisalInStockList(int start, int limit, String sorter, String sorterDirection, String extraParam);

	/**
	 *  获取在库检材数量
	 * @return
	 */
	public long getAppraisalQty();
	
	/**
	 *  获取在库检材数量
	 * @return
	 */
	public long getAppraisalInStock(String extraParam);
	
	/**
	 * 获取交接检材列表
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @param extraParam 
	 * @return
	 */
	public List<Appraisal> getAppraisalConnectList(int start, int limit, String sorter, String sorterDirection);

	/**
	 * 获取交接检材列表
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @param extraParam 
	 * @return
	 */
	public List<Appraisal> getAppraisalConnectLists(int start, int limit, String sorter, String sorterDirection, String extraParam);

	/**
	 *  获取交接检材数量
	 * @param extraParam 
	 * @return
	 */
	public long getAppraisalConnectQtys(String extraParam);
	
	/**
	 *  获取交接检材数量
	 * @param extraParam 
	 * @return
	 */
	public long getAppraisalConnectQty();

	/**
	 * 获取出库检材列表
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @param extraParam 
	 * @return
	 */
	public List<Appraisal> getAppraisalOutputList(int start, int limit, String sorter, String sorterDirection, String extraParam);

	/**
	 *  获取交出库检材数量
	 * @param extraParam 
	 * @return
	 */
	public long getAppraisalOutputQty(String extraParam);

	/**
	 * 根据预检信息查询
	 * @param preappraisalId
	 * @return
	 */
	public Appraisal getAppraisalByPreappraisedId(String preappraisalId);
	
	/**
	 * 根据预检信息查询检验鉴定集合
	 * @param preappraisalId
	 * @return
	 */
	public List<Appraisal> getAppraisalsByPreappraisedId(String preappraisalId);
	
	/**
	 * 获取Appraisal总集合首页数据
	 * @return
	 */
	public List<Appraisal> getAppraisalsIndex(Integer status);
	
	/**
	 * 查询广州市检材鉴定受理对比分析数据源
	 * @param year 年份
	 * @param mouth 月份
	 * @return
	 */
	public Map<String,Object> getAcceptedAnalysis(String year, String month);


	/**
	 * 查询历年广州市送检检材数量趋势分析数据源
	 * @param year 年份
	 * @return
	 */
	public Map<String, List<String>> getHistoryYearAnalysis(String year);
	
	
	/**
	 * 查询广州市各区送检检材数量趋势分析数据源
	 * @param year 年份
	 * @param mouth 月份
	 * @return
	 */
	public Map<String, List<String>> getCountryAnalysis(String year,String month);
	
	/**
	 * 查询广州市检材鉴定受理对比分析数据源
	 * @param year 年份
	 * @param mouth 月份
	 * @return
	 */
	public Map<String,List<String>> getAppraisalsTypeAnalysis(String year, String month);
	
	/**
	 * 查询历年广州市成功受理送检检材数量趋势分析数据源
	 * @param year 年份
	 * @return
	 */
	public Map<String, List<String>> getAcceptedOKYearAnalysis(String year);
	
	
	/**
	 * 查询广州市检材鉴定受理对比分析数据源
	 * @param year 年份
	 * @param mouth 月份
	 * @return
	 */
	public Map<String,Object> getIdentifyResultsAnalysis(String year, String month,String country);
	
	/**
	 * 查询广州市检材 受理成功 按区域  分析数据源
	 * @param year 年份
	 * @return
	 */
	public Map<String,List<String>> getAcceptedOKONCountryAnalysis(String year,String month);

	/**
	 * 查询历年广州市取证应用率趋势数据源
	 * @param year 年份
	 * @return
	 */
	public Long getYearHistoryAppraisal(String year);
	
	/**
	 * 查询历年广州市取证应用率趋势数据源
	 * @param year 年份
	 * @param month 月份
	 * @return
	 */
	public Long getMonthHistoryAppraisal(String year,String month);
	
	/**
	 * 查询历年广州市取证应用率趋势数据源
	 * @param year 年份
	 * @param month 月份
	 * @return
	 */
	public Long getCountryHistoryAppraisal(String year,String country);
	
	/**
	 * 查询历年广州市取证应用率趋势数据源
	 * @param year 年份
	 * @param month 月份
	 * @param country 地区
	 * @return
	 */
	public Long getCountryHistoryAppraisal(String year,String month,String country);
	
}
