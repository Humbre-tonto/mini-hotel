package com.hotel.minihotel.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotel.minihotel.exception.HotelException;

public interface RoomHandler extends Serializable {

	ResponseEntity<List<?>> getAll() throws HotelException;

	
	ResponseEntity<?> getById(Integer id) throws HotelException;

	
}
