package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Advertisement;
import org.pangolin.eeip.service.AdvertisementService;
import org.pangolin.eeip.util.SerialNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 广告管理 Controller
 * @author Oscar Mok
 */
@Controller
@SuppressWarnings("all")
public class AdvertisementController extends BaseController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	/**
	 * 广告信息列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_LIST)
	public ModelAndView getAdvertisementListMV() {
        return new ModelAndView("/pangolin/assessibilityMgt/advertisementMgt/advertisementList");
    }
	
	/**
	 * 广告信息表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_FORM)
	public ModelAndView getAdvertisementFormMV() {
        return new ModelAndView("/pangolin/assessibilityMgt/advertisementMgt/advertisementForm");
    }
	
	/**
	 * 广告信息列表数据源
	 * @author Oscar Mok
	 * @return 广告数据集JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getAdvertisementListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		long totalCount = advertisementService.getAdvertisementQty();
		List<Advertisement> advertisementList =  
				advertisementService.getAdvertisements(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		return BootstrapDataGridUtil.getResultMap(params, totalCount, advertisementList);
	}
	
	/**
	 * 移除广告数据
	 * @author Oscar Mok
	 * @param id 广告ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeAdvertisementData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) 
			status = advertisementService.removeAdvertisement(id);
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 加载广告数据（用于更新）
	 * @author Oscar Mok
	 * @param id 广告ID
	 * @return 指定广告数据JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getAdvertisementData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( id != null && !id.trim().equals("") ) {
			Advertisement advertisement = advertisementService.getAdvertisementById(id);
			if ( advertisement != null ) 
				advertisement.setUploadFileName(getFileName(advertisement.getPath()));
			resultMap.put("entity", ( advertisement != null ) ? advertisement : new Advertisement());
		} else resultMap.put("entity", new Advertisement());
		return resultMap;
	}
	
	/**
	 * 保存广告数据
	 * @author Oscar Mok
	 * @param advertisement 广告对象
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveAdvertisement(@RequestBody Advertisement advertisement) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( advertisement != null ) {
			if ( advertisement.getUrl() != null && !advertisement.getUrl().trim().equals("") ) {
				if ( !isURL(advertisement.getUrl()) ) {
					resultMap.put("status", false);
					return resultMap;
				}
			}
			
			String destFilePath = fetchTempPhoto(advertisement.getTempUploadFileName());
			if ( destFilePath != null && !destFilePath.trim().equals("") ) advertisement.setPath(destFilePath);
			
			status = advertisementService.saveAdvertisement(advertisement);
		}
		
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 上载图片数据
	 * @param file 上载文件对象
	 * @return 上载文件状态JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_UPLOAD_PHOTO_DATA)
	@ResponseBody
	 public Map<String,Object> uploadADPhoto(@RequestParam("file") MultipartFile file, String id) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		boolean status = false;
        
		String uploadPhotoPath = Const.EEIP_DOCUMENT_TEMP_PATH;
        File directory = new File(uploadPhotoPath);
        if (directory.isDirectory()) directory.mkdirs();
        
        if (!file.isEmpty()) {
        	if ( isPhoto(file.getOriginalFilename()) ) {
        		String fileName = file.getOriginalFilename();
                String fileExtension = FilenameUtils.getExtension(fileName);
                String uploadFileName = SerialNumberGenerator.getUploadFileName(fileExtension);
                
                File uploadedFile = new File(uploadPhotoPath, uploadFileName);
                try {
                	FileUtils.copyInputStreamToFile(file.getInputStream(), uploadedFile);
                	if ( uploadedFile.length() >0 ) status = true;
                	resultMap.put("tmpPicName", uploadFileName);
    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
        	}
        }
        resultMap.put("status", status);
		return resultMap;
    }
	
	/**
	 * 根据图片名称获取图片信息流
	 * @param adPhotoName 图片文件名
	 * @param request Request 对象
	 * @param response Response 对象
	 * @return 图片信息流
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_AD_MGT_IMG_DATA_VIEWER)
	public void getAdvertisementImageData(String adPhotoName, HttpServletRequest request, HttpServletResponse response) {
		try{
			if ( adPhotoName != null && !adPhotoName.trim().equals("") ) {
				File image = null;
				File image0 = new File(Const.EEIP_DOCUMENT_PATH + adPhotoName); //正式上载文件
				File image1 = new File(Const.EEIP_DOCUMENT_TEMP_PATH + adPhotoName); //临时上载文件
				
				if ( image0.exists() && image0.canRead() ) image = image0;
				if ( image1.exists() && image1.canRead() ) image = image1;
				
				if ( image.exists() && image.canRead() ) {
					FileInputStream inputStream = new FileInputStream(image);
			        byte[] data = new byte[(int)image.length()];
			        inputStream.read(data);
			        inputStream.close();
			        response.setContentType("image/jpeg");
			        OutputStream stream = response.getOutputStream();
			        stream.write(data);
			        stream.flush();
			        stream.close();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 提取临时上载文件数据并返回其物理路径
	 * @param tmpPicName 临时文件名称
	 * @return 正式文件物理路径
	 * */
	private String fetchTempPhoto(String tmpPicName) {
		try {
			if ( tmpPicName != null 
					&& !tmpPicName.trim().equals("") ) {
				String srcFilePath = Const.EEIP_DOCUMENT_TEMP_PATH + tmpPicName;
				String destFilePath = Const.EEIP_DOCUMENT_PATH + SerialNumberGenerator.getUploadFileName(FilenameUtils.getExtension(srcFilePath));
				File srcFile = new File(srcFilePath);
				File destFile = new File(destFilePath);
				if ( srcFile.exists() ) {
					FileUtils.copyFile(srcFile, destFile);
					if ( destFile.exists() ) return destFilePath;
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return "";
	}
	
	/**
	 * 是否图片
	 * @author Oscar Mok
	 * @return 是否图片状态
	 * */
	private boolean isPhoto(String fileName) {
		if ( fileName != null && !fileName.trim().equals("") ) {
			String regex = "(?i).+?\\.(jpg|gif|bmp|png|jpeg)";
			return fileName.matches(regex);
		}
		return false;
	}
	
	/**
	 * 是否URL（正则表达式）
	 * @author Oscar Mok
	 * @return 
	 * */
	private boolean isURL(String url) {
		if ( url != null && !url.trim().equals("") ) {
			String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
			return url.matches(regex);
		}
		return false;
	}
	
	/**
	 * 获取文件名称
	 * @author Oscar Mok
	 * @param filePath 文件物理路径
	 * @return 文件名称
	 * */
	private String getFileName(String filePath) {
		try {
			if ( filePath != null 
					&& !filePath.trim().equals("") ) {
				File file = new File(filePath);
				if ( file.exists() ) {
					return file.getName();
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}