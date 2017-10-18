package org.pangolin.eeip.common;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 当前登录用户
 * @author Oscar Mok
 * */
@SuppressWarnings("all")
public class CurrentUser implements Serializable {
	
	private static final long serialVersionUID = -2268851158483985769L;
	
	private String userId;
	private String userName;
	private String userAlias;
	private Integer userType;
	private Integer userSex;
	private String userIdCard;
	private String policeId;
	private String userEmail;
	private String userTelephone;
	private String userCellphone;
	private String orgId;
	private String orgName;
	private String orgSN;
	private String ipAddr;
	private String country;
	private Date activatedDate;
	private Date expiredDate;
	private String lang = Const.DEFAULT_LANGUAGE;
	private Map<String, String> verModules = new HashMap<String, String>();
	private Map<String, String> roles = new HashMap<String, String>();
	private Map<String, String> authorities = new HashMap<String, String>();
	private Map<String, String> resources = new HashMap<String, String>();

	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String outputObjPropertyString(Object obj) {
		StringBuffer sb = new StringBuffer();
		if (null != obj) {
			try {
				this.getPropertyString(obj, sb);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}

	public String getPropertyString(Object entityName, StringBuffer sb) {
		try {
			Class clazz = entityName.getClass();
			Field field[] = clazz.getDeclaredFields();
			Object obj = null;
			Object tempObj = null;
			sb.append("------ " + " begin ------\n");
			for (Field f : field) {
				if ( !f.getName().trim().equals("serialVersionUID") ) {
					sb.append(f.getName());
					sb.append(" : ");
					obj = invokeMethod(entityName, f.getName(), f.getType(), null);
					if (null != obj) {
						if (obj.getClass().isArray()) {
							for (int i = 0; i < Array.getLength(obj); i++) {
								tempObj = Array.get(obj, i);
								if (tempObj.getClass().isPrimitive()) {
									sb.append(tempObj.toString());
								} else if (tempObj instanceof String) {
									sb.append(tempObj.toString());
								} else if (tempObj instanceof Date) {
									sb.append(tempObj.toString());
								} else if (tempObj instanceof Number) {
									sb.append(tempObj.toString());
								} else {
									this.getPropertyString(tempObj, sb);
								}
							}
						}
					}
					sb.append(obj);
					sb.append("\n");
				}
			}
			sb.append("------ " + " end ------\n");
		} catch(Exception ex) { ex.printStackTrace(); }
		return sb.toString();
	}

	public Object invokeMethod(Object owner, String methodName, Class fieldType, Object[] args) {
		try {
			Method method = null;
			Class ownerClass = owner.getClass();
			methodName = methodName.substring(0, 1).toUpperCase() 
					+ methodName.substring(1);
			try {
				if (fieldType == boolean.class) {
					method = ownerClass.getMethod("is" + methodName);
				} else {
					method = ownerClass.getMethod("get" + methodName);
				}
			} catch (SecurityException ex) {
				ex.printStackTrace();
			} catch (NoSuchMethodException ex) {
				ex.printStackTrace();
				return " can't find 'get" + methodName + "' method";
			}
			return method.invoke(owner);
		} catch(Exception ex) { ex.printStackTrace(); }
		return null;
	}
	
	//getters and setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserCellphone() {
		return userCellphone;
	}

	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgSN() {
		return orgSN;
	}

	public void setOrgSN(String orgSN) {
		this.orgSN = orgSN;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Date getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Map<String, String> getVerModules() {
		return verModules;
	}

	public void setVerModules(Map<String, String> verModules) {
		this.verModules = verModules;
	}

	public Map<String, String> getRoles() {
		return roles;
	}

	public void setRoles(Map<String, String> roles) {
		this.roles = roles;
	}

	public Map<String, String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Map<String, String> authorities) {
		this.authorities = authorities;
	}

	public Map<String, String> getResources() {
		return resources;
	}

	public void setResources(Map<String, String> resources) {
		this.resources = resources;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}