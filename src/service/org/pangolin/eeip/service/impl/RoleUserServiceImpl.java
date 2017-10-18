package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.RoleUserDao;
import org.pangolin.eeip.dto.RoleUserDto;
import org.pangolin.eeip.entity.RoleUser;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.service.RoleUserService;
import org.springframework.stereotype.Service;

@Service("roleUserService")
@SuppressWarnings("all")
public class RoleUserServiceImpl implements RoleUserService {

	@Resource
	private  RoleUserDao roleUserDao;
	
	public RoleUser getRoleUserById(String roleUserId) {
		return roleUserDao.get(RoleUser.class, roleUserId);
	}
	
	public List<RoleUser> getRoleUsers() {
		return roleUserDao.find("from RoleUser");
	}
	
	public List<RoleUserDto> getRoleUserDtos() {
		RoleUserDto roleUserDto = null;
		String roleId = null, roleName = null, roleLabel = null;
		String userId = null, userName = null, userAlias = null;
		
		List<RoleUserDto> roleUserDtoList = new ArrayList<RoleUserDto>();
		List resultList = roleUserDao.compSearch("select b.roleId, b.roleName, b.roleLabel, c.userId, c.userName, c.userAlias from RoleUser a, Role b, User c "
				+ "where a.roleId = b.roleId and a.userId = c.userId", new Object[] {  });
		if ( resultList != null && resultList.size() > 0 ) {
			for ( int i = 0; i < resultList.size(); i++ ) {
				Object[] objArray = (Object[])resultList.get(i);
				
				if (objArray[0] != null) roleId = (String)objArray[0];
				if (objArray[1] != null) roleName = (String)objArray[1];
				if (objArray[2] != null) roleLabel = (String)objArray[2];
				if (objArray[3] != null) userId = (String)objArray[3];
				if (objArray[4] != null) userName = (String)objArray[4];
				if (objArray[5] != null) userAlias = (String)objArray[5];
				
				roleUserDto = new RoleUserDto();
				roleUserDto.setRoleId(roleId);
				roleUserDto.setRoleName(roleName);
				roleUserDto.setRoleLabel(roleLabel);
				roleUserDto.setUserId(userId);
				roleUserDto.setUserName(userName);
				roleUserDto.setUserAlias(userAlias);
				roleUserDtoList.add(roleUserDto);
			}
		}
		return roleUserDtoList;
	}
	
	public List<RoleUser> getRoleUsersByRole(String roleId) {
		return roleUserDao.find("from RoleUser where roleId = ?", new Object[] { roleId });
	}
	
	public List<RoleUser> getRoleUsersByUser(String userId) {
		return roleUserDao.find("from RoleUser where userId = ?", new Object[] { userId });
	}
	
	public void removeRoleUser(String roleUserId) {
		roleUserDao.executeHql("delete from RoleUser where roleUserId = ?", new Object[] { roleUserId });
	}
	
	public void removeRoleUserByRole(String roleId) {
		roleUserDao.executeHql("delete from RoleUser where roleId = ?", new Object[] { roleId });
	}
	
	public void removeRoleUserByUser(String userId) {
		roleUserDao.executeHql("delete from RoleUser where userId = ?", new Object[] { userId });
	}
	
	public void saveRoleUser(RoleUser roleUser) {
		roleUserDao.saveOrUpdate(roleUser);
	}
	
	public boolean existRoleUser(String roleId, String userId) {
		List<RoleUser> roleUserList = roleUserDao.find("from RoleUser where roleId = ? and userId = ?", new Object[] { roleId, userId });
		if ( roleUserList != null && roleUserList.size() > 0 ) return true;
		return false;
	}
	
}