package org.pangolin.eeip.web.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.tagext.TagSupport;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.entity.Authority;
import org.pangolin.eeip.entity.Role;
import org.pangolin.util.StringUtil;

public class AuthorityTag extends TagSupport {
	
	private static final long serialVersionUID = -7193581791038941876L;
	
	private String username;
	private String grant;
	private Boolean disable;
	
	public int doStartTag() {
		if ( username != null && !username.trim().equals("") 
				&& grant != null && !grant.trim().equals("") ) {
			if ( disable != null && disable.booleanValue() == true ) return SKIP_BODY;
			
			List<Authority> userAuthorities = new ArrayList<Authority>(); //用户所有权限
			List<Role> roleList = Const.USER_ROLE_MAP.get(username); //根据当前帐户获取角色列表
			if ( roleList != null ) {
				Map<String, String> map = new HashMap<String, String>();
				for ( Role role : roleList ) {
					List<Authority> authList = Const.ROLE_AUTH_MAP.get(role.getRoleLabel());
					if ( authList != null ) {
						for ( Authority authority : authList ) {
							if ( !map.containsKey(authority.getAuthorityId()) ) {
								map.put(authority.getAuthorityId(), authority.getAuthorityId());
								userAuthorities.add(authority); //加入用户所在角色的权限
							}
							
						}
					}
				}
			}
			
			List<String> authLabelList = StringUtil.separate2List(grant, "|"); //权限标识允许多个
			for (String authLabel : authLabelList) {
				for ( Authority authority : userAuthorities ) {
					if ( authority.getAuthorityLabel().trim().equals(authLabel.trim()) ) return EVAL_BODY_INCLUDE;
				}
			}
		}
		return SKIP_BODY;
	}

	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGrant() {
		return grant;
	}

	public void setGrant(String grant) {
		this.grant = grant;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
}