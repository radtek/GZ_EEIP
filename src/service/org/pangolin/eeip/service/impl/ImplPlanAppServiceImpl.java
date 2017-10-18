package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ImplPlanAppDao;
import org.pangolin.eeip.dao.ImplPlanAttDao;
import org.pangolin.eeip.entity.ImplPlanApp;
import org.pangolin.eeip.entity.ImplPlanAtt;
import org.pangolin.eeip.service.ImplPlanAppService;
import org.springframework.stereotype.Service;

@Service("implPlanAppService")
public class ImplPlanAppServiceImpl implements ImplPlanAppService {

	@Resource
	private ImplPlanAppDao implPlanAppDao;
	
	@Resource
	private ImplPlanAttDao implPlanAttDao;
	
	@Override
	public boolean saveImplPlanApp(ImplPlanApp implPlanApp) {
		Long qty = implPlanAppDao.count("select count(id) from ImplPlanApp where id = ?" , new Object[] { implPlanApp.getId() });
		if ( qty > 0 ) {
			implPlanApp.setModifiedDate(new Date());
			implPlanAppDao.update(implPlanApp);
		} else {
			implPlanAppDao.save(implPlanApp);
		}
		return true;
	}

	@Override
	public boolean removeImplPlanApp(String id) {
		implPlanAppDao.executeHql("delete from ImplPlanApp where id = ?", new Object[] { id });
		Long qty = implPlanAppDao.count("select count(id) from ImplPlanApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeImplPlanAppFalse(String id) {
		implPlanAppDao.executeHql("update ImplPlanApp set delFlag = ? where id = ?", new Object[] { ImplPlanApp.REMOVED, id });
		Long qty = implPlanAppDao.count("select count(id) from ImplPlanApp where id = ? and delFlag = ? " , new Object[] { id, ImplPlanApp.NORMAL });
		if ( qty.intValue() == 0 ) {
			implPlanAttDao.executeHql("update ImplPlanAtt set delFlag = ? where implPlanAppId = ?", new Object[] { ImplPlanAtt.REMOVED, id });
			return true;
		}
		return false;
	}

	@Override
	public ImplPlanApp getImplPlanAppById(String id) {
		return implPlanAppDao.get(ImplPlanApp.class, id);
	}

	@Override
	public Long getImplPlanAppQty(String queryParams) {
		if ( queryParams != null && !"".equals(queryParams) ) {
			queryParams = "%" + queryParams + "%";
			return implPlanAppDao.count("select count(id) from ImplPlanApp where delFlag = ? and title like ?", new Object[]{ ImplPlanApp.NORMAL, queryParams });
		}
		return implPlanAppDao.count("select count(id) from ImplPlanApp where delFlag = ?", new Object[]{ ImplPlanApp.NORMAL });
	}

	@Override
	public List<ImplPlanApp> getImplPlanApps() {
		return implPlanAppDao.find("from ImplPlanApp where delFlag = ? order by createdDate desc", new Object[]{  });
	}

	@Override
	public List<ImplPlanApp> getImplPlanApps(int startIndex, int rows, String sorter,String sortingAttribute, String queryParams) {
		if( queryParams != null && !"".equals(queryParams) ) {
			queryParams = "%" + queryParams + "%";
			String hql = "from ImplPlanApp where delFlag = ? and title like ?  order by " + sorter + " " + sortingAttribute;
			return implPlanAppDao.search(hql,new Object[]{ ImplPlanApp.NORMAL, queryParams }, startIndex, rows);
		}
		return implPlanAppDao.search("from ImplPlanApp where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[]{ ImplPlanApp.NORMAL }, startIndex, rows);
	}
	
	
}
