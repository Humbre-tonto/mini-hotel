package com.informatique.gov.helpdesk.rest.handler.impl;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.rest.dto.UserDetailsDto;
import com.informatique.gov.helpdesk.rest.handler.LoginHandler;
import com.informatique.gov.helpdesk.service.InternalSecurityService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LoginHandlerImpl implements LoginHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671575528463487897L;
	
	private InternalSecurityService securityService;
	
	@Override
	public ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws ShowDogException {
		
		ResponseEntity<UserDetailsDto> response = null;
		
		try {
			UserDetailsDto userDetailsDto = securityService.getUserDetails(session);
			response = ResponseEntity.ok(userDetailsDto);
		}catch (ShowDogException e) {
			throw e;
		} catch (Exception e) {
			throw new HelpdeskInternalException(e);
		}
		return response;		
	}

}
