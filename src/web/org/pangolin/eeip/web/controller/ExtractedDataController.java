package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.ExtractedData;
import org.pangolin.eeip.service.ExtractedDataItemService;
import org.pangolin.eeip.service.ExtractedDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtractedDataController extends BaseController{
	
	@Resource
	private ExtractedDataService extractedDataService;
	@Resource
	private ExtractedDataItemService extractedDataItemService;
	
	/***
	 * 保存提取电子数据清单表
	 * @param extractedData 提取电子数据清单对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EXTRACTEDDATA_SAVEEXTRACTEDDATADATA)
	@ResponseBody
	public Map<String, Object> saveExtractedData(@RequestBody ExtractedData extractedData){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			if(extractedData != null){
				String appraisalId = extractedData.getAppraisalId();
				ExtractedData oldExtracted = extractedDataService.getExtractedDataByAppraisalId(appraisalId);
				if(oldExtracted != null && !"".equals(oldExtracted.getId())){
					String oldExtractedDataId = oldExtracted.getId();
					extractedDataService.removeExtractedData(oldExtractedDataId);
					extractedDataItemService.removeExtractedDataItemByExtractedDataId(oldExtractedDataId);
				}
				status = extractedDataService.saveExtractedData(extractedData);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据ID查询  提取电子数据清单
	 * @param id 提取电子数据清单 ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EXTRACTEDDATA_LOADEXTRACTEDDATADATA)
	@ResponseBody
	public Map<String, Object> getExtractedDataDataById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			ExtractedData extractedData = null ;
			if(id != null && !"".equals(id)){
				extractedData = extractedDataService.getExtractedDataById(id);
			}
			extractedData = extractedData == null ? new ExtractedData() : extractedData;
			result.put("entity", extractedData);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ExtractedData());
		}
		return result;
	}
	
	/***
	 * 根据ID查询  提取电子数据清单
	 * @param id 提取电子数据清单 ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EXTRACTEDDATA_LOADEXTRACTEDDATABYAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getExtractedDataByappraisalId(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			ExtractedData extractedData = null ;
			if(id != null && !"".equals(id)){
				extractedData = extractedDataService.getExtractedDataByAppraisalId(id);
			}
			extractedData = extractedData == null ? new ExtractedData() : extractedData;
			result.put("entity", extractedData);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ExtractedData());
		}
		return result;
	}

}
