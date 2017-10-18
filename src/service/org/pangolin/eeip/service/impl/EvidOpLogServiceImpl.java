package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.EvidOpLogDao;
import org.pangolin.eeip.entity.EvidOpLog;
import org.pangolin.eeip.service.EvidOpLogService;
import org.springframework.stereotype.Service;

@Service("evidOpLogService")
@SuppressWarnings("all")
public class EvidOpLogServiceImpl implements EvidOpLogService{

	@Resource
	private EvidOpLogDao evidOpLogDao;
	
	@Override
	public EvidOpLog getEvidOpLogById(String id) {
		return evidOpLogDao.get(EvidOpLog.class, id);
	}

	@Override
	public List<EvidOpLog> getEvidOpLogsByEvidId(String evidId) {
		return evidOpLogDao.find("from EvidOpLog where evidId =? ", new Object[]{evidId});
	}

	@Override
	public boolean saveEvidOpLog(EvidOpLog evidOpLog) {
		try {
			String id = evidOpLog.getId();
 			Long qty = evidOpLogDao.count("select count(id) from EvidOpLog where id=?", new Object[] {id}); 
 			if (qty > 0) {    
 				evidOpLogDao.update(evidOpLog);
			} else {  
				evidOpLogDao.save(evidOpLog);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true; 
	}

	@Override
	public EvidOpLog getEvidOpLogByEvidIdAndSpLabel(String evidId, Integer spLabel) {
		return evidOpLogDao.get("from EvidOpLog where evidId =?  and spLabel =?", new Object[]{evidId,spLabel});
	}
	
	@Override
	public EvidOpLog getEvidOpLogByEvidEvidIdAndType(String evidId,Integer type) {
		List<EvidOpLog> result =  evidOpLogDao.find(" from EvidOpLog where evidId =? and type = ? order by createdDate desc ", new Object[]{ evidId , type });
		if(result.size() > 0){
			return result.get(0);
		} 
		return new EvidOpLog();
	}

}
