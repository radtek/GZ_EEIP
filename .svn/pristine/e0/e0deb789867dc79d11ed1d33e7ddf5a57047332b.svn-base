package org.pangolin.eeip.dto;

/***
 * 内审实施计划申请
 * @author Tinggui Zhu
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pangolin.eeip.entity.ImplPlan;
import org.pangolin.eeip.entity.ImplPlanApp;
import org.pangolin.eeip.entity.ImplPlanIaParticipant;
import org.pangolin.eeip.entity.ImplPlanParticipant;

public class ImplPlanAppDto {

	private String id;
	
	private String title;
	
	private String year;
	
	private String scope;
	
	private String purpose;
	
	private Date firstDate;
	
	private Date lastDate;
	
	private String gist;
	
	private String approverId;
	
	private String approverName;
	
	private String approverAlias;
	
	private String opinion;
	
	private Date approvedDate;
	
	private Integer status;
	
	private Date modifiedDate;
	
	private Date createdDate;
	
	private String creatorId;
	
	private String creatorName;
	
	private String creatorAlias;
	
	private Integer delFlag;
	
	private List<ImplPlan> implPlans = new ArrayList<ImplPlan>(); // 内审实施
	
	private List<ImplPlanParticipant> participants = new ArrayList<ImplPlanParticipant>(); // 参与人员
	
	private List<ImplPlanIaParticipant> iaParticipants = new ArrayList<ImplPlanIaParticipant>();  // 内审人员
	
	private List<String> addAtt = new ArrayList<String>();
	 
	public static ImplPlanApp converToImPlanApp(ImplPlanAppDto dto) {
		ImplPlanApp implPlanApp = new ImplPlanApp();
		implPlanApp.setApprovedDate(dto.getApprovedDate());
		implPlanApp.setApproverAlias(dto.getApproverAlias());
		implPlanApp.setApproverId(dto.getApproverId());
		implPlanApp.setApproverName(dto.getApproverName());
		implPlanApp.setCreatedDate(dto.getCreatedDate());
		implPlanApp.setCreatorAlias(dto.getCreatorAlias());
		implPlanApp.setCreatorId(dto.getCreatorId());
		implPlanApp.setCreatorName(dto.getCreatorName());
		implPlanApp.setDelFlag(dto.getDelFlag());
		implPlanApp.setFirstDate(dto.getFirstDate());
		implPlanApp.setGist(dto.getGist());
		implPlanApp.setId(dto.getId());
		implPlanApp.setLastDate(dto.getLastDate());
		implPlanApp.setModifiedDate(dto.getModifiedDate());
		implPlanApp.setOpinion(dto.getOpinion());
		implPlanApp.setPurpose(dto.getPurpose());
		implPlanApp.setScope(dto.getScope());
		implPlanApp.setStatus(dto.getStatus());
		implPlanApp.setTitle(dto.getTitle());
		implPlanApp.setYear(dto.getYear());
		return implPlanApp;
	}
	
	public static ImplPlanAppDto converToImplPlanAppDto(ImplPlanApp implPlanApp) {
		ImplPlanAppDto dto = new ImplPlanAppDto();
		dto.setApprovedDate(implPlanApp.getApprovedDate());
		dto.setApproverAlias(implPlanApp.getApproverAlias());
		dto.setApproverId(implPlanApp.getApproverId());
		dto.setApproverName(implPlanApp.getApproverName());
		dto.setCreatedDate(implPlanApp.getCreatedDate());
		dto.setCreatorAlias(implPlanApp.getCreatorAlias());
		dto.setCreatorId(implPlanApp.getCreatorId());
		dto.setCreatorName(implPlanApp.getCreatorName());
		dto.setDelFlag(implPlanApp.getDelFlag());
		dto.setFirstDate(implPlanApp.getFirstDate());
		dto.setGist(implPlanApp.getGist());
		dto.setId(implPlanApp.getId());
		dto.setLastDate(implPlanApp.getLastDate());
		dto.setModifiedDate(dto.getModifiedDate());
		dto.setOpinion(implPlanApp.getOpinion());
		dto.setPurpose(implPlanApp.getPurpose());
		dto.setScope(implPlanApp.getScope());
		dto.setStatus(implPlanApp.getStatus());
		dto.setTitle(implPlanApp.getTitle());
		dto.setYear(implPlanApp.getYear());
		return dto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getGist() {
		return gist;
	}

	public void setGist(String gist) {
		this.gist = gist;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public String getApproverAlias() {
		return approverAlias;
	}

	public void setApproverAlias(String approverAlias) {
		this.approverAlias = approverAlias;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorAlias() {
		return creatorAlias;
	}

	public void setCreatorAlias(String creatorAlias) {
		this.creatorAlias = creatorAlias;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public List<ImplPlan> getImplPlans() {
		return implPlans;
	}

	public void setImplPlans(List<ImplPlan> implPlans) {
		this.implPlans = implPlans;
	}

	public List<ImplPlanParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ImplPlanParticipant> participants) {
		this.participants = participants;
	}

	public List<ImplPlanIaParticipant> getIaParticipants() {
		return iaParticipants;
	}

	public void setIaParticipants(List<ImplPlanIaParticipant> iaParticipants) {
		this.iaParticipants = iaParticipants;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<String> getAddAtt() {
		return addAtt;
	}

	public void setAddAtt(List<String> addAtt) {
		this.addAtt = addAtt;
	}
	
	
}
