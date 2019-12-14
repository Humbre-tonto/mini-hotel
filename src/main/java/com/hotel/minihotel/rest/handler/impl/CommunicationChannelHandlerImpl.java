package com.informatique.gov.helpdesk.rest.handler.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.CommunicationChannel;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.rest.dto.CommunicationChannelDto;
import com.informatique.gov.helpdesk.rest.handler.CommunicationChannelHandler;
import com.informatique.gov.helpdesk.service.CommunicationChannelService;
import com.informatique.gov.helpdesk.support.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CommunicationChannelHandlerImpl implements CommunicationChannelHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private CommunicationChannelService communicationChannelService;
	private ModelMapper<CommunicationChannel, CommunicationChannelDto, Byte> communicationChannelMapper;

	@Override
	public ResponseEntity<List<?>> getAll() throws ShowDogException {
		ResponseEntity<List<?>> response = null;
		try {
			List<CommunicationChannel> communicationChannels = communicationChannelService.getAll();
			List<CommunicationChannelDto> communicationChannelDtos = communicationChannelMapper
					.toDto(communicationChannels);
			response = ResponseEntity.ok(communicationChannelDtos);

		} catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}

		return response;
	}

}
