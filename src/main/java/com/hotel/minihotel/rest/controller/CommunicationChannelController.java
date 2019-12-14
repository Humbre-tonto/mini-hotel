package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.handler.CommunicationChannelHandler;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/communicationChannels")
@AllArgsConstructor
public class CommunicationChannelController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;
	private CommunicationChannelHandler communicationChannelHandler;

	@GetMapping
	public ResponseEntity<?> getAll() throws ShowDogException {
		return communicationChannelHandler.getAll();
	}
}
