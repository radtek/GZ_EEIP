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

public class AdvancedAuthorityTag extends TagSupport {
	
	private static final long serialVersionUID = 5676740791828684919L;

	/**
	 * 或条件
	 * */
	private static final String OR = "OR";
	
	/**
	 * 与条件
	 * */
	private static final String AND = "AND";
	
	private String username;
	private String grants;
	private String condition;
	private Boolean disable;
	
	public int doStartTag() {
		if ( username != null && !username.trim().equals("") 
				&& grants != null && !grants.trim().equals("") 
				&& condition != null && !condition.trim().equals("") ) {
			if ( disable != null && disable.booleanValue() == true ) return SKIP_BODY;
			
			List<String> grantList = StringUtil.separate2List(grants, ",");
			
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
			
			if ( condition.trim().equals(OR) ) {
				for ( String grant : grantList ) {
					for ( Authority authority : userAuthorities ) {
						if ( authority.getAuthorityLabel().trim().equals(grant.trim()) ) return EVAL_BODY_INCLUDE;
					}
				}
			} else if ( condition.trim().equals(AND) ) {
				int grantQty = grantList.size();
				int count = 0;
				for ( String grant : grantList ) {
					for ( Authority authority : userAuthorities ) {
						if ( authority.getAuthorityLabel().trim().equals(grant.trim()) ) count ++;
					}
				}
				if ( grantQty == count ) return EVAL_BODY_INCLUDE;
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

	public String getGrants() {
		return grants;
	}

	public void setGrants(String grants) {
		this.grants = grants;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
}