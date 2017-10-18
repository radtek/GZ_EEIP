package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.CriminalFilingQtyDao;
import org.pangolin.eeip.entity.CriminalFilingQty;
import org.pangolin.eeip.service.CriminalFilingQtyService;
import org.springframework.stereotype.Service;

@Service
public class CriminalFilingQtyServiceImpl implements CriminalFilingQtyService {

	@Resource
	private CriminalFilingQtyDao criminalFilingQtyDao;
	
	
	@Override
	public CriminalFilingQty getCriminalFilingQty(String id) {
		return criminalFilingQtyDao.get(CriminalFilingQty.class, id);
	}

	@Override
	public List<CriminalFilingQty> getCriminalFilingQtys(String year,String month) {
 		return criminalFilingQtyDao.find("from CriminalFilingQty where year =? and month =?", new Object[]{year,month});
	}

	@Override
	public boolean saveCriminalFilingQtyByYearAndMonth(CriminalFilingQty criminalFilingQty) {
		try {
			criminalFilingQtyDao.executeHql("delete from CriminalFilingQty where year =? and month =? and  country =?", new Object[] { criminalFilingQty.getYear(),criminalFilingQty.getMonth(),criminalFilingQty.getCountry() });
 			Long qty = criminalFilingQtyDao.count("select count(id) from CriminalFilingQty where year =? and month =? and  country =?", new Object[] {criminalFilingQty.getYear(),criminalFilingQty.getMonth(),criminalFilingQty.getCountry()  });
			if(qty>0){
				return false;
			}else{
				criminalFilingQtyDao.save(criminalFilingQty);	
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public Map<String, List<String>> getYearHistoryCFQty(String year) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		List<String> dateList = new ArrayList<String>();
		List<String> sumList = new ArrayList<String>();
		String sql = "";
		if( null != year && !"".equals(year)){
			sql = "select sum(f_filing_qty) ,f_month from t_criminal_filing_qty where f_year = '"+year+"' and f_country = '440100' GROUP BY f_month  order by f_created_date asc"; 
		}else{
			sql = "select sum(f_filing_qty) ,f_year from t_criminal_filing_qty where  f_country = '440100'  GROUP BY f_year order by f_created_date asc"; 
		}
		
		List list = criminalFilingQtyDao.compSearchBySQL(sql, new Object[]{}); 
		if(null != list && list.size() > 0){
			for ( int i = 0; i < list.size(); i++) {
				Object[] objArray = (Object[])list.get(i);
				sumList.add(objArray[0].toString());
				dateList.add(objArray[1].toString());
			}
		}
		result.put("number", sumList);
		result.put("date", dateList);
	return result;
	}

	@Override
	public Map<String, List<String>> getCounryCFQty(String year,String month) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		List<String> countryList = new ArrayList<String>();
		List<String> sumList = new ArrayList<String>();
		String sql = "";
		if( null != month && !"".equals(month)){
			sql = "select sum(f_filing_qty) ,f_country from t_criminal_filing_qty where f_year ='"+year+"' and f_month='"+month+"'  GROUP BY f_country"; 
		}else{
			sql = "select sum(f_filing_qty) ,f_country from t_criminal_filing_qty where f_year ='"+year+"'  GROUP BY f_country"; 
		}
		
		List list = criminalFilingQtyDao.compSearchBySQL(sql, new Object[]{}); 
		if(null != list && list.size() > 0){
			for ( int i = 0; i < list.size(); i++) {
				Object[] objArray = (Object[])list.get(i);
				sumList.add(objArray[0].toString());
				countryList.add(objArray[1].toString());
			}
		}
		result.put("number", sumList);
		result.put("country", countryList);
	return result;
	}

	
	
}
