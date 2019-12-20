package com.hotel.minihotel.service;

import java.io.Serializable;
import java.util.List;

import com.hotel.minihotel.domain.Reservation;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.ReservationDto;

public interface ReservationService extends Serializable {
	List<Reservation> getAll() throws HotelException;
	ReservationDto reserve(ReservationDto reservation) throws HotelException;
	ReservationDto getById(Integer id) throws HotelException;
}