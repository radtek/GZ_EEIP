package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.UserCertificate;

public interface UserCertificateService {

	/**
	 * 根据ID查询UserCertificate
	 * ID
	 * @param id
	 * @return
	 */
	public UserCertificate getUserCertificateById(String id);

	/**
	 * 获取UserCertificate总数量
	 * @return
	 */
	public Long getUserCertificateQty();
	
	/**
	 * 获取UserCertificate总集合
	 * @return
	 */
	public List<UserCertificate> getUserCertificates();
	
	/**
	 * 获取UserCertificate总集合userBasicInfoId
	 * @return
	 */
	public List<UserCertificate> getUserCertificatesByUserId(String userBasicInfoId);
	
	/**
	 * 分页查询
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return
	 */
	public List<UserCertificate> getUserCertificates(int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 删除UserCertificate
	 * @param id ID
	 * @return
	 */
	public boolean removeUserCertificate(String id);
	
	/**
	 * 伪删除UserCertificate
	 * @param id ID
	 * @return
	 */
	public boolean removeUserCertificateFalse(String id);
	
	/**
	 * 更新 UserCertificate
	 * @param UserCertificate 对象
	 * @return 更新状态
	 */
	public boolean saveUserCertificate(UserCertificate userCertificate);

}
