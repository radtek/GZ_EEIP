package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.MgtRvwPlanDao;
import org.pangolin.eeip.entity.MgtRvwPlanApp;
import org.pangolin.eeip.service.MgtRvwPlanAppService;
import org.springframework.stereotype.Service;

@Service("mgtRvwPlanAppService")
@SuppressWarnings("all")
public class MgtRvwPlanAppServiceImpl implements MgtRvwPlanAppService {

	@Resource
	private MgtRvwPlanDao mgtRvwPlanDao;
	
	@Override
	public boolean saveMgtRvwPlanApp(MgtRvwPlanApp implPlanApp) {
		Long qty = mgtRvwPlanDao.count("select count(id) from MgtRvwPlanApp where id = ?" , new Object[] { implPlanApp.getId() });
		if ( qty > 0 ) {
			implPlanApp.setModifiedDate(new Date());
			mgtRvwPlanDao.update(implPlanApp);
		} else {
			mgtRvwPlanDao.save(implPlanApp);
		}
		return true;
	}

	@Override
	public boolean removeMgtRvwPlanApp(String id) {
		mgtRvwPlanDao.executeHql("delete from MgtRvwPlanApp where id = ?", new Object[] { id });
		Long qty = mgtRvwPlanDao.count("select count(id) from MgtRvwPlanApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeMgtRvwPlanAppFalse(String id) {
		mgtRvwPlanDao.executeHql("update MgtRvwPlanApp set delFlag = ? where id = ?", new Object[] { MgtRvwPlanApp.REMOVED, id });
		Long qty = mgtRvwPlanDao.count("select count(id) from MgtRvwPlanApp where id = ? and delFlag = ? " , new Object[] { id, MgtRvwPlanApp.NORMAL });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public MgtRvwPlanApp getMgtRvwPlanAppById(String id) {
		return mgtRvwPlanDao.get(MgtRvwPlanApp.class, id);
	}

	@Override
	public Long getMgtRvwPlanAppQty(String queryParams) {
		if ( queryParams != null && !"".equals(queryParams) ) {
			queryParams = "%" + queryParams + "%";
			return mgtRvwPlanDao.count("select count(id) from MgtRvwPlanApp where delFlag = ? and title like ?", new Object[]{ MgtRvwPlanApp.NORMAL, queryParams });
		}
		return mgtRvwPlanDao.count("select count(id) from MgtRvwPlanApp where delFlag = ?", new Object[]{ MgtRvwPlanApp.NORMAL });
	}

	@Override
	public List<MgtRvwPlanApp> getMgtRvwPlanApps() {
		return mgtRvwPlanDao.find("from MgtRvwPlanApp where delFlag = ? order by createdDate desc", new Object[]{  });
	}

	@Override
	public List<MgtRvwPlanApp> getMgtRvwPlanApps(int startIndex, int rows, String sorter,String sortingAttribute, String queryParams) {
		if( queryParams != null && !"".equals(queryParams) ) {
			queryParams = "%" + queryParams + "%";
			String hql = "from MgtRvwPlanApp where delFlag = ? and title like ?  order by " + sorter + " " + sortingAttribute;
			return mgtRvwPlanDao.search(hql,new Object[]{ MgtRvwPlanApp.NORMAL, queryParams }, startIndex, rows);
		}
		return mgtRvwPlanDao.search("from MgtRvwPlanApp where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[]{ MgtRvwPlanApp.NORMAL }, startIndex, rows);
	}
}
