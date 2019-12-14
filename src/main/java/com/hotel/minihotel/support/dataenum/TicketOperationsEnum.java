package com.informatique.gov.helpdesk.support.dataenum;

import lombok.Getter;

public enum TicketOperationsEnum {
	RELEASEMENT("RELEASMENT"), CLOSURE("CLOSURE"), DEPRECATE("DEPRECATE"), ASSIGN("ASSIGN"), ASSIGNTOSELF(
			"ASSIGNTOSELF"), RELEASEFROMSELF("RELEASEFROMSELF"), PROCESSSTART("PROCESSSTART");
	@Getter
	private String code;

	private TicketOperationsEnum(String code) {
		this.code = code;
	}
}
