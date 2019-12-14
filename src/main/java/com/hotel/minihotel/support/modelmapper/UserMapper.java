package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.Role;
import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.rest.dto.RoleDto;
import com.informatique.gov.helpdesk.rest.dto.UserDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserMapper extends AbstractModelMapper<User, UserDto, Integer> {

	private ModelMapper<Role, RoleDto, Byte> roleMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public UserDto toDto(User entity) {
		UserDto dto = null;
		if (isConvertable(entity)) {
			dto = new UserDto();

			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setId(entity.getId());
			dto.setLoginName(entity.getLoginName());
			dto.setRole(roleMapper.toDto(entity.getRole()));
			dto.setEmail(entity.getEmail());
			dto.setMobile(entity.getMobile());
			// dto.setPet(petMapper.toDto(entity.getPet()));
		}
		return dto;
	}

	@Override
	protected User toEntity(UserDto dto, boolean nullId) {
		User entity = null;
		if (isConvertable(dto)) {
			entity = new User();
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setId(dto.getId());
			entity.setLoginName(dto.getLoginName());
			entity.setRole(roleMapper.toEntity(dto.getRole()));
			entity.setEmail(dto.getEmail());
			entity.setMobile(dto.getMobile());
			// entity.setPet(petMapper.toEntity(dto.getPet()));

		}
		return entity;
	}

}
