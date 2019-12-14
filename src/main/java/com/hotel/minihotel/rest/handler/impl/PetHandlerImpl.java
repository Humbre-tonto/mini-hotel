package com.informatique.gov.helpdesk.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.domain.Pet;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetDto;
import com.informatique.gov.helpdesk.rest.handler.PetHandler;
import com.informatique.gov.helpdesk.service.PetService;
import com.informatique.gov.helpdesk.support.modelmapper.PetMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PetHandlerImpl implements PetHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;

	private PetService petService;
	private PetMapper petMapper;

	@Override
	public ResponseEntity<List<?>> getAll() throws ShowDogException {
		ResponseEntity<List<?>> response = null;
		try {
			List<Pet> pets = petService.getAll();
			List<PetDto> petDtos = petMapper.toDto(pets);
			response = ResponseEntity.ok(petDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> addPet(PetDto petDto) throws ShowDogException {
		ResponseEntity<PetDto> response = null;
		petDto = petService.addPet(petDto);
		response = ResponseEntity.ok(petDto);
		return response;
	}

	@Override
	public ResponseEntity<List<?>> getAllByBreed(Integer breedId) throws ShowDogException{
		ResponseEntity<List<?>> response = null;
		try {
			List<Pet> pets = petService.getAllByBreed(breedId);
			List<PetDto> petDtos = petMapper.toDto(pets);
			response = ResponseEntity.ok(petDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

}
