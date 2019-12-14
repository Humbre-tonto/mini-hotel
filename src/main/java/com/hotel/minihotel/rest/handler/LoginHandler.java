package com.informatique.gov.helpdesk.rest.handler;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.UserDetailsDto;


public interface LoginHandler extends Serializable{

	ResponseEntity<UserDetailsDto> getUserDetails(HttpSession session) throws ShowDogException;

}
