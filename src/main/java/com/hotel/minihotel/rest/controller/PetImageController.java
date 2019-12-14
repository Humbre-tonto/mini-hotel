package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.handler.PetImageHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/petImages")
@AllArgsConstructor
public class PetImageController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private PetImageHandler petHandler;

	@GetMapping("/getPet/{petId}")
	public ResponseEntity<?> getAllByPetId(@PathVariable Integer petId) throws ShowDogException {
		return petHandler.getAllByPetId(petId);
	}

	// @PostMapping("/addPet" )
	@RequestMapping(value = "/addPet/{petId}", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = "application/json", consumes = "image/*")
	public ResponseEntity<?> AddPet(@PathVariable Integer petId, @RequestParam("image") MultipartFile image)
			throws ShowDogException { // @RequestBody PetImageDto petDto,
		return petHandler.addImage(petId, image);
	}
}
