package com.informatique.gov.helpdesk.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.persistence.repository.UserRepository;
import com.informatique.gov.helpdesk.rest.dto.UserDto;
import com.informatique.gov.helpdesk.service.InternalUserService;
import com.informatique.gov.helpdesk.service.UserService;
import com.informatique.gov.helpdesk.support.modelmapper.UserMapper;
import static org.springframework.util.Assert.notNull;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements InternalUserService, UserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private UserRepository userRepository;
	private UserMapper userMapper;

	@Override
	@Transactional(rollbackFor = Exception.class, readOnly = true)
	public User getByLoginName(String loginName) throws ShowDogException {
		User user = null;
		try {

			user = userRepository.findByLoginNameIgnoreCase(loginName);

		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return user;
	}

	@Override
	public List<User> getAll() throws ShowDogException {
		List<User> users = null;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return users;
	}

	@Override
	public UserDto register(UserDto userDto) throws ShowDogException {
		UserDto savedDto = null;

		try {
			notNull(userDto, "dto must be set");

			User entiry = userMapper.toNewEntity(userDto);

			entiry = userRepository.save(entiry);

			savedDto = userMapper.toDto(entiry);

		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return savedDto;
	}

	@Override
	public UserDto getById(Integer id) throws ShowDogException {
		UserDto users = null;
		try {
			users = userMapper.toDto(userRepository.findById(id).get());
			
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return users;
	}

	@Override
	public UserDto updateById(Integer id, UserDto updatedUser) throws ShowDogException {
		UserDto savedDto = null;

		try {
			notNull(updatedUser, "dto must be set");
			User oldUser = userRepository.findById(id).get();
			
			User entity = userMapper.toEntity(updatedUser);
			
			oldUser.setFirstName(entity.getFirstName());
			oldUser.setLastName(entity.getLastName());
			oldUser.setMobile(entity.getMobile());
			oldUser.setEmail(entity.getEmail());
			
			entity = userRepository.save(oldUser);

			savedDto = userMapper.toDto(entity);
			

		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return savedDto;
	}
}
