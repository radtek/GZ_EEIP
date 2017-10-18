package org.pangolin.eeip.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.service.AppraisalService;
import org.pangolin.eeip.service.PreappraisalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkflowController extends BaseController {
	
	@Resource
	private PreappraisalService preappraisalService;
	
	@Resource
	private AppraisalService appraisalService;
	
	/**
	 * 构建工作项
	 * @author Oscar Mok
	 * @param appraisalId 检材鉴定信息ID
	 * @return 构建状态
	 * */
	@RequestMapping(NavConst.WORKFLOW_MGT_CREATE_TASK)
	@ResponseBody
	public Map<String, Object> createTask(String appraisalId) {
		boolean status = false;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Appraisal appraisal = appraisalService.getAppraisalById(appraisalId);
		if ( appraisal != null ) {
			status = createTask(appraisal);
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 构建当前鉴定信息工作项
	 * @author Oscar Mok
	 * @param appraisal 鉴定信息对象
	 * */
	private boolean createTask(Appraisal appraisal) {
		try {
			if ( appraisal.getProcInstId() != null 
					&& !appraisal.getProcInstId().trim().equals("") ) {
				String sender = "admin";
				if ( appraisal.getWorkItemId() != null 
						&& !appraisal.getWorkItemId().trim().equals("") )
					sender = workflow.getSenderByTask(appraisal.getWorkItemId());
				
				String workItemId = workflow.startTask(sender, 
				                                       getCurrentUser().getUserName(), 
				                                       new Date().getTime(), 
				                                       appraisal.getProcInstId(), 
				                                       workflow.getNextProcAct(appraisal.getProcActInstId()));
				
				String procActInstId = workflow.getProcActInstByTask(workItemId);
				if ( procActInstId != null && !procActInstId.trim().equals("") ) {
					appraisal.setProcActInstId(procActInstId);
					appraisal.setWorkItemId(workItemId);
					appraisalService.saveAppraisal(appraisal); //Update appraisal data
				}
				
				workflow.completeTask(workItemId);
				return true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}