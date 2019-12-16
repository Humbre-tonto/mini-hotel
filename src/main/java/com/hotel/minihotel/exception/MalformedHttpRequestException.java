package com.hotel.minihotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedHttpRequestException extends HotelException {

	/**
	 * 
	 */
	private static final long serialVersionUID =1;

	public MalformedHttpRequestException(String details) {
		super(HotelExceptionEnum.MAL_FORMED_HTTP_REQUEST_EXCEPTION, details);
	}
}
