package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserWorkExpDao;
import org.pangolin.eeip.entity.UserWorkExp;
import org.pangolin.eeip.service.UserWorkExpService;
import org.springframework.stereotype.Service;

@Service("userWorkExpService")
@SuppressWarnings("all")
public class UserWorkExpServiceImpl implements UserWorkExpService {

	@Resource
	private UserWorkExpDao userWorkExpDao;
	
	 //根据ID查询
		public UserWorkExp getUserWorkExpById(String id) {
			return userWorkExpDao.get(UserWorkExp.class, id);
		}
		
		//获取总数量
		public Long getUserWorkExpQty() {
			return userWorkExpDao.count("select count(id) from UserWorkExp where delFlag="+UserWorkExp.NORMAL);
		} 
		
		//获取总集合
		public List<UserWorkExp> getUserWorkExps() {
			return userWorkExpDao.find("from UserWorkExp where delFlag="+UserWorkExp.NORMAL+" order by createdDate desc");
		}
		
		//分页查询
		public List<UserWorkExp> getUserWorkExps(int startIndex, int rows, String sorter, String sortingAttribute) {
			return userWorkExpDao.search("from UserWorkExp where delFlag="+UserWorkExp.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
		} 
		
		//数据删除
		public boolean removeUserWorkExp(String id) {
			userWorkExpDao.executeHql("delete from UserWorkExp where id = ?", new Object[] { id });
			Long qty = userWorkExpDao.count("select count(id) from UserWorkExp where id = ?" , new Object[] { id });
			if ( qty.intValue() == 0 ) return true;
			return false;
		}
		
		//数据删除（伪）
		public boolean removeUserWorkExpFalse(String id) {
				Integer qty = userWorkExpDao.executeHql("update  UserWorkExp set delFlag= ? where id = ?", new Object[] { UserWorkExp.REMOVED,id });
				if ( qty == 0 ) return false;
				return true;
		}
		
		//数据修改或保存
		public boolean saveUserWorkExp(UserWorkExp userWorkExp) {
			Long qty = userWorkExpDao.count("select count(id) from UserWorkExp where id = ?",new Object[]{ userWorkExp.getId() });
			if( qty > 0 ){
				userWorkExpDao.update(userWorkExp);
			}else{
				userWorkExpDao.save(userWorkExp);
			}
			return true;
			/*String method = "";
			if ( userWorkExp.getId() == null ) { method = "add"; }
			else { 
				method = "update";
	 		}
			userWorkExpDao.saveOrUpdate(userWorkExp);
			if ( method.equals("add") ) {
				if ( userWorkExp.getId() != null ) return true;
			} else { return true; }
			return false;*/
		}

		@Override
		public List<UserWorkExp> getUserWorkExps(String userBasicInfoId) { 
			return userWorkExpDao.find("from UserWorkExp where userBasicInfoId='"+userBasicInfoId+"' and  delFlag="+UserWorkExp.NORMAL+" order by createdDate desc");
		}

		@Override
		public UserWorkExp getUserWorkExpByUserId(String userBasicInfoId) {
			return userWorkExpDao.get("from UserWorkExp where userBasicInfoId=? and  delFlag=? ", new Object[]{userBasicInfoId,UserWorkExp.NORMAL});
		}
}
