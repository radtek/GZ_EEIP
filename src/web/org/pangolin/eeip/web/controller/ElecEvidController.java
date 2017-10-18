package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.service.ElecEvidService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 电子物证信息Controller
 * @author 
 *
 */
@Controller
@SuppressWarnings("all")
public class ElecEvidController extends BaseController{
	 
	
	@Resource(name = "elecEvidService")
	private ElecEvidService elecEvidService;
}
