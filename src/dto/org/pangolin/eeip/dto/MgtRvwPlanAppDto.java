package org.pangolin.eeip.dto;

import java.util.ArrayList;
import java.util.List;

import org.pangolin.eeip.entity.MgtRvwPlanApp;

/***
 * 管理评审计划申请
 * @author Tinggui Zhu
 *
 */
public class MgtRvwPlanAppDto {

	private MgtRvwPlanApp mgtRvwPlanApp = new MgtRvwPlanApp();
	
	private List<String> addAtt = new ArrayList<String>();

	public MgtRvwPlanApp getMgtRvwPlanApp() {
		return mgtRvwPlanApp;
	}

	public void setMgtRvwPlanApp(MgtRvwPlanApp mgtRvwPlanApp) {
		this.mgtRvwPlanApp = mgtRvwPlanApp;
	}

	public List<String> getAddAtt() {
		return addAtt;
	}

	public void setAddAtt(List<String> addAtt) {
		this.addAtt = addAtt;
	}
	
	
}
