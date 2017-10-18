package org.pangolin.eeip.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pangolin.bootstrap.BootstrapDataGridParam;
import org.pangolin.bootstrap.BootstrapDataGridUtil;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.common.NavConst;
import org.pangolin.eeip.entity.Notification;
import org.pangolin.eeip.entity.NotificationImage;
import org.pangolin.eeip.entity.NotificationType;
import org.pangolin.eeip.entity.OperationLog;
import org.pangolin.eeip.entity.Version;
import org.pangolin.eeip.service.NotificationImageService;
import org.pangolin.eeip.service.NotificationService;
import org.pangolin.eeip.service.NotificationTypeService;
import org.pangolin.eeip.service.OperationLogService;
import org.pangolin.eeip.task.NotificationTask;
import org.pangolin.fileupload.UploadFileInfo;
import org.pangolin.util.CKEditorUtil;
import org.pangolin.util.StringUtil;
import org.pangolin.validator.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("all")
public class NotificationController extends BaseController {
	
	@Autowired
	private NotificationTypeService notificationTypeService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private NotificationImageService notificationImageService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 消息列表页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_LIST)
	public ModelAndView getNotificationListMV(Model model) {
		Long qty = notificationTypeService.getNotificationTypeQty();
		
		Boolean treeAvailability = new Boolean(false);
		if ( qty.intValue() <= 1 ) treeAvailability = new Boolean(false);
		if ( qty.intValue() > 1 ) treeAvailability = new Boolean(true);
		model.addAttribute("treeAvailability", treeAvailability);
        
		return new ModelAndView("/pangolin/systemMgt/notificationMgt/notificationList");
    }
	
	/**
	 * 消息表单页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_FORM)
	public ModelAndView getNotificationFormMV() {
        return new ModelAndView("/pangolin/systemMgt/notificationMgt/notificationForm");
	}
	
	/**
	 * 消息视图页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_VIEW)
	public ModelAndView getNotificationViewMV() {
        return new ModelAndView("/pangolin/systemMgt/notificationMgt/notificationView");
	}
	
	/**
	 * 消息表单发布页导航
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_PUBLISH)
	public ModelAndView getNotificationPublish() {
        return new ModelAndView("/pangolin/systemMgt/notificationMgt/notificationPublish");
	}
	
	/**
	 * 消息类型列表数据源
	 * @author Oscar Mok
	 * @return 消息类型数据集JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_TYPE_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationTypeListData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<NoteType> noteTypeList = new ArrayList<NoteType>();
		List<NotificationType> rootNoteTypeList = notificationTypeService.getRootNotificationTypies();
		if ( rootNoteTypeList != null && rootNoteTypeList.size() > 0 ) {
			for ( NotificationType noteType : rootNoteTypeList ) {
				noteTypeList.add(new NoteType(noteType.getId(), 
						noteType.getName(), 
						noteType.getCreatedDate(), 
						noteType.getModifiedDate(), 
						noteType.getDescription(), 
						"treegrid-" + noteType.getId()));
				addChildNoteType(noteType, noteTypeList);
			}
		}
		resultMap.put("data", noteTypeList);
		return resultMap;
	}
	
	/**
	 * 消息类型下拉选项数据源
	 * @author Oscar Mok
	 * @return 消息类型数据集JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_TYPE_OPTIONS_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationTypeOptionsData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<NotificationType> notificationTypeList = notificationTypeService.getNotificationTypies();
		resultMap.put("entity", notificationTypeList);
		return resultMap;
	}
	
	/**
	 * 消息列表数据源
	 * @author Oscar Mok
	 * @return 消息数据集JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_LIST_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationListData() {
		BootstrapDataGridParam params = BootstrapDataGridUtil.getBootstrapDataGridParam(getRequest());
		String noteTypeId = params.getExtraParam("noteTypeId");
		long totalCount = 0;
		List<Notification> notificationList = new ArrayList<Notification>();
		if ( noteTypeId != null && !noteTypeId.trim().equals("") ) {
			totalCount = notificationService.getNotificationQtyByType(noteTypeId);
			notificationList = 
					notificationService.getNotificationsByType(noteTypeId, params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		} else {
			totalCount = notificationService.getNotificationQty();
			notificationList = notificationService.getNotifications(params.getStart(), params.getLimit(), params.getSorter(), params.getSorterDirection());
		}
		return BootstrapDataGridUtil.getResultMap(params, totalCount, notificationList);
	}
	
	/**
	 * 从缓存获取消息类型数据源
	 * @author Oscar Mok
	 * @return 消息类型JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_TYPE_MGT_LOAD_CACHE_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationTypeCacheData(String label) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		NotificationType notificationType = null;
		if ( label != null && !label.trim().equals("") ) {
			notificationType = notificationTypeService.getNotificationTypeByLabel(label);
		}
		resultMap.put("entity", ( (notificationType != null) ? notificationType : new NotificationType() ));
		return resultMap;
	}
	
	/**
	 * 从缓存获取消息列表数据源
	 * @author Oscar Mok
	 * @return 消息数据集JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_LIST_CACHE_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationListCacheData(String label) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Notification> notificationList = new ArrayList<Notification>();
		if ( label != null && !label.trim().equals("") ) {
			NotificationType notificationType = notificationTypeService.getNotificationTypeByLabel(label);
			if ( notificationType != null ) {
				notificationList = notificationService.getNotificationsByTypeAndIssueRange(notificationType.getId(), getOrgSNByCurrentUser(), getRoleLabelByCurrentUser());
			}
		}
		resultMap.put("notificationList", notificationList);
		return resultMap;
	}
	
	/**
	 * 从缓存获取消息内容数据源
	 * @author Oscar Mok
	 * @return 消息内容JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_CONTENT_CACHE_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationContentCacheData(String id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String content = "";
		if ( id != null && !id.trim().equals("") ) {
			Notification notification = notificationService.getNotificationById(id);
			if ( notification != null ) content = notification.getContent();
		}
		resultMap.put("content", content);
		return resultMap;
	}

	/**
	 * 保存消息
	 * @param notification 消息对象
	 * @return 保存情况JSON
	 * 
	 */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_SAVE_DATA)
	@ResponseBody
	public Map<String, Object> saveNotification(@RequestBody Notification notification) {
		boolean status = false;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		notification.setCreatorId(getCurrentUser().getUserId());
		notification.setCreatorName(getCurrentUser().getUserName());
		notification.setCreatorAlias(getCurrentUser().getUserAlias());
		
		if(notification.getTitle() != null 
				&& StringValidator.isSpecialCharacter(notification.getTitle())){
			resultMap.put("status", status);
			return resultMap;
		}
		
		Integer logType = getLogType(notification);
		
		status = notificationService.saveNotification(notification);
		
		if ( status ) {
			NotificationImage img = null;
			if ( notification.getNotificationImages() != null 
					&& !notification.getNotificationImages().trim().equals("") ) {
				List<String> imageIdList = StringUtil.separate2List(notification.getNotificationImages(), ",");
				if ( imageIdList != null 
						&& imageIdList.size() > 0 ) {
					for ( String imgId : imageIdList ) {
						img = notificationImageService.getNotificationImageById(imgId);
						if ( img != null ) {
							img.setNotificationId(notification.getId());
							notificationImageService.saveNotificationImage(img);
						}
					}
				}
			}
			
			addNotificationTask(notification);
			saveOperationLog(notification, logType);
		}
		
		resultMap.put("status", status);
		
		return resultMap;
	}
	
	/**
	 * 设定消息状态
	 * @param id 消息ID
	 * @param status 消息状态
	 * @return 设定消息状态JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_SAVE_DATA_STATUS)
	@ResponseBody
	public Map<String, Object> saveNotificationStatus(String notificationId, Integer status) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean operationStatus = notificationService.saveNotificationStatus(notificationId, status);
		resultMap.put("status", operationStatus);
		return resultMap;
	}
	
	/**
	 * 移除消息数据
	 * @author Oscar Mok
	 * @param orgId 组织ID
	 * @return 移除情况JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_REMOVE_DATA)
	@ResponseBody
	public Map<String, Object> removeNotificationData(String notificationId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean status = false;
		if ( notificationId != null && !notificationId.trim().equals("") ) {
			Notification note = notificationService.getNotificationById(notificationId);
			if ( note != null ) {
				status = notificationService.removeNotification(notificationId);
				if ( status ) {
					removeNotificationTask(notificationId);
					saveOperationLog(note, OperationLog.REMOVE);
				}
			}
		}
		resultMap.put("status", status);
		return resultMap;
	}
	
	/**
	 * 加载消息数据（用于更新）
	 * @author Oscar Mok
	 * @param userId 用户ID
	 * @return 指定消息数据JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_LOAD_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationData(String notificationId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ( notificationId != null && !notificationId.trim().equals("") ) {
			Notification notification = notificationService.getNotificationById(notificationId);
			resultMap.put("entity", ( notification != null ) ? notification : new Notification());
		} else resultMap.put("entity", new Notification());
		return resultMap;
	}
	
	/**
	 * 上载图片数据
	 * @author Oscar Mok
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_UPLOAD_PHOTO_DATA)
	private void uploadNotificationImage(HttpServletRequest request, HttpServletResponse response) {
		try {
			String uploadPhotoPath = Const.EEIP_DOCUMENT_PATH;
	        File directory = new File(uploadPhotoPath);
	        if (!directory.exists()) directory.mkdirs();
	        
	        UploadFileInfo uploadFileInfo = CKEditorUtil.upload(request, response, uploadPhotoPath); //上载文件
	        String imageId = saveNotificationImage(uploadFileInfo);
	        if ( imageId != null && !imageId.trim().equals("") ) {
	        	CKEditorUtil.callback(request, response, 
  		                              request.getContextPath() + "/" + NavConst.SYS_NOTIFICATION_MGT_PHOTO_VIEWER + "?noteImgId=" + imageId, 
  		                              appendImage(imageId)); //回调CKEditor预览功能
	        }
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	/**
	 * 追加临时图片ID
	 * @author Oscar Mok
	 * @param imageId 图片ID
	 * */
	private String appendImage(String imageId) {
		String extraJS = "window.parent.document.getElementById('images').value += '" + imageId + ",';";
		return extraJS;
	}
	
	/**
	 * 根据消息图片ID预览图片
	 * @author Oscar Mok
	 * @param noteImgId 用户ID
	 * @param response Response对象
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_PHOTO_VIEWER)
	public void previewNotificationImage(String noteImgId, HttpServletResponse response) {
		if ( noteImgId != null && !noteImgId.trim().equals("") ) {
			try {
				NotificationImage noteImage = notificationImageService.getNotificationImageById(noteImgId);
				if ( noteImage != null ) {
					File image = new File(noteImage.getPath());
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
			} catch(Exception ex) { ex.printStackTrace(); }
		}
	}
	
	/**
	 * 加载消息数据（用于首页）
	 * @author Xiaolin Yin
	 * @return 消息数据JSON
	 * */
	@RequestMapping(NavConst.SYS_NOTIFICATION_MGT_LOAD_INDEX_DATA)
	@ResponseBody
	public Map<String, Object> getNotificationData() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Notification> resultList = new ArrayList<Notification>();
		resultList = notificationService.getNotificationsByStatus(1,0, 5, "publishedDate", "desc");
		resultMap.put("entity", resultList);
		return resultMap;
	}
	
	/**
	 * 新增消息任务
	 * @author Oscar Mok
	 * @param notification 消息对象
	 * */
	private void addNotificationTask(Notification notification) {
		try {
			if ( notification != null ) {
				if ( notification.getMethod().intValue() == Notification.AUTO.intValue() 
						&& notification.getPublishedDate() != null ) {
					if ( NotificationTask.PRE_PUBLISH_NOTES.containsKey(notification.getId()) ) 
						NotificationTask.PRE_PUBLISH_NOTES.remove(notification.getId());
					
					NotificationTask.PRE_PUBLISH_NOTES.put(notification.getId(), notification.getPublishedDate().getTime());
				}
				if ( notification.getTimeliness().booleanValue() == Notification.TIME_LIMIT 
						&& notification.getExpiredDate() != null ) {
					if ( NotificationTask.PRE_WITHDRAW_NOTES.containsKey(notification.getId()) ) 
						NotificationTask.PRE_WITHDRAW_NOTES.remove(notification.getId());
					
					NotificationTask.PRE_WITHDRAW_NOTES.put(notification.getId(), notification.getExpiredDate().getTime());
				}
			}
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	/**
	 * 移除消息任务
	 * @param notificationId 消息ID
	 * */
	private void removeNotificationTask(String notificationId) {
		NotificationTask.PRE_PUBLISH_NOTES.remove(notificationId);
		NotificationTask.PRE_WITHDRAW_NOTES.remove(notificationId);
	}
	
	/**
	 * 递归加入子类型
	 * @author Oscar Mok
	 * @param noteType 上级类型对象
	 * @param noteTypeList 类型列表
	 * */
	private void addChildNoteType(NotificationType noteType, List<NoteType> noteTypeList) {
		List<NotificationType> childNoteTypeList = notificationTypeService.getNotificationTypiesByParentType(noteType.getId());
		for ( NotificationType childNoteType : childNoteTypeList ) {
			noteTypeList.add(new NoteType(childNoteType.getId(), 
					childNoteType.getName(),
					childNoteType.getCreatedDate(), 
					childNoteType.getModifiedDate(), 
					childNoteType.getDescription(), "treegrid-"+childNoteType.getId()+" treegrid-parent-"+noteType.getId()));
			addChildNoteType(childNoteType, noteTypeList);
		}
	}
	
	/**
	 * 根据上载文件信息保存图片信息
	 * @author Oscar Mok
	 * @param uploadFileInfo 上载文件对象
	 * @return 图片ID
	 * */
	private String saveNotificationImage(UploadFileInfo uploadFileInfo) {
		String imageId = null;
		if ( uploadFileInfo != null ) {
			NotificationImage image = new NotificationImage();
			image.setName(uploadFileInfo.getOriginalFileName());
			image.setExtensions("." + uploadFileInfo.getFileExt());
			image.setPath(uploadFileInfo.getFilePath());
			image.setNotificationId("temp");
			notificationImageService.saveNotificationImage(image);
			
			imageId = image.getId();
		}
		return imageId;
	}
	
	/**
	 * 内部类-用于组装前端消息类型Treegrid页面数据源
	 * */
	private class NoteType {
		private String id;
		private String name;
		private String createdDateStr;
		private String modifiedDateStr;
		private String desc;
		private String style;

		/**
		 * 内部类构造方法
		 * @param id 类型ID
		 * @param name 类型名称
		 * @param createdDate 创建时间
		 * @param modifiedDate 修改时间
		 * @param desc 类型描述
		 * @param style 节点样式
		 * */
		public NoteType(String id, String name, Date createdDate, Date modifiedDate, String desc, String style) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			this.id = id;
			this.name = name;
			this.createdDateStr = ( createdDate != null ) ? sdf.format(createdDate) : "";
			this.modifiedDateStr = ( modifiedDate != null ) ? sdf.format(modifiedDate) : "";
			this.desc = desc;
			this.style = style;
		}
		
		//getters and setters
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCreatedDateStr() {
			return createdDateStr;
		}

		public void setCreatedDateStr(String createdDateStr) {
			this.createdDateStr = createdDateStr;
		}

		public String getModifiedDateStr() {
			return modifiedDateStr;
		}

		public void setModifiedDateStr(String modifiedDateStr) {
			this.modifiedDateStr = modifiedDateStr;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getStyle() {
			return style;
		}

		public void setStyle(String style) {
			this.style = style;
		}
	}
	
	/**
	 * 判断新增或编辑类型
	 * @author Oscar Mok
	 * @param note 消息对象
	 * @return 日志类型
	 * */
	private Integer getLogType(Notification note) {
		if ( note != null && note.getId() == null ) return OperationLog.ADD;
		else return OperationLog.MODIFY;
	}
	
	/**
	 * 保存操作日志
	 * @author Oscar Mok
	 * @param note 消息对象
	 * @param logType 日志类型
	 * */
	private void saveOperationLog(Notification note, Integer logType) {
		if ( logType.intValue() == OperationLog.ADD.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_NOTE_MGT, 
					                             OperationLog.ADD, "Add notification " + note.getTitle() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.MODIFY.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_NOTE_MGT, 
					                             OperationLog.MODIFY, "Modify notification " + note.getTitle() + " successfully", 
					                             getCurrentUser());
		} else if ( logType.intValue() == OperationLog.REMOVE.intValue() ) {
			operationLogService.saveOperationLog(Const.MODULE_NOTE_MGT, 
					                             OperationLog.REMOVE, "Remove notification " + note.getTitle() + " successfully", 
					                             getCurrentUser());
		}
	}
	
	
}