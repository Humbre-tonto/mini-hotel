package com.hotel.minihotel.service;

import java.io.Serializable;
import java.util.List;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.rest.dto.UserDto;

public interface UserService extends Serializable {
	List<User> getAll() throws HotelException;
	UserDto register(UserDto userDto) throws HotelException;
	UserDto getById(Integer id) throws HotelException;
	UserDto updateById(Integer id, UserDto updatedUser) throws HotelException;
	void deleteById(Integer id) throws HotelInternalException;
	UserDto getByUsernameAndPassword(String id, String password) throws HotelInternalException;
}