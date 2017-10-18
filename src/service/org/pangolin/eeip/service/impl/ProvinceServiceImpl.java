package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ProvinceDao;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Province;
import org.pangolin.eeip.service.ProvinceService;
import org.springframework.stereotype.Service;

/**
 * 省service实现类
 * @author liaoqi
 *
 */
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
	private ProvinceDao provinceDao;
	
	/**
	 * 通过编号，查询实体
	 */
	@Override
	public Province getProvince(String provinceId) {
		// TODO Auto-generated method stub
		return provinceDao.get(Province.class, provinceId);
	}

	/**
	 * 获取所有实体
	 */
	@Override
	public List<Province> getProvinces() {
		// TODO Auto-generated method stub
		return provinceDao.find(" from Province ");
	}

	@Override
	public Province getProvinceByProvinceId(String provinceId) {
 		return provinceDao.get(" from Province where provinceId =? ", new Object[]{provinceId});
	}
	
	public Long getProvinceQty() {
		return provinceDao.count("select count(id) from Province", new Object[] {  });
	}
}