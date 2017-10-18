package org.pangolin.eeip.sms;

public class SMSParam {
	
	private static final String NO_PASSWORD = "sms-no-pwd";
	
	private String url;
	private String account;
	private String password;
	private String noPassword;
	
	/**
	 * Setting parameters of sms
	 * @author Oscar Mok
	 * @param url URL
	 * @param account Account
	 * @param password Password
	 * */
	public SMSParam(String url, String account, String password) {
		this.url = url;
		this.account = account;
		
		if ( password == null || ( password != null && password.trim().equals("") ) ) {
			this.noPassword = NO_PASSWORD;
		} else {
			this.password = password;
		}
	}
	
	//getters and setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNoPassword() {
		return noPassword;
	}

	public void setNoPassword(String noPassword) {
		this.noPassword = noPassword;
	}
}