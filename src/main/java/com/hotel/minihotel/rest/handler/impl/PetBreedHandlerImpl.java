package com.informatique.gov.helpdesk.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.domain.PetTypeBreed;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetTypeBreedDto;
import com.informatique.gov.helpdesk.rest.handler.PetBreedHandler;
import com.informatique.gov.helpdesk.service.PetBreedService;
import com.informatique.gov.helpdesk.support.modelmapper.PetTypeBreedMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PetBreedHandlerImpl implements PetBreedHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;

	private PetBreedService petBreedService;
	private PetTypeBreedMapper petBreedMapper;

	@Override
	public ResponseEntity<List<?>> getAll() throws ShowDogException {
		ResponseEntity<List<?>> response = null;
		try {
			List<PetTypeBreed> breeds = petBreedService.getAll();
			List<PetTypeBreedDto> breedDtos = petBreedMapper.toDto(breeds);
			response = ResponseEntity.ok(breedDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<List<?>> getByPetType(Integer petTypeId) throws ShowDogException {
		ResponseEntity<List<?>> response = null;
		List<PetTypeBreed> breeds = petBreedService.getByPetType(petTypeId);
		List<PetTypeBreedDto> breedDtos = petBreedMapper.toDto(breeds);

		response = ResponseEntity.ok(breedDtos);
		return response;
	}

}
