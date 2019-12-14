package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface PetBreedHandler extends Serializable {

	// ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws
	// ShowDogException;
	ResponseEntity<List<?>> getAll() throws ShowDogException;

	ResponseEntity<List<?>> getByPetType(Integer petTypeId) throws ShowDogException;
}
