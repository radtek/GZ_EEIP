package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisedDevDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AppraisedDev;
import org.pangolin.eeip.service.AppraisedDevService;
import org.springframework.stereotype.Service;

@Service("appraisedDevService")
@SuppressWarnings("all")
public class AppraisedDevServiceImpl implements AppraisedDevService{

	@Resource
	private AppraisedDevDao appraisedDevDao;
	
	 //根据ID查询
	@Override
	public AppraisedDev getAppraisedDevById(String id) {
		return appraisedDevDao.get(AppraisedDev.class, id);
	 }
	
	//获取总数量
	@Override
	public Long getAppraisedDevQty() {
		return appraisedDevDao.count("select count(id) from AppraisedDev where delFlag = "+AppraisedDev.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<AppraisedDev> getAppraisedDevs() {
		return appraisedDevDao.find("from AppraisedDev where delFlag="+AppraisedDev.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<AppraisedDev> getAppraisedDevs(int startIndex, int rows, String sorter, String sortingAttribute) {
		return appraisedDevDao.search("from AppraisedDev where delFlag = "+AppraisedDev.NORMAL + " order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeAppraisedDev(String id) {
		appraisedDevDao.executeHql("delete from AppraisedDev where id = ?", new Object[] { id });
		Long qty = appraisedDevDao.count("select count(id) from AppraisedDev where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeAppraisedDevFalse(String id) {
			Integer qty = appraisedDevDao.executeHql("update AppraisedDev set delFlag = ? where id = ?", new Object[] { AppraisedDev.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveAppraisedDev(AppraisedDev appraisedDev) {
		try {
			String id = appraisedDev.getId();
 			Long qty = appraisedDevDao.count("select count(id) from AppraisedDev where id=?", new Object[] {id});
 			if (qty > 0) {    
				appraisedDevDao.update(appraisedDev);
			} else {  
				appraisedDevDao.save(appraisedDev);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public void saveAppraisedDevByHistory(String historyId, String appraisalId) {
		appraisedDevDao.executeHql("update AppraisedDev set delFlag = ?,appraisalHistId = ? where appraisalId = ?",new Object[]{ AppraisedDev.REMOVED , historyId , appraisalId   });
	}

	@Override
	public List<AppraisedDev> getAppraisedByappraisalId(String id) {
		return appraisedDevDao.find("from AppraisedDev where appraisalId = ? and delFlag="+AppraisedDev.NORMAL,new Object[]{id});
	}
	 
}
