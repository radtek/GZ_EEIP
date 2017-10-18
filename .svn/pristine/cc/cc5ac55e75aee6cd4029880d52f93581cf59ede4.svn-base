package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalDao;
import org.pangolin.eeip.dao.AppraisalHistoryDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.AppraisalHistory;
import org.pangolin.eeip.service.AppraisalHistoryService;
import org.springframework.stereotype.Service;

@Service("appraisalHistoryService")
@SuppressWarnings("all")
public class AppraisalHistoryServiceImpl implements AppraisalHistoryService{

	@Resource
	private AppraisalHistoryDao appraisalHistoryDao;
	@Resource
	private AppraisalDao appraisalDao;
	
	 //根据ID查询
	@Override
	public AppraisalHistory getAppraisalHistoryById(String id) {
		return appraisalHistoryDao.get(AppraisalHistory.class, id);
	}
	
	//获取总数量
	@Override
	public Long getAppraisalHistoryQty() {
		return appraisalHistoryDao.count("select count(id) from AppraisalHistory");
	} 
	
	//获取总集合
	@Override
	public List<AppraisalHistory> getAppraisalHistorys() {
		return appraisalHistoryDao.find("from AppraisalHistory order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<AppraisalHistory> getAppraisalHistorys(int startIndex, int rows, String sorter, String sortingAttribute) {
		return appraisalHistoryDao.search("from AppraisalHistory order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeAppraisalHistory(String id) {
		appraisalHistoryDao.executeHql("delete from AppraisalHistory where id = ?", new Object[] { id });
		Long qty = appraisalHistoryDao.count("select count(id) from AppraisalHistory where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean saveAppraisalHistory(AppraisalHistory appraisalHistory) {
		try {
			String id = appraisalHistory.getId();
 			Long qty = appraisalHistoryDao.count("select count(id) from AppraisalHistory where id=?", new Object[] {id});
 			if (qty > 0) {    
 				appraisalHistoryDao.update(appraisalHistory);
			} else {  
				appraisalHistoryDao.save(appraisalHistory);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public AppraisalHistory saveAppraisalToHistory(AppraisalHistory appraisalHistory, String appraisalId) {
		Appraisal appraisal = appraisalDao.get(Appraisal.class, appraisalId);
		if(appraisal != null){
			appraisalHistory.setCreatedDate(new Date());
			
			appraisalHistory.setAssignerAlias(appraisal.getAssignerAlias());
			appraisalHistory.setAssignerId(appraisal.getAssignerId());
			appraisalHistory.setAssignerName(appraisal.getAssignerName());
			appraisalHistory.setAllocationDate(appraisal.getAllocationDate());
			appraisalHistory.setPlanedStartDate(appraisal.getPlanedStartDate());
			appraisalHistory.setPlanedEndDate(appraisal.getPlanedEndDate());
			appraisalHistory.setMajor(appraisal.getMajor());
			appraisalHistory.setAppraiserId(appraisal.getAppraiserId());
			appraisalHistory.setAppraiserAlias(appraisal.getAppraiserAlias());
			appraisalHistory.setAppraiserMp(appraisal.getAppraiserMp());
			appraisalHistory.setAppraiserName(appraisal.getAppraiserName());
			
			appraisalHistory.setCollectorAlias(appraisal.getCollectorAlias());
			appraisalHistory.setCollectorId(appraisal.getCollectorId());
			appraisalHistory.setCollectorName(appraisal.getCollectorName());
			appraisalHistory.setCollectedDate(appraisal.getCollectedDate());
			
			appraisalHistory.setVideoPath(appraisal.getVideoPath());
			appraisalHistory.setLocation(appraisal.getLocation());
			appraisalHistory.setProcess(appraisal.getProcess());
			appraisalHistory.setAntivirusResult(appraisal.getAntivirusResult());
			appraisalHistory.setAppraisalResult(appraisal.getAppraisalResult());
			appraisalHistory.setRemarks(appraisal.getRemarks());
			appraisalHistory.setAppraisedStartDate(appraisal.getAppraisedStartDate());
			appraisalHistory.setAppraisedEndDate(appraisal.getAppraisedEndDate());
			
			appraisalHistory.setReturnerId(appraisal.getReturnerId());
			appraisalHistory.setReturnerAlias(appraisal.getReturnerAlias());
			appraisalHistory.setReturnerName(appraisal.getReturnerName());
			appraisalHistory.setReturnedDate(appraisal.getReturnedDate());
			
			appraisalHistory.setReviewer(appraisal.getReviewer());
			appraisalHistory.setReviewerdDate(appraisal.getReviewerdDate());
			appraisalHistory.setIssuedForm(appraisal.getIssuedForm());
			appraisalHistory.setAtt(appraisal.getAtt());
			appraisalHistory.setAttOther(appraisal.getAttOther());
			appraisalHistory.setVerifierAlias(appraisal.getVerifierAlias());
			appraisalHistory.setVerifierId(appraisal.getVerifierId());
			appraisalHistory.setVerifierName(appraisal.getVerifierName());
			appraisalHistory.setSitnJudgement(appraisal.getSitnJudgement());
			appraisalHistory.setVerifierOpinion(appraisal.getVerifierOpinion());
			appraisalHistory.setVerifiedDate(appraisal.getVerifiedDate());
			appraisalHistory.setApprovedDate(appraisal.getApprovedDate());
			appraisalHistory.setApproverAlias(appraisal.getApproverAlias());
			appraisalHistory.setApproverId(appraisal.getApproverId());
			appraisalHistory.setApproverName(appraisal.getApproverName());
			appraisalHistory.setApproverOpinion(appraisal.getApproverName());
			appraisalHistory.setComments(appraisal.getComments());
		}
		return appraisalHistory;
	}
	 
}
