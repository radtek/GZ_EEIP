package org.pangolin.eeip.web.servlet;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.pangolin.util.NavigationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigationLoader extends HttpServlet {
	
	private static final long serialVersionUID = -6244335545153517561L;
	
	private static final Logger log = LoggerFactory.getLogger(NavigationLoader.class);
	
	public void init() {
		try {
			NavigationUtil navUtil = new NavigationUtil();
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream("/sys_navigations.properties");
			Properties propertyLoader = new Properties();
			try { propertyLoader.load(is); }
			catch(Exception ex) { log.error(ex.getMessage()); }
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				navUtil.add(propertyName, propertyValue);
			}
			
			this.getServletContext().setAttribute("nav", navUtil);
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
}