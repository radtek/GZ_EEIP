package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.AppraisalSitn;
import org.pangolin.eeip.service.AppraisalSitnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 鉴定情况 
 * @author Xiaolin Yin
 *
 */
@Controller
public class AppraisalSitnController extends BaseController {

	@Autowired
	private  AppraisalSitnService appraisalSitnService;
	
	/**
	 * 保存  鉴定情况 数据
	 * @param AppraisalSitn 鉴定情况
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.SPPRAISALSITN_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveSppraisalSitn(@RequestBody AppraisalSitn sitn) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		status = appraisalSitnService.saveAppraisalSitn(sitn);
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 删除鉴定人员 
	 * @param AppraisalSitn 鉴定情况
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.SPPRAISALSITN_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> saveSppraisalSitn(String appraisalId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		AppraisalSitn sitn = appraisalSitnService.getAppraisalSitnByAppraisalId(appraisalId);
		if(sitn != null){
			status = appraisalSitnService.removeAppraisalSitn(sitn.getId());
		}
		resultMap.put("entity", status);
		return resultMap;
	}
}
