package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
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
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.DevAttachment;
import org.pangolin.eeip.entity.UserCertificate;
import org.pangolin.eeip.service.DevAttachmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DevAttachmentController extends BaseController{
	
	@Resource
	private DevAttachmentService devAttachmentService;
	
	/***
	 * 保存设备附件表 234567
	 * @param devAttachment 设备附件对象
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_SAVEDEVATTACHMENT)
	@ResponseBody	 
	public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String id,String location,String type,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
        String saveDirectoryPath = Const.DEV_DOC_PATH;
        File saveDirectory = new File(saveDirectoryPath);
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_NAME);
        if (!file.isEmpty()) {  
            String fileName = file.getOriginalFilename();  
            String fileExt = FilenameUtils.getExtension(fileName);  
            File rootFile = new File(saveDirectory, fileName);
            String path = rootFile.getPath();
            try {
            	FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
            	DevAttachment devAttachment = new DevAttachment();
            	devAttachment.setCreatedDate(new Date());
            	devAttachment.setCreatorAlias(currentUser.getUserAlias());
            	devAttachment.setCreatorName(currentUser.getUserName());
            	devAttachment.setCreatorId(currentUser.getUserId());
            	devAttachment.setDeviceId(id);
            	devAttachment.setExt(fileExt);
            	devAttachment.setName(fileName);
            	devAttachment.setPath(path);
            	devAttachment.setType(Integer.valueOf(type));
            	devAttachment.setLocation(location);
            	devAttachmentService.saveDevAttachment(devAttachment);
            	//根据类型和deviceId返回Id 删除需要
            	DevAttachment devAtt = devAttachmentService.getDevAttachmentByTypeAndDeviceId(Integer.valueOf(type),id);
            	if(devAtt != null){
            		map.put("fileId", devAtt.getId());
            	}
            	map.put("name", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			} 
        }  
		return map;
	}
	
	/***
	 * other回显
	 * @param id 设备ID
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_LOADLIST)
	@ResponseBody
	public Map<String, Object> getDevAttachmentDetail(@RequestBody String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<DevAttachment> AttList = devAttachmentService.getDevAttachmentListByDeviceId(id);
			List<DevAttachment> DevList = new ArrayList<DevAttachment>();
			for (DevAttachment devAttachment : AttList) {
				if(devAttachment.getType().equals(0) || devAttachment.getType().equals(1) || devAttachment.getType().equals(8)){
					DevList.add(devAttachment);
				}else{
					result.put(String.valueOf(devAttachment.getType()), devAttachment);
				}
			}
			result.put("p", DevList);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", "");
		}
		return result;
	}
	
	/***
	 * 加载对象
	 * @param id attrId
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_LOADDEVATTACHMENT)
	@ResponseBody
	public Map<String, Object> getDevAttachment(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		DevAttachment devAttachment = new DevAttachment();
		try{
			devAttachment = devAttachmentService.getDevAttachmentById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		devAttachment = devAttachment == null ? new DevAttachment() : devAttachment;
		result.put("entity", devAttachment);
		return result;
	}
	
	/***
	 * 保存附件Attr 
	 * @param id attrId
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_SAVEATTACHMENTFILE)
	@ResponseBody
	public Map<String, Object> saveDevAttachment(@RequestBody DevAttachment devAttachment){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAttachmentService.saveDevAttachment(devAttachment);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 删除附件Attr 
	 * @param id attrId
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_REMOVEATTRBYID)
	@ResponseBody
	public Map<String, Object> saveDevAttachment(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAttachmentService.removeDevAttachment(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 下载附件的时候输出
	 * @param id attrId
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_DOWNATTACHMENTFILE)
	@ResponseBody
	public void download(HttpServletResponse response, String id){
		DevAttachment devAttachment = devAttachmentService.getDevAttachmentById(id);
		if(devAttachment != null){
			String name = devAttachment.getName();
			response.setContentType("application/octet-stream");
			try { 
				name = URLEncoder.encode(name,"UTF-8");
				String path = devAttachment.getPath(); 
				response.reset(); 
				response.setHeader("Content-Disposition", "devAttachment;fileName="+name);
	            OutputStream os = response.getOutputStream();  
	            byte[] bytes = org.pangolin.util.FileUtil.readFile(path);
	            os.write(bytes);
	            os.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		}
	}
	
	/***
	 * 删除对象(伪删除)
	 * @param id attrId
	 * @return
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_DELETEATTACHMENTFALSEDATA)
	@ResponseBody
	public Map<String, Object> deleteDevAttachment(String attrId){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = devAttachmentService.removeDevAttachmentFalse(attrId);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	
	
	/***
	 * 获取设备附件中图片的数量
	 * @return 设备附件数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_GETATTACHMENTPICTURENUM)
	@ResponseBody
	public Map<String, Object> getAttachmentPictureNum(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<DevAttachment> devAttachments = new ArrayList<DevAttachment>();
		List<DevAttachment> getAttachments = new ArrayList<DevAttachment>();
		try{
			devAttachments = devAttachmentService.getDevAttachmentListByDeviceId(id);
			for (DevAttachment devAttachment : devAttachments) {
				if(devAttachment.getType().equals(1)){
					getAttachments.add(devAttachment);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("entity", getAttachments);
		return result;
	}
	
	/***
	 * 把图片写出
	 * @return 设备附件数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_SHOWATTACHMENTPICTURE)
	@ResponseBody
	public void showAttachmentPicture(String id, HttpServletRequest request, HttpServletResponse response){
		try {
			if (id != null && (!id.trim().equals(""))) {
				DevAttachment devAttachment = devAttachmentService.getDevAttachmentById(id);
				File file = new File(devAttachment.getPath());
				if (file.exists() && file.canRead()) {
					FileInputStream inputStream = new FileInputStream(file);
					byte[] data = new byte[(int)file.length()];
			        inputStream.read(data);
			        inputStream.close();
			        response.setContentType("image/jpeg");
			        OutputStream stream = response.getOutputStream();
			        stream.write(data);
			        stream.flush();
			        stream.close();
				}
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 设备附件信息列表数据源
	 * @return 设备附件数据集JSON
	 */
	@RequestMapping(NavConst.DEVICE_MGT_DEVATTACHMENT_DEVATTACHMENTGIRDDATA)
	@ResponseBody
	public Map<String, Object> getDevAttachmentList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String deviceId = params.getExtraParam("deviceId");
		String type = params.getExtraParam("type");
		List<DevAttachment> list = devAttachmentService.getDevAttachments(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection(),deviceId,Integer.valueOf(type));
		long totalCount = devAttachmentService.getDevAttachmentQty(deviceId,Integer.valueOf(type));
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
