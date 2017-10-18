package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AccessLog;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.SystemLog;
import org.pangolin.eeip.service.AccessLogService;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogController extends BaseController {
	
	@Autowired
	private AccessLogService accessLogService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	@Autowired
	private SystemLogService systemLogService;
	
	/**
	 * 访问日志列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESS_LOG_MGT_LIST)
	public ModelAndView getAccessLogListMV() {
        return new ModelAndView("/pangolin/systemMgt/logMgt/accessLogMgt/accessLogList");
    }
	
	/**
	 * 操作日志列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.OPERATION_LOG_MGT_LIST)
	public ModelAndView getOperationLogListMV() {
        return new ModelAndView("/pangolin/systemMgt/logMgt/operationLogMgt/operationLogList");
    }
	
	/**
	 * 系统日志列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_LOG_MGT_LIST)
	public ModelAndView getSystemLogListMV() {
        return new ModelAndView("/pangolin/systemMgt/logMgt/systemLogMgt/systemLogList");
    }
	
	/**
	 * 访问日志列表数据源
	 * @author Oscar Mok
	 * @return 访问日志数据集JSON
	 * */
	@RequestMapping(NavConst.ACCESS_LOG_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAccessLogListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<AccessLog> accessLogList = new ArrayList<AccessLog>();
		
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			totalCount = accessLogService.getAccessLogQty();
			accessLogList = accessLogService.getAccessLogs(params.getStart(), params.getLimit(), 
					                                       params.getSorter(), params.getSorterDirection());
		} else {
			totalCount = accessLogService.getAccessLogQtyByOrg(getOrgIdByCurrentUser());
			accessLogList = accessLogService.getAccessLogsByOrg(getOrgIdByCurrentUser(), 
					                                            params.getStart(), params.getLimit(), 
					                                            params.getSorter(), params.getSorterDirection());
		}
		return BootstrapDataGridUtil.getResultMap(params, totalCount, accessLogList);
	}
	
	/**
	 * 操作日志列表数据源
	 * @author Oscar Mok
	 * @return 操作日志数据集JSON
	 * */
	@RequestMapping(NavConst.OPERATION_LOG_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getOperationLogListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<OperationLog> operationLogList = new ArrayList<OperationLog>();
		
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			totalCount = operationLogService.getOperationLogQty();
			operationLogList = 
					operationLogService.getOperationLogs(params.getStart(), params.getLimit(), 
							                             params.getSorter(), params.getSorterDirection());
		} else {
			totalCount = operationLogService.getOperationLogQtyByOrg(getOrgIdByCurrentUser());
			operationLogList = 
					operationLogService.getOperationLogsByOrg(getOrgIdByCurrentUser(),
							                                  params.getStart(), params.getLimit(), 
							                                  params.getSorter(), params.getSorterDirection());
		}
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, operationLogList);
	}
	
	/**
	 * 系统日志列表数据源
	 * @author Oscar Mok
	 * @return 系统日志数据集JSON
	 * */
	@RequestMapping(NavConst.SYS_LOG_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getSystemLogListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<SystemLog> systemLogList = new ArrayList<SystemLog>();
		
		if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
			totalCount = systemLogService.getSystemLogQty();
			systemLogList = systemLogService.getSystemLogs(params.getStart(), params.getLimit(), 
					                                       params.getSorter(), params.getSorterDirection());
		} else {
			//TODO
		}
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, systemLogList);
	}
	
	/**
	 * 移除所有日志数据
	 * @author Oscar Mok
	 * @param logType 日志类型（0：访问日志；1：操作日志；2：系统日志）
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.SYS_LOG_MGT_REMOVE_ALL_DATA)
	@ResponseBody
	public Map<String, Object> removeAllLogData(Integer logType) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( logType != null ) {
			boolean status = false;
			if ( logType.intValue() == 0 ) {
				if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
					status = accessLogService.removeAllAccessLog();
				} else {
					status = accessLogService.removeAllAccessLogByOrg(getOrgIdByCurrentUser());
				}
			}
			if ( logType.intValue() == 1 ) {
				if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
					status = operationLogService.removeAllOperationLog();
				} else {
					status = operationLogService.removeAllOperationLogByOrg(getOrgIdByCurrentUser());
				}
			}
			if ( logType.intValue() == 2 ) {
				if ( getRoleLabelByCurrentUser().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
					status = systemLogService.removeAllSystemLog();
				} else {
					//TODO
				}
			}
			resultMap.put("status", status);
		}
		return resultMap;
	}
	
	/***
	 * 移除日志数据
	 * @param id 日志ID
	 * @param logType 日志类型（0：访问日志，1：操作日志；2：系统日志）
	 * @author zhutinggui
	 * @return
	 */
	@RequestMapping(NavConst.SYS_LOG_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String,Object> removeLogData(String id,Integer logType){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if( logType != null){
			boolean status = false;
			if(  logType.intValue() == 0 ) status = accessLogService.removeAccessLog(id);
			if ( logType.intValue() == 1 ) status = operationLogService.removeOperationLog(id);
			if ( logType.intValue() == 2 ) status = systemLogService.removeSystemLog(id);
			resultMap.put("status", status);
		}
		return resultMap;
	}
}