package org.pangolin.eeip.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.DeviceDto;
import org.pangolin.eeip.dto.DeviceMaintainDto;
import org.pangolin.eeip.entity.DevAdjApp;
import org.pangolin.eeip.entity.DevAdjPlan;
import org.pangolin.eeip.entity.DevAdjustmentSitn;
import org.pangolin.eeip.entity.DevDiscardApp;
import org.pangolin.eeip.entity.DevInspection;
import org.pangolin.eeip.entity.DevMaintanence;
import org.pangolin.eeip.entity.DevSwUpgrade;
import org.pangolin.eeip.entity.DevUsingSitn;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.service.DevAdjAppService;
import org.pangolin.eeip.service.DevAdjPlanService;
import org.pangolin.eeip.service.DevAdjustmentSitnService;
import org.pangolin.eeip.service.DevDiscardAppService;
import org.pangolin.eeip.service.DevInspectionService;
import org.pangolin.eeip.service.DevMaintanenceService;
import org.pangolin.eeip.service.DevSwUpgradeService;
import org.pangolin.eeip.service.DevUsingSitnService;
import org.pangolin.eeip.service.DeviceService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceController extends BaseController{
	
	@Resource
	private DeviceService deviceService;
	@Resource
	private DevAdjustmentSitnService devAdjustmentSitnService;
	@Resource
	private DevAdjPlanService devAdjPlanService;
	@Resource
	private DevAdjAppService devAdjAppService;
	@Resource
	private DevDiscardAppService devDiscardAppService;
	@Resource
	private DevSwUpgradeService devSwUpgradeService;
	@Resource
	private DevMaintanenceService devMaintanenceService;
	@Resource
	private DevInspectionService devInspectionService;
	@Resource
	private DevUsingSitnService devUsingSitnService;
	
	/***
	 * 保存设备管理信息
	 * @param device 设备管理对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_SAVEDEVICEDATA)
	@ResponseBody
	public Map<String, Object> saveDevice(@RequestBody Device device){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = deviceService.saveDevice(device);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 获取所有设备信息
	 * @param device 设备管理对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_GETDEVICELISTDATA)
	@ResponseBody
	public Map<String,Object> getDeviceListData(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Device> list = new ArrayList<Device>();
		try{
			list = deviceService.getDevices();
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", list);
		}
		return result;
	}
	
	/***
	 * 获取所有设备状态为正常的设备列表信息
	 * @param device 设备管理对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_GETNORMALDEVICELIST)
	@ResponseBody
	public Map<String,Object> getNormalDeviceList(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Device> list = new ArrayList<Device>();
		try{
			list = deviceService.getNormalDevices();
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", list);
		}
		return result;
	}
	
	/***
	 * 根据设备管理ID获取设备管理信息
	 * @param id 设备管理ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_LOADDEVICEDATA)
	@ResponseBody
	public Map<String, Object> getDeviceDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Device device = deviceService.getDeviceById(id);
			device = device == null ? new Device() : device;
			result.put("entity", device);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new Device());
		}
		return result;
	}
	
	/***
	 * 根据设备管理ID删除设备管理信息（伪删除）
	 * @param id 设备管理ID
	 * @return
	 */
	
	@ResponseBody
	public Map<String, Object> removeDevice(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = deviceService.removeDeviceFalse(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 设备管理信息列表数据源
	 * @return 设备管理数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_DEVICEGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDeviceList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String extraParam = params.getExtraParam("queryParam");
		List<Device> list =  deviceService.getDevices(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),extraParam);
		long totalCount = deviceService.getDeviceQty(extraParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 审批列表数据源
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_APPROVELISTDATA)
	@ResponseBody
	public Map<String, Object> getApproveListData(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<DeviceDto> list = new ArrayList<DeviceDto>();
		String extraParam = params.getExtraParam("queryParam");
		//登记表审批列表
		List<DevAdjustmentSitn> devAdjustmentSitns = devAdjustmentSitnService.getDevAdjustmentSitnByQueryParam(extraParam);
		for (DevAdjustmentSitn devAdjustmentSitn : devAdjustmentSitns) {
			if(devAdjustmentSitn.getStatus().equals(1)){
				list.add(DeviceDto.devAdjustmentSitnToDto(devAdjustmentSitn));
			}
		}
		//仪器设备期间核查/校准计划  
		List<DevAdjPlan> devAdjPlansByStatus = devAdjPlanService.getDevAdjPlanByQueryParam(extraParam);
		for (DevAdjPlan devAdjPlan : devAdjPlansByStatus) {
			if(devAdjPlan.getStatus().equals(1)){
				list.add(DeviceDto.devAdjPlanToDto(devAdjPlan));
			}
		}
		//仪器设备核查/校准/维修申请表
		List<DevAdjApp> devAdjAppByStatus = devAdjAppService.getDevAdjAppByQueryParam(extraParam);
		for (DevAdjApp devAdjApp : devAdjAppByStatus) {
			if(devAdjApp.getStatus().equals(1)){
				list.add(DeviceDto.devAdjAppToDto(devAdjApp));
			}
		}
		//固定资产（设备）报废申请表 
		List<DevDiscardApp> devDiscardAppByStatus = devDiscardAppService.getDevDiscardAppByQueryParam(extraParam);
		for (DevDiscardApp devDiscardApp : devDiscardAppByStatus) {
			if(devDiscardApp.getStatus().equals(1)){
				list.add(DeviceDto.devDiscardAppToDto(devDiscardApp));
			}
		}
		
		
		/*for (DevAdjustmentSitn devAdjustmentSitn : devAdjustmentSitns) {
			if(!devAdjustmentSitn.getStatus().equals(1)){
				list.add(DeviceDto.devAdjustmentSitnToDto(devAdjustmentSitn));
			}
		}
		for (DevAdjPlan devAdjPlan : devAdjPlansByStatus) {
			if(!devAdjPlan.getStatus().equals(1)){
				list.add(DeviceDto.devAdjPlanToDto(devAdjPlan));
			}
		}
		for (DevAdjApp devAdjApp : devAdjAppByStatus) {
			if(!devAdjApp.getStatus().equals(1)){
				list.add(DeviceDto.devAdjAppToDto(devAdjApp));
			}
		}
		for (DevDiscardApp devDiscardApp : devDiscardAppByStatus) {
			if(!devDiscardApp.getStatus().equals(1)){
				list.add(DeviceDto.devDiscardAppToDto(devDiscardApp));
			}
		}*/
		
		long totalCount = list.size();
		int startIndex = params.getStart();
		if((startIndex+10)>totalCount){
			list = list.subList(startIndex, (int)totalCount);
		}else{
			list = list.subList(startIndex, startIndex+10);
		}
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 生命周期数据源
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_GETLIFECYCLELISTDATA)
	@ResponseBody
	public Map<String, Object> getLifeCycleListData(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<DeviceMaintainDto> list = new ArrayList<DeviceMaintainDto>();
		try{
			List<DevUsingSitn> devUsingSitns = devUsingSitnService.getDevUsingSitns(id);
			if(devUsingSitns.size() > 0){
				for (DevUsingSitn devUsingSitn : devUsingSitns) {
					list.add(DeviceMaintainDto.usingTo(devUsingSitn));
				}
			}
			List<DevSwUpgrade> devSwUpgrades = devSwUpgradeService.getDevSwUpgrades(id);
			if(devSwUpgrades.size() > 0){
				for (DevSwUpgrade devSwUpgrade : devSwUpgrades) {
					list.add(DeviceMaintainDto.softTo(devSwUpgrade));
				}
			}
			List<DevMaintanence> devMaintanences = devMaintanenceService.getDevMaintanences(id);
			if(devMaintanences.size() > 0){
				for (DevMaintanence devMaintanence : devMaintanences) {
					list.add(DeviceMaintainDto.maintanenceTo(devMaintanence));
				}
			}
			List<DevInspection> devInspections = devInspectionService.getDevInspections(id);
			if(devInspections.size() > 0){
				for (DevInspection devInspection : devInspections) {
					list.add(DeviceMaintainDto.inspectionTo(devInspection));
				}
			}
			Collections.sort(list);
//			for (DeviceMaintainDto deviceMaintainDto : list) {
//				String str = deviceMaintainDto.getType().equals("0") ? "维护 " : deviceMaintainDto.getType().equals("1") ? "升级" : deviceMaintainDto.getType().equals("2") ? "使用情况" : "设备核查情况";
//				System.out.println(deviceMaintainDto.getCreateDate()+"   类型："+ str);
//			}
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", list);
		}
		return result;
	}
	
	/***
	 * 自定义UUID
	 * @return 自定义的
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_GETUUID)
	@ResponseBody
	public Map<String, Object> getUUID(){
		Map<String, Object> result = new HashMap<String, Object>();
		String uuid = UUIDHexGenerator.getInstance().generate();
		result.put("entity", uuid);
		return result;
	}
	
	/***
	 * 获取所有设备状态为正常的设备列表信息
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_USE_SITUATION)
	@ResponseBody
	public Map<String,Object> getDeviceUseSituationList(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Device> list = new ArrayList<Device>();
		try{
			list = deviceService.getDeviceUseSituations();
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", list);
		}
		return result;
	}
	
	/***
	 * 获取所有设备状态为正常的设备列表信息
	 * @param id 设备ID  通过ID获取 设备集合
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVICE_GET_BY_NAME_LIST)
	@ResponseBody
	public Map<String,Object> getDeviceUseSituationList(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Device> list = new ArrayList<Device>();
		try{
			if(null != id && !"".equals(id)){
				Device device = deviceService.getDeviceById(id);
				if(device != null){
					list = deviceService.getAppraisalDevices(device.getName());
				}
			}
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", list);
		}
		return result;
	}
	
}
