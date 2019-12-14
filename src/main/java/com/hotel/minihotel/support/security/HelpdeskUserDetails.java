package com.informatique.gov.helpdesk.support.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"username"})
@ToString(of = {"username", "englishName"})
public class HelpdeskUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817860817948767837L;
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private String firstName;
	private String lastName;
	private AuthenticationToken token;

}
