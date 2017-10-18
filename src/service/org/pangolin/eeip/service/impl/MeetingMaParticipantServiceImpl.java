package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingMaParticipantDao;
import org.pangolin.eeip.entity.MeetingMaParticipant;
import org.pangolin.eeip.service.MeetingMaParticipantService;
import org.springframework.stereotype.Service;

@Service("meetingMaParticipantService")
@SuppressWarnings("all")
public class MeetingMaParticipantServiceImpl implements MeetingMaParticipantService {

	@Resource
	private MeetingMaParticipantDao meetingMaParticipantDao;
	
	@Override
	public boolean saveMeetingMaParticipant(MeetingMaParticipant meetingMaParticipant) {
		String method = "";
		if ( meetingMaParticipant.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingMaParticipantDao.saveOrUpdate(meetingMaParticipant);
		if ( method.equals("add") ) {
			if ( meetingMaParticipant.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingMaParticipant(String id) {
		meetingMaParticipantDao.executeHql("delete from MeetingMaParticipant where id = ?", new Object[] { id });
		Long qty = meetingMaParticipantDao.count("select count(id) from MeetingMaParticipant where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	

	@Override
	public MeetingMaParticipant getMeetingMaParticipantById(String id) {
		return meetingMaParticipantDao.get(MeetingMaParticipant.class, id);
	}

	@Override
	public Long getMeetingMaParticipantQty() {
		return meetingMaParticipantDao.count("select count(id) from MeetingMaParticipant ", new Object[]{  });
	}

	@Override
	public List<MeetingMaParticipant> getMeetingMaParticipants() {
		return meetingMaParticipantDao.find("from MeetingMaParticipant order by createdDate desc", new Object[]{  });
	}

	@Override
	public List<MeetingMaParticipant> getMeetingMaParticipants(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingMaParticipantDao.search("from MeetingMaParticipant order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	@Override
	public List<MeetingMaParticipant> getMeetingMaParticipantsByReportId(String reportId) {
		return meetingMaParticipantDao.find("from MeetingMaParticipant where meetingMaReportId = ? ", new Object[]{ reportId });
	}

}
