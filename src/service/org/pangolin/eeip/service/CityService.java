package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.City;

/**
 * 市service
 * @author liaoqi
 *
 */
public interface CityService {
	
	/**
	 * 通过编号，查询实体
	 * @param cityId
	 * @return
	 */
	public City getCity(String cityId);
	
	/**
	 * 通过编号，查询实体
	 * @param cityId
	 * @return
	 */
	public City getCityByCityId(String cityId);
	
	/**
	 * 通过外键，查询实体
	 * @param provinceId
	 * @return
	 */
	public List<City> getCityByProvinceId(String provinceId);
	
	/**
	 * 获取所有市级数量
	 * @author Oscar Mok
	 * @return 市级数量
	 * */
	public Long getCityQty();
}
