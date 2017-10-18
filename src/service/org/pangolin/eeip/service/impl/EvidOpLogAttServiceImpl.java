package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.EvidOpLogAttDao;
import org.pangolin.eeip.entity.EvidOpLogAtt;
import org.pangolin.eeip.service.EvidOpLogAttService;
import org.springframework.stereotype.Service;


@Service("evidOpLogAttService")
@SuppressWarnings("all")
public class EvidOpLogAttServiceImpl implements EvidOpLogAttService {

	@Resource
	private EvidOpLogAttDao evidOpLogAttDao;
	
	@Override
	public List<EvidOpLogAtt> getEvidOpLogAttByPreappraisalId(String appraisalId) {
		return evidOpLogAttDao.find("from EvidOpLogAtt where appraisalId =? ", new Object[]{appraisalId});
	}

	@Override
	public boolean saveEvidOpLogAtt(EvidOpLogAtt evidOpLogAtt) {
		String method = "";
		if ( evidOpLogAtt.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		evidOpLogAttDao.saveOrUpdate(evidOpLogAtt);
		if ( method.equals("add") ) {
			if ( evidOpLogAtt.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public List<EvidOpLogAtt> getEvidOpLogAttByEvidOpLogId(String evidOpLogId) {
		return evidOpLogAttDao.find("from EvidOpLogAtt where evidOpLogId =? ", new Object[]{evidOpLogId});
	}

	@Override
	public EvidOpLogAtt getEvidOpLogAttById(String id) {
		return evidOpLogAttDao.get(EvidOpLogAtt.class,id);
	}

	@Override
	public List<EvidOpLogAtt> getEvidOpLogAttByEvidenceId(String evidenceId) {
		return evidOpLogAttDao.find("from EvidOpLogAtt where evidId =? ", new Object[]{evidenceId});
	}

	@Override
	public boolean removeEvidOpLogAttById(String id) {
		evidOpLogAttDao.executeHql("delete from EvidOpLogAtt where id = ?", new Object[] { id });
		Long qty = evidOpLogAttDao.count("select count(id) from EvidOpLogAtt where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

}
