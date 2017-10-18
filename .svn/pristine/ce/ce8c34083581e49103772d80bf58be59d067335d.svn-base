package org.pangolin.eeip.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.CriminalFilingQtyDto;
import org.pangolin.eeip.dto.RatioStatisticsDto;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.CriminalFilingQty;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.CountyService;
import org.pangolin.eeip.service.CriminalFilingQtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CriminalFilingQtyController extends BaseController{

	@Resource
	private CriminalFilingQtyService criminalFilingQtyService;
	
	@Resource
	private AppraisalService appraisalService;
	
	@Resource
	private CountyService countyService;
 
	/***
	 * 根据刑事案件立案数 年份 和 月份 获取集合
	 * @param year 年份   month 月份
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getCriminalFilingQtyList(String year,String month) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<CriminalFilingQty> resultList = new ArrayList<CriminalFilingQty>();
		CriminalFilingQtyDto dto = new CriminalFilingQtyDto();
		try {
			resultList = criminalFilingQtyService.getCriminalFilingQtys(year,month);
			for (CriminalFilingQty cf : resultList) {
				if(cf.getCountry().equals("440100")){
					dto.setAll(cf.getFilingQty());
				}else if(cf.getCountry().equals("440103")){
					dto.setLiwan(cf.getFilingQty());
				}else if(cf.getCountry().equals("440104")){
					dto.setYuexiu(cf.getFilingQty());
				}else if(cf.getCountry().equals("440105")){
					dto.setHaizhu(cf.getFilingQty());
				}else if(cf.getCountry().equals("440106")){
					dto.setTianhe(cf.getFilingQty());
				}else if(cf.getCountry().equals("440115")){
					dto.setNansha(cf.getFilingQty());
				}else if(cf.getCountry().equals("440111")){
					dto.setBaiyun(cf.getFilingQty());
				}else if(cf.getCountry().equals("440112")){
					dto.setHuangpu(cf.getFilingQty());
				}else if(cf.getCountry().equals("440113")){
					dto.setPanyu(cf.getFilingQty());
				}else if(cf.getCountry().equals("440114")){
					dto.setHuadu(cf.getFilingQty());
				}else if(cf.getCountry().equals("440118")){
					dto.setZengcheng(cf.getFilingQty());
				}else if(cf.getCountry().equals("440117")){
					dto.setConghua(cf.getFilingQty());
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("entity", dto);
		return resultMap;
	} 
	
	/***
	 * 保存根据刑事案件立案数
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_SAVE_LIST_DATA)
	@ResponseBody
	public Map<String, Object> saveCriminalFilingQtyList(@RequestBody  CriminalFilingQtyDto criminalFilingQtyDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		CriminalFilingQty  cfq = new CriminalFilingQty();
		cfq.setMonth(criminalFilingQtyDto.getMonth());
		cfq.setYear(criminalFilingQtyDto.getYear());
		cfq.setCreatorId(criminalFilingQtyDto.getCreatorId());
		cfq.setCreatorAlias(criminalFilingQtyDto.getCreatorAlias());
		try {
			cfq.setId(null);
			cfq.setFilingQty((criminalFilingQtyDto.getAll() != null) ? criminalFilingQtyDto.getAll() : new Integer(0));
			cfq.setCountry("440100");
			status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getLiwan() != null) ? criminalFilingQtyDto.getLiwan() : new Integer(0));
				cfq.setCountry("440103");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getYuexiu() != null) ? criminalFilingQtyDto.getYuexiu() : new Integer(0));
				cfq.setCountry("440104");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getTianhe() != null) ? criminalFilingQtyDto.getTianhe() : new Integer(0));
				cfq.setCountry("440106");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getHaizhu() != null) ? criminalFilingQtyDto.getHaizhu() : new Integer(0));
				cfq.setCountry("440105");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty((criminalFilingQtyDto.getHuangpu() != null) ? criminalFilingQtyDto.getHuangpu()
						: new Integer(0));
				cfq.setCountry("440112");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getBaiyun() != null) ? criminalFilingQtyDto.getBaiyun() : new Integer(0));
				cfq.setCountry("440111");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getPanyu() != null) ? criminalFilingQtyDto.getPanyu() : new Integer(0));
				cfq.setCountry("440113");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getNansha() != null) ? criminalFilingQtyDto.getNansha() : new Integer(0));
				cfq.setCountry("440115");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty(
						(criminalFilingQtyDto.getHuadu() != null) ? criminalFilingQtyDto.getHuadu() : new Integer(0));
				cfq.setCountry("440114");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty((criminalFilingQtyDto.getZengcheng() != null) ? criminalFilingQtyDto.getZengcheng()
						: new Integer(0));
				cfq.setCountry("440118");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}
			if (status) {
				cfq.setId(null);
				cfq.setFilingQty((criminalFilingQtyDto.getConghua() != null) ? criminalFilingQtyDto.getConghua()
						: new Integer(0));
				cfq.setCountry("440117");
				status = criminalFilingQtyService.saveCriminalFilingQtyByYearAndMonth(cfq);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	
	/***
	 * 根据刑事案件立案数 年份 和 月份 获取集合
	 * @param year 年份   month 月份
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_RATIO_YEAR_DATA)
	@ResponseBody
	public Map<String, List<String>> getHistoryCriminalFiling() {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		List<String> date = new ArrayList<String>();
		List<String> qty = new ArrayList<String>();
 		try {
 			Map<String, List<String>> cf = criminalFilingQtyService.getYearHistoryCFQty(null);
 			List<String> dateList = cf.get("date");
 			List<String> sumList = cf.get("number");
 		    if(dateList != null && dateList.size() > 0){
 		    	for (int i = 0; i < dateList.size() ; i++) {
					String year = dateList.get(i);
					Long appQty = appraisalService.getYearHistoryAppraisal(year);
					Double ratio = (double) (appQty/ Double.valueOf(sumList.get(i)))*100;
					DecimalFormat    df   = new DecimalFormat("######0.00"); 
					qty.add(df.format(ratio));
					date.add(year);
				} 
 		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
 		resultMap.put("date", date); 
 		resultMap.put("qty", qty); 
		return resultMap;
	} 
	
	/***
	 * 根据刑事案件立案数 年份 和 月份 获取集合
	 * @param year 年份   month 月份
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_RATIO_MONTH_DATA)
	@ResponseBody
	public Map<String, List<String>> getMonthCriminalFiling(String year) {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		List<String> date = new ArrayList<String>();
		List<String> qty = new ArrayList<String>();
 		try {
 			Map<String, List<String>> cf = criminalFilingQtyService.getYearHistoryCFQty(year);
 			List<String> dateList = cf.get("date");
 			List<String> sumList = cf.get("number");
 		    if(dateList != null && dateList.size() > 0){
 		    	for (int i = 0; i < dateList.size() ; i++) {
					String month = dateList.get(i);
					Long appQty = appraisalService.getMonthHistoryAppraisal(year,month);
					Double ratio = (double) (appQty/ Double.valueOf(sumList.get(i)))*100;
					DecimalFormat    df   = new DecimalFormat("######0.00"); 
					qty.add(df.format(ratio));
					date.add(month);
				} 
 		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
 		resultMap.put("date", date); 
 		resultMap.put("qty", qty); 
		return resultMap;
	} 
	
	/***
	 * 根据刑事案件立案数 年份 和 月份 获取集合
	 * @param year 年份   month 月份
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_RATIO_COUNTRY_DATA)
	@ResponseBody
	public Map<String, List<String>> getCountryCriminalFiling(String year,String month) {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		List<String> coun = new ArrayList<String>();
		List<String> qty = new ArrayList<String>();
 		try {
 			Map<String, List<String>> cf = criminalFilingQtyService.getCounryCFQty(year,month);
 			List<String> countryList = cf.get("country");
 			List<String> sumList = cf.get("number");
 		    if(countryList != null && countryList.size() > 0){
 		    	for (int i = 0; i < countryList.size() ; i++) {
					String country = countryList.get(i);
					if(country.equals("440100")){
					}else{
					    coun.add(countyService.getCountyByCountyId(country).getName());
					    Long appQty = 0L;
					    if(null != month && !"".equals(month)){
					    	 appQty = appraisalService.getCountryHistoryAppraisal(year,month,country);
					    }else{
					    	 appQty = appraisalService.getCountryHistoryAppraisal(year,country);
					    }
					     //appQty = appraisalService.getCountryHistoryAppraisal(year,country);
						Double ratio = (double) (appQty/ Double.valueOf(sumList.get(i)))*100;
						DecimalFormat    df   = new DecimalFormat("######0.00"); 
						qty.add(df.format(ratio));
					}
				} 
 		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
 		resultMap.put("country", coun); 
 		resultMap.put("qty", qty); 
		return resultMap;
	}  
	
	/***
	 * 比率统计表
	 * @param year 年份   month 月份
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_RATIO_STATISTICS_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getRatioStatisticsList(String year,String month) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<RatioStatisticsDto> resultList = new ArrayList<RatioStatisticsDto>();
		List<CriminalFilingQty> cfList = new ArrayList<CriminalFilingQty>();
		List<Appraisal> appList = new ArrayList<Appraisal>();
		try {
			String name = "";
			Integer casesQty = new Integer(0);
			Integer officeQty = new Integer(0);
			Integer sceneInquestQty = new Integer(0);
			RatioStatisticsDto dto = null;
			DecimalFormat    df   = new DecimalFormat("######0.00"); 
			cfList = criminalFilingQtyService.getCriminalFilingQtys(year, month);
			for (int i = 0; i < cfList.size(); i++) {
				dto = new RatioStatisticsDto();
				if(cfList.get(i).getCountry().equals("440100")){
					officeQty = appraisalService.getCountryHistoryAppraisal(year, month, cfList.get(i).getCountry()).intValue();
					casesQty = cfList.get(i).getFilingQty();
					dto.setCasesQty(casesQty);
					dto.setSceneInquestQty(sceneInquestQty);
					dto.setOfficeQty(officeQty);
					dto.setName("全市");
					if(officeQty.intValue() == 0){
						dto.setEvidenceRatio(0+"");
					}else{
						Double eratio = (double) (Double.valueOf(officeQty)/ Double.valueOf(casesQty)*100);
						dto.setEvidenceRatio(df.format(eratio));
					}
					dto.setSceneRatio(0+"");
				}else{
					officeQty = appraisalService.getCountryHistoryAppraisal(year, month, cfList.get(i).getCountry()).intValue();
					casesQty = cfList.get(i).getFilingQty();
					name = countyService.getCountyByCountyId(cfList.get(i).getCountry()).getName();
					dto.setCasesQty(casesQty);
					dto.setSceneInquestQty(sceneInquestQty);
					dto.setOfficeQty(officeQty);
					dto.setName(name);
					if(officeQty.intValue() == 0){
						dto.setEvidenceRatio(0+"");
					}else{
						Double eratio = (double) (Double.valueOf(officeQty)/ Double.valueOf(casesQty)*100);
						dto.setEvidenceRatio(df.format(eratio));
					}
					dto.setSceneRatio(0+"");
				} 
				resultList.add(dto);
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("entity" , resultList);
		return resultMap;
	} 
	
	/***
	 * 比率统计表
	 * @param year 年份   month 月份
	 * @return
	 */
	@RequestMapping(NavConst.CRIMINALFILINGQTY_DOWNLOAD_RATIO_STATISTICS)
	public void downLoadRatioStatistics(HttpServletResponse response,String year,String month) {
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
	    String filename = timeFormat.format(new Date())+".xls";  
	    response.setContentType("application/ms-excel;charset=UTF-8");  
	    try {
			response.setHeader("Content-Disposition", "attachment;filename="  
			        .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
			OutputStream out = response.getOutputStream();
		
 
	
		List<RatioStatisticsDto> resultList = new ArrayList<RatioStatisticsDto>();
		List<CriminalFilingQty> cfList = new ArrayList<CriminalFilingQty>();
		List<Appraisal> appList = new ArrayList<Appraisal>();
		try {
			String name = "";
			Integer casesQty = new Integer(0);
			Integer officeQty = new Integer(0);
			Integer sceneInquestQty = new Integer(0);
			RatioStatisticsDto dto = null;
			DecimalFormat    df   = new DecimalFormat("######0.00"); 
			cfList = criminalFilingQtyService.getCriminalFilingQtys(year, month);
			for (int i = 0; i < cfList.size(); i++) {
				dto = new RatioStatisticsDto();
				if(cfList.get(i).getCountry().equals("440100")){
					officeQty = appraisalService.getCountryHistoryAppraisal(year, month, cfList.get(i).getCountry()).intValue();
					casesQty = cfList.get(i).getFilingQty();
					dto.setCasesQty(casesQty);
					dto.setSceneInquestQty(sceneInquestQty);
					dto.setOfficeQty(officeQty);
					dto.setName("全市");
					if(officeQty.intValue() == 0){
						dto.setEvidenceRatio(0+"");
					}else{
						Double eratio = (double) (Double.valueOf(officeQty)/ Double.valueOf(casesQty)*100);
						dto.setEvidenceRatio(df.format(eratio));
					}
					dto.setSceneRatio(0+"");
				}else{
					officeQty = appraisalService.getCountryHistoryAppraisal(year, month, cfList.get(i).getCountry()).intValue();
					casesQty = cfList.get(i).getFilingQty();
					name = countyService.getCountyByCountyId(cfList.get(i).getCountry()).getName();
					dto.setCasesQty(casesQty);
					dto.setSceneInquestQty(sceneInquestQty);
					dto.setOfficeQty(officeQty);
					dto.setName(name);
					if(officeQty.intValue() == 0){
						dto.setEvidenceRatio(0+"");
					}else{
						Double eratio = (double) (Double.valueOf(officeQty)/ Double.valueOf(casesQty)*100);
						dto.setEvidenceRatio(df.format(eratio));
					}
					dto.setSceneRatio(0+"");
				} 
				resultList.add(dto);
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		String[] title ={"","刑事立案数","检验鉴定取证报告数","现场勘验笔录数","取证应用率","现场勘验率"};
		//创建Excel工作簿
		  HSSFWorkbook workbook = new HSSFWorkbook();
		  //创建一个工作表sheet
		  HSSFSheet sheet = workbook.createSheet();
	      //创建第一行
		  HSSFRow row = sheet.createRow(0);
		  HSSFCell cell = null;
		  //插入标题
		  for (int i = 0; i < title.length; i++) {
				cell = row.createCell(i);
				HSSFRichTextString text = new HSSFRichTextString(title[i]);  
	            cell.setCellValue(text); 
			}
		//追加数据
	      for (int i = 0,j=1; i < resultList.size(); i++,j++) {
	 		HSSFRow nextrow = sheet.createRow(j);  
	 		HSSFCell cell2 = nextrow.createCell(0);
	 		cell2.setCellValue(resultList.get(i).getName());
	 		cell2=nextrow.createCell(1);
	 		cell2.setCellValue(resultList.get(i).getCasesQty());
	 		cell2=nextrow.createCell(2);
	 		cell2.setCellValue(resultList.get(i).getOfficeQty());
	 		cell2=nextrow.createCell(3);
	 		cell2.setCellValue(resultList.get(i).getSceneInquestQty()+"%" );
	 		cell2=nextrow.createCell(4);
	 		cell2.setCellValue(resultList.get(i).getEvidenceRatio() +"%" );
	 		cell2=nextrow.createCell(5);
	 		cell2.setCellValue(resultList.get(i).getSceneRatio());
	       }
	      workbook.write(out);
	    } catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	       
	} 
	
	
	
	
	
}
