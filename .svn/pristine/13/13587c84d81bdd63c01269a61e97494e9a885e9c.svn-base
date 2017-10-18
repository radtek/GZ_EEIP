package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.PreappraisalEntruster;
import org.pangolin.eeip.service.PreappraisalEntrusterService;
import org.pangolin.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PreappraisalEntrusterController extends BaseController{
	
	@Resource
	private PreappraisalEntrusterService preappraisalEntrusterService;
	
	/***
	 * 保存电子物证（检材）预检信息表
	 * @param preappraisalEntruster 电子物证（检材）预检信息对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_SAVEPREAPPRAISALENTRUSTERDATA)
	@ResponseBody
	public Map<String, Object> savePreappraisalEntruster(HttpServletRequest request,
            HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			String jsonStr = request.getParameter("arrList");
			//存储需要insert的项目人员关系信息
			JSONArray array = JSONArray.fromObject(jsonStr.toString());
			List<PreappraisalEntruster> arrayList = (List<PreappraisalEntruster>) JSONArray.toCollection(array, PreappraisalEntruster.class);
			if(arrayList.size() > 0){
				String preappraisalId = arrayList.get(0).getPreappraisalId();
				preappraisalEntrusterService.removePreappraisalEntruster(preappraisalId);
				for (PreappraisalEntruster preappraisalEntruster : arrayList) {
					preappraisalEntrusterService.savePreappraisalEntruster(preappraisalEntruster);
				}
				status = true;
			}
		}catch(Exception e){
			status = false;
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID获取电子物证（检材）预检信息信息
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_LOADPREAPPRAISALENTRUSTERDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisalEntrusterDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			PreappraisalEntruster preappraisalEntruster = preappraisalEntrusterService.getPreappraisalEntrusterById(id);
			preappraisalEntruster = preappraisalEntruster == null ? new PreappraisalEntruster() : preappraisalEntruster;
			result.put("entity", preappraisalEntruster);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new PreappraisalEntruster());
		}
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID 获取送件人集合
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_GETPREAPPRAISALENTRUSTERLISTBYPREAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getPreappraisalEntrusterListByPreappraisalId(String preappraisalId){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<PreappraisalEntruster> list = preappraisalEntrusterService.getPreappraisalEntrusterListByPreappraisalId(preappraisalId);
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new ArrayList<PreappraisalEntruster>());
		}
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID获取电子物证（检材）预检信息信息
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_GETPREAPPRAISALENTRUSTERBYPREAPPRAISALID)
	@ResponseBody
	public Map<String, Object> getPreappraisalEntrusterBypreappraisalId(String preappraisalDataId){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			PreappraisalEntruster preappraisalEntruster = preappraisalEntrusterService.getPreappraisalEntrusterBypreappraisalId(preappraisalDataId);
			preappraisalEntruster = preappraisalEntruster == null ? new PreappraisalEntruster() : preappraisalEntruster;
			result.put("entity", preappraisalEntruster);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new PreappraisalEntruster());
		}
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID获取电子物证（检材）预检信息信息
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_LOADPREAPPRAISALENTRUSTERLIST)
	@ResponseBody
	public List<PreappraisalEntruster> getPreappraisalEntrusterList(String PreappraisalId){
		List<PreappraisalEntruster> preappraisalEntrusters = preappraisalEntrusterService.getPreappraisalEntrusters(PreappraisalId);
//		System.out.println(preappraisalEntrusters.size());
		return preappraisalEntrusters;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID删除电子物证（检材）预检信息信息（伪删除）
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
//	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_LOADPREAPPRAISALENTRUSTERLIST)
	@ResponseBody
	public Map<String, Object> removePreappraisalEntruster(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = preappraisalEntrusterService.removePreappraisalEntruster(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 电子物证（检材）预检信息信息列表数据源
	 * @return 电子物证（检材）预检信息数据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALENTRUSTER_PREAPPRAISALENTRUSTERGIRDDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisalEntrusterList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<PreappraisalEntruster> list = preappraisalEntrusterService.getPreappraisalEntrusters(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = preappraisalEntrusterService.getPreappraisalEntrusterQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
