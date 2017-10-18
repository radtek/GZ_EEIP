package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.EvidType;
import org.pangolin.eeip.service.ElecEvidTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 电子物证类型Controller
 * @author 
 *
 */
@Controller
@SuppressWarnings("all")
public class ElecEvidTypeController extends BaseController{
	 
	
	@Resource(name = "elecEvidTypeService")
	private ElecEvidTypeService elecEvidTypeService;
		
	
	/***
	 * 电子物证类型列表
	 * @return
	 */
	//@RequestMapping(NavConst.ELECEVIDTYPE_STOCK_MGT_LIST)
	@ResponseBody
	public Map<String,Object> getElecEvidTypeLists(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest()); 
        Long total = null;
        List<EvidType> list = null;
		try{
			if(params != null){
				String query = params.getExtraParam("query").trim();
				if(query != null && !"".equals(query)){
					list = elecEvidTypeService.getElecEvidTypes(query, params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
					total = elecEvidTypeService.count(query);
				}else{
					list = elecEvidTypeService.getElecEvidTypes(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
					total = elecEvidTypeService.count();
				}
			}
		}catch(Exception e){
			list = new ArrayList<EvidType>();
			total = 0L;
			e.printStackTrace();
		}
		return BootstrapDataGridUtil.getResultMap(params, total, list);
	}
	
	/***
	 * 新增保存来访人信息信息
	 * @param produceStock
	 * @return
	 */
	//@RequestMapping(NavConst.ELECEVIDTYPE_STOCK_MGT_SAVE)
	@ResponseBody
	public Map<String,Object> saveElecEvidType(@RequestBody EvidType elecEvidType){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean status = false;
		try{
			status = elecEvidTypeService.add(elecEvidType);
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("status", status);
		return map;
	}
	
	/***
	 * 根据ID获取来访人详细信息
	 * @param id ID
	 * @return
	 */
	//@RequestMapping(NavConst.ELECEVIDTYPE_STOCK_MGT_DETAIL)
	@ResponseBody
	public Map<String,Object> getElecEvidTypeById(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			EvidType elecEvidType = elecEvidTypeService.getElecEvidTypeById(id);
			elecEvidType = elecEvidType == null ? new EvidType() : elecEvidType;
			map.put("entity", elecEvidType);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return map;
	}
	
	/***
	 * 根据ID删除纳税人商品库存信息
	 * @param id ID
	 * @return
	 */
	//@RequestMapping(NavConst.ELECEVIDTYPE_STOCK_MGT_REMOVE)
	@ResponseBody
	public Map<String,Object> remove(String id){
		Map<String,Object> map = new HashMap<String, Object>();
		boolean status = false;
		try{
			if(id != null){
				status = elecEvidTypeService.remove(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put("status", status);
		return map;
	}	
	
	
    
	
	
}
