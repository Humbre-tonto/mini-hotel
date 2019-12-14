package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetDto;


public interface PetHandler extends Serializable{

	//ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws ShowDogException;
	ResponseEntity<List<?>> getAll() throws ShowDogException;

	ResponseEntity<?> addPet(PetDto petDto) throws ShowDogException;

	ResponseEntity<List<?>> getAllByBreed(Integer breedId) throws ShowDogException;
}
