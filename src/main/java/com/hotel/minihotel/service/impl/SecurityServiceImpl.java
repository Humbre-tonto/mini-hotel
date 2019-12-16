package com.hotel.minihotel.service.impl;

import static org.springframework.util.Assert.notNull;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelException;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.persistence.repository.UserRepository;
import com.hotel.minihotel.rest.dto.AuthenticationTokenDto;
import com.hotel.minihotel.rest.dto.UserDetailsDto;
import com.hotel.minihotel.service.InternalSecurityService;
import com.hotel.minihotel.support.dataenum.UserRoleEnum;
import com.hotel.minihotel.support.security.AuthenticationToken;
import com.hotel.minihotel.support.security.HotelGrantedAuthority;
import com.hotel.minihotel.support.security.HotelUserDetails;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements InternalSecurityService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
    private Environment environment;
	private UserRepository userRepository;
	
	@Override
	public UserDetailsDto getUserDetails(HttpSession session) throws HotelException {
		UserDetailsDto userDetailsDto = null;
		try {
			Principal principal = SecurityContextHolder.getContext().getAuthentication();
			UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken)principal;
			HotelUserDetails userDetails = (HotelUserDetails)authenticationToken.getDetails();
			userDetails.setToken(new AuthenticationToken(session.getId(), Integer.parseInt(environment.getRequiredProperty("app.security.max-inactive-interval"))));
			userDetailsDto = toUserDetailsDto(userDetails);
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
		
		return userDetailsDto;
	}
	
	@Override
	public boolean hasRole(UserRoleEnum userRoleEnum) throws HotelException {
		try {
			Optional<Authentication> authentication = getAuthentication();
			return authentication.map(auth -> auth.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals(userRoleEnum.getCode()))).orElse(false);
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
	}
	
	@Override
	public boolean hasRole(String userLoginName, UserRoleEnum userRoleEnum) throws HotelException {
		try {
			String roleCode = userRepository.findRoleCodeByLoginName(userLoginName).orElse(null);
			return roleCode != null && roleCode.equals(userRoleEnum.getCode());
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
	}
	
	@Override
	public boolean hasAnyRole(List<HotelGrantedAuthority> authorities) throws HotelException {
		try {
			Optional<Authentication> authentication = getAuthentication();
			return authentication.map(auth -> auth.getAuthorities().stream().anyMatch(authorities::contains)).orElse(false);
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
	}
	
	@Override
	public boolean hasAnyRole(UserRoleEnum... userRoleEnums) throws HotelException {
		try {
			Optional<Authentication> authenticationOpt = getAuthentication();
			if(authenticationOpt.isPresent()) {
				Authentication authentication = authenticationOpt.get();
				Collection<? extends GrantedAuthority>  authorities = authentication.getAuthorities();
				
				for(GrantedAuthority auth : authorities) {
					for(UserRoleEnum role : userRoleEnums) {
						if(auth.getAuthority().equals(role.getCode())) {
							return true;
						}
					}
				}
				
			}
			return false;
			
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
	}
	
	@Override
	public UserDetailsDto getUserDetails() throws HotelException {
		UserDetailsDto userDetailsDto = null;
		try {
			Principal principal = SecurityContextHolder.getContext().getAuthentication();
			UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken)principal;
			HotelUserDetails userDetails = (HotelUserDetails)authenticationToken.getDetails();
			userDetailsDto = toUserDetailsDto(userDetails);
			
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
		
		return userDetailsDto;
	}
	
	@Override
	public Optional<Authentication> getAuthentication() throws HotelException {
		Optional<Authentication> authentication = Optional.empty();
		try {
			authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
		
		return authentication;
	}
	
	@Override
	public String getPrincipal() throws HotelException{
		String username = null;
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			username = authentication.getPrincipal().toString();
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
		
		return username;
	}
	
	@Override
	public boolean isUserLoggedIn() {
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}
	
	
	
	@Override
	public User getUser() throws HotelException {
		User user = null;
		try {
			String loginName = getPrincipal();
			user = userRepository.findByName(loginName);
		}catch(HotelException e) {
			throw e;
		}catch(Exception e) {
			throw new HotelInternalException(e);
		}
		
		return user;
	}
	
	private UserDetailsDto toUserDetailsDto(HotelUserDetails userDetails) {
		
		notNull(userDetails, "userDetails must be set");
		
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setFirstName(userDetails.getFirstName());
		userDetailsDto.setLastName(userDetails.getLastName());
		userDetailsDto.setUsername(userDetails.getUsername());
		userDetailsDto.setRole(userDetails.getAuthorities().iterator().next().getAuthority());
		userDetailsDto.setToken(new AuthenticationTokenDto(userDetails.getToken().getValue(), userDetails.getToken().getMaxInactiveInterval()));
		return userDetailsDto;
	}
}
