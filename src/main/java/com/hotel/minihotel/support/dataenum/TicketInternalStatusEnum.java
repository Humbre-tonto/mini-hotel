package com.informatique.gov.helpdesk.support.dataenum;

import lombok.Getter;

public enum TicketInternalStatusEnum {
	
	
	OPEN("OPEN", TicketStatusEnum.OPEN),
	CLOSED("CLOSED", TicketStatusEnum.CLOSED);
	
	
	
	
	
	@Getter
    private String code;
	
	@Getter
	private TicketStatusEnum ticketStatusEnum;

	
	private TicketInternalStatusEnum(String code, TicketStatusEnum currentStatusEnum) {
		this.code = code;
		this.ticketStatusEnum = currentStatusEnum;
	}
	
	
	public static TicketInternalStatusEnum getByCode(String code) {
		for(TicketInternalStatusEnum internalStatusEnum : TicketInternalStatusEnum.values()) {
			if(internalStatusEnum.code.equals(code)) {
				return internalStatusEnum;
			}
		}
		return null;
	}
	
	
	
}
