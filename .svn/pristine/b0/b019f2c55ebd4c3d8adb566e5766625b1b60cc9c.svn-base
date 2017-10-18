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
import org.pangolin.eeip.entity.TrainingPlanAtt;
import org.pangolin.eeip.service.TrainingPlanAttService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TrainingPlanAttController extends BaseController {

	@Resource
	private TrainingPlanAttService trainingPlanAttService;
	
	/***
	 * 根据培训计划附件ID删除培训计划附件信息（伪删除）
	 * @param id 培训计划附件ID
	 * @return
	 */
	@RequestMapping(NavConst.TRAININGPLANATT_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeTrainingPlanAtt(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try {
			status = trainingPlanAttService.removeTrainingPlanAtt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据培训计划ID获取培训计划附件信息列表
	 * @param id 培训计划ID
	 * @return
	 */
	@RequestMapping(NavConst.TRAININGPLANATT_MGT_LIST_BY_APP_ID_DATA)
	@ResponseBody
	public Map<String, Object> getTrainingPlanAttByAppId (String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TrainingPlanAtt> list = null;
		try {
			list = trainingPlanAttService.getTrainingPlanAttsByAppId(id);
		} catch (Exception e) {
			e.printStackTrace();
			list = new ArrayList<TrainingPlanAtt>();
		}
	
		result.put("entity", list);
		return result;
	}
	
	/***
	 * 上传文件
	 * @param file
	 * @param id 培训计划ID
	 * @param creatorId 创建者ID
	 * @param creatorName 创建者账号
	 * @param creatorAlias 创建者姓名
	 * @return
	 */
     @RequestMapping(NavConst.TRAININGPLANATT_MGT_UPLOAD_DATA)
	 @ResponseBody
	 public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String id,String creatorId,String creatorName,String creatorAlias) { 
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	boolean status = false;
		map.put("status", status);
		String uploadFolderName = "uploadFiles";
        String saveDirectoryPath =  Const.TRAINING_PLAN_PATH +uploadFolderName;  
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
            	TrainingPlanAtt trainingPlanAtt = new TrainingPlanAtt();
            	trainingPlanAtt.setExt(fileExtension);
            	trainingPlanAtt.setTrainingPlanAppId(id);
            	trainingPlanAtt.setPath(path);
            	trainingPlanAtt.setCreatorAlias(creatorAlias);
            	trainingPlanAtt.setCreatorId(creatorId);
            	trainingPlanAtt.setCreatorName(creatorName);
            	trainingPlanAtt.setDelFlag(TrainingPlanAtt.REMOVED);
            	trainingPlanAtt.setName(fileName);
            	
            	status = trainingPlanAttService.saveTrainingPlanAtt(trainingPlanAtt);
            	
				String attId = trainingPlanAtt.getId();
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
   	@RequestMapping(NavConst.TRAININGPLANATT_MGT_DOWNLOAD_DATA)
   	@ResponseBody
   	public void download(HttpServletResponse response, String id) {
   		TrainingPlanAtt trainingPlanAtt = trainingPlanAttService.getTrainingPlanAtt(id);
   		if ( trainingPlanAtt != null ) {
   			String name = trainingPlanAtt.getName();
   			response.setContentType("application/octet-stream");
   			try { 
   				name = URLEncoder.encode(name,"UTF-8");
   				String path = trainingPlanAtt.getPath(); 
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
   	@RequestMapping(NavConst.TRAININGPLANATT_MGT_UPDATE_DATA)
   	@ResponseBody
   	public void updateTrainingPlanAttStatus(String[] ids){
   		Map<String, Object> result = new HashMap<String, Object>();
   		boolean status = false;
   		if ( ids != null && ids.length > 0 ) {
   			for ( String id : ids ) {
   			    trainingPlanAttService.updateTrainingPlanAttStatus(id);
   			    status = true;
   			}
   		}
   		result.put("status", status);
   	}
}
