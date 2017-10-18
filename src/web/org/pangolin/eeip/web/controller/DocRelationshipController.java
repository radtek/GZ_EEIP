package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.service.DocRelationshipService;
import org.springframework.stereotype.Controller;
import org.pangolin.eeip.common.NavConst;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocRelationshipController extends BaseController {

	@Resource
	private DocRelationshipService docRelationshipService;
	
	/***
	 * 保存相关文件信息
	 * @param folder 相关文件对象
	 * @return
	 */
	//@RequestMapping()
	@ResponseBody
	public Map<String, Object> saveDocRelationship(@RequestBody DocRelationship directory) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = docRelationshipService.saveDocRelationship(directory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据相关文件ID获取相关文件信息
	 * @param id 相关文件ID
	 * @return
	 */
	//@RequestMapping()
	@ResponseBody
	public Map<String, Object> getDocRelationshipDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			DocRelationship folder = docRelationshipService.getDocRelationshipById(id);
			folder = folder == null ? new DocRelationship() : folder;
			result.put("entity", folder);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new DocRelationship());
		}
	
		return result;
	}
	
	/***
	 * 根据相关文件ID删除相关文件信息
	 * @param id 相关文件ID
	 * @return
	 */
	@RequestMapping(NavConst.DOC_RELATIONSHIP_MGT_RMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeDocRelationship(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = docRelationshipService.removeDocRelationship(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 相关文件信息列表数据源
	 * @return 相关文件数据集JSON
	 */
	//@RequestMapping()
	@ResponseBody
	public Map<String, Object> getDocRelationshipList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<DocRelationship> list =  docRelationshipService.getDocRelationships(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = docRelationshipService.getDocRelationshipQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
