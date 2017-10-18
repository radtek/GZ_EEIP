package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.DismissalNotice;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.service.DismissalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DismissalNoticeController extends BaseController {

	@Autowired
	private DismissalNoticeService dismissalNoticeService;
	
	/**
	 * 加载不受理鉴定委托告知书表
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定不受理鉴定委托告知书JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_DISMISSALNOTICE_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> getDismissalNoticeById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			DismissalNotice dismissalNotice = dismissalNoticeService.getDismissalNoticeById(id);
			resultMap.put("entity", ( dismissalNotice != null ) ? dismissalNotice : new DismissalNotice());
		} else{ 
			resultMap.put("entity", new DismissalNotice());
		}
		return resultMap;
	}
	
	/**
	 * 保存不受理鉴定委托告知书表数据
	 * @author Xiaolin Yin
	 * @param DismissalNotice 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_DISMISSALNOTICE_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveDismissalNoticeData(@RequestBody DismissalNotice dismissalNotice) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(dismissalNotice != null){
			status= dismissalNoticeService.saveDismissalNotice(dismissalNotice);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	
}
