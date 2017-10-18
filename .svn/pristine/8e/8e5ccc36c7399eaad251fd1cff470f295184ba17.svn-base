package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.AuthorityDto;
import org.pangolin.eeip.dto.AuthorityRootTypeDto;
import org.pangolin.eeip.dto.AuthorityTypeDto;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.AuthorityType;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.AuthorityTypeService;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.service.RoleAuthorityService;
import org.pangolin.eeip.service.RoleService;
import org.pangolin.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorityController extends BaseController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityTypeService authorityTypeService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private RoleAuthorityService roleAuthorityService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 权限数据列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.AUTH_MGT_LIST)
	public ModelAndView getAuthorityListMV() {
        return new ModelAndView("/pangolin/systemMgt/authorityMgt/authorityList");
    }
	
	/**
	 * 权限列表数据源
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 权限数据集JSON
	 * */
	@RequestMapping(NavConst.AUTH_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAuthorityListData(String roleId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<AuthorityRootTypeDto> authRootTypeDtoList = new ArrayList<AuthorityRootTypeDto>();
		List<AuthorityTypeDto> authSubTypeDtoList = null;
		List<AuthorityDto> authDtoList = null;
		
		List<AuthorityType> authorityRootTypeList = authorityTypeService.getRootAuthorityTypies();
		if ( authorityRootTypeList != null && authorityRootTypeList.size() > 0 ) {
			for ( AuthorityType rootType : authorityRootTypeList ) {
				//检测是否可使用模块
				if ( isAccessibleModule(rootType.getAuthorityTypeLabel()) ) {
					AuthorityRootTypeDto rootTypeDto = AuthorityRootTypeDto.convertToAuthorityTypeDto(rootType);
					
					authSubTypeDtoList = new ArrayList<AuthorityTypeDto>();
					List<AuthorityType> authoritySubTypeList = authorityTypeService.getAuthorityTypiesByParentAuthorityType(rootType.getAuthorityTypeId());
					if ( authoritySubTypeList != null && authoritySubTypeList.size() > 0 ) {
						for ( AuthorityType subType : authoritySubTypeList ) {
							AuthorityTypeDto subTypeDto = AuthorityTypeDto.convertToAuthorityTypeDto(subType);
							
							authDtoList = new ArrayList<AuthorityDto>();
							List<Authority> authorityList = authorityService.getAuthoritiesByType(subType.getAuthorityTypeId());
							for ( Authority authority : authorityList ) {
								AuthorityDto authDto = AuthorityDto.convertToAuthorityDto(authority, isChecked(roleId, authority.getAuthorityId()));
								authDtoList.add(authDto);
							}
							
							subTypeDto.setAuthorities(authDtoList);
							
							authSubTypeDtoList.add(subTypeDto);
						}
					}
					
					rootTypeDto.setSubTypeQty(authSubTypeDtoList.size());
					rootTypeDto.setSubTypies(authSubTypeDtoList);
					
					authRootTypeDtoList.add(rootTypeDto);
				}
			}
		}
		resultMap.put("authList", authRootTypeDtoList);
		return resultMap;
	}
	
	/**
	 * 保存角色权限
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @param authorityIds 权限ID集合
	 * */
	@RequestMapping(NavConst.AUTH_MGT_SAVE_ROLE_AUTH)
	@ResponseBody
	public Map<String, Object> saveRoleAuthority(String roleId, String authorityIds, String parentAuthLabels) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String[] authorityIdSet = StringUtil.separate2Array(authorityIds, ",");
		String[] parentAuthLabelSet = StringUtil.separate2Array(parentAuthLabels, ",");
		roleAuthorityService.saveRoleAuthority(roleId, authorityIdSet, parentAuthLabelSet);
		saveOperationLog(roleId);
		resultMap.put("status", true);
		reloadAuthorities(); //重载所有角色权限
		return resultMap;
	}
	
	/**
	 * 权限是否选定
	 * @author Oscar Mok
	 * @param roleId
	 * @param authorityId
	 * @return 选定状态
	 * */
	private boolean isChecked(String roleId, String authorityId) {
		if ( roleAuthorityService.existRoleAuthority(roleId, authorityId) ) return AuthorityDto.CHECKED;
		return AuthorityDto.UNCHECKED;
	}
	
	/**
	 * 重载所有角色权限（缓存）
	 * @author Oscar Mok
	 * */
	private void reloadAuthorities() {
		try {
			Const.ROLE_AUTH_MAP.clear();
			
			List<Authority> authorityList = null;
			List<Role> roleList = roleService.getRoles();
			if ( roleList != null && roleList.size() > 0 ) {
				for ( Role role : roleList ) {
					authorityList = authorityService.getAuthoritiesByRole(role.getRoleId());
					if ( authorityList != null && authorityList.size() > 0 ) {
						Const.ROLE_AUTH_MAP.put(role.getRoleLabel(), authorityList);
					}
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	/**
	 * 是否可使用模块
	 * @param moduleLabel 模块标识
	 * @return 可使用状态
	 * */
	private boolean isAccessibleModule(String moduleLabel) {
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) return true;
		if ( getCurrentUser().getVerModules() != null ) {
			if ( getCurrentUser().getVerModules().containsKey(moduleLabel) ) return true;
		}
		return false;
	}
	
	/**
	 * 保存操作日志
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * */
	private void saveOperationLog(String roleId) {
		if ( roleId != null && !roleId.trim().equals("") ) {
			Role role = roleService.getRoleById(roleId);
			if ( role != null ) {
				operationLogService.saveOperationLog(Const.MODULE_AUTH_MGT, 
						                             OperationLog.MODIFY, "Adjust authorities of role " + role.getRoleName() + " successfully", 
						                             getCurrentUser());
			}
		}
	}
}