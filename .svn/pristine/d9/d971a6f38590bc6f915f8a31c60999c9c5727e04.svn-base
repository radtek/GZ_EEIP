package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.AppraisalAcptAtt;

public interface AppraisalAcptAttService {

	/**
	 * 根据ID查询AppraisalAcptAtt
	 * ID
	 * @param id
	 * @return
	 */
	public AppraisalAcptAtt getAppraisalAcptAttById(String id);
  
	/**
	 * 获取AppraisalAcptAtt总集合
	 * @return
	 */
	public List<AppraisalAcptAtt> getAppraisalAcptAttsByAppraisalId(String appraisalId);
	
 	/**
	 * 更新 AppraisalAcptAtt
	 * @param AppraisalAcptAtt 对象
	 * @return 更新状态
	 */
	public boolean saveAppraisalAcptAtt(AppraisalAcptAtt appraisalAcptAtt);
	
 	/**
	 * 获取受理的对象
	 * @param appraisalId 检材Id
	 * @return 附件数据
	 */
	public AppraisalAcptAtt getAppraisalAcptAttData(String appraisalId);
	/**
	 * 删除 受理文件爱你
	 * @param id 附件Id
	 * @return 更新状态
	 */
	public boolean removeAppraisalAcptAttData(String id);
}
