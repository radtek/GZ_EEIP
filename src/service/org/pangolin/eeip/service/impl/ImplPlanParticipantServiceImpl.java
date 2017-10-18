package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ImplPlanParticipantDao;
import org.pangolin.eeip.entity.ImplPlanParticipant;
import org.pangolin.eeip.service.ImplPlanParticipantService;
import org.springframework.stereotype.Service;

@Service("implPlanParticipantService")
@SuppressWarnings("all")
public class ImplPlanParticipantServiceImpl implements ImplPlanParticipantService {

	@Resource
	private ImplPlanParticipantDao implPlanParticipantDao;

	@Override
	public boolean saveImplPlanParticipant(ImplPlanParticipant participant) {
		implPlanParticipantDao.save(participant);
		return true;
		/*String method = "";
		if ( participant.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		implPlanParticipantDao.saveOrUpdate(participant);
		if ( method.equals("add") ) {
			if ( participant.getId() != null ) return true;
		} else { return true; }
		return false;*/
	}

	@Override
	public List<ImplPlanParticipant> getImplPlanParticipantsByAppId(String appId) {
		return implPlanParticipantDao.find("from ImplPlanParticipant where implPlanAppId = ?", new Object[]{ appId });
	}

	@Override
	public boolean removeImplPlanParticipant(String id) {
		implPlanParticipantDao.executeHql("delete from ImplPlanParticipant where id = ?", new Object[] { id });
		Long qty = implPlanParticipantDao.count("select count(id) from ImplPlanParticipant where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public boolean removeImplPlanParticipantByAppId(String appId) {
		implPlanParticipantDao.executeHql("delete from ImplPlanParticipant where implPlanAppId = ?", new Object[] { appId });
		List<ImplPlanParticipant> list = getImplPlanParticipantsByAppId(appId);
		if ( list == null || list.size() == 0 ) {
			return true;
		}
		return false;
	}
}
