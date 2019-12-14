package com.informatique.gov.helpdesk.rest.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatique.gov.helpdesk.ShowDogVersion;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.handler.LoginHandler;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = ShowDogVersion.serialVersionUID;	
	private LoginHandler loginHandler;
	
	@GetMapping
	public ResponseEntity<?> login(HttpSession session) throws ShowDogException {
		return loginHandler.getUserDetails(session);
	}
}
