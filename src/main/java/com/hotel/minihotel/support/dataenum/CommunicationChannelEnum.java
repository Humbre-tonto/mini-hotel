package com.informatique.gov.helpdesk.support.dataenum;

import com.informatique.gov.helpdesk.domain.CommunicationChannel;

import lombok.Getter;

public enum CommunicationChannelEnum {
	SYSTEM("SYSTEM"), SMS("SMS"), PHONE("PHONE"), EMAIL("EMAIL");
	@Getter
	private String code;

	private CommunicationChannelEnum(String code) {
		this.code = code;
	}

	public CommunicationChannel getEntity() {
		return new CommunicationChannel(this.code);
	}
}
