package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.service.ImplPlanParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImplPlanParticipantController extends BaseController {

	@Resource
	private ImplPlanParticipantService implPlanParticipantService;
	
	/***
	 * 根据内部审核实施计划申请参与人员ID删除内部审核实施计划参与人员信息
	 * @param id 内部审核实施计划申请申请ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANPATICIPANT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeImplPlanApp(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = implPlanParticipantService.removeImplPlanParticipant(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
}
