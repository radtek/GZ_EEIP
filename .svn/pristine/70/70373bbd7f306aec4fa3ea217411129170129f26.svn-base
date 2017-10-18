package org.pangolin.eeip.security;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.entity.AccessLog;
import org.pangolin.eeip.service.AccessLogService;
import org.pangolin.eeip.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class SignOutServlet extends HttpServlet {
	
	private static final Logger log = LoggerFactory.getLogger(SignOutServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.signOut(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.signOut(request, response);
	}
	
	private void signOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			saveAccessLog(request, "System logout successful", AccessLog.SUCCESS);
			HttpSession session = request.getSession();
			session.invalidate();
			destroyCookie(request, response);
			
			if ( isMobileDevice(request) ) {
				//response.sendRedirect(request.getContextPath()+"/mobile/login.do");
				response.sendRedirect(request.getContextPath()+"/test/app/ionic/login.jsp");
			} else {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		} catch(Exception ex) { saveAccessLog(request, "System logout failed", AccessLog.FAILURE); log.error(ex.getMessage()); }
	}
	
	/**
	 * 保存访问日志
	 * @param request Request
	 * @param logEvent 事件描述
	 * @param logStatus 日志状态（成功或失败）
	 * */
	private void saveAccessLog(HttpServletRequest request, String logEvent, Integer logStatus) {
		try {
			HttpSession session = request.getSession();
			CurrentUser currentUser = (CurrentUser) session.getAttribute(Const.LOGIN_USER_SESSION_NAME);
			if ( currentUser != null ) {
				SpringUtil springUtil = new SpringUtil();
				AccessLogService accessLogService = (AccessLogService) springUtil.getBean("accessLogService");
				AccessLog accessLog = new AccessLog();
				accessLog.setLogEvent(logEvent);
				accessLog.setEventDate(new Date());
				accessLog.setUserName(currentUser.getUserName());
				accessLog.setUserAlias(currentUser.getUserAlias());
				accessLog.setUserIPAddress(getIpAddress(request));
				accessLog.setUserNavAppVersion("Chrome");
				accessLog.setLogType(AccessLog.SYSTEM_LOGIN);
				accessLog.setLogStatus(logStatus);
				accessLog.setOrgId(currentUser.getOrgId());
				accessLogService.saveAccessLog(accessLog);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	private String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");      
        if( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) ) {
        	ip = request.getHeader("Proxy-Client-IP");
        }
        if( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) ) {
        	ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) ) {
        	ip = request.getRemoteAddr();
        }
        return ip;
    }
	
	/**
	 * 销毁Cookie
	 * @param request Request 对象
	 * @param response Response 对象
	 * */
	private void destroyCookie(HttpServletRequest request, HttpServletResponse response) {
		try {
			Cookie[] cookies = request.getCookies();
			if ( cookies != null ) {
				for ( Cookie cookie : cookies ) {
					if ( cookie.getName().trim().equals(Const.LOGIN_USER_SESSION_NAME) ) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	/**
	 * 是否为移动设备
	 * @author Oscar Mok
	 * @param 
	 * */
	private boolean isMobileDevice(HttpServletRequest request) {
		try {
			String userAgent = request.getHeader( "USER-AGENT" ).toLowerCase();
			if ( userAgent != null && !userAgent.trim().equals("") ) {
				String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"  
				        +"|windows (phone|ce)|blackberry"  
				        +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"  
				        +"|laystation portable)|nokia|fennec|htc[-_]"  
				        +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";  
				String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"  
				        +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";  
				Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);  
				Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);
				
			    Matcher matcherPhone = phonePat.matcher(userAgent);  
			    Matcher matcherTable = tablePat.matcher(userAgent);  
			    if ( matcherPhone.find() || matcherTable.find() ) return true;
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return false;
	}
}