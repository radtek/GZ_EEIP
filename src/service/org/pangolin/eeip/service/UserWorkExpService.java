package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserWorkExp;

public interface UserWorkExpService {
	/**
	 * 根据ID查询UserWorkExp
	 * ID
	 * @param id
	 * @return
	 */
	public UserWorkExp getUserWorkExpById(String id);

	/**
	 * 根据UserID查询UserWorkExp
	 * UserID
	 * @param Userid
	 * @return
	 */
	public UserWorkExp getUserWorkExpByUserId(String userBasicInfoId);

	
	/**
	 * 获取UserWorkExp总数量
	 * @return
	 */
	public Long getUserWorkExpQty();
	
	/**
	 * 获取UserWorkExp总集合
	 * @return
	 */
	public List<UserWorkExp> getUserWorkExps();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserWorkExp> getUserWorkExps(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserWorkExp
	 * @param id ID
	 * @return
	 */
	public boolean removeUserWorkExp(String id);
	
	/**
	 * 伪删除UserWorkExp
	 * @param id ID
	 * @return
	 */
	public boolean removeUserWorkExpFalse(String id);
	
	/**
	 * 更新 UserWorkExp
	 * @param UserWorkExp 对象
	 * @return 更新状态
	 */
	public boolean saveUserWorkExp(UserWorkExp UserWorkExp);
	
	/**
	 * 根据人员基本信息（userBasicInfoId）ID 获取UserWorkExp总集合
	 * @return
	 */
	public List<UserWorkExp> getUserWorkExps(String userBasicInfoId);
	
	

}
