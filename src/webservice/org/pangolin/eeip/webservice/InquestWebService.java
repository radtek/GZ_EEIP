package org.pangolin.eeip.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InquestWebService extends BaseWebService {
	
	private static final Logger log = LoggerFactory.getLogger(InquestWebService.class);
	
	/**
	 * TODO
	 * 登记现场勘验信息
	 * @return 登记状态（0：失败；1：成功）
	 * */
	public String saveInquest() {
		try {
			
		} catch(Exception ex) {
			log.error(ex.getMessage());
		}
		return "";
	}
}