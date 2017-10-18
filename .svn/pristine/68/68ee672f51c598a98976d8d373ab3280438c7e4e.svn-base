package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserWorks;

public interface UserWorksService  { 

	/**
	 * 根据ID查询UserWorks
	 * ID
	 * @param id
	 * @return
	 */
	public UserWorks getUserWorksById(String id);

	/**
	 * 获取UserWorks总数量
	 * @return
	 */
	public Long getUserWorksQty();
	
	/**
	 * 获取UserWorks总集合
	 * @return
	 */
	public List<UserWorks> getUserWorkss();
	

	/**
	 * 根据userBasicInfoId获取UserWorks总集合
	 * @return
	 */
	public List<UserWorks> getUserWorksByUserId(String userBasicInfoId);
	
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserWorks> getUserWorkss(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserWorks
	 * @param id ID
	 * @return
	 */
	public boolean removeUserWorks(String id);
	
	/**
	 * 伪删除UserWorks
	 * @param id ID
	 * @return
	 */
	public boolean removeUserWorksFalse(String id);
	
	/**
	 * 更新 UserWorks
	 * @param UserWorks 对象
	 * @return 更新状态
	 */
	public boolean saveUserWorks(UserWorks userWorks);

}
