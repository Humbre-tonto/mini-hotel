package com.informatique.gov.helpdesk.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.informatique.gov.helpdesk.service.SystemNotificationService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class NotificationController {

	
	private SystemNotificationService systemNotificationService;
	
	@MessageMapping("/notificationSent")
	public void sent(Long notificationId) throws Exception {
		systemNotificationService.setSendDate(notificationId);
	}
}
