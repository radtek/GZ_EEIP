package org.pangolin.eeip.service.impl;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalHistoryDao;
import org.pangolin.eeip.dao.AppraisalItemDao;
import org.pangolin.eeip.entity.AppraisalItem;
import org.pangolin.eeip.service.AppraisalItemService;
import org.springframework.stereotype.Service;

@Service("appraisalItemService")
@SuppressWarnings("all")
public class AppraisalItemServiceImpl  implements AppraisalItemService{

	@Resource
	private AppraisalItemDao appraisalItemDao;
	
	@Override
	public AppraisalItem getAppraisalItemById(String id) {
		return appraisalItemDao.get(AppraisalItem.class, id);
	}

	@Override
	public boolean saveAppraisalItem(AppraisalItem appraisalItem) {
		try {
			String id = appraisalItem.getId();
 			Long qty = appraisalItemDao.count("select count(id) from AppraisalItem where id=?", new Object[] {id});
 			if (qty > 0) {    
 				appraisalItemDao.update(appraisalItem);
			} else {  
				appraisalItemDao.save(appraisalItem);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public AppraisalItem getAppraisalItemByReviseId(String appraisalReviseId) {
 		return appraisalItemDao.get(" from AppraisalItem  where appraisalReviseId =?", new Object[]{appraisalReviseId});
	}

}
