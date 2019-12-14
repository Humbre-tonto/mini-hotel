package com.informatique.gov.helpdesk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.rest.dto.UserDetailsDto;
import com.informatique.gov.helpdesk.support.dataenum.UserRoleEnum;
import com.informatique.gov.helpdesk.support.security.HelpdeskGrantedAuthority;


public interface InternalSecurityService extends Serializable{

	UserDetailsDto getUserDetails(HttpSession session) throws ShowDogException;

	String getPrincipal() throws ShowDogException;

	UserDetailsDto getUserDetails() throws ShowDogException;

	User getUser() throws ShowDogException;

	Optional<Authentication> getAuthentication() throws ShowDogException;

	boolean hasRole(UserRoleEnum userRoleEnum) throws ShowDogException;

	boolean hasAnyRole(List<HelpdeskGrantedAuthority> authorities) throws ShowDogException;

	boolean hasAnyRole(UserRoleEnum... userRoleEnum) throws ShowDogException;

	boolean hasRole(String userLoginName, UserRoleEnum userRoleEnum) throws ShowDogException;

	boolean isUserLoggedIn();


}
