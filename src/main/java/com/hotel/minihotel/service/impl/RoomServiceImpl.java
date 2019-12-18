package com.hotel.minihotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.persistence.repository.RoomRepository;
import com.hotel.minihotel.rest.dto.RoomDto;
import com.hotel.minihotel.service.RoomService;
import com.hotel.minihotel.support.modelmapper.RoomMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements  RoomService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private RoomRepository roomRepository;
	private RoomMapper roomMapper;

	@Override
	public List<RoomDto> getAll() throws HotelException {
		List<RoomDto> rooms = null;
		try {
			rooms = roomMapper.toDto(roomRepository.findAll());
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return rooms;
	}

	
	@Override
	public RoomDto getById(Integer id) throws HotelException {
		RoomDto room = null;
		try {
			room = roomMapper.toDto(roomRepository.findById(id).get());
			
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return room;
	}

	
}
