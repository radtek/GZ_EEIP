package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalItem;
import org.pangolin.eeip.service.AppraisalItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppraisalItemController extends BaseController {

	@Resource
	private AppraisalItemService appraisalItemService;
	
	/***
	 * 根据电子物证（检材）鉴定设备ID获取电子物证（检材）鉴定设备信息
	 * @param id 电子物证（检材）鉴定设备ID
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISALITEM_MGT_GET_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> getAppraisalItemById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			AppraisalItem appraisalItem=  appraisalItemService.getAppraisalItemById(id);
			appraisalItem = appraisalItem == null ? new AppraisalItem() : appraisalItem;
			result.put("entity", appraisalItem);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisalItem());
		}
		return result;
	}
	
	/***
	 * 保存电子物证（检材）鉴定申请表
	 * @param appraisal 电子物证（检材）鉴定申请对象
	 * @return
	 */
	@RequestMapping(NavConst.APPRAISALITEM_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAppraisalItem(@RequestBody AppraisalItem appraisalItem){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{ 
			status = appraisalItemService.saveAppraisalItem(appraisalItem);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	
}
