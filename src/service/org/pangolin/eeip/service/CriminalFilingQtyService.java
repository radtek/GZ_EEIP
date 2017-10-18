package org.pangolin.eeip.service;

import java.util.List;
import java.util.Map;

import org.pangolin.eeip.entity.CriminalFilingQty;

public interface CriminalFilingQtyService {

	/**
	 * 根据ID查询CriminalFilingQty
	 * @param id
	 * @return
	 */
	public CriminalFilingQty getCriminalFilingQty(String id);
	
	/**
	 * 获取CriminalFilingQty总集合 通过 year
	 * @return
	 */
	public List<CriminalFilingQty> getCriminalFilingQtys(String year,String month);
	
	/**
	 * 更新 CriminalFilingQty 通过年月
	 * @param CriminalFilingQty 对象
	 * @return 更新状态
	 */
	public boolean saveCriminalFilingQtyByYearAndMonth(CriminalFilingQty criminalFilingQty);
	
	/**
	 * 获取年历史取证利用率趋势分析图
	 * @param year 年
	 * @return 结果数据集
	 */
	public Map<String, List<String>> getYearHistoryCFQty(String year);
	
	/**
	 * 获取年取证利用率趋势分析图
	 * @param year 年
	 * @param country 地区代码
	 * @return 结果数据集
	 */
	public Map<String, List<String>> getCounryCFQty(String year,String month);
	
	
}
