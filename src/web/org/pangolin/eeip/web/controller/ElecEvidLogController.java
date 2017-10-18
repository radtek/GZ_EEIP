package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.EvidOpLog;
import org.pangolin.eeip.service.ElecEvidLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 电子物证日志Controller
 * @author 
 *
 */
@Controller
@SuppressWarnings("all")
public class ElecEvidLogController extends BaseController{
	 
	
	@Resource(name = "elecEvidLogService")
	private ElecEvidLogService elecEvidLogService; 
}
