package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserBasicInfoDao;
import org.pangolin.eeip.entity.UserBasicInfo;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.UserBasicInfoService;
import org.springframework.stereotype.Service;


@Service("userBasicInfoService")
@SuppressWarnings("all")
public class UserBasicInfoServiceImpl implements UserBasicInfoService {

	@Resource
	private UserBasicInfoDao userBasicInfoDao;
	
	 //根据ID查询
		public UserBasicInfo getUserBasicInfoById(String id) {
			return userBasicInfoDao.get(UserBasicInfo.class, id);
		}
		
        //根据UserId加载人员基本信息
		@Override
		public UserBasicInfo getUserBasicInfoByUserId(String userId) {
 			return userBasicInfoDao.get("from UserBasicInfo where delFlag =? and userId = ?", new Object[]{UserBasicInfo.NORMAL,userId});
		}
		
		//获取总数量
		public Long getUserBasicInfoQty() {
			return userBasicInfoDao.count("select count(id) from UserBasicInfo where delFlag="+UserBasicInfo.NORMAL);
		} 
		
		//获取总集合
		public List<UserBasicInfo> getUserBasicInfos() {
			return userBasicInfoDao.find("from UserBasicInfo where delFlag =? and appraisalFlag =? order by createdDate desc",new Object[]{UserBasicInfo.NORMAL,UserBasicInfo.NOT_ASSIGNED});
		}
		
		//分页查询
		public List<UserBasicInfo> getUserBasicInfos(int startIndex, int rows, String sorter, String sortingAttribute) {
			return userBasicInfoDao.search("from UserBasicInfo where delFlag="+UserBasicInfo.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
		} 
		
		//数据删除
		public boolean removeUserBasicInfo(String id) {
			userBasicInfoDao.executeHql("delete from UserBasicInfo where id = ?", new Object[] { id });
			Long qty = userBasicInfoDao.count("select count(id) from UserBasicInfo where id = ?" , new Object[] { id });
			if ( qty.intValue() == 0 ) return true;
			return false;
		}
		
		//数据删除（伪）
		public boolean removeUserBasicInfoFalse(String id) {
				Integer qty = userBasicInfoDao.executeHql("update  UserBasicInfo set delFlag= ? where id = ?", new Object[] { UserBasicInfo.REMOVED,id });
				if ( qty == 0 ) return false;
				return true;
		}
		
		//数据修改或保存
		public boolean saveUserBasicInfo(UserBasicInfo userBasicInfo) { 
			try {
				String id = userBasicInfo.getId();
	 			Long qty = userBasicInfoDao.count("select count(id) from UserBasicInfo where id=?", new Object[] {id}); 
	 			if (qty > 0) {    
	 				userBasicInfoDao.update(userBasicInfo);
				} else {  
					userBasicInfoDao.save(userBasicInfo);
				}
			} catch(Exception ex) { ex.printStackTrace(); return false; }
			return true; 
		}

		@Override
		public Long getUserBasicInfoQty(String queryParam) {
			StringBuffer hql=new StringBuffer();
			hql.append(" select count(id) from UserBasicInfo where 1=1  ");
			if(null != queryParam && !"".equals(queryParam) ){
				queryParam = "%" + queryParam + "%";
				hql.append(" and (name  like '" + queryParam +"' or major like '"+ queryParam + "' or techPost like '"+ queryParam +"')");
			}
			
			return userBasicInfoDao.count(hql.toString());
		}

		@Override
		public List<UserBasicInfo> getUserBasicInfos(String queryParam, int startIndex,
				int rows, String sorter, String sortingAttribute) {
			StringBuffer hql=new StringBuffer();
			hql.append("  from UserBasicInfo where 1=1  ");
			if(null != queryParam && !"".equals(queryParam) ){
				queryParam = "%" + queryParam + "%";
				hql.append(" and (name  like '" + queryParam +"' or major like '"+ queryParam + "' or techPost like '"+ queryParam +"')");
			}
			
			return userBasicInfoDao.search(hql.toString()+" and delFlag=" + Visitor.NORMAL + " order by " + sorter
					+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
		
		}

}
