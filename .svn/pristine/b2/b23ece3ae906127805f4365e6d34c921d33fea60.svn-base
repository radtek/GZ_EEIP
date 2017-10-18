package org.pangolin.eeip.licence;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.pangolin.eeip.util.HardwareUtil;
import org.pangolin.security.encryption.BASE64Encryption;
import org.pangolin.util.FileUtil;
import org.pangolin.util.StringUtil;
import org.pangolin.validator.StringValidator;

/**
 * 许可证加载器
 * @author Oscar Mok
 * */
public class LicenceLoader {
	
	private static ServletContext servletContext;
	
	/**
	 * 激活许可证限制
	 * */
	private static final boolean ACTIVATE_LICENCE_LIMIT = false;
	
	/**
	 * 许可证 - CPU序列号
	 * */
	private static final String CPU_ID = "CPU_ID";
	
	/**
	 * 许可证 - 服务器网卡地址
	 * */
	private static final String MAC_ADDR = "MAC_ADDR";
	
	/**
	 * 许可证 - 过期时间
	 * */
	private static final String EXP_DATE = "EXP_DATE";
	
	/**
	 * 许可证静态类
	 * */
	private static class Licence {
		String cpuId;
		String macAddr;
		Date expDate;
	}
	
	/**
	 * 初始化许可证加载器
	 * */
	public static void initialize(ServletContext servletContext) {
		LicenceLoader.servletContext = servletContext;
	}
	
	/**
	 * 验证许可证有效性
	 * @author Oscar Mok
	 * @param licenceFile 许可证文件
	 * @return 许可证是否可用
	 * */
	public static boolean validateLicence() {
		try {
			if ( !ACTIVATE_LICENCE_LIMIT ) return true;
			
			String path = LicenceLoader.servletContext.getRealPath("/WEB-INF/classes/license.dat");
			if ( path != null && !path.trim().equals("") ) {
				File licenceFile = new File(path);
				if ( licenceFile.exists() ) {
					String licenceContent  = decryptLicenceFile(path);
					if ( licenceContent != null 
							&& !licenceContent.trim().equals("") ) {
						Licence licence = getLicence(licenceContent);
						
						String cpuId = HardwareUtil.getProcessorId();
						String macAddr = HardwareUtil.getMacAddress();
						long currentDateTime = Calendar.getInstance().getTime().getTime();
						
						/*System.out.println("CPU: "+cpuId +"<>"+licence.cpuId );
						System.out.println("Mac: "+macAddr +"<>"+licence.macAddr );
						System.out.println("Time: "+currentDateTime +"<>"+licence.expDate.getTime() );*/
						
						if ( cpuId.trim().equals(licence.cpuId) 
								&& macAddr.trim().equals(licence.macAddr) 
								&& currentDateTime < licence.expDate.getTime() ) {
							return true;
						}
					}
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return false;
	}
	
	/**
	 * 获取许可证文件
	 * @author Oscar Mok
	 * @return 许可证文件
	 * */
	public static File getLicenceFile() {
		String path = LicenceLoader.servletContext.getRealPath("/WEB-INF/classes/license.dat");
		if ( path != null && !path.trim().equals("") ) {
			File licenceFile = new File(path);
			if ( licenceFile.exists() ) {
				return licenceFile;
			}
		}
		return null;
	}
	
	/**
	 * 解密许可证文件
	 * @param filePath 许可证文件
	 * @return 许可证内容
	 * */
	private static String decryptLicenceFile(String filePath) {
		try {
			byte[]  encryptedBytes = FileUtil.readFile(filePath);
			byte[] decryptedBytes = BASE64Encryption.decrypt(encryptedBytes);
			return new String(decryptedBytes, "UTF-8");
		} catch(Exception ex) { ex.printStackTrace(); }
		return "";
	}
	
	/**
	 * 根据许可证内容获取许可证对象
	 * @param licenceContent 许可证内容
	 * @return 许可证对象
	 * */
	private static Licence getLicence(String licenceContent) {
		Licence licence = null;
		try {
			if ( licenceContent != null 
					&& !licenceContent.trim().equals("") ) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				licence = new Licence();
				String itemValue = "";
				
				List<String> itemList = StringUtil.separate2List(licenceContent, ",");
				if ( itemList != null && itemList.size() > 0 ) {
					for ( String item : itemList ) {
						itemValue = item.substring(item.indexOf("=") + 1);
						itemValue = itemValue.substring(0, itemValue.indexOf("]"));
						
						if ( item.indexOf(CPU_ID) != -1 ) {
							licence.cpuId = itemValue;
						}
						if ( item.indexOf(MAC_ADDR) != -1 ) {
							licence.macAddr = itemValue;
						}
						if ( item.indexOf(EXP_DATE) != -1 ) {
							licence.expDate = sdf.parse(itemValue);
						}
					}
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return licence;
	}
	
	/**
	 * 获取许可证使用期限
	 * @param encryptedBytes 已加密的许可证二进制流
	 * @return 许可证使用期限（格式：yyyy-MM-dd HH:mm）
	 * */
	public static String getExpDate(byte[] encryptedBytes) {
		try {
			byte[] decryptedBytes = BASE64Encryption.decrypt(encryptedBytes);
			String licenceContent = new String(decryptedBytes, "UTF-8");
			
			Licence licence = getLicence(licenceContent);
			if ( licence != null ) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				return sdf.format(licence.expDate);
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return "";
	}
	
	/**
	 * 验证注册码有效性
	 * @param encryptedBytes 已加密的许可证（注册码）二进制流
	 * @return 注册码有效性
	 * */
	public static boolean validateRegCode(byte[] encryptedBytes) {
		try {
			byte[] decryptedBytes = BASE64Encryption.decrypt(encryptedBytes);
			String licenceContent = new String(decryptedBytes, "UTF-8");
			
			Licence licence = getLicence(licenceContent);
			if ( licence != null ) {
				if ( licence.cpuId != null 
						&& licence.macAddr != null 
						&& licence.expDate != null 
						&& !licence.cpuId.trim().equals("") 
						&& !licence.macAddr.trim().equals("") 
						&& StringValidator.isValidMacAddress(licence.macAddr.trim()) ) {
					return true;
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return false;
	}
}