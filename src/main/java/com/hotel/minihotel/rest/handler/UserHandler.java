package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.UserDto;

public interface UserHandler extends Serializable {

	// ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws
	// ShowDogException;
	ResponseEntity<List<?>> getAll() throws ShowDogException;

	ResponseEntity<?> register(UserDto user) throws ShowDogException;

	ResponseEntity<?> getById(Integer id) throws ShowDogException;

	ResponseEntity<?> updateById(Integer id, UserDto updatedUser) throws ShowDogException;;
}
