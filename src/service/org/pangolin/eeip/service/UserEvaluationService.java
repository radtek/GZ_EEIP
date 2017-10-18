package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserEvaluation;

public interface UserEvaluationService {
	/**
	 * 根据ID查询UserEvaluation
	 * @param id
	 * @return
	 */
	public UserEvaluation getUserEvaluationById(String id);

	/**
	 * 根据userBasicInfoId查询UserEvaluation
	 * @param userBasicInfoId
	 * @return
	 */
	public UserEvaluation getUserEvaluationByUserId(String userBasicInfoId);

	
	/**
	 * 获取UserEvaluation总数量
	 * @return
	 */
	public Long getUserEvaluationQty(String userBasicInfoId);
	
	/**
	 * 获取UserEvaluation总集合
	 * @return
	 */
	public List<UserEvaluation> getUserEvaluations();
	
	/**
	 * 根据userBasicInfoId分页查询
	 * @param userBasicInfoId 
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserEvaluation> getUserEvaluations(String userBasicInfoId, int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserEvaluation
	 * @param id ID
	 * @return
	 */
	public boolean removeUserEvaluation(String id);
	
	/**
	 * 伪删除UserEvaluation
	 * @param id ID
	 * @return
	 */
	public boolean removeUserEvaluationFalse(String id);
	
	/**
	 * 更新 UserEvaluation
	 * @param UserEvaluation 对象
	 * @return 更新状态
	 */
	public boolean saveUserEvaluation(UserEvaluation userEvaluation);

}
