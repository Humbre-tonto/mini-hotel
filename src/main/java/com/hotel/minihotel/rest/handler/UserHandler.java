package com.hotel.minihotel.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.UserDto;

public interface UserHandler extends Serializable {

	// ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws
	// HotelException;
	ResponseEntity<List<?>> getAll() throws HotelException;

	ResponseEntity<?> register(UserDto user) throws HotelException;

	ResponseEntity<?> getById(Integer id) throws HotelException;

	ResponseEntity<?> updateById(Integer id, UserDto updatedUser) throws HotelException;;
}
