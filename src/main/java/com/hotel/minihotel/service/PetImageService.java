package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.informatique.gov.helpdesk.domain.PetImage;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.PetImageDto;

public interface PetImageService extends Serializable {
	List<PetImage> getAllByPetId(Integer petId) throws ShowDogException;

	PetImageDto addPetImage(Integer petId, MultipartFile image) throws ShowDogException;

}