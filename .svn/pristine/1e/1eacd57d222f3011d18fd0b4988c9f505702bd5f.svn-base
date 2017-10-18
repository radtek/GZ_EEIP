package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import org.pangolin.eeip.dao.EvidenceDao;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("evidenceService")
@SuppressWarnings("all")
public class EvidenceServiceImpl implements EvidenceService{

	@Autowired
	private EvidenceDao evidenceDao;
	
	// 根据ID查询
	public Evidence getEvidenceById(String id) {
		return evidenceDao.get(Evidence.class, id);
	}
	

	@Override
	public Evidence getEvidenceByAppraisalId(String appraisalId) {
		return evidenceDao.get(" from Evidence  where appraisalId =?", new Object[]{appraisalId});
	}

	// 获取总数量
	public Long getEvidenceQty() {
		return evidenceDao.count("select count(id) from Evidence  ");
	}

	// 获取总集合
	public List<Evidence> getEvidences() {
		return evidenceDao.find("from Evidence  order by createdDate desc");
	}

	// 数据删除
	public boolean removeEvidence(String id) {
		evidenceDao.executeHql("delete from Evidence where id = ?", new Object[] { id });
		Long qty = evidenceDao.count("select count(id) from Evidence where id = ?", new Object[] { id });
		if (qty.intValue() == 0)
			return true;
		return false;
	}

	// 数据修改或保存
	public boolean saveEvidence(Evidence evidence) {
		try {
			String id = evidence.getId();
 			Long qty = evidenceDao.count("select count(id) from Evidence where id=?", new Object[] {id}); 
 			if (qty > 0) {    
 				evidence.setModifiedDate(new Date());
 				evidenceDao.update(evidence);
			} else {   
				evidenceDao.save(evidence);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true; 
	}

	@Override
	public List<Evidence> getEvidencesByAppraisalId(String appraisalId) {
		return evidenceDao.find("from Evidence where appraisalId=? order by createdDate desc",
				new Object[] { appraisalId });
	}


	@Override
	public Evidence getEvidenceByEvidId(String evidId) {
		return evidenceDao.get(" from Evidence  where evidId =?", new Object[]{evidId});
	}
}
