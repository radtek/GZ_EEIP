package org.pangolin.eeip.dto;

import java.util.Date;

import org.pangolin.eeip.entity.DevInspection;
import org.pangolin.eeip.entity.DevMaintanence;
import org.pangolin.eeip.entity.DevSwUpgrade;
import org.pangolin.eeip.entity.DevUsingSitn;

public class DeviceMaintainDto implements Comparable<DeviceMaintainDto>{
	private String type; //0 维护  1 升级 2 使用情况 3设备核查情况
	private Date createDate;  //时间排序--无实际意义
	private Date startDate; //开始时间  核查时间 维护时间
	private Date endDate;
	private String userAlias; //操作人  使用人  维护人  检查人
	private String evidSn;  //捡材编号
	private String result; //检查结果
	private String content; //维护内容
	private String remarks; //备注
	private String softName; //软件名称
	
	public static DeviceMaintainDto maintanenceTo(DevMaintanence devMaintanence){
		DeviceMaintainDto deviceMaintainDto = new DeviceMaintainDto();
		if(devMaintanence != null){
			deviceMaintainDto.setUserAlias(devMaintanence.getCreatorAlias());
			deviceMaintainDto.setStartDate(devMaintanence.getMaintDate());
			deviceMaintainDto.setContent(devMaintanence.getContent());
			deviceMaintainDto.setRemarks(devMaintanence.getRemarks());
			deviceMaintainDto.setCreateDate(devMaintanence.getCreatedDate());
			deviceMaintainDto.setType("0");
		}
		return deviceMaintainDto;
	}
	
	public static DeviceMaintainDto softTo(DevSwUpgrade devSwUpgrade){
		DeviceMaintainDto deviceMaintainDto = new DeviceMaintainDto();
		if(devSwUpgrade != null){
			deviceMaintainDto.setSoftName(devSwUpgrade.getSoftwareName());
			deviceMaintainDto.setUserAlias(devSwUpgrade.getOperatorAlias());
			deviceMaintainDto.setRemarks(devSwUpgrade.getRemarks());
			deviceMaintainDto.setCreateDate(devSwUpgrade.getCreatedDate());
			deviceMaintainDto.setType("1");
		}
		return deviceMaintainDto;
	}
	
	public static DeviceMaintainDto usingTo(DevUsingSitn devUsingSitn){
		DeviceMaintainDto deviceMaintainDto = new DeviceMaintainDto();
		if(devUsingSitn != null){
			deviceMaintainDto.setStartDate(devUsingSitn.getStartDate());
			deviceMaintainDto.setEndDate(devUsingSitn.getEndDate());
			deviceMaintainDto.setUserAlias(devUsingSitn.getOperatorAlias());
			deviceMaintainDto.setEvidSn(devUsingSitn.getEvidSn());
			deviceMaintainDto.setCreateDate(devUsingSitn.getCreatedDate());
			deviceMaintainDto.setType("2");
		}
		return deviceMaintainDto;
	}
	
	public static DeviceMaintainDto inspectionTo(DevInspection devInspection){
		DeviceMaintainDto deviceMaintainDto = new DeviceMaintainDto();
		if(devInspection != null){
			deviceMaintainDto.setUserAlias(devInspection.getInspectorAlias());
			deviceMaintainDto.setStartDate(devInspection.getInspectedDate());
			deviceMaintainDto.setResult(devInspection.getResult().equals(0)?"正常":"不正常");
			deviceMaintainDto.setCreateDate(devInspection.getCreatedDate());
			deviceMaintainDto.setType("3");
		}
		return deviceMaintainDto;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getEvidSn() {
		return evidSn;
	}

	public void setEvidSn(String evidSn) {
		this.evidSn = evidSn;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSoftName() {
		return softName;
	}

	public void setSoftName(String softName) {
		this.softName = softName;
	}

	@Override
	public int compareTo(DeviceMaintainDto o) {
		return this.getCreateDate().compareTo(o.getCreateDate());
	}
	
}
