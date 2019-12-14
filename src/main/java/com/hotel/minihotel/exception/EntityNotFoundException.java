package com.informatique.gov.helpdesk.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.informatique.gov.helpdesk.ShowDogVersion;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EntityNotFoundException extends HelpdeskInternalException{

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	
	
	
	public EntityNotFoundException(String type, Serializable id) {
		super(ShowDogExceptionEnum.ENTITY_NOT_FOUND_EXCEPTION, type, id);
	}
	
	public EntityNotFoundException(String ticketSerial, String type, Serializable id) {
		super(ShowDogExceptionEnum.ENTITY_NOT_FOUND_EXCEPTION, type, id);
		this.ticketSerial = ticketSerial;
	}
}
