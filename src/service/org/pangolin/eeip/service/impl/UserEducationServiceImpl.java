package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserEducationDao;
import org.pangolin.eeip.entity.UserEducation;
import org.pangolin.eeip.service.UserEducationService;
import org.springframework.stereotype.Service;

@Service("userEducationService")
@SuppressWarnings("all")
public class UserEducationServiceImpl extends BaseServiceImpl<UserEducation> implements UserEducationService {

	  @Resource
      private UserEducationDao userEducationDao;
	
	   //根据ID查询
		public UserEducation getUserEducationById(String id) {
			return userEducationDao.get(UserEducation.class, id);
		}
		
		//获取总数量
		public Long getUserEducationQty() {
			return userEducationDao.count("select count(id) from UserEducation where delFlag="+UserEducation.NORMAL);
		} 
		
		//获取总集合
		public List<UserEducation> getUserEducations() {
			return userEducationDao.find("from UserEducation where delFlag="+UserEducation.NORMAL+" order by createdDate desc");
		}
		
		//分页查询
		public List<UserEducation> getUserEducations(int startIndex, int rows, String sorter, String sortingAttribute) {
			return userEducationDao.search("from UserEducation where delFlag="+UserEducation.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
		} 
		
		//数据删除
		public boolean removeUserEducation(String id) {
			userEducationDao.executeHql("delete from UserEducation where id = ?", new Object[] { id });
			Long qty = userEducationDao.count("select count(id) from UserEducation where id = ?" , new Object[] { id });
			if ( qty.intValue() == 0 ) return true;
			return false;
		}
		
		//数据删除（伪）
		public boolean removeUserEducationFalse(String id) {
				Integer qty = userEducationDao.executeHql("update  UserEducation set delFlag= ? where id = ?", new Object[] { UserEducation.REMOVED,id });
				if ( qty == 0 ) return false;
				return true;
		}
		
		//数据修改或保存
		public boolean saveUserEducation(UserEducation userEducation) {
			String method = "";
			if ( userEducation.getId() == null ) { method = "add"; }
			else { 
				method = "update";
	 		}
			userEducationDao.saveOrUpdate(userEducation);
			if ( method.equals("add") ) {
				if ( userEducation.getId() != null ) return true;
			} else { return true; }
			return false;
		}

		@Override
		public UserEducation getUserEducationByUserId(String userBasicInfoId) {
			return userEducationDao.get("from UserEducation where userBasicInfoId = ? and  delFlag= ?", new Object[]{userBasicInfoId,UserEducation.NORMAL});
		}
	 
}
