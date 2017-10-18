package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AuthorityType;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.Version;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.AuthorityTypeService;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 版本管理 Controller
 * @author Oscar Mok
 */
@Controller
@SuppressWarnings("all")
public class VersionController extends BaseController {
	
	@Autowired
	private VersionService versionService;
	
	@Autowired
	private AuthorityTypeService authorityTypeService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 版本信息列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_LIST)
	public ModelAndView getVersionListMV() {
        return new ModelAndView("/pangolin/assessibilityMgt/versionMgt/versionList");
    }
	
	/**
	 * 版本信息表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_FORM)
	public ModelAndView getVersionFormMV() {
        return new ModelAndView("/pangolin/assessibilityMgt/versionMgt/versionForm");
    }
	
	/**
	 * 版本列表数据源
	 * @author Oscar Mok
	 * @return 机构数据集JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getVersionListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<Version> versionList = new ArrayList<Version>();
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			totalCount = versionService.getVersionQty();
			versionList = versionService.getVersions(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		}
		return BootstrapDataGridUtil.getResultMap(params, totalCount, versionList);
	}
	
	/**
	 * 加载版本数据（用于更新）
	 * @author Oscar Mok
	 * @param id 版本ID
	 * @return 指定版本数据JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getVersionData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( id != null && !id.trim().equals("") ) {
			Version version = versionService.getVersionById(id);
			resultMap.put("entity", ( version != null ) ? version : new Version());
		} else resultMap.put("entity", new Version());
		return resultMap;
	}
	
	/**
	 * 保存版本数据
	 * @author Oscar Mok
	 * @param version 版本对象
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveVersion(@RequestBody Version version) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( version != null ) {
			Integer logType = getLogType(version);
			boolean status = versionService.saveVersion(version);
			if ( status ) {
				saveOperationLog(version, logType);
			}
			resultMap.put("status", status);
		}
		return resultMap;
	}
	
	/**
	 * 保存版本状态
	 * @author Oscar Mok
	 * @param id 版本ID
	 * @param status 版本状态
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_SAVE_STATUS_DATA)
	@ResponseBody
	public Map<String, Object> saveVersionStatus(String id, Integer status) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( id != null && !id.trim().equals("") && status != null ) {
			boolean situation = versionService.saveVersionStatus(id, status);
			resultMap.put("status", situation);
		}
		return resultMap;
	}
	
	/**
	 * 移除版本数据
	 * @author Oscar Mok
	 * @param id 版本ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeVersionData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) {
			Version version = versionService.getVersionById(id);
			if ( version != null ) {
				status = versionService.removeVersion(id);
				if ( status ) {
					saveOperationLog(version, OperationLog.REMOVE);
				}
			}
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 版本功能模块选项数据源
	 * @author Oscar Mok
	 * @return 版本功能模块集JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_MODULE_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getModuleOptionsData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AuthorityType> authorityTypeList = authorityTypeService.getRootAuthorityTypies();
		resultMap.put("entity", authorityTypeList);
		return resultMap;
	}
	
	/**
	 * 版本选项数据源
	 * @author Oscar Mok
	 * @return 版本选项数据集JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_VER_MGT_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getVersionOptionsData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Version> versionList = versionService.getVersionsByStatus(Version.ENABLE);
		resultMap.put("entity", versionList);
		return resultMap;
	}
	
	/**
	 * 判断新增或编辑类型
	 * @author Oscar Mok
	 * @param version 版本对象
	 * @return 日志类型
	 * */
	private Integer getLogType(Version version) {
		if ( version != null && version.getId() == null ) return OperationLog.ADD;
		else return OperationLog.MODIFY;
	}
	
	/**
	 * 保存操作日志
	 * @author Oscar Mok
	 * @param version 版本对象
	 * @param logType 日志类型
	 * */
	private void saveOperationLog(Version version, Integer logType) {
		if ( logType.intValue() == OperationLog.ADD.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_VER_MGT, 
					                             OperationLog.ADD, "Add version " + version.getName() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.MODIFY.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_VER_MGT, 
					                             OperationLog.MODIFY, "Modify version " + version.getName() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.REMOVE.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_VER_MGT, 
					                             OperationLog.REMOVE, "Remove version " + version.getName() + " successfully", 
					                             getCurrentUser());
		}
	}
}