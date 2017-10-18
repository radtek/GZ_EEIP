package org.pangolin.eeip.util;

import javax.servlet.ServletContext;

import org.pangolin.servlet.InitServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringUtil {
	
	private static final Logger log = LoggerFactory.getLogger(SpringUtil.class);
	
	public Object getBean(String beanName) {
		Object object = null;
		try {
			return org.pangolin.util.SpringUtil.getManager(InitServletContext.SERVLET_CONTEXT, beanName);
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return object;
	}

	public Object getBean(ServletContext content, String beanName) {
		Object object = null;
		try {
			return org.pangolin.util.SpringUtil.getManager(content, beanName);
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return object;
	}
}