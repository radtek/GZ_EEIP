package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Province;

/**
 * 省service
 * @author liaoqi
 *
 */
public interface ProvinceService {
	
	/**
	 * 通过编号，查询实体
	 * @param provinceId
	 * @return
	 */
	public Province getProvince(String provinceId);
	
	/**
	 * 获取所有实体
	 * @return
	 */
	public List<Province> getProvinces();
	
	/**
	 * 通过编号，查询实体
	 * @param provinceId
	 * @return
	 */
	public Province getProvinceByProvinceId(String provinceId);
	
	/**
	 * 获取所有省级数量
	 * @author Oscar Mok
	 * @return 省级数量
	 * */
	public Long getProvinceQty();
}