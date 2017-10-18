package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.DocumentDto;
import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.service.DocRelationshipService;
import org.pangolin.eeip.service.DocumentService;
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
 * 文档管理 Controller
 * @author Oscar Mok
 */
@Controller
@SuppressWarnings("all")
public class DocumentController extends BaseController {
	
	@Autowired
	private DocumentService documentService;
	
	@Resource
	private DocRelationshipService docRelationshipService;
	
	/**
	 * 文档信息列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_LIST)
	public ModelAndView getDocumentInfoListMV() {
        return new ModelAndView("/pangolin/assessibilityMgt/documentMgt/documentList");
    }
	
	/**
	 * 文档信息表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_FORM)
	public ModelAndView getDocumentInfoFormMV() {
        return new ModelAndView("/pangolin/assessibilityMgt/documentMgt/documentForm");
    }
	
	/**
	 * 文档信息列表数据源
	 * @author Oscar Mok
	 * @return 文档数据集JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getDocumentInfoListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		long totalCount = documentService.getDocumentQty(queryParam);
		List<Document> documentList =  
				documentService.getDocuments(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		return BootstrapDataGridUtil.getResultMap(params, totalCount, documentList);
	}
	
	/**
	 * 从缓存获取文档列表数据源
	 * @author Oscar Mok
	 * @return 文档数据集JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_LIST_CACHE_DATA)
	@ResponseBody
	public Map<String, Object> getDocumentListCacheData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Document> documentList = documentService.getDocuments();
		resultMap.put("entity", documentList);
		return resultMap;
	}
	
	/**
	 * 移除文档数据
	 * @author Oscar Mok
	 * @param id 文档ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeDocumentData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( id != null && !id.trim().equals("") ) 
			status = documentService.removeDocument(id);
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 加载文档数据（用于更新）
	 * @author Oscar Mok
	 * @param id 文档ID
	 * @return 指定文档数据JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getDocumentData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( id != null && !id.trim().equals("") ) {
			Document document =  documentService.getDocumentById(id);
			List<Document> documents = new ArrayList<Document>();
			List<DocRelationship> docRelationships = new ArrayList<DocRelationship>();
			if ( document != null ) {
				docRelationships = docRelationshipService.getDocRelationshipsBySrcDocId(id);
			    if ( docRelationships != null && docRelationships.size() > 0 ) {
				   for ( DocRelationship docRelationship : docRelationships ) {
					  documents.add(documentService.getDocumentById(docRelationship.getRelevantDocId()));
				    }
			    }
				//document.setUploadFileName(getFileName(document.getPath()));
			}
			document = ( document != null ) ? document : new Document();
			DocumentDto documentDto = DocumentDto.convertToDocumentDto(document);
			documentDto.setDocRelationships(docRelationships);
			documentDto.setDocuments(documents);
			resultMap.put("entity", documentDto);
		} else resultMap.put("entity", new Document());
		return resultMap;
	}
	
	/**
	 * 保存文档数据
	 * @author Oscar Mok
	 * @param advertisement 文档对象
	 * @return 保存情况JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveDocument(@RequestBody Document document) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
				
		if ( document != null ) status = documentService.saveDocument(document);
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 上载文档数据
	 * @param file 上载文件对象
	 * @return 上载文件状态JSON
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_UPLOAD_DATA)
	@ResponseBody
	 public Map<String,Object> uploadDocument(@RequestParam("file") MultipartFile file, String id) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		boolean status = false;
        
		String uploadPhotoPath = Const.EEIP_DOCUMENT_TEMP_PATH;
        File directory = new File(uploadPhotoPath);
        if (directory.isDirectory()) directory.mkdirs();
        
        if (!file.isEmpty()) {
        	if ( !isExecutableDoc(file.getOriginalFilename()) ) {
        		String fileName = file.getOriginalFilename();
                String fileExtension = FilenameUtils.getExtension(fileName);
                String uploadFileName = SerialNumberGenerator.getUploadFileName(fileExtension);
                
                File uploadedFile = new File(uploadPhotoPath, uploadFileName);
                try {
                	FileUtils.copyInputStreamToFile(file.getInputStream(), uploadedFile);
                	if ( uploadedFile.length() >0 ) status = true;
                	resultMap.put("tmpFileName", uploadFileName);
    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
        	}
        }
        resultMap.put("status", status);
		return resultMap;
    }
	
	/**
	 * 根据文档名称获取文档信息流
	 * @param adPhotoName 文件名
	 * @param request Request 对象
	 * @param response Response 对象
	 * @return 文档信息流
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_DATA_VIEWER)
	public void getDocumentData(String fileName, HttpServletRequest request, HttpServletResponse response) {
		try{
			if ( fileName != null && !fileName.trim().equals("") ) {
				File file = null;
				File file0 = new File(Const.EEIP_DOCUMENT_PATH + fileName); //正式上载文件
				File file1 = new File(Const.EEIP_DOCUMENT_TEMP_PATH + fileName); //临时上载文件
				
				if ( file0.exists() && file0.canRead() ) file = file0;
				if ( file1.exists() && file1.canRead() ) file = file1;
				
				if ( file.exists() && file.canRead() ) {
					FileInputStream inputStream = new FileInputStream(file);
			        byte[] data = new byte[(int)file.length()];
			        inputStream.read(data);
			        inputStream.close();
			        response.setContentType("multipart/form-data");
			        response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
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
	 * 根据文档名称获取文档信息流
	 * @param adPhotoName 文件名
	 * @param request Request 对象
	 * @param response Response 对象
	 * @return 文档信息流
	 * */
	@RequestMapping(NavConst.ACCESSIBILITY_DOC_MGT_DATA_DOWNLOAD)
	public void downloadDocumentData(String id, HttpServletRequest request, HttpServletResponse response) {
		try{
			if ( id != null && !id.trim().equals("") ) {
				Document document = documentService.getDocumentById(id);
				if ( document != null ) {
					File file = new File(document.getPath()); //正式上载文件
					if ( file.exists() && file.canRead() ) {
						FileInputStream inputStream = new FileInputStream(file);
				        byte[] data = new byte[(int)file.length()];
				        inputStream.read(data);
				        inputStream.close();
				        response.setContentType("multipart/form-data");
				        response.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
				        OutputStream stream = response.getOutputStream();
				        stream.write(data);
				        stream.flush();
				        stream.close();
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 是否可执行文件
	 * @author Oscar Mok
	 * @return 是否可执行文件状态
	 * */
	private boolean isExecutableDoc(String fileName) {
		if ( fileName != null && !fileName.trim().equals("") ) {
			String regex = "(?i).+?\\.(bin|sh|exe|bat|msi|vbs|js|cmd|scr)";
			return fileName.matches(regex);
		}
		return false;
	}
	
	/**
	 * 提取临时上载文件数据并返回其物理路径
	 * @param tmpFileName 临时文件名称
	 * @return 正式文件物理路径
	 * */
	private String fetchTempUploadFile(String tmpFileName) {
		try {
			if ( tmpFileName != null 
					&& !tmpFileName.trim().equals("") ) {
				String srcFilePath = Const.EEIP_DOCUMENT_TEMP_PATH + tmpFileName;
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
	
	/***
	 * 根据文件夹ID获取文件列表信息
	 * @param dirId 文件夹ID
	 * @author Tinggui Zhu
	 * @return
	 */
	@RequestMapping(NavConst.DOCUMENT_MGT_LIST_BY_DIR_ID_DATA)
	@ResponseBody
	public Map<String,Object> getDocumentsByDirId(String dirId) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Document> list = documentService.getDocumentsByDirectoryId(dirId);
		result.put("entity", list);
		return result;
	}
	
	/***
	 * 根据关键字获取文件列表信息
	 * @param dirId 文件夹ID
	 * @param key 关键字
	 * @author Tinggui Zhu
	 * @return
	 */
	@RequestMapping(NavConst.DOCUMENT_MGT_LIST_BY_KEY_DATA)
	@ResponseBody
	public Map<String,Object> getDocumentByKey(String dirId,String key) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Document> list = documentService.getDocumentByKey(dirId, key);
		result.put("entity", list);
		return result;
	}
}