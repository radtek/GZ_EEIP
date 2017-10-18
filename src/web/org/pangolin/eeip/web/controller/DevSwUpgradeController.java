package org.pangolin.eeip.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevSwUpgrade;
import org.pangolin.eeip.service.DevSwUpgradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DevSwUpgradeController extends BaseController{
	
	@Resource
	private DevSwUpgradeService devSwUpgradeService;
	
	/***
	 * 保存软件升级表
	 * @param devSwUpgrade 软件升级对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVSWUPGRADE_SAVEDEVSWUPGRADEDATA)
	@ResponseBody
	public Map<String, Object> saveDevSwUpgrade(@RequestBody DevSwUpgrade devSwUpgrade){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devSwUpgradeService.saveDevSwUpgrade(devSwUpgrade);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据软件升级ID获取软件升级信息
	 * @param id 软件升级ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVSWUPGRADE_LOADDEVSWUPGRADEDATA)
	@ResponseBody
	public Map<String, Object> getDevSwUpgradeDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			DevSwUpgrade devSwUpgrade = devSwUpgradeService.getDevSwUpgradeById(id);
			devSwUpgrade = devSwUpgrade == null ? new DevSwUpgrade() : devSwUpgrade;
			result.put("entity", devSwUpgrade);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new DevSwUpgrade());
		}
	
		return result;
	}
	
	/***
	 * 根据软件升级ID删除软件升级信息（伪删除）
	 * @param id 软件升级ID
	 * @return
	 */
	
	@ResponseBody
	public Map<String, Object> removeDevSwUpgrade(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devSwUpgradeService.removeDevSwUpgradeFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 软件升级信息列表数据源
	 * @return 软件升级数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVSWUPGRADE_DEVSWUPGRADEGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevSwUpgradeList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String devId = params.getExtraParam("devId");
		List<DevSwUpgrade> list = devSwUpgradeService.getDevSwUpgrades(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),devId);
		long totalCount = devSwUpgradeService.getDevSwUpgradeQty(devId);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
