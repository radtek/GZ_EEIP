package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserTraining;

public interface UserTrainingService {

	/**
	 * 根据ID查询UserTraining
	 * ID
	 * @param id
	 * @return
	 */
	public UserTraining getUserTrainingById(String id);

	/**
	 * 根据userBasicInfoId查询UserTraining
	 * userBasicInfoId
	 * @param userBasicInfoId 用户基本信息ID
	 * @return
	 */
	public UserTraining getUserTrainingByUserId(String userBasicInfoId);

	/**
	 * 获取UserTraining总数量
	 * @return
	 */
	public Long getUserTrainingQty();
	
	/**
	 * 获取UserTraining总集合
	 * @return
	 */
	public List<UserTraining> getUserTrainings();
	
	/**
	 * 通过UserID获取UserTraining总集合
	 * @param  userBasicInfoId 用户基本信息ID
	 * @return 
	 */
	public List<UserTraining> getUserTrainingsByUserId(String userBasicInfoId);
	
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserTraining> getUserTrainings(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserTraining
	 * @param id ID
	 * @return
	 */
	public boolean removeUserTraining(String id);
	
	/**
	 * 伪删除UserTraining
	 * @param id ID
	 * @return
	 */
	public boolean removeUserTrainingFalse(String id);
	
	/**
	 * 更新 UserTraining
	 * @param UserTraining 对象
	 * @return 更新状态
	 */
	public boolean saveUserTraining(UserTraining userTraining);

}
