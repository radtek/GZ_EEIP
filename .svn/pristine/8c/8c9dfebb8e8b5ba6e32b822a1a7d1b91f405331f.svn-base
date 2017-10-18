package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ImplPlanDao;
import org.pangolin.eeip.entity.ImplPlan;
import org.pangolin.eeip.service.ImplPlanService;
import org.springframework.stereotype.Service;

@Service("implPlanService")
public class ImplPlanServiceImpl implements ImplPlanService{

	@Resource
	private ImplPlanDao implPlanDao;

	@Override
	public boolean saveImplPlan(ImplPlan implPlan) {
		Long qty = implPlanDao.count("select count(id) from ImplPlan where id = ?", new Object[]{ implPlan.getId() });
		if( qty > 0 ){
			implPlanDao.update(implPlan);
		}else{
			implPlanDao.save(implPlan);
		}
		return true; 
		/*String method = "";
		if ( implPlan.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		implPlanDao.saveOrUpdate(implPlan);
		if ( method.equals("add") ) {
			if ( implPlan.getId() != null ) return true;
		} else { return true; }
		return false;*/
	}

	@Override
	public List<ImplPlan> getImplPlansByAppId(String appId) {
		return implPlanDao.find("from ImplPlan where implPlanAppId = ?", new Object[]{ appId });
	}

	@Override
	public ImplPlan getImplPlan(String id) {
		return implPlanDao.get(ImplPlan.class, id);
	}

	@Override
	public boolean removeImplPlan(String id) {
		implPlanDao.executeHql("delete from ImplPlan where id = ?",new Object[]{id});
		Long qty = implPlanDao.count("select count(id) from  ImplPlan where id = ?",new Object[]{id});
		if ( qty > 0 ) {
			return false;
		}
		return true;
	}
	
	
}
