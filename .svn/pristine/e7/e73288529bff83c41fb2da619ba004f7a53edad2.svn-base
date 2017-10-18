package org.pangolin.eeip.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Scanner;

/**
 * Hardware Information Utility Tool
 * @author Oscar Mok
 * */
public class HardwareUtil {
	
	/**
	 * Windows Platform
	 * */
	public static final int WINDOWS = 0;
	
	/**
	 * Linux Platform
	 * */
	public static final int LINUX = 1;
	
	/**
	 * Get Serial Number of CPU
	 * @author Oscar Mok
	 * @return Serial Number of CPU
	 * */
	public static String getProcessorId() {
		try {
			if ( getOsType() == WINDOWS ) {
				Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
				process.getOutputStream().close();
				Scanner sc = new Scanner(process.getInputStream());
				sc.next();
				return sc.next();
			} else if ( getOsType() == LINUX ) {
				String result = "";
				Process process;
				process = Runtime.getRuntime().exec(new String[]{"sh","-c", "dmidecode -t 4 | grep ID |sort -u |awk -F': ' '{print $2}'"});
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));  
                String line;
                while ((line = br.readLine()) != null) {
                	result += line;
                    break;
                } 
                br.close();
                return result.replaceAll("\\s*", "");
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return "";
	}
	
	/**
	 * Get MAC Address of Network Card
	 * @author Oscar Mok
	 * @return MAC Address
	 * */
	public static String getMacAddress() {
		try {
			/**
			 * Caution: Running 'InetAddress.getLocalHost()' in Linux
			 * Edit file '/etc/hosts' and let HOSTNAME direct to effective IP address
			 * e.g. 192.168.1.202 dev.machine
			 * */
			if ( getOsType() == WINDOWS || getOsType() == LINUX ) {
				byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
				StringBuffer sb = new StringBuffer("");
				for(int i=0; i<mac.length; i++) {
					if(i!=0) sb.append("-");
					int temp = mac[i]&0xff;
					String str = Integer.toHexString(temp);
					if(str.length()==1) {
						sb.append("0"+str);
					}else {
						sb.append(str);
					}
				}
				return sb.toString().toUpperCase();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		
		return "";
	}
	
	/**
	 * Get Name of Operating System
	 * @author Oscar Mok
	 * @return Name of Operating System
	 * */
	public static String getOsName() {
        String osName = "";
        osName = System.getProperty("os.name");
        return osName;
    }
	
	/**
	 * Get Type of Operating System
	 * @author Oscar Mok
	 * @return Type of Operating System
	 * */
	public static int getOsType() {
		if ( getOsName().indexOf("Windows") != -1 ) {
			return WINDOWS;
		} else if ( getOsName().indexOf("Linux") != -1 ) {
			return LINUX;
		}
		return WINDOWS;
	}
}