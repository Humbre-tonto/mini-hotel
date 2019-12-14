package com.informatique.gov.helpdesk.support.security;
//
import org.springframework.security.core.GrantedAuthority;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.support.dataenum.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(of = {"role"})
@EqualsAndHashCode(of = {"role"}, callSuper = false)

@AllArgsConstructor
public class HelpdeskGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private final String role;

	
	public HelpdeskGrantedAuthority(UserRoleEnum userRoleEnum) {
		this.role = userRoleEnum.getCode();
	}

	@Override
	public String getAuthority() {
		return role;
	}
}
