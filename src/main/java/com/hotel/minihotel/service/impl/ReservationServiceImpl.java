package com.hotel.minihotel.service.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.minihotel.domain.Reservation;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.persistence.repository.ReservationRepository;
import com.hotel.minihotel.rest.dto.ReservationDto;
import com.hotel.minihotel.service.ReservationService;
import com.hotel.minihotel.support.modelmapper.ReservationMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private ReservationRepository reservationRepository;
	private ReservationMapper reservationMapper;

	
	@Override
	public List<Reservation> getAll() throws HotelException {
		List<Reservation> reservation = null;
		try {
			reservation = reservationRepository.findAll();
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return reservation;
	}

	@Override
	public ReservationDto reserve(ReservationDto reservationDto) throws HotelException {
		ReservationDto savedDto = null;

		try {
			notNull(reservationDto, "dto must be set");

			Reservation entiry = reservationMapper.toNewEntity(reservationDto);

			entiry = reservationRepository.save(entiry);

			savedDto = reservationMapper.toDto(entiry);

		} catch (Exception e) {
			throw new HotelInternalException(e);
		}

		return savedDto;
	}

	@Override
	public ReservationDto getById(Integer id) throws HotelException {
		ReservationDto reservation = null;
		try {
			reservation = reservationMapper.toDto(reservationRepository.findById(id).get());
			
		} catch (Exception e) {
			throw new HotelInternalException(e);
		}
		return reservation;
	}


}
