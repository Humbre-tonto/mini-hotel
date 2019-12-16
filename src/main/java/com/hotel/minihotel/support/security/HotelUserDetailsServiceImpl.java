package com.hotel.minihotel.support.security;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hotel.minihotel.domain.User;
import com.hotel.minihotel.exception.HotelInternalException;
import com.hotel.minihotel.service.InternalUserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HotelUserDetailsServiceImpl implements UserDetailsService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2167322879669809169L;
	private InternalUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		HotelUserDetails userDetails = null;
		User user = null;
		try {
			notNull(username, "username must be set");
			user = userService.getByLoginName(username);

			if (user == null) {
				throw new UsernameNotFoundException(username);
			}

			userDetails = toUserDetails(user);

		} catch (HotelInternalException e) {
			throw new UsernameNotFoundException(username, e);
		} catch (UsernameNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new UsernameNotFoundException(username, new HotelInternalException(e));
		}
		return userDetails;
	}

	private HotelUserDetails toUserDetails(User user) {

		notNull(user, "user must be set");

		HotelUserDetails userDetails = new HotelUserDetails();

		userDetails.setAuthorities(Arrays.asList(new HotelGrantedAuthority(user.getRole().getCode())));
		return userDetails;
	}
}
