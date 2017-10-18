package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.OrgDto;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.service.OrganizationService;
import org.pangolin.eeip.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 角色
 * @author liaoqi
 *
 */
@Controller
public class RoleController extends BaseController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 角色数据列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ROLE_MGT_LIST)
	public ModelAndView getRoleListMV() {
        return new ModelAndView("/pangolin/systemMgt/roleMgt/roleList");
    }
	
	/**
	 * 角色表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ROLE_MGT_FORM)
	public ModelAndView getRoleFormMV() {
        return new ModelAndView("/pangolin/systemMgt/roleMgt/roleForm");
	}
	
	/**
	 * 角色列表数据源
	 * @author Oscar Mok
	 * @return 角色数据集JSON
	 * */
	@RequestMapping(NavConst.ROLE_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getRoleListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String orgId = params.getExtraParam("orgId");
		if ( orgId != null && !orgId.trim().equals("") ) {
			long totalCount = roleService.getRoleQtyByOrg(orgId);
			List<Role> roleList = 
					roleService.getRolesByOrg(orgId, params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
			return BootstrapDataGridUtil.getResultMap(params, totalCount, roleList);
		} else {
			if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
				long totalCount = roleService.getRootRoleQty();
				List<Role> roleList = 
						roleService.getRootRoles(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				return BootstrapDataGridUtil.getResultMap(params, totalCount, roleList);
			} else {
				long totalCount = roleService.getRoleQtyByOrg(getOrgIdByCurrentUser());
				List<Role> roleList = 
						roleService.getRolesByOrg(getOrgIdByCurrentUser(), 
								                                 params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
				return BootstrapDataGridUtil.getResultMap(params, totalCount, roleList);
			}
		}
	}
	
	/**
	 * 机构树数据源
	 * @author Oscar Mok
	 * @return 机构数据集JSON
	 * */
	@RequestMapping(NavConst.ROLE_MGT_ORG_TREE_GRID_DATA)
	@ResponseBody
	public Map<String, Object> getOrgTreeGridData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<OrgDto> orgList = new ArrayList<OrgDto>();
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			orgList =  organizationService.getAllUserOrganizationTreeGridData();
		} else {
			orgList = organizationService.getChildOrganizationTreeGridData(getOrgIdByCurrentUser());
		}
		resultMap.put("data", orgList);
		return resultMap;
	}
	
	/**
	 * 角色下拉选项数据源
	 * @author Oscar Mok
	 * @return 角色数据集JSON
	 * */
	@RequestMapping(NavConst.ROLE_MGT_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getRoleOptionsData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			List<Role> roleList = roleService.getRootRoles(Role.ENABLE);
			if ( roleList != null && roleList.size() > 0 ) {
				resultMap.put("entity", roleList);
			}
		} else {
			List<Role> roleList = roleService.getRolesByOrg(getOrgIdByCurrentUser(), Role.ENABLE);
			if ( roleList != null && roleList.size() > 0 ) {
				resultMap.put("entity", roleList);
			}
		}
		return resultMap;
	}
	
	/**
	 * 移除角色数据
	 * @author Oscar Mok
	 * @param roleId 角色ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.ROLE_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeRoleData(String roleId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( roleId != null && !roleId.trim().equals("") ) {
			Role role = roleService.getRoleById(roleId);
			if ( role != null ) {
				status = roleService.setRoleDelFlag(roleId, Role.REMOVED);
				if ( status ) {
					saveOperationLog(role, OperationLog.REMOVE);
				}
			}
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 加载角色数据（用于更新）
	 * @author Oscar Mok
	 * @param roleId 用户ID
	 * @return 指定角色数据JSON
	 * */
	@RequestMapping(NavConst.ROLE_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getRoleData(String roleId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( roleId != null && !roleId.trim().equals("") ) {
			Role role = roleService.getRoleById(roleId);
			resultMap.put("entity", ( role != null ) ? role : new Role());
		} else resultMap.put("entity", new Role());
		return resultMap;
	}
	
	/**
	 * 保存角色数据
	 * @author Oscar Mok
	 * @param role 角色对象
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.ROLE_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveRole(@RequestBody Role role) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( role != null ) {
			if ( role.getOrgId() != null 
					&& role.getOrgId().trim().equals("") ) role.setOrgId(null);
			Integer logType = getLogType(role);
			
			boolean status = roleService.saveRole(role);
			if ( status ) {
				saveOperationLog(role, logType);
			}
			resultMap.put("status", status);
		}
		return resultMap;
	}
	
	/**
	 * 判断新增或编辑类型
	 * @author Oscar Mok
	 * @param role 角色对象
	 * @return 日志类型
	 * */
	private Integer getLogType(Role role) {
		if ( role != null && role.getRoleId() == null ) return OperationLog.ADD;
		else return OperationLog.MODIFY;
	}
	
	/**
	 * 保存操作日志
	 * @author Oscar Mok
	 * @param role 角色对象
	 * @param logType 日志类型
	 * */
	private void saveOperationLog(Role role, Integer logType) {
		if ( logType.intValue() == OperationLog.ADD.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_ROLE_MGT, 
					                             OperationLog.ADD, "Add role " + role.getRoleName() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.MODIFY.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_ROLE_MGT, 
					                             OperationLog.MODIFY, "Modify role " + role.getRoleName() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.REMOVE.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_ROLE_MGT, 
					                             OperationLog.REMOVE, "Remove role " + role.getRoleName() + " successfully", 
					                             getCurrentUser());
		}
	}
}