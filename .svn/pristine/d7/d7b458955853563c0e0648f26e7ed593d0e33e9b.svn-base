package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevEvnDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevEvn;
import org.pangolin.eeip.service.DevEvnService;
import org.springframework.stereotype.Service;

@Service("devEvnService")
@SuppressWarnings("all")
public class DevEvnServiceImpl implements DevEvnService{

	@Resource
	private DevEvnDao devEvnDao;
	
	public DevEvn getDevEvnById(String id) {
		return devEvnDao.get(DevEvn.class, id);
	}
	
	public Long getDevEvnQty() {
		return devEvnDao.count("select count(id) from DevEvn");
	}
	
	public List<DevEvn> getDevEvns() {
		return devEvnDao.find("from DevEvn order by collectedDate desc");
	}
	
	public List<DevEvn> getDevEvns(int startIndex, int rows, String sorter, String sortingAttribute) {
		return devEvnDao.search("from DevEvn order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public boolean saveDevEvn(DevEvn devEvn) {
		try {
			String id = devEvn.getId();
 			Long qty = devEvnDao.count("select count(id) from DevEvn where id=?", new Object[] {id});
 			if (qty > 0) {    
				devEvnDao.update(devEvn);
			} else {  
				devEvnDao.save(devEvn);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}
	
	public DevEvn getDevEvnByCreateDate(String location) {
		List<DevEvn> list = devEvnDao.find("from DevEvn where location = ? order by collectedDate desc",new Object[]{ location });
		if(list.size() > 0){
			return list.get(0);
		}else{
			return new DevEvn();
		}
	}

	@Override
	public Long getDevEvnQty(String queryParam, String startDate, String endDate) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(id) from DevEvn where location = ?  ");
		if(null != startDate && !"".equals(startDate)){
			hql.append(" and  '"+startDate+"' < collectedDate");
		} 
		if(null != endDate && !"".equals(endDate) ){
			hql.append(" and collectedDate < '"+endDate+"'");
		}
//		System.out.println(hql.toString()+" order by collectedDate desc");
		
		return devEvnDao.count(hql.toString(), new Object[] { queryParam });
	}

	@Override
	public List<DevEvn> getDevEvns(int startIndex, int rows, String sorter, String sortingAttribute, String queryParam,
			String startDate, String endDate) {
		StringBuffer hql=new StringBuffer();
		hql.append("from DevEvn where location = ?  ");
		if(null != startDate && !"".equals(startDate)){
			hql.append(" and  '"+startDate+"' <= collectedDate");
		} 
		if(null != endDate && !"".equals(endDate) ){
			hql.append(" and collectedDate <= '"+endDate+"'");
		}
		return devEvnDao.search(hql.toString()+" order by " + sorter + " " + sortingAttribute, new Object[] { queryParam }, startIndex, rows);
	}

	@Override
	public List<DevEvn> getDevEvnList(String queryParam, String startDate, String endDate) {
		StringBuffer hql=new StringBuffer();
		hql.append("from DevEvn where location = ?  ");
		if(null != startDate && !"".equals(startDate)){
			hql.append(" and  '"+startDate+"' <= collectedDate");
		} 
		if(null != endDate && !"".equals(endDate) ){
			hql.append(" and collectedDate <= '"+endDate+"'");
		}
		return devEvnDao.find(hql.toString()+" order by collectedDate desc",new Object[] { queryParam });
	} 
}
