package org.pangolin.eeip.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.entity.User;
import org.pangolin.eeip.service.UserService;
import org.pangolin.eeip.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录信息过滤器
 * @author Oscar Mok
 */
@SuppressWarnings("all")
public class SignInFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(SignInFilter.class);
	
	public void destroy() {  }

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
		try {
			HttpServletRequest request = (HttpServletRequest) arg0;
			HttpServletResponse response = (HttpServletResponse) arg1;
			HttpSession session = request.getSession();
			
			if ( session.getAttribute(Const.LOGIN_USER_SESSION_NAME) == null ) {
				String userName = getCookie(request);
				if ( userName != null && !userName.trim().equals("") ) {
					autoSignIn(userName, session);
				}
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			} else {
				filterChain.doFilter(arg0, arg1);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
	
	public void init(FilterConfig config) throws ServletException {
		
	}
	
	/**
	 * 从Cookie获取登录用户帐号
	 * @param request Request 对象
	 * @return 登录用户帐号
	 * */
	private String getCookie(HttpServletRequest request) {
		try {
			Cookie[] cookies = request.getCookies();
			if ( cookies != null ) {
				for ( Cookie cookie : cookies ) {
					if ( cookie.getName().trim().equals(Const.LOGIN_USER_SESSION_NAME) ) {
						return cookie.getValue();
					}
				}
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
		return null;
	}
	
	/**
	 * 根据Cookie登录用户信息进行自动登录系统
	 * @param userName 登录用户帐号
	 * @param session Session 对象
	 * @return 登录用户帐号
	 * */
	private void autoSignIn(String userName, HttpSession session) {
		try {
			SpringUtil springUtil = new SpringUtil();
			UserService userService = (UserService) springUtil.getBean("userService");
			User user = userService.getUserByName(userName);
			if ( user != null ) {
				CurrentUser currentUser = userService.getCurrentUser(user);
				session.setAttribute(Const.LOGIN_USER_SESSION_NAME, currentUser);
			}
		} catch(Exception ex) { log.error(ex.getMessage()); }
	}
}