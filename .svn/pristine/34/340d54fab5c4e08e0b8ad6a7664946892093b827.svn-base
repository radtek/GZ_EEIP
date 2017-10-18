package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AnnualPlanAttDao;
import org.pangolin.eeip.entity.AnnualPlanAtt;
import org.pangolin.eeip.service.AnnualPlanAttService;
import org.springframework.stereotype.Service;

@Service("annualPlanAttService")
public class AnnualPlanAttServiceImpl implements AnnualPlanAttService {

	@Resource
	private AnnualPlanAttDao annualPlanAttDao;
	
	@Override
	public boolean saveAnnualPlanAtt(AnnualPlanAtt implPlanAtt) {
		String method = "";
		if ( implPlanAtt.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		annualPlanAttDao.saveOrUpdate(implPlanAtt);
		if ( method.equals("add") ) {
			if ( implPlanAtt.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeAnnualPlanAtt(String id) {
		annualPlanAttDao.executeHql("update AnnualPlanAtt set delFlag = ? where id = ?", new Object[] { AnnualPlanAtt.REMOVED, id });
		Long qty = annualPlanAttDao.count("select count(id) from AnnualPlanAtt where id = ? and delFlag = ?" , new Object[] { id, AnnualPlanAtt.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public void updateAnnualPlanAttStatus(String id) {
		annualPlanAttDao.executeHql("update AnnualPlanAtt set delFlag = ? where id = ?", new Object[] { AnnualPlanAtt.NORMAL, id } );
	}

	@Override
	public List<AnnualPlanAtt> getAnnualPlanAttsByAppId(String appId) {
		List<AnnualPlanAtt> list = annualPlanAttDao.find("from AnnualPlanAtt where delFlag = ? and annualPlanAppId = ?", new Object[] { AnnualPlanAtt.NORMAL, appId });
		return list;
	}

	@Override
	public AnnualPlanAtt getAnnualPlanAtt(String id) {
		return annualPlanAttDao.get(AnnualPlanAtt.class, id);
	}
}
