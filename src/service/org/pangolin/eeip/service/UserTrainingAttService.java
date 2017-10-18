package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserTrainingAtt;

public interface UserTrainingAttService {

	/**
	 * 根据ID查询UserTrainingAtt
	 * ID
	 * @param id
	 * @return
	 */
	public UserTrainingAtt getUserTrainingAttById(String id);

	/**
	 * 获取UserTrainingAtt总数量
	 * @return
	 */
	public Long getUserTrainingAttQty();
	
	/**
	 * 获取UserTrainingAtt总集合
	 * @return
	 */
	public List<UserTrainingAtt> getUserTrainingAtts();
	
	/**
	 * 获取UserTrainingAtt总集合
	 * @return
	 */
	public List<UserTrainingAtt> getUserTrainingAttsByTraId(String userTrainingId);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserTrainingAtt> getUserTrainingAtts(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserTrainingAtt
	 * @param id ID
	 * @return
	 */
	public boolean removeUserTrainingAtt(String id);
	
	/**
	 * 伪删除UserTrainingAtt
	 * @param id ID
	 * @return
	 */
	public boolean removeUserTrainingAttFalse(String id);
	
	/**
	 * 更新 UserTrainingAtt
	 * @param UserTrainingAtt 对象
	 * @return 更新状态
	 */
	public boolean saveUserTrainingAtt(UserTrainingAtt userTrainingAtt);

}
