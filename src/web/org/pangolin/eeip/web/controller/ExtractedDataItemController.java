package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.ExtractedDataItem;
import org.pangolin.eeip.service.ExtractedDataItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExtractedDataItemController extends BaseController{
	
	@Resource
	private ExtractedDataItemService extractedDataItemService;
	
	/***
	 * 保存提取电子数据清单表
	 * @param extractedDataItem 提取电子数据清单对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EXTRACTEDDATAITEM_SAVEEXTRACTEDDATAITEM)
	@ResponseBody
	public Map<String, Object> saveExtractedDataItem(@RequestBody ExtractedDataItem extractedDataItem){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = extractedDataItemService.saveExtractedDataItem(extractedDataItem);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据ID查询  提取电子数据清单
	 * @param id 提取电子数据清单 ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EXTRACTEDDATAITEM_LOADEXTRACTEDDATAITEM)
	@ResponseBody
	public Map<String, Object> getExtractedDataItemDataById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			ExtractedDataItem extractedDataItem = null;
			if(id != null && !"".equals(id)){
				extractedDataItem = extractedDataItemService.getExtractedDataItemById(id);
			}
			extractedDataItem = extractedDataItem == null ? new ExtractedDataItem() : extractedDataItem;
			result.put("entity", extractedDataItem);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ExtractedDataItem());
		}
		return result;
	}
	
	/***
	 * 根据ID查询  提取电子数据清单
	 * @param id 提取电子数据清单 ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_EXTRACTEDDATAITEM_LOADEXTRACTEDDATAITEMLIST)
	@ResponseBody
	public Map<String, Object> getExtractedDataItemDataList(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<ExtractedDataItem>	list = extractedDataItemService.getExtractedDataItemByExtractedDataId(id);
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ExtractedDataItem());
		}
		return result;
	}
	
	/***
	 * 删除提取电子数据清单信息（伪删除）
	 * @param id 提取电子数据清单ID
	 * @return
	 */
//	@RequestMapping()
	@ResponseBody
	public Map<String, Object> removeExtractedDataItem(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = extractedDataItemService.removeExtractedDataItem(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	

}
