package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.domain.CommunicationChannel;
import com.informatique.gov.helpdesk.rest.dto.CommunicationChannelDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CommunicationChannelMapper
		extends AbstractModelMapper<CommunicationChannel, CommunicationChannelDto, Byte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CommunicationChannelDto toDto(CommunicationChannel entity) {
		CommunicationChannelDto dto = null;

		if (isConvertable(entity)) {
			dto = new CommunicationChannelDto();
			dto.setId(entity.getId());
			dto.setArabicName(entity.getArabicName());
			dto.setCode(entity.getCode());
			dto.setEnglishName(entity.getEnglishName());

		}
		return dto;
	}

	@Override
	protected CommunicationChannel toEntity(CommunicationChannelDto dto, boolean nullId) {
		CommunicationChannel entity = null;

		if (isConvertable(dto)) {
			entity = new CommunicationChannel();
			entity.setId(nullId ? null : dto.getId());
			entity.setArabicName(dto.getArabicName());
			entity.setCode(dto.getCode());
			entity.setEnglishName(dto.getEnglishName());
		}
		return entity;
	}

}
