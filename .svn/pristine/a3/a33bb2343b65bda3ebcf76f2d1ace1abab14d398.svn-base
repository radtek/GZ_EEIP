package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.QuestionItemDao;
import org.pangolin.eeip.entity.QuestionItem;
import org.pangolin.eeip.service.QuestionItemService;

@SuppressWarnings("all")
public class QuestionItemServiceImpl implements QuestionItemService {

	@Resource
	private  QuestionItemDao questionItemDao;
	
	public QuestionItem getQuestionItemById(String id) {
		return questionItemDao.get(QuestionItem.class, id);
	}
	
	public List<QuestionItem> getQuestionItems(String surveyQuestionId) {
		return questionItemDao.find("from QuestionItem where surveyQuestionId = ? order by sequenceNumber", new Object[] { surveyQuestionId });
	}
	
	public boolean removeQuestionItem(String id) {
		questionItemDao.executeHql("delete from QuestionItem where id = ?", new Object[] { id });
		Long qty = questionItemDao.count("select count(id) from QuestionItem where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveQuestionItem(QuestionItem questionItem) {
		String method = "";
		if ( questionItem.getId() == null ) { method = "add"; }
		else { method = "update"; }
		questionItemDao.saveOrUpdate(questionItem);
		if ( method.equals("add") ) {
			if ( questionItem.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public List<QuestionItem> getQuestionItemsByWhere(String hql) {
		return questionItemDao.find("from QuestionItem where 1=1 "+hql+" order by sequenceNumber", new Object[] {});
	}

	@Override
	public List<QuestionItem> getQuestionItemsBysurveySubjectId(String surveySubjectId) {
		return questionItemDao.find("from QuestionItem where surveySubjectId = ? order by sequenceNumber", new Object[] { surveySubjectId });	} 
}