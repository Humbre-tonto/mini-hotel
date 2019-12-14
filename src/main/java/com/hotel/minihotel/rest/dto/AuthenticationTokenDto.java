package com.informatique.gov.helpdesk.rest.dto;

import java.io.Serializable;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationTokenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	@Getter
	private final String value;
	@Getter
	private final Integer maxInactiveInterval;

}
