package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.UserDao;
import org.pangolin.eeip.dao.UserDetailDao;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;
import org.pangolin.eeip.service.UserDetailService;
import org.pangolin.validator.ChinaIDCardValidator;
import org.pangolin.validator.HKIDCardValidator;
import org.pangolin.validator.StringValidator;
import org.springframework.stereotype.Service;

@Service("userDetailService")
@SuppressWarnings("all")
public class UserDetailServiceImpl implements UserDetailService {

	@Resource
	private UserDetailDao userDetailDao;
	
	@Resource
	private UserDao userDao;
	
	public UserDetail getUserDetailById(String userDetailId) {
		return userDetailDao.get(UserDetail.class, userDetailId);
	}
	
	public UserDetail getUserDetailByUser(String userId) {
		List<UserDetail> userDetailList = userDetailDao.find("from UserDetail where userId = ?", new Object[] { userId });
		if ( userDetailList != null && userDetailList.size() > 0 ) {
			return userDetailList.get(0);
		}
		return null;
	}
	
	public void removeUserDetail(String userDetailId) {
		userDetailDao.executeHql("delete from UserDetail where userDetailId = ?", new Object[] { userDetailId });
	}
	
	public void removeUserDetailByUser(String userId) {
		userDetailDao.executeHql("delete from UserDetail where userId = ?", new Object[] { userId });
	}
	
	public boolean saveUserDetail(UserDetail userDetail) {
		String method = "";
		if ( userDetail.getUserDetailId() == null ) { method = "add"; }
		else { method = "update"; }
		userDetailDao.saveOrUpdate(userDetail);
		if ( method.equals("add") ) {
			if ( userDetail.getUserDetailId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean validateUserDetail(UserDetail userDetail) {
		boolean status = true;
		
		if ( userDetail != null ) {
			//验证用户身份证号格式
			if ( userDetail.getUserIdCard() != null 
					&& !userDetail.getUserIdCard().trim().equals("") ) {
				status = ( ChinaIDCardValidator.validate(userDetail.getUserIdCard()) || HKIDCardValidator.validate(userDetail.getUserIdCard()) );
				if (!status) return status;
			}
			
			//验证用户电子邮箱格式
			if ( userDetail.getUserEmail() != null 
					&& !userDetail.getUserEmail().trim().equals("") ) {
				status = ( StringValidator.isValidSimpleEmailAddress(userDetail.getUserEmail()) 
						|| StringValidator.isValidStrictEmailAddress(userDetail.getUserEmail()) );
				if (!status) return status;
			}
			
			//验证用户手机格式
			if ( userDetail.getUserCellphone() != null 
					&& !userDetail.getUserCellphone().trim().equals("") ) {
				status = StringValidator.isValidCellphoneNumber(userDetail.getUserCellphone());
				if (!status) return status;
			}
			
			//验证用户固定电话格式
			if ( userDetail.getUserTelephone() != null 
					&& !userDetail.getUserTelephone().trim().equals("") ) {
				status = StringValidator.isValidFixedPhone(userDetail.getUserTelephone());
				if (!status) return status;
			}
			
			//验证用户传真电话格式
			if ( userDetail.getUserFax() != null 
					&& !userDetail.getUserFax().trim().equals("") ) {
				status = StringValidator.isValidFixedPhone(userDetail.getUserFax());
				if (!status) return status;
			}
			
			//验证用户地址格式
			if ( userDetail.getUserAddress() != null 
					&& !userDetail.getUserAddress().trim().equals("") ) {
				status = (StringValidator.isSpecialCharacter(userDetail.getUserAddress()))? false : true;
				if (!status) return status;
			}
		}
		
		return status;
	}

	@Override
	public UserDetail getUserDetailByPoliceId(String policeId) {
		UserDetail userDetail = null;
		List<UserDetail> userDetailList = userDetailDao.find("from UserDetail where policeId = ?", new Object[] { policeId });
		if ( userDetailList != null && userDetailList.size() > 0 ) {
			for (int i = 0; i < userDetailList.size(); i++) {
				User user = userDao.get(" from User where  userId = ? and deleteFlag = ?", new Object[]{userDetailList.get(i).getUserId(),User.NORMAL});
				if(user != null){
					userDetail = userDetailList.get(i);
				}
			}
			return userDetail;
		}
		return null;
	}
}