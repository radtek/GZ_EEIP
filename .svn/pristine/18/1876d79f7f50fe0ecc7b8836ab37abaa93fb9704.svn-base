package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserBasicInfo;

public interface UserBasicInfoService {
	/**
	 * 根据ID查询UserBasicInfo
	 * ID
	 * @param id
	 * @return
	 */
	public UserBasicInfo getUserBasicInfoById(String id);

	/**
	 * 根据userId查询UserBasicInfo
	 * userId
	 * @param userId
	 * @return
	 */
	public UserBasicInfo getUserBasicInfoByUserId(String userId);

	
	/**
	 * 获取UserBasicInfo总数量
	 * @return
	 */
	public Long getUserBasicInfoQty();
	
	/**
	 * 列表获取UserBasicInfo总数量
	 * @param queryParam 查询条件（ 姓名，专业，现任技术职务）
	 * @return
	 */
	public Long getUserBasicInfoQty(String queryParam);
	
	
	/**
	 * 获取UserBasicInfo总集合
	 * @return
	 */
	public List<UserBasicInfo> getUserBasicInfos();
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserBasicInfo> getUserBasicInfos(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 条件分页查询
	 * @param queryParam 查询条件（姓名,专业,现任技术职务）
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserBasicInfo> getUserBasicInfos(String queryParam,int startIndex, int rows, String sorter, String sortingAttribute);
	
	
	/**
	 * 删除UserBasicInfo
	 * @param id ID
	 * @return
	 */
	public boolean removeUserBasicInfo(String id);
	
	/**
	 * 伪删除UserBasicInfo
	 * @param id ID
	 * @return
	 */
	public boolean removeUserBasicInfoFalse(String id);
	
	/**
	 * 更新 UserBasicInfo
	 * @param UserBasicInfo 对象
	 * @return 更新状态
	 */
	public boolean saveUserBasicInfo(UserBasicInfo UserBasicInfo);

}
