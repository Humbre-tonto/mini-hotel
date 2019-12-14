package com.informatique.gov.helpdesk.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class ResourceNotModifiedException extends ShowDogException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6849614432000571777L;

	@Getter
	private final int currentVersion;
	public ResourceNotModifiedException(Serializable id, int currentVersion) {
		super(ShowDogExceptionEnum.RESOURCE_NOT_MODIFIED_EXCEPTION);
		this.currentVersion = currentVersion;
	}

}
