package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.MgtRvwPlanAppDto;
import org.pangolin.eeip.entity.MgtRvwPlanApp;
import org.pangolin.eeip.service.MgtRvwPlanAppService;
import org.pangolin.eeip.service.MgtRvwPlanAttService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class MgtRvwPlanAppController extends BaseController {

	@Resource
	private MgtRvwPlanAppService mgtRvwPlanAppService;
	
	@Resource
	private MgtRvwPlanAttService mgtRvwPlanAttService;
	
	/***
	 * 保存管理评审计划信息
	 * @param meetingApp 管理评审计划对象
	 * @return
	 */
	@RequestMapping(NavConst.MGTRVWPLANAPP_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveMgtRvwPlanApp(@RequestBody MgtRvwPlanAppDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			MgtRvwPlanApp mgtRvwPlanApp = dto.getMgtRvwPlanApp();
			status = mgtRvwPlanAppService.saveMgtRvwPlanApp(mgtRvwPlanApp);
			
			// 管理评审附件
			List<String> addIds = dto.getAddAtt();
			if ( addIds != null && addIds.size() > 0 ) {
				for ( String id : addIds ) {
					mgtRvwPlanAttService.updateMgtRvwPlanAttStatus(id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据管理评审计划ID获取管理评审计划信息
	 * @param id 管理评审计划ID
	 * @return
	 */
	@RequestMapping(NavConst.MGTRVWPLANAPP_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMgtRvwPlanApp(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MgtRvwPlanApp mgtRvwPlanApp = mgtRvwPlanAppService.getMgtRvwPlanAppById(id);
			mgtRvwPlanApp = mgtRvwPlanApp == null ? new MgtRvwPlanApp() : mgtRvwPlanApp;
			MgtRvwPlanAppDto dto = new MgtRvwPlanAppDto();
			dto.setMgtRvwPlanApp(mgtRvwPlanApp);
			result.put("entity", dto);
		} catch(Exception e) {
			e.printStackTrace();
			result.put("entity", new MgtRvwPlanApp());
		}
	
		return result;
	}
	
	/***
	 * 根据管理评审计划ID删除管理评审计划信息
	 * @param id ID
	 */
	@RequestMapping(NavConst.MGTRVWPLANAPP_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String,Object> removeMgtRvwPlanAppById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = mgtRvwPlanAppService.removeMgtRvwPlanAppFalse(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 管理评审计划申请申请信息列表数据源
	 * @return 管理评审计划申请申请数据集JSON
	 */
	@RequestMapping(NavConst.MGTRVWPLANAPP_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMgtRvwPlanAppList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String	key = params.getExtraParam("key");
		List<MgtRvwPlanApp> list =  mgtRvwPlanAppService.getMgtRvwPlanApps(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),key);
		long totalCount = mgtRvwPlanAppService.getMgtRvwPlanAppQty(key);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
}
