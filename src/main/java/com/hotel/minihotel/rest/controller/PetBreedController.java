package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.handler.PetBreedHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/petBreed")
@AllArgsConstructor
public class PetBreedController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private PetBreedHandler petBreedHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws ShowDogException {
		return petBreedHandler.getAll();
	}
	
	@PostMapping("/{petTypeId}")
	public ResponseEntity<?> getByPetType(@PathVariable Integer petTypeId) throws ShowDogException {
		return petBreedHandler.getByPetType(petTypeId);
	}
}
