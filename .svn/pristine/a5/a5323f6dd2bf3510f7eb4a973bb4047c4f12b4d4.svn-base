package org.pangolin.eeip.service.impl;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalSitnDao;
import org.pangolin.eeip.entity.AppraisalSitn;
import org.pangolin.eeip.service.AppraisalSitnService;
import org.springframework.stereotype.Service;

@Service("appraisalSitnService")
@SuppressWarnings("all")
public class AppraisalSitnServiceImpl implements AppraisalSitnService {

	@Resource
	private AppraisalSitnDao appraisalSitnDao;
 

	@Override
	public AppraisalSitn getAppraisalSitnById(String id) {
		return appraisalSitnDao.get(AppraisalSitn.class, id);
	}

	@Override
	public boolean saveAppraisalSitn(AppraisalSitn appraisalSitn) {
		try {
			String id = appraisalSitn.getId();
 			Long qty = appraisalSitnDao.count("select count(id) from AppraisalSitn where id=?", new Object[] {id}); 
 			if (qty > 0) {    
 				appraisalSitnDao.update(appraisalSitn);
			} else {  
				appraisalSitnDao.save(appraisalSitn);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public boolean removeAppraisalSitn(String id) {
		appraisalSitnDao.executeHql("delete from AppraisalSitn where id = ?", new Object[] { id });
		Long qty = appraisalSitnDao.count("select count(id) from AppraisalSitn where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public AppraisalSitn getAppraisalSitnByAppraisalId(String appraisalId) {
		AppraisalSitn sitn = null;
		sitn = appraisalSitnDao.get(" from AppraisalSitn where appraisalId = ? ", new Object[]{appraisalId});
		return sitn;
	}

}
