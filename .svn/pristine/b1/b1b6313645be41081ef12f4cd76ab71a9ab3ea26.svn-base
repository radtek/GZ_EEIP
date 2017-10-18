package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DocHistoryDao;
import org.pangolin.eeip.entity.DocHistory;
import org.pangolin.eeip.service.DocHistoryService;
import org.springframework.stereotype.Service;

@Service("docHistoryService")
public class DocHistoryServiceImpl implements DocHistoryService {

	@Resource
	private DocHistoryDao docHistoryDao;

	@Override
	public boolean saveDocHistory(DocHistory docHistory) {
		String method = "";
		if( docHistory.getId() != null ){
			method = "add";
		}else{
			method = "update";
		}
		docHistoryDao.saveOrUpdate(docHistory);
		if( method.equals("add") ){
			if( docHistory.getId() != null ) return true;
		}else { return true; }
		return false;
	}

	@Override
	public List<DocHistory> getDocHistorysByDocId(String docId) {
		return docHistoryDao.find("from DocHistory where docId = ? and deleteFlag = ? order by createdDate desc", new Object[]{ docId, DocHistory.NORMAL });
	}

	@Override
	public DocHistory getDocHistory(String id) {
		return docHistoryDao.get(DocHistory.class, id);
	}

	@Override
	public List<DocHistory> getDocHistorysByDocId(String docId, int startIndex,int rows, String sorter, String sortingAttribute) {
		return docHistoryDao.search("from DocHistory where docId = ? and deleteFlag = ? order by "+ sorter +" "+sortingAttribute, new Object[]{ docId, DocHistory.NORMAL }, startIndex, rows);
	}
}
