package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ImplPlan;

public interface ImplPlanService {

	/***
	 * 保存内部审核实施计划信息
	 * @param implPlan 内部审核实施计划
	 * @return 保存状态
	 */
	public boolean saveImplPlan(ImplPlan implPlan);
	
	/***
	 * 根据ID获取内部审核实施计划信息
	 * @param id ID
	 * @return
	 */
	public ImplPlan getImplPlan(String id);
	
	/***
	 * 根据内部审核实施计划申请 ID获取内部审核实施计划信息列表
	 * @param appId 内部审核实施计划申请 ID
	 * @return 内部审核实施计划信息列表
	 */
	public List<ImplPlan> getImplPlansByAppId(String appId);
	
	/***
	 * 根据ID删除内审实施计划信息
	 * @param id ID
	 * @return 删除状态
	 */
	public boolean removeImplPlan(String id);
}
