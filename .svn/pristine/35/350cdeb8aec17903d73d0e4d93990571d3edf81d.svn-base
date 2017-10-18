package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AnnualPlanAppDao;
import org.pangolin.eeip.dao.AnnualPlanAttDao;
import org.pangolin.eeip.entity.AnnualPlanApp;
import org.pangolin.eeip.entity.AnnualPlanAtt;
import org.pangolin.eeip.service.AnnualPlanAppService;
import org.springframework.stereotype.Service;

@Service("annualPlanAppService")
public class AnnualPlanAppServiceImpl implements AnnualPlanAppService {

	@Resource(name = "annualPlanAppDao")
	private AnnualPlanAppDao annualPlanAppDao;
	
	@Resource
	private AnnualPlanAttDao annualPlanAttDao;
	
	@Override
	public boolean saveAnnualPlanApp(AnnualPlanApp annualPlanApp) {
		Long qty = annualPlanAppDao.count("select count(id) from AnnualPlanApp where id = ?", new Object[]{ annualPlanApp.getId() }) ;
		if ( qty > 0 ) {
			annualPlanApp.setModifiedDate(new Date());
			annualPlanAppDao.update(annualPlanApp);
		} else {
			annualPlanAppDao.save(annualPlanApp);
		}
		
		return true;
	}

	@Override
	public boolean removeAnnualPlanApp(String id) {
		annualPlanAppDao.executeHql("delete from AnnualPlanApp where id = ?", new Object[] { id });
		Long qty = annualPlanAppDao.count("select count(id) from AnnualPlanApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeAnnualPlanAppFalse(String id) {
		annualPlanAppDao.executeHql("update AnnualPlanApp set delFlag = ? where id = ?", new Object[] { AnnualPlanApp.REMOVED, id });
		Long qty = annualPlanAppDao.count("select count(id) from AnnualPlanApp where id = ? and delFlag = ? " , new Object[] { id, AnnualPlanApp.NORMAL });
		if ( qty.intValue() == 0 ) {
			annualPlanAttDao.executeHql("update AnnualPlanAtt set delFlag = ? where annualPlanAppId = ?", new Object[] { AnnualPlanAtt.REMOVED, id });
			return true;
		}
		return false;
	}

	@Override
	public AnnualPlanApp getAnnualPlanAppById(String id) {
		return annualPlanAppDao.get(AnnualPlanApp.class, id);
	}

	@Override
	public Long getAnnualPlanAppQty(String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			return annualPlanAppDao.count("select count(id) from AnnualPlanApp where delFlag = ? and title like ?", new Object[]{ AnnualPlanApp.NORMAL,queryParam });
		}
		return annualPlanAppDao.count("select count(id) from AnnualPlanApp where delFlag = ? ", new Object[]{ AnnualPlanApp.NORMAL });
	}

	@Override
	public List<AnnualPlanApp> getAnnualPlanApps() {
		return annualPlanAppDao.find("from AnnualPlanApp where delFlag = ? order by createdDate desc", new Object[]{ AnnualPlanApp.NORMAL });
	}

	@Override
	public List<AnnualPlanApp> getAnnualPlanApps(int startIndex, int rows, String sorter,String sortingAttribute,String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			return annualPlanAppDao.search("from AnnualPlanApp where delFlag = ? and title like ? order by " + sorter + " " + sortingAttribute, new Object[] { AnnualPlanApp.NORMAL, queryParam }, startIndex, rows);
		}
		return annualPlanAppDao.search("from AnnualPlanApp where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { AnnualPlanApp.NORMAL }, startIndex, rows);
	}
}
