package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ImplPlanIaParticipantDao;
import org.pangolin.eeip.entity.ImplPlanIaParticipant;
import org.pangolin.eeip.service.ImplPlanIaParticipantService;
import org.springframework.stereotype.Service;

@Service("implPlanIaParticipantService")
@SuppressWarnings("all")
public class ImplPlanIaParticipantServiceImpl implements ImplPlanIaParticipantService {

	@Resource
	private ImplPlanIaParticipantDao implPlanIaParticipantDao;

	@Override
	public boolean saveImplPlanIaParticipant(ImplPlanIaParticipant iaParticipant) {
		implPlanIaParticipantDao.save(iaParticipant);
		return true;
		/*String method = "";
		if ( iaParticipant.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		implPlanIaParticipantDao.saveOrUpdate(iaParticipant);
		if ( method.equals("add") ) {
			if ( iaParticipant.getId() != null ) return true;
		} else { return true; }
		return false;*/
	}

	@Override
	public List<ImplPlanIaParticipant> getImplPlanIaParticipantsByAppId(String appId) {
		return implPlanIaParticipantDao.find("from ImplPlanIaParticipant where implPlanAppId = ?", new Object[]{ appId });
	}

	@Override
	public boolean removeImplPlanIaParticipant(String id) {
		implPlanIaParticipantDao.executeHql("delete from ImplPlanIaParticipant where id = ?", new Object[] { id });
		Long qty = implPlanIaParticipantDao.count("select count(id) from ImplPlanIaParticipant where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public boolean removeImplPlanIaParticipantByAppId(String appId) {
		implPlanIaParticipantDao.executeHql("delete from ImplPlanIaParticipant where implPlanAppId = ?", new Object[] { appId });
		List<ImplPlanIaParticipant> list = getImplPlanIaParticipantsByAppId(appId);
		if ( list == null && list.size() > 0 ) {
			return true;
		}
		return false;
	}
}
