package com.informatique.gov.helpdesk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.informatique.gov.helpdesk.ShowDogVersion;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenOperationException extends ShowDogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	public ForbiddenOperationException(String operation) {
		super(ShowDogExceptionEnum.FORBIDDEN_OPERATION_EXCEPTION, operation);
	}
}
