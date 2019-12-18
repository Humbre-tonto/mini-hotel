package com.hotel.minihotel.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.persistence.repository.UserRepository;
import com.hotel.minihotel.rest.dto.UserDto;
import com.hotel.minihotel.service.InternalUserService;
import com.hotel.minihotel.service.UserService;
import com.hotel.minihotel.support.modelmapper.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements InternalUserService, UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private UserRepository userRepository;
	private UserMapper userMapper;

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = true)
	public User getByLoginName(String loginName) throws HotelException {
		User user = null;
		try {

			user = userRepository.findByName(loginName);

		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return user;
	}

	@Override
	public List<User> getAll() throws HotelException {
		List<User> users = null;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return users;
	}

	@Override
	public UserDto register(UserDto userDto) throws HotelException {
		UserDto savedDto = null;

		try {
			notNull(userDto, "dto must be set");

			User entiry = userMapper.toNewEntity(userDto);

			entiry = userRepository.save(entiry);

			savedDto = userMapper.toDto(entiry);

		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return savedDto;
	}

	@Override
	public UserDto getById(Integer id) throws HotelException {
		UserDto users = null;
		try {
			users = userMapper.toDto(userRepository.findById(id).get());
			
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return users;
	}

	@Override
	public UserDto updateById(Integer id, UserDto updatedUser) throws HotelException {
		UserDto savedDto = null;

		try {
			notNull(updatedUser, "dto must be set");
			User oldUser = userRepository.findById(id).get();
			
			User entity = userMapper.toEntity(updatedUser);
			
			
			entity = userRepository.save(oldUser);

			savedDto = userMapper.toDto(entity);
			

		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return savedDto;
	}

	@Override
	public void deleteById(Integer id) throws HotelInternalException {
		try {
		 userRepository.deleteById(id);
		}catch (Exception e) {
			throw new HotelInternalException(e);
		}
	}

	@Override
	public UserDto getByUsernameAndPassword(String id, String password) throws HotelInternalException {
		UserDto users = null;
		try {
			users = userMapper.toDto(userRepository.findByNameAndPassword(id,password));			
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return users;
	}
}
