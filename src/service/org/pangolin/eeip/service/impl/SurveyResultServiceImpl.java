package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import org.pangolin.eeip.dao.SurveyResultDao;
import org.pangolin.eeip.entity.SurveyResult;
import org.pangolin.eeip.service.SurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("all")
public class SurveyResultServiceImpl implements SurveyResultService {

	@Autowired
	private SurveyResultDao surveyResultDao;
	
	@Override
	public SurveyResult getSurveyResultById(String id) {
 		return surveyResultDao.get(SurveyResult.class, id) ;
	}

	@Override
	public List<SurveyResult> getSurveyResultsBySubject(String surveyResultId) {
         return surveyResultDao.find(" from SurveyResult where surveyResultId = ? order by submittedDate ", new Object[] {surveyResultId});
	}

	@Override
	public List<SurveyResult> getSurveyResultsByrespondentId(String respondentId) { 
        return surveyResultDao.find(" from SurveyResult where respondentId = ? order by submittedDate ", new Object[] {respondentId});
	}

	@Override
	public List<SurveyResult> getSurveyResults(int startIndex, int rows, String sorter, String sortingAttribute) {
		return surveyResultDao.search("from SurveyResult order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
 	}

	@Override
	public Long getSurveyResultQty() {
 		return surveyResultDao.count("select count(id) from SurveyResult")  ;
	}

	@Override
	public List<SurveyResult> getSurveyResults() {
        return surveyResultDao.find(" from SurveyResult  order by submittedDate ");
	}

	@Override
	public List<SurveyResult> getSurveyResultsByWhere(String hql) {
 	    return surveyResultDao.find(" from SurveyResult where 1=1 "+hql+"  order by submittedDate ");
	}

	@Override
	public Long getSurveyResultsQtyByWhere(String hql) {
        return surveyResultDao.count("select count(id)  from SurveyResult where 1=1 "+hql+"  order by submittedDate ");
	}

	@Override
	public boolean saveSurveyResult(SurveyResult surveyResult) {
		String method = "";
		if ( surveyResult.getId() == null ) { method = "add"; }
		else { 
			method = "update"; 
		}
		surveyResultDao.saveOrUpdate(surveyResult);
		if ( method.equals("add") ) {
			if ( surveyResult.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeSurveyResult(String id) {
		surveyResultDao.executeHql("delete from SurveyResult where id = ?", new Object[] { id });
		Long qty = surveyResultDao.count("select count(id) from SurveyResult where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

}
