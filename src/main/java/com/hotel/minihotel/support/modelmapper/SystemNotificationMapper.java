package com.informatique.gov.helpdesk.support.modelmapper;

import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.SystemNotification;
import com.informatique.gov.helpdesk.websocket.dto.SystemNotificationDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SystemNotificationMapper extends AbstractModelMapper<SystemNotification, SystemNotificationDto, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;

	@Override
	public SystemNotificationDto toDto(SystemNotification entity) {
		SystemNotificationDto dto = null;
		if (isConvertable(entity)) {
			dto = new SystemNotificationDto();
			dto.setBody(entity.getBody());
			dto.setId(entity.getId());
			dto.setReceiveDate(entity.getReceiveDate());
			dto.setSendDate(entity.getSendDate());
			dto.setTypeCode(entity.getTypeCode());
			dto.setCreateDate(entity.getCreateDate());
			dto.setTicketSerial(entity.getTicketSerial());
		}
		return dto;
	}

	@Override
	protected SystemNotification toEntity(SystemNotificationDto dto, boolean nullId) {

		return null;
	}

}
