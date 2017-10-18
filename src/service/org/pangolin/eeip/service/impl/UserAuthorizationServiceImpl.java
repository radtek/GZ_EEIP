package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserAuthorizationDao;
import org.pangolin.eeip.entity.UserAuthorization;
import org.pangolin.eeip.service.UserAuthorizationService;
import org.springframework.stereotype.Service;

@Service("userAuthorizationService")
@SuppressWarnings("all")
public class UserAuthorizationServiceImpl implements UserAuthorizationService {

	@Resource
	private UserAuthorizationDao userAuthorizationDao;
	
	
    //根据ID查询
	public UserAuthorization getUserAuthorizationById(String id) {
		return userAuthorizationDao.get(UserAuthorization.class, id);
	}
	
	@Override
	public UserAuthorization getUserAuthorizationByUserId(String userBasicInfoId) {
		return userAuthorizationDao.get("from UserAuthorization where userBasicInfoId=? and delFlag=? ", new Object[]{userBasicInfoId,UserAuthorization.NORMAL});
	}
	//获取总数量
	public Long getUserAuthorizationQty() {
		return userAuthorizationDao.count("select count(id) from UserAuthorization where delFlag="+UserAuthorization.NORMAL);
	} 
	
	//获取总集合
	public List<UserAuthorization> getUserAuthorizations() {
		return userAuthorizationDao.find("from UserAuthorization where delFlag="+UserAuthorization.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	public List<UserAuthorization> getUserAuthorizations(int startIndex, int rows, String sorter, String sortingAttribute) {
		return userAuthorizationDao.search("from UserAuthorization where delFlag="+UserAuthorization.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	public boolean removeUserAuthorization(String id) {
		userAuthorizationDao.executeHql("delete from UserAuthorization where id = ?", new Object[] { id });
		Long qty = userAuthorizationDao.count("select count(id) from UserAuthorization where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	public boolean removeUserAuthorizationFalse(String id) {
			Integer qty = userAuthorizationDao.executeHql("update  UserAuthorization set delFlag= ? where id = ?", new Object[] { UserAuthorization.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	public boolean saveUserAuthorization(UserAuthorization userAuthorization) {
		String method = "";
		if ( userAuthorization.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		userAuthorizationDao.saveOrUpdate(userAuthorization);
		if ( method.equals("add") ) {
			if ( userAuthorization.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	
}
