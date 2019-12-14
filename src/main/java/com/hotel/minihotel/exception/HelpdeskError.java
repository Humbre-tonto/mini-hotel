package com.informatique.gov.helpdesk.exception;

import java.io.Serializable;

import com.informatique.gov.helpdesk.ShowDogVersion;

public class HelpdeskError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	private Object target;
	private Object errorArguments;

	public HelpdeskError(Object target, ShowDogExceptionEnum sakErrorEnum, Object errorArguments) {
		this.target = target;
		this.errorCode = sakErrorEnum.getCode();
		this.errorDescription = sakErrorEnum.getDescription();
		this.fixSuggestion = sakErrorEnum.getFixSuggestion();
		this.errorArguments = errorArguments;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getFixSuggestion() {
		return fixSuggestion;
	}

	public Object getTarget() {
		return target;
	}

	public Object getErrorArguments() {
		return errorArguments;
	}

}
