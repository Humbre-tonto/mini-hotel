package com.informatique.gov.helpdesk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.informatique.gov.helpdesk.ShowDogVersion;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedOperationException extends ShowDogException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	
	public UnsupportedOperationException(String operation) {
		super(ShowDogExceptionEnum.UNSUPPORTED_OPERATION_EXCEPTION, operation);
	}
	
}
