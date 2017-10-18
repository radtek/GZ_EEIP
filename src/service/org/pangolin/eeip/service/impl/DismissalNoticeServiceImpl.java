package org.pangolin.eeip.service.impl;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DismissalNoticeDao;
import org.pangolin.eeip.entity.DismissalNotice;
import org.pangolin.eeip.service.DismissalNoticeService;
import org.springframework.stereotype.Service;

@Service
public class DismissalNoticeServiceImpl implements DismissalNoticeService{

	@Resource
	private DismissalNoticeDao dismissalNoticeDao;
	
	@Override
	public boolean saveDismissalNotice(DismissalNotice dismissalNotice) {
		try {
			String id = dismissalNotice.getId();
 			Long qty = dismissalNoticeDao.count("select count(id) from DismissalNotice where id=?", new Object[] {id}); 
 			if (qty > 0) {    
 				dismissalNoticeDao.update(dismissalNotice);
			} else {  
				dismissalNoticeDao.save(dismissalNotice);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true; 
	}

	@Override
	public DismissalNotice getDismissalNoticeByAppraisalId(String appraisalId) {
 		return dismissalNoticeDao.get(" from DismissalNotice where appraisalId = ?", new Object[]{appraisalId});
	}

	@Override
	public DismissalNotice getDismissalNoticeById(String id) {
		return dismissalNoticeDao.get(DismissalNotice.class, id) ;
	}

}
