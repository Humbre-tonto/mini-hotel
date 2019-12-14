package com.informatique.gov.helpdesk.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
public class PreConditionRequiredException extends ShowDogException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6610574449409519179L;

	@Getter
	private final Serializable id;
	public PreConditionRequiredException(Serializable id) {
		super(ShowDogExceptionEnum.PRE_CONDITION_REQUIRED);
		this.id = id;
	}

}
