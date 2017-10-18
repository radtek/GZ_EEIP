package org.pangolin.eeip.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 编号生成器
 * @author Oscar Mok
 * */
public class SerialNumberGenerator {
	
	/**
	 * 获取系统管理员帐户
	 * @author Oscar Mok
	 * @return 系统管理员帐户名
	 * */
	public static String getSecondaryAdminAccount() {
		return "admin_" + SerialNumberGenerator.getRandomNumber();
	}
	
	/**
	 * 获取上载文件名称
	 * @author Oscar Mok
	 * @param ext 文件扩展名
	 * @return 上载文件名
	 * */
	public static String getUploadFileName(String ext) {
		return "file-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "-" + SerialNumberGenerator.getRandomNumber() + "." + ext;
	}
	
	/**
	 * 获取6位随机数
	 * @author Oscar Mok
	 * */
	private static String getRandomNumber() {
		double uuidNum = Double.valueOf(convertToNumber(SerialNumberGenerator.getRandomUUID()));
		int randomNo = (int)(uuidNum%1000000);
		DecimalFormat df = new DecimalFormat("000000");
		return df.format(randomNo);
	}
	
	private static String convertToNumber(String uuid) {
		String str = "";
		if ( uuid != null && !uuid.trim().equals("") ) {
			char[] charArray = uuid.toCharArray();
			for ( char c : charArray ) {
				if ( Character.isLetter(c) ) {
					int i = (int) c;
					str += String.valueOf(i);
				} else if ( c == '-' ) {
					str += "0";
				} else {
					str += String.valueOf(c);
				}
			}
		}
		return str + String.valueOf((int)((Math.random()*9+1)*100000));
	}
	
	private static String getRandomUUID() {
		return UUID.randomUUID() + "";
	}
}