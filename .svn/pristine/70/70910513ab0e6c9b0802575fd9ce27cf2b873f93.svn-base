package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ImplPlanIaParticipant;

public interface ImplPlanIaParticipantService {

	/***
	 * 保存内审成员信息
	 * @param iaParticipant 内审成员信息对象
	 * @return 保存状态
	 */
	public boolean saveImplPlanIaParticipant(ImplPlanIaParticipant iaParticipant);
	
	/***
	 * 根据内部审核实施计划申请ID获取内审成员信息列表
	 * @param appId 内部审核实施计划申请ID
	 * @return 内审成员信息列表
	 */
	public List<ImplPlanIaParticipant> getImplPlanIaParticipantsByAppId(String appId);
	
	/**
	 * 根据ID删除参会人信息
	 * @param id 参会人ID
	 * @return 删除状态
	 */
	public boolean removeImplPlanIaParticipant(String id);
	
	/**
	 * 根据申请ID删除参会人信息
	 * @param appId 参会人ID
	 * @return 删除状态
	 */
	public boolean removeImplPlanIaParticipantByAppId(String appId);
}
