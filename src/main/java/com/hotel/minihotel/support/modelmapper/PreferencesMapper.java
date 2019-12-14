package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Preferences;
import com.informatique.gov.helpdesk.rest.dto.PreferencesDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PreferencesMapper extends AbstractModelMapper<Preferences, PreferencesDto, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public PreferencesDto toDto(Preferences entity) {
		PreferencesDto dto = null;
		if (isConvertable(entity)) {
			dto = new PreferencesDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
		}
		return dto;
	}

	@Override
	protected Preferences toEntity(PreferencesDto dto, boolean nullId) {
		Preferences entity = null;
		if (isConvertable(dto)) {
			entity = new Preferences();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
		}
		return entity;
	}

}
