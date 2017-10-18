package org.pangolin.eeip.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.DevAdjPlanItem;
import org.pangolin.eeip.entity.Preappraisal;
import org.pangolin.eeip.service.AppraisalService;
import org.springframework.stereotype.Service;

@Service("appraisalService")
@SuppressWarnings("all")
public class AppraisalServiceImpl implements AppraisalService{

	@Resource
	private AppraisalDao appraisalDao;
	
	 //根据ID查询
	@Override
	public Appraisal getAppraisalById(String id) {
		return appraisalDao.get(Appraisal.class, id);
	}
	
	//获取总数量
	@Override
	public Long getAppraisalQty(Integer status) {
		if(status!=null){
			return appraisalDao.count("select count(id) from Appraisal where status =? and delFlag=? ",new Object[]{status,Appraisal.NORMAL});
		}else{
			return appraisalDao.count("select count(id) from Appraisal and delFlag=? ",new Object[]{Appraisal.NORMAL});
		}
		
	} 
	
	@Override
	public Long getAppraisalQty(String caseName, String caseSn, Integer status) {
		return appraisalDao.count("select count(id) from Appraisal where status=? and( caseName like ? or caseSn like ?  ) and delFlag=? ",new Object[]{status,"%"+caseName+"%","%"+caseSn+"%",Appraisal.NORMAL});
	}
	
	//获取总集合
	@Override
	public List<Appraisal> getAppraisals() {
		return appraisalDao.find("from Appraisal order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<Appraisal> getAppraisals(Integer status,int startIndex, int rows, String sorter, String sortingAttribute) {
		if(status!=null){
			return appraisalDao.search("from Appraisal where status = ? and delFlag=? order by " + sorter + " " + sortingAttribute, new Object[] { status ,Appraisal.NORMAL}, startIndex, rows);
		}else{
			return appraisalDao.search("from Appraisal where and delFlag=? order by " + sorter + " " + sortingAttribute, new Object[] { Appraisal.NORMAL }, startIndex, rows);
		}
		
	} 

	@Override
	public List<Appraisal> getAppraisals(String caseName, String caseSn, Integer status, int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return appraisalDao.search("from Appraisal where status=? and( caseName like ? or caseSn like ?  ) and delFlag=?   order by " + sorter + " " + sortingAttribute, new Object[] { status,"%"+caseName+"%","%"+caseSn+"%",Appraisal.NORMAL }, startIndex, rows);
	}
	
	//数据删除
	@Override
	public boolean removeAppraisal(String id) {
		appraisalDao.executeHql("delete from Appraisal where id = ?", new Object[] { id });
		Long qty = appraisalDao.count("select count(id) from Appraisal where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean saveAppraisal(Appraisal appraisal) {
		try {
			String id = appraisal.getId();
 			Long qty = appraisalDao.count("select count(id) from Appraisal where id=?", new Object[] {id});
 			if (qty > 0) {    
 				appraisalDao.update(appraisal);
			} else {  
				appraisalDao.save(appraisal);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public Appraisal getAppraisalByUserId(String userId) {
		List<Appraisal> list = appraisalDao.find("from Appraisal where delFlag = ? and  appraiserId = ? order by createdDate",new Object[]{Appraisal.NORMAL , userId });
		if(list.size() > 0){
			for (Appraisal appraisal : list) {
				if(appraisal.getStatus().intValue() ==  Appraisal.LED_BY.intValue()){//6
					return appraisal;
				}else if(appraisal.getStatus().intValue() == Appraisal.DEV_APPLY.intValue() ){//7
					return appraisal;
				}else if(appraisal.getStatus().intValue() == Appraisal.AUTHENTICATE.intValue()){//8
					return appraisal;
				}else if(appraisal.getStatus().intValue() == Appraisal.CHECK_MATERIAL_RETURNED.intValue()){//9
					return appraisal;
				}else if(appraisal.getStatus().intValue() == Appraisal.ARRANGEMENT_DOCUMENTS.intValue()){//10
					return appraisal;
				}else if(appraisal.getStatus().intValue() == Appraisal.DOWN_DOC.intValue()){ //13
					return appraisal;
				}
			}
		}
		return null;
	}

	@Override
	public List<Appraisal> getFinishAppraisals(int start, int limit, String sorter, String sorterDirection,String userId) {
		return appraisalDao.search("from Appraisal where delFlag = ? and status = "+Appraisal.RESULT_FEEDBACK+" and appraiserId = ? order by " + sorter + " " + sorterDirection, new Object[] { Appraisal.NORMAL,userId }, start, limit);
	}

	@Override
	public long getFinishAppraisalQty(String userId) {
		return appraisalDao.count("select count(id) from Appraisal where delFlag = ? and  status = "+Appraisal.RESULT_FEEDBACK+" and appraiserId = ? order by createdDate desc", new Object[] {Appraisal.NORMAL, userId });
		
	}

	//获取在库检材料列表
	@Override
	public List<Appraisal> getAppraisalInStockList(int start, int limit, String sorter, String sorterDirection,String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Appraisal where status = "+Appraisal.TERMINATION+" or status > "+Appraisal.WILL_STORAGE+" and status < "+Appraisal.FINISH+"  and ( delFlag="+Appraisal.NORMAL+"  ) ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"'or evidSn like '"+ extraParam +"')");
		}
		return appraisalDao.search(hql.toString()+" order by " + sorter + " " + sorterDirection, new Object[] {  }, start, limit);
	}
	
	//获取在库检材料列表
	@Override
	public long getAppraisalInStock(String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(id) from Appraisal where status = "+Appraisal.TERMINATION+" or status > "+Appraisal.WILL_STORAGE+" and status < "+Appraisal.FINISH+" and ( delFlag="+Appraisal.NORMAL+"  )");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"'or evidSn like '"+ extraParam +"')");
		}
		return appraisalDao.count(hql.toString()+" order by createdDate desc");
	}
	
	@Override
	public List<Appraisal> getAppraisalList(int start, int limit, String sorter, String sorterDirection) {
		return appraisalDao.search("from Appraisal where status > "+Appraisal.WILL_STORAGE+" and status < "+Appraisal.FINISH+" order by " + sorter + " " + sorterDirection, new Object[] {  }, start, limit);
	}

	@Override
	public long getAppraisalQty() {
		return appraisalDao.count("select count(id) from Appraisal where status != "+Appraisal.FINISH+" order by createdDate desc");
	}

	@Override
	public List<Appraisal> getAppraisalConnectList(int start, int limit, String sorter, String sorterDirection) {
		return appraisalDao.search("from Appraisal where delFlag=?  order by " + sorter + " " + sorterDirection, new Object[] {Appraisal.NORMAL  }, start, limit);
	}

	@Override
	public long getAppraisalConnectQty() {
		return appraisalDao.count("select count(id) from Appraisal where delFlag=?  order by createdDate desc",new Object[]{ Appraisal.NORMAL });
	}

	@Override
	public List<Appraisal> getAppraisalConnectLists(int start, int limit, String sorter, String sorterDirection,
			String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Appraisal where 1=1 and delFlag=  0");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"'or evidSn like '"+ extraParam +"')");
		}
		return appraisalDao.search(hql.toString()+" order by " + sorter + " " + sorterDirection, new Object[] {    }, start, limit);
	}

	@Override
	public long getAppraisalConnectQtys(String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(id) from Appraisal where 1=1 and delFlag= 0 ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"' or evidSn like '"+ extraParam +"')");
		}
		return appraisalDao.count(hql.toString()+" order by createdDate desc");
	}

	@Override
	public List<Appraisal> getAppraisalOutputList(int start, int limit, String sorter, String sorterDirection,String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("from Appraisal where status = "+Appraisal.FINISH+" and delFlag="+Appraisal.NORMAL+" ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"'or evidSn like '"+ extraParam +"')");
		}
		return appraisalDao.search(hql.toString()+" order by " + sorter + " " + sorterDirection, new Object[] {  }, start, limit);
	}

	@Override
	public long getAppraisalOutputQty(String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(id) from Appraisal where status = "+Appraisal.FINISH+"  and delFlag="+Appraisal.NORMAL+" ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (orgName  like '" + extraParam +"' or caseName like '"+ extraParam + "' or caseSn like '"+ extraParam +"'or evidSn like '"+ extraParam +"')");
		}
		return appraisalDao.count(hql.toString()+" order by createdDate desc");
	}

	@Override
	public Long getAllAppraisalsSearchQty(String caseName, String caseSn) {
		return appraisalDao.count("select count(id) from Appraisal  where delFlag=? and ( caseName =? and caseSn =? ) order by  createdDate desc",new Object[]{Appraisal.NORMAL ,caseName , caseSn});
	}

	@Override
	public List<Appraisal> getAllAppraisalsSearch(String caseName, String caseSn, int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return appraisalDao.search("from Appraisal where delFlag=? and (  caseName like ? or caseSn like ? )  order by " + sorter + " " + sortingAttribute, new Object[] {Appraisal.NORMAL , "%"+caseName+"%","%"+caseSn+"%" }, startIndex, rows);
	}

	@Override
	public Long getAppraisalQtyByUserIdQty(String userId) {
		return appraisalDao.count("select count(id) from Appraisal where  delFlag=? and  ( appraiserId = ? or acceptorId = ? ) order by createdDate desc",new Object[]{Appraisal.NORMAL,userId,userId});
	}

	@Override
	public List<Appraisal> getFinishAppraisalsByUserId(String userId, int start, int limit, String sorter,
			String sorterDirection) {
		return appraisalDao.search("from Appraisal where delFlag=? and  ( appraiserId = ? or acceptorId = ? ) order by " + sorter + " " + sorterDirection, new Object[] {Appraisal.NORMAL, userId,userId }, start, limit);
	}

	@Override
	public Long getAppraisalQtyByUserIdQty(String userId, String caseName, String caseSn) {
		return appraisalDao.count("select count(id) from Appraisal where delFlag=? and (appraiserId = ? or acceptorId = ? ) and ( caseName like ? or caseSn like ?)  order by createdDate desc",new Object[]{Appraisal.NORMAL,userId,userId,caseName,caseSn});
	}

	@Override
	public List<Appraisal> getFinishAppraisalsByUserId(String userId, String caseName, String caseSn, int start,
			int limit, String sorter, String sorterDirection) {
		return appraisalDao.search("from Appraisal where delFlag=? and  (appraiserId = ? or acceptorId = ? ) and ( caseName like ? or caseSn like ?)  order by " + sorter + " " + sorterDirection, new Object[] {Appraisal.NORMAL, userId ,userId,caseName,caseSn }, start, limit);
	}

	@Override
	public Appraisal getAppraisalByPreappraisedId(String preappraisalId) {
		List<Appraisal> list = appraisalDao.find("from Appraisal where preappraisalId = ? order by createdDate desc",new Object[]{ preappraisalId });
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Appraisal> getAppraisalsByPreappraisedId(String preappraisalId) {
		return  appraisalDao.find("from Appraisal where preappraisalId = ?   and delFlag=?  order by createdDate desc",new Object[]{ preappraisalId, Appraisal.NORMAL });
	}

	@Override
	public List<Appraisal> getAppraisalsIndex(Integer status) {
		return  appraisalDao.find("from Appraisal where status = ?  and delFlag=? order by createdDate desc",new Object[]{ status , Appraisal.NORMAL }, 0, 5);
	}
	@Override
	public Map<String, Object> getAcceptedAnalysis(String year, String month) {
		Map<String, Object> result = new HashMap<String,  Object>();
		Integer ok=0;
		Integer no=0;
		 String sql = "select count(p.pk_id) , p.f_status from t_appraisal as p where p.f_del_flag = 0   ";
		 if(null != month && !"".equals(month)){
				sql += "and  p.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' group by p.f_status";
			}else{
				sql += "and  p.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by p.f_status";
			}  
		 List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
			if(null != list && list.size() > 0){
				for ( int i = 0; i < list.size(); i++) {
					Object[] objArray = (Object[])list.get(i);
					if( Integer.parseInt(objArray[1].toString()) == 0 || Integer.parseInt(objArray[1].toString()) == 1 ){
						no+=Integer.parseInt(objArray[0].toString());
					}else{
						ok+=Integer.parseInt(objArray[0].toString());
					}
				}
			}
			result.put("no", no);
			result.put("ok", ok);
		return result;
	}

	@Override
	public Map<String, List<String>> getHistoryYearAnalysis(String year) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		List<String> dateList = new ArrayList<String>();
		List<String> sumList = new ArrayList<String>();
		String sql = "";
		if(null != year && !"".equals(year)){
			sql = "select count(p.pk_id) as num , p.f_created_date as date from t_appraisal as p "
					+ "where p.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by EXTRACT(MONTH FROM p.f_created_date)";	
		}else{
		 sql = "select count(p.pk_id) as num , p.f_created_date as date from t_appraisal as p "
		 		+ "group by EXTRACT(YEAR FROM p.f_created_date)";
		}
		List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
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
		String sql = " select count(a.pk_id) , b.f_country from t_appraisal as a  ,t_preappraisal as b where a.fk_preappraisal_id = b.pk_id  ";
		if(null != month && !"".equals(month)){
			sql += "and  a.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' group by b.f_country  ";
		}else{
			sql += "and  a.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by b.f_country";
		} 
		
		List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
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
	public Map<String, List<String>> getAppraisalsTypeAnalysis(String year, String month) {
		Map<String, List<String>> result = new HashMap<String,  List<String>>();
		List<String> typeList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();
		 String sql = " select count(a.pk_id),b.f_type from t_preappraisal as a  ,t_preappraised_evid as b where a.pk_id = b.fk_preappraisal_id  ";
		 if(null != month && !"".equals(month)){
				sql += "and  a.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' group by b.f_type";
			}else{
				sql += "and  a.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by b.f_type";
			}  
		 List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
			if(null != list && list.size() > 0){
				for ( int i = 0; i < list.size(); i++) {
					Object[] objArray = (Object[])list.get(i);
					numberList.add(objArray[0].toString());
					typeList.add(objArray[1].toString());
				}
			}
			result.put("type", typeList);
			result.put("number", numberList);
		return result;
	}

	@Override
	public Map<String, List<String>> getAcceptedOKYearAnalysis(String year) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		List<String> dateList = new ArrayList<String>();
		List<String> sumList = new ArrayList<String>();
		String sql = "";
		if(null != year && !"".equals(year)){
			sql = "select count(p.pk_id) as num , p.f_created_date as date from t_appraisal as p "
					+ "where p.f_status > 1 and  p.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by EXTRACT(MONTH FROM p.f_created_date)";	
		}else{
		 sql = "select count(p.pk_id) as num , p.f_created_date as date from t_appraisal as p "
		 		+ " where p.f_status > 1  group by EXTRACT(YEAR FROM p.f_created_date)";
		}
		List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
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
	public Map<String, Object> getIdentifyResultsAnalysis(String year, String month,String country) {
		Map<String, Object> result = new HashMap<String,  Object>();
		Integer ok=0;
		Integer no=0;
		Integer stop=0;
		 String sql = "select count(p.pk_id) , p.f_status from t_appraisal as p ,t_preappraisal as b where p.f_del_flag = 0 and p.fk_preappraisal_id = b.pk_id and b.f_country = '"+country+"'  ";
		 if(null != month && !"".equals(month)){
				sql += "and  p.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' group by p.f_status";
			}else{
				sql += "and  p.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by p.f_status";
			}  
		 List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
			if(null != list && list.size() > 0){
				for ( int i = 0; i < list.size(); i++) {
					Object[] objArray = (Object[])list.get(i);
					if(  Integer.parseInt(objArray[1].toString()) == 1 ){
						no+=Integer.parseInt(objArray[0].toString());
					}else if(  Integer.parseInt(objArray[1].toString()) == 14 ){
						ok+=Integer.parseInt(objArray[0].toString());
					}/*else if(  Integer.parseInt(objArray[1].toString()) == 15 ){
						stop+=Integer.parseInt(objArray[0].toString());
					}*/
				}
			}
			String stopSql="select count(a.pk_id) from t_appraisal as a ,t_preappraisal as b  "
					+ "where a.fk_preappraisal_id = b.pk_id and b.f_country = '"+country+"'  and  a.pk_id in "
					+ "( select fk_appraisal_id from t_appraisal_doc where f_type='10' and f_del_flag = '0'";
			if(null != month && !"".equals(month)){
				stopSql += " and f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59') ";
			}else{
				stopSql += " and f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59') ";
			}			
			 List list2 = appraisalDao.compSearchBySQL(stopSql, new Object[]{}); 
			 if(null != list2 && list2.size() > 0){
				 BigInteger astop = (BigInteger)list2.get(0);
				 stop = astop.intValue();
			 }
			
			result.put("no", no);
			result.put("ok", ok);
			result.put("stop", stop);
		return result;
	}

	@Override
	public Map<String, List<String>> getAcceptedOKONCountryAnalysis(String year,String month) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		List<String> nameList = new ArrayList<String>();
		List<String> sumList = new ArrayList<String>();
		String sql = "select count(a.pk_id),b.f_country from t_appraisal as a ,t_preappraisal as b where a.fk_preappraisal_id = b.pk_id and  a.f_del_flag = 0 and a.f_status > 1    ";
		if(null != month && !"".equals(month)){
			sql += "and  a.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' group by b.f_country";
		} else{
			sql += "and  a.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' group by b.f_country";
		}
		List list = appraisalDao.compSearchBySQL(sql, new Object[]{}); 
		if(null != list && list.size() > 0){
			for ( int i = 0; i < list.size(); i++) {
				Object[] objArray = (Object[])list.get(i);
				sumList.add(objArray[0].toString());
				nameList.add(objArray[1].toString());
			}
		}
		result.put("number", sumList);
		result.put("name", nameList);
	   return result; 
	}

	@Override
	public Long getYearHistoryAppraisal(String year) {
	 Long qty = appraisalDao.count(" select count(id) from Appraisal where delFlag = 0 and createdDate BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' ");
	 return qty;
	}

	@Override
	public Long getMonthHistoryAppraisal(String year, String month) {
		Long qty = appraisalDao.count(" select count(id) from Appraisal where delFlag = 0 and createdDate BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59' ");
 	 return qty;
	}

	@Override
	public Long getCountryHistoryAppraisal(String year, String country) {
		Long qty = 0L;
		List list = appraisalDao.compSearchBySQL(" select count(a.pk_id) from t_appraisal as a , t_preappraisal as b where a.fk_preappraisal_id = b.pk_id and "
				+ "  a.f_del_flag = 0 and a.f_created_date BETWEEN '"+year+"-01-01 00:00:00' and '"+year+"-12-31 23:59:59' and b.f_country ='"+country+"' ", new Object[]{});
		if(null != list && list.size() > 0){
			qty = Long.parseLong( list.get(0).toString());
		}
		return qty;
	}

	@Override
	public Long getCountryHistoryAppraisal(String year, String month, String country) {
		Long qty = 0L;
		String sql=" select count(a.pk_id) from t_appraisal as a , t_preappraisal as b where a.fk_preappraisal_id = b.pk_id and "
				+ "  a.f_del_flag = 0 and a.f_created_date BETWEEN '"+year+"-"+month+"-01 00:00:00' and '"+year+"-"+month+"-31 23:59:59'  ";
		if( !"440100".equals(country)){
			sql += " and b.f_country ='"+country+"' ";
		}
		
		List list = appraisalDao.compSearchBySQL(sql, new Object[]{});
		if(null != list && list.size() > 0){
			qty = Long.parseLong( list.get(0).toString());
		}
		return qty;
	} 
	
}
