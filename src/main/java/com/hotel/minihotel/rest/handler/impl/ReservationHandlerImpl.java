package com.hotel.minihotel.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.Reservation;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.rest.dto.ReservationDto;
import com.hotel.minihotel.rest.handler.ReservationHandler;
import com.hotel.minihotel.service.ReservationService;
import com.hotel.minihotel.support.modelmapper.ReservationMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReservationHandlerImpl implements ReservationHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;

	private ReservationService reservationService;
	private ReservationMapper reservationMapper;

	@Override
	public ResponseEntity<List<?>> getAll() throws HotelException {
		ResponseEntity<List<?>> response = null;
		try {
			List<Reservation> roomss = reservationService.getAll();
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
			ReservationDto userDtos = reservationService.getById(id);
			response = ResponseEntity.ok(userDtos);

		} catch (HotelException e) {
			throw e;
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return response;

	
	}

	@Override
	public ResponseEntity<?> reserve(ReservationDto reservation) throws HotelException {
		ResponseEntity<ReservationDto> response = null;

		reservation = reservationService.reserve(reservation); 
		 response = ResponseEntity.ok(reservation);
		return response;
	}
}
