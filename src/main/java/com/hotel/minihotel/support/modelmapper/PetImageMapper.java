package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Pet;
import com.informatique.gov.helpdesk.domain.PetImage;
import com.informatique.gov.helpdesk.rest.dto.PetDto;
import com.informatique.gov.helpdesk.rest.dto.PetImageDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PetImageMapper extends AbstractModelMapper<PetImage, PetImageDto, Integer> {

	private ModelMapper<Pet,PetDto,Integer> petMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public PetImageDto toDto(PetImage entity) {
		PetImageDto dto = null;
		if (isConvertable(entity)) {
			dto = new PetImageDto();
			dto.setId(entity.getId());
			dto.setPet(petMapper.toDto(entity.getPet()));
			dto.setProfileImage(entity.getProfileImage());
			dto.setImage(entity.getImage());
		}
		return dto;
	}

	@Override
	protected PetImage toEntity(PetImageDto dto, boolean nullId) {
		PetImage entity = null;
		if (isConvertable(dto)) {
			entity = new PetImage();
			entity.setId(dto.getId());
			entity.setPet(petMapper.toEntity(dto.getPet()));
			entity.setProfileImage(dto.getProfileImage());
			entity.setImage(dto.getImage());
		}
		return entity;
	}

}
