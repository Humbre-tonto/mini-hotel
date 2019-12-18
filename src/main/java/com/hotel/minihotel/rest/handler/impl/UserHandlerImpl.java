package com.hotel.minihotel.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.rest.dto.UserDto;
import com.hotel.minihotel.rest.handler.UserHandler;
import com.hotel.minihotel.service.UserService;
import com.hotel.minihotel.support.modelmapper.UserMapper;

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
	public ResponseEntity<List<?>> getAll() throws HotelException {
		ResponseEntity<List<?>> response = null;
		try {
			List<User> users = userService.getAll();
			List<UserDto> userDtos = userMapper.toDto(users);
			response = ResponseEntity.ok(userDtos);

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> register(UserDto userDto) throws HotelException {
		ResponseEntity<UserDto> response = null;

		userDto = userService.register(userDto); 
		 response = ResponseEntity.ok(userDto);
		return response;
	}

	@Override
	public ResponseEntity<?> getById(Integer id) throws HotelException {
		ResponseEntity<?> response = null;

		try {
			UserDto userDtos = userService.getById(id);
			response = ResponseEntity.ok(userDtos);

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> updateById(Integer id,UserDto updatedUser) throws HotelException {
		ResponseEntity<?> response = null;

		try {
			UserDto users = userService.updateById(id, updatedUser);
			response = ResponseEntity.ok(users);

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> deleteById(Integer id) throws HotelInternalException {
		ResponseEntity<?> response = null;

		try {
			 userService.deleteById(id);
			response = (ResponseEntity<?>) ResponseEntity.ok();

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> getByUsernameAndPassword(String id, String password) throws HotelException {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = null;

		try {
			UserDto user= userService.getByUsernameAndPassword(id,password);
			response = ResponseEntity.ok(user);

		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

}
