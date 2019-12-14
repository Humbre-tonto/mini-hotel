package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.websocket.dto.SystemNotificationDto;

public interface SystemNotificationHandler extends Serializable{

	ResponseEntity<Page<SystemNotificationDto>> getByRecipient(int page, int size) throws ShowDogException;

}
