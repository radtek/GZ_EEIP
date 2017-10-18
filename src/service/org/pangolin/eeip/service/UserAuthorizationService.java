package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserAuthorization;
import org.pangolin.eeip.entity.UserAuthorization;

public interface UserAuthorizationService {
	/**
	 * 根据ID查询UserAuthorization
	 * ID
	 * @param id
	 * @return
	 */
	public UserAuthorization getUserAuthorizationById(String id);

	/**
	 * 根据userBasicInfoId查询UserAuthorization
	 * @param userBasicInfoId
	 * @return
	 */
	public UserAuthorization getUserAuthorizationByUserId(String userBasicInfoId);	
	
	/**
	 * 获取UserAuthorization总数量
	 * @return
	 */
	public Long getUserAuthorizationQty();
	
	/**
	 * 获取UserAuthorization总集合
	 * @return
	 */
	public List<UserAuthorization> getUserAuthorizations();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserAuthorization> getUserAuthorizations(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserAuthorization
	 * @param id ID
	 * @return
	 */
	public boolean removeUserAuthorization(String id);
	
	/**
	 * 伪删除UserAuthorization
	 * @param id ID
	 * @return
	 */
	public boolean removeUserAuthorizationFalse(String id);
	
	/**
	 * 更新 UserAuthorization
	 * @param UserAuthorization 对象
	 * @return 更新状态
	 */
	public boolean saveUserAuthorization(UserAuthorization userAuthorization);
}
