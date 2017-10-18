package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserTrainingExpDao;
import org.pangolin.eeip.entity.UserTrainingExp;
import org.pangolin.eeip.service.UserTrainingExpService;
import org.springframework.stereotype.Service;

@Service("userTrainingExpService")
@SuppressWarnings("all")
public class UserTrainingExpServiceImpl implements UserTrainingExpService {
	    @Resource
	    private UserTrainingExpDao userTrainingExpDao;
	
	    //根据ID查询
		public UserTrainingExp getUserTrainingExpById(String id) {
			return userTrainingExpDao.get(UserTrainingExp.class, id);
		}
		
		//获取总数量
		public Long getUserTrainingExpQty() {
			return userTrainingExpDao.count("select count(id) from UserTrainingExp where delFlag="+UserTrainingExp.NORMAL);
		} 
		
		//获取总集合
		public List<UserTrainingExp> getUserTrainingExps() {
			return userTrainingExpDao.find("from UserTrainingExp where delFlag="+UserTrainingExp.NORMAL+" order by createdDate desc");
		}
		
		//获取总集合
		public List<UserTrainingExp> getUserTrainingExpsByUserId(String userBasicInfoId) {
					return userTrainingExpDao.find("from UserTrainingExp where delFlag="+UserTrainingExp.NORMAL+" and userBasicInfoId ='"+userBasicInfoId+"'  order by createdDate desc");
		}
		
		//分页查询
		public List<UserTrainingExp> getUserTrainingExps(int startIndex, int rows, String sorter, String sortingAttribute) {
			return userTrainingExpDao.search("from UserTrainingExp where delFlag="+UserTrainingExp.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
		} 
		
		//数据删除
		public boolean removeUserTrainingExp(String id) {
			userTrainingExpDao.executeHql("delete from UserTrainingExp where id = ?", new Object[] { id });
			Long qty = userTrainingExpDao.count("select count(id) from UserTrainingExp where id = ?" , new Object[] { id });
			if ( qty.intValue() == 0 ) return true;
			return false;
		}
		
		//数据删除（伪）
		public boolean removeUserTrainingExpFalse(String id) {
				Integer qty = userTrainingExpDao.executeHql("update  UserTrainingExp set delFlag= ? where id = ?", new Object[] { UserTrainingExp.REMOVED,id });
				if ( qty == 0 ) return false;
				return true;
		}
		
		//数据修改或保存
		public boolean saveUserTrainingExp(UserTrainingExp userTrainingExp) {
			Long qty = userTrainingExpDao.count("select count(id) from UserTrainingExp where delFlag = ? and id = ?", new Object[] { UserTrainingExp.NORMAL, userTrainingExp.getId() });
			if ( qty > 0 ) {
				userTrainingExpDao.update(userTrainingExp);
			} else {
				userTrainingExpDao.save(userTrainingExp);
			}
			
			return true;
			/*String method = "";
			if ( userTrainingExp.getId() == null ) { method = "add"; }
			else { 
				method = "update";
	 		}
			userTrainingExpDao.saveOrUpdate(userTrainingExp);
			if ( method.equals("add") ) {
				if ( userTrainingExp.getId() != null ) return true;
			} else { return true; }
			return false;*/
		}
}
