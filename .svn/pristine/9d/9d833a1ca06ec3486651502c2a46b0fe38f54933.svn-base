package org.pangolin.eeip.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.pangolin.util.NumberUtil;
import org.pangolin.util.StringUtil;

/**
 * Data collector of temperature and humidity sensor
 * @author Oscar Mok
 * @version 1.0
 * */
public class THSensorDataCollector {
	
	/**
	 * Command of sensor 01
	 * */
	public static byte[] TH01_COMMAND;
	
	/**
	 * Command of sensor 02
	 * */
	public static byte[] TH02_COMMAND;
	
	static {
		TH01_COMMAND = new byte[8];
		TH01_COMMAND[0] = (byte) 0x01;
		TH01_COMMAND[1] = (byte) 0x04;
		TH01_COMMAND[2] = (byte) 0x00;
		TH01_COMMAND[3] = (byte) 0x00;
		TH01_COMMAND[4] = (byte) 0x00;
		TH01_COMMAND[5] = (byte) 0x02;
		TH01_COMMAND[6] = (byte) 0x71;
		TH01_COMMAND[7] = (byte) 0xcb;
		
		TH02_COMMAND = new byte[8];
		TH02_COMMAND[0] = (byte) 0x02;
		TH02_COMMAND[1] = (byte) 0x04;
		TH02_COMMAND[2] = (byte) 0x00;
		TH02_COMMAND[3] = (byte) 0x00;
		TH02_COMMAND[4] = (byte) 0x00;
		TH02_COMMAND[5] = (byte) 0x02;
		TH02_COMMAND[6] = (byte) 0x71;
		TH02_COMMAND[7] = (byte) 0xf8;
	}
	
	/**
	 * Get effective value
	 * @author Oscar Mok
	 * @param value integer
	 * @return Effective value
	 * */
	private static String getEffectiveValue(int value) {
		if(value>99){
			double result = Double.parseDouble(String.valueOf(value))/10;
			return String.valueOf(result);
		}else if(value<99){
			double result = Double.parseDouble(String.valueOf(value));
			return String.valueOf(result);
		}else{
			return "-100";
		}
		
	}
	
	/**
	 * Value zeroize
	 * @author Oscar Mok
	 * @param value Feedback value of sensor
	 * @return Zeroized value
	 * */
	private static String zeroize(String value) {
		if ( NumberUtil.isNumber(value) ) {
			DecimalFormat df = new DecimalFormat("00");
			return df.format(Integer.parseInt(value));
		} else {
			return value;
		}
	}
	
	/**
	 * Get data of temperature and humidity sensor
	 * @author Oscar Mok
	 * @param ipAddr IP address
	 * @param port Port of service
	 * @param command Command
	 * @return Data of temperature and humidity sensor
	 * */
	public static String[] getData(String ipAddr, int port, byte[] command) {
		String[] data = new String[2];
		
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		
		try {
			socket = new Socket(ipAddr, port);
			os = socket.getOutputStream();
			os.write(command);
            os.flush();
            
            List<String> result = new ArrayList<String>();
            is = socket.getInputStream();
            int count = 0;
            while(true) {
            	if ( count > 8 ) break;
            	result.add(zeroize(Integer.toHexString(is.read())));
                count ++;
            }
                        
            String temp = getEffectiveValue(Integer.parseInt((result.get(3) + result.get(4)), 16));
            String hum = getEffectiveValue(Integer.parseInt((result.get(5) + result.get(6)), 16));
            
            data[0] = temp;
            data[1] = hum;
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				is.close();
	            os.close();
	            socket.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		return data;
	}
	
	/**
	 * Get value of temperature
	 * @param collectedData Data of collecting from sensor
	 * @return Temperature value
	 * */
	public static double getTemperature(String[] collectedData) {
		try {
			if ( collectedData != null ) {
				return Double.parseDouble(collectedData[0]);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Get value of humidity
	 * @param collectedData Data of collecting from sensor
	 * @return Humidity value
	 * */
	public static double getHumidity(String[] collectedData) {
		try {
			if ( collectedData != null ) {
				return Double.parseDouble(collectedData[1]);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Get bytes of command
	 * @author Oscar Mok
	 * @param commandStr command
	 * @return Bytes of command
	 * */
	public static byte[] getCommand(String commandStr) {
		byte[] command = new byte[8];
		List<String> commandList = StringUtil.separate2List(commandStr, " ");
		for ( int i = 0; i < command.length; i++ ) {
			command[i] = Integer.valueOf(commandList.get(i), 16).byteValue();
		}
		return command;
	}
	
	public static void main(String args[]) {
		byte[] command1 = THSensorDataCollector.getCommand("01 04 00 00 00 02 71 CB");
		byte[] command2 = THSensorDataCollector.getCommand("02 04 00 00 00 02 71 F8");
		
		String[] data1 = THSensorDataCollector.getData("192.168.1.249", 1985, TH01_COMMAND);
		System.out.println("Temperature1: " + THSensorDataCollector.getTemperature(data1));
		System.out.println("humidity1: " + THSensorDataCollector.getHumidity(data1));
		
		String[] data2 = THSensorDataCollector.getData("192.168.1.249", 1985, TH02_COMMAND);
		System.out.println("Temperature2: " + THSensorDataCollector.getTemperature(data2));
		System.out.println("humidity2: " + THSensorDataCollector.getHumidity(data2));
	}
}