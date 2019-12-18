package com.hotel.minihotel.service;

import java.io.Serializable;
import java.util.List;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.RoomDto;

public interface RoomService extends Serializable {
	List<RoomDto> getAll() throws HotelException;
	RoomDto getById(Integer id) throws HotelException;
	}