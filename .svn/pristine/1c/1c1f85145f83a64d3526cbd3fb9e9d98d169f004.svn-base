package org.pangolin.eeip.web.servlet;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.pangolin.eeip.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceUrlLoader extends HttpServlet {
	
	private static final long serialVersionUID = -6435894301977566229L;
	
	private static final Logger log = LoggerFactory.getLogger(WebServiceUrlLoader.class);
	
	public void init() {
		try {
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream("/webservice.properties");
			Properties propertyLoader = new Properties();
			try { propertyLoader.load(is); }
			catch(Exception ex) { log.error(ex.getMessage()); }
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				Const.WS_URL_MAP.put(propertyName, propertyValue);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
}