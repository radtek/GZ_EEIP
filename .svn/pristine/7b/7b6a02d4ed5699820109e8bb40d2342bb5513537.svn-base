package org.pangolin.eeip.web.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.common.CurrentUser;
import org.pangolin.eeip.webservice.client.WorkflowWebServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
	
	@Autowired
	protected  HttpServletRequest request;
	
	/**
	 * Service of workflow engine
	 * @author Oscar Mok
	 * */
	protected WorkflowWebServiceClient workflow = new WorkflowWebServiceClient();
	
	/**
	 * Returns the current request.
	 * @author Oscar Mok
	 * */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * Returns the current session associated with current request.
	 * @author Oscar Mok
	 * */
	public HttpSession getSession() {
		if ( request != null ) return request.getSession();
		return null;
	}
	
	/**
	 *  Binds an object to this session, using the name specified.
	 *  @author Oscar Mok
	 *  @param key Name of session
	 *  @param value Value of session
	 * */
	public void setSession(String key, String value) {
		getSession().setAttribute(key, value);
	}
	
	/**
	 * Getting information of current user
	 * @author Oscar Mok
	 * @return information of current user
	 * */
	public CurrentUser getCurrentUser() {
		try {
			CurrentUser currentUser = (CurrentUser) getSession().getAttribute(Const.LOGIN_USER_SESSION_NAME);
			if ( currentUser != null ) return currentUser;
		} catch(Exception ex) { ex.printStackTrace(); }
		return null;
	}
	
	/**
	 * Getting role label of current user
	 * @author Oscar Mok
	 * @return role label of current user
	 * */
	public String getRoleLabelByCurrentUser() {
		CurrentUser currentUser = getCurrentUser();
		if ( currentUser != null ) {
			Set<String> keys = currentUser.getRoles().keySet();
			for ( String roleLabel : keys ) {
				return roleLabel;
			}
		}
		return "";
	}
	
	/**
	 * Getting org id of current user
	 * @author Oscar Mok
	 * @return org id of current user
	 * */
	public String getOrgIdByCurrentUser() {
		CurrentUser currentUser = getCurrentUser();
		if ( currentUser != null ) {
			return currentUser.getOrgId();
		}
		return "";
	}
	
	/**
	 * Getting org sn of current user
	 * @author Oscar Mok
	 * @return org sn of current user
	 * */
	public String getOrgSNByCurrentUser() {
		CurrentUser currentUser = getCurrentUser();
		if ( currentUser != null ) {
			return currentUser.getOrgSN();
		}
		return "";
	}
}