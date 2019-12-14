package com.informatique.gov.helpdesk.support.dataenum;

import lombok.Getter;

public enum UserRoleEnum {
	EMPLOYEE("EMPLOYEE"), HELPDESK_AGENT("HELPDESK_AGENT"), SECTION_HEAD("SECTION_HEAD"), DEPARTMENT_HEAD("DEPARTMENT_HEAD");
	@Getter
	private String code;
	
	private UserRoleEnum (String code) {
		this.code = code;
	}
}
