package org.pangolin.eeip.security;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.apache.commons.io.IOUtils;
import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.dto.RoleUserDto;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.AuthorityType;
import org.pangolin.eeip.entity.NotificationType;
import org.pangolin.eeip.entity.Resource;
import org.pangolin.eeip.entity.Role;
import org.pangolin.eeip.entity.RoleAuthority;
import org.pangolin.eeip.entity.RoleResource;
import org.pangolin.eeip.entity.RoleUser;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.entity.UserDetail;
import org.pangolin.eeip.licence.LicenceLoader;
import org.pangolin.eeip.service.AuthorityService;
import org.pangolin.eeip.service.AuthorityTypeService;
import org.pangolin.eeip.service.CityService;
import org.pangolin.eeip.service.CountyService;
import org.pangolin.eeip.service.NotificationTypeService;
import org.pangolin.eeip.service.ProvinceService;
import org.pangolin.eeip.service.ResourceService;
import org.pangolin.eeip.service.RoleAuthorityService;
import org.pangolin.eeip.service.RoleResourceService;
import org.pangolin.eeip.service.RoleService;
import org.pangolin.eeip.service.RoleUserService;
import org.pangolin.eeip.service.UserDetailService;
import org.pangolin.eeip.service.UserService;
import org.pangolin.eeip.util.SpringUtil;
import org.pangolin.security.encryption.MD5Encryption;
import org.pangolin.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

@SuppressWarnings("all")
public class InitSystemDataServlet extends HttpServlet {
	
	private static final Logger log = LoggerFactory.getLogger(InitSystemDataServlet.class);
	
	private static final String ROLE_PROPERTY_FILE_PATH= "/sys_roles.properties";
	private static final String AUTH_PROPERTY_FILE_PATH= "/sys_authorities.properties";
	private static final String RESOURCE_PROPERTY_FILE_PATH= "/sys_resources.properties";
	private static final String ROLE_AUTH_TYPE_PROPERTY_FILE_PATH= "/sys_auth_typies.properties";
	private static final String ROLE_AUTH_PROPERTY_FILE_PATH= "/sys_role_authorities.properties";
	private static final String ROLE_RESOURCE_PROPERTY_FILE_PATH= "/sys_role_resources.properties";
	private static final String NOTIFICATION_TYPE_PROPERTY_FILE_PATH= "/sys_notification_typies.properties";
	private static final String WEBAPPS_PROPERTY_FILE_PATH= "/webapps.properties";
	private static final String WEB_SERVICE_PROPERTY_FILE_PATH = "/webservice.properties";
	
	private static final String REGION_PROVINCE_SQL_SCRIPT = "/scripts/region_province.sql";
	private static final String REGION_CITY_SQL_SCRIPT = "/scripts/region_city.sql";
	private static final String REGION_COUNTRY_SQL_SCRIPT = "/scripts/region_country.sql";
	
	protected SpringUtil springUtil = new SpringUtil();
	
	private UserService userService = (UserService) springUtil.getBean("userService");
	private UserDetailService userDetailService = (UserDetailService) springUtil.getBean("userDetailService");
	private RoleService roleService = (RoleService) springUtil.getBean("roleService");
	private AuthorityTypeService authorityTypeService = (AuthorityTypeService) springUtil.getBean("authorityTypeService");
	private AuthorityService authorityService = (AuthorityService) springUtil.getBean("authorityService");
	private ResourceService resourceService = (ResourceService) springUtil.getBean("resourceService");
	private RoleUserService roleUserService = (RoleUserService) springUtil.getBean("roleUserService");
	private RoleAuthorityService roleAuthorityService = (RoleAuthorityService) springUtil.getBean("roleAuthorityService");
	private RoleResourceService roleResourceService = (RoleResourceService) springUtil.getBean("roleResourceService");
	private NotificationTypeService notificationTypeService = (NotificationTypeService) springUtil.getBean("notificationTypeService");
	
	private ProvinceService provinceService = (ProvinceService) springUtil.getBean("provinceService");
	private CountyService countyService = (CountyService) springUtil.getBean("countyService");
	private CityService cityService = (CityService) springUtil.getBean("cityService");
	
	private HikariDataSource dataSource = (HikariDataSource) springUtil.getBean("dataSource");
	
	/**
	 * 初始化系统数据
	 * @author Oscar Mok
	 * */
	public void init() {
		try {
			//初始化数据（用户、角色、权限）
			initRoles();
			initAuthorityTypies();
			initAuthorities();
			initResources();
			initRoleAuthorities();
			initRoleResources();
			initUsers();
			initNotificationTypies();
			//加载数据（角色、权限）
			loadUserRoles();
			loadRoleAuthorities();
			loadRoleResources();
			//加载WebService资源
			loadWebServiceUrl();
			//加载角色名称
			loadRoleNames();
			//加载系统路径
			loadSystemPath();
			//加载资产库设定
			loadAssetLibrarySettings();
			//初始化许可证
			LicenceLoader.initialize(getServletContext());
			//加载区域数据脚本
			initRegions();
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 初始化用户数据
	 * @author Oscar Mok
	 * */
	private void initUsers() {
		try {
			if ( !userService.existUser(Const.ADMINISTRATOR_ACCOUNT) ) {
				User user = new User();
				user.setUserName(Const.ADMINISTRATOR_ACCOUNT);
				user.setUserAlias(Const.ADMINISTRATOR_ALIAS);
				user.setUserPwd(MD5Encryption.encrypt(Const.USER_DEFAULT_PWD));
				user.setUserRegStatus(User.EXISTING);
				boolean status = userService.saveUser(user);
				if ( status ) {
					UserDetail userDetail = new UserDetail();
					userDetail.setUserId(user.getUserId());
					status = userDetailService.saveUserDetail(userDetail); //save user detail info
					
					if ( status ) {
						Role role = roleService.getRoleByLabel(Const.ADMINISTRATOR_ROLE);
						if ( role != null ) {
							RoleUser roleUser = new RoleUser();
							roleUser.setRoleId(role.getRoleId());
							roleUser.setUserId(user.getUserId());
							roleUserService.saveRoleUser(roleUser);
						}
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 初始化角色数据
	 * @author Oscar Mok
	 * */
	private void initRoles() {
		try {
			Role role = null;
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(ROLE_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				saveRole(getRole(propertyValue));
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 初始化权限类型数据
	 * @author Oscar Mok
	 * */
	private void initAuthorityTypies() {
		try {
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(ROLE_AUTH_TYPE_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			List<String> parentAuthTypePropVal = new ArrayList<String>();
			List<String> subAuthTypePropVal = new ArrayList<String>();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				if ( propertyValue.indexOf("PARENT") != -1 ) {
					subAuthTypePropVal.add(propertyValue);
				} else {
					parentAuthTypePropVal.add(propertyValue);
				}
			}
			
			for ( String val : parentAuthTypePropVal ) {
				AuthorityType authorityType = getAuthorityType(val);
				authorityTypeService.saveAuthorityType(authorityType);
			}
			
			for ( String val : subAuthTypePropVal ) {
				AuthorityType authorityType = getAuthorityType(val);
				authorityTypeService.saveAuthorityType(authorityType);
			}
			
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 初始化权限数据
	 * @author Oscar Mok
	 * */
	private void initAuthorities() {
		try {
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(AUTH_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				saveAuthority(getAuthority(propertyValue));
			}
			
			validateParentAuthorities();
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 初始化访问资源数据
	 * @author Oscar Mok
	 * */
	private void initResources() {
		try {
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(RESOURCE_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				saveResource(getResource(propertyValue));
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Initialize Relationship Data of Role and Authority
	 * @author Oscar Mok
	 * */
	private void initRoleAuthorities() {
		try {
			Role role = null; Authority authority = null;
			RoleAuthority roleAuthority = null;
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(ROLE_AUTH_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				roleAuthority = getRoleAuthority(propertyValue);
				if ( roleAuthority != null ) roleAuthorityService.saveRoleAuthority(roleAuthority);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Initialize Relationship Data of Role and Resource
	 * @author Oscar Mok
	 * */
	private void initRoleResources() {
		try {
			Role role = null; Resource resource = null;
			RoleResource roleResource = null;
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(ROLE_RESOURCE_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				roleResource = getRoleResource(propertyValue);
				if ( roleResource != null ) roleResourceService.saveRoleResource(roleResource);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Initialize Typies of Notification
	 * @author Oscar Mok
	 * */
	private void initNotificationTypies() {
		try {
			NotificationType noteType = null;
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(NOTIFICATION_TYPE_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			List<String> parentNoteTypePropVal = new ArrayList<String>();
			List<String> subNoteTypePropVal = new ArrayList<String>();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				
				if ( propertyValue.indexOf("PARENT") != -1 ) {
					subNoteTypePropVal.add(propertyValue);
				} else {
					parentNoteTypePropVal.add(propertyValue);
				}
			}
			
			for ( String val : parentNoteTypePropVal ) {
				noteType = getNotificationType(val);
				
				if ( !notificationTypeService.existNotificationType(noteType.getLabel()) ) 
					notificationTypeService.saveNotificationType(noteType);
			}
			
			for ( String val : subNoteTypePropVal ) {
				noteType = getNotificationType(val);
				if ( !notificationTypeService.existNotificationType(noteType.getLabel()) ) 
					notificationTypeService.saveNotificationType(noteType);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	private void saveRole(Role role) {
		try {
			if ( role != null ) {
				if ( roleService.getRoleByLabel(role.getRoleLabel()) == null ) 
					roleService.saveRole(role);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	private void saveResource(Resource resource) {
		try {
			if ( resource != null ) {
				if ( resourceService.getResourceByLabel(resource.getResourceLabel()) == null ) 
					resourceService.saveResource(resource);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	private void saveAuthority(Authority authority) {
		try {
			if ( authority != null ) {
				if ( authorityService.getAuthorityByLabel(authority.getAuthorityLabel()) == null ) 
					authorityService.saveAuthority(authority);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	private Role getRole(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String roleName = null, roleLabel = null, roleDesc = null;
				Role role = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("NAME") != -1 && roleName == null ) roleName = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("LABEL") != -1 && roleLabel == null ) roleLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("DESC") != -1 && roleDesc == null ) roleDesc = param.substring(param.indexOf("=")+1);
				}
				
				if ( roleName != null && !roleName.trim().equals("") 
						&& roleLabel != null && !roleLabel.trim().equals("") ) {
					role = new Role();
					role.setRoleName(roleName);
					role.setRoleLabel(roleLabel);
					if ( roleDesc != null && !roleDesc.trim().equals("") && !roleDesc.trim().equals("''") ) role.setRoleDesc(roleDesc);
					return role;
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	private Resource getResource(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String resourceName = null, resourceLabel = null, resourceLocation = null, resourceDesc = null;
				Resource resource = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("NAME") != -1 && resourceName == null ) resourceName = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("LABEL") != -1 && resourceLabel == null ) resourceLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("URL") != -1 && resourceLocation == null ) resourceLocation = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("DESC") != -1 && resourceDesc == null ) resourceDesc = param.substring(param.indexOf("=")+1);
				}
				
				if ( resourceName != null && !resourceName.trim().equals("") 
						&& resourceLabel != null && !resourceLabel.trim().equals("") 
						&& resourceLocation != null && !resourceLocation.trim().equals("") ) {
					resource = new Resource();
					resource.setResourceName(resourceName);
					resource.setResourceLabel(resourceLabel);
					resource.setResourceLocation(resourceLocation);
					if ( resourceDesc != null && !resourceDesc.trim().equals("") && !resourceDesc.trim().equals("''") ) 
						resource.setResourceDesc(resourceDesc);
					return resource;
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	private AuthorityType getAuthorityType(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String authorityTypeName = null, authorityTypeLabel = null, parentAuthorityTypeLabel = null;
				AuthorityType authorityType = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("NAME") != -1 && authorityTypeName == null ) authorityTypeName = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("LABEL") != -1 && authorityTypeLabel == null ) authorityTypeLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("PARENT") != -1 && parentAuthorityTypeLabel == null ) parentAuthorityTypeLabel = param.substring(param.indexOf("=")+1);
				}
				
				if ( authorityTypeName != null && !authorityTypeName.trim().equals("") 
						&& authorityTypeLabel != null && !authorityTypeLabel.trim().equals("") ) {
					
					AuthorityType parentAuthType = null;
					if ( parentAuthorityTypeLabel != null && !parentAuthorityTypeLabel.trim().equals("") ) {
						parentAuthType = authorityTypeService.getAuthorityTypeByLabel(parentAuthorityTypeLabel);
					}
					
					authorityType = new AuthorityType();
					authorityType.setAuthorityTypeName(authorityTypeName);
					authorityType.setAuthorityTypeLabel(authorityTypeLabel);
					if (parentAuthType != null) authorityType.setParentAuthorityTypeId(parentAuthType.getAuthorityTypeId());
					return authorityType;
				}
				
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	private Authority getAuthority(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String authorityTypeLabel = null, authorityName = null, authorityLabel = null, parentAuthorityLabel = null, authorityDesc = null;
				Authority authority = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("TYPE") != -1 && authorityTypeLabel == null ) authorityTypeLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("NAME") != -1 && authorityName == null ) authorityName = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("LABEL") != -1 && authorityLabel == null ) authorityLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("RELATED_AUTH") != -1 && parentAuthorityLabel == null ) parentAuthorityLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("DESC") != -1 && authorityDesc == null ) authorityDesc = param.substring(param.indexOf("=")+1);
				}
				
				if ( authorityTypeLabel != null && !authorityTypeLabel.trim().equals("") 
						&& authorityName != null && !authorityName.trim().equals("") 
						&& authorityLabel != null && !authorityLabel.trim().equals("") ) {
					AuthorityType authorityType = authorityTypeService.getAuthorityTypeByLabel(authorityTypeLabel);
					
					if ( authorityType != null ) {
						authority = new Authority();
						authority.setAuthorityName(authorityName);
						authority.setAuthorityLabel(authorityLabel);
						if ( parentAuthorityLabel != null && !parentAuthorityLabel.trim().equals("") ) authority.setParentAuthorityLabel(parentAuthorityLabel);
						if ( authorityDesc != null && !authorityDesc.trim().equals("") && !authorityDesc.trim().equals("''") ) authority.setAuthorityDesc(authorityDesc);
						authority.setAuthorityTypeId(authorityType.getAuthorityTypeId());
						return authority;
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	/**
	 * 验证各权限之父级权限有效性
	 * */
	private void validateParentAuthorities() {
		List<Authority> authorities = authorityService.getAuthorities();
		if ( authorities != null && authorities.size() > 0 ) {
			for ( Authority authority : authorities ) {
				if ( authority.getParentAuthorityLabel() != null 
						&& !authority.getParentAuthorityLabel().trim().equals("") ) {
					if ( !authorityService.existAuthority(authority.getParentAuthorityLabel()) ) {
						authority.setParentAuthorityLabel(null);
						authorityService.saveAuthority(authority);
					}
				}
			}
		}
	}
	
	private RoleAuthority getRoleAuthority(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String roleLabel = null, authorityLabel = null;
				RoleAuthority roleAuthority = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("ROLE") != -1 && roleLabel == null ) { roleLabel = param.substring(param.indexOf("=")+1); continue; }
					if ( param.indexOf("AUTH") != -1 && authorityLabel == null ) { authorityLabel = param.substring(param.indexOf("=")+1); continue; }
				}
				
				if ( roleLabel != null && authorityLabel != null 
						&& !roleLabel.trim().equals("") && !authorityLabel.trim().equals("") ) {
					Role role = roleService.getRoleByLabel(roleLabel);
					Authority authority = authorityService.getAuthorityByLabel(authorityLabel);
					if ( role != null && authority != null ) {
						if ( !roleAuthorityService.existRoleAuthority(role.getRoleId(), authority.getAuthorityId()) ) {
							roleAuthority = new RoleAuthority();
							roleAuthority.setRoleId(role.getRoleId());
							roleAuthority.setAuthorityId(authority.getAuthorityId());
							return roleAuthority;
						}
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	private RoleResource getRoleResource(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String roleLabel = null, resourceLabel = null;
				RoleResource roleResource = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("ROLE") != -1 && roleLabel == null ) roleLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("RSRC") != -1 && resourceLabel == null ) resourceLabel = param.substring(param.indexOf("=")+1);
				}
				
				if ( roleLabel != null && resourceLabel != null 
						&& !roleLabel.trim().equals("") && !resourceLabel.trim().equals("") ) {
					Role role = roleService.getRoleByLabel(roleLabel);
					Resource resource = resourceService.getResourceByLabel(resourceLabel);
					if ( role != null && resource != null ) {
						if ( !roleResourceService.existRoleResource(role.getRoleId(), resource.getResourceId()) ) {
							roleResource = new RoleResource();
							roleResource.setRoleId(role.getRoleId());
							roleResource.setResourceId(resource.getResourceId());
							return roleResource;
						}
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	private NotificationType getNotificationType(String config) {
		try {
			if ( config != null && !config.trim().equals("") ) {
				String noteTypeName = null, noteTypeLabel = null, noteTypeDesc = null, parentNoteTypeLabel = null;
				NotificationType notificationType = null;
				String[] configArray = StringUtil.separate2Array(config, ",");
				for ( String param : configArray ) {
					param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
					if ( param.indexOf("NAME") != -1 && noteTypeName == null ) noteTypeName = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("LABEL") != -1 && noteTypeLabel == null ) noteTypeLabel = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("DESC") != -1 && noteTypeDesc == null ) noteTypeDesc = param.substring(param.indexOf("=")+1);
					if ( param.indexOf("PARENT") != -1 && parentNoteTypeLabel == null ) parentNoteTypeLabel = param.substring(param.indexOf("=")+1);
				}
				
				if ( noteTypeName != null && !noteTypeName.trim().equals("") 
						&& noteTypeLabel != null && !noteTypeLabel.trim().equals("") ) {
					notificationType = new NotificationType();
					notificationType.setName(noteTypeName);
					notificationType.setLabel(noteTypeLabel);
					notificationType.setDescription(noteTypeDesc);
					
					if ( parentNoteTypeLabel != null 
							&& !parentNoteTypeLabel.trim().equals("") ) {
						NotificationType parentNotificationType = 
								notificationTypeService.getNotificationTypeByLabel(parentNoteTypeLabel);
						if ( parentNotificationType != null ) 
							notificationType.setParentNoteTypeId(parentNotificationType.getId());
					}
					
					if ( notificationType != null ) return notificationType;
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	/**
	 * Load Roles of User
	 * @author Oscar Mok
	 * */
	private void loadUserRoles() {
		List<RoleUserDto> roleUserDtoList = roleUserService.getRoleUserDtos();
		Role role = null; List<Role> roleList = null;
		List<User> userList = userService.getUsers();
		for ( User user : userList ) {
			roleList = new ArrayList<Role>();
			for ( RoleUserDto roleUserDto : roleUserDtoList ) {
				if ( roleUserDto.getUserName().trim().equals(user.getUserName()) ) {
					role = new Role();
					role.setRoleId(roleUserDto.getRoleId());
					role.setRoleName(roleUserDto.getRoleName());
					role.setRoleLabel(roleUserDto.getRoleLabel());
					roleList.add(role);
				}
			}			
			Const.USER_ROLE_MAP.put(user.getUserName(), roleList);
		}
	}
	
	/**
	 * Load Authorities of Role
	 * @author Oscar Mok
	 * */
	private void loadRoleAuthorities() {
		try {
			List<Authority> authorityList = null;
			List<Role> roleList = roleService.getRoles();
			if ( roleList != null && roleList.size() > 0 ) {
				for ( Role role : roleList ) {
					authorityList = authorityService.getAuthoritiesByRole(role.getRoleId());
					if ( authorityList != null && authorityList.size() > 0 ) {
						Const.ROLE_AUTH_MAP.put(role.getRoleLabel(), authorityList);
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Load Resources of Role
	 * @author Oscar Mok
	 * */
	private void loadRoleResources() {
		try {
			List<Resource> resourceList = null;
			List<Role> roleList = roleService.getRoles();
			if ( roleList != null && roleList.size() > 0 ) {
				for ( Role role : roleList ) {
					resourceList = resourceService.getResourcesByRole(role.getRoleId());
					if ( resourceList != null && resourceList.size() > 0 ) {
						Const.ROLE_RESOURCE_MAP.put(role.getRoleLabel(), resourceList);
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Load Role Names
	 * @author Oscar Mok
	 * */
	private void loadRoleNames() {
		try {
			List<Role> roleList = roleService.getRoles();
			if ( roleList != null && roleList.size() > 0 ) {
				for ( Role role : roleList ) {
					Const.ROLE_NAME_MAP.put(role.getRoleLabel(), role.getRoleName());
				}
				getServletContext().setAttribute("ROLE_NAME", Const.ROLE_NAME_MAP);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Load System Path
	 * @author Oscar Mok
	 * */
	private void loadSystemPath() {
		try {
			String protocol = null, ipAddr = null, port =null, contextRoot = null;
			String propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(WEBAPPS_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
				String[] info = getWebAppsInfo(propertyValue);
				
				protocol = info[0];
				ipAddr = info[1]; 
				contextRoot = info[2]; 
				port = info[3];
				
				Const.SYSTEM_PATH.put(propertyName, protocol + "://" + ipAddr + ( port.trim().equals("80") ? "" : ":"+ port ) + "/" + contextRoot);
			}
			
			getServletContext().setAttribute("SYS_PATH", Const.SYSTEM_PATH);
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 加载应用系统配置信息
	 * @author Oscar Mok
	 * @param config 配置信息
	 * @return 配置信息数组
	 * */
	private String[] getWebAppsInfo(String config) {
		String[] info = new String[4];
		String protocol = null, ipAddr = null, contextRoot = null, port = null;
		String[] configArray = StringUtil.separate2Array(config, ",");
		for ( String param : configArray ) {
			param = param.substring(param.indexOf("[") + 1, param.lastIndexOf("]"));
			if ( param.indexOf("PROTOCOL") != -1 && protocol == null ) protocol = param.substring(param.indexOf("=")+1);
			if ( param.indexOf("IP_ADDR") != -1 && ipAddr == null ) ipAddr = param.substring(param.indexOf("=")+1);
			if ( param.indexOf("CONTEXT_ROOT") != -1 && contextRoot == null ) contextRoot = param.substring(param.indexOf("=")+1);
			if ( param.indexOf("PORT") != -1 && port == null ) port = param.substring(param.indexOf("=")+1);
		}
		
		info[0] = protocol;
		info[1] = ipAddr;
		info[2] = contextRoot;
		info[3] = port;
		
		return info;
	}
	
	/**
	 * Load Asset Library Settings
	 * @author Oscar Mok
	 * */
	private void loadAssetLibrarySettings() {
		try {
			getServletContext().setAttribute("ASSET_LIBRARY", Const.USING_ASSET_LIBRARY);
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * Load Url of Web Service
	 * @author Oscar Mok
	 * */
	private void loadWebServiceUrl() {
		try {
			String url, propertyName = "", propertyValue = "";
			InputStream is = getClass().getResourceAsStream(WEB_SERVICE_PROPERTY_FILE_PATH);
			Properties propertyLoader = new Properties();
			propertyLoader.load(is);
			
			Set<String> propertyNamesSet = propertyLoader.stringPropertyNames();
			Iterator propertyNamesInterator = propertyNamesSet.iterator();
			
			while( propertyNamesInterator.hasNext() ) {
				propertyName = (String) propertyNamesInterator.next();
				propertyValue = propertyLoader.getProperty( propertyName );
								
				if ( !Const.WS_URL_MAP.containsKey(propertyName) ) {
					Const.WS_URL_MAP.put(propertyName, propertyValue);
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 初始化区域SQL脚本数据
	 * @author Oscar Mok
	 * */
	private void initRegions() {
		try {
			if ( !existProvinceData() ) {
				loadRegionData(REGION_PROVINCE_SQL_SCRIPT);
			}
			if ( !existCityData() ) {
				loadRegionData(REGION_CITY_SQL_SCRIPT);
			}
			if ( !existCountryData() ) {
				loadRegionData(REGION_COUNTRY_SQL_SCRIPT);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 加载SQL脚本数据
	 * @author Oscar Mok
	 * @param sqlScript SQL脚本位置
	 * */
	private void loadRegionData(String sqlScript) {
		try {
			InputStream is = getClass().getResourceAsStream(sqlScript);
			String result = IOUtils.toString(is, "UTF-8");
			if ( result != null && !result.trim().equals("") ) {
				List<String> sqlList = new ArrayList<String>();
				sqlList = StringUtil.separate2List(result, ";");
				
				Connection con = null;
				PreparedStatement stmt = null;
				try {
					con = dataSource.getConnection();
					con.setAutoCommit(false);
					for (String sql : sqlList) {
						stmt = con.prepareStatement(sql);
						stmt.executeUpdate();
					}
					con.commit();
					con.setAutoCommit(true);
				} catch(SQLException ex) {
					con.rollback();
					log.error(ex.getMessage()); 
				} finally {
					if ( con != null ) con.close();
					if ( stmt != null ) stmt.close();
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 判断是否存在省级数据
	 * @author Oscar Mok
	 * */
	private boolean existProvinceData() {
		try {
			Long qty = provinceService.getProvinceQty();
			if ( qty > 0 ) return true;
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
	
	/**
	 * 判断是否存在市级数据
	 * @author Oscar Mok
	 * */
	private boolean existCityData() {
		try {
			Long qty = cityService.getCityQty();
			if ( qty > 0 ) return true;
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
	
	/**
	 * 判断是否存在县区级数据
	 * @author Oscar Mok
	 * */
	private boolean existCountryData() {
		try {
			Long qty = countyService.getCountyQty();
			if ( qty > 0 ) return true;
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
}