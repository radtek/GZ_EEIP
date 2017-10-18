package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MgtRvwPlanAttDao;
import org.pangolin.eeip.entity.MgtRvwPlanAtt;
import org.pangolin.eeip.service.MgtRvwPlanAttService;
import org.springframework.stereotype.Service;

@Service("mgtRvwPlanAttService")
public class MgtRvwPlanAttServiceImpl implements MgtRvwPlanAttService {

	@Resource
	private MgtRvwPlanAttDao mgtRvwPlanAttDao;
	
	@Override
	public boolean saveMgtRvwPlanAtt(MgtRvwPlanAtt implPlanAtt) {
		String method = "";
		if ( implPlanAtt.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		mgtRvwPlanAttDao.saveOrUpdate(implPlanAtt);
		if ( method.equals("add") ) {
			if ( implPlanAtt.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMgtRvwPlanAtt(String id) {
		mgtRvwPlanAttDao.executeHql("update MgtRvwPlanAtt set delFlag = ? where id = ?", new Object[] { MgtRvwPlanAtt.REMOVED, id });
		Long qty = mgtRvwPlanAttDao.count("select count(id) from MgtRvwPlanAtt where id = ? and delFlag = ?" , new Object[] { id, MgtRvwPlanAtt.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public void updateMgtRvwPlanAttStatus(String id) {
		mgtRvwPlanAttDao.executeHql("update MgtRvwPlanAtt set delFlag = ? where id = ?", new Object[] { MgtRvwPlanAtt.NORMAL, id } );
	}

	@Override
	public List<MgtRvwPlanAtt> getMgtRvwPlanAttByAppId(String appId) {
		List<MgtRvwPlanAtt> list = mgtRvwPlanAttDao.find("from MgtRvwPlanAtt where delFlag = ? and mgtRvwPlanAppId = ?", new Object[] { MgtRvwPlanAtt.NORMAL, appId });
		return list;
	}

	@Override
	public MgtRvwPlanAtt getMgtRvwPlanAtt(String id) {
		return mgtRvwPlanAttDao.get(MgtRvwPlanAtt.class, id);
	}
}
