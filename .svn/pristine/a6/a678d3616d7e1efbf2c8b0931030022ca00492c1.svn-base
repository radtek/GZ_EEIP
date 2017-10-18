package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
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
import org.pangolin.eeip.entity.PreappraisalAtt;
import org.pangolin.eeip.service.PreappraisalAttService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PreappraisalAttController extends BaseController{
	
	@Resource
	private PreappraisalAttService preappraisalAttService;
	
	/***
	 * 保存电子物证（检材）预检信息表
	 * @param preappraisalAtt 电子物证（检材）预检信息对象
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALATT_SAVEPREAPPRAISALATTDATA)
	@ResponseBody
	public Map<String,Object> upload(@RequestParam("file") MultipartFile file,String id,String location,String type,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
        String saveDirectoryPath = Const.DOC_LIB_PATH;
        File saveDirectory = new File(saveDirectoryPath);
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute(Const.LOGIN_USER_SESSION_NAME);
        if (!file.isEmpty()) {  
            String fileName = file.getOriginalFilename();  
            String fileExt = FilenameUtils.getExtension(fileName);  
            File rootFile = new File(saveDirectory, fileName);
            String path = rootFile.getPath();
            try {
            	FileUtils.copyInputStreamToFile(file.getInputStream(),rootFile);
            	PreappraisalAtt preappraisalAtt = new PreappraisalAtt();
            	preappraisalAtt.setId(UUIDHexGenerator.getInstance().generate());
            	preappraisalAtt.setCreatedDate(new Date());
            	preappraisalAtt.setCreatorAlias(currentUser.getUserAlias());
            	preappraisalAtt.setCreatorName(currentUser.getUserName());
            	preappraisalAtt.setCreatorId(currentUser.getUserId());
            	preappraisalAtt.setPreappraisalId(id);
            	preappraisalAtt.setExt(fileExt);
            	preappraisalAtt.setName(fileName);
            	preappraisalAtt.setPath(path);
            	preappraisalAttService.savePreappraisalAtt(preappraisalAtt);
            	map.put("name", fileName);
            	map.put("id", preappraisalAtt.getId());
			} catch (Exception e) {
				e.printStackTrace();
			} 
        }  
		return map;
	}
	
	
	/***
	 * 根据电子物证（检材）预检信息ID获取电子物证（检材）预检信息信息
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALATT_LOADPREAPPRAISALATTDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisalAttDetail(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			List<PreappraisalAtt> list = preappraisalAttService.getPreappraisalAtts(id);
			result.put("entity", list);
		}catch(Exception e){
			e.printStackTrace();
			result.put("entity", new PreappraisalAtt());
		}
	
		return result;
	}
	
	//下载当前附件
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALATT_DOWNPREAPPRAISALATTDATA)
	@ResponseBody
	public void download(HttpServletResponse response, String id){
		PreappraisalAtt preappraisalAtt = preappraisalAttService.getPreappraisalAttById(id);
		if(preappraisalAtt != null){
			String name = preappraisalAtt.getName();
			response.setContentType("application/octet-stream");
			try { 
				name = URLEncoder.encode(name,"UTF-8");
				String path = preappraisalAtt.getPath(); 
				response.reset(); 
				response.setHeader("Content-Disposition", "devAttachmentachment;fileName="+name);
	            OutputStream os = response.getOutputStream();  
	            byte[] bytes = org.pangolin.util.FileUtil.readFile(path);
	            os.write(bytes);
	            os.close();
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		}
	}
	//下载当前附件
	@RequestMapping(NavConst.ELEC_EVIDMGT_PREAPPRAISALATT_DELETEPREAPPRAISALATTDATA)
	@ResponseBody
	public Map<String, Object> deletePreappraisalAttById(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = preappraisalAttService.removePreappraisalAtt(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		result.put("status", status);
		return result;
	}
	
	/***
	 * 根据电子物证（检材）预检信息ID删除电子物证（检材）预检信息信息（伪删除）
	 * @param id 电子物证（检材）预检信息ID
	 * @return
	 */
//	@RequestMapping()
	@ResponseBody
	public Map<String, Object> removePreappraisalAtt(String id){
		Map<String, Object> result = new HashMap<String, Object>();
		boolean status = false;
		try{
			status = preappraisalAttService.removePreappraisalAtt(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		result.put("status", status);
		return result;
	}
	
	/***
	 * 电子物证（检材）预检信息信息列表数据源
	 * @return 电子物证（检材）预检信息数据集JSON
	 */
//	@RequestMapping(NavConst.DEVICE_MGT_DEVDISCARDAPP_DEVDISCARDAPPGIRDDATA)
	@ResponseBody
	public Map<String, Object> getPreappraisalAttList(){
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		List<PreappraisalAtt> list = preappraisalAttService.getPreappraisalAtts(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		long totalCount = preappraisalAttService.getPreappraisalAttQty();
		return BootstrapDataGridUtil.getResultMap(params, totalCount, list);
	}

}
