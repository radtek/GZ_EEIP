package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Province;
import org.pangolin.eeip.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 省
 * @author liaoqi
 *
 */
@Controller
public class ProvinceController extends BaseController {
	
	@Autowired
	private ProvinceService provinceService;

	/**
	 * 下拉框数据源
	 * @return
	 */
	@RequestMapping(NavConst.PROVINCE_OPTIONS_DATE)
	@ResponseBody
	public Map<String, Object> getProvince() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Province> provinceList = provinceService.getProvinces();
		resultMap.put("entity", provinceList);
		return resultMap;
	}
}
