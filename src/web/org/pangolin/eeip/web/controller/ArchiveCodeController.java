package org.pangolin.eeip.web.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.ArchiveCode;
import org.pangolin.eeip.service.ArchiveCodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArchiveCodeController extends BaseController {

	@Resource
	private ArchiveCodeService archiveCodeService;
	
	/***
	 * 根据文号 ID 获取文号
	 * @param id 文号ID
	 * @return
	 */
	@RequestMapping(NavConst.ARCHIVECODE_MGT_GET_DATA_BY_ID)
	@ResponseBody
	public Map<String, Object> getArchiveCodeById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			ArchiveCode archiveCode = archiveCodeService.getArchiveCodeById(id); 
			archiveCode = archiveCode == null ? new ArchiveCode() : archiveCode;
			result.put("entity", archiveCode);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ArchiveCode());
		}
		return result;
	}
	
	/***
	 * 保存 文号
	 * @param ArchiveCode 文号
	 * @return
	 */
	@RequestMapping(NavConst.ARCHIVECODE_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAppraisal(@RequestBody ArchiveCode archiveCode){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{ 
			status = archiveCodeService.saveArchiveCode(archiveCode);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 生成  ArchiveCode 集合 通过 年号和机关代字
	 * @param id 文号ID
	 * @return
	 */
	@RequestMapping(NavConst.ARCHIVECODE_MGT_GET_DATA_BY_AGECYANDYEAR)
	@ResponseBody
	public Map<String, Object> getArchiveCodeById(String appraisalId, String agency, String year){
		Map<String, Object> result = new HashMap<String, Object>();
		List<ArchiveCode> reusltList = new ArrayList<ArchiveCode>();
		DecimalFormat df = new DecimalFormat("0000");
		ArchiveCode archiveCode = null ;
		if(agency.equals("1")){
			agency = "穗公网鉴"; 
		}else if(agency.equals("2")){
			agency = "中止";
		}
		try{
			reusltList = archiveCodeService.getArchiveCodesByAgencyAndYear(agency, year); 
			if( reusltList.size() > 0 ){
			    archiveCode = reusltList.get(0); 
				archiveCode.setCreatedDate(new Date());
				Integer sn = Integer.valueOf(archiveCode.getSn())+1;
				archiveCode.setSn(df.format(sn));
				archiveCode.setAppraisalId(appraisalId);
				archiveCode.setId(null);
				archiveCodeService.saveArchiveCode(archiveCode);
 			}else{
 				archiveCode =new ArchiveCode();
 				archiveCode.setSn(df.format(1));
				archiveCode.setAppraisalId(appraisalId);
 				archiveCode.setAgency(agency);
				archiveCode.setYear(year);
				archiveCodeService.saveArchiveCode(archiveCode);
 			}
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ArchiveCode() );
		}
		result.put("entity", archiveCode);
		return result;
	}
	
	
}
