package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.PetType;
import com.informatique.gov.helpdesk.rest.dto.PetTypeDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PetTypeMapper extends AbstractModelMapper<PetType, PetTypeDto, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public PetTypeDto toDto(PetType entity) {
		PetTypeDto dto = null;
		if (isConvertable(entity)) {
			dto = new PetTypeDto();
			dto.setEnglishName(entity.getEnglishName());
			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
		}
		return dto;
	}

	@Override
	protected PetType toEntity(PetTypeDto dto, boolean nullId) {
		PetType entity = null;
		if (isConvertable(dto)) {
			entity = new PetType();
			entity.setEnglishName(dto.getEnglishName());
			entity.setId(dto.getId());
			entity.setCode(dto.getCode());
		}
		return entity;
	}

}
