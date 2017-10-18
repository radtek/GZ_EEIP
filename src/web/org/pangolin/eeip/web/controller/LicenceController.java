package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.LicenseAppDto;
import org.pangolin.eeip.licence.LicenceLoader;
import org.pangolin.eeip.util.HardwareUtil;
import org.pangolin.security.encryption.BASE64Encryption;
import org.pangolin.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings("all")
public class LicenceController extends BaseController {
	
	private static final String DOC_EXT = ".lica";
	
	/**
	 * 申请许可证
	 * @author Oscar Mok
	 * @param licenseApp 许可证申请数据访问对象
	 * */
	@RequestMapping(NavConst.SYS_LICENCE_MGT_APPLY)
	@ResponseBody
	public Map<String, Object> applyLicence(@RequestBody LicenseAppDto licenseApp) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if ( licenseApp != null ) {
				String tmpFileName = getTempFileName();
				FileUtil.createDirectory(Const.EEIP_DOCUMENT_TEMP_PATH);
				FileUtil.createFile(Const.EEIP_DOCUMENT_TEMP_PATH, tmpFileName);
				
				File tmpFile = new File(Const.EEIP_DOCUMENT_TEMP_PATH + tmpFileName);
				if ( tmpFile.exists() ) {
					String content = generateContent(licenseApp);
					FileUtil.writeToFile(tmpFile, content.getBytes(), content.getBytes().length);
					
					resultMap.put("key", tmpFileName);
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return resultMap;
	}
	
	/**
	 * 申请许可证
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_LICENCE_MGT_DOWNLOAD)
	public void downloadLicenceAppFile(String key, HttpServletRequest request, HttpServletResponse response) {
		try {
			File tmpFile = new File(Const.EEIP_DOCUMENT_TEMP_PATH + key);
			if ( tmpFile.exists() ) {
				FileInputStream inputStream = new FileInputStream(tmpFile);
		        byte[] data = new byte[(int)tmpFile.length()];
		        inputStream.read(data);
		        inputStream.close();
		        response.setContentType("multipart/form-data");
		        response.setHeader("Content-Disposition", "attachment;fileName=" + getDownloadFileName());
		        OutputStream stream = response.getOutputStream();
		        stream.write(data);
		        stream.flush();
		        stream.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 激活许可证
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_LICENCE_MGT_ACTIVATE)
	@ResponseBody
	public Map<String, Object> activateLicence(String regCode) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		try {
			if ( regCode != null 
					&& !regCode.trim().equals("") ) {
				File licenceFile = LicenceLoader.getLicenceFile();
				if ( licenceFile != null ) {
					byte[] binaryStream = regCode.getBytes();
					if ( LicenceLoader.validateRegCode(binaryStream) ) {
						FileUtil.writeToFile(licenceFile, binaryStream, binaryStream.length);
						resultMap.put("expDate", LicenceLoader.getExpDate(binaryStream));
						status = true;
					}
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 生成许可证申请信息
	 * @author Oscar Mok
	 * @param licenseApp 许可证申请信息对象
	 * @return 许可证申请信息
	 * */
	private String generateContent(LicenseAppDto licenseApp) {
		String content = "";
		if ( licenseApp != null ) {
			String cpuId = HardwareUtil.getProcessorId();
			String macAddr = HardwareUtil.getMacAddress();
			
			content += "Corporation Name: " + licenseApp.getCorpName() + "\n";
			content += "Applicant: " + licenseApp.getApplicantName() + "\n";
			content += "Telephone: " + licenseApp.getApplicantTel() + "\n";
			content += "Email: " + licenseApp.getApplicantEmail() + "\n";
			content += "Address: " + licenseApp.getApplicantAddr() + "\n";
			content += "CPU ID: " + cpuId + "\n";
			content += "MAC Address: " + macAddr + "\n";
			content = BASE64Encryption.encrypt(content);
		}
		return content;
	}
	
	/**
	 * 获取临时文件名
	 * @author Oscar Mok
	 * @return 临时文件名
	 * */
	private String getTempFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return "lic-app-" + sdf.format(new Date()) + DOC_EXT;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 获取下载文件名
	 * @author Oscar Mok
	 * @return 下载文件名
	 * */
	private String getDownloadFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return "sys-license-app-" + sdf.format(new Date()) + DOC_EXT;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}