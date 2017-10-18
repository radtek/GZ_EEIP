package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ImplPlanAttDao;
import org.pangolin.eeip.entity.ImplPlanAtt;
import org.pangolin.eeip.service.ImplPlanAttService;
import org.springframework.stereotype.Service;

@Service("implPlanAttService")
public class ImplPlanAttServiceImpl implements ImplPlanAttService {
	
	@Resource
	private ImplPlanAttDao implPlanAttDao;

	@Override
	public boolean saveImplPlanAtt(ImplPlanAtt implPlanAtt) {
		String method = "";
		if ( implPlanAtt.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		implPlanAttDao.saveOrUpdate(implPlanAtt);
		if ( method.equals("add") ) {
			if ( implPlanAtt.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeImplPlanAtt(String id) {
		implPlanAttDao.executeHql("update ImplPlanAtt set delFlag = ? where id = ?", new Object[] { ImplPlanAtt.REMOVED, id });
		Long qty = implPlanAttDao.count("select count(id) from ImplPlanAtt where id = ? and delFlag = ?" , new Object[] { id, ImplPlanAtt.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public void updateImplPlanAttStatus(String id) {
		implPlanAttDao.executeHql("update ImplPlanAtt set delFlag = ? where id = ?", new Object[] { ImplPlanAtt.NORMAL, id } );
	}

	@Override
	public List<ImplPlanAtt> getImplPlanAttsByAppId(String appId) {
		List<ImplPlanAtt> list = implPlanAttDao.find("from ImplPlanAtt where delFlag = ? and implPlanAppId = ?", new Object[] { ImplPlanAtt.NORMAL, appId });
		return list;
	}

	@Override
	public ImplPlanAtt getImplPlanAtt(String id) {
		return implPlanAttDao.get(ImplPlanAtt.class, id);
	}

	
}
