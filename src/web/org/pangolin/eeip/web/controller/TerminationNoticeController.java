package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalSitn;
import org.pangolin.eeip.entity.TerminationNotice;
import org.pangolin.eeip.entity.UserBasicInfo;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.AppraisalSitnService;
import org.pangolin.eeip.service.TerminationNoticeService;
import org.pangolin.eeip.service.UserBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TerminationNoticeController extends BaseController{
	
	@Resource
	private TerminationNoticeService terminationNoticeService;
	@Autowired
	private UserBasicInfoService userBasicInfoService;
	@Autowired
	private AppraisalService appraisalService;
	
	@Resource
	private AppraisalSitnService appraisalSitnService;
	
	/***
	 * 保存设备期间核查情况记录表 
	 * @param terminationNotice 设备期间核查情况记录对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_TERMINATIONNOTICE_SAVETERMINATIONNOTICEDATA)
	@ResponseBody
	public Map<String, Object> saveTerminationNotice(@RequestBody TerminationNotice terminationNotice){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			Appraisal appraisal = appraisalService.getAppraisalById(terminationNotice.getAppraisalId());
			
			/*AppraisalSitn sitn =appraisalSitnService.getAppraisalSitnByAppraisalId(appraisal.getId());
			if(sitn != null){
				status = appraisalSitnService.removeAppraisalSitn(sitn.getId());
			}*/
		/*	//空出鉴定专家
			UserBasicInfo basicInfo = userBasicInfoService.getUserBasicInfoByUserId(appraisal.getAppraiserId());
			basicInfo.setAppraisalFlag(UserBasicInfo.NOT_ASSIGNED);
			status = userBasicInfoService.saveUserBasicInfo(basicInfo);*/
			
			status = terminationNoticeService.saveTerminationNotice(terminationNotice);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据设备期间核查情况记录ID获取设备期间核查情况记录信息
	 * @param id 设备期间核查情况记录ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_TERMINATIONNOTICE_LOADTERMINATIONNOTICEDATA)
	@ResponseBody
	public Map<String, Object> getTerminationNoticeDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			TerminationNotice terminationNotice = terminationNoticeService.getTerminationNoticeById(id);
			terminationNotice = terminationNotice == null ? new TerminationNotice() : terminationNotice;
			result.put("entity", terminationNotice);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new TerminationNotice());
		}
	
		return result;
	}
}
