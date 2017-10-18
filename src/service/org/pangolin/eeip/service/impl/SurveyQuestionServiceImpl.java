package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.SurveyQuestionDao;
import org.pangolin.eeip.entity.SurveyQuestion;
import org.pangolin.eeip.service.SurveyQuestionService;

@SuppressWarnings("all")
public class SurveyQuestionServiceImpl implements SurveyQuestionService {

	@Resource
	private  SurveyQuestionDao surveyQuestionDao;
	
	public SurveyQuestion getSurveyQuestionById(String id) {
		return surveyQuestionDao.get(SurveyQuestion.class, id);
	}
	
	public Long getSurveySubjectQty(String surveySubjectId) {
		return surveyQuestionDao.count("select count(id) from SurveyQuestion where surveySubjectId = ?", new Object[] { surveySubjectId });
	}
	
	public List<SurveyQuestion> getSurveyQuestions(String surveySubjectId) {
		return surveyQuestionDao.find("from SurveyQuestion where surveySubjectId = ? order by sequenceNumber", new Object[] { surveySubjectId });
	}
	
	public boolean removeSurveyQuestion(String id) {
		surveyQuestionDao.executeHql("delete from SurveyQuestion where id = ?", new Object[] { id });
		Long qty = surveyQuestionDao.count("select count(id) from SurveyQuestion where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveSurveyQuestion(SurveyQuestion surveyQuestion) {
		String method = "";
		if ( surveyQuestion.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			surveyQuestion.setModifiedDate(new Date());
		}
		surveyQuestionDao.saveOrUpdate(surveyQuestion);
		if ( method.equals("add") ) {
			if ( surveyQuestion.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public List<SurveyQuestion> getSurveyQuestionsByWhere(String hql) {
		return surveyQuestionDao.find("from SurveyQuestion where 1=1 "+hql+" order by sequenceNumber", new Object[] {}); 
 	}

}