package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
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
import org.pangolin.eeip.entity.InquestDoc;
import org.pangolin.eeip.service.InquestDocService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class InquestDocController extends BaseController {

	@Resource
	private InquestDocService inquestDocService;
	
	/***
	 * 保存现场勘验文件信息
	 * @param meetingApp 现场勘验文件对象
	 * @return
	 */
	@RequestMapping(NavConst.INQUEST_DOC_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveInquestDoc(@RequestBody InquestDoc meetingApp) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = inquestDocService.saveInquestDoc(meetingApp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据现场勘验文件ID获取现场勘验文件信息
	 * @param id 现场勘验文件ID
	 * @return
	 */
	@RequestMapping(NavConst.INQUEST_DOC_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getInquestDocDetail(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			InquestDoc meetingApp = inquestDocService.getInquestDocById(id);
			meetingApp = meetingApp == null ? new InquestDoc() : meetingApp;
			result.put("entity", meetingApp);
		} catch(Exception e) {
			e.printStackTrace();
			result.put("entity", new InquestDoc());
		}
	
		return result;
	}
	
	/***
	 * 根据现场勘验文件ID删除现场勘验文件信息（伪删除）
	 * @param id 现场勘验文件ID
	 * @return
	 */
	@RequestMapping(NavConst.INQUEST_DOC_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeInquestDoc(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = inquestDocService.removeInquestDocFalse(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 现场勘验文件信息列表数据源
	 * @return 现场勘验文件数据集JSON
	 */
	@RequestMapping(NavConst.INQUEST_DOC_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getInquestDocList() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<InquestDoc> list =  inquestDocService.getInquestDocs(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = inquestDocService.getInquestDocQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}
	
	 /***
	 * 上传文件
	 * @param file
	 * @param id 现场勘验ID
	 * @param creatorId 创建者ID
	 * @param creatorName 创建者账号
	 * @param creatorAlias 创建者姓名
	 * @return
	 */
     @RequestMapping(NavConst.INQUEST_DOC_MGT_UPLOAD_DATA)
	 @ResponseBody
	 public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String id,String creatorId,String creatorName,String creatorAlias) { 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", "false");
		String uploadFolderName = "uploadFiles";
        String saveDirectoryPath =  Const.INQUEST_DOC_PATH +uploadFolderName;  
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
            	InquestDoc inquestDoc = new InquestDoc();
            	inquestDoc.setExt(fileExtension);
            	inquestDoc.setInquestId(id);
            	inquestDoc.setName(fileName);
            	inquestDoc.setPath(path);
            	inquestDoc.setCreatorAlias(creatorAlias);
            	inquestDoc.setCreatorId(creatorId);
            	inquestDoc.setCreatorName(creatorName);
            	inquestDocService.saveInquestDoc(inquestDoc);
				String inquestId = inquestDoc.getId();
            	map.put("status", "success");
            	map.put("fileName", fileName);
            	map.put("path", path);
            	map.put("id", inquestId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }  
		return map;
    }  
     
     /***
      * 根据现场勘验ID获取现场勘验文件列表信息
      * @param id 现场勘验ID
      * @return
      */
     @RequestMapping(NavConst.INQUEST_DOC_MGT_LIST_BY_INQUEST_ID_DATA)
     @ResponseBody
     public Map<String, Object> getInquestDocListByInquestId(String id) {
    	 Map<String, Object> result = new HashMap<String, Object>();
    	 List<InquestDoc> list = inquestDocService.getInquestDocsByInquestId(id);
    	 result.put("entity", list);
    	 return result;
     }
     
     /***
  	 * 根据ID下载附件信息
  	 * @param response
  	 * @param attachmentId
  	 */
  	@RequestMapping(NavConst.INQUEST_DOC_MGT_DOWNLOAD_DATA)
  	@ResponseBody
  	public void download(HttpServletResponse response, String id) {
  		InquestDoc doc = inquestDocService.getInquestDocById(id);
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
}
