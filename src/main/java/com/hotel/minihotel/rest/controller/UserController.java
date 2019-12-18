package com.hotel.minihotel.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.UserDto;
import com.hotel.minihotel.rest.handler.UserHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private UserHandler userHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws HotelException {
		return userHandler.getAll();
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam String id,@RequestParam String password) throws HotelException {
		return userHandler.getByUsernameAndPassword(id,password);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) throws HotelException {
		return userHandler.getById(id);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) throws HotelException {
		return userHandler.deleteById(id);
	}
	
	@PostMapping("/createCustomer")
	public ResponseEntity<?>registerCustomer(@RequestBody UserDto user)throws HotelException{
		return userHandler.register(user);
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<?>registerEmployee(@RequestBody UserDto user)throws HotelException{
		return userHandler.register(user);
	}
}
