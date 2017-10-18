package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalHistory;
import org.pangolin.eeip.entity.AppraisalSitn;
import org.pangolin.eeip.service.AppraisalDocService;
import org.pangolin.eeip.service.AppraisalHistoryService;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.AppraisalSitnService;
import org.pangolin.eeip.service.AppraisedDevService;
import org.pangolin.eeip.service.UserBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppraisalHistoryController extends BaseController{
	
	@Resource
	private AppraisalHistoryService appraisalHistoryService;
	@Resource
	private AppraisedDevService appraisedDevService;
	@Resource
	private AppraisalDocService appraisalDocService;
	@Resource
	private AppraisalService appraisalService;
	@Autowired
	private UserBasicInfoService userBasicInfoService;
	@Autowired
	private AppraisalSitnService appraisalSitnService;
	
	/***
	 * 保存电子物证（检材）鉴定设备表
	 * @param appraisalHistory 电子物证（检材）鉴定设备对象
	 * @return
	 */
	@SuppressWarnings({ "static-access", "unused" })
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALHISTORY_SAVEAPPRAISALHISTORYDATA)
	@ResponseBody
	public Map<String, Object> saveAppraisalHistory(@RequestBody AppraisalHistory appraisalHistory,String appraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			Appraisal appraisal = appraisalService.getAppraisalById(appraisalId);
			//保存原始记录
			appraisalHistory = appraisalHistoryService.saveAppraisalToHistory(appraisalHistory,appraisalId);
			
			//把电子物证（检材）鉴定设备 全部根据appraisalId未删除然后添加appraisalHistory的id
			appraisedDevService.saveAppraisedDevByHistory(appraisalHistory.getId(),appraisalId);
			
			//鉴定文书资料 暂停过程中需要进行伪删除的文档编号有 4、5、6、7、8
			appraisalDocService.removeAppraisalDocByHistory(appraisalHistory.getId(),appraisalId);
			
			status = appraisalHistoryService.saveAppraisalHistory(appraisalHistory);
			
			//空出鉴定专家
			AppraisalSitn sitn =appraisalSitnService.getAppraisalSitnByAppraisalId(appraisal.getId());
			if(sitn != null){
				status = appraisalSitnService.removeAppraisalSitn(sitn.getId());
			}
			/*UserBasicInfo basicInfo = userBasicInfoService.getUserBasicInfoByUserId(appraisal.getAppraiserId());
			basicInfo.setAppraisalFlag(UserBasicInfo.NOT_ASSIGNED);
			status = userBasicInfoService.saveUserBasicInfo(basicInfo);*/
			
			if(status){
				if(appraisal != null){
					appraisal = appraisal.cleanAppraisalParam(appraisal);
					appraisalService.saveAppraisal(appraisal);
				}else{
					status = false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据电子物证（检材）鉴定设备ID获取电子物证（检材）鉴定设备信息
	 * @param id 电子物证（检材）鉴定设备ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_APPRAISALHISTORY_LOADAPPRAISALHISTORYDATA)
	@ResponseBody
	public Map<String, Object> getAppraisalHistoryDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			AppraisalHistory appraisalHistory = appraisalHistoryService.getAppraisalHistoryById(id);
			appraisalHistory = appraisalHistory == null ? new AppraisalHistory() : appraisalHistory;
			result.put("entity", appraisalHistory);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new AppraisalHistory());
		}
	
		return result;
	}
}
