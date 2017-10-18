package org.pangolin.eeip.webservice.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;

public class BaseWebServiceClient {

	/**
	 * Web Service Timeout
	 * */
	protected static long WS_TIMEOUT = 6000;
	
	protected HttpServletRequest request;
	
	/**
	 * Get Current User Information
	 * @return CurrentUser
	 * */
	protected CurrentUser getCurrentUser() {
		if ( request != null ) {
			HttpSession session = request.getSession();
			if ( session.getAttribute(Const.LOGIN_USER_SESSION_NAME) != null ) {
				CurrentUser currentUser = (CurrentUser)session.getAttribute(Const.LOGIN_USER_SESSION_NAME);
				return currentUser;
			}
		}
		return null;
	}
	
	/**
	 * Get Web Service URL
	 * @param wsName Web Service Name
	 * @return Web Service URL
	 * */
	protected String getWebServiceURL(String wsName) {
		if ( wsName != null && !wsName.trim().equals("") ) {
			return Const.WS_URL_MAP.get(wsName);
		}
		return null;
	}
}