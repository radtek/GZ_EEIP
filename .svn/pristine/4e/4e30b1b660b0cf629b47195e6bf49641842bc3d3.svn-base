package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingIiReportDao;
import org.pangolin.eeip.entity.MeetingIiReport;
import org.pangolin.eeip.service.MeetingIiReportService;
import org.springframework.stereotype.Service;

@Service("meetingIiReportService")
public class MeetingIiReportServiceImpl implements MeetingIiReportService {

	@Resource
	private MeetingIiReportDao meetingIiReportDao;
	
	@Override
	public boolean saveMeetingIiReport(MeetingIiReport meetingIiReport) {
		String method = "";
		if ( meetingIiReport.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingIiReportDao.saveOrUpdate(meetingIiReport);
		if ( method.equals("add") ) {
			if ( meetingIiReport.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingIiReport(String id) {
		meetingIiReportDao.executeHql("delete from MeetingIiReport where id = ?", new Object[] { id });
		Long qty = meetingIiReportDao.count("select count(id) from MeetingIiReport where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingIiReportFalse(String id) {
		meetingIiReportDao.executeHql("update MeetingIiReport set delFlag = ? where id = ?", new Object[] { MeetingIiReport.REMOVED, id });
		Long qty = meetingIiReportDao.count("select count(id) from MeetingIiReport where id = ? and delFlag = ? " , new Object[] { id, MeetingIiReport.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingIiReport getMeetingIiReportById(String id) {
		return meetingIiReportDao.get(MeetingIiReport.class, id);
	}

	@Override
	public Long getMeetingIiReportQty() {
		return meetingIiReportDao.count("select count(id) from MeetingIiReport where delFlag = ? ", new Object[]{ MeetingIiReport.NORMAL });
	}

	@Override
	public List<MeetingIiReport> getMeetingIiReports() {
		return meetingIiReportDao.find("from MeetingIiReport where delFlag = ?", new Object[]{ MeetingIiReport.NORMAL });
	}

	@Override
	public List<MeetingIiReport> getMeetingIiReports(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingIiReportDao.search("from MeetingIiReport where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { MeetingIiReport.NORMAL }, startIndex, rows);
	}

	@Override
	public List<MeetingIiReport> getMeetingIiReportsByAppId(String appId) {
		return meetingIiReportDao.find("from MeetingIiReport where delFlag = ? and meetingAppId = ?", new Object[]{ MeetingIiReport.NORMAL, appId });
	}

	@Override
	public void removeMeetingIiReportFalseByParticipantId(String participantId) {
		meetingIiReportDao.executeHql("update MeetingIiReport set delFlag = ? where meetingParticipantId = ?", new Object[] { MeetingIiReport.REMOVED, participantId });
		
	}

	@Override
	public List<MeetingIiReport> getMeetingIiReportByAppIdAndParticipantId(String appId, String participantId) {
		return meetingIiReportDao.find("from MeetingIiReport where delFlag = ? and meetingAppId = ? and principalId = ?", new Object[]{ MeetingIiReport.NORMAL, appId, participantId } );
	}
}
