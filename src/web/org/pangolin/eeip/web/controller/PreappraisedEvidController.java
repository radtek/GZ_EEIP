package org.pangolin.eeip.web.controller;

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
import org.pangolin.eeip.entity.PreappraisedEvid;
import org.pangolin.eeip.service.PreappraisedEvidService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

@Controller
public class PreappraisedEvidController extends BaseController{
	
	@Resource
	private PreappraisedEvidService preappraisedEvidService;
	
	/***
	 * 保存待鉴定电子物证（检材）信息 表
	 * @param preappraisedEvid 待鉴定电子物证（检材）信息 对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISEDEVID_SAVEPREAPPRAISEDEVIDDATA)
	@ResponseBody
	public Map<String, Object> savePreappraisedEvid(HttpServletRequest request,
            HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			String jsonStr = request.getParameter("arrList");
			//存储需要insert的项目人员关系信息
			JSONArray array = JSONArray.fromObject(jsonStr.toString());
			List<PreappraisedEvid> arrayList = (List<PreappraisedEvid>) JSONArray.toCollection(array, PreappraisedEvid.class);
			if(arrayList.size() > 0){
				String preappraisalId = arrayList.get(0).getPreappraisalId();
				preappraisedEvidService.removePreappraisedEvid(preappraisalId);
				for (PreappraisedEvid preappraisedEvid : arrayList) {
					preappraisedEvidService.savePreappraisedEvid(preappraisedEvid);
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
	 * 根据待鉴定电子物证（检材）信息 ID获取待鉴定电子物证（检材）信息 信息
	 * @param id 待鉴定电子物证（检材）信息 ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISEDEVID_LOADPREAPPRAISEDEVIDDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisedEvidDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			PreappraisedEvid preappraisedEvid;
			if(id != null || !"".equals(id)){
				preappraisedEvid = preappraisedEvidService.getPreappraisedEvidById(id);
				preappraisedEvid = preappraisedEvid == null ? new PreappraisedEvid() : preappraisedEvid;
			}else{
				preappraisedEvid = new PreappraisedEvid();
			}
			result.put("entity", preappraisedEvid);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new PreappraisedEvid());
		}
		return result;
	}
	
	/***
	 * 根据待鉴定电子物证（检材）信息 ID删除待鉴定电子物证（检材）信息 信息
	 * @param 返回List 送检检材信息
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISEDEVID_PREAPPRAISEDEVIDDATALIST)
	@ResponseBody
	public List<PreappraisedEvid> removePreappraisedEvid(String preappraisalId){
		return preappraisedEvidService.getPreappraisedEvids(preappraisalId);
	}
	
	/***
	 * 待鉴定电子物证（检材）信息 信息列表数据源
	 * @return 待鉴定电子物证（检材）信息 数据集JSON
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISEDEVID_PREAPPRAISEDEVIDGIRDDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisedEvidList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<PreappraisedEvid> list = preappraisedEvidService.getPreappraisedEvids(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = preappraisedEvidService.getPreappraisedEvidQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
