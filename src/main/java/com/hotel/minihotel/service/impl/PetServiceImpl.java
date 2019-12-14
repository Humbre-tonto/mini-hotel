package com.informatique.gov.helpdesk.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Pet;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.persistence.repository.PetRepository;
import com.informatique.gov.helpdesk.rest.dto.PetDto;
import com.informatique.gov.helpdesk.service.PetService;
import com.informatique.gov.helpdesk.support.modelmapper.PetMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PetServiceImpl implements PetService {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private PetRepository petRepository;
	private PetMapper petMapper;

	@Override
	public List<Pet> getAll() throws ShowDogException {
		List<Pet> pets = null;
		try {
			pets = petRepository.findAll();
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return pets;
	}

	@Override
	public PetDto addPet(PetDto petDto) throws ShowDogException {
		PetDto savedDto = null;
		try {
			notNull(petDto, "dto must be set");

			Pet entity = petMapper.toNewEntity(petDto);

			entity = petRepository.save(entity);

			savedDto = petMapper.toDto(entity);

		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return savedDto;
	}

	@Override
	public List<Pet> getAllByBreed(Integer breedId) throws ShowDogException {
		List<Pet> pets = null;
		try {
			pets = petRepository.findAllByPetTypeBreedId(breedId);
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return pets;
	}

}