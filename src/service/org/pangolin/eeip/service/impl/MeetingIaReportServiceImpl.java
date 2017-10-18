package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingIaReportDao;
import org.pangolin.eeip.entity.MeetingIaReport;
import org.pangolin.eeip.service.MeetingIaReportService;
import org.springframework.stereotype.Service;

@Service("meetingIaReportService")
@SuppressWarnings("all")
public class MeetingIaReportServiceImpl implements MeetingIaReportService {

	@Resource
	private MeetingIaReportDao meetingIaReportDao;
	
	@Override
	public boolean saveMeetingIaReport(MeetingIaReport meetingIaReport) {
		String method = "";
		if ( meetingIaReport.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			meetingIaReport.setModifiedDate(new Date());
		}
		meetingIaReportDao.saveOrUpdate(meetingIaReport);
		if ( method.equals("add") ) {
			if ( meetingIaReport.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingIaReport(String id) {
		meetingIaReportDao.executeHql("delete from MeetingIaReport where id = ?", new Object[] { id });
		Long qty = meetingIaReportDao.count("select count(id) from MeetingIaReport where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingIaReportFalse(String id) {
		meetingIaReportDao.executeHql("update MeetingIaReport set delFlag = ? where id = ?", new Object[] { MeetingIaReport.REMOVED, id });
		Long qty = meetingIaReportDao.count("select count(id) from MeetingIaReport where id = ? and delFlag = ? " , new Object[] { id, MeetingIaReport.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingIaReport getMeetingIaReportById(String id) {
		return meetingIaReportDao.get(MeetingIaReport.class, id);
	}

	@Override
	public Long getMeetingIaReportQty() {
		return meetingIaReportDao.count("select count(id) from MeetingIaReport where delFlag = ? ", new Object[]{ MeetingIaReport.NORMAL });
	}

	@Override
	public List<MeetingIaReport> getMeetingIaReports() {
		return meetingIaReportDao.find("from MeetingIaReport where delFlag = ? order by createdDate desc", new Object[]{ MeetingIaReport.NORMAL });
	}

	@Override
	public List<MeetingIaReport> getMeetingIaReports(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingIaReportDao.search("from MeetingIaReport where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { MeetingIaReport.NORMAL }, startIndex, rows);
	}

	@Override
	public MeetingIaReport getMeetingIaReportByAppId(String appId) {
		List<MeetingIaReport> list = meetingIaReportDao.find("from MeetingIaReport where delFlag = ? and meetingAppId = ?", new Object[]{ MeetingIaReport.NORMAL, appId});
		if ( list != null && list.size() > 0 ) {
			return list.get(0);
		}
		return new MeetingIaReport();
	}

}
