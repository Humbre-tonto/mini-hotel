package com.hotel.minihotel.support.modelmapper;

import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.Role;
import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.rest.dto.RoleDto;
import com.hotel.minihotel.rest.dto.UserDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserMapper extends AbstractModelMapper<User, UserDto, Integer> {

	private ModelMapper<Role, RoleDto, Byte> roleMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Override
	public UserDto toDto(User entity) {
		UserDto dto = null;
		if (isConvertable(entity)) {
			dto = new UserDto();

			
			dto.setId(entity.getId());
			dto.setRole(roleMapper.toDto(entity.getRole()));
			
		}
		return dto;
	}

	@Override
	protected User toEntity(UserDto dto, boolean nullId) {
		User entity = null;
		if (isConvertable(dto)) {
			entity = new User();
			
			entity.setId(dto.getId());
			entity.setRole(roleMapper.toEntity(dto.getRole()));

		}
		return entity;
	}

}
