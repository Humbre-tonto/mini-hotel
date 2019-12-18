package com.hotel.minihotel.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.handler.RoomHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private RoomHandler roomHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws HotelException {
		return roomHandler.getAll();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) throws HotelException {
		return roomHandler.getById(id);
	}
		
}
