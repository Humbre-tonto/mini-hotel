package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.handler.SystemNotificationHandler;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/systemNotifications")
@AllArgsConstructor
public class SystemNotificationController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private SystemNotificationHandler systemNotificationHandler;

	@GetMapping(params = { "page", "size" })
	public ResponseEntity<?> getByRecipient(@RequestParam int page, @RequestParam int size) throws ShowDogException {

		return systemNotificationHandler.getByRecipient(page, size);
	}

}
