package com.informatique.gov.helpdesk.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.PetTypeBreed;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.persistence.repository.PetBreedRepository;
import com.informatique.gov.helpdesk.service.PetBreedService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PetBreedServiceImpl implements PetBreedService {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private PetBreedRepository petBreedRepository;

	@Override
	public List<PetTypeBreed> getAll() throws ShowDogException {
		List<PetTypeBreed> breeds = null;
		try {
			breeds = petBreedRepository.findAll();
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return breeds;
	}

	@Override
	public List<PetTypeBreed> getByPetType(Integer petTypeId) throws ShowDogException {
		List<PetTypeBreed> entity = null;
		try {
			notNull(petTypeId, "dto must be set");

			entity = petBreedRepository.findAllByPetTypeId(petTypeId);

		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return entity;
	}

}