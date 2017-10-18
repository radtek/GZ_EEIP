package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.PreappraisalEntrusterDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.PreappraisalEntruster;
import org.pangolin.eeip.service.PreappraisalEntrusterService;
import org.springframework.stereotype.Service;

@Service("PreappraisalEntrusterService")
@SuppressWarnings("all")
public class PreappraisalEntrusterServiceImpl implements PreappraisalEntrusterService{

	@Resource
	private PreappraisalEntrusterDao PreappraisalEntrusterDao;
	
	 //根据ID查询
	@Override
	public PreappraisalEntruster getPreappraisalEntrusterById(String id) {
		return PreappraisalEntrusterDao.get(PreappraisalEntruster.class, id);
	}
	
	//获取总数量
	@Override
	public Long getPreappraisalEntrusterQty() {
		return PreappraisalEntrusterDao.count("select count(id) from PreappraisalEntruster");
	} 
	
	//获取List
	@Override
	public List<PreappraisalEntruster> getPreappraisalEntrusters(String PreappraisalId) {
		return PreappraisalEntrusterDao.find("from PreappraisalEntruster where preappraisalId = ? ", new Object[]{ PreappraisalId });
	}
	
	//分页查询
	@Override
	public List<PreappraisalEntruster> getPreappraisalEntrusters(int startIndex, int rows, String sorter, String sortingAttribute) {
		return PreappraisalEntrusterDao.search("from PreappraisalEntruster order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	@Override
	public boolean removePreappraisalEntruster(String preappraisalId) {
		PreappraisalEntrusterDao.executeHql("delete from PreappraisalEntruster where preappraisalId = ?", new Object[] { preappraisalId });
		Long qty = PreappraisalEntrusterDao.count("select count(id) from PreappraisalEntruster where preappraisalId = ?" , new Object[] { preappraisalId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean savePreappraisalEntruster(PreappraisalEntruster PreappraisalEntruster) {
		try {
			String id = PreappraisalEntruster.getId();
 			Long qty = PreappraisalEntrusterDao.count("select count(id) from PreappraisalEntruster where id=?", new Object[] {id});
 			if (qty > 0) {    
				PreappraisalEntrusterDao.update(PreappraisalEntruster);
			} else {  
				PreappraisalEntrusterDao.save(PreappraisalEntruster);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public PreappraisalEntruster getPreappraisalEntrusterBypreappraisalId(String preappraisalDataId) {
		List<PreappraisalEntruster> list = PreappraisalEntrusterDao.find("from PreappraisalEntruster where preappraisalId = ? ",new Object[]{preappraisalDataId});
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<PreappraisalEntruster> getPreappraisalEntrusterListByPreappraisalId(String preappraisalId) {
		return PreappraisalEntrusterDao.find("from PreappraisalEntruster where preappraisalId = ? ",new Object[]{ preappraisalId });
	}
	 
}
