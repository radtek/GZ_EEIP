package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.CityDao;
import org.pangolin.eeip.entity.City;
import org.pangolin.eeip.service.CityService;
import org.springframework.stereotype.Service;

/**
 * 市service实现类
 * @author liaoqi
 *
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

	@Resource
	private CityDao cityDao;
	
	/**
	 * 通过编号，查询实体
	 */
	@Override
	public City getCity(String cityId) {
		// TODO Auto-generated method stub
		return cityDao.get(City.class, cityId);
	}

	/**
	 * 通过外键，查询实体
	 */
	@Override
	public List<City> getCityByProvinceId(String provinceId) {
		// TODO Auto-generated method stub
		return cityDao.find(" from City where provinceId = ? ", new Object[]{provinceId});
	}

	@Override
	public City getCityByCityId(String cityId) {
 		return cityDao.get(" from City where cityId =?", new Object[]{cityId});
	}
	
	public Long getCityQty() {
		return cityDao.count("select count(id) from City", new Object[] {  });
	}
}