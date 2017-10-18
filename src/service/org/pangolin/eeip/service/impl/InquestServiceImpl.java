package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.InquestDao;
import org.pangolin.eeip.dao.InquestDocDao;
import org.pangolin.eeip.entity.Inquest;
import org.pangolin.eeip.entity.InquestDoc;
import org.pangolin.eeip.service.InquestService;
import org.springframework.stereotype.Service;

@Service("inquestService")
@SuppressWarnings("all")
public class InquestServiceImpl implements InquestService {

	@Resource
	private InquestDao inquestDao;
	
	@Resource
	private InquestDocDao inquestDocDao;
	
	@Override
	public boolean saveInquest(Inquest inquest) {
		Long qty = inquestDao.count("select count(id) from Inquest where id = ?", new Object[]{ inquest.getId() });
		if ( qty > 0 ) {
		    inquest.setModifiedDate(new Date());
		    inquestDao.update(inquest);
		} else {
			inquestDao.save(inquest);
		}
		
		return true;
	}

	@Override
	public boolean removeInquest(String id) {
		inquestDao.executeHql("delete from Inquest where id = ?", new Object[] { id });
		Long qty = inquestDao.count("select count(id) from Inquest where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	@Override
	public boolean removeInquestFalse(String id) {
		inquestDao.executeHql("update Inquest set delFlag = ? where id = ?", new Object[] { Inquest.REMOVED, id });
		Long qty = inquestDao.count("select count(id) from Inquest where id = ? and delFlag = ? " , new Object[] { id, Inquest.NORMAL });
		if ( qty.intValue() == 0 ) {
			inquestDocDao.executeHql("update InquestDoc set delFlag = ? where inquestId = ?", new Object[] { InquestDoc.REMOVED, id });
			return true;
		}
		return false;
	}

	@Override
	public Inquest getInquestById(String id) {
		return inquestDao.get(Inquest.class, id);
	}

	@Override
	public Long getInquestQty(String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			String hql = "select count(id) from Inquest where delFlag = ? and (sn like ? or caseName like ? ) ";
			return inquestDao.count(hql, new Object[]{ Inquest.NORMAL, queryParam, queryParam });
		}
		return inquestDao.count("select count(id) from Inquest where delFlag = ? ", new Object[]{ Inquest.NORMAL });
	}

	@Override
	public List<Inquest> getInquests() {
		return inquestDao.find("from Inquest where delFlag = ? order by createdDate desc", new Object[]{ Inquest.NORMAL });
	}

	@Override
	public List<Inquest> getInquests(int startIndex, int rows, String sorter,String sortingAttribute,String queryParam) {
		if ( queryParam != null && !"".equals(queryParam) ) {
			queryParam = "%" + queryParam + "%";
			String hql = "from Inquest where delFlag = ? and (sn like ? or caseName like ?) order by " + sorter + " " + sortingAttribute;
			return inquestDao.search(hql, new Object[] { Inquest.NORMAL, queryParam, queryParam }, startIndex, rows);
		}
		return inquestDao.search("from Inquest where delFlag = ? order by " + sorter + " " + sortingAttribute, new Object[] { Inquest.NORMAL }, startIndex, rows);
	}
}
