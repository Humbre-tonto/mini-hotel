package com.informatique.gov.helpdesk.rest.handler.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.domain.SystemNotification;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.rest.handler.SystemNotificationHandler;
import com.informatique.gov.helpdesk.service.InternalSecurityService;
import com.informatique.gov.helpdesk.service.SystemNotificationService;
import com.informatique.gov.helpdesk.support.modelmapper.ModelMapper;
import com.informatique.gov.helpdesk.websocket.dto.SystemNotificationDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SystemNotificationHandlerImpl implements SystemNotificationHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private SystemNotificationService systemNotificationService;
	private InternalSecurityService securityService;
	private ModelMapper<SystemNotification, SystemNotificationDto, Long> systemNotificationMapper;
	
	@Override
	public ResponseEntity<Page<SystemNotificationDto>> getByRecipient(int page, int size) throws ShowDogException{
		ResponseEntity<Page<SystemNotificationDto>> response = null;
		try {
			
			Sort sort = Sort.by(Direction.fromString("desc"), "id");
			Pageable pageable = null;
			Page<SystemNotification> pageOfSystemNotifications = null;
			List<SystemNotification> totalsystemNotifications = systemNotificationService.getTotalByRecipient(securityService.getPrincipal());
			if(totalsystemNotifications.size() >= size)
			{	pageable = PageRequest.of(page, size, sort);
				pageOfSystemNotifications = systemNotificationService.getByRecipient(securityService.getPrincipal(), pageable);
			}else {
				pageable = PageRequest.of(page, totalsystemNotifications.size(), sort);
				pageOfSystemNotifications = systemNotificationService.getByRecipient(securityService.getPrincipal(), pageable);
			}
			Page<SystemNotificationDto> pageOfSystemNotificationDtos =  systemNotificationMapper.toDto(pageOfSystemNotifications);
			
			response = ResponseEntity.ok(pageOfSystemNotificationDtos);
			if(pageOfSystemNotificationDtos.hasContent()) {
			systemNotificationService.markAsSeen(pageOfSystemNotifications.getContent());
			}
		}catch(ShowDogException e) {
			throw e;
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return response;		
	}
}
