package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingIaInspectionDao;
import org.pangolin.eeip.entity.MeetingIaInspection;
import org.pangolin.eeip.service.MeetingIaInspectionService;
import org.springframework.stereotype.Service;

@Service("meetingIaInspectionService")
@SuppressWarnings("all")
public class MeetingIaInspectionServiceImpl implements MeetingIaInspectionService {

	@Resource
	private MeetingIaInspectionDao meetingIaInspectionDao;
	
	@Override
	public boolean saveMeetingIaInspection(MeetingIaInspection meetingIaInspection) {
		Long qty = meetingIaInspectionDao.count("select count(id) from MeetingIaInspection where id = ?",new Object[]{ meetingIaInspection.getId() });
		if ( qty > 0 ) {
			meetingIaInspection.setModifiedDate(new Date());
			meetingIaInspectionDao.update(meetingIaInspection);
		} else {
			meetingIaInspectionDao.save(meetingIaInspection);
		}
		return true;
	}

	@Override
	public boolean removeMeetingIaInspection(String id) {
		meetingIaInspectionDao.executeHql("delete from MeetingIaInspection where id = ?", new Object[] { id });
		Long qty = meetingIaInspectionDao.count("select count(id) from MeetingIaInspection where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingIaInspectionFalse(String id) {
		meetingIaInspectionDao.executeHql("update MeetingIaInspection set delFlag = ? where id = ?", new Object[] { MeetingIaInspection.REMOVED, id });
		Long qty = meetingIaInspectionDao.count("select count(id) from MeetingIaInspection where id = ? and delFlag = ? " , new Object[] { id, MeetingIaInspection.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public void removeMeetingIaInspectionFalseByParticipantId(String participantId) {
		meetingIaInspectionDao.executeHql("update MeetingIaInspection set delFlag = ? where meetingParticipantId = ?", new Object[] { MeetingIaInspection.REMOVED, participantId });
		
	}

	@Override
	public MeetingIaInspection getMeetingIaInspectionById(String id) {
		return meetingIaInspectionDao.get(MeetingIaInspection.class, id);
	}

	@Override
	public Long getMeetingIaInspectionQty() {
		return meetingIaInspectionDao.count("select count(id) from MeetingIaInspection where delFlag = ? ", new Object[]{ MeetingIaInspection.NORMAL });
	}

	@Override
	public List<MeetingIaInspection> getMeetingIaInspections() {
		return meetingIaInspectionDao.find("from MeetingIaInspection where delFlag = ? order by createdDate desc", new Object[]{ MeetingIaInspection.NORMAL });
	}

	@Override
	public List<MeetingIaInspection> getMeetingIaInspections(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingIaInspectionDao.search("from MeetingIaInspection where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { MeetingIaInspection.NORMAL }, startIndex, rows);
	}

	@Override
	public List<MeetingIaInspection> getMeetingIaInspectionsByAppId(String appId) {
		return meetingIaInspectionDao.find("from MeetingIaInspection where delFlag = ? and meetingAppId = ? order by createdDate desc", new Object[]{ MeetingIaInspection.NORMAL, appId });
	}

	@Override
	public List<MeetingIaInspection> getMeetingIaInspectionByAppIdAndParticipantId(
			String appId, String participantId) {
		return meetingIaInspectionDao.find("from MeetingIaInspection where delFlag = ? and meetingAppId = ? and creatorId = ? order by createdDate desc", new Object[]{ MeetingIaInspection.NORMAL, appId, participantId });
	}

}
