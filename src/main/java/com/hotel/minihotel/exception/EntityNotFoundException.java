package com.hotel.minihotel.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EntityNotFoundException extends HotelInternalException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	
	
	public EntityNotFoundException(String type, Serializable id) {
		super(HotelExceptionEnum.ENTITY_NOT_FOUND_EXCEPTION, type, id);
	}
	
	public EntityNotFoundException(String ticketSerial, String type, Serializable id) {
		super(HotelExceptionEnum.ENTITY_NOT_FOUND_EXCEPTION, type, id);
		this.ticketSerial = ticketSerial;
	}
}
