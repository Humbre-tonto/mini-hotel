package com.hotel.minihotel.rest.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.handler.LoginHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;	
	private LoginHandler loginHandler;
	
	@GetMapping
	public ResponseEntity<?> login(HttpSession session) throws HotelException {
		return loginHandler.getUserDetails(session);
	}
}
