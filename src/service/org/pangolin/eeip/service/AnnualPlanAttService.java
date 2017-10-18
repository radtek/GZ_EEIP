package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AnnualPlanAtt;

public interface AnnualPlanAttService {

	/***
	 * 保存年度审核计划附件信息
	 * @param implPlanAtt 年度审核计划附件对象
	 * @return 保存状态
	 */
	public boolean saveAnnualPlanAtt(AnnualPlanAtt annualPlanAtt);
	
	/***
	 * 根据ID伪删除年度审核计划附件信息（修改状态）
	 * @param id
	 * @return 删除状态
	 */
	public boolean removeAnnualPlanAtt(String id);
	
	/***
	 * 根据Id修改年度审核计划附件状态
	 * @param id ID
	 */
	public void updateAnnualPlanAttStatus(String id);
	
	/***
	 * 根据年度审核计划申请ID获取年度审核计划附件信息
	 * @param appId 申请ID
	 * @return 年度审核计划附件列表
	 */
	public List<AnnualPlanAtt> getAnnualPlanAttsByAppId(String appId);
	
	/***
	 * 根据ID获取年度审核计划附件信息
	 * @param id ID
	 * @return 年度审核计划附件对象
	 */
	public AnnualPlanAtt getAnnualPlanAtt(String id);
}
