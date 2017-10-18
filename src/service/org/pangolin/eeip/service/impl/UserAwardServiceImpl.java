package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserAwardDao;
import org.pangolin.eeip.entity.UserAward;
import org.pangolin.eeip.service.UserAwardService;
import org.springframework.stereotype.Service;

@Service("userAwardService")
@SuppressWarnings("all")
public class UserAwardServiceImpl implements UserAwardService {

   @Resource
   private UserAwardDao userAwardDao;

   //根据ID查询
	public UserAward getUserAwardById(String id) {
		return userAwardDao.get(UserAward.class, id);
	}
	
	//获取总数量
	public Long getUserAwardQty() {
		return userAwardDao.count("select count(id) from UserAward where delFlag="+UserAward.NORMAL);
	} 
	
	//获取总集合
	public List<UserAward> getUserAwards() {
		return userAwardDao.find("from UserAward where delFlag="+UserAward.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	public List<UserAward> getUserAwards(int startIndex, int rows, String sorter, String sortingAttribute) {
		return userAwardDao.search("from UserAward where delFlag="+UserAward.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	public boolean removeUserAward(String id) {
		userAwardDao.executeHql("delete from UserAward where id = ?", new Object[] { id });
		Long qty = userAwardDao.count("select count(id) from UserAward where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	public boolean removeUserAwardFalse(String id) {
			Integer qty = userAwardDao.executeHql("update  UserAward set delFlag= ? where id = ?", new Object[] { UserAward.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	public boolean saveUserAward(UserAward userAward) {
		Long qty = userAwardDao.count("select count(id) from UserAward where id = ?",new Object[]{ userAward.getId() });
		if( qty > 0 ){
			userAwardDao.update(userAward);
		}else{
			userAwardDao.save(userAward);
		}
		return true;
		/*String method = "";
		if ( UserAward.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		userAwardDao.saveOrUpdate(UserAward);
		if ( method.equals("add") ) {
			if ( UserAward.getId() != null ) return true;
		} else { return true; }
		return false;*/
	}

	@Override
	public List<UserAward> getUserAwardsByUserId(String userBasicInfoId) {
		return userAwardDao.find("from UserAward where delFlag=? and userBasicInfoId=? order by createdDate desc",new Object[]{ UserAward.NORMAL,userBasicInfoId});
	}
	 
}
