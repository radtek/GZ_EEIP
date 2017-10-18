package org.pangolin.eeip.web.controller;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.dto.DocHistoryDto;
import org.pangolin.eeip.entity.DocHistory;
import org.pangolin.eeip.entity.DocRelationship;
import org.pangolin.eeip.entity.Document;
import org.pangolin.eeip.service.DocHistoryService;
import org.pangolin.eeip.service.DocRelationshipService;
import org.pangolin.eeip.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocHistoryController extends BaseController {

	@Resource
	private DocHistoryService docHistoryService;
	
	@Resource
	private DocumentService documentService;
	
	@Resource
	private DocRelationshipService docRelationshipService;
	
	/***
	 * 根据正式文件ID获取历史文件信息
	 * @param docId 正式文件ID
	 * @return
	 */
	@RequestMapping(NavConst.DOC_HISTORY_MGT_LIST_BY_DOC_ID_DATA)
	@ResponseBody
	public Map<String,Object> getDocHistoryByDocId(String docId) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<DocHistory> list = docHistoryService.getDocHistorysByDocId(docId);
		result.put("entity", list);
		return result;
	}
	
	/***
	 * 根据ID获取历史文件信息
	 * @param id ID
	 * @return
	 */
	@RequestMapping(NavConst.DOC_HISTORY_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getDocumentData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( id != null && !id.trim().equals("") ) {
			DocHistory docHistory =  docHistoryService.getDocHistory(id);
			List<Document> documents = new ArrayList<Document>();
			List<DocRelationship> docRelationships = new ArrayList<DocRelationship>();
			if ( docHistory != null ){
				docRelationships = docRelationshipService.getDocRelationshipsBySrcDocId(id);
			    if ( docRelationships != null && docRelationships.size() > 0 ) {
				   for ( DocRelationship docRelationship : docRelationships ) {
					  documents.add(documentService.getDocumentById(docRelationship.getRelevantDocId()));
				    }
			    }
			}
			docHistory = ( docHistory != null ) ? docHistory : new DocHistory();
			DocHistoryDto docHistoryDto  = DocHistoryDto.convertToDocHistoryDto(docHistory);
			docHistoryDto.setDocRelationships(docRelationships);
			docHistoryDto.setDocuments(documents);
			resultMap.put("entity", docHistoryDto);
		} else resultMap.put("entity", new DocHistoryDto());
		return resultMap;
	}
	
	/***
	 * 根据ID下载历史文件
	 * @param response
	 * @param id
	 */
	@RequestMapping(NavConst.DOC_HISTORY_MGT_DOWNLOAD_DATA)
	@ResponseBody
	public void download(HttpServletResponse response, String id) {
		DocHistory docHistory = docHistoryService.getDocHistory(id);
		if ( docHistory != null ) {
 			String name = docHistory.getName();
 			String ext = docHistory.getExtensions();
 			response.setContentType("application/octet-stream");
 			try { 
 				name = URLEncoder.encode(name,"UTF-8");
 				String path = docHistory.getPath(); 
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
}
