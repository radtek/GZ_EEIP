package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.SurveySubjectDao;
import org.pangolin.eeip.entity.SurveySubject;
import org.pangolin.eeip.service.SurveySubjectService;

@SuppressWarnings("all")
public class SurveySubjectServiceImpl implements SurveySubjectService {

	@Resource
	private  SurveySubjectDao surveySubjectDao;
	
	public SurveySubject getSurveySubjectById(String id) {
		return surveySubjectDao.get(SurveySubject.class, id);
	}
	
	public Long getSurveySubjectQty() {
		return surveySubjectDao.count("select count(id) from SurveySubject");
	}
	
	public Long getSurveySubjectQty(String orgSN, String roleLabel, Integer status) {
		return surveySubjectDao.count("select count(id) from SurveySubject where orgSN = ? and roleLabel = ? and status = ?", new Object[] { orgSN, roleLabel, status });
	}
	
	public List<SurveySubject> getSurveySubjects() {
		return surveySubjectDao.find("from SurveySubject order by createdDate desc");
	}
	
	public List<SurveySubject> getSurveySubjects(String orgSN, String roleLabel, Integer status) {
		return surveySubjectDao.find("from SurveySubject where orgSN = ? and roleLabel = ? and status = ? order by createdDate desc", new Object[] { orgSN, roleLabel, status });
	}
	
	public List<SurveySubject> getSurveySubjects(int startIndex, int rows, String sorter, String sortingAttribute) {
		return surveySubjectDao.search("from SurveySubject order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<SurveySubject> getSurveySubjects(String orgSN, String roleLabel, Integer status, 
			int startIndex, int rows, String sorter, String sortingAttribute) {
		return surveySubjectDao.search("from SurveySubject where orgSN = ? and roleLabel = ? and status = ? order by " + sorter + " " + sortingAttribute, 
				new Object[] { orgSN, roleLabel, status }, startIndex, rows);
	}
	
	public boolean removeSurveySubject(String id) {
		surveySubjectDao.executeHql("delete from SurveySubject where id = ?", new Object[] { id });
		Long qty = surveySubjectDao.count("select count(id) from SurveySubject where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveSurveySubject(SurveySubject surveySubject) {
		String method = "";
		if ( surveySubject.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			surveySubject.setModifiedDate(new Date());
		}
		surveySubjectDao.saveOrUpdate(surveySubject);
		if ( method.equals("add") ) {
			if ( surveySubject.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public List<SurveySubject> getSurveySubjectsByWhere(String hql, int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return surveySubjectDao.search("from SurveySubject where 1=1 "+ hql +" order by " + sorter + " " + sortingAttribute, 
				new Object[] { }, startIndex, rows);
	}

	@Override
	public Long getSurveySubjectQtyByWhere(String hql) {
		return surveySubjectDao.count("select count(id) from SurveySubject where 1=1 "+hql);
	}

}