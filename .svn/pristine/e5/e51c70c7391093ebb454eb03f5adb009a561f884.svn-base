package org.pangolin.eeip.task;

import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.pangolin.eeip.entity.DevEvn;
import org.pangolin.eeip.service.DevEvnService;
import org.pangolin.eeip.util.THSensorDataCollector;
import org.pangolin.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 温湿度传感器收据收集任务<p>
 * 数据收集时间为10点和15点
 * @author Oscar Mok
 * @version 1.0
 * */
@Service("thDataCollectionTask")
public class THDataCollectionTask {
	
	private static final String SENSOR_PROPERTY_FILE_PATH = "/th_sensor.properties";
	
	@Autowired
	private DevEvnService devEvnService;
	
	/**
	 * 收集温湿度传感器数据
	 * @author Oscar Mok
	 * */
	public void collectTHData() {
		try {
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(SENSOR_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				saveSensorDataLog(propertyValue);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 保存温湿度传感器数据
	 * @author Oscar Mok
	 * @param config 配置信息
	 * */
	private void saveSensorDataLog(String config) {
		if ( config != null && !config.trim().equals("") ) {
			String ipAddr = null, port = null, location = null, command = null;
			String[] configArray = StringUtil.separate2Array(config, ",");
			for ( String param : configArray ) {
				param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
				if ( param.indexOf("IP") != -1 && ipAddr == null ) { ipAddr = param.substring(param.indexOf("=")+1); continue; }
				if ( param.indexOf("PORT") != -1 && port == null ) { port = param.substring(param.indexOf("=")+1); continue; }
				if ( param.indexOf("LOCATION") != -1 && location == null ) { location = param.substring(param.indexOf("=")+1); continue; }
				if ( param.indexOf("COMMAND") != -1 && command == null ) { command = param.substring(param.indexOf("=")+1); continue; }
			}
			
			if ( ipAddr != null && !ipAddr.trim().equals("") 
					&& port != null && !port.trim().equals("")
					&& location != null && !location.trim().equals("") ) {
				String[] data = THSensorDataCollector.getData(ipAddr, 
						                                      Integer.valueOf(port), 
						                                      THSensorDataCollector.getCommand(command));
				
				DevEvn devEvn = new DevEvn();
				devEvn.setLocation(location);
				devEvn.setIpAddr(ipAddr);
				devEvn.setPort(port);
				devEvn.setTemperature(THSensorDataCollector.getTemperature(data));
				devEvn.setHumidity(THSensorDataCollector.getHumidity(data));
				devEvnService.saveDevEvn(devEvn);
			}
		}
	}
}