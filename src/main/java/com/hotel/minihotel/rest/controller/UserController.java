package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.UserDto;
import com.informatique.gov.helpdesk.rest.handler.UserHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private UserHandler userHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws ShowDogException {
		return userHandler.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) throws ShowDogException {
		return userHandler.getById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Integer id,@RequestBody UserDto updatedUser) throws ShowDogException {
		return userHandler.updateById(id,updatedUser);
	}
	
	@PostMapping
	public ResponseEntity<?>register(@RequestBody UserDto user)throws ShowDogException{
		return userHandler.register(user);
	}
}
