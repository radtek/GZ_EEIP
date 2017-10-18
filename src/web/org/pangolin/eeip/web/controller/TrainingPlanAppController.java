package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.TrainingPlanAppDto;
import org.pangolin.eeip.entity.TrainingPlanApp;
import org.pangolin.eeip.service.TrainingPlanAppService;
import org.pangolin.eeip.service.TrainingPlanAttService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrainingPlanAppController extends BaseController {

	@Resource
	private TrainingPlanAppService trainingPlanAppService;
	
	@Resource
	private TrainingPlanAttService trainingPlanAttService;
	
	/***
	 * 保存培训计划信息
	 * @param annualPlanApp 培训计划对象
	 * @return
	 */
	@RequestMapping(NavConst.TRAININGPLANAPP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveTrainingPlanApp(@RequestBody TrainingPlanAppDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			TrainingPlanApp annualPlanApp = dto.getTrainingPlanApp();
			status = trainingPlanAppService.saveTrainingPlanApp(annualPlanApp);

			// 附件
			List<String> addAtt = dto.getAddAtt();
			if ( addAtt != null && addAtt.size() > 0 ) {
				for ( String id : addAtt ) {
					trainingPlanAttService.updateTrainingPlanAttStatus(id);
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
	 * 根据培训计划ID获取培训计划信息
	 * @param id 培训计划ID
	 * @return
	 */
	@RequestMapping(NavConst.TRAININGPLANAPP_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getTrainingPlanAppDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			TrainingPlanApp trainingPlanApp = trainingPlanAppService.getTrainingPlanAppById(id);
			trainingPlanApp = trainingPlanApp == null ? new TrainingPlanApp() : trainingPlanApp;
			TrainingPlanAppDto appDto = new TrainingPlanAppDto();
			appDto.setTrainingPlanApp(trainingPlanApp);
			result.put("entity", appDto);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new TrainingPlanAppDto());
		}
	
		return result;
	}
	
	/***
	 * 根据培训计划ID删除培训计划信息（伪删除）
	 * @param id 培训计划ID
	 * @return
	 */
	@RequestMapping(NavConst.TRAININGPLANAPP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeTrainingPlanApp(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = trainingPlanAppService.removeTrainingPlanAppFalse(id);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 培训计划信息列表数据源
	 * @return 培训计划数据集JSON
	 */
	@RequestMapping(NavConst.TRAININGPLANAPP_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getTrainingPlanAppList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		List<TrainingPlanApp> list =  trainingPlanAppService.getTrainingPlanApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		long totalCount = trainingPlanAppService.getTrainingPlanAppQty(queryParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
