package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalAcptAttDao;
import org.pangolin.eeip.entity.AppraisalAcptAtt;
import org.pangolin.eeip.service.AppraisalAcptAttService;
import org.springframework.stereotype.Service;

@Service("appraisalAcptAttService")
@SuppressWarnings("all")
public class AppraisalAcptAttServiceImpl implements AppraisalAcptAttService {

	@Resource
	private AppraisalAcptAttDao appraisalAcptAttDao;
	
	@Override
	public AppraisalAcptAtt getAppraisalAcptAttById(String id) {
		return appraisalAcptAttDao.get(AppraisalAcptAtt.class, id);
	}

	@Override
	public List<AppraisalAcptAtt> getAppraisalAcptAttsByAppraisalId(String appraisalId) {
		return appraisalAcptAttDao.find("from AppraisalAcptAtt where appraisalId=?", new Object[]{appraisalId});
	}

	@Override
	public boolean saveAppraisalAcptAtt(AppraisalAcptAtt appraisalAcptAtt) {
		String method = "";
		if ( appraisalAcptAtt.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		appraisalAcptAttDao.saveOrUpdate(appraisalAcptAtt);
		if ( method.equals("add") ) {
			if ( appraisalAcptAtt.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public AppraisalAcptAtt getAppraisalAcptAttData(String appraisalId) {
		List<AppraisalAcptAtt> list = appraisalAcptAttDao.find("from AppraisalAcptAtt where appraisalId = ?", new Object[]{ appraisalId });
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean removeAppraisalAcptAttData(String id) {
		appraisalAcptAttDao.executeHql("delete from AppraisalAcptAtt where id = ?", new Object[] { id });
		Long qty = appraisalAcptAttDao.count("select count(id) from AppraisalAcptAtt where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false; 
	}

}
