package org.pangolin.eeip.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.EvidenceService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings("all")
public class EvidenceController extends BaseController {

	@Autowired
	private EvidenceService evidenceService;
	
	@Autowired
	private AppraisalService appraisalService;
	
	/**
	 * 加载电子物证信息表
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定电子物证信息表数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDENCE_DATA_BY_APPRAISALID)
	@ResponseBody
	public Map<String, Object> getEvidenceByAppraisalId(String appraisalId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( appraisalId != null && !appraisalId.trim().equals("") ) {
			Evidence evidence = evidenceService.getEvidenceByAppraisalId(appraisalId); 
			resultMap.put("entity", ( evidence != null ) ? evidence : new Evidence(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new Evidence(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 加载电子物证信息表
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定电子物证信息表数据JSON
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_GET_EVIDENCE_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> getEvidenceByEvidId(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			Evidence evidence = evidenceService.getEvidenceById(id);
			resultMap.put("entity", ( evidence != null ) ? evidence : new Evidence(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new Evidence(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 保存电子物证信息表数据
	 * @author Xiaolin Yin
	 * @param Evidence 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.APPRAISAL_MGT_EVIDENCE_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveEvidenceData(@RequestBody Evidence evidence) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(evidence!=null){
			status=evidenceService.saveEvidence(evidence);
		}  
		if(status){
			Appraisal appraisal = appraisalService.getAppraisalById(evidence.getAppraisalId());
			if(appraisal.getStatus().intValue() == Appraisal.WILL_STORAGE.intValue()){
				appraisal.setStatus(Appraisal.WAIT_FOR_DISTRIBUTION);
			} else if(appraisal.getStatus().intValue() == Appraisal.RESULT_FEEDBACK){
				appraisal.setStatus(Appraisal.FINISH);
			}
			
			if(appraisal.getStatus().intValue() == Appraisal.TERMINATION ){
				appraisal.setStatus(Appraisal.DOWN_DOC);	
			}
			appraisal.setEvidId(evidence.getId());
			status = appraisalService.saveAppraisal(appraisal);
		}
		resultMap.put("status", status); 
		return resultMap;
	}
	
	
	
}
