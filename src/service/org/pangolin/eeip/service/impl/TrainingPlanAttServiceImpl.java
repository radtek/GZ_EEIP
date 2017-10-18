package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.TrainingPlanAttDao;
import org.pangolin.eeip.entity.TrainingPlanAtt;
import org.pangolin.eeip.service.TrainingPlanAttService;
import org.springframework.stereotype.Service;

@Service("trainingPlanAttService")
public class TrainingPlanAttServiceImpl implements TrainingPlanAttService {

	@Resource
	private TrainingPlanAttDao trainingPlanAttDao;
	
	@Override
	public boolean saveTrainingPlanAtt(TrainingPlanAtt implPlanAtt) {
		String method = "";
		if ( implPlanAtt.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		trainingPlanAttDao.saveOrUpdate(implPlanAtt);
		if ( method.equals("add") ) {
			if ( implPlanAtt.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeTrainingPlanAtt(String id) {
		trainingPlanAttDao.executeHql("update TrainingPlanAtt set delFlag = ? where id = ?", new Object[] { TrainingPlanAtt.REMOVED, id });
		Long qty = trainingPlanAttDao.count("select count(id) from TrainingPlanAtt where id = ? and delFlag = ?" , new Object[] { id, TrainingPlanAtt.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public void updateTrainingPlanAttStatus(String id) {
		trainingPlanAttDao.executeHql("update TrainingPlanAtt set delFlag = ? where id = ?", new Object[] { TrainingPlanAtt.NORMAL, id } );
	}

	@Override
	public List<TrainingPlanAtt> getTrainingPlanAttsByAppId(String appId) {
		List<TrainingPlanAtt> list = trainingPlanAttDao.find("from TrainingPlanAtt where delFlag = ? and trainingPlanAppId = ?", new Object[] { TrainingPlanAtt.NORMAL, appId });
		return list;
	}

	@Override
	public TrainingPlanAtt getTrainingPlanAtt(String id) {
		return trainingPlanAttDao.get(TrainingPlanAtt.class, id);
	}
}
