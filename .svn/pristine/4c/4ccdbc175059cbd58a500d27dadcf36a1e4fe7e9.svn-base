package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.County;
import org.pangolin.eeip.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 县/区
 * @author liaoqi
 *
 */
@Controller
public class CountyController extends BaseController {
	
	@Autowired
	private CountyService countyService;
	
	/**
	 * 下拉框数据源
	 * @return
	 */
	@RequestMapping(NavConst.COUNTY_OPTIONS_DATE)
	@ResponseBody
	public Map<String, Object> getCounty(String cityId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<County> countyList = countyService.getCountyByCityId(cityId);
		resultMap.put("entity", countyList);
		return resultMap;
	}
}
