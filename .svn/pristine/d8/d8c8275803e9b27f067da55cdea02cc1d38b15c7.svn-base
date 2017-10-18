package org.pangolin.eeip.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.pangolin.eeip.dto.CameraDto;
import org.pangolin.util.StringUtil;

@SuppressWarnings("all")
public class CameraDataLoader {
	
	private static final String CAMERA_PROPERTY_FILE_PATH = "/camera.properties";
	
	public static List<CameraDto> CAMERAS = new ArrayList<CameraDto>();
	
	/**
	 * 获取所有监控摄像头
	 * @author Oscar Mok
	 * @return 监控摄像头列表
	 * */
	public static List<CameraDto> getCameras() {
		try {
			if ( CAMERAS != null 
					&& CAMERAS.size() == 0 ) {
				String propertyName = "", propertyValue = "";
				InputStream is = CameraDataLoader.class.getResourceAsStream(CAMERA_PROPERTY_FILE_PATH);
				Properties propertyLoader = new Properties();
				propertyLoader.load(is);
				
				Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
				Iterator propertyNamesInterator = propertyNamesSet.iterator();
				
				while( propertyNamesInterator.hasNext() ) {
					propertyName = (String) propertyNamesInterator.next();
					propertyValue = propertyLoader.getProperty( propertyName );
									
					CAMERAS.add(getCamera(propertyValue));
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return CAMERAS;
	}
	
	/**
	 * 根据配置信息获取摄像头信息
	 * @author Oscar Mok
	 * @param config 配置信息
	 * @return 摄像头信息
	 * */
	private static CameraDto getCamera(String config) {
		CameraDto cameraDto = null;
		try {
			if ( config != null && !config.trim().equals("") ) {
				String name = null, 
						ipAddr = null, port = null, 
						account = null, pwd = null, vs = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("NAME") != -1 && name == null ) { name = param.substring(param.indexOf("=") + 1); continue; }
					if ( param.indexOf("IP") != -1 && ipAddr == null ) { ipAddr = param.substring(param.indexOf("=") + 1); continue; }
					if ( param.indexOf("PORT") != -1 && port == null ) { port = param.substring(param.indexOf("=") + 1); continue; }
					if ( param.indexOf("USERNAME") != -1 && account == null ) { account = param.substring(param.indexOf("=") + 1); continue; }
					if ( param.indexOf("PASSWORD") != -1 && pwd == null ) { pwd = param.substring(param.indexOf("=") + 1); continue; }
					if ( param.indexOf("VS") != -1 && vs == null ) { vs = param.substring(param.indexOf("=") + 1); continue; }
				}
				
				if ( name != null && !name.trim().equals("") 
						&& ipAddr != null && !ipAddr.trim().equals("") 
						&& port != null && !port.trim().equals("")  
						&& account != null && !account.trim().equals("") 
						&& pwd != null && !pwd.trim().equals("") ) {
					cameraDto = new CameraDto();
					
					cameraDto.setName(name);
					cameraDto.setIp(ipAddr);
					cameraDto.setPort(Integer.valueOf(port));
					cameraDto.setAccount(account);
					cameraDto.setPassword(pwd);
					cameraDto.setVideoSource(vs);
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cameraDto;
	}
}