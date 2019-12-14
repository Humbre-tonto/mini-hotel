package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Gender;
import com.informatique.gov.helpdesk.rest.dto.GenderDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GenderMapper extends AbstractModelMapper<Gender, GenderDto, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public GenderDto toDto(Gender entity) {
		GenderDto dto = null;
		if (isConvertable(entity)) {
			dto = new GenderDto();
			dto.setEnglishName(entity.getEnglishName());
			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
		}
		return dto;
	}

	@Override
	protected Gender toEntity(GenderDto dto, boolean nullId) {
		Gender entity = null;
		if (isConvertable(dto)) {
			entity = new Gender();
			entity.setEnglishName(dto.getEnglishName());
			entity.setId(dto.getId());
			entity.setCode(dto.getCode());
		}
		return entity;
	}

}
