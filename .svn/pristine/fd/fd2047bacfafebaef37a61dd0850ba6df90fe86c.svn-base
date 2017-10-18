package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingRoomDao;
import org.pangolin.eeip.entity.MeetingRoom;
import org.pangolin.eeip.service.MeetingRoomService;
import org.springframework.stereotype.Service;

@Service("meetingRoomService")
public class MeetingRoomServiceImpl implements MeetingRoomService {

	@Resource(name = "meetingRoomDao")
	private MeetingRoomDao meetingRoomDao;
	
	@Override
	public boolean saveMeetingRoom(MeetingRoom meetingRoom) {
		String method = "";
		if ( meetingRoom.getId() == null ) { 
			method = "add"; 
			meetingRoom.setCreatedDate(new Date());
		} else { 
			method = "update";
			meetingRoom.setModifedDate(new Date());
		}
		meetingRoomDao.saveOrUpdate(meetingRoom);
		if ( method.equals("add") ) {
			if ( meetingRoom.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingRoom(String id) {
		meetingRoomDao.executeHql("delete from MeetingRoom where id = ?", new Object[] { id });
		Long qty = meetingRoomDao.count("select count(id) from MeetingRoom where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingRoomFalse(String id) {
		meetingRoomDao.executeHql("update MeetingRoom set delFlag = ? where id = ?", new Object[] { MeetingRoom.REMOVED, id });
		Long qty = meetingRoomDao.count("select count(id) from MeetingRoom where id = ? and delFlag = ? " , new Object[] { id, MeetingRoom.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingRoom getMeetingRoomById(String id) {
		return meetingRoomDao.get(MeetingRoom.class, id);
	}

	@Override
	public Long getMeetingRoomQty(String params) {
		if ( params != null && !"".equals(params) ) {
			params = "%" + params + "%";
			return meetingRoomDao.count("select count(id) from MeetingRoom where delFlag = ? and ( sn like ? or name like ? )", new Object[]{ MeetingRoom.NORMAL, params, params });
		}
		return meetingRoomDao.count("select count(id) from MeetingRoom where delFlag = ? ", new Object[]{ MeetingRoom.NORMAL });
	}

	@Override
	public List<MeetingRoom> getMeetingRooms() {
		return meetingRoomDao.find("from MeetingRoom where delFlag = ? order by createdDate desc", new Object[]{ MeetingRoom.NORMAL });
	}

	@Override
	public List<MeetingRoom> getMeetingRooms(int startIndex, int rows,String sorter, String sortingAttribute, String params) {
		if ( params != null && !"".equals(params) ) {
			params = "%" + params + "%";
			String hql = "from MeetingRoom where delFlag = ? and ( sn like ? or name like ? ) order by " + sorter + " " + sortingAttribute;
			return meetingRoomDao.search(hql, new Object[]{ MeetingRoom.NORMAL, params, params }, startIndex, rows);
		}
		return meetingRoomDao.search("from MeetingRoom where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[]{ MeetingRoom.NORMAL } , startIndex, rows);
	}

	@Override
	public List<MeetingRoom> getEmptyMeetingRooms() {
		return meetingRoomDao.find("from MeetingRoom where delFlag = ?order by createdDate desc", new Object[]{ MeetingRoom.NORMAL });
	}



}
