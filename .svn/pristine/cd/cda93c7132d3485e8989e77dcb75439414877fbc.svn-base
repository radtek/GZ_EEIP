package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ImplPlanAtt;

public interface ImplPlanAttService {

	/***
	 * 根据ID获取内审实施计划附件信息
	 * @param id ID
	 * @return 内审实施计划附件对象
	 */
	public ImplPlanAtt getImplPlanAtt(String id);
	
	/***
	 * 保存内审实施计划附件信息
	 * @param implPlanAtt 内审实施计划附件对象
	 * @return 保存状态
	 */
	public boolean saveImplPlanAtt(ImplPlanAtt implPlanAtt);
	
	/***
	 * 根据ID伪删除内审实施计划附件信息（修改状态）
	 * @param id
	 * @return 删除状态
	 */
	public boolean removeImplPlanAtt(String id);
	
	/***
	 * 根据Id修改内审实施计划附件状态
	 * @param id ID
	 */
	public void updateImplPlanAttStatus(String id);
	
	/***
	 * 根据内审实施计划申请ID获取内审实施计划附件信息
	 * @param appId 申请ID
	 * @return 内审实施计划附件列表
	 */
	public List<ImplPlanAtt> getImplPlanAttsByAppId(String appId);
}
