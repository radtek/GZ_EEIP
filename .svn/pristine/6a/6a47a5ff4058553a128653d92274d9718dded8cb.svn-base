package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserWorksDao;
import org.pangolin.eeip.entity.UserWorks;
import org.pangolin.eeip.entity.UserWorks;
import org.pangolin.eeip.service.UserWorksService;
import org.springframework.stereotype.Service;

@Service("userWorksService")
@SuppressWarnings("all")
public class UserWorksServiceImpl implements  UserWorksService{

	@Resource
    private UserWorksDao userWorksDao;
	 
	 //根据ID查询
		public UserWorks getUserWorksById(String id) {
			return userWorksDao.get(UserWorks.class, id);
		}
		
		//获取总数量
		public Long getUserWorksQty() {
			return userWorksDao.count("select count(id) from UserWorks where delFlag="+UserWorks.NORMAL);
		} 
		
		//获取总集合
		public List<UserWorks> getUserWorkss() {
			return userWorksDao.find("from UserWorks where delFlag="+UserWorks.NORMAL+" order by createdDate desc");
		}
		
		//分页查询
		public List<UserWorks> getUserWorkss(int startIndex, int rows, String sorter, String sortingAttribute) {
			return userWorksDao.search("from UserWorks where delFlag="+UserWorks.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
		} 
		
		//数据删除
		public boolean removeUserWorks(String id) {
			userWorksDao.executeHql("delete from UserWorks where id = ?", new Object[] { id });
			Long qty = userWorksDao.count("select count(id) from UserWorks where id = ?" , new Object[] { id });
			if ( qty.intValue() == 0 ) return true;
			return false;
		}
		
		//数据删除（伪）
		public boolean removeUserWorksFalse(String id) {
				Integer qty = userWorksDao.executeHql("update  UserWorks set delFlag= ? where id = ?", new Object[] { UserWorks.REMOVED,id });
				if ( qty == 0 ) return false;
				return true;
		}
		
		//数据修改或保存
		public boolean saveUserWorks(UserWorks userWorks) {
			Long qty = userWorksDao.count("select count(id) from UserWorks where id = ?",new Object[]{ userWorks.getId() });
			if( qty > 0 ){
				userWorksDao.update(userWorks);
			}else{
				userWorksDao.save(userWorks);
			}
			return true;
			/*String method = "";
			if ( userWorks.getId() == null ) { method = "add"; }
			else { 
				method = "update";
	 		}
			userWorksDao.saveOrUpdate(userWorks);
			if ( method.equals("add") ) {
				if ( userWorks.getId() != null ) return true;
			} else { return true; }
			return false;*/
		}

		@Override
		public List<UserWorks> getUserWorksByUserId(String userBasicInfoId) {
			return userWorksDao.find("from UserWorks where delFlag=? and userBasicInfoId =?  order by createdDate desc" ,new Object[]{UserWorks.NORMAL,userBasicInfoId});
		}
	
}
