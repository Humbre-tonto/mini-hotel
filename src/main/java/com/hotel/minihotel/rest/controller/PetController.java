package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetDto;
import com.informatique.gov.helpdesk.rest.handler.PetHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pet")
@AllArgsConstructor
public class PetController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private PetHandler petHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws ShowDogException {
		return petHandler.getAll();
	}
	
	@PostMapping("/addPet")
	public ResponseEntity<?> AddPet(@RequestBody PetDto petDto) throws ShowDogException {
		return petHandler.addPet(petDto);
	}
	
	@GetMapping("/petBreeds")
	public ResponseEntity<?> getAllByBreed(@PathVariable Integer breedId) throws ShowDogException {
		return petHandler.getAllByBreed(breedId);
	}
}
