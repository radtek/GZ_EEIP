package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalDocDao;
import org.pangolin.eeip.dao.AppraisalReviseDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AppraisalRevise;
import org.pangolin.eeip.service.AppraisalReviseService;
import org.springframework.stereotype.Service;

@Service("appraisalReviseService")
@SuppressWarnings("all")
public class AppraisalReviseServiceImpl implements AppraisalReviseService{

	@Resource
	private AppraisalReviseDao appraisalReviseDao;
	
	 //根据ID查询
	@Override
	public AppraisalRevise getAppraisalReviseById(String id) {
		return appraisalReviseDao.get(AppraisalRevise.class, id);
	}
	
	//获取总数量
	@Override
	public Long getAppraisalReviseQty(String query,Integer status) {
		return appraisalReviseDao.count("select count(id) from AppraisalRevise where status=? and (reportSn like ? or reportName like ?)",new Object[]{status,"%"+query+"%","%"+query+"%"});
	} 
	
	//获取总集合
	@Override
	public List<AppraisalRevise> getAppraisalRevises() {
		return appraisalReviseDao.find("from AppraisalRevise order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<AppraisalRevise> getAppraisalRevises(String query,Integer status,int startIndex, int rows, String sorter, String sortingAttribute) {
		return appraisalReviseDao.search("from AppraisalRevise  where status=? and (reportSn like ? or reportName like ?) order by " + sorter + " " + sortingAttribute, new Object[] { status,"%"+query+"%","%"+query+"%" }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeAppraisalRevise(String id) {
		appraisalReviseDao.executeHql("delete from AppraisalRevise where id = ?", new Object[] { id });
		Long qty = appraisalReviseDao.count("select count(id) from AppraisalRevise where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean saveAppraisalRevise(AppraisalRevise appraisalRevise) {
		try {
			String id = appraisalRevise.getId();
 			Long qty = appraisalReviseDao.count("select count(id) from AppraisalRevise where id=?", new Object[] {id});
 			if (qty > 0) {    
 				appraisalReviseDao.update(appraisalRevise);
			} else {  
				appraisalReviseDao.save(appraisalRevise);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public AppraisalRevise getAppraisalReviseByAppraisalId(String appraisalId) {
		List<AppraisalRevise> list = appraisalReviseDao.find("from AppraisalRevise where appraisalId = ? and status "
				+ "in ( '0', '1', '2', '3', '4', '6' )",new Object[]{appraisalId});
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Long getAppraisalReviseQty(String userId) {
		return appraisalReviseDao.count("select count(id) from AppraisalRevise where creatorId = ?",new Object[]{ userId });
	}

	@Override
	public List<AppraisalRevise> getAppraisalRevises(int startIndex, int rows, String sorter, String sortingAttribute,String userId) {
		return appraisalReviseDao.search("from AppraisalRevise where creatorId = ? order by " + sorter + " " + sortingAttribute, new Object[] { userId }, startIndex, rows);
	}

	@Override
	public Long getAppraisalReviseQty(Integer status) {
		return appraisalReviseDao.count("select count(id) from AppraisalRevise where status =? ",new Object[]{status});
	}

	@Override
	public List<AppraisalRevise> getAppraisalRevises(Integer status, int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return appraisalReviseDao.search("from AppraisalRevise  where status=? order by " + sorter + " " + sortingAttribute, new Object[] { status }, startIndex, rows);
	}

	@Override
	public List<AppraisalRevise> getAppraisalRevises(String userId) {
		return appraisalReviseDao.find("from AppraisalRevise where creatorId = ? ", new Object[] { userId });
	}
}
