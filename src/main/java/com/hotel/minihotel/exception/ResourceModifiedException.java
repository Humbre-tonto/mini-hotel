package com.informatique.gov.helpdesk.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.informatique.gov.helpdesk.ShowDogVersion;

import lombok.Getter;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ResourceModifiedException extends ShowDogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Getter
	private final Serializable id;
	@Getter
	private final Short targetVersion;
	@Getter
	private final Short currentVersion;

	public ResourceModifiedException(Serializable id, Short targetVersion, Short currentVersion) {
		super(ShowDogExceptionEnum.RESOURCE_MODIFIED_EXCEPTION);
		this.currentVersion = currentVersion;
		this.id = id;
		this.targetVersion = targetVersion;
	}

}
