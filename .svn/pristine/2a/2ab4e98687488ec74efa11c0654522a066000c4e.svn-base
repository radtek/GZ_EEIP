package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.service.ImplPlanIaParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImplPlanIaParticipantController extends BaseController {

	@Resource
	private ImplPlanIaParticipantService implPlanIaParticipantService;
	
	/***
	 * 根据内部审核实施计划申请审核员ID删除内部审核实施计划审核员信息
	 * @param id 内部审核实施计划申请申请ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANIAPATICIPANT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeImplPlanApp(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = implPlanIaParticipantService.removeImplPlanIaParticipant(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
}
