package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.EvidOpLog;

public interface EvidOpLogService {

	/**
	 * 根据ID查询EvidOpLog
	 * @param appraisalId 电子物证（检材）鉴定ID
	 * @return
	 */
	public EvidOpLog getEvidOpLogById(String id);

	/**
	 * 获取EvidOpLog总集合
	 * @return
	 */
	public List<EvidOpLog> getEvidOpLogsByEvidId(String evidId);
	
	/**
	 * 更新 EvidOpLog
	 * @param evidOpLog 对象
	 * @return 更新状态
	 */
	public boolean saveEvidOpLog(EvidOpLog evidOpLog);
	
	/**
	 * 获取 EvidOpLog 
	 * @param evidId 检材ID
	 * @param spLabel 进出库（公安意义上的） 辨识
	 * @return
	 */
	public EvidOpLog getEvidOpLogByEvidIdAndSpLabel(String evidId,Integer spLabel);
	
	/**
	 * 获取最新的电子物证日志信息
	 * @param evidId 电子物证ID
	 * @param type 日志类型
	 * @return 电子物证日志信息
	 * */
	public EvidOpLog getEvidOpLogByEvidEvidIdAndType(String evidId,Integer type);
	
	
}
