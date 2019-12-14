package com.informatique.gov.helpdesk.support.security;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.informatique.gov.helpdesk.domain.User;
import com.informatique.gov.helpdesk.exception.HelpdeskInternalException;
import com.informatique.gov.helpdesk.service.InternalUserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HelpdeskUserDetailsServiceImpl implements UserDetailsService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167322879669809169L;
	private InternalUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		HelpdeskUserDetails userDetails = null;
		User user = null;
		try {
			notNull(username, "username must be set");
			user = userService.getByLoginName(username);

			if (user == null) {
				throw new UsernameNotFoundException(username);
			}

			userDetails = toUserDetails(user);

		} catch (HelpdeskInternalException e) {
			throw new UsernameNotFoundException(username, e);
		} catch (UsernameNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new UsernameNotFoundException(username, new HelpdeskInternalException(e));
		}
		return userDetails;
	}

	private HelpdeskUserDetails toUserDetails(User user) {

		notNull(user, "user must be set");

		HelpdeskUserDetails userDetails = new HelpdeskUserDetails();

		userDetails.setFirstName(user.getFirstName());
		userDetails.setAuthorities(Arrays.asList(new HelpdeskGrantedAuthority(user.getRole().getCode())));

		userDetails.setLastName(user.getLastName());
		userDetails.setUsername(user.getLoginName());
		userDetails.setPassword(user.getCredentials().getPassword());
		return userDetails;
	}
}
