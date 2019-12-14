package com.informatique.gov.helpdesk.support.dataenum;

import lombok.Getter;

public enum TicketStatusEnum {
	
	OPEN("OPEN"),
	CLOSED("CLOSED");
	
	
	
	@Getter
    private String code;

	
	private TicketStatusEnum(String code) {
		this.code = code;
	}
	
	
	public static TicketStatusEnum getByCode(String code) {
		for(TicketStatusEnum statusEnum : TicketStatusEnum.values()) {
			if(statusEnum.code.equals(code)) {
				return statusEnum;
			}
		}
		return null;
	}
	
	
}
