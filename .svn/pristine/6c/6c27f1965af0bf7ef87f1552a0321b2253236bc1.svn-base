package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserTrainingDao;
import org.pangolin.eeip.entity.UserTraining;
import org.pangolin.eeip.service.UserTrainingService;
import org.springframework.stereotype.Service;

@Service("userTrainingService")
@SuppressWarnings("all")
public class UserTrainingServiceImpl implements UserTrainingService {

	@Resource
	private UserTrainingDao userTrainingDao;

	// 根据ID查询
	public UserTraining getUserTrainingById(String id) {
		return userTrainingDao.get(UserTraining.class, id);
	}

	@Override
	public UserTraining getUserTrainingByUserId(String userBasicInfoId) {
		return userTrainingDao.get(" from UserTraining where delFlag = ? and  userBasicInfoId =?", new Object[]{UserTraining.NORMAL,userBasicInfoId});
	}
	
	// 获取总数量
	public Long getUserTrainingQty() {
		return userTrainingDao.count("select count(id) from UserTraining where delFlag=" + UserTraining.NORMAL);
	}

	// 获取总集合
	public List<UserTraining> getUserTrainings() {
		return userTrainingDao
				.find("from UserTraining where delFlag=" + UserTraining.NORMAL + " order by createdDate desc");
	}

	// 分页查询
	public List<UserTraining> getUserTrainings(int startIndex, int rows, String sorter, String sortingAttribute) {
		return userTrainingDao.search("from UserTraining where delFlag=" + UserTraining.NORMAL + " order by " + sorter
				+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
	}

	// 数据删除
	public boolean removeUserTraining(String id) {
		userTrainingDao.executeHql("delete from UserTraining where id = ?", new Object[] { id });
		Long qty = userTrainingDao.count("select count(id) from UserTraining where id = ?", new Object[] { id });
		if (qty.intValue() == 0)
			return true;
		return false;
	}

	// 数据删除（伪）
	public boolean removeUserTrainingFalse(String id) {
		Integer qty = userTrainingDao.executeHql("update  UserTraining set delFlag= ? where id = ?",
				new Object[] { UserTraining.REMOVED, id });
		if (qty == 0)
			return false;
		return true;
	}

	// 数据修改或保存
	public boolean saveUserTraining(UserTraining userTraining) {
		try {
			String id = userTraining.getId();
 			Long qty = userTrainingDao.count("select count(id) from UserTraining where id=?", new Object[] {id}); 
 			if (qty > 0) {    
 				userTrainingDao.update(userTraining);
			} else {  
				userTrainingDao.save(userTraining);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;  
	}

	@Override
	public List<UserTraining> getUserTrainingsByUserId(String userBasicInfoId) {
		return userTrainingDao.find("from UserTraining where delFlag=? and userBasicInfoId =? ", new Object[]{UserTraining.NORMAL,userBasicInfoId});
	}

}
