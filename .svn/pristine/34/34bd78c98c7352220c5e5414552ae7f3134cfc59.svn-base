package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MeetingAppDao;
import org.pangolin.eeip.dao.MeetingDocDao;
import org.pangolin.eeip.entity.MeetingApp;
import org.pangolin.eeip.entity.MeetingDoc;
import org.pangolin.eeip.service.MeetingAppService;
import org.springframework.stereotype.Service;


@Service("meetingAppService")
public class MeetingAppServiceImpl implements MeetingAppService {

	@Resource(name = "meetingAppDao")
	private MeetingAppDao meetingAppDao;
	
	@Resource(name = "meetingDocDao")
	private MeetingDocDao meetingDocDao;
	
	@Override
	public boolean saveMeetingApp(MeetingApp meetingApp) {
		Long qty = meetingAppDao.count("select count(id) from MeetingApp where id = ?" , new Object[] { meetingApp.getId() });
		if ( qty > 0 ) {
			meetingApp.setModifiedDate(new Date());
			meetingAppDao.update(meetingApp);
		} else {
			meetingAppDao.save(meetingApp);
		}

		return true;
	}

	@Override
	public boolean removeMeetingApp(String id) {
		meetingAppDao.executeHql("delete from MeetingApp where id = ?", new Object[] { id });
		Long qty = meetingAppDao.count("select count(id) from MeetingApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMeetingAppFalse(String id) {
		meetingAppDao.executeHql("update MeetingApp set delFlag = ? where id = ?", new Object[] { MeetingApp.REMOVED, id });
		Long qty = meetingAppDao.count("select count(id) from MeetingApp where id = ? and delFlag = ? " , new Object[] { id, MeetingApp.NORMAL });
		if ( qty.intValue() == 0 ) {
			meetingDocDao.executeHql("update MeetingDoc set delFlag = ? where meetingAppId = ?", new Object[] { MeetingDoc.REMOVED, id });
			return true;
		}
		return false;
	}

	@Override
	public MeetingApp getMeetingAppById(String id) {
		return meetingAppDao.get(MeetingApp.class, id);
	}

	@Override
	public Long getMeetingAppQty(Map<String, Object> queryParams) {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(id) from MeetingApp where delFlag = "+MeetingApp.NORMAL);
		List<Object> list = bulidParameter(queryParams, hql);
		return meetingAppDao.count(hql.toString(), list);
	}

	@Override
	public List<MeetingApp> getMeetingApps() {
		return meetingAppDao.find("from MeetingApp where delFlag = ? order by createdDate desc", new Object[]{  });
	}

	@Override
	public List<MeetingApp> getMeetingApps(int startIndex, int rows, String sorter,
			String sortingAttribute, Map<String, Object> queryParams) {
		StringBuffer hql = new StringBuffer();
		hql.append("from MeetingApp where delFlag = "+MeetingApp.NORMAL);
		List<Object> list = bulidParameter(queryParams, hql);
		hql.append(" order by " + sorter + " " + sortingAttribute);
		return meetingAppDao.search(hql.toString(), list, startIndex, rows);
	}
	
	/**
	 * 查询参数构造
	 * @param map
	 * @param buffer
	 * @return
	 */
	private List<Object> bulidParameter(Map<String,Object> map,StringBuffer buffer){
		List<Object> list = new ArrayList<Object>();
		if ( map.get("type") != null && !"".equals(map.get("type")) ) {
			buffer.append(" and type = ? ");
			list.add(Integer.valueOf(map.get("type").toString()));
		}
		if ( map.get("key") != null && !"".equals(map.get("key")) ) {
			buffer.append(" and (subject like ? or meetingRoomName like ? ) ");
			list.add("%"+map.get("key")+"%");
			list.add("%"+map.get("key")+"%");
		}
		
        return list;
	}

}
