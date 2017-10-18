package org.pangolin.eeip.web.tag;

import java.util.List;

import javax.servlet.jsp.tagext.TagSupport;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.entity.Role;

/**
 * 系统超级管理员专用标签
 * 用途：限制某些功能模块并只开放给系统超级管理员使用
 * @author Oscar Mok
 * */
public class SupervisorTag extends TagSupport {
	
	private static final long serialVersionUID = 7801552216853218159L;
	
	private String username;
	private Boolean disable;
	
	public int doStartTag() {
		if ( username != null && !username.trim().equals("") ) {
			if ( disable != null && disable.booleanValue() == true ) return SKIP_BODY;
			
			List<Role> roleList = Const.USER_ROLE_MAP.get(username); //根据当前帐户获取角色列表
			if ( roleList != null ) {
				for ( Role role : roleList ) {
					if ( role.getRoleLabel() != null 
							&& role.getRoleLabel().trim().equals(Const.ADMINISTRATOR_ROLE) ) {
						return EVAL_BODY_INCLUDE;
					}
				}
			}
		}
		return SKIP_BODY;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}	
}