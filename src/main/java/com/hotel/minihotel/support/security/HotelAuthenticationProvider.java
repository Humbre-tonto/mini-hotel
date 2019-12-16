package com.hotel.minihotel.support.security;

import java.io.Serializable;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HotelAuthenticationProvider implements AuthenticationProvider, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private final Logger logger = LoggerFactory.getLogger(HotelAuthenticationProvider.class);

	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		final boolean debug = logger.isDebugEnabled();
		
		if(debug) {
			logger.debug("Authentication : " + authentication.getPrincipal() + "...");
		}
		
		Object principal = authentication.getPrincipal();
		UserDetails userDetails = null;
		Collection<? extends GrantedAuthority> authorities = null;
		
		if(debug) {
			logger.debug("Loading user details from DB with input : " + principal.toString().trim());
		}

		userDetails = userDetailsService.loadUserByUsername(principal.toString().trim());
		
		
		if(debug) {
			logger.debug("User details loaded from DB : " + userDetails);
		}

		if (userDetails == null) {
			throw new UsernameNotFoundException(principal.toString());
		}
		if (userDetails != null) {

			String password = authentication.getCredentials().toString().trim();

			
			if(debug) {
				logger.debug("Matching provided credentials with the stored");
			}
			
			


			if (StringUtils.isEmpty(password) || StringUtils.isEmpty(userDetails.getPassword()) || !password.trim().equals(userDetails.getPassword().trim())) {
				logger.debug("Credentials matching fails...");
				return null;
			}
			authorities = userDetails.getAuthorities();

		}

		if (authorities == null) {
			if(debug) {
				logger.debug("User has no authorities...");
			}
			return null;
		}
	
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails.getUsername(), authentication.getCredentials(), authorities);
		usernamePasswordAuthenticationToken.setDetails(userDetails);

		if(debug) {
			logger.debug("User authenticated successfully");
		}
		
		return usernamePasswordAuthenticationToken;
	}

	@Override
	public boolean supports(Class<?> authenticationClazz) {
		return authenticationClazz.equals(UsernamePasswordAuthenticationToken.class);
	}
}
