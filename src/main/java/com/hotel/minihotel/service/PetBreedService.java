package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;

import com.informatique.gov.helpdesk.domain.PetTypeBreed;
import com.informatique.gov.helpdesk.exception.ShowDogException;

public interface PetBreedService extends Serializable {
	List<PetTypeBreed> getAll() throws ShowDogException;

	List<PetTypeBreed> getByPetType(Integer petTypeId) throws ShowDogException;

}