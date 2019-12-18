package com.hotel.minihotel.rest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id", "type" })
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class RoomDto implements UserModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	private Integer id;
	private TypeDto type;
	private ReservationDto reservation;

}
