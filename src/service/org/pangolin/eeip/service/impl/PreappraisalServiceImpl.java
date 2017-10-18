package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.PreappraisalDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.Preappraisal;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.PreappraisalService;
import org.springframework.stereotype.Service;

@Service("preappraisalService")
@SuppressWarnings("all")
public class PreappraisalServiceImpl implements PreappraisalService{

	@Resource
	private PreappraisalDao preappraisalDao;
	
	 //根据ID查询
	@Override
	public Preappraisal getPreappraisalById(String id) {
		return preappraisalDao.get(Preappraisal.class, id);
	}
	
	//获取总数量
	@Override
	public Long getPreappraisalQty(String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(id) from Preappraisal where 1=1  ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"')");
		}
		return preappraisalDao.count(hql.toString()+" and delFlag=" + Preappraisal.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<Preappraisal> getPreappraisals() {
		return preappraisalDao.find("from Preappraisal where delFlag="+Preappraisal.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<Preappraisal> getPreappraisals(int startIndex, int rows, String sorter, String sortingAttribute,String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("  from Preappraisal where 1=1  ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"')");
		}
		return preappraisalDao.search(hql.toString()+" and delFlag=" + Preappraisal.NORMAL + " order by " + sorter
				+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removePreappraisal(String id) {
		preappraisalDao.executeHql("delete from Preappraisal where id = ?", new Object[] { id });
		Long qty = preappraisalDao.count("select count(id) from Preappraisal where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removePreappraisalFalse(String id) {
			Integer qty = preappraisalDao.executeHql("update  Preappraisal set delFlag= ? where id = ?", new Object[] { Preappraisal.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean savePreappraisal(Preappraisal preappraisal) {
		try {
			String id = preappraisal.getId();
 			Long qty = preappraisalDao.count("select count(id) from Preappraisal where id=?", new Object[] {id});
 			if (qty > 0) {    
				preappraisalDao.update(preappraisal);
			} else {  
				preappraisalDao.save(preappraisal);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public List<Preappraisal> getPreappraisals(int startIndex, int rows, String sorter, String sortingAttribute,
			String extraParam, String creatorId) {
		StringBuffer hql=new StringBuffer();
		hql.append("  from Preappraisal where 1=1  and creatorId = '"+creatorId+"' ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"')");
		}
		return preappraisalDao.search(hql.toString()+" and delFlag=" + Preappraisal.NORMAL + " order by " + sorter
				+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
	}
	
	//获取总数量 通过登录用户信息
		@Override
		public Long getPreappraisalQty(String extraParam,String creatorId) {
			StringBuffer hql=new StringBuffer();
			hql.append("select count(id) from Preappraisal where 1=1 and creatorId = '"+creatorId+"' ");
			if(null != extraParam && !"".equals(extraParam) ){
				extraParam = "%" + extraParam + "%";
				hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"')");
			}
			return preappraisalDao.count(hql.toString()+" and delFlag=" + Preappraisal.NORMAL);
		}

		@Override
		public Map<String, List<String>> getHistoryYearAnalysis(String year) {
			Map<String, List<String>> result = new HashMap<String, List<String>>();
			List<String> dateList = new ArrayList<String>();
			List<String> sumList = new ArrayList<String>();
			String sql = "";
			if(null != year && !"".equals(year)){
				sql = "select count(p.pk_id) as num , p.f_created_date as date from t_preappraisal as p "
						+ "where p.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by EXTRACT(MONTH FROM p.f_created_date)";	
			}else{
			 sql = "select count(p.pk_id) as num , p.f_created_date as date from t_preappraisal as p "
			 		+ "group by EXTRACT(YEAR FROM p.f_created_date)";
			}
			List list = preappraisalDao.compSearchBySQL(sql, new Object[]{}); 
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
		public Map<String, List<String>> getCountryAnalysis(String year, String month) {
			Map<String, List<String>> result = new HashMap<String, List<String>>();
			List<String> dateList = new ArrayList<String>();
			List<String> sumList = new ArrayList<String>();
			String sql = " select count(p.pk_id) as num , p.f_country as date from t_preappraisal as p where 1=1 ";
			if(null != month && !"".equals(month)){
				sql += "and  p.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' group by f_country";
			}else{
				sql += "and  p.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by f_country";
			} 
			
			List list = preappraisalDao.compSearchBySQL(sql, new Object[]{}); 
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

}
