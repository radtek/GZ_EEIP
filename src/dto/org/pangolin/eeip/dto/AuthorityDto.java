package org.pangolin.eeip.dto;

import java.io.Serializable;

import org.pangolin.eeip.entity.Authority;

public class AuthorityDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 20867077522808667L;
	
	public static final Boolean CHECKED = true;
	public static final Boolean UNCHECKED = false;
	
	private String authorityId;
	private String authorityName;
	private String parentAuthorityLabel;
	private Boolean checked = AuthorityDto.CHECKED;

	public static AuthorityDto convertToAuthorityDto(Authority authority, Boolean checked) {
		AuthorityDto authDto = new AuthorityDto();
		authDto.setAuthorityId(authority.getAuthorityId());
		authDto.setAuthorityName(authority.getAuthorityName());
		authDto.setParentAuthorityLabel(authority.getParentAuthorityLabel());
		authDto.setChecked(checked);
		return authDto;
	}
	
	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}
	
	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getParentAuthorityLabel() {
		return parentAuthorityLabel;
	}

	public void setParentAuthorityLabel(String parentAuthorityLabel) {
		this.parentAuthorityLabel = parentAuthorityLabel;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}