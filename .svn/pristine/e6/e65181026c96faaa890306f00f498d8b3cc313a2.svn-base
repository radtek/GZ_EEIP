package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingDocDao;
import org.pangolin.eeip.entity.MeetingDoc;
import org.pangolin.eeip.service.MeetingDocService;
import org.springframework.stereotype.Service;

@Service("meetingDocService")
public class MeetingDocServiceImpl implements MeetingDocService {

	@Resource(name = "meetingDocDao")
	private MeetingDocDao meetingDocDao;
	
	@Override
	public boolean saveMeetingDoc(MeetingDoc meetingFile) {
		String method = "";
		if ( meetingFile.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingDocDao.saveOrUpdate(meetingFile);
		if ( method.equals("add") ) {
			if ( meetingFile.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingDoc(String id) {
		meetingDocDao.executeHql("delete from MeetingDoc where id = ?", new Object[] { id });
		Long qty = meetingDocDao.count("select count(id) from MeetingDoc where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingDocFalse(String id) {
		meetingDocDao.executeHql("update MeetingDoc set delFlag = ? where id = ?", new Object[] { MeetingDoc.REMOVED, id });
		Long qty = meetingDocDao.count("select count(id) from MeetingDoc where id = ? and delFlag = ? " , new Object[] { id, MeetingDoc.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean updateMeetingDoc(String id) {
		meetingDocDao.executeHql("update MeetingDoc set delFlag = ? where id = ?", new Object[] { MeetingDoc.NORMAL, id });
		Long qty = meetingDocDao.count("select count(id) from MeetingDoc where id = ? and delFlag = ? " , new Object[] { id, MeetingDoc.REMOVED });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingDoc getMeetingDocById(String id) {
		return meetingDocDao.get(MeetingDoc.class, id);
	}

	@Override
	public Long getMeetingDocQty() {
		return meetingDocDao.count("select count(id) from MeetingDoc where delFlag = ? ", new Object[]{MeetingDoc.NORMAL});
	}

	@Override
	public List<MeetingDoc> getMeetingDocs() {
		return meetingDocDao.find("from MeetingDoc where delFlag = ? order by createdDate desc", new Object[]{MeetingDoc.NORMAL});
	}

	@Override
	public List<MeetingDoc> getMeetingDocs(int startIndex, int rows,
			String sorter, String sortingAttribute) {
		return meetingDocDao.search("from MeetingDoc where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { MeetingDoc.NORMAL }, startIndex, rows);
	}

	@Override
	public List<MeetingDoc> getMeetingDocsByMeetingAppId(String meetingAppId) {
		return meetingDocDao.find("from MeetingDoc where delFlag = ? and meetingAppId = ? order by createdDate desc", new Object[] { MeetingDoc.NORMAL, meetingAppId });
	}

	@Override
	public MeetingDoc getMeetingDocByAppIdAndType(String appId, int type) {
		return meetingDocDao.get("from MeetingDoc where delFlag = ? and meetingAppId = ? and type = ?" , new Object[]{ MeetingDoc.NORMAL, appId, type});
	}

}
