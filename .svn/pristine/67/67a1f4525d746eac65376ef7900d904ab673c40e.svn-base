package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserAward;

public interface UserAwardService {
	/**
	 * 根据ID查询UserAward
	 * ID
	 * @param id
	 * @return
	 */
	public UserAward getUserAwardById(String id);

	/**
	 * 获取UserAward总数量
	 * @return
	 */
	public Long getUserAwardQty();
	
	/**
	 * 获取UserAward总集合
	 * @return
	 */
	public List<UserAward> getUserAwards();
	
	/**
	 * 获取UserAward总集合
	 * @return
	 */
	public List<UserAward> getUserAwardsByUserId(String userBasicInfoId);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserAward> getUserAwards(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserAward
	 * @param id ID
	 * @return
	 */
	public boolean removeUserAward(String id);
	
	/**
	 * 伪删除UserAward
	 * @param id ID
	 * @return
	 */
	public boolean removeUserAwardFalse(String id);
	
	/**
	 * 更新 UserAward
	 * @param UserAward 对象
	 * @return 更新状态
	 */
	public boolean saveUserAward(UserAward UserAward);
}
