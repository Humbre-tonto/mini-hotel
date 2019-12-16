package com.hotel.minihotel.support.modelmapper;

import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.Role;
import com.hotel.minihotel.rest.dto.RoleDto;


@Component
public class RoleMapper extends AbstractModelMapper<Role, RoleDto, Byte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Override
	public RoleDto toDto(Role entity) {
		RoleDto dto = null;
		if (isConvertable(entity)) {
			dto = new RoleDto();
			dto.setArabicName(entity.getArabicName());
			dto.setCode(entity.getCode());
			dto.setEnglishName(entity.getEnglishName());
			dto.setId(entity.getId());
		}
		return dto;
	}

	@Override
	protected Role toEntity(RoleDto dto, boolean nullId) {
		Role entity = null;
		if (isConvertable(dto)) {
			entity = new Role();
			entity.setArabicName(dto.getArabicName());
			entity.setCode(dto.getCode());
			entity.setEnglishName(dto.getEnglishName());
			entity.setId(dto.getId());
		}
		return entity;
	}

}
