package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.City;
import org.pangolin.eeip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 市
 * @author liaoqi
 *
 */
@Controller
public class CityController extends BaseController {
	
	@Autowired
	private CityService cityService;

	/**
	 * 下拉框数据源
	 * @return
	 */
	@RequestMapping(NavConst.CITY_OPTIONS_DATE)
	@ResponseBody
	public Map<String, Object> getCity(String provinceId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<City> cityList = cityService.getCityByProvinceId(provinceId);
		resultMap.put("entity", cityList);
		return resultMap;
	}
}
