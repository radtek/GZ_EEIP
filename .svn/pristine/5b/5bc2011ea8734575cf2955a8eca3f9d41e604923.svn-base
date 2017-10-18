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
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.MeetingDoc;
import org.pangolin.eeip.service.MeetingDocService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MeetingDocController extends BaseController {

	@Resource(name = "meetingDocService")
	private MeetingDocService meetingDocService;
	
	/***
	 * 根据会议资料ID获取会议资料信息
	 * @param id 会议资料ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_DOC_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingDocDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MeetingDoc meetingDoc = meetingDocService.getMeetingDocById(id);
			meetingDoc = meetingDoc == null ? new MeetingDoc() : meetingDoc;
			result.put("entity", meetingDoc);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("entity", new MeetingDoc());
		}
	
		return result;
	}
	
	/***
	 * 根据会议资料ID删除会议资料信息（伪删除）
	 * @param id 会议资料ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_DOC_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeMeetingDoc(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = meetingDocService.removeMeetingDocFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 会议资料信息列表数据源
	 * @return 会议资料数据集JSON
	 */
	@RequestMapping(NavConst.MEETINGAPP_DOC_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingDocList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<MeetingDoc> list =  meetingDocService.getMeetingDocs(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = meetingDocService.getMeetingDocQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	/***
	 * 根据会议申请ID获取会议资料信息列表
	 * @param id 会议申请ID
	 * @return
	 */
	@RequestMapping(NavConst.MEETINGAPP_DOC_MGT_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getMeetingDocByAppId (String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<MeetingDoc> list = null;
		try {
			list = meetingDocService.getMeetingDocsByMeetingAppId(id);
		} catch (Exception e) {
			e.printStackTrace();
			list = new ArrayList<MeetingDoc>();
		}
	
		result.put("entity", list);
		return result;
	}
	
	/***
	 * 上传文件
	 * @param file
	 * @param id 会议申请ID
	 * @param creatorId 创建者ID
	 * @param creatorName 创建者账号
	 * @param creatorAlias 创建者姓名
	 * @param type 文件类型
	 * @return
	 */
     @RequestMapping(NavConst.MEETINGAPP_DOC_MGT_UPLOAD_DATA)
	 @ResponseBody
	 public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String id,String creatorId,String creatorName,String creatorAlias,int type) { 
    	Map<String,Object> map = new HashMap<String,Object>();
    	//MeetingDoc doc = meetingDocService.getMeetingDocByAppIdAndType(id, type);
    	boolean status = false;
		map.put("status", status);
		String uploadFolderName = "uploadFiles";
        String saveDirectoryPath =  Const.MEETING_DOC_PATH +uploadFolderName;  
        File saveDirectory = new File(saveDirectoryPath);  
        if (!saveDirectory.exists() ) {
				saveDirectory.mkdirs();
			}  
        if ( !file.isEmpty() ) {  
            String fileName = file.getOriginalFilename();  
            String fileExtension = FilenameUtils.getExtension(fileName);  
            File rootFile = new File(saveDirectory, UUIDHexGenerator.getInstance().generate()+"."+fileExtension);
            String path = rootFile.getPath();
            try {
            	FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
            	MeetingDoc meetingDoc = new MeetingDoc();
            	meetingDoc.setExt(fileExtension);
            	meetingDoc.setMeetingAppId(id);
            	meetingDoc.setPath(path);
            	meetingDoc.setCreatorAlias(creatorAlias);
            	meetingDoc.setCreatorId(creatorId);
            	meetingDoc.setCreatorName(creatorName);
            	meetingDoc.setType(type);
            	meetingDoc.setDelFlag(MeetingDoc.REMOVED);
            	meetingDoc.setName(fileName);
            	/*if ( type == 0 ) {
            		meetingDoc.setName("会议签到表."+fileExtension);
            	} else if ( type == 1 ) {
            		meetingDoc.setName("会议记录表."+fileExtension);
            	} else {
            		
            	}*/
            	
            	status = meetingDocService.saveMeetingDoc(meetingDoc);
            	
				String docId = meetingDoc.getId();
            	map.put("status", status);
            	map.put("fileName", meetingDoc.getName());
            	map.put("path", path);
            	map.put("id", docId);
            	map.put("ext", fileExtension);
            	/*//删除上一份文件
            	if ( doc != null && doc.getId() != null && (type == 0 || type == 1) ) {
            		meetingDocService.removeMeetingDocFalse(doc.getId());
            	}*/
            	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }  
		return map;
    }  
	
     
     /***
   	 * 根据ID下载附件信息
   	 * @param response
   	 * @param attachmentId
   	 */
   	@RequestMapping(NavConst.MEETINGAPP_DOC_MGT_DOWNLOAD_DATA)
   	@ResponseBody
   	public void download(HttpServletResponse response, String id) {
   		MeetingDoc doc = meetingDocService.getMeetingDocById(id);
   		if ( doc != null ) {
   			String name = doc.getName();
   			response.setContentType("application/octet-stream");
   			try { 
   				name = URLEncoder.encode(name,"UTF-8");
   				String path = doc.getPath(); 
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
	
   	/***
   	 * 根据ID修改文件的状态
   	 * @param ids
   	 */
   	@RequestMapping(NavConst.MEETINGAPP_DOC_MGT_UPDATE_DATA)
   	@ResponseBody
   	public void updateMeetingDocStatus(String[] ids){
   		Map<String, Object> result = new HashMap<String, Object>();
   		boolean status = false;
   		if ( ids != null && ids.length > 0 ) {
   			for ( String id : ids ) {
   			    status = meetingDocService.updateMeetingDoc(id);
   			}
   		}
   		result.put("status", status);
   	}
}
