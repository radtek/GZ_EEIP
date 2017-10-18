package org.pangolin.eeip.web.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.tagext.TagSupport;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.entity.Role;
import org.pangolin.util.StringUtil;

public class RoleAuthorityTag extends TagSupport {
	
	private static final long serialVersionUID = 8618927810407150321L;

	/**
	 * Account of user
	 * */
	private String username;
	
	/**
	 * Labels of role
	 * Example: role = "roleA" or role = "roleA|roleB"
	 * */
	private String role;
	
	/**
	 * Tag is disabled or not
	 * */
	private Boolean disable;
	
	public int doStartTag() {
		if ( username != null && !username.trim().equals("") 
				&& role != null && !role.trim().equals("") ) {
			if ( disable != null && disable.booleanValue() == true ) return SKIP_BODY;
			
			List<String> roleLabels = new ArrayList<String>();
			List<Role> roleList = Const.USER_ROLE_MAP.get(username);
			if ( roleList != null ) {
				for ( Role role : roleList ) {
					roleLabels.add(role.getRoleLabel());
				}
			}
			
			Map<String, String> authorisedRoleMap = getAuthorizedRoleLabel();
			for (String roleLabel : roleLabels) {
				if (authorisedRoleMap.containsKey(roleLabel)) return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}
	
	/**
	 * Getting authorized labels of role
	 * @author Oscar Mok
	 * @return Map of authorized role label
	 * */
	private Map<String, String> getAuthorizedRoleLabel() {
		 Map<String, String> roleMap = new HashMap<String, String>();
		 List<String> roleLabelList = StringUtil.separate2List(role, "|");
		 for (String roleLabel : roleLabelList) {
			 roleMap.put(roleLabel, roleLabel);
		 }
		 return roleMap;
	}

	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
}