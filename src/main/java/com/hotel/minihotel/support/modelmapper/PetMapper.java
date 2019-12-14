package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Gender;
import com.informatique.gov.helpdesk.domain.Pet;
import com.informatique.gov.helpdesk.domain.PetTypeBreed;
import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.rest.dto.GenderDto;
import com.informatique.gov.helpdesk.rest.dto.PetDto;
import com.informatique.gov.helpdesk.rest.dto.PetTypeBreedDto;
import com.informatique.gov.helpdesk.rest.dto.UserDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PetMapper extends AbstractModelMapper<Pet, PetDto, Integer> {

	private ModelMapper<Gender, GenderDto, Integer> genderMapper;
	//private ModelMapper<PetPreferences, PetPreferencesDto, Integer> preferencesMapper;
	private ModelMapper<User,UserDto,Integer> userMapper;
	private ModelMapper<PetTypeBreed, PetTypeBreedDto , Integer> petTypeBreedMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public PetDto toDto(Pet entity) {
		PetDto dto = null;
		if (isConvertable(entity)) {
			dto = new PetDto();
			dto.setEnglishName(entity.getEnglishName());
			dto.setId(entity.getId());
			dto.setGender(genderMapper.toDto(entity.getGender()));
		//	dto.setPetPreferences(preferencesMapper.toDto(entity.getPetPreferences()));
			dto.setUser(userMapper.toDto(entity.getUser()));
			dto.setPetTypeBreed(petTypeBreedMapper.toDto(entity.getPetTypeBreed()));
		}
		return dto;
	}

	@Override
	protected Pet toEntity(PetDto dto, boolean nullId) {
		Pet entity = null;
		if (isConvertable(dto)) {
			entity = new Pet();
			entity.setEnglishName(dto.getEnglishName());
			entity.setId(dto.getId());
			entity.setGender(genderMapper.toEntity(dto.getGender()));
		//	entity.setPetPreferences(preferencesMapper.toEntity(dto.getPetPreferences()));
			entity.setUser(userMapper.toEntity(dto.getUser()));
			entity.setPetTypeBreed(petTypeBreedMapper.toEntity(dto.getPetTypeBreed()));
		}
		return entity;
	}

}
