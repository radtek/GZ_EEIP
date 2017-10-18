package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingQsDocCmtItemDao;
import org.pangolin.eeip.entity.MeetingQsDocCmtItem;
import org.pangolin.eeip.service.MeetingQsDocCmtItemService;
import org.springframework.stereotype.Service;

@Service("meetingQsDocCmtItemService")
@SuppressWarnings("all")
public class MeetingQsDocCmtItemServiceImpl implements MeetingQsDocCmtItemService {

	@Resource
	private MeetingQsDocCmtItemDao meetingQsDocCmtItemDao;
	
	@Override
	public boolean saveMeetingQsDocCmtItem(MeetingQsDocCmtItem meetingQsDocCmtItem) {
		String method = "";
		if ( meetingQsDocCmtItem.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingQsDocCmtItemDao.saveOrUpdate(meetingQsDocCmtItem);
		if ( method.equals("add") ) {
			if ( meetingQsDocCmtItem.getId() != null ) return true;
		} else { return true; }
		return false;
	}

	@Override
	public boolean removeMeetingQsDocCmtItem(String id) {
		meetingQsDocCmtItemDao.executeHql("delete from MeetingQsDocCmtItem where id = ?", new Object[] { id });
		Long qty = meetingQsDocCmtItemDao.count("select count(id) from MeetingQsDocCmtItem where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	

	@Override
	public MeetingQsDocCmtItem getMeetingQsDocCmtItemById(String id) {
		return meetingQsDocCmtItemDao.get(MeetingQsDocCmtItem.class, id);
	}

	@Override
	public Long getMeetingQsDocCmtItemQty() {
		return meetingQsDocCmtItemDao.count("select count(id) from MeetingQsDocCmtItem ", new Object[]{  });
	}

	@Override
	public List<MeetingQsDocCmtItem> getMeetingQsDocCmtItems() {
		return meetingQsDocCmtItemDao.find("from MeetingQsDocCmtItem order by createdDate desc", new Object[]{  });
	}

	@Override
	public List<MeetingQsDocCmtItem> getMeetingQsDocCmtItems(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingQsDocCmtItemDao.search("from MeetingQsDocCmtItem order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	@Override
	public List<MeetingQsDocCmtItem> getMeetingQsDocCmtItemsByCmtId(String appId,int type) {
		return meetingQsDocCmtItemDao.find("from MeetingQsDocCmtItem where meetingAppId = ? and docType = ?", new Object[]{ appId, type });
	}

}
