package com.informatique.gov.helpdesk.service.impl;

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

import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.ShowDogException;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.persistence.repository.UserRepository;
import com.informatique.gov.helpdesk.rest.dto.AuthenticationTokenDto;
import com.informatique.gov.helpdesk.rest.dto.UserDetailsDto;
import com.informatique.gov.helpdesk.service.InternalSecurityService;
import com.informatique.gov.helpdesk.support.dataenum.UserRoleEnum;
import com.informatique.gov.helpdesk.support.security.AuthenticationToken;
import com.informatique.gov.helpdesk.support.security.HelpdeskGrantedAuthority;
import com.informatique.gov.helpdesk.support.security.HelpdeskUserDetails;

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
	public UserDetailsDto getUserDetails(HttpSession session) throws ShowDogException {
		UserDetailsDto userDetailsDto = null;
		try {
			Principal principal = SecurityContextHolder.getContext().getAuthentication();
			UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken)principal;
			HelpdeskUserDetails userDetails = (HelpdeskUserDetails)authenticationToken.getDetails();
			userDetails.setToken(new AuthenticationToken(session.getId(), Integer.parseInt(environment.getRequiredProperty("app.security.max-inactive-interval"))));
			userDetailsDto = toUserDetailsDto(userDetails);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
		return userDetailsDto;
	}
	
	@Override
	public boolean hasRole(UserRoleEnum userRoleEnum) throws ShowDogException {
		try {
			Optional<Authentication> authentication = getAuthentication();
			return authentication.map(auth -> auth.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals(userRoleEnum.getCode()))).orElse(false);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}
	
	@Override
	public boolean hasRole(String userLoginName, UserRoleEnum userRoleEnum) throws ShowDogException {
		try {
			String roleCode = userRepository.findRoleCodeByLoginName(userLoginName).orElse(null);
			return roleCode != null && roleCode.equals(userRoleEnum.getCode());
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}
	
	@Override
	public boolean hasAnyRole(List<HelpdeskGrantedAuthority> authorities) throws ShowDogException {
		try {
			Optional<Authentication> authentication = getAuthentication();
			return authentication.map(auth -> auth.getAuthorities().stream().anyMatch(authorities::contains)).orElse(false);
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
	}
	
	@Override
	public boolean hasAnyRole(UserRoleEnum... userRoleEnums) throws ShowDogException {
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
			throw new HelpdeskInternalException(e);
		}
	}
	
	@Override
	public UserDetailsDto getUserDetails() throws ShowDogException {
		UserDetailsDto userDetailsDto = null;
		try {
			Principal principal = SecurityContextHolder.getContext().getAuthentication();
			UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken)principal;
			HelpdeskUserDetails userDetails = (HelpdeskUserDetails)authenticationToken.getDetails();
			userDetailsDto = toUserDetailsDto(userDetails);
			
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
		return userDetailsDto;
	}
	
	@Override
	public Optional<Authentication> getAuthentication() throws ShowDogException {
		Optional<Authentication> authentication = Optional.empty();
		try {
			authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
		return authentication;
	}
	
	@Override
	public String getPrincipal() throws ShowDogException{
		String username = null;
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			username = authentication.getPrincipal().toString();
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
		return username;
	}
	
	@Override
	public boolean isUserLoggedIn() {
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}
	
	
	
	@Override
	public User getUser() throws ShowDogException {
		User user = null;
		try {
			String loginName = getPrincipal();
			user = userRepository.findByLoginNameIgnoreCase(loginName);
		}catch(ShowDogException e) {
			throw e;
		}catch(Exception e) {
			throw new HelpdeskInternalException(e);
		}
		
		return user;
	}
	
	private UserDetailsDto toUserDetailsDto(HelpdeskUserDetails userDetails) {
		
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
