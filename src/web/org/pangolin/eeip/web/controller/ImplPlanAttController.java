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
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.ImplPlanAtt;
import org.pangolin.eeip.service.ImplPlanAttService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImplPlanAttController extends BaseController {

	@Resource
	private ImplPlanAttService implPlanAttService;
	
	/***
	 * 根据内审实施计划附件ID删除内审实施计划附件信息（伪删除）
	 * @param id 内审实施计划附件ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANATT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeImplPlanAtt(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = implPlanAttService.removeImplPlanAtt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据内审实施计划申请ID获取内审实施计划附件信息列表
	 * @param id 内审实施计划申请ID
	 * @return
	 */
	@RequestMapping(NavConst.IMPLPLANATT_MGT_LIST_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getImplPlanAttByAppId (String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ImplPlanAtt> list = null;
		try {
			list = implPlanAttService.getImplPlanAttsByAppId(id);
		} catch (Exception e) {
			e.printStackTrace();
			list = new ArrayList<ImplPlanAtt>();
		}
	
		result.put("entity", list);
		return result;
	}
	
	/***
	 * 上传文件
	 * @param file
	 * @param id 内审实施计划申请ID
	 * @param creatorId 创建者ID
	 * @param creatorName 创建者账号
	 * @param creatorAlias 创建者姓名
	 * @return
	 */
     @RequestMapping(NavConst.IMPLPLANATT_MGT_UPLOAD_DATA)
	 @ResponseBody
	 public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String id,String creatorId,String creatorName,String creatorAlias) { 
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	boolean status = false;
		map.put("status", status);
		String uploadFolderName = "uploadFiles";
        String saveDirectoryPath =  Const.MEETING_PLAN_PATH +uploadFolderName;  
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
            	ImplPlanAtt implPlanAtt = new ImplPlanAtt();
            	implPlanAtt.setExt(fileExtension);
            	implPlanAtt.setImplPlanAppId(id);
            	implPlanAtt.setPath(path);
            	implPlanAtt.setCreatorAlias(creatorAlias);
            	implPlanAtt.setCreatorId(creatorId);
            	implPlanAtt.setCreatorName(creatorName);
            	implPlanAtt.setDelFlag(ImplPlanAtt.REMOVED);
            	implPlanAtt.setName(fileName);
            	
            	status = implPlanAttService.saveImplPlanAtt(implPlanAtt);
            	
				String attId = implPlanAtt.getId();
            	map.put("status", status);
            	map.put("fileName", fileName);
            	map.put("path", path);
            	map.put("id", attId);
            	map.put("ext", fileExtension);
            	
			} catch (Exception e) {
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
   	@RequestMapping(NavConst.IMPLPLANATT_MGT_DOWNLOAD_DATA)
   	@ResponseBody
   	public void download(HttpServletResponse response, String id) {
   		ImplPlanAtt implPlanAtt = implPlanAttService.getImplPlanAtt(id);
   		if ( implPlanAtt != null ) {
   			String name = implPlanAtt.getName();
   			response.setContentType("application/octet-stream");
   			try { 
   				name = URLEncoder.encode(name,"UTF-8");
   				String path = implPlanAtt.getPath(); 
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
   	@RequestMapping(NavConst.IMPLPLANATT_MGT_UPDATE_DATA)
   	@ResponseBody
   	public void updateImplPlanAttStatus(String[] ids){
   		Map<String, Object> result = new HashMap<String, Object>();
   		boolean status = false;
   		if ( ids != null && ids.length > 0 ) {
   			for ( String id : ids ) {
   			    implPlanAttService.updateImplPlanAttStatus(id);
   			    status = true;
   			}
   		}
   		result.put("status", status);
   	}
}
