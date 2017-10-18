package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.dto.DocOpLogDto;
import org.pangolin.eeip.dto.TmpDocOpLogDto;
import org.pangolin.eeip.entity.DocHistory;
import org.pangolin.eeip.entity.DocOpLog;
import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.entity.TmpDocOpLog;
import org.pangolin.eeip.service.DocHistoryService;
import org.pangolin.eeip.service.DocOpLogService;
import org.pangolin.eeip.service.DocRelationshipService;
import org.pangolin.eeip.service.DocumentService;
import org.pangolin.eeip.service.TmpDocOpLogService;
import org.pangolin.eeip.util.DocumentUtil;
import org.springframework.stereotype.Controller;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TmpDocOpLogController extends BaseController {

	@Resource
	private TmpDocOpLogService tmpDocOpLogService;
	
	@Resource
	private DocumentService documentService;
	
	@Resource
	private DocRelationshipService docRelationshipService;
	
	@Resource
	private DocHistoryService docHistoryService;
	
	@Resource 
	private DocOpLogService docOpLogService;
	
	/***
	 * 保存临时文件信息
	 * @param docOpLog 临时文件
	 * @return
	 */
	@RequestMapping(NavConst.TMP_DOC_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveTmpDocOpLog(@RequestBody TmpDocOpLogDto docOpLogDto ) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			TmpDocOpLog docOpLog = TmpDocOpLogDto.convertToTmpDocOpLog(docOpLogDto);
			status = tmpDocOpLogService.saveTmpDocOpLog(docOpLog);
			
			//删除原相关的文件
			status = docRelationshipService.removeDocRelationshipBySrcId(docOpLog.getId());
			
			//保存相关文件
			List<DocRelationship> docRelationships = docOpLogDto.getDocRelationships();
			if ( docRelationships != null && docRelationships.size() > 0 ) {
				for ( DocRelationship docRelationship : docRelationships ) {
					docRelationship.setSrcDocId(docOpLog.getId());
					status = docRelationshipService.saveDocRelationship(docRelationship);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			status = false;
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 修改正式文件，保存历史文件
	 * @param docOpLogDto
	 * @return
	 */
	@RequestMapping(NavConst.TMP_DOC_MGT_SAVE_DOCUMENT_DATA)
	@ResponseBody
	public Map<String, Object> saveDocument(@RequestBody TmpDocOpLogDto docOpLogDto) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			 TmpDocOpLog docOpLog = TmpDocOpLogDto.convertToTmpDocOpLog(docOpLogDto);
			 Document document = new Document();
			 DocOpLog opLog = new DocOpLog();
			 opLog.setEvent("Add document "+docOpLog.getName()+" Successful");
			 opLog.setType(DocOpLog.ADD);
			 
			 if ( docOpLog.getDocId() != null && !docOpLog.getDocId().equals("") ){
				 
				 document = documentService.getDocumentById(docOpLog.getDocId());
				 document.setHistDoc(true);
				 
				 //保存文件历史记录
				 DocHistory docHistory = DocumentUtil.convertDocHistory(document);
				 status = docHistoryService.saveDocHistory(docHistory);
				 
				 opLog.setEvent("Modify document "+document.getName()+" Successful");
				 opLog.setDocHistId(docHistory.getId());
				 opLog.setType(DocOpLog.REMOVE);
			 }
			 
			//保存或修改正式文件
			document = DocumentUtil.convertDocument(document, docOpLog);
            status = documentService.saveDocument(document);
            
            //保存文档操作日志
            opLog.setDocumentId(document.getId());
           // status = docOpLogService.saveDocOpLog(opLog);
			
            // 删除历史相关文件
            if ( document.getHistDoc() ) {
            	docRelationshipService.removeDocRelationshipBySrcId(document.getId());
            }
            
            //保存相关文件
 			List<DocRelationship> docRelationships = docRelationshipService.getDocRelationshipsBySrcDocId(docOpLog.getId());
 			if( docRelationships != null && docRelationships.size() > 0 ) {
 				for ( DocRelationship docRelationship : docRelationships ) {
 					DocRelationship relationship = new DocRelationship();
 					relationship.setSrcDocId(document.getId());
 					relationship.setRelevantDocId(docRelationship.getRelevantDocId());
 					status = docRelationshipService.saveDocRelationship(relationship);
 				}
 			}
             
             // 伪删除临时文件
			 status = tmpDocOpLogService.removeTmpDocOpLogFalse(docOpLog.getId());
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据ID获取临时文件信息
	 * @return ID
	 */
	@RequestMapping(NavConst.TMP_DOC_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getTmpDocOpLogById(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		TmpDocOpLog docOpLog = tmpDocOpLogService.getTmpDocOpLogById(id);
		List<Document> documents = new ArrayList<Document>();
		List<DocRelationship> docRelationships = new ArrayList<DocRelationship>();
		//相关文件
		if ( docOpLog != null ) {
			docRelationships = docRelationshipService.getDocRelationshipsBySrcDocId(id);
			if ( docRelationships != null && docRelationships.size() > 0 ) {
				for ( DocRelationship docRelationship : docRelationships ) {
					documents.add(documentService.getDocumentById(docRelationship.getRelevantDocId()));
				}
			}
		}
		docOpLog = docOpLog == null ? new TmpDocOpLog() : docOpLog;
		TmpDocOpLogDto docOpLogDto = TmpDocOpLogDto.convertToTmpDocOpLogDto(docOpLog);
		docOpLogDto.setDocuments(documents);
		docOpLogDto.setDocRelationships(docRelationships);
		result.put("entity", docOpLogDto);
		return result;
	}
	
	/***
	 * 根据正式文件ID获取临时文件信息
	 * @param docId 正式文件ID
	 * @return
	 */
	//@RequestMapping(NavConst.t)
	@ResponseBody
	public Map<String, Object> getTmpDocOpLogByDocId(String docId) {
		Map<String, Object> result = new HashMap<String, Object>();
		TmpDocOpLog docOpLog = tmpDocOpLogService.getTmpDocOpLogByDocId(docId);
		docOpLog = docOpLog == null ? new TmpDocOpLog() : docOpLog;
		result.put("entity", docOpLog);
		return result;
	}
	
	/***
	 * 根据ID伪删除文件信息
	 * @param id ID
	 * @return
	 */
	@RequestMapping(NavConst.TMP_DOC_MGT_REMOVE_FALSE_DATA)
	@ResponseBody
	public Map<String, Object> removeTmpDocOpLogFalse(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = tmpDocOpLogService.removeTmpDocOpLogFalse(id);
		result.put("status", status);
		return result;
	}
	
	/***
	 * 待审核文件列表
	 * @return
	 */
	@RequestMapping(NavConst.TMP_DOC_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> saveTmpDocOpLogList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		List<TmpDocOpLog> list = tmpDocOpLogService.getTmpDocOpLogsByStatus(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		long total = tmpDocOpLogService.getTmpDocOpLogQtyByStatus(queryParam);
		return BootstrapDataGridUtil.getResultMap(params, total, list);
	}
	
	/***
	 * 待审核和正式文件列表
	 * @return
	 */
	@RequestMapping(NavConst.TMP_DOC_MGT_ALL_LIST_DATA)
	@ResponseBody
	public Map<String, Object> saveTmpDocOpLogAndDocumentList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String queryParam = params.getExtraParam("key");
		List<TmpDocOpLog> docOpLogs = tmpDocOpLogService.getTmpDocOpLogs(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		List<Document> documents = documentService.getDocuments(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),queryParam);
		List<DocOpLogDto> dtos = DocOpLogDto.converToDocOpLogDto(documents, docOpLogs);
		long total = tmpDocOpLogService.getTmpDocOpLogQty(queryParam);
		long documentTotal = documentService.getDocumentQty(queryParam);
		return BootstrapDataGridUtil.getResultMap(params, total+documentTotal, dtos);
	}
	
	/***
	 * 上传文件
	 * @param file
	 * @param creatorId 创建者ID
	 * @param creatorName 创建者账号
	 * @param creatorAlias 创建者姓名
	 * @return
	 */
     @RequestMapping(NavConst.TMP_DOC_MGT_UPLOAD_DATA)
	 @ResponseBody
	 public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String creatorId,String creatorName,String creatorAlias,int type,String id) { 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", false);
		String uploadFolderName = "uploadFiles";
        String saveDirectoryPath =  Const.KNOWLEDGE_DOCUMENT_PATH +uploadFolderName;  
        File saveDirectory = new File(saveDirectoryPath);  
        if ( !saveDirectory.exists() ) {
				saveDirectory.mkdirs();
			}  
        if ( !file.isEmpty() ) {  
            String fileName = file.getOriginalFilename();  
            String fileExtension = FilenameUtils.getExtension(fileName);  
            File rootFile = new File(saveDirectory, UUIDHexGenerator.getInstance().generate()+"."+fileExtension);
            String path = rootFile.getPath();
            try {
            	FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
            	/*TmpDocOpLog docOpLog = new TmpDocOpLog();
            	docOpLog.setId(id);
            	docOpLog.setCreatorAlias(creatorAlias);
            	docOpLog.setCreatorId(creatorId);
            	docOpLog.setCreatorName(creatorName);
            	docOpLog.setType(type);
            	docOpLog.setExtensions(fileExtension);
            	docOpLog.setPath(path);
            	docOpLog.setName(fileName);
            	docOpLog.setYear("");
            	docOpLog.setSn("");
            	docOpLog.setDirId("");
            	docOpLog.setDelFlag(TmpDocOpLog.REMOVED);
            	tmpDocOpLogService.saveTmpDocOpLog(docOpLog);*/
            	
            	map.put("status", true);
            	map.put("fileName", fileName);
            	map.put("path", path);
            	map.put("extensions", fileExtension);
			} catch (Exception e) {
				e.printStackTrace();
			} 
        }  
		return map;
    }  
     
     /***
 	 * 根据ID删除文件信息
 	 * @param id ID
 	 * @return
 	 */
 	@RequestMapping(NavConst.TMP_DOC_MGT_REMOVE_DATA)
 	@ResponseBody
 	public Map<String, Object> removeTmpDocOpLog(String id) {
 		Map<String, Object> result = new HashMap<String, Object>();
 		boolean status = tmpDocOpLogService.removeTmpDocOpLog(id);
 		result.put("status", status);
 		return result;
 	}
     
     
     /***
 	 * 根据附件ID下载附件信息
 	 * @param response
 	 * @param attachmentId
 	 */
 	@RequestMapping(NavConst.TMP_DOC_MGT_DOWNLOAD_DATA)
 	@ResponseBody
 	public void download(HttpServletResponse response, String id) {
 		Document document = documentService.getDocumentById(id);
 		TmpDocOpLog log = tmpDocOpLogService.getTmpDocOpLogById(id);
 		if ( document != null ){
 			String name = document.getName();
 			String ext = document.getExtensions();
 			response.setContentType("application/octet-stream");
 			try { 
 				name = URLEncoder.encode(name,"UTF-8");
 				String path = document.getPath(); 
 				response.reset(); 
 				response.setHeader("Content-Disposition", "attachment;fileName="+name+"."+ext);
 	            OutputStream os=response.getOutputStream();  
 	            byte[] bytes= org.pangolin.util.FileUtil.readFile(path);
 	            os.write(bytes);
 	            os.close();
 	        } catch (Exception e) {  
 	            e.printStackTrace();  
 	        }
 		} else if ( log != null ) {
 			String name = log.getName();
 			String ext = log.getExtensions();
 			response.setContentType("application/octet-stream");
 			try { 
 				name = URLEncoder.encode(name,"UTF-8");
 				String path = log.getPath(); 
 				response.reset(); 
 				response.setHeader("Content-Disposition", "attachment;fileName="+name+"."+ext);
 	            OutputStream os=response.getOutputStream();  
 	            byte[] bytes= org.pangolin.util.FileUtil.readFile(path);
 	            os.write(bytes);
 	            os.close();
 	        } catch (Exception e) {  
 	            e.printStackTrace();  
 	        }
 		}
 	}
 	
 	/***
 	 * 下载刚上传的文档
 	 * @param response
 	 * @param name 文件名
 	 * @param path 文件路径
 	 */
 	@RequestMapping(NavConst.TMP_DOC_MGT_DOWNLOAD_UNSAVED_DATA)
 	@ResponseBody
 	public void downloadUnsaved(HttpServletResponse response, String name,String path) {
 		response.setContentType("application/octet-stream");
			try { 
				name = URLEncoder.encode(name,"UTF-8");
				response.reset(); 
				response.setHeader("Content-Disposition", "attachment;fileName="+name);
	            OutputStream os=response.getOutputStream();  
	            byte[] bytes= org.pangolin.util.FileUtil.readFile(path);
	            os.write(bytes);
	            os.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
 	}
 	
}
