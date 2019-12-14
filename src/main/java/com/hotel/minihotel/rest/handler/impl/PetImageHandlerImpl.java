package com.informatique.gov.helpdesk.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.informatique.gov.helpdesk.domain.PetImage;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetImageDto;
import com.informatique.gov.helpdesk.rest.handler.PetImageHandler;
import com.informatique.gov.helpdesk.service.PetImageService;
import com.informatique.gov.helpdesk.support.modelmapper.PetImageMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PetImageHandlerImpl implements PetImageHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;

	private PetImageService petService;
	private PetImageMapper petMapper;

	@Override
	public ResponseEntity<List<?>> getAllByPetId(Integer petId) throws ShowDogException {
		ResponseEntity<List<?>> response = null;
		try {
			List<PetImage> pets = petService.getAllByPetId(petId);
			List<PetImageDto> petDtos = petMapper.toDto(pets);
			response = ResponseEntity.ok(petDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> addImage(Integer petId, MultipartFile image) throws ShowDogException {
		ResponseEntity<PetImageDto> response = null;
		PetImageDto petDto = null;
		petDto = petService.addPetImage(petId, image);
		response = ResponseEntity.ok(petDto);
		return response;
	}

}
