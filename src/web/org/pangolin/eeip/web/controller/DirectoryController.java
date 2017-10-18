package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Directory;
import org.pangolin.eeip.service.DirectoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DirectoryController extends BaseController {

	@Resource(name = "directoryService")
	private DirectoryService directoryService;
	
	/***
	 * 获取所有的文件夹
	 * @return
	 */
	@RequestMapping(NavConst.DIRECTORY_MGT_LIST_DATA)
	@ResponseBody
	public Map<String,Object> getDirectors() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Directory> list = directoryService.getDirectorys();
		result.put("entity", list);
		return result;
	}
}
