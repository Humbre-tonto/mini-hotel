package com.hotel.minihotel.support.dataenum;

import lombok.Getter;

public enum UserRoleEnum {
	EMPLOYEE("EMPLOYEE"), ADMIN("ADMIN"), CUSTOMER("CUSTOMER");
	@Getter
	private String code;
	
	private UserRoleEnum (String code) {
		this.code = code;
	}
}
