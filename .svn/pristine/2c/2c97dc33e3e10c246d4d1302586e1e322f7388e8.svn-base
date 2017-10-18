package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserCertificateDao;
import org.pangolin.eeip.entity.UserCertificate;
import org.pangolin.eeip.entity.UserTrainingAtt;
import org.pangolin.eeip.service.UserCertificateService;
import org.springframework.stereotype.Service;

@Service("userCertificateService")
@SuppressWarnings("all")
public class UserCertificateServiceImpl implements UserCertificateService {

  @Resource
  private  UserCertificateDao  userCertificateDao;
	
  //根据ID查询
 	public UserCertificate getUserCertificateById(String id) {
 		return userCertificateDao.get(UserCertificate.class, id);
 	}
 	
 	//获取总数量
 	public Long getUserCertificateQty() {
 		return userCertificateDao.count("select count(id) from UserCertificate where delFlag="+UserCertificate.NORMAL);
 	} 
 	
 	//获取总集合
 	public List<UserCertificate> getUserCertificates() {
 		return userCertificateDao.find("from UserCertificate where delFlag="+UserCertificate.NORMAL+" order by createdDate desc");
 	}
 	
 	@Override
	public List<UserCertificate> getUserCertificatesByUserId(String userBasicInfoId) {
 		return userCertificateDao.find(" from UserCertificate where delFlag=? and userBasicInfoId=? order by createdDate desc", new Object[]{UserCertificate.NORMAL,userBasicInfoId});
	} 
 	
 	//分页查询
 	public List<UserCertificate> getUserCertificates(int startIndex, int rows, String sorter, String sortingAttribute) {
 		return userCertificateDao.search("from UserCertificate where delFlag="+UserCertificate.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
 	} 
 	
 	//数据删除
 	public boolean removeUserCertificate(String id) {
 		userCertificateDao.executeHql("delete from UserCertificate where id = ?", new Object[] { id });
 		Long qty = userCertificateDao.count("select count(id) from UserCertificate where id = ?" , new Object[] { id });
 		if ( qty.intValue() == 0 ) return true;
 		return false;
 	}
 	
 	//数据删除（伪）
 	public boolean removeUserCertificateFalse(String id) {
 			Integer qty = userCertificateDao.executeHql("update  UserCertificate set delFlag= ? where id = ?", new Object[] { UserCertificate.REMOVED,id });
 			if ( qty == 0 ) return false;
 			return true;
 	}
 	
 	//数据修改或保存
 	public boolean saveUserCertificate(UserCertificate userCertificate) {
 		String method = "";
 		if ( userCertificate.getId() == null ) { method = "add"; }
 		else { 
 			method = "update";
  		}
 		userCertificateDao.saveOrUpdate(userCertificate);
 		if ( method.equals("add") ) {
 			if ( userCertificate.getId() != null ) return true;
 		} else { return true; }
 		return false;
 	}

	
}
