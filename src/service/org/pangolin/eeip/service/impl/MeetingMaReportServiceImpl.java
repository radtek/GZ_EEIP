package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingMaReportDao;
import org.pangolin.eeip.entity.MeetingMaReport;
import org.pangolin.eeip.service.MeetingMaReportService;
import org.springframework.stereotype.Service;

@Service("meetingMaReportService")
@SuppressWarnings("all")
public class MeetingMaReportServiceImpl implements MeetingMaReportService {

	@Resource
	private MeetingMaReportDao meetingMaReportDao;
	
	@Override
	public boolean saveMeetingMaReport(MeetingMaReport meetingMaReport) {
		String method = "";
		if ( meetingMaReport.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			meetingMaReport.setModifiedDate(new Date());
		}
		meetingMaReportDao.saveOrUpdate(meetingMaReport);
		if ( method.equals("add") ) {
			if ( meetingMaReport.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingMaReport(String id) {
		meetingMaReportDao.executeHql("delete from MeetingMaReport where id = ?", new Object[] { id });
		Long qty = meetingMaReportDao.count("select count(id) from MeetingMaReport where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingMaReportFalse(String id) {
		meetingMaReportDao.executeHql("update MeetingMaReport set delFlag = ? where id = ?", new Object[] { MeetingMaReport.REMOVED, id });
		Long qty = meetingMaReportDao.count("select count(id) from MeetingMaReport where id = ? and delFlag = ? " , new Object[] { id, MeetingMaReport.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingMaReport getMeetingMaReportById(String id) {
		return meetingMaReportDao.get(MeetingMaReport.class, id);
	}

	@Override
	public Long getMeetingMaReportQty() {
		return meetingMaReportDao.count("select count(id) from MeetingMaReport where delFlag = ? ", new Object[]{ MeetingMaReport.NORMAL });
	}

	@Override
	public List<MeetingMaReport> getMeetingMaReports() {
		return meetingMaReportDao.find("from MeetingMaReport where delFlag = ? order by createdDate desc", new Object[]{ MeetingMaReport.NORMAL });
	}

	@Override
	public List<MeetingMaReport> getMeetingMaReports(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingMaReportDao.search("from MeetingMaReport where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { MeetingMaReport.NORMAL }, startIndex, rows);
	}

	@Override
	public MeetingMaReport getMeetingMaReportByAppId(String appId) {
		List<MeetingMaReport> list = meetingMaReportDao.find("from MeetingMaReport where delFlag = ? and meetingAppId = ?", new Object[]{ MeetingMaReport.NORMAL, appId});
		if ( list != null && list.size() > 0 ) {
			return list.get(0);
		}
		return new MeetingMaReport();
	}

}
