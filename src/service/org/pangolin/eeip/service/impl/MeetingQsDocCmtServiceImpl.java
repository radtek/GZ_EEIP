package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingQsDocCmtDao;
import org.pangolin.eeip.entity.MeetingQsDocCmt;
import org.pangolin.eeip.service.MeetingQsDocCmtService;
import org.springframework.stereotype.Service;

@Service("meetingQsDocCmtService")
@SuppressWarnings("all")
public class MeetingQsDocCmtServiceImpl implements MeetingQsDocCmtService {

	@Resource
	private MeetingQsDocCmtDao meetingQsDocCmtDao;
	
	@Override
	public boolean saveMeetingQsDocCmt(MeetingQsDocCmt meetingQsDocCmt) {
		Long qty = meetingQsDocCmtDao.count("select count(id) from MeetingQsDocCmt where id = ?", new Object[]{ meetingQsDocCmt.getId() });
		if ( qty > 0 ) {
			meetingQsDocCmt.setModifiedDate(new Date());
			meetingQsDocCmtDao.update(meetingQsDocCmt);
			
		} else {
			meetingQsDocCmtDao.save(meetingQsDocCmt);
		}
		
		return true;
	}

	@Override
	public boolean removeMeetingQsDocCmt(String id) {
		meetingQsDocCmtDao.executeHql("delete from MeetingQsDocCmt where id = ?", new Object[] { id });
		Long qty = meetingQsDocCmtDao.count("select count(id) from MeetingQsDocCmt where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingQsDocCmtFalse(String id) {
		meetingQsDocCmtDao.executeHql("update MeetingQsDocCmt set delFlag = ? where id = ?", new Object[] { MeetingQsDocCmt.REMOVED, id });
		Long qty = meetingQsDocCmtDao.count("select count(id) from MeetingQsDocCmt where id = ? and delFlag = ? " , new Object[] { id, MeetingQsDocCmt.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingQsDocCmt getMeetingQsDocCmtById(String id) {
		return meetingQsDocCmtDao.get(MeetingQsDocCmt.class, id);
	}

	@Override
	public Long getMeetingQsDocCmtQty() {
		return meetingQsDocCmtDao.count("select count(id) from MeetingQsDocCmt where delFlag = ? ", new Object[]{ MeetingQsDocCmt.NORMAL });
	}

	@Override
	public List<MeetingQsDocCmt> getMeetingQsDocCmts() {
		return meetingQsDocCmtDao.find("from MeetingQsDocCmt where delFlag = ? order by createdDate desc", new Object[]{ MeetingQsDocCmt.NORMAL });
	}

	@Override
	public List<MeetingQsDocCmt> getMeetingQsDocCmts(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingQsDocCmtDao.search("from MeetingQsDocCmt where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { MeetingQsDocCmt.NORMAL }, startIndex, rows);
	}

	@Override
	public MeetingQsDocCmt getMeetingQsDocCmtByAppId(String appId) {
		List<MeetingQsDocCmt> list = meetingQsDocCmtDao.find("from MeetingQsDocCmt where delFlag = ? and meetingAppId = ?", new Object[]{ MeetingQsDocCmt.NORMAL, appId});
		if ( list != null && list.size() > 0 ) {
			return list.get(0);
		}
		return new MeetingQsDocCmt();
	}

}
