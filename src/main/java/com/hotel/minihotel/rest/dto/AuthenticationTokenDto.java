package com.hotel.minihotel.rest.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationTokenDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	@Getter
	private final String value;
	@Getter
	private final Integer maxInactiveInterval;

}
