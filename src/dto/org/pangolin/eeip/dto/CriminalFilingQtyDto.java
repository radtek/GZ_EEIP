package org.pangolin.eeip.dto;

/**
 * 刑事案件立案数  DTO
 * @author Xiaolin Yin
 *
 */
public class CriminalFilingQtyDto  extends BaseDto{

	private String year;
	private String month;
	private Integer all;
	private Integer yuexiu;
	private Integer liwan;
	private Integer tianhe;
	private Integer haizhu;
	private Integer huangpu;
	private Integer baiyun;
	private Integer panyu;
	private Integer nansha;
	private Integer huadu;
	private Integer zengcheng;
	private Integer conghua;
	private String creatorAlias;
	private String creatorId;
	
	
	public CriminalFilingQtyDto(){}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
 
 
	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	public Integer getYuexiu() {
		return yuexiu;
	}

	public void setYuexiu(Integer yuexiu) {
		this.yuexiu = yuexiu;
	}

	public Integer getLiwan() {
		return liwan;
	}

	public void setLiwan(Integer liwan) {
		this.liwan = liwan;
	}

	public Integer getTianhe() {
		return tianhe;
	}

	public void setTianhe(Integer tianhe) {
		this.tianhe = tianhe;
	}

	public Integer getHaizhu() {
		return haizhu;
	}

	public void setHaizhu(Integer haizhu) {
		this.haizhu = haizhu;
	}

	public Integer getHuangpu() {
		return huangpu;
	}

	public void setHuangpu(Integer huangpu) {
		this.huangpu = huangpu;
	}

	public Integer getBaiyun() {
		return baiyun;
	}

	public void setBaiyun(Integer baiyun) {
		this.baiyun = baiyun;
	}

	public Integer getPanyu() {
		return panyu;
	}

	public void setPanyu(Integer panyu) {
		this.panyu = panyu;
	}

	public Integer getNansha() {
		return nansha;
	}

	public void setNansha(Integer nansha) {
		this.nansha = nansha;
	}

	public Integer getHuadu() {
		return huadu;
	}

	public void setHuadu(Integer huadu) {
		this.huadu = huadu;
	}

	public Integer getZengcheng() {
		return zengcheng;
	}

	public void setZengcheng(Integer zengcheng) {
		this.zengcheng = zengcheng;
	}

	public Integer getConghua() {
		return conghua;
	}

	public void setConghua(Integer conghua) {
		this.conghua = conghua;
	}

	public String getCreatorAlias() {
		return creatorAlias;
	}

	public void setCreatorAlias(String creatorAlias) {
		this.creatorAlias = creatorAlias;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
}
