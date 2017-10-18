package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.TrainingPlanAtt;

public interface TrainingPlanAttService {

	/***
	 * 保存培训计划附件信息
	 * @param implPlanAtt 培训计划附件对象
	 * @return 保存状态
	 */
	public boolean saveTrainingPlanAtt(TrainingPlanAtt trainingPlanAtt);
	
	/***
	 * 根据ID伪删除培训计划附件信息（修改状态）
	 * @param id
	 * @return 删除状态
	 */
	public boolean removeTrainingPlanAtt(String id);
	
	/***
	 * 根据Id修改培训计划附件状态
	 * @param id ID
	 */
	public void updateTrainingPlanAttStatus(String id);
	
	/***
	 * 根据培训计划ID获取培训计划附件信息
	 * @param appId 申请ID
	 * @return 培训计划附件列表
	 */
	public List<TrainingPlanAtt> getTrainingPlanAttsByAppId(String appId);
	
	/***
	 * 根据ID获取培训计划附件信息
	 * @param id ID
	 * @return 培训计划附件对象
	 */
	public TrainingPlanAtt getTrainingPlanAtt(String id);
}
