package com.hotel.minihotel.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.rest.dto.RoomDto;
import com.hotel.minihotel.rest.handler.RoomHandler;
import com.hotel.minihotel.service.RoomService;
import com.hotel.minihotel.support.modelmapper.RoomMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RoomHandlerImpl implements RoomHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;

	private RoomService roomService;
	private RoomMapper roomMapper;

	@Override
	public ResponseEntity<List<?>> getAll() throws HotelException {
		ResponseEntity<List<?>> response = null;
		try {
			List<RoomDto> roomss = roomService.getAll();
			response = ResponseEntity.ok(roomss);

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

	@Override
	public ResponseEntity<?> getById(Integer id) throws HotelException {
		ResponseEntity<?> response = null;

		try {
			RoomDto userDtos = roomService.getById(id);
			response = ResponseEntity.ok(userDtos);

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;
	}

}
