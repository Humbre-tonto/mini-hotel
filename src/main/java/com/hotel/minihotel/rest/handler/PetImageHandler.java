package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.informatique.gov.helpdesk.exception.ShowDogException;


public interface PetImageHandler extends Serializable{

	//ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws ShowDogException;
	ResponseEntity<List<?>> getAllByPetId(Integer petId) throws ShowDogException;

	ResponseEntity<?> addImage(Integer petId, MultipartFile image) throws ShowDogException;
}
