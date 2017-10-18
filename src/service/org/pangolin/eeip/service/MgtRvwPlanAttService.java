package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.MgtRvwPlanAtt;

public interface MgtRvwPlanAttService {

	/***
	 * 保存管理评审计划附件信息
	 * @param implPlanAtt 管理评审计划附件对象
	 * @return 保存状态
	 */
	public boolean saveMgtRvwPlanAtt(MgtRvwPlanAtt mgtRvwPlanAtt);
	
	/***
	 * 根据ID伪删除管理评审计划附件信息（修改状态）
	 * @param id
	 * @return 删除状态
	 */
	public boolean removeMgtRvwPlanAtt(String id);
	
	/***
	 * 根据Id修改管理评审计划附件状态
	 * @param id ID
	 */
	public void updateMgtRvwPlanAttStatus(String id);
	
	/***
	 * 根据管理评审计划申请ID获取管理评审计划附件信息
	 * @param appId 申请ID
	 * @return 管理评审计划附件列表
	 */
	public List<MgtRvwPlanAtt> getMgtRvwPlanAttByAppId(String appId);
	
	/***
	 * 根据ID获取管理评审计划附件信息
	 * @param id ID
	 * @return 管理评审计划附件对象
	 */
	public MgtRvwPlanAtt getMgtRvwPlanAtt(String id);
}
