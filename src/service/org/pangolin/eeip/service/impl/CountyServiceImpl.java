package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.CountyDao;
import org.pangolin.eeip.entity.County;
import org.pangolin.eeip.service.CountyService;
import org.springframework.stereotype.Service;

/**
 * 县/区service实现类
 * @author liaoqi
 *
 */
@Service("countyService")
public class CountyServiceImpl implements CountyService {
	
	@Resource
	private CountyDao countyDao;

	/**
	 * 通过编号，查询实体
	 */
	@Override
	public County getCounty(String countyId) {
		// TODO Auto-generated method stub
		return countyDao.get(County.class, countyId);
	}

	/**
	 * 通过外键，查询实体
	 */
	@Override
	public List<County> getCountyByCityId(String cityId) {
		// TODO Auto-generated method stub
		return countyDao.find(" from County where cityId = ? ", new Object[]{cityId});
	}

	@Override
	public County getCountyByCountyId(String countyId) {
 		return countyDao.get(" from County where countyId=? ", new Object[]{countyId});
	}
	
	public Long getCountyQty() {
		return countyDao.count("select count(id) from County", new Object[] {  });
	}
}