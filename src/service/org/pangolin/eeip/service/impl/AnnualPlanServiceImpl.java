package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AnnualPlanDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.service.AnnualPlanService;
import org.springframework.stereotype.Service;

@Service("annualPlanService")
public class AnnualPlanServiceImpl implements AnnualPlanService {

	@Resource(name = "annualPlanDao")
	private AnnualPlanDao annualPlanDao;
	
	@Override
	public boolean saveAnnualPlan(AnnualPlan annualPlan) {
		String method = "";
		if ( annualPlan.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			annualPlan.setModifiedDate(new Date());
		}
		annualPlanDao.saveOrUpdate(annualPlan);
		if ( method.equals("add") ) {
			if ( annualPlan.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeAnnualPlan(String id) {
		annualPlanDao.executeHql("delete from AnnualPlan where id = ?", new Object[] { id });
		Long qty = annualPlanDao.count("select count(id) from AnnualPlan where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}


	@Override
	public AnnualPlan getAnnualPlanById(String id) {
		return annualPlanDao.get(AnnualPlan.class, id);
	}

	@Override
	public Long getAnnualPlanQty() {
		return annualPlanDao.count("select count(id) from AnnualPlan ", new Object[]{  });
	}

	@Override
	public List<AnnualPlan> getAnnualPlans() {
		return annualPlanDao.find("from AnnualPlan order by createdDate desc", new Object[]{  });
	}

	@Override
	public List<AnnualPlan> getAnnualPlans(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return annualPlanDao.search("from AnnualPlan order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	@Override
	public List<AnnualPlan> getAnnualPlansByAppId(String annualPlanAppId) {
		return annualPlanDao.find("from AnnualPlan where annualPlanAppId = ? order by createdDate", new Object[] { annualPlanAppId });
	}
}
