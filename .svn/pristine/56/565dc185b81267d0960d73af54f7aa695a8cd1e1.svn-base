package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.UserTraining;
import org.pangolin.eeip.service.UserTrainingService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class UserTrainingController extends BaseController {

	@Autowired
	private UserTrainingService userTrainingService;
	
	/**
	 * 培训履历列表数据源
	 * @author Xiaolin Yin
	 * @return 培训履历数据集JSON
	 * */
	//@RequestMapping(NavConst.UserTraining_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = 0;
		List<UserTraining> resultList = new ArrayList<UserTraining>();
		 
		totalCount=userTrainingService.getUserTrainingQty();
		resultList=userTrainingService.getUserTrainings(params.getStart(), params.getLimit(),params.getSorter(), params.getSorterDirection());
		
		return BootstrapDataGridUtil.getResultMap(params, totalCount, resultList);
	}
	
	/**
	 * 加载培训履历
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 指定培训履历数据JSON
	 * */
	//@RequestMapping(NavConst.UserTraining_MGT_GET_UserTraining_BY_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingDataById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( id != null && !id.trim().equals("") ) {
			UserTraining userTraining = userTrainingService.getUserTrainingById(id);  
			resultMap.put("entity", ( userTraining != null ) ? userTraining : new UserTraining(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new UserTraining(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 通过 userBasicInfoId 加载培训履历
	 * @author Xiaolin Yin
	 * @param  userBasicInfoId
	 * @return 指定培训履历数据JSON
	 * */
	@RequestMapping(NavConst.USERTRAINING_MGT_GET_BY_USER_ID_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingDataByUserId(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			UserTraining userTraining = userTrainingService.getUserTrainingByUserId(userBasicInfoId);  
			resultMap.put("entity", ( userTraining != null ) ? userTraining : new UserTraining(UUIDHexGenerator.getInstance().generate()));
		} else{ 
			resultMap.put("entity", new UserTraining(UUIDHexGenerator.getInstance().generate()));
		}
		return resultMap;
	}
	
	/**
	 * 加载培训履历集合通过userBasicInfoId
	 * @author Xiaolin Yin
	 * @param userBasicInfoId
	 * @return 指定培训履历数据JSON
	 * */
	//@RequestMapping(NavConst.USERTRAINING_MGT_GET_BY_USER_ID_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getUserTrainingListDataById(String userBasicInfoId) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		if ( userBasicInfoId != null && !userBasicInfoId.trim().equals("") ) {
			List<UserTraining> resultList = userTrainingService.getUserTrainingsByUserId(userBasicInfoId);  
			resultMap.put("entity", ( resultList.size()>0 ) ? resultList : new ArrayList<UserTraining>());
		} else{ 
			resultMap.put("entity", new ArrayList<UserTraining>());
		}
		return resultMap;
	}
	
	/**
	 * 保存培训履历数据
	 * @author Xiaolin Yin
	 * @param UserTraining 保存对象
	 * @return 保存状态
	 * */
	@RequestMapping(NavConst.USERTRAINING_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveUserTrainingData(@RequestBody UserTraining userTraining) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if(userTraining!=null){
			status=userTrainingService.saveUserTraining(userTraining);
		}  
		resultMap.put("status", status); 
		return resultMap;
	}
	
	/**
	 * 删除培训履历记录
	 * @author Xiaolin Yin
	 * @param id ID
	 * @return 删除状态
	 * */
	//@RequestMapping(NavConst.UserTraining_MGT_REMOVE_UserTraining_DATA)
	@ResponseBody
	public Map<String, Object> removeUserTrainingById(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		boolean status=false;
		if ( id != null && !id.trim().equals("") ) {
			status=userTrainingService.removeUserTrainingFalse(id);
			resultMap.put("status", status);
		} else{ 
			resultMap.put("status",status);
			resultMap.put("result","删除失败！");
		}
		return resultMap;
	} 
	
	/**
	 * 培训履历表单页面导航
	 * */
	@RequestMapping(NavConst.TRAINING_RECORD_MGT_FORM)
	public ModelAndView getTrainingRecordMV() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/trainingRecord");
    }
	
	/**
	 * 培训履历表单详情页面导航
	 * */
	@RequestMapping(NavConst.TRAINING_RECORD_MGT_VIEW)
	public ModelAndView getTrainingRecordView() {
        return new ModelAndView("/pangolin/psnlInfoMgt/expert/trainingRecordView");
    }
}
