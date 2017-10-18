package org.pangolin.eeip.dto;

/**
 * 智能分析 比率统计
 * @author Xiaolin Yin
 *
 */
public class RatioStatisticsDto {

	private String name;
	private Integer casesQty;
	private Integer officeQty;
	private Integer sceneInquestQty;
	private String evidenceRatio;
	private String sceneRatio;
	
	public RatioStatisticsDto(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCasesQty() {
		return casesQty;
	}

	public void setCasesQty(Integer casesQty) {
		this.casesQty = casesQty;
	}

	public Integer getOfficeQty() {
		return officeQty;
	}

	public void setOfficeQty(Integer officeQty) {
		this.officeQty = officeQty;
	}

	public Integer getSceneInquestQty() {
		return sceneInquestQty;
	}

	public void setSceneInquestQty(Integer sceneInquestQty) {
		this.sceneInquestQty = sceneInquestQty;
	}

	public String getEvidenceRatio() {
		return evidenceRatio;
	}

	public void setEvidenceRatio(String evidenceRatio) {
		this.evidenceRatio = evidenceRatio;
	}

	public String getSceneRatio() {
		return sceneRatio;
	}

	public void setSceneRatio(String sceneRatio) {
		this.sceneRatio = sceneRatio;
	}
}
