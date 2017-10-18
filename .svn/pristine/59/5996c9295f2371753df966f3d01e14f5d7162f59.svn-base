package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingIaInspectionItemDao;
import org.pangolin.eeip.entity.MeetingIaInspectionItem;
import org.pangolin.eeip.service.MeetingIaInspectionItemService;
import org.springframework.stereotype.Service;

@Service("meetingIaInspectionItemService")
@SuppressWarnings("all")
public class MeetingIaInspectionItemServiceImpl implements MeetingIaInspectionItemService {

	@Resource
	private MeetingIaInspectionItemDao meetingIaInspectionItemDao;
	
	@Override
	public boolean saveMeetingIaInspectionItem(MeetingIaInspectionItem meetingIaInspectionItem) {
		Long qty = meetingIaInspectionItemDao.count("select count(id) from MeetingIaInspectionItem where id = ?", new Object[]{ meetingIaInspectionItem.getId() });
		if ( qty > 0 ) {
			meetingIaInspectionItemDao.update(meetingIaInspectionItem);
		} else {
			meetingIaInspectionItemDao.save(meetingIaInspectionItem);
		}
		return true;
		/*String method = "";
		if ( meetingIaInspectionItem.getId() == null ) { method = "add"; }
		else { 
			method = "update";
		}
		meetingIaInspectionItemDao.saveOrUpdate(meetingIaInspectionItem);
		if ( method.equals("add") ) {
			if ( meetingIaInspectionItem.getId() != null ) return true;
		} else { return true; }
		return false;*/
	}

	@Override
	public boolean removeMeetingIaInspectionItem(String id) {
		meetingIaInspectionItemDao.executeHql("delete from MeetingIaInspectionItem where id = ?", new Object[] { id });
		Long qty = meetingIaInspectionItemDao.count("select count(id) from MeetingIaInspectionItem where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MeetingIaInspectionItem getMeetingIaInspectionItemById(String id) {
		return meetingIaInspectionItemDao.get(MeetingIaInspectionItem.class, id);
	}

	@Override
	public Long getMeetingIaInspectionItemQty() {
		return meetingIaInspectionItemDao.count("select count(id) from MeetingIaInspectionItem ", new Object[]{  });
	}

	@Override
	public List<MeetingIaInspectionItem> getMeetingIaInspectionItems() {
		return meetingIaInspectionItemDao.find("from MeetingIaInspectionItem ", new Object[]{  });
	}

	@Override
	public List<MeetingIaInspectionItem> getMeetingIaInspectionItems(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return meetingIaInspectionItemDao.search("from MeetingIaInspectionItem order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	@Override
	public List<MeetingIaInspectionItem> getMeetingIaInspectionItemsByInspectionId(String inspectionId) {
		return meetingIaInspectionItemDao.find("from MeetingIaInspectionItem where meetingIaInspectionId = ?", new Object[]{ inspectionId });
	}

}
