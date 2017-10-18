package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.AnnualPlanAppDto;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AnnualPlanApp;
import org.pangolin.eeip.service.AnnualPlanAppService;
import org.pangolin.eeip.service.AnnualPlanAttService;
import org.pangolin.eeip.service.AnnualPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnnualPlanAppController extends BaseController {

	@Resource(name = "annualPlanAppService")
	private AnnualPlanAppService annualPlanAppService;
	
	@Resource
	private AnnualPlanService annualPlanService;
	
	@Resource
	private AnnualPlanAttService annualPlanAttService;
	
	/***
	 * 保存年度内部审核申请信息
	 * @param annualPlanApp 年度内部审核申请对象
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLANAPP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAnnualPlanApp(@RequestBody AnnualPlanAppDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			AnnualPlanApp annualPlanApp = AnnualPlanAppDto.convertToAnnualPlanApp(dto);
			status = annualPlanAppService.saveAnnualPlanApp(annualPlanApp);
			/*//获取年度内部审核信息并保存
			List<AnnualPlan> annualPlans = dto.getAnnualPlans();
			if ( annualPlans != null && annualPlans.size() > 0 ) {
				for ( AnnualPlan annualPlan : annualPlans ) {
					annualPlan.setAnnualPlanAppId(annualPlanApp.getId());
					annualPlan.setCreatorId(annualPlanApp.getCreatorId());
					annualPlan.setCreatorAlias(annualPlanApp.getCreatorAlias());
					annualPlan.setCreatorName(annualPlanApp.getCreatorName());
					annualPlan.setYear(annualPlanApp.getYear());
					status = annualPlanService.saveAnnualPlan(annualPlan);
				}
			}*/
			// 附件
			List<String> addAtt = dto.getAddAtt();
			if ( addAtt != null && addAtt.size() > 0 ) {
				for ( String id : addAtt ) {
					annualPlanAttService.updateAnnualPlanAttStatus(id);
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
	 * 根据年度内部审核申请ID获取年度内部审核申请信息
	 * @param id 年度内部审核申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLANAPP_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getAnnualPlanAppDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			AnnualPlanApp annualPlanApp = annualPlanAppService.getAnnualPlanAppById(id);
			List<AnnualPlan> annualPlans = new ArrayList<AnnualPlan>();
			if ( annualPlanApp != null ) {
				annualPlans = annualPlanService.getAnnualPlansByAppId(annualPlanApp.getId()); 
				annualPlans = AnnualPlanAppDto.convertToAnnualPlan(annualPlans);
			}
			if ( annualPlans.size() == 0 ) {
				annualPlans.add(new AnnualPlan()); 
			}
			annualPlanApp = annualPlanApp == null ? new AnnualPlanApp() : annualPlanApp;
			AnnualPlanAppDto appDto = AnnualPlanAppDto.converToAnnualPlanDto(annualPlanApp);
			appDto.setAnnualPlans(annualPlans);
			result.put("entity", appDto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new AnnualPlanApp());
		}
	
		return result;
	}
	
	/***
	 * 根据年度内部审核申请ID删除年度内部审核申请信息（伪删除）
	 * @param id 年度内部审核申请ID
	 * @return
	 */
	@RequestMapping(NavConst.ANNUALPLANAPP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeAnnualPlanApp(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = annualPlanAppService.removeAnnualPlanAppFalse(id);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 年度内部审核申请信息列表数据源
	 * @return 年度内部审核申请数据集JSON
	 */
	@RequestMapping(NavConst.ANNUALPLANAPP_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAnnualPlanAppList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		List<AnnualPlanApp> list =  annualPlanAppService.getAnnualPlanApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		long totalCount = annualPlanAppService.getAnnualPlanAppQty(queryParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
