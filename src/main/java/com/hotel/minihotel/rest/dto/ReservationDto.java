package com.hotel.minihotel.rest.dto;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id", "room" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class ReservationDto implements UserModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	private Integer id;
	private Date dateCreated;

	private Integer duration;

	private RoomDto room;

	private UserDto customer;

	private UserDto creator;

}
