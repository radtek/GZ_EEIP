package org.pangolin.eeip.sms;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Message Sender
 * @author Oscar Mok
 * */
public class MessageSender {
	
	private static final String SMS_PROPERTY_FILE_PATH = "/sms.properties";
	
	/**
	 * Charset of encoding
	 * */
	private static final String CHARSET = "GBK";
	
	/**
	 * Send message
	 * @author Oscar Mok
	 * @param content Content of message
	 * @param cellPhones CellPhone numbers
	 * @return Status of sending message
	 * */
	public static boolean send(String content, List<String> cellPhones) {
		try {
			//SMSParam param = new SMSParam("http://10.41.0.197:81/jk/wbjk_new.asp", "dzsys", null);
			SMSParam param = loadSMSParam();
			URL url = new URL(MessageSender.getUrlBySMSParam(param, contentEncode(content, CHARSET), cellPhones));
			HttpURLConnection httpURLCon = (HttpURLConnection)url.openConnection();
			httpURLCon.setRequestMethod("GET");
			httpURLCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLCon.setRequestProperty("Connection", "Keep-Alive");
			httpURLCon.setUseCaches(false);
			httpURLCon.setDoOutput(true);
			httpURLCon.setDoInput(true);
			httpURLCon.setConnectTimeout(5000);
			httpURLCon.setReadTimeout(5000);
			httpURLCon.connect();
			
			if (httpURLCon.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("Connection Failed!");
				httpURLCon.disconnect();
			} else {
				return true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Loading parameters of sms
	 * */
	private static SMSParam loadSMSParam() {
		SMSParam param = null;
		try {
			String url = null, account = null, password = null;
			String propertyName = "", propertyValue = "";
			InputStream is = MessageSender.class.getResourceAsStream(SMS_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				if ( propertyName != null && propertyName.trim().equals("url") ) { url = propertyValue; }
				if ( propertyName != null && propertyName.trim().equals("account") ) { account = propertyValue; }
				if ( propertyName != null && propertyName.trim().equals("password") ) { password = propertyValue; }
			}
			
			param = new SMSParam(url, account, password);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return param;
	}
	
	/**
	 * Encode content of message
	 * @author Oscar Mok
	 * @param content Content of message
	 * @param charset Charset of encoding
	 * @return Encoded content of message
	 * */
	private static String contentEncode(String content, String charset) {
		try {
			return URLEncoder.encode(content, charset);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Getting URL
	 * @author Oscar Mok
	 * @param param Parameters of SMS
	 * @param content Content of message
	 * @param cellPhones CellPhone numbers
	 * @return URL
	 * */
	private static String getUrlBySMSParam(SMSParam param, String content, List<String> cellPhones) {
		if ( !(cellPhones != null && cellPhones.size() > 0) ) return "";
		
		String url = param.getUrl();
		if ( param.getAccount() != null && !param.getAccount().trim().equals("") 
				&& (param.getPassword() != null && !param.getPassword().trim().equals("") 
				|| param.getNoPassword() != null && !param.getNoPassword().trim().equals("")) ) {
			String basicParam = "?username=" + param.getAccount();
			url += basicParam;
		}
		
		if ( content != null && !content.trim().equals("") ) {
			String msgContent = "&Content=" + content;
			url += msgContent;
		}
		
		String cellPhoneParam = "&Mobiles=";
		for ( int i = 0; i < cellPhones.size(); i++ ) {
			 if ( i == (cellPhones.size() - 1) ) {
				 cellPhoneParam += cellPhones.get(i);
			 } else {
				 cellPhoneParam += cellPhones.get(i) + ",";
			 }
		}
		url += cellPhoneParam;
		
		return url;
	}
	
	/**
	 * Testing
	 * @author Oscar Mok
	 * */
	/*public static void main(String args[]) {
		List<String> cellPhones = new ArrayList<String>();
		cellPhones.add("15818195710");
		cellPhones.add("18613114006");
		
		boolean status = MessageSender.send("测试电子物证短信发送", cellPhones);
		if ( status ) System.out.println("Message sent!");
	}*/
}