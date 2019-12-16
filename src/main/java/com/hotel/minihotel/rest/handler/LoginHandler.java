package com.hotel.minihotel.rest.handler;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.UserDetailsDto;


public interface LoginHandler extends Serializable{

	ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws HotelException;

}
