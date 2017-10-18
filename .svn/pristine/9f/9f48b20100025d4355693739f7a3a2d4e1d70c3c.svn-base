package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserEvaluationDao;
import org.pangolin.eeip.entity.UserEvaluation;
import org.pangolin.eeip.service.UserEvaluationService;
import org.springframework.stereotype.Service;

@Service("userEvaluationService")
@SuppressWarnings("all")
public class UserEvaluationServiceImpl implements UserEvaluationService {

	@Resource
	private UserEvaluationDao userEvaluationDao;
	
	 //根据ID查询
		public UserEvaluation getUserEvaluationById(String id) {
			return userEvaluationDao.get(UserEvaluation.class, id);
		}
		
		@Override
		public UserEvaluation getUserEvaluationByUserId(String userBasicInfoId) {
 			return userEvaluationDao.get("from UserEvaluation where userBasicInfoId = ? and  delFlag=?", new Object[]{userBasicInfoId,UserEvaluation.NORMAL});
		}
		
		//获取总数量
		public Long getUserEvaluationQty(String userBasicInfoId) {
			return userEvaluationDao.count("select count(id) from UserEvaluation where delFlag= ? and userBasicInfoId = ? ", new Object[] { UserEvaluation.NORMAL, userBasicInfoId });
		} 
		
		//获取总集合
		public List<UserEvaluation> getUserEvaluations() {
			return userEvaluationDao.find("from UserEvaluation where delFlag="+UserEvaluation.NORMAL+" order by createdDate desc");
		}
		
		//分页查询
		public List<UserEvaluation> getUserEvaluations(String userBasicInfoId, int startIndex, int rows, String sorter, String sortingAttribute) {
			return userEvaluationDao.search("from UserEvaluation where delFlag= ? and userBasicInfoId = ? order by " + sorter + " " + sortingAttribute, new Object[] { UserEvaluation.NORMAL, userBasicInfoId }, startIndex, rows);
		} 
		
		//数据删除
		public boolean removeUserEvaluation(String id) {
			userEvaluationDao.executeHql("delete from UserEvaluation where id = ?", new Object[] { id });
			Long qty = userEvaluationDao.count("select count(id) from UserEvaluation where id = ?" , new Object[] { id });
			if ( qty.intValue() == 0 ) return true;
			return false;
		}
		
		//数据删除（伪）
		public boolean removeUserEvaluationFalse(String id) {
				Integer qty = userEvaluationDao.executeHql("update  UserEvaluation set delFlag= ? where id = ?", new Object[] { UserEvaluation.REMOVED,id });
				if ( qty == 0 ) return false;
				return true;
		}
		
		//数据修改或保存
		public boolean saveUserEvaluation(UserEvaluation userEvaluation) {
			String method = "";
			if ( userEvaluation.getId() == null ) { method = "add"; }
			else { 
				method = "update";
	 		}
			userEvaluationDao.saveOrUpdate(userEvaluation);
			if ( method.equals("add") ) {
				if ( userEvaluation.getId() != null ) return true;
			} else { return true; }
			return false;
		}

		
	 
}
