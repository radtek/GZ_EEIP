package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.EvidOpLogAtt;

public interface EvidOpLogAttService {
	/**
	 * 根据ID获取电子物证操作日志附件
 	 * @param preappraisalId 电子物证（检材）鉴定ID
	 * @return 电子物证类型信息
	 * */
	public List<EvidOpLogAtt> getEvidOpLogAttByPreappraisalId(String appraisalId);
	
	/**
	 * 根据ID获取电子物证操作日志附件
 	 * @param id ID
	 * @return 电子物证类型信息
	 * */
	public EvidOpLogAtt getEvidOpLogAttById(String id);
	
	/**
	 * 根据ID获取电子物证删除日志附件
 	 * @param id ID
	 * @return 电子物证类型信息
	 * */
	public boolean removeEvidOpLogAttById(String id);
	
	/**
	 * 保存电子物证交接附件信息
	 * @param evidOpLogAtt
	 * @return
	 */
	public boolean saveEvidOpLogAtt(EvidOpLogAtt evidOpLogAtt);
	/**
	 * 根据LogID获取电子物证操作日志附件
 	 * @param preappraisalId 电子物证（检材）鉴定ID
	 * @return 电子物证类型信息
	 * */
	public List<EvidOpLogAtt> getEvidOpLogAttByEvidOpLogId(String evidOpLogId);

	/**
	 * 根据evid获取入库照片
	 * @param evidenceId
	 * @return
	 */
	public List<EvidOpLogAtt> getEvidOpLogAttByEvidenceId(String evidenceId);
	
}
