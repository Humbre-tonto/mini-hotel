package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;

import com.informatique.gov.helpdesk.domain.Pet;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetDto;

public interface PetService extends Serializable {
	List<Pet> getAll() throws ShowDogException;

	PetDto addPet(PetDto petDto) throws ShowDogException;

	List<Pet> getAllByBreed(Integer breedId) throws ShowDogException;

}