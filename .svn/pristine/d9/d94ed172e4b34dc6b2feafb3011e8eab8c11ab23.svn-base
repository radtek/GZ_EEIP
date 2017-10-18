package org.pangolin.eeip.security;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.entity.AccessLog;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.licence.LicenceLoader;
import org.pangolin.eeip.service.AccessLogService;
import org.pangolin.eeip.service.OrganizationService;
import org.pangolin.eeip.service.UserService;
import org.pangolin.eeip.util.SpringUtil;
import org.pangolin.security.encryption.MD5Encryption;
import org.pangolin.util.NumberUtil;
import org.pangolin.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class SignInServlet extends HttpServlet {

	private static final Logger log = LoggerFactory.getLogger(SignInServlet.class);
	
	/**
	 * 系统免登录
	 * */
	private static final String REMEMBER_ME = "1";
	
	/**
	 * Cookie 超时值
	 * Cookie 时间单位：秒
	 * */
	private static final int COOKIE_TIMEOUT = 60 * 60 * 24 * 90;
	
	//-----------------------------------------------------------------
	
	/**
	 * 浏览器类型 - 个人电脑
	 * */
	private static final String NAVIGATOR_PC = "0";
	
	/**
	 * 浏览器类型 - 浏览器
	 * */
	private static final String NAVIGATOR_CELLPHONE = "1";
	
	//-----------------------------------------------------------------
	
	/**
	 * 重定向操作代码 - 登录成功
	 * */
	private static final Integer SIGN_IN_SUCCESS = new Integer(0);
	
	/**
	 * 重定向操作代码 - 用户帐号失效
	 * */
	private static final Integer USER_DISABLED = new Integer(1);
	
	/**
	 * 重定向操作代码 - 用户登录信息错误
	 * */
	private static final Integer USER_INFO_ERROR = new Integer(2);
	
	/**
	 * 重定向操作代码 - LICENSE信息有误
	 * */
	private static final Integer INVALID_LICENSE = new Integer(3);
	
	/**
	 * POST方式访问
	 * @param request Request 对象
	 * @param response Response 对象
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.signIn(request, response);
	}
	
	/**
	 * GET方式访问
	 * @param request Request 对象
	 * @param response Response 对象
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.signIn(request, response);
	}
	
	/**
	 * 用户系统登录
	 * @param request Request 对象
	 * @param response Response 对象
	 * */
	private void signIn(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String userName = request.getParameter("username");
			String userPwd = request.getParameter("password");
			String navigatorType = request.getParameter("navigatorType");
			String autoSignInStatus = request.getParameter("rememberMe");
			
			if ( LicenceLoader.validateLicence() ) { //许可证有效性验证
				SpringUtil springUtil = new SpringUtil();
				UserService userService = (UserService) springUtil.getBean("userService");
				
				if ( userName != null && !userName.trim().equals("") 
						&& userPwd != null && !userPwd.trim().equals("") ) {
					User user = userService.getUserByName(userName);
					if ( user != null ) {
						if ( validateUserPwd(user, userPwd) ) { //用户密码验证
							if ( validateUserAvailability(user) ) { //用户可用性验证
								CurrentUser currentUser = userService.getCurrentUser(user);
								if ( currentUser != null ) {
									currentUser.setIpAddr(RequestUtil.getIpAddress(request));
										
									String ticketId = ServiceTicket.generateTicket();
									session.setAttribute(Const.LOGIN_USER_SESSION_NAME, currentUser);
									ServiceTicket.push(ticketId, currentUser.getUserName());
									session.setAttribute("service_ticket", ticketId);
										
									if ( autoSignInStatus != null 
											&& autoSignInStatus.trim().equals(REMEMBER_ME) ) {
										createCookie(userName, response);
									}
										
									saveAccessLog(request, user, "User "+ user.getUserName() +" login successfully", AccessLog.SUCCESS);
									pageRedirect(navigatorType, request, response, SIGN_IN_SUCCESS); 
								}
							}  else {
								//User is disabled
								saveAccessLog(request, user, "User "+ user.getUserName() +" is disabled", AccessLog.FAILURE);
								pageRedirect(navigatorType, request, response, USER_DISABLED);
							}
						} else {
							//User password is incorrect
							saveAccessLog(request, user, "User password is incorrect", AccessLog.FAILURE);
							pageRedirect(navigatorType, request, response, USER_INFO_ERROR);
						}
					} else {
						//User does not exist
						pageRedirect(navigatorType, request, response, USER_INFO_ERROR);
					}
				}
			} else {
				pageRedirect(navigatorType, request, response, INVALID_LICENSE);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 页面重定向
	 * @param navigatorType 浏览器类型
	 * @param request request对象
	 * @param response response对象
	 * @param operationCode 操作代码
	 * */
	private void pageRedirect(String navigatorType, HttpServletRequest request, HttpServletResponse response, Integer operationCode) {
		try {
			if ( navigatorType.trim().equals(NAVIGATOR_PC) ) {
				if ( operationCode.intValue() == SIGN_IN_SUCCESS.intValue() ) {
					response.sendRedirect(request.getContextPath()+"/");
				}
				if ( operationCode.intValue() == USER_DISABLED.intValue() ) {
					response.sendRedirect(request.getContextPath()+"/login.jsp?action=user_disabled");
				}
				if ( operationCode.intValue() == USER_INFO_ERROR.intValue() ) {
					response.sendRedirect(request.getContextPath()+"/login.jsp?action=user_info_error");
				}
				if ( operationCode.intValue() == INVALID_LICENSE.intValue() ) {
					response.sendRedirect(request.getContextPath()+"/login.jsp?action=invalid_license");
				}
			}
			if ( navigatorType.trim().equals(NAVIGATOR_CELLPHONE) ) {
				if ( operationCode.intValue() == SIGN_IN_SUCCESS.intValue() ) {
					//response.sendRedirect(request.getContextPath()+"/mobile/homepage.do");
					response.sendRedirect(request.getContextPath()+"/test/app/ionic/home.jsp");
				}
				if ( operationCode.intValue() == USER_DISABLED.intValue() ) {
					//response.sendRedirect(request.getContextPath()+"/mobile/login.do?action=user_disabled");
					response.sendRedirect(request.getContextPath()+"/test/app/ionic/login.jsp?action=user_disabled");
				}
				if ( operationCode.intValue() == USER_INFO_ERROR.intValue() ) {
					//response.sendRedirect(request.getContextPath()+"/mobile/login.do?action=user_info_error");
					response.sendRedirect(request.getContextPath()+"/test/app/ionic/login.jsp?action=user_info_error");
				}
				if ( operationCode.intValue() == INVALID_LICENSE.intValue() ) {					
					//response.sendRedirect(request.getContextPath()+"/mobile/login.do?action=invalid_license");
					response.sendRedirect(request.getContextPath()+"/test/app/ionic/login.jsp?action=invalid_license");
				}
			}
		} catch(Exception ex) {  }
	}
	
	/**
	 * 构建登录用户Cookie
	 * @param userName 用户帐号
	 * @param response Response 对象
	 * */
	private void createCookie(String userName, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(Const.LOGIN_USER_SESSION_NAME, userName);
			cookie.setMaxAge(COOKIE_TIMEOUT);
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 验证用户密码
	 * @param user 用户对象
	 * @param userPwd 用户密码
	 * @return 用户密码验证情况
	 * */
	private boolean validateUserPwd(User user, String userPwd) {
		try {
			if ( user != null 
					&& userPwd != null && !userPwd.trim().equals("") ) {
				if ( user.getUserPwd() != null 
						&& user.getUserPwd().trim().equals(MD5Encryption.encrypt(userPwd)) ) return true;
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
	
	/**
	 * 验证用户可用性
	 * @param user 用户对象
	 * @return 用户可用性情况
	 * */
	private boolean validateUserAvailability(User user) {
		try {
			if ( user != null ) {
				if ( NumberUtil.equals(user.getUserStatus(), User.ENABLE)  ) return true;
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
	
	/**
	 * 验证用户是否在有效使用期内
	 * @param currentUser 当前登录用户
	 * @return 用户可用性情况
	 * */
	private boolean validateVersion(CurrentUser currentUser) {
		try {
			if ( currentUser != null ) {
				if ( currentUser.getActivatedDate() != null 
						&& currentUser.getExpiredDate() != null ) {
					Date currentDate = new Date();
					if ( currentDate.getTime() >= currentUser.getActivatedDate().getTime() 
							&& currentDate.getTime() < currentUser.getExpiredDate().getTime() ) {
						return true;
					}
				} else if ( currentUser.getOrgId() == null 
						&& currentUser.getActivatedDate() == null 
						&& currentUser.getExpiredDate() == null ) {
					return true;
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
	
	/**
	 * 根据用户获取机构信息
	 * @param user 用户对象信息
	 * @return 机构信息
	 * */
	private Organization getOrgByUser(User user) {
		try {
			if ( user != null ) {
				SpringUtil springUtil = new SpringUtil();
				OrganizationService organizationService = (OrganizationService) springUtil.getBean("organizationService");
				List<Organization> orgList = organizationService.getOrganizationsByUser(user.getUserId());
				if ( orgList != null && orgList.size() > 0 ) {
					return orgList.get(0);
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	/**
	 * 保存访问日志
	 * @param request Request
	 * @param user 用户对象
	 * @param logEvent 事件描述
	 * @param logStatus 日志状态（成功或失败）
	 * */
	private void saveAccessLog(HttpServletRequest request, User user, String logEvent, Integer logStatus) {
		try {
			SpringUtil springUtil = new SpringUtil();
			AccessLogService accessLogService = (AccessLogService) springUtil.getBean("accessLogService");
			Organization org = getOrgByUser(user);
			
			AccessLog accessLog = new AccessLog();
			accessLog.setLogEvent(logEvent);
			accessLog.setEventDate(new Date());
			accessLog.setUserName(user.getUserName());
			accessLog.setUserAlias(user.getUserAlias());
			accessLog.setUserIPAddress(RequestUtil.getIpAddress(request));
			accessLog.setUserNavAppVersion(RequestUtil.getUserAgent(request));
			accessLog.setLogType(AccessLog.SYSTEM_LOGIN);
			accessLog.setLogStatus(logStatus);
			accessLog.setOrgId((org != null && org.getOrgId()!= null && !org.getOrgId().trim().equals("")) ? org.getOrgId() : null);
			accessLogService.saveAccessLog(accessLog);
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
}