package org.pangolin.eeip.language;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统语言加载器
 * @author Oscar Mok
 * */
public class LocaleLoader extends HttpServlet {
	
	private static final long serialVersionUID = -6300201820269787548L;
	
	private static final Logger log = LoggerFactory.getLogger(LocaleLoader.class);

	/**
	 * 系统语言MAP常量
	 * Map<String（语言标识，如：zh_CN、zh_TW）, Map<String（功能标识）, String（功能名称）>>
	 * */
	public static Map<String, Map<String, String>> LOCALE_MAP = new HashMap<String, Map<String, String>>();
	
	/**
	 * 初始化系统语言
	 * */
	public void init() {
		try {
			String path = getServletContext().getRealPath("/WEB-INF/classes/languages");
			File directory = new File(path);
			if ( directory.exists() ) {
				File[] files = directory.listFiles();
				for ( File file : files ) {
					if ( isLocaleFile(file) ) { loadLocale(file, LOCALE_MAP); }
				}
			}
			
			getServletContext().setAttribute("LANG", LOCALE_MAP);
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 是否语言配置文件
	 * @param file 文件对象
	 * @return 是否语言文件
	 * */
	private boolean isLocaleFile(File file) {
		if ( file.getName().indexOf("locale") != -1 ) return true;
		return false;
	}
	
	/**
	 * 加载系统语言配置文件
	 * @param file 文件对象
	 * @param localeMap 语言MAP对象
	 * */
	private void loadLocale(File file, Map<String, Map<String, String>> localeMap) {
		String locale = file.getName().substring(7, file.getName().lastIndexOf(".properties"));
		Map<String, String> map = new HashMap<String, String>();
		
		String propertyName = "", propertyValue = "";
		InputStream is = getClass().getResourceAsStream("/languages/"+file.getName());
		Properties p = new Properties();
		try { p.load(is); }
		catch(Exception ex) { ex.printStackTrace(); }
		
		Set<String> propertyNamesSet = p.stringPropertyNames();
		Iterator<String> propertyNamesInterator = propertyNamesSet.iterator();
		
		while( propertyNamesInterator.hasNext() ) {
			propertyName = (String) propertyNamesInterator.next();
			propertyValue = p.getProperty( propertyName );
			map.put(propertyName, propertyValue);
		}
		localeMap.put(locale, map);
	}
}