package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.ImplPlanAppDto;
import org.pangolin.eeip.entity.ImplPlan;
import org.pangolin.eeip.entity.ImplPlanApp;
import org.pangolin.eeip.entity.ImplPlanIaParticipant;
import org.pangolin.eeip.entity.ImplPlanParticipant;
import org.pangolin.eeip.service.ImplPlanAppService;
import org.pangolin.eeip.service.ImplPlanAttService;
import org.pangolin.eeip.service.ImplPlanIaParticipantService;
import org.pangolin.eeip.service.ImplPlanParticipantService;
import org.pangolin.eeip.service.ImplPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImplPlanAppController extends BaseController {

	@Resource
	private ImplPlanAppService implPlanAppService;
	
	@Resource
	private ImplPlanService implPlanService;
	
	@Resource
	private ImplPlanIaParticipantService implPlanIaParticipantService;
	
	@Resource
	private ImplPlanParticipantService implPlanParticipantService;
	
	@Resource
	private ImplPlanAttService implPlanAttService;
	
	/***
	 * 保存内部审核实施计划申请申请信息
	 * @param meetingApp 内部审核实施计划申请申请对象
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANAPP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveImplPlanApp(@RequestBody ImplPlanAppDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			ImplPlanApp implPlanApp = ImplPlanAppDto.converToImPlanApp(dto);
			status = implPlanAppService.saveImplPlanApp(implPlanApp);
			
			/*status = implPlanParticipantService.removeImplPlanParticipantByAppId(implPlanApp.getId());
			//参会人员
			List<ImplPlanParticipant> participants = dto.getParticipants();
			if ( participants != null && participants.size() > 0 ) {
				for ( ImplPlanParticipant participant : participants ) {
					participant.setImplPlanAppId(implPlanApp.getId());
					status = implPlanParticipantService.saveImplPlanParticipant(participant);
				}
			}
			
			status = implPlanIaParticipantService.removeImplPlanIaParticipantByAppId(implPlanApp.getId());
			//内审成员
			List<ImplPlanIaParticipant> iaParticipants = dto.getIaParticipants();
			if( iaParticipants != null && iaParticipants.size() > 0 ) {
				for( ImplPlanIaParticipant iaParticipant : iaParticipants ) {
					iaParticipant.setImplPlanAppId(implPlanApp.getId());
					status = implPlanIaParticipantService.saveImplPlanIaParticipant(iaParticipant);
				}
			}*/
			
			// 附件
			List<String> addAtt = dto.getAddAtt();
			if ( addAtt != null && addAtt.size() > 0 ) {
				for ( String id : addAtt ) {
					implPlanAttService.updateImplPlanAttStatus(id);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内部审核实施计划申请申请ID获取内部审核实施计划申请申请信息
	 * @param id 内部审核实施计划申请申请ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANAPP_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getImplPlanAppDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			ImplPlanApp implPlanApp = implPlanAppService.getImplPlanAppById(id);
			List<ImplPlan> implPlans = new ArrayList<ImplPlan>();
			List<ImplPlanParticipant> participants = new ArrayList<ImplPlanParticipant>();
			List<ImplPlanIaParticipant> iaParticipants = new ArrayList<ImplPlanIaParticipant>();
			if ( implPlanApp != null ) {
				implPlans = implPlanService.getImplPlansByAppId(id);
				participants = implPlanParticipantService.getImplPlanParticipantsByAppId(id);
				iaParticipants = implPlanIaParticipantService.getImplPlanIaParticipantsByAppId(id);
			}
			implPlanApp = implPlanApp == null ? new ImplPlanApp() : implPlanApp;
			ImplPlanAppDto dto = ImplPlanAppDto.converToImplPlanAppDto(implPlanApp);
			dto.setImplPlans(implPlans);
			dto.setParticipants(participants);
			dto.setIaParticipants(iaParticipants);
			result.put("entity", dto);
		} catch(Exception e) {
			e.printStackTrace();
			result.put("entity", new ImplPlanApp());
		}
	
		return result;
	}
	
	/***
	 * 根据内部审核实施计划申请申请ID删除内部审核实施计划申请申请信息（伪删除）
	 * @param id 内部审核实施计划申请申请ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANAPP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeImplPlanApp(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = implPlanAppService.removeImplPlanAppFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 内部审核实施计划申请申请信息列表数据源
	 * @return 内部审核实施计划申请申请数据集JSON
	 */
	@RequestMapping(NavConst.IMPLPLANAPP_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getImplPlanAppList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String	key = params.getExtraParam("key");
		List<ImplPlanApp> list =  implPlanAppService.getImplPlanApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),key);
		long totalCount = implPlanAppService.getImplPlanAppQty(key);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
