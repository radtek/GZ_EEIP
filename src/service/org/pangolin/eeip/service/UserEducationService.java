package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserEducation;

public interface UserEducationService {

	/**
	 * 根据ID查询UserEducation
	 * ID
	 * @param id
	 * @return
	 */
	public UserEducation getUserEducationById(String id);

	/**
	 * 根据userBasicInfoId查询UserEducation
	 * userBasicInfoId
	 * @param userBasicInfoId
	 * @return
	 */
	public UserEducation getUserEducationByUserId(String userBasicInfoId);
 
	
	/**
	 * 获取UserEducation总数量
	 * @return
	 */
	public Long getUserEducationQty();
	
	/**
	 * 获取UserEducation总集合
	 * @return
	 */
	public List<UserEducation> getUserEducations();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserEducation> getUserEducations(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserEducation
	 * @param id ID
	 * @return
	 */
	public boolean removeUserEducation(String id);
	
	/**
	 * 伪删除UserEducation
	 * @param id ID
	 * @return
	 */
	public boolean removeUserEducationFalse(String id);
	
	/**
	 * 更新 UserEducation
	 * @param UserEducation 对象
	 * @return 更新状态
	 */
	public boolean saveUserEducation(UserEducation userEducation);

}
