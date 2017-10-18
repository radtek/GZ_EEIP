package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingParticipantDao;
import org.pangolin.eeip.entity.MeetingParticipant;
import org.pangolin.eeip.service.MeetingIaInspectionService;
import org.pangolin.eeip.service.MeetingIiReportService;
import org.pangolin.eeip.service.MeetingParticipantService;
import org.springframework.stereotype.Service;

@Service("meetingParticipantService")
public class MeetingParticipantServiceImpl implements MeetingParticipantService {

	@Resource(name = "meetingParticipantDao")
	private MeetingParticipantDao meetingParticipantDao;
	
	@Resource
	private MeetingIiReportService meetingIiReportService;  //不符合项报告
	
	@Resource
	private MeetingIaInspectionService meetingIaInspectionService; // 内部审核检查表
	
	@Override
	public boolean saveMeetingParticipant(MeetingParticipant meetingParticipant,Integer type) {
		meetingParticipantDao.save(meetingParticipant);
		return true;
		/*String method = "";
		if ( meetingParticipant.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingParticipantDao.saveOrUpdate(meetingParticipant);
		if ( method.equals("add") ) {
			if ( meetingParticipant.getId() != null ){
				  if ( type.equals(MeetingApp.TYPE_INNER) ) {
					  return saveReportAndInspection(meetingParticipant);
				  }
				return true;
			}
		} else { return true; }
		return false;*/
	}
	
	/***
	 * 添加不符合项报告信息 和 内部审核检查表
	 * @param meetingParticipant
	 * @return
	 */
	/*private boolean saveReportAndInspection(MeetingParticipant meetingParticipant) {
		boolean status = false;
		
		//不符合项报告
		MeetingIiReport iiReport = new MeetingIiReport();
		iiReport.setPrincipalAlias(meetingParticipant.getUserAlias());
		iiReport.setPrincipalId(meetingParticipant.getUserId());
		iiReport.setPrincipalName(meetingParticipant.getUserName());
		iiReport.setMeetingAppId(meetingParticipant.getMeetingAppId());
		iiReport.setMeetingParticipantId(meetingParticipant.getId());
		status = meetingIiReportService.saveMeetingIiReport(iiReport);
		
		// 内部审核检查表
		MeetingIaInspection iaInspection = new MeetingIaInspection();
		iaInspection.setCreatorId(meetingParticipant.getUserId());
		iaInspection.setCreatorAlias(meetingParticipant.getUserAlias());
		iaInspection.setCreatorName(meetingParticipant.getUserName());
		iaInspection.setMeetingAppId(meetingParticipant.getMeetingAppId());
		iaInspection.setMeetingParticipantId(meetingParticipant.getId());
		status = meetingIaInspectionService.saveMeetingIaInspection(iaInspection);
		
		return status;
	}*/

	@Override
	public boolean removeMeetingParticipant(String id) {
		meetingParticipantDao.executeHql("delete from MeetingParticipant where id = ?", new Object[] { id });
		Long qty = meetingParticipantDao.count("select count(id) from MeetingParticipant where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) {
			meetingIaInspectionService.removeMeetingIaInspectionFalseByParticipantId(id);
			meetingIiReportService.removeMeetingIiReportFalseByParticipantId(id);
			return true;
		}
		return false;
	}

	@Override
	public MeetingParticipant getMeetingParticipantById(String id) {
		return meetingParticipantDao.get(MeetingParticipant.class, id);
	}

	@Override
	public Long getMeetingParticipantQty() {
		return meetingParticipantDao.count("select count(id) from MeetingParticipant ", new Object[]{ });
	}

	@Override
	public List<MeetingParticipant> getMeetingParticipants() {
		return meetingParticipantDao.find("from MeetingParticipant order by createdDate desc", new Object[]{ });
	}

	@Override
	public List<MeetingParticipant> getMeetingParticipants(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingParticipantDao.search("from MeetingParticipant where order by " + sorter + " " + sortingAttribute, new Object[] { }, startIndex, rows);
	}

	@Override
	public List<MeetingParticipant> getMeetingParticipantsByMeetingAppId(
			String meetingAppId) {
		return meetingParticipantDao.find("from MeetingParticipant where meetingAppId = ?", new Object[]{ meetingAppId });
	}

	@Override
	public boolean removeMeetingParticipantsByAppId(String appId) {
		meetingParticipantDao.executeHql("delete MeetingParticipant where meetingAppId = ?", new Object[] { appId });
		List<MeetingParticipant> list = getMeetingParticipantsByMeetingAppId(appId);
		if ( list == null || list.size() == 0) {
			return true;
		}
		return false;
	}
}
