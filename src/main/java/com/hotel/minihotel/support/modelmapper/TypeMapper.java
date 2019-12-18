package com.hotel.minihotel.support.modelmapper;

import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.Type;
import com.hotel.minihotel.rest.dto.TypeDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class TypeMapper extends AbstractModelMapper<Type, TypeDto, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Override
	public TypeDto toDto(Type entity) {
		TypeDto dto = null;
		if (isConvertable(entity)) {
			dto = new TypeDto();

			dto.setId(entity.getId());
			dto.setCode(entity.getCode());
		}
		return dto;
	}

	@Override
	protected Type toEntity(TypeDto dto, boolean nullId) {
		Type entity = null;
		if (isConvertable(dto)) {
			entity = new Type();

			entity.setId(dto.getId());
			entity.setCode(dto.getCode());
		}
		return entity;
	}

}
