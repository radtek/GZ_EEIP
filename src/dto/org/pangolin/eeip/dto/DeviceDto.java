package org.pangolin.eeip.dto;

import java.util.Date;

import org.pangolin.eeip.entity.DevAdjApp;
import org.pangolin.eeip.entity.DevAdjPlan;
import org.pangolin.eeip.entity.DevAdjustmentSitn;
import org.pangolin.eeip.entity.DevDiscardApp;

public class DeviceDto {
	//类型     	 1：设备维修情况登记		2：核查校准计划		3：核查维修申请单	 4：固定资产报废 
	private String type;
	private String deviceId;
	private String otherId;  //待审批文件的Id
	private Integer status;//审批状态
	private Date date;

	public static DeviceDto devAdjustmentSitnToDto(DevAdjustmentSitn devAdjustmentSitn){
		DeviceDto deviceDto = new DeviceDto();
		deviceDto.setType("1");
		deviceDto.setDeviceId(devAdjustmentSitn.getDeviceId());
		deviceDto.setOtherId(devAdjustmentSitn.getId());
		deviceDto.setStatus(devAdjustmentSitn.getStatus());
		deviceDto.setDate(devAdjustmentSitn.getCreatedDate());
		return deviceDto;
	}
	
	public static DeviceDto devAdjPlanToDto(DevAdjPlan devAdjPlan){
		DeviceDto deviceDto = new DeviceDto();
		deviceDto.setType("2");
		deviceDto.setDeviceId(devAdjPlan.getDeviceId());
		deviceDto.setOtherId(devAdjPlan.getId());
		deviceDto.setStatus(devAdjPlan.getStatus());
		deviceDto.setDate(devAdjPlan.getCreatedDate());
		return deviceDto;
	}
	
	public static DeviceDto devAdjAppToDto(DevAdjApp devAdjApp){
		DeviceDto deviceDto = new DeviceDto();
		deviceDto.setType("3");
		deviceDto.setDeviceId(devAdjApp.getDeviceId());
		deviceDto.setOtherId(devAdjApp.getId());
		deviceDto.setStatus(devAdjApp.getStatus());
		deviceDto.setDate(devAdjApp.getCreatedDate());
		return deviceDto;
	}
	
	public static DeviceDto devDiscardAppToDto(DevDiscardApp devDiscardApp){
		DeviceDto deviceDto = new DeviceDto();
		deviceDto.setType("4");
		deviceDto.setDeviceId(devDiscardApp.getDeviceId());
		deviceDto.setOtherId(devDiscardApp.getId());
		deviceDto.setStatus(devDiscardApp.getStatus());
		deviceDto.setDate(devDiscardApp.getCreatedDate());
		return deviceDto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getOtherId() {
		return otherId;
	}

	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
