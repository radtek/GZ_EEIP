package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Evidence;

public interface EvidenceService {

	/**
	 * 根据ID查询Evidence
	 * ID
	 * @param id
	 * @return
	 */
	public Evidence getEvidenceById(String id);

	/**
	 * 根据ID查询Evidence
	 * @param appraisalId 电子物证（检材）鉴定ID
	 * @return
	 */
	public Evidence getEvidenceByAppraisalId(String appraisalId);
	
	/**
	 * 根据evidId查询Evidence
	 * @param 电子物证信息表ID
	 * @return
	 */
	public Evidence getEvidenceByEvidId(String evidId);

	
	/**
	 * 获取Evidence总数量
	 * @return
	 */
	public Long getEvidenceQty();
	
	/**
	 * 获取Evidence总集合
	 * @return
	 */
	public List<Evidence> getEvidences();
	
	/**
	 * 获取Evidence总集合
	 * @return
	 */
	public List<Evidence> getEvidencesByAppraisalId(String appraisalId);
	
	 
	/**
	 * 删除Evidence
	 * @param id ID
	 * @return
	 */
	public boolean removeEvidence(String id);
	
	/**
	 * 更新 Evidence
	 * @param Evidence 对象
	 * @return 更新状态
	 */
	public boolean saveEvidence(Evidence Evidence);
}
