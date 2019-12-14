package com.informatique.gov.helpdesk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.informatique.gov.helpdesk.ShowDogVersion;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedHttpRequestException extends ShowDogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	public MalformedHttpRequestException(String details) {
		super(ShowDogExceptionEnum.MAL_FORMED_HTTP_REQUEST_EXCEPTION, details);
	}
}
