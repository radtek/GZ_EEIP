package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.PreappraisedEvidDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.PreappraisedEvid;
import org.pangolin.eeip.service.PreappraisedEvidService;
import org.springframework.stereotype.Service;

@Service("preappraisedEvidService")
@SuppressWarnings("all")
public class PreappraisedEvidServiceImpl implements PreappraisedEvidService{

	@Resource
	private PreappraisedEvidDao preappraisedEvidDao;
	
	 //根据ID查询
	@Override
	public PreappraisedEvid getPreappraisedEvidById(String id) {
		return preappraisedEvidDao.get(PreappraisedEvid.class, id);
	}
	
	//获取总数量
	@Override
	public Long getPreappraisedEvidQty() {
		return preappraisedEvidDao.count("select count(id) from PreappraisedEvid ");
	} 
	
	//获取总集合
	@Override
	public List<PreappraisedEvid> getPreappraisedEvids(String preappraisalId) {
		return preappraisedEvidDao.find("from PreappraisedEvid where preappraisalId = ? " , new Object[]{ preappraisalId });
	}
	
	//分页查询
	@Override
	public List<PreappraisedEvid> getPreappraisedEvids(int startIndex, int rows, String sorter, String sortingAttribute) {
		return preappraisedEvidDao.search("from PreappraisedEvid order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removePreappraisedEvid(String preappraisalId) {
		preappraisedEvidDao.executeHql("delete from PreappraisedEvid where preappraisalId = ?", new Object[] { preappraisalId });
		Long qty = preappraisedEvidDao.count("select count(id) from PreappraisedEvid where preappraisalId = ?" , new Object[] { preappraisalId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean savePreappraisedEvid(PreappraisedEvid preappraisedEvid) {
		try {
			String id = preappraisedEvid.getId();
 			Long qty = preappraisedEvidDao.count("select count(id) from PreappraisedEvid where id=?", new Object[] {id});
 			if (qty > 0) {    
				preappraisedEvidDao.update(preappraisedEvid);
			} else {  
				preappraisedEvidDao.save(preappraisedEvid);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public PreappraisedEvid getPreappraisedEvid(String preappraisalId, String sn) {
 		return preappraisedEvidDao.get(" from PreappraisedEvid where preappraisalId = ? and sn = ? ", new Object[]{preappraisalId , sn});
	}
	 
}
