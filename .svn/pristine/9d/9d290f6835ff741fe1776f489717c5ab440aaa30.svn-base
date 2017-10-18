package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserTrainingExp;

public interface UserTrainingExpService {
	/**
	 * 根据ID查询UserTrainingExp
	 * ID
	 * @param id
	 * @return
	 */
	public UserTrainingExp getUserTrainingExpById(String id);

	/**
	 * 获取UserTrainingExp总数量
	 * @return
	 */
	public Long getUserTrainingExpQty();
	
	/**
	 * 获取UserTrainingExp总集合
	 * @return
	 */
	public List<UserTrainingExp> getUserTrainingExps();
	
	

	/**
	 * 根据userBasicInfoId获取UserTrainingExp总集合
	 * @return
	 */
	public List<UserTrainingExp> getUserTrainingExpsByUserId(String userBasicInfoId);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserTrainingExp> getUserTrainingExps(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserTrainingExp
	 * @param id ID
	 * @return
	public boolean removeUserTrainingExp(String id);
	
	/**
	 * 伪删除UserTrainingExp
	 * @param id ID
	 * @return
	 */
	public boolean removeUserTrainingExpFalse(String id);
	
	/**
	 * 更新 UserTrainingExp
	 * @param UserTrainingExp 对象
	 * @return 更新状态
	 */
	public boolean saveUserTrainingExp(UserTrainingExp userTrainingExp);

}
