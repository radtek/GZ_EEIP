package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.PreappraisalAttDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.PreappraisalAtt;
import org.pangolin.eeip.service.PreappraisalAttService;
import org.springframework.stereotype.Service;

@Service("preappraisalAttService")
@SuppressWarnings("all")
public class PreappraisalAttServiceImpl implements PreappraisalAttService{

	@Resource
	private PreappraisalAttDao preappraisalAttDao;
	
	 //根据ID查询
	@Override
	public PreappraisalAtt getPreappraisalAttById(String id) {
		return preappraisalAttDao.get(PreappraisalAtt.class, id);
	}
	
	//获取总数量
	@Override
	public Long getPreappraisalAttQty() {
		return preappraisalAttDao.count("select count(id) from PreappraisalAtt");
	} 
	
	//获取总集合
	@Override
	public List<PreappraisalAtt> getPreappraisalAtts(String PreappraisalId) {
		return preappraisalAttDao.find("from PreappraisalAtt where preappraisalId = ? order by createdDate desc",new Object[]{ PreappraisalId });
	}
	
	//分页查询
	@Override
	public List<PreappraisalAtt> getPreappraisalAtts(int startIndex, int rows, String sorter, String sortingAttribute) {
		return preappraisalAttDao.search("from PreappraisalAtt order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removePreappraisalAtt(String id) {
		preappraisalAttDao.executeHql("delete from PreappraisalAtt where id = ?", new Object[] { id });
		Long qty = preappraisalAttDao.count("select count(id) from PreappraisalAtt where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除
	@Override
	public boolean removePreappraisalAttByPreappraisalId(String preappraisalId) {
		preappraisalAttDao.executeHql("delete from PreappraisalAtt where preappraisalId = ?", new Object[] { preappraisalId });
		Long qty = preappraisalAttDao.count("select count(id) from PreappraisalAtt where preappraisalId = ?" , new Object[] { preappraisalId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean savePreappraisalAtt(PreappraisalAtt preappraisalAtt) {
		try {
			String id = preappraisalAtt.getId();
 			Long qty = preappraisalAttDao.count("select count(id) from PreappraisalAtt where id=?", new Object[] {id});
 			if (qty > 0) {    
				preappraisalAttDao.update(preappraisalAtt);
			} else {  
				preappraisalAttDao.save(preappraisalAtt);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}
	 
}
