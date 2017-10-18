package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.TrainingPlanAppDao;
import org.pangolin.eeip.dao.TrainingPlanAttDao;
import org.pangolin.eeip.entity.TrainingPlanApp;
import org.pangolin.eeip.entity.TrainingPlanAtt;
import org.pangolin.eeip.service.TrainingPlanAppService;
import org.springframework.stereotype.Service;

@Service("trainingPlanAppService")
public class TrainingPlanAppServiceImpl implements TrainingPlanAppService {

	@Resource
	private TrainingPlanAppDao trainingPlanAppDao;
	
	@Resource
	private TrainingPlanAttDao trainingPlanAttDao;
	
	@Override
	public boolean saveTrainingPlanApp(TrainingPlanApp annualPlanApp) {
		Long qty = trainingPlanAppDao.count("select count(id) from TrainingPlanApp where id = ?", new Object[]{ annualPlanApp.getId() }) ;
		if ( qty > 0 ) {
			annualPlanApp.setModifiedDate(new Date());
			trainingPlanAppDao.update(annualPlanApp);
		} else {
			trainingPlanAppDao.save(annualPlanApp);
		}
		
		return true;
	}

	@Override
	public boolean removeTrainingPlanApp(String id) {
		trainingPlanAppDao.executeHql("delete from TrainingPlanApp where id = ?", new Object[] { id });
		Long qty = trainingPlanAppDao.count("select count(id) from TrainingPlanApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeTrainingPlanAppFalse(String id) {
		trainingPlanAppDao.executeHql("update TrainingPlanApp set delFlag = ? where id = ?", new Object[] { TrainingPlanApp.REMOVED, id });
		Long qty = trainingPlanAppDao.count("select count(id) from TrainingPlanApp where id = ? and delFlag = ? " , new Object[] { id, TrainingPlanApp.NORMAL });
		if ( qty.intValue() == 0 ){
			trainingPlanAttDao.executeHql("update TrainingPlanAtt set delFlag = ? where trainingPlanAppId = ?", new Object[] { TrainingPlanAtt.REMOVED, id });
			return true;
		}
		return false;
	}

	@Override
	public TrainingPlanApp getTrainingPlanAppById(String id) {
		return trainingPlanAppDao.get(TrainingPlanApp.class, id);
	}

	@Override
	public Long getTrainingPlanAppQty(String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			return trainingPlanAppDao.count("select count(id) from TrainingPlanApp where delFlag = ? and title like ?", new Object[]{ TrainingPlanApp.NORMAL,queryParam });
		}
		return trainingPlanAppDao.count("select count(id) from TrainingPlanApp where delFlag = ? ", new Object[]{ TrainingPlanApp.NORMAL });
	}

	@Override
	public List<TrainingPlanApp> getTrainingPlanApps() {
		return trainingPlanAppDao.find("from TrainingPlanApp where delFlag = ? order by createdDate desc", new Object[]{ TrainingPlanApp.NORMAL });
	}

	@Override
	public List<TrainingPlanApp> getTrainingPlanApps(int startIndex, int rows, String sorter,String sortingAttribute,String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			return trainingPlanAppDao.search("from TrainingPlanApp where delFlag = ? and title like ? order by " + sorter + " " + sortingAttribute, new Object[] { TrainingPlanApp.NORMAL, queryParam }, startIndex, rows);
		}
		return trainingPlanAppDao.search("from TrainingPlanApp where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { TrainingPlanApp.NORMAL }, startIndex, rows);
	}
}
