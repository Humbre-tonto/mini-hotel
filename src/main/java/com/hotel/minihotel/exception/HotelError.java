package com.hotel.minihotel.exception;

import java.io.Serializable;

public class HotelError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	private Object target;
	private Object errorArguments;

	public HotelError(Object target, HotelExceptionEnum sakErrorEnum, Object errorArguments) {
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
