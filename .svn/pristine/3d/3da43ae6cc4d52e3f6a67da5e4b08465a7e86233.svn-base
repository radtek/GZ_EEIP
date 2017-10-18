package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalReviseEntrusterDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AppraisalReviseEntruster;
import org.pangolin.eeip.service.AppraisalReviseEntrusterService;
import org.springframework.stereotype.Service;

@Service("appraisalReviseEntrusterService")
@SuppressWarnings("all")
public class AppraisalReviseEntrusterServiceImpl implements AppraisalReviseEntrusterService{

	@Resource
	private AppraisalReviseEntrusterDao appraisalReviseEntrusterDao;
	
	 //根据ID查询
	@Override
	public AppraisalReviseEntruster getAppraisalReviseEntrusterById(String id) {
		return appraisalReviseEntrusterDao.get(AppraisalReviseEntruster.class, id);
	}
	
	//获取总数量
	@Override
	public Long getAppraisalReviseEntrusterQty() {
		return appraisalReviseEntrusterDao.count("select count(id) from AppraisalReviseEntruster");
	} 
	
	//获取总集合
	@Override
	public List<AppraisalReviseEntruster> getAppraisalReviseEntrusters() {
		return appraisalReviseEntrusterDao.find("from AppraisalReviseEntruster order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<AppraisalReviseEntruster> getAppraisalReviseEntrusters(int startIndex, int rows, String sorter, String sortingAttribute) {
		return appraisalReviseEntrusterDao.search("from AppraisalReviseEntruster order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeAppraisalReviseEntruster(String id) {
		appraisalReviseEntrusterDao.executeHql("delete from AppraisalReviseEntruster where id = ?", new Object[] { id });
		Long qty = appraisalReviseEntrusterDao.count("select count(id) from AppraisalReviseEntruster where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean saveAppraisalReviseEntruster(AppraisalReviseEntruster appraisalReviseEntruster) {
		String method = "";
		if ( appraisalReviseEntruster.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		appraisalReviseEntrusterDao.saveOrUpdate(appraisalReviseEntruster);
		if ( method.equals("add") ) {
			if ( appraisalReviseEntruster.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public List<AppraisalReviseEntruster> getAppraisalReviseEntrusters(String appraisalReviseAppId) {
 		return appraisalReviseEntrusterDao.find(" from AppraisalReviseEntruster  where appraisalReviseAppId =? ", new Object[]{appraisalReviseAppId});
	}
}
