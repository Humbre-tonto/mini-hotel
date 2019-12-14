package com.informatique.gov.helpdesk.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.UserDto;
import com.informatique.gov.helpdesk.rest.handler.UserHandler;
import com.informatique.gov.helpdesk.service.UserService;
import com.informatique.gov.helpdesk.support.modelmapper.UserMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserHandlerImpl implements UserHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;

	private UserService userService;
	private UserMapper userMapper;

	@Override
	public ResponseEntity<List<?>> getAll() throws ShowDogException {
		ResponseEntity<List<?>> response = null;
		try {
			List<User> users = userService.getAll();
			List<UserDto> userDtos = userMapper.toDto(users);
			response = ResponseEntity.ok(userDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> register(UserDto userDto) throws ShowDogException {
		ResponseEntity<UserDto> response = null;

		userDto = userService.register(userDto); 
		 response = ResponseEntity.ok(userDto);
		return response;
	}

	@Override
	public ResponseEntity<?> getById(Integer id) throws ShowDogException {
		ResponseEntity<?> response = null;

		try {
			UserDto userDtos = userService.getById(id);
			response = ResponseEntity.ok(userDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> updateById(Integer id,UserDto updatedUser) throws ShowDogException {
		ResponseEntity<?> response = null;

		try {
			UserDto users = userService.updateById(id, updatedUser);
			response = ResponseEntity.ok(users);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

}
