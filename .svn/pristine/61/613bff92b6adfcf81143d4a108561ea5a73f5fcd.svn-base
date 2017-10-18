package org.pangolin.eeip.dto;

/***
 * 内审年度计划申请
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AnnualPlanApp;

public class AnnualPlanAppDto {

	private String id;
	
	private String title;
	
	private String remarks;
	
	private String approverId;
	
	private String approverName;
	
	private String approverAlias;
	
	private String opinion;
	
	private Date approvedDate;
	
	private Integer status;
	
	private Date modifiedDate;
	
	private Date createdDate = new Date();
	
	private String creatorId;
	
	private String creatorName;
	
	private String creatorAlias;
	
	private Integer delFlag;
	
	private String year;
	
	private List<AnnualPlan> annualPlans = new ArrayList<AnnualPlan>();  // 内审年度计划
	
	private List<String> addAtt = new ArrayList<String>();
	
	public static AnnualPlanApp convertToAnnualPlanApp(AnnualPlanAppDto annualPlanDto) {
		AnnualPlanApp annualPlanApp = new AnnualPlanApp();
		annualPlanApp.setId(annualPlanDto.getId());
		annualPlanApp.setTitle(annualPlanDto.getTitle());
		annualPlanApp.setApprovedDate(annualPlanDto.getApprovedDate());
		annualPlanApp.setApproverAlias(annualPlanDto.getApproverAlias());
		annualPlanApp.setApproverId(annualPlanDto.getApproverId());
		annualPlanApp.setApproverName(annualPlanDto.getApproverName());
		annualPlanApp.setCreatedDate(annualPlanDto.getCreatedDate());
		annualPlanApp.setCreatorName(annualPlanDto.getCreatorName());
		annualPlanApp.setCreatorAlias(annualPlanDto.getCreatorAlias());
		annualPlanApp.setCreatorId(annualPlanDto.getCreatorId());
		annualPlanApp.setDelFlag(annualPlanDto.getDelFlag());
		annualPlanApp.setModifiedDate(annualPlanDto.getModifiedDate());
		annualPlanApp.setStatus(annualPlanDto.getStatus());
		annualPlanApp.setOpinion(annualPlanDto.getOpinion());
		annualPlanApp.setRemarks(annualPlanDto.getRemarks());
		annualPlanApp.setYear(annualPlanDto.getYear());
		return annualPlanApp;
	}
	
	public static AnnualPlanAppDto converToAnnualPlanDto(AnnualPlanApp annualPlanApp) {
		AnnualPlanAppDto dto = new AnnualPlanAppDto();
		dto.setId(annualPlanApp.getId());
		dto.setTitle(annualPlanApp.getTitle());
		dto.setApprovedDate(annualPlanApp.getApprovedDate());
		dto.setApproverAlias(annualPlanApp.getApproverAlias());
		dto.setApproverId(annualPlanApp.getApproverId());
		dto.setApproverName(annualPlanApp.getApproverName());
		dto.setCreatedDate(annualPlanApp.getCreatedDate());
		dto.setCreatorName(annualPlanApp.getCreatorName());
		dto.setCreatorAlias(annualPlanApp.getCreatorAlias());
		dto.setCreatorId(annualPlanApp.getCreatorId());
		dto.setDelFlag(annualPlanApp.getDelFlag());
		dto.setModifiedDate(annualPlanApp.getModifiedDate());
		dto.setStatus(annualPlanApp.getStatus());
		dto.setOpinion(annualPlanApp.getOpinion());
		dto.setRemarks(annualPlanApp.getRemarks());
		dto.setYear(annualPlanApp.getYear());
		return dto;
	}
	
	public static List<AnnualPlan> convertToAnnualPlan(List<AnnualPlan> plans) {
		List<AnnualPlan> annualPlans = new ArrayList<AnnualPlan>();
		for(AnnualPlan annualPlan : plans){
			if ( annualPlan.getApr() != null && annualPlan.getApr().equals("false") ) annualPlan.setApr(null);
			if ( annualPlan.getAug() != null && annualPlan.getAug().equals("false") ) annualPlan.setAug(null);
			if ( annualPlan.getDec() != null && annualPlan.getDec().equals("false") ) annualPlan.setDec(null);
			if ( annualPlan.getFeb() != null && annualPlan.getFeb().equals("false") ) annualPlan.setFeb(null);
			if ( annualPlan.getJan() != null && annualPlan.getJan().equals("false") ) annualPlan.setJan(null);
			if ( annualPlan.getJun() != null && annualPlan.getJun().equals("false") ) annualPlan.setJun(null);
			if ( annualPlan.getJul() != null && annualPlan.getJul().equals("false") ) annualPlan.setJul(null);
			if ( annualPlan.getMar() != null && annualPlan.getMar().equals("false") ) annualPlan.setMar(null);
			if ( annualPlan.getMay() != null && annualPlan.getMay().equals("false") ) annualPlan.setMay(null);
			if ( annualPlan.getNov() != null && annualPlan.getNov().equals("false") ) annualPlan.setNov(null);
			if ( annualPlan.getOct() != null && annualPlan.getOct().equals("false") ) annualPlan.setOct(null);
			if ( annualPlan.getSep() != null && annualPlan.getSep().equals("false") ) annualPlan.setSep(null);
			annualPlans.add(annualPlan);
		}
		return annualPlans;
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

	public List<AnnualPlan> getAnnualPlans() {
		return annualPlans;
	}

	public void setAnnualPlans(List<AnnualPlan> annualPlans) {
		this.annualPlans = annualPlans;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
