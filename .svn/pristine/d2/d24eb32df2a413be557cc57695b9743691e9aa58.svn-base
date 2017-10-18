package org.pangolin.eeip.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.pangolin.eeip.entity.AuthorityType;

public class AuthorityTypeDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 7524922436026251227L;
	
	private String typeId;
	private String typeName;
	private List<AuthorityDto> authorities = new ArrayList<AuthorityDto>();

	/**
	 * 权限类型对象转换至权限类型传输对象
	 * @author Oscar Mok
	 * @param authorityType 权限类型对象
	 * @return 权限类型传输对象
	 * */
	public static AuthorityTypeDto convertToAuthorityTypeDto(AuthorityType authorityType) {
		AuthorityTypeDto authTypeDto = new AuthorityTypeDto();
		authTypeDto.setTypeId(authorityType.getAuthorityTypeId());
		authTypeDto.setTypeName(authorityType.getAuthorityTypeName());
		return authTypeDto;
	}
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<AuthorityDto> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityDto> authorities) {
		this.authorities = authorities;
	}
}
