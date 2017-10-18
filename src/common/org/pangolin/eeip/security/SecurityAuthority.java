package org.pangolin.eeip.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;

public class SecurityAuthority {
	
	private CurrentUser currentUser = null;
	
	public SecurityAuthority(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if ( session.getAttribute(Const.LOGIN_USER_SESSION_NAME) != null ) {
			currentUser = (CurrentUser)session.getAttribute(Const.LOGIN_USER_SESSION_NAME);
		}
	}
	
	public boolean isPermitted(String authorityLabel) {
		if ( authorityLabel != null && !authorityLabel.trim().equals("") ) {
			if ( currentUser != null ) {
				Map<String, String> authMap = currentUser.getAuthorities();
				if ( authMap.containsKey(authorityLabel) ) {
					return true;
				}
			}
		}
		return false;
	}
}