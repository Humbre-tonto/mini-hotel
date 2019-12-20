package com.hotel.minihotel.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.ReservationDto;
import com.hotel.minihotel.rest.handler.ReservationHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private ReservationHandler reservationHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws HotelException {
		return reservationHandler.getAll();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) throws HotelException {
		return reservationHandler.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> reserve(@RequestBody ReservationDto reservation) throws HotelException {
		return reservationHandler.reserve(reservation);
	}
		
}
