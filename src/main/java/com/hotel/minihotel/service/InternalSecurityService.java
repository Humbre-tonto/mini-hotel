package com.hotel.minihotel.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.rest.dto.UserDetailsDto;
import com.hotel.minihotel.support.dataenum.UserRoleEnum;
import com.hotel.minihotel.support.security.HotelGrantedAuthority;


public interface InternalSecurityService extends Serializable{

	UserDetailsDto getUserDetails(HttpSession session) throws HotelException;

	String getPrincipal() throws HotelException;

	UserDetailsDto getUserDetails() throws HotelException;

	User getUser() throws HotelException;

	Optional<Authentication> getAuthentication() throws HotelException;

	boolean hasRole(UserRoleEnum userRoleEnum) throws HotelException;

	boolean hasAnyRole(List<HotelGrantedAuthority> authorities) throws HotelException;

	boolean hasAnyRole(UserRoleEnum... userRoleEnum) throws HotelException;

	boolean hasRole(String userLoginName, UserRoleEnum userRoleEnum) throws HotelException;

	boolean isUserLoggedIn();


}
