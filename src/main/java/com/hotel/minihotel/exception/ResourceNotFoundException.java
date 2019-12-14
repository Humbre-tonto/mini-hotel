package com.informatique.gov.helpdesk.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.informatique.gov.helpdesk.ShowDogVersion;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ShowDogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	public ResourceNotFoundException(String type, Serializable id) {
		super(ShowDogExceptionEnum.RESOURCE_NOT_FOUND_EXCEPTION, type, id);
	}

}
