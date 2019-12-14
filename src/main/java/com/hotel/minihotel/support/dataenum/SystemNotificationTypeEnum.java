package com.informatique.gov.helpdesk.support.dataenum;

import com.informatique.gov.helpdesk.domain.SystemNotificationType;

import lombok.Getter;

public enum SystemNotificationTypeEnum {
	URGENT("URGENT");
	
	@Getter
	private String code;
	private SystemNotificationTypeEnum (String code) {
		this.code = code;
	}
	
	public SystemNotificationType getEntity() {
		return new SystemNotificationType(code);
	}
}
