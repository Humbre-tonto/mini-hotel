package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.PetType;
import com.informatique.gov.helpdesk.domain.PetTypeBreed;
import com.informatique.gov.helpdesk.rest.dto.PetTypeBreedDto;
import com.informatique.gov.helpdesk.rest.dto.PetTypeDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PetTypeBreedMapper extends AbstractModelMapper<PetTypeBreed, PetTypeBreedDto, Integer> {

	private ModelMapper<PetType, PetTypeDto, Integer> petTypeMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public PetTypeBreedDto toDto(PetTypeBreed entity) {
		PetTypeBreedDto dto = null;
		if (isConvertable(entity)) {
			dto = new PetTypeBreedDto();
			dto.setEnglishName(entity.getEnglishName());
			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
			dto.setPetType(petTypeMapper.toDto(entity.getPetType()));
		}
		return dto;
	}

	@Override
	protected PetTypeBreed toEntity(PetTypeBreedDto dto, boolean nullId) {
		PetTypeBreed entity = null;
		if (isConvertable(dto)) {
			entity = new PetTypeBreed();
			entity.setEnglishName(dto.getEnglishName());
			entity.setId(dto.getId());
			entity.setCode(dto.getCode());
			entity.setPetType(petTypeMapper.toEntity(dto.getPetType()));
		}
		return entity;
	}

}
