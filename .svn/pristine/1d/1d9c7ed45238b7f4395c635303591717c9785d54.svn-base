package org.pangolin.eeip.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.pangolin.eeip.entity.AuthorityType;

public class AuthorityRootTypeDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 778948216855348545L;
	
	private String typeId;
	private String typeName;
	private Integer subTypeQty = new Integer(0);
	private List<AuthorityTypeDto> subTypies = new ArrayList<AuthorityTypeDto>();

	/**
	 * 权限类型（顶层）对象转换至权限类型（顶层）传输对象
	 * @author Oscar Mok
	 * @param authorityType 权限类型（顶层）对象
	 * @return 权限类型（顶层）传输对象
	 * */
	public static AuthorityRootTypeDto convertToAuthorityTypeDto(AuthorityType authorityType) {
		AuthorityRootTypeDto authRootTypeDto = new AuthorityRootTypeDto();
		authRootTypeDto.setTypeId(authorityType.getAuthorityTypeId());
		authRootTypeDto.setTypeName(authorityType.getAuthorityTypeName());
		return authRootTypeDto;
	}
	
	//getters and setters
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

	public Integer getSubTypeQty() {
		return subTypeQty;
	}

	public void setSubTypeQty(Integer subTypeQty) {
		this.subTypeQty = subTypeQty;
	}

	public List<AuthorityTypeDto> getSubTypies() {
		return subTypies;
	}

	public void setSubTypies(List<AuthorityTypeDto> subTypies) {
		this.subTypies = subTypies;
	}
	
}