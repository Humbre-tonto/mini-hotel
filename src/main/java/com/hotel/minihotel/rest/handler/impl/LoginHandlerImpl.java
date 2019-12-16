package com.hotel.minihotel.rest.handler.impl;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.rest.dto.UserDetailsDto;
import com.hotel.minihotel.rest.handler.LoginHandler;
import com.hotel.minihotel.service.InternalSecurityService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LoginHandlerImpl implements LoginHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;
	
	private InternalSecurityService securityService;
	
	@Override
	public ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws HotelException {
		
		ResponseEntity<UserDetailsDto> response = null;
		
		try {
			UserDetailsDto userDetailsDto = securityService.getUserDetails(session);
			response = ResponseEntity.ok(userDetailsDto);
		}catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return response;		
	}

}
