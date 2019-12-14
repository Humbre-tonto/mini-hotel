package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;

import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.UserDto;

public interface UserService extends Serializable {
	List<User> getAll() throws ShowDogException;
	UserDto register(UserDto userDto) throws ShowDogException;
	UserDto getById(Integer id) throws ShowDogException;
	UserDto updateById(Integer id, UserDto updatedUser) throws ShowDogException;
}