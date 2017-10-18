package org.pangolin.eeip.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.Resource;
import org.pangolin.eeip.entity.Role;

/**
 * 系统常量类
 * <p>用于集中管理系统内部使用的常量值
 * @version 1.2
 * @author Oscar Mok
 * */
public class Const {
	
	//System Language Settings -----------------------------------------
	/**
	 * Default Language Library
	 * zh_CN: Simple Chinese
	 * zh_TW: Traditional Chinese
	 * en_US: English (United State)
	 * */
	public static String DEFAULT_LANGUAGE = "zh_CN";
	
	//Workflow Settings -----------------------------------------
	/**
	 * Key of process definition (EEIP)
	 * */
	public static final String PROC_DEFN = "EEIP";
	
	//Service Provider Settings -----------------------------------------
	/**
	 * Name of Service Provider
	 * */
	public static final String SERVICE_PROVIDER_NAME = "Vanage";
	
	//User Basic Information Settings -----------------------------------------
	/**
	 * Logined User Name in Session
	 * */
	public static final String LOGIN_USER_SESSION_NAME = "loginUser";
	
	/**
	 * 系统超级管理员标识、帐户、名称
	 * */
	public static final String ADMINISTRATOR_ROLE = "ROLE_ADMIN";
	public static final String ADMINISTRATOR_ACCOUNT = "admin";
	public static final String ADMINISTRATOR_ALIAS = "\u7cfb\u7edf\u8d85\u7ea7\u7ba1\u7406\u5458";
	
	/**
	 * 系统普通（二级）管理员标识、名称
	 * */
	public static final String SECONDARY_ADMINISTRATOR_ROLE = "ROLE_SECONDARY_ADMIN";
	public static final String SECONDARY_ADMINISTRATOR_ALIAS = "\u7ba1\u7406\u5458";
	
	/**
	 * 普通帐户标识、名称
	 * */
	public static final String GUEST_ROLE = "ROLE_GUEST";
	public static final String GUEST_ALIAS = "\u666e\u901a\u8d26\u6237";
	
	/**
	 * 系统默认用户密码
	 * */
	public static final String USER_DEFAULT_PWD = "123456";
	
	//Cellphone Push Settings -----------------------------------------
	
	/**
	 * 手机应用推送服务AppKey
	 * */
	public static final String APP_KEY = "a596ee43f5a9290ff0214537";
	
	/**
	 * 手机应用推送服务Master Secret
	 * 用于服务器端 API 调用与 appkey 配合使用达到鉴权的目的
	 * */
	public static final String MASTER_SECRET = "422e6ce5995180b88ac3c78f";
	
	//Document Storage Path Settings -----------------------------------------
	
	/**
	 * 电子物证平台管理 - 文件根目录
	 * */
	public static final String EEIP_DOCUMENT_PATH = "c:/eeip_docs";
	//public static final String EEIP_DOCUMENT_PATH = "d:/eeip_docs";
	
	/**
	 * 电子物证平台管理 - 临时文件目录
	 * */
	public static final String EEIP_DOCUMENT_TEMP_PATH = EEIP_DOCUMENT_PATH + "/temp/";
	
	/**
	 * 电子物证平台管理 - 用户头像目录
	 * */
	public static final String USER_AVATAR_PATH = EEIP_DOCUMENT_PATH + "/user/avatars/";
	
	/**
	 * 电子物证平台管理 - 文档库目录
	 * */
	public static final String DOC_LIB_PATH = EEIP_DOCUMENT_PATH + "/docs/";
	
	/**
	 * 电子物证平台管理 - 电子物证文书目录
	 * */
	public static final String DOC_LIB_INSTRUMENT_PATH = EEIP_DOCUMENT_PATH + "/docs/instrument/";
	
	/**
	 * 电子物证平台管理 - 消息图片目录
	 * */
	public static final String NOTE_IMG_PATH = EEIP_DOCUMENT_PATH + "/note/images";
	
	/**
	 * 电子物证平台管理 - 电子物证图片目录
	 * */
	public static final String EVID_IMG_PATH = EEIP_DOCUMENT_PATH + "/elecEVID/images";
	
	/**
	 * 电子物证平台管理 - 电子物证视频目录
	 * */
	public static final String EVID_VIDEO_PATH = EEIP_DOCUMENT_PATH + "/elecEVID/videos";
	
	/**
	 * 电子物证平台管理 - 设备档案目录
	 * */
	public static final String DEV_DOC_PATH = EEIP_DOCUMENT_PATH + "/device/docs";
	
	/**
	 * 电子物证平台管理 - 电子物证受理拍照图片目录
	 * */
	public static final String EVID_APPRAISAL_ACPT_ATT_IMG_PATH = EEIP_DOCUMENT_PATH + "/elecEVID/images";
	
	//System Resource Settings -----------------------------------------
	
	/**
	 * 人员信息管理平台 - 基本信息照片
	 */
	public static final String USERBASICINFO_AVATAR_PATH = EEIP_DOCUMENT_PATH + "/psnlInfoMgt/userBasicInfo/avatar";
	
	/**
	 * 人员信息管理平台 - 培训履历目录
	 */
	public static final String EXPERT_DOC_PATH = EEIP_DOCUMENT_PATH + "/psnlInfoMgt/expert/train";
	
	/**
	 * 人员信息管理平台 - 资格证书目录
	 */
	public static final String CERTIFICATE_IMG_PATH = EEIP_DOCUMENT_PATH + "/psnlInfoMgt/expert/certificate";
	
	/***
	 * 人员信息管理平台 - 培训计划附件
	 */
	public static final String TRAINING_PLAN_PATH = EEIP_DOCUMENT_PATH + "/trainingPlan/attachment";
	
	/***
	 * 会议管理平台 - 会议资料
	 */
	public static final String MEETING_DOC_PATH = EEIP_DOCUMENT_PATH + "/meeting/docs";
	
	/***
	 * 会议管理平台 - 计划附件
	 */
	public static final String MEETING_PLAN_PATH = EEIP_DOCUMENT_PATH + "/plan/attachment";
	
	/***
	 * 现场勘验平台 - 文件
	 */
	public static final String INQUEST_DOC_PATH = EEIP_DOCUMENT_PATH + "/inquest/docs";
	
	/***
	 * 知识管理平台 - 知识文件
	 */
	public static final String KNOWLEDGE_DOCUMENT_PATH = EEIP_DOCUMENT_PATH + "/konwledge/documents";
	
	/**
	 * 外部系统资源<系统名称，系统主路径>
	 * */
	public static Map<String, String> SYSTEM_PATH = new HashMap<String, String>();
	
	/**
	 * Web Service URL
	 * */
	public static Map<String, String> WS_URL_MAP = new HashMap<String, String>();
	
	/**
	 * 用户角色缓存<用户帐号，角色列表>
	 * */
	public static Map<String, List<Role>> USER_ROLE_MAP = new HashMap<String, List<Role>>();
	
	/**
	 * 角色权限缓存<角色标识，权限列表>
	 * */
	public static Map<String, List<Authority>> ROLE_AUTH_MAP = new HashMap<String, List<Authority>>();
	
	/**
	 * 角色资源缓存<角色标识，资源列表>
	 * */
	public static Map<String, List<Resource>> ROLE_RESOURCE_MAP = new HashMap<String, List<Resource>>();
	
	/**
	 * 角色标识与名称缓存<角色标识，角色名称>
	 * */
	public static Map<String, String> ROLE_NAME_MAP = new HashMap<String, String>();
	
	/**
	 * 运维管理 - 是否选用资产库
	 * */
	public static final boolean USING_ASSET_LIBRARY = true;
	
	/**
	 * 操作日志管理 - 模块名称
	 * */
	public static final String MODULE_ORG_MGT = "ORG MGT";
	public static final String MODULE_USER_MGT = "USER MGT";
	public static final String MODULE_ROLE_MGT = "ROLE MGT";
	public static final String MODULE_AUTH_MGT = "AUTH MGT";
	public static final String MODULE_LOG_MGT = "LOG MGT";
	public static final String MODULE_VER_MGT = "VER MGT";
	public static final String MODULE_NOTE_MGT = "NOTE MGT";
	public static final String MODULE_DOC_MGT = "DOC MGT";
}