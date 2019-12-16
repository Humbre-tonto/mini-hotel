package com.hotel.minihotel.support.security;
//
import org.springframework.security.core.GrantedAuthority;

import com.hotel.minihotel.support.dataenum.UserRoleEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(of = {"role"})
@EqualsAndHashCode(of = {"role"}, callSuper = false)

@AllArgsConstructor
public class HotelGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1;
	private final String role;

	
	public HotelGrantedAuthority(UserRoleEnum userRoleEnum) {
		this.role = userRoleEnum.getCode();
	}

	@Override
	public String getAuthority() {
		return role;
	}
}
