package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingIaParticipantDao;
import org.pangolin.eeip.entity.MeetingIaParticipant;
import org.pangolin.eeip.service.MeetingIaInspectionService;
import org.pangolin.eeip.service.MeetingIaParticipantService;
import org.pangolin.eeip.service.MeetingIiReportService;
import org.springframework.stereotype.Service;

@Service("meetingIaParticipantService")
public class MeetingIaParticipantServiceImpl implements MeetingIaParticipantService {

	@Resource
	private MeetingIaParticipantDao meetingIaParticipantDao;
	
	@Resource
	private MeetingIiReportService meetingIiReportService;  //不符合项报告
	
	@Resource
	private MeetingIaInspectionService meetingIaInspectionService; // 内部审核检查表
	
	@Override
	public boolean saveMeetingIaParticipant(MeetingIaParticipant meetingIaParticipant, Integer type) {
		meetingIaParticipantDao.save(meetingIaParticipant);
		return true;
		/*String method = "";
		if ( meetingIaParticipant.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingIaParticipantDao.saveOrUpdate(meetingIaParticipant);
		if ( method.equals("add") ) {
			if ( meetingIaParticipant.getId() != null ){
				if ( type.equals( MeetingApp.TYPE_INNER) ) {
					return saveReportAndInspection(meetingIaParticipant);
				}
				return true;
			}
		} else { return true; }
		return false;*/
	}
	
	/***
	 * 添加不符合项报告信息 和 内部审核检查表
	 * @param meetingIaParticipant
	 * @return
	 */
	/*private boolean saveReportAndInspection(MeetingIaParticipant meetingIaParticipant) {
		boolean status = false;
		
		//不符合项报告
		MeetingIiReport iiReport = new MeetingIiReport();
		iiReport.setPrincipalAlias(meetingIaParticipant.getUserAlias());
		iiReport.setPrincipalId(meetingIaParticipant.getUserId());
		iiReport.setPrincipalName(meetingIaParticipant.getUserName());
		iiReport.setMeetingAppId(meetingIaParticipant.getMeetingAppId());
		iiReport.setMeetingParticipantId(meetingIaParticipant.getId());
		status = meetingIiReportService.saveMeetingIiReport(iiReport);
		
		// 内部审核检查表
		MeetingIaInspection iaInspection = new MeetingIaInspection();
		iaInspection.setCreatorId(meetingIaParticipant.getUserId());
		iaInspection.setCreatorAlias(meetingIaParticipant.getUserAlias());
		iaInspection.setCreatorName(meetingIaParticipant.getUserName());
		iaInspection.setMeetingAppId(meetingIaParticipant.getMeetingAppId());
		iaInspection.setMeetingParticipantId(meetingIaParticipant.getId());
		status = meetingIaInspectionService.saveMeetingIaInspection(iaInspection);
		
		return status;
	}
*/
	@Override
	public boolean removeMeetingIaParticipant(String id) {
		meetingIaParticipantDao.executeHql("delete from MeetingIaParticipant where id = ?", new Object[] { id });
		Long qty = meetingIaParticipantDao.count("select count(id) from MeetingIaParticipant where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ){
			meetingIaInspectionService.removeMeetingIaInspectionFalseByParticipantId(id);
			meetingIiReportService.removeMeetingIiReportFalseByParticipantId(id);
			return true;
		}
		return false;
	}
	

	@Override
	public MeetingIaParticipant getMeetingIaParticipantById(String id) {
		return meetingIaParticipantDao.get(MeetingIaParticipant.class, id);
	}

	@Override
	public Long getMeetingIaParticipantQty() {
		return meetingIaParticipantDao.count("select count(id) from MeetingIaParticipant ", new Object[]{ });
	}

	@Override
	public List<MeetingIaParticipant> getMeetingIaParticipants() {
		return meetingIaParticipantDao.find("from MeetingIaParticipant", new Object[]{  });
	}

	@Override
	public List<MeetingIaParticipant> getMeetingIaParticipants(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingIaParticipantDao.search("from MeetingIaParticipant order by " + sorter + " " + sortingAttribute, new Object[] { }, startIndex, rows);
	}

	@Override
	public List<MeetingIaParticipant> getMeetingIaParticipantsByAppId(String appId) {
		return meetingIaParticipantDao.find("from MeetingIaParticipant where meetingAppId = ?", new Object[]{ appId });
	}

	@Override
	public boolean removeMeetingIaParticipantByAppId(String appId) {
		meetingIaParticipantDao.executeHql("delete MeetingIaParticipant where meetingAppId = ?", new Object[]{ appId });
		List<MeetingIaParticipant> list = getMeetingIaParticipantsByAppId(appId);
		if ( list == null || list.size() == 0 ) {
			return true;
		}
		return false;
	}
}
