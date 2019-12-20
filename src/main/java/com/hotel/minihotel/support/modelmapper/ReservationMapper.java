package com.hotel.minihotel.support.modelmapper;

import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.Reservation;
import com.hotel.minihotel.domain.Room;
import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.rest.dto.ReservationDto;
import com.hotel.minihotel.rest.dto.RoomDto;
import com.hotel.minihotel.rest.dto.UserDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ReservationMapper extends AbstractModelMapper<Reservation, ReservationDto, Integer> {

	private ModelMapper<Room, RoomDto, Integer> roomMapper;
	private ModelMapper<User, UserDto, Integer> employeeMapper;
	private ModelMapper<User, UserDto, Integer> customerMapper;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;

	@Override
	public ReservationDto toDto(Reservation entity) {
		ReservationDto dto = null;
		if (isConvertable(entity)) {
			dto = new ReservationDto();

			dto.setId(entity.getId());
			dto.setDuration(entity.getDuration());
			dto.setCreator(customerMapper.toDto(entity.getCreator()));
			dto.setCustomer(employeeMapper.toDto(entity.getCreator()));
			dto.setRoom(roomMapper.toDto(entity.getRoom()));

		}
		return dto;
	}

	@Override
	protected Reservation toEntity(ReservationDto dto, boolean nullId) {
		Reservation entity = null;
		if (isConvertable(dto)) {
			entity = new Reservation();

			entity.setId(dto.getId());
			dto.setDuration(entity.getDuration());
			dto.setCreator(customerMapper.toDto(entity.getCreator()));
			dto.setCustomer(employeeMapper.toDto(entity.getCreator()));
			dto.setRoom(roomMapper.toDto(entity.getRoom()));
		}
		return entity;
	}

}
