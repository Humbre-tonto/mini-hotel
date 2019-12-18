package com.hotel.minihotel.support.modelmapper;

import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.Room;
import com.hotel.minihotel.rest.dto.RoomDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RoomMapper extends AbstractModelMapper<Room, RoomDto, Integer> {

	/**
	 * 
	 */
	private TypeMapper typeMapper;
	private static final long serialVersionUID = 1;

	@Override
	public RoomDto toDto(Room entity) {
		RoomDto dto = null;
		if (isConvertable(entity)) {
			dto = new RoomDto();

			
			dto.setId(entity.getId());
			dto.setType(typeMapper.toDto(entity.getType()));
			//dto.setReservation(reservationMapper.toDto(entity.getReservation()));			
		}
		return dto;
	}

	@Override
	protected Room toEntity(RoomDto dto, boolean nullId) {
		Room entity = null;
		if (isConvertable(dto)) {
			entity = new Room();
			
			entity.setId(dto.getId());
			entity.setType(typeMapper.toEntity(dto.getType()));
			//entity.setReservation(reservationMapper.toEntity(dto.getReservation()));

		}
		return entity;
	}

}
