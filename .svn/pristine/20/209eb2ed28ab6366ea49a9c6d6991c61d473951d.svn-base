package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.EvidOpLog;
import org.pangolin.eeip.service.EvidOpLogService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvidOpLogController extends BaseController {

	@Resource
	private EvidOpLogService evidOpLogService;
	
	/**
	 * 加载电子物证操作日志表（物证出入库记录） 
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定电子物证操作日志表（物证出入库记录） 数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDOPLOG_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> getEvidOpLogById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			EvidOpLog evidOpLog = evidOpLogService.getEvidOpLogById(id);
			resultMap.put("entity", ( evidOpLog != null ) ? evidOpLog : new EvidOpLog(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new EvidOpLog(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 保存电子物证信息表日志数据
	 * @author Xiaolin Yin
	 * @param Evidence 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDOPLOG_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveEvidOpLogData(@RequestBody EvidOpLog evidOpLog) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(evidOpLog!=null){
			status=evidOpLogService.saveEvidOpLog(evidOpLog);
		}  
		resultMap.put("status", status); 
		return resultMap;
	} 
	
	/**
	 * 加载电子物证操作日志表（物证出入库记录） 
	 * 首次和末次的进出库记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定电子物证操作日志表（物证出入库记录） 数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDOPLOG_DATA_BY_EVIDIDANDSPLABEL)
	@ResponseBody
	public Map<String, Object> getEvidOpLogByEvidIdAndSpLabel (String evidId,Integer spLabel) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( evidId != null && !evidId.trim().equals("")&&null != spLabel ) {
			EvidOpLog evidOpLog = evidOpLogService.getEvidOpLogByEvidIdAndSpLabel(evidId,spLabel);
			resultMap.put("entity", ( evidOpLog != null ) ? evidOpLog : new EvidOpLog(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new EvidOpLog(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	
	/**
	 * （物证出入库记录） 
	 * 首次和末次的进出库记录
	 * @author Xiaolin Yin
	 * @param evidId 电子物证ID 
	 * @param type 进出库类型
	 * @return 指定电子物证操作日志表（物证出入库记录） 数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDOPLOG_DATA_BY_EVIDIDANDTYPE)
	@ResponseBody
	public Map<String, Object> getEvidOpLogByEvidIdAndType (String evidId,Integer type) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( evidId != null && !evidId.trim().equals("")&&null != type ) {
			EvidOpLog evidOpLog = evidOpLogService.getEvidOpLogByEvidEvidIdAndType(evidId,type);
			resultMap.put("entity", ( evidOpLog != null ) ? evidOpLog : new EvidOpLog(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new EvidOpLog(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
}
