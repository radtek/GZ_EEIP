package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserTrainingAttDao;
import org.pangolin.eeip.entity.UserTrainingAtt;
import org.pangolin.eeip.service.UserTrainingAttService;
import org.springframework.stereotype.Service;

@Service("userTrainingAttService")
@SuppressWarnings("all")
public class UserTrainingAttServiceImpl implements UserTrainingAttService {

	@Resource
	private UserTrainingAttDao userTrainingAttDao;

	// 根据ID查询
	public UserTrainingAtt getUserTrainingAttById(String id) {
		return userTrainingAttDao.get(UserTrainingAtt.class, id);
	}

	// 获取总数量
	public Long getUserTrainingAttQty() {
		return userTrainingAttDao.count("select count(id) from UserTrainingAtt where delFlag=" + UserTrainingAtt.NORMAL);
	}

	// 获取总集合
	public List<UserTrainingAtt> getUserTrainingAtts() {
		return userTrainingAttDao
				.find("from UserTrainingAtt where delFlag=" + UserTrainingAtt.NORMAL + " order by createdDate desc");
	}

	@Override
	public List<UserTrainingAtt> getUserTrainingAttsByTraId(String userTrainingId) {
		return userTrainingAttDao.find(" from UserTrainingAtt where delFlag=? and userTrainingId=? order by createdDate desc", new Object[]{UserTrainingAtt.NORMAL,userTrainingId});
	}
	
	// 分页查询
	public List<UserTrainingAtt> getUserTrainingAtts(int startIndex, int rows, String sorter, String sortingAttribute) {
		return userTrainingAttDao.search("from UserTrainingAtt where delFlag=" + UserTrainingAtt.NORMAL + " order by " + sorter
				+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
	}

	// 数据删除
	public boolean removeUserTrainingAtt(String id) {
		userTrainingAttDao.executeHql("delete from UserTrainingAtt where id = ?", new Object[] { id });
		Long qty = userTrainingAttDao.count("select count(id) from UserTrainingAtt where id = ?", new Object[] { id });
		if (qty.intValue() == 0)
			return true;
		return false;
	}

	// 数据删除（伪）
	public boolean removeUserTrainingAttFalse(String id) {
		Integer qty = userTrainingAttDao.executeHql("update  UserTrainingAtt set delFlag= ? where id = ?",
				new Object[] { UserTrainingAtt.REMOVED, id });
		if (qty == 0)
			return false;
		return true;
	}

	// 数据修改或保存
	public boolean saveUserTrainingAtt(UserTrainingAtt userTrainingAtt) {
		String method = "";
		if (userTrainingAtt.getId() == null) {
			method = "add";
		} else {
			method = "update";
		}
		userTrainingAttDao.saveOrUpdate(userTrainingAtt);
		if (method.equals("add")) {
			if (userTrainingAtt.getId() != null)
				return true;
		} else {
			return true;
		}
		return false;
	}
 
}
