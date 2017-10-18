package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ImplPlanParticipant;

public interface ImplPlanParticipantService {

	/***
	 * 保存参会人信息
	 * @param participant 参会人信息对象
	 * @return 保存状态
	 */
	public boolean saveImplPlanParticipant(ImplPlanParticipant participant);
	
	/***
	 * 根据内部审核实施计划申请ID获取参会人信息列表
	 * @param appId 内部审核实施计划申请ID
	 * @return
	 */
	public List<ImplPlanParticipant> getImplPlanParticipantsByAppId(String appId);
	
	/**
	 * 根据ID删除参会人信息
	 * @param id 参会人ID
	 * @return 删除状态
	 */
	public boolean removeImplPlanParticipant(String id);
	
	/**
	 * 根据申请ID删除参会人信息
	 * @param id 参会人ID
	 * @return 删除状态
	 */
	public boolean removeImplPlanParticipantByAppId(String appId);
}
